import java.util.ArrayList;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class BalanceArray {

    public static void main(String[] args) throws IOException {

        ArrayList<Integer> sorted = new ArrayList<>();
        sorted.add(0);
        sorted.add(2);
        sorted.add(4);
        sorted.add(8);
        sorted.add(10);

        /*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (String line = br.readLine(); line != null; line = br.readLine()) {
            sorted.add(Integer.parseInt(line));
        }*/

        new BalancedConverter().convert(sorted, 0, sorted.size()-1);
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
