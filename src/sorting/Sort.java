package sorting;

/**
 * Created by chace on 5/18/14.
 */
public class Sort {

    private void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    public void quickSort(int[] A) {
        if (A == null || A.length <= 1) {
            return;
        }
        quickSort(A, 0, A.length-1);
    }

    public void quickSort(int[] A, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int p = partition(A, lo, hi);
        quickSort(A, lo, p-1);
        quickSort(A, p+1, hi);
    }

    private int partition(int[] A, int lo, int hi) {
        int i = lo, j = hi + 1;
        int p = A[i];
        while (true) {
            while (A[++i] < p) {
                if (i >= hi) {
                    break;
                }
            }
            while (A[--j] > p) {
                if (j <= lo) {
                    break;
                }
            }
            if (i == j) break;
            swap(A, i, j);
        }
        swap(A, lo, j);
        return j;
    }

    ////////////////////////////////////////////////////////

    public void insertSort(int[] A) {
        if (A == null || A.length <= 1) {
            return;
        }
        for (int i = 1; i < A.length; i++) {
            for (int j = i; j > 0; j--) {
                if (A[j] < A[j-1]) {
                    swap(A, j, j-1);
                }
            }
        }
    }

    ////////////////////////////////////////////////////////

    public void bubbleSort(int[] A) {
        if (A == null || A.length <= 1) {
            return;
        }

        for (int i = A.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (A[j] > A[i]) {
                    swap(A, i, j);
                }
            }
        }
    }

    ////////////////////////////////////////////////////////

    public void mergeSort(int[] A) {
        if (A == null || A.length <= 1) {
            return;
        }
        mergeSort(A, 0, A.length - 1);
    }

    public void mergeSort(int[] A, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int mid = (lo + hi) / 2;
        mergeSort(A, lo, mid);
        mergeSort(A, mid+1, hi);
        merge(A, lo, mid, hi);
    }

    public void merge(int[] A, int lo, int mid, int hi) {
        int i = lo, j = mid+1;
        int[] aux = new int[hi];
        for (int k = lo; k <= hi; k++) {
            aux[k] = A[k];
        }
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                A[k] = aux[j++];
            } else if (j > hi) {
                A[k] = aux[i++];
            } else if (A[i] > A[j]) {
                A[k] = A[j++];
            } else {
                A[k] = A[i++];
            }
        }
    }

    ////////////////////////////////////////////////////////
}
