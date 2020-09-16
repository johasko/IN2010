import java.util.ArrayList;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class BalanceHeap {

    public static void main(String[] args) throws IOException {

        PriorityQueue pq = new PriorityQueue<Integer>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (String line = br.readLine(); line != null; line = br.readLine()) {
            pq.offer(Integer.parseInt(line));
        }

        int s = pq.size();
        for (int i = 0; i < s; i++) {
            System.out.println(pq.poll());
        }
    }
}


class BalancedConverter {

    public void convert(ArrayList<Integer> arr, int first, int last) {

        if (first > last) {
            return;
        }

        int mid = (first+last)/2;
        System.out.println(arr.get(mid));

        convert(arr, mid + 1, last);
        convert(arr, first, mid - 1);

        return;
    }
}
