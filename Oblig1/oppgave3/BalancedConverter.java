import java.util.ArrayList;

class BalancedConverter {

    ArrayList<Integer> sorted = new ArrayList<>();

    static ArrayList<Integer> balanced = new ArrayList<>();
    static int mid;

    public BalancedConverter(ArrayList<Integer> sorted) {

    }

    public ArrayList<Integer> convert() {
        int max = sorted.size()-1;
        int min = 0;
        mid = ((max + min) + 1)/2

        balanced.add(sorted[mid]);

        if (sorted.size == 2) {
            balanced = sorted;
        }
        if (max - mid <= 2 || mid - min <= 2) {
            //legg til indekser
        }
        checkHigh((mid+1), max);

        checkLow(mid-1, min);

        return balanced;
    }

    private void checkHigh(int curMid, int max) {
        if (curMid == max) {
            balanced.add(sorted[max]);
            return;
        }
        if (max - curMid < 2) {
            balanced.add(sorted[curMid]);
            balanced.add(sorted[max]);
            return;
        }
        if (max - curMid == 2) {
            balanced.add(sorted[curMid]);
            balanced.add(sorted[max]);
            balanced.add(sorted[max-1]);
            return;
        }
        int newMid = ((max + curMid) + 1)/2;
        balanced.add(newMid);

        checkHigh(newMid, max)
        checkHigh(curMid, mid)

        return;
    }

    private void checkLow(ing curMid, int min) {
        if (curMid == min) {
            balanced.add(sorted[min]);
            return;
        }
        if (min - curMid < 2) {
            balanced.add(sorted[curMid]);
            balanced.add(sorted[min]);
            return;
        }
        if (min - curMid == 2) {
            balanced.add(sorted[curMid]);
            balanced.add(sorted[min]);
            balanced.add(sorted[min+1]);
            return;
        }

        int newMid = ((curMid + min) - 1)/2;
        balanced.add(newMid);
        checkLow(newMid, min);
        checkHigh(curMid, mid);

        return;
    }

}
