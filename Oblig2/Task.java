import java.util.*;

class Task {
    int id, time, staff;
    String name;
    int earliestStart, latestStart;
    int[] outEdges;
    int cntPredecessors;
    boolean status = false;

    public Task(int id, String n, int t, int s, int[] ed) {
        this.id = id;
        name = n;
        time = t;
        staff = s;
        outEdges = ed;
        cntPredecessors = ed.length;
    }

    public String toString() {
        return "Id: " + id + "\nName: " + name + "\nTime requirement: " + time + "\nStaff requirement: " + staff + "\nOutEdges: " + arrayToString(outEdges) + "\n";
    }

    public String arrayToString(int[] array) {
        String s = "";
        for (int e : array) {
            if (s.length() == 0) {
                s += e;
            }
            else {
                s += (", " + e);
            }

        }
        return s;
    }
}
