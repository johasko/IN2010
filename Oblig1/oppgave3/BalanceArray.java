import java.util.ArrayList;

class BalanceArray {

    public static void main(String[] args) {
        ArrayList<Integer> sorted = new ArrayList<>();
        ArrayList<Integer> balanced;

        balanced = new BalancedConverter().convert(sorted);
        for (int i : sorted) {
            System.out.println(i);
        }
    }
}
