import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class BalanceHeap {

    public static void main(String[] args) throws IOException {

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (String line = br.readLine(); line != null; line = br.readLine()) {
            pq.offer(Integer.parseInt(line));
        }

        new HeapConverter().convert(pq);
    }
}


class HeapConverter {

    public void convert(PriorityQueue pq) {

        PriorityQueue<Integer> lpq = new PriorityQueue<Integer>(); //Lave enden av lista
        PriorityQueue<Integer> hpq; // Hoye enden av lista

        int l = pq.size();
        for (int i = 0; i < l/2; i++) {
            int t = (Integer)pq.poll();
            lpq.offer(t);
        }

        hpq = pq;

        if (hpq.size() > 0 || lpq.size() > 0) {
            System.out.println(hpq.poll());

            convert(hpq);
            convert(lpq);
        }
        else if (hpq.size() == 2 || lpq.size() == 2) {
            System.out.println(hpq.poll());
            System.out.println(hpq.poll());

            return;
        }
        return;
    }
}
