import java.util.*;

class Task {
    int id, time, staff;
    String name;
    int earliestStart, latestStart;
    ArrayList<Task> outEdges = new ArrayList<>();
    ArrayList<Task> inEdges = new ArrayList<>();
    int cntPredecessors;
    boolean status = false;

    public Task(int id) {
        this.id = id;
    }

    public void addOutEdge(Task t) {
        outEdges.add(t);
    }
    public void addInEdge(Task t) {
        inEdges.add(t);
    }
}
