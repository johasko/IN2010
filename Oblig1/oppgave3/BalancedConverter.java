import java.util.ArrayList;

class BalancedConverter {

    ArrayList<Integer> sorted = new ArrayList<>();

    static ArrayList<Integer> balanced = new ArrayList<>();

    public BalancedConverter(ArrayList<Integer> sorted) {

    }

    public ArrayList<Integer> convert() {
        int max = sorted.size()-1;
        int min = 0;
        int mid = ((max + min) + 1)/2

        balanced.add(mid);

        if (sorted.size == 2) {
            balanced = sorted;
        }

        if (max - mid <= 2 || mid - min <= 2) {
            //legg til indekser
        }

        checkHigh(mid, max);

        checkLow(mid, min);

        return balanced;




    }

    private void checkHigh(int curMid, int max) {

    }

    private void checkLow(ing curMid, int min) {

    }

}
