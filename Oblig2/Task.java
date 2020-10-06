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

    public int earlyStart(int i) {
        if(outEdges.size()==0) {
            return 0;
        }
        for (Task v : outEdges) {
            if (v.time > i) {
                i += v.earlyStart(i);
            } else {
                return i;
            }
        }
    }
}
