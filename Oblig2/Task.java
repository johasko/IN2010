import java.util.*;

class Task {
    int id, time, staff;
    String name;
    int earliestStart, latestStart;
    ArrayList<Task> outEdges = new ArrayList<>();
    int cntPredecessors;
    boolean status = false;

    public Task(int id) {
        this.id = id;
    }

    public String toString() {
        return "Id: " + id + "\nName: " + name + "\nTime requirement: " + time + "\nStaff requirement: " + staff + "\nOutEdges: " + cntPredecessors + "\n";
    }

    public void addEdge(Task t) {
        outEdges.add(t);
    }

    public int earlyStart(Task[] tasks) { //Dette er Dijktras algoritme
        PriorityQueue<Task> pq = new PriorityQueue<>();

        for (Task t : tasks) {
            t.earliestStart = Integer.MAX_VALUE;
            pq.add(t);
        }
        tasks[0].earliestStart = 0;

        while (pq.size() < 0) {
            Task v = pr.poll();
        }
    }
}
