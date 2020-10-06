import java.io.File;
import java.io.IOException;
import java.util.Scanner;

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

        for (Task t : tasks) {
            System.out.println(t);
        }
    }

    public boolean DFS(Task[] a, Task t) { 
        t.status = true;
        for (Task v : t.outEdges) {
            if (v.status == false) {
                DFS(a, v); 
            }
        }
    }

    public boolean DFS_full(Task[] a) {
        for (Task v : a) {
            if (v.status == false) {
                DFS(a, v);
            }
        }
    }
}
