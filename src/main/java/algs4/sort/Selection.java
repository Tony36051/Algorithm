package algs4.sort;

import static algs4.sort.SortBase.*;

public class Selection {

    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int minIndex = i;
            for (int j = i; j < N; j++) {
                if (less(a[j], a[minIndex])) {
                    minIndex = j;
                }
            }
            exch(a, i, minIndex);
        }
    }

    public static void main(String[] args) {
        Integer[] a = new Integer[]{1,3,5,6,4,2};
        Selection.sort(a);
        assert isSorted(a);
        show(a);
    }
}
