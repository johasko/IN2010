import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.*;

class TaskManager {

    static int longestPath = 0;

    public static void main(String[] args) throws IOException {
        String filename = args[0];
        Scanner in = new Scanner(new File(filename));

        int n = in.nextInt();
        Task[] tasks = new Task[n];

        for (int i = 0; i < n; i++) {
            tasks[i] = new Task(i + 1);
        }

        for (int i = 0; i < n; i++) {
            int id = in.nextInt();
            Task task = tasks[id - 1];
            task.name = in.next();
            task.time = in.nextInt();
            task.staff = in.nextInt();

            while (true) {
                int dep = in.nextInt();
                if (dep == 0) {
                    break;
                }
                task.addInEdge(tasks[dep - 1]);
                tasks[dep - 1].addOutEdge(task);
                tasks[id - 1].cntPredecessors++;
            }
        }

        Task[] sykel = realizable(tasks);

        if (sykel == null) {
            System.out.println("Grafen har en sykel");
        } else {
            earlyStart(sykel);
            lateStart(sykel);

            System.out.println("------- Printing all tasks -------");
            for (Task t : sykel) {
                taskPrint(t);
            }
            runProject(sykel);

        }
    }

    public static Task[] realizable(Task[] g) { //Topologisk sortering
        Stack<Task> s = new Stack<>();
        Task[] output = new Task[g.length];

        for (Task t : g) {
            if (t.cntPredecessors == 0) {
                s.push(t);
            }
        }
        int i =1;
        while (!s.empty()) {
            Task v = s.pop();
            output[i-1] = v;
            i++;
            for (Task e : g) {
                if (e.inEdges.contains(v)) {
                    e.cntPredecessors--;
                    if (e.cntPredecessors == 0) {
                        s.push(e);
                    }
                }
            }
        }
        if (i > g.length) {
            return output;
        }
        return null;
    }

    public static void earlyStart(Task[] task) {

        for (Task v : task) {
            if (v.inEdges.size() > 0) {
                v.earliestStart = Integer.MAX_VALUE;
            }
            else {
                v.earliestStart = 0;
            }

        }

        for (Task node : task) {
            int curTime = 0;
            for (Task edge : node.inEdges) {
                if (curTime < edge.earliestStart + edge.time) {
                    curTime = edge.earliestStart + edge.time;
                }
            }
            node.earliestStart = curTime;
            if (node.earliestStart + node.time > longestPath) {
                longestPath = node.earliestStart + node.time;
            }
        }
    }

    public static void lateStart(Task[] task) {
        for (Task node : task) {
            node.latestStart = node.earliestStart;

            int curTime = Integer.MAX_VALUE;
            for (Task edge : node.outEdges) {
                if (curTime > edge.earliestStart - node.time) {
                    curTime = edge.earliestStart - node.time;
                }
            }
            if (node.outEdges.size() == 0) {
                node.latestStart = longestPath - node.time;
            }
            else {
                node.latestStart = curTime;
            }
        }
    }

    public static void taskPrint(Task t) {
        System.out.println("ID: " + t.id);
        System.out.println("Name: " + t.name);
        System.out.println("Time: " + t.time);
        System.out.println("Staff required: " + t.staff);
        System.out.println("Earliest starttime: " + t.earliestStart);
        System.out.println("Slack: " + (t.latestStart - t.earliestStart));
        if (t.outEdges.size() != 0) {
            System.out.println("Tasks who depend on this task:\n");
            for (Task oe : t.outEdges) {
                System.out.println("          Id: "  + oe.id + ", "+ oe.name);
            }
        }
        System.out.println("-------------------------------------------");
    }

    public static void runProject(Task[] tasks) {
        System.out.println("\n------- Printing runtime simulation -------\n");

        int currentStaff = 0;

        for (int i = 0; i <= longestPath; i++) {
            boolean check = false;
            for (Task t : tasks) {
                if (t.earliestStart == i) {
                    if (!check) {
                        System.out.println("Current time : " + i);
                        check = true;
                    }
                    System.out.println("                    Starting: " + t.name);
                    currentStaff += t.staff;
                }
                else if(t.earliestStart + t.time == i) {
                    if (!check) {
                        System.out.println("Current time : " + i);
                        check = true;
                    }
                    System.out.println("                    Finished: " + t.name);
                    currentStaff -= t.staff;
                }
            }
            if (check) {
                System.out.println("                    Current staff: " + currentStaff  + "\n");
            }
        }
        System.out.println("------- Shortest completion time: " + longestPath + " -------");
    }
}
