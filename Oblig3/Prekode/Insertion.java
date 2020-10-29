class Insertion extends Sorter {

    void sort() {

        // Do insertion sort here. Use the Sorter's comparison- and swap
        // methods for automatically counting the swaps and comparisons.
        //
        // The object has a field A and n, where A is to be sorted and n is its
        // length.
        //
        // Alternatively, you can "manually" increment the fields `comparisons'
        // and `swaps' at your own leisure.
        for (int i = 1; i < n-1; i++) {
            int j = i;
            while (j > 0 && gt(A[j-1], A[j])) {
                swap(j-1, j);
                j--;
            }
        }
    }

    String algorithmName() {
        return "insertion";
    }
}
