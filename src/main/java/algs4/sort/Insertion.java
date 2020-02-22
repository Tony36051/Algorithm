package algs4.sort;

import static algs4.sort.SortBase.*;

public class Insertion {
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
        }
    }

    public static void sortX(Comparable[] a) {
        int N = a.length;
        boolean changed = false;
        for (int i = N - 1; i > 0; i--) {
            if (less(a[i], a[i - 1])) {
                exch(a, i, i - 1);
                changed = true;
            }
        }
        if (!changed) return;
        for (int i = 1; i < N; i++) {
            Comparable t = a[i];
            int j = i;
            while (less(t, a[j - 1])) {
                a[j] = a[j - 1];
                j--;
            }
            a[j] = t;
        }
    }

    public static void main(String[] args) {
        Integer[] a = new Integer[]{1, 3, 5, 6, 4, 2};
        Insertion.sortX(a);
        assert isSorted(a);
        show(a);
    }
}
