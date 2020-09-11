import java.util.ArrayList;

class BalanceArray {

    public static void main(String[] args) {
        ArrayList<Integer> sorted = new ArrayList<>();
        ArrayList<Integer> balanced = new ArrayList<>();

        for (int i = 0; i <= 20; i++) {
            sorted.add(i);
        }

        balanced = new BalancedConverter(sorted).convert();
        for (int i : sorted) {
            System.out.println(i);
        }
    }
}
