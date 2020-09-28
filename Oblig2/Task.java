class Task {
    int id, time, staff;
    String name;
    int earliestStart, latestStart;
    int[] outEdges;
    int cntPredecessors;

    public Task(int id, int t, int s, String n, int[] ed) {
        this.id = id;
        time = t;
        staff = s;
        name = n;
        outEdges = ed;
    }
}
