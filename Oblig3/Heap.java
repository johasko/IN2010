class Heap extends Sorter {

    void sort() {
        //buildMaxHeap
        for (int i = n/2; i >= 0; i--) {
            bubbleDown(i, n);
        }
        for (int i = n-1; i >= 0; i--) {
            swap(0, i);
            bubbleDown(0,i);
        }
    }


    void bubbleDown(int i, int n) {
        int largest = i;
        int left = 2*i+1;
        int right = 2*i+2;

        if (left < n && lt(A[largest], A[left])) {
            int temp = largest;
            largest = left;
            left = temp;
        }

        if (right < n && lt(A[largest], A[right])) {
            int temp = largest;
            largest = right;
            right = temp;
        }

        if (i != largest) {
            swap(i, largest);
            bubbleDown(largest, n);
        }
    }

    String algorithmName() {
        return "heap";
    }
}
