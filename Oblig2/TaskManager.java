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
                tasks[dep - 1].addEdge(task);
                tasks[id - 1].cntPredecessors++;
            }
        }

        Task[] sykel = realizable(tasks);
        if (sykel == null) {
            System.out.println("Grafen er en sykel");
        } else {
            for (Task t : sykel) {
                System.out.println(t.name);
            }
        }

        System.out.println();
        /*for (Task t : tasks) {
            System.out.println(t);
        }*/
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
            for (Task e : v.outEdges) {
                e.cntPredecessors--;
                if (e.cntPredecessors == 0) {
                    s.push(e);
                }
            }
        }
        if (i > g.length) {
            return output;
        }
        return null;
    }

    public static int earlyStart(Task t) {

        for (Task v : t.outEdges) {
            return v.time;
        }
    }
}
