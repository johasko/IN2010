import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.*;

class TaskManager {

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
                task.addEdge(tasks[dep - 1]);
                tasks[id - 1].cntPredecessors++;
            }
        }

        Task[] sykel = realizable(tasks);
        earlyStart(sykel);
        lateStart(sykel);
        //slack(sykel);
        if (sykel == null) {
            System.out.println("Grafen har en sykel");
        } else {
            for (Task t : sykel) {
                testPrint(t);
            }

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
                if (e.outEdges.contains(v)) {
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
            if (v.outEdges.size() > 0) {
                v.earliestStart = Integer.MAX_VALUE;
            }
            else {
                v.earliestStart = 0;
            }

        }

        for (Task node : task) {
            int curTime = 0;
            for (Task edge : node.outEdges) {
                if (curTime < edge.earliestStart + edge.time) {
                    curTime = edge.earliestStart + edge.time;
                }
            }
            node.earliestStart = curTime;
        }
    }

    public static void lateStart(Task[] task) {

        for (Task t : task) {
            t.latestStart = t.earliestStart;
        }

        for (Task node : task) {
            int curTime = 0;
            for (Task edge : node.outEdges) {
                if (node.earliestStart > edge.earliestStart + edge.time) {
                    edge.latestStart = edge.earliestStart + (node.earliestStart-
                                                            (edge.earliestStart + edge.time));
                }
            }
        }
    }

    public static void testPrint(Task t) {
        System.out.println("ID: " + t.id);
        System.out.println("Tid: " + t.time);
        System.out.println("Tidligste start: " + t.earliestStart);
        System.out.println("Tidligst fullført: " + (t.earliestStart+t.time));
        System.out.println("Seneste start: " + t.latestStart);
        System.out.println("Senest fullført: " + (t.latestStart+t.time));
        System.out.println("Slack: " + (t.latestStart - t.earliestStart));
        System.out.println("Kritisk task? " + (t.latestStart - t.earliestStart == 0));
        System.out.println("#################################");
    }
}
