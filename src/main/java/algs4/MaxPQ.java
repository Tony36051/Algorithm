package algs4;

public class MaxPQ<Key extends Comparable<Key>> {
    public MaxPQ() {
        pq = (Key[]) new Comparable[1];
    }

    public MaxPQ(int max) {
        pq = (Key[]) new Comparable[max+1];
    }

    public MaxPQ(Key[] a) {
        pq = a;
        N = pq.length + 1;
        for (int i = N / 2; i > 0; i--) {
            sink(i);
        }
    }

    public void insert(Key v) {
        pq[++N] = v;
        swim(N);
    }

    public Key max() {
        if(isEmpty()) return null;
        return pq[1];
    }
    public Key delMax(){
        Key t = pq[1];
        exch(1, N--);
        pq[N+1] = null;
        sink(1);
        return t;
    }
    public boolean isEmpty() {
        return N==0;
    }

    public int size() {
        return N;
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j])<0;
    }

    private void exch(int i, int j) {
        Key t= pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k = k/2;
        }
    }

    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2*k;
            if(j<N && less(j, j+1)) j++;
            if(!less(k,j))break;
            exch(k,j);
            k = j;
        }
    }

    private Key[] pq;
    private int N=0;

    public static void main(String[] args) {
        MaxPQ maxPQ = new MaxPQ<Character>(9);
        maxPQ.insert('P');
        maxPQ.insert('Q');
        maxPQ.insert('E');
        System.out.println(maxPQ.delMax());;
        maxPQ.insert('X');
        maxPQ.insert('A');
        maxPQ.insert('M');
        System.out.println(maxPQ.delMax());;
        maxPQ.insert('P');
        maxPQ.insert('L');
        maxPQ.insert('E');
        System.out.println(maxPQ.delMax());;
        System.out.println();
    }

}
