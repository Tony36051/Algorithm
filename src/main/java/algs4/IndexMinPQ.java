package algs4;

public class IndexMinPQ<Key extends Comparable<Key>> {
    private int maxN; // maximum number of elements on PQ
    private int n; // number of elements on PQ
    private int[] pq;  // binary heap using 1-based indexing
    private int[] qp; // inverse of pq - qp[pq[i]]=i
    private Key[] keys; // key[i] = priority of i

    public IndexMinPQ(int maxN) {
        if (maxN < 0) throw new IllegalStateException();
        this.maxN = maxN;
        n = 0;
        keys = (Key[]) new Comparable[maxN + 1];
        pq = new int[maxN + 1];
        qp = new int[maxN + 1];
        for (int i = 0; i <= maxN; i++) {
            qp[i] = -1;
        }
    }

    public void insert(int i, Key key) {
        validateIndex(i);
        if (contains(i)) {
            throw new IllegalStateException("index is already in the priority quque");
        }
        n++;
        qp[i] = n;
        pq[n] = i;
        keys[i] = key;

    }

    private boolean less(int i, int j) {
        return keys[i].compareTo(keys[j]) < 0;
    }

    private void exch(int i, int j) {
        int t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }

    private void swim(int k) {
        while (k > 1 && !less(k / 2, k)) {
            exch(k, k / 2);
            k /= 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(j + 1, j)) j++;
            if (less(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public boolean contains(int i) {
        validateIndex(i);
        return qp[i] != -1;
    }

    public int size() {
        return n;
    }


    private void validateIndex(int i) {
        if (i < 0) throw new IllegalArgumentException("index is negative: " + i);
        if (i >= maxN) throw new IllegalArgumentException("index >= capacity: " + i);
    }
}
