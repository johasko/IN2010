import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class TaskManager {

    public static void main(String[] args) throws IOException {
        int tasks;
        ArrayList<Task> allTasks = new ArrayList<>();


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        tasks = Integer.parseInt(br.readLine());

        for (String line = br.readLine(); line != null; line = br.readLine()) {
            if (line.length() > 0) {
                String[] bits = line.split("\\s+");

                int id = Integer.parseInt(bits[0]);
                String name = bits[1];
                int time = Integer.parseInt(bits[2]);
                int staff = Integer.parseInt(bits[3]);

                int[] ed = new int[bits.length-4];
                for (int i = 4; i < bits.length; i++) {
                    int n = Integer.parseInt(bits[i]);
                    ed[i-4] = n;
                }

                Task task = new Task(id, name, time, staff, ed);
                allTasks.add(task);
            }
        }

        //Print all tasks
        /*for (Task t : allTasks) {
            System.out.println(t);
        }*/

        runTasks(allTasks);
    }

    public static void runTasks(ArrayList<Task> tasks) {

        ArrayList<Task> queue = new ArrayList<>();
        int o = 0;
        for (Task t : tasks) {
            if (t.cntPredecessors == 1) {
                t.status = true;
                System.out.println("Starting: " + t.name);
                //Print kjøretid + annen info
            }

            for (int i : t.outEdges) {
                if (tasks.get(i).status == false) {
                    queue.add(t);
                    break;
                }
            }
            o++;
        }

        if (tasks.size() > 0) {
            runTasks(queue);
        }
    }
}
