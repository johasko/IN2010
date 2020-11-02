class Quick extends Sorter {

    void sort() {

        int high = A.length-1;
        int low = 0;
        quickSort(low, high);
    }

    void quickSort(int low, int high) {
        if (low >= high) {
            return;
        }
        int p = part(low, high);
        quickSort(low, p-1);
        quickSort(p+1, high);
    }

    int part(int low, int high) {
        int p = (int)(Math.random() * (high - low + 1) + low);
        swap(p, high);

        int pivot = A[high];
        int left = low;
        int right = high-1;

        while(left <= right) {
            while(left <= right && leq(A[left], pivot)) {
                left++;
            }
            while (right >= left && geq(A[right], pivot)) {
                right--;
            }
            if (left < right) {
                swap(left, right);
            }
        }
        swap(left, high);
        return left;
    }


    String algorithmName() {
        return "quick";
    }
}
