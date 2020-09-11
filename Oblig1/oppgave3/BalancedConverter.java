import java.util.ArrayList;

class BalancedConverter {

    ArrayList<Integer> sorted = new ArrayList<>();

    static ArrayList<Integer> balanced = new ArrayList<>();
    static int mid;

    public BalancedConverter(ArrayList<Integer> sorted) {
        this.sorted = sorted;
    }

    public ArrayList<Integer> convert() {
        int max = sorted.size()-1;
        int min = 0;
        mid = ((max + min) + 1)/2;

        balanced.add(sorted.get(mid));

        if (sorted.size() == 2) {
            balanced = sorted;
        }
        if (sorted.size()<= 5) {
            //legg til indekser
        }
        checkHigh((mid+1), max);

        checkLow(mid-1, min);

        return balanced;
    }

    private void checkHigh(int curMid, int max) {
        if (curMid == max) {
            balanced.add(sorted.get(max));
            return;
        }
        if (max - curMid < 2) {
            balanced.add(sorted.get(curMid));
            balanced.add(sorted.get(max));
            return;
        }
        if (max - curMid == 2) {
            balanced.add(sorted.get(curMid));
            balanced.add(sorted.get(max));
            balanced.add(sorted.get(max-1));
            return;
        }
        int newMid = ((max + curMid) + 1)/2;
        balanced.add(newMid);

        checkHigh(newMid, max);
        checkLow(curMid, mid);

        return;
    }

    private void checkLow(int curMid, int min) {
        if (curMid == min) {
            balanced.add(sorted.get(min));
            return;
        }
        if (min - curMid < 2) {
            balanced.add(sorted.get(curMid));
            balanced.add(sorted.get(min));
            return;
        }
        if (min - curMid == 2) {
            balanced.add(sorted.get(curMid));
            balanced.add(sorted.get(min));
            balanced.add(sorted.get(min+1));
            return;
        }

        int newMid = ((curMid + min) - 1)/2;
        balanced.add(newMid);
        checkLow(newMid, min);
        checkHigh(curMid, mid);

        return;
    }

}
