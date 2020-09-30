import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

class TaskManager {

    public static void main(String[] args) throws IOException {
        int tasks;
        ArrayList<Task> allTasks = new ArrayList<Task>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        tasks = Integer.parseInt(br.readLine());

        for (String line = br.readLine(); line != null; line = br.readLine()) {
            if (line.length() > 0) {
                String[] bits = line.split("\\s+");

                int id = Integer.parseInt(bits[0]);
                String name = bits[1];
                int time = Integer.parseInt(bits[2]);
                int staff = Integer.parseInt(bits[3]);
                int[] ed = new int[bits.length-3];
                for (int i = 3; i < bits.length; i++) {
                    int n = Integer.parseInt(bits[i]);
                    ed[i-3] = n;
                }

                Task task = new Task(id, name, time, staff, ed);
                allTasks.add(task);
            }
        }

        //Test print
        for (Task t : allTasks) {
            System.out.println(t);
        }
    }
}
