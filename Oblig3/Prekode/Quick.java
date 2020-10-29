class Quick extends Sorter {

    void sort() {

        int high = A.length-1;
        int low = 0;

        // Do insertion sort here. Use the Sorter's comparison- and swap
        // methods for automatically counting the swaps and comparisons.
        //
        // The object has a field A and n, where A is to be sorted and n is its
        // length.
        //
        // Alternatively, you can "manually" increment the fields `comparisons'
        // and `swaps' at your own leisure.

        quickSort(low, high);


    }

    int[] quickSort(int low, int high) {
        if (low >= high) {
            return A;
        }
        int p = part(low, high);
        quickSort(low, p-1);
        quickSort(p+1, high);
        return A;
    }

    int part(int low, int high) {
        /*int p = (int)(Math.random() * (high - low + 1) + low);
        swap(p, high);

        int pivot = A[high];
        int left = low;
        int right = high-1;

        while(left <= right) {
            while(left <= right && leq(A[left], pivot)) {
                left++;
                System.out.println("Left = " + left);
            }

            while (right >= left && geq(A[right], pivot)) {
                right++;
                System.out.println("Right = " + right);
            }

            if (left < right) {
                swap(left, right);
            }
        }
        swap(left, high);
        return left;*/

        int pivot = A[A.length-1];
        int i = (low-1);

        for (int j = low; j < high; j++) {
            if (A[j] <= pivot) {
                i++;

                int swapTemp = A[i];
                A[i] = A[j];
                A[j] = swapTemp;
            }
        }

        int swapTemp = A[i+1];
        A[i+1] = A[A.length-1];
        A[A.length-1] = swapTemp;

        return i+1;
    }


    String algorithmName() {
        return "quick";
    }
}
