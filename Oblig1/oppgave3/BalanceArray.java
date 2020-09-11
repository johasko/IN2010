import java.util.ArrayList;

class BalanceArray {

    public static void main(String[] args) {
        ArrayList<Integer> sorted = new ArrayList<>();
        ArrayList<Integer> balanced = new ArrayList<>();

        for (int i = 0; i <= 10; i++) {
            sorted.add(i);
        }

        balanced = new BalancedConverter(sorted).convert();
        for (int i : balanced) {
            System.out.println(i);
        }
    }
}
