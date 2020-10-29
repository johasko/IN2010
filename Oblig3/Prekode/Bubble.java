class Bubble extends Sorter {

    void sort() {

        for (int i = 0; i < n-1; i++) {
            int count = 0;
            for (int j = 0; j < n-i-1; j++) {
                if (A[j] > A[j+1]) {
                    swap(j, j+1);
                    count++;
                }
            }
        }
    }

    String algorithmName() {
        return "bubble";
    }
}
