package kz.algorithm.data_structure.sort;


/**
 * Сортировка слиянием
 * цель разделить массив, отсортировать рекурсивно и обьеденить
 * <p>
 * Выч.сложность O(N*log(N))
 */
public class MergeSort extends ComparableClass {
    /**
     * вместо swap используем конструкцию для мерджинга
     * обьеденяем
     */
    private static void merge(Comparable a[], Comparable aux[], int L, int mid, int R) {
        int i = L;
        int j = mid + 1;
        for (int k = L; k <= R; k++) {
            aux[k] = a[k];
        }
        for (int k = L; k <= R; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > R) {
                a[k] = aux[i++];
            } else if (less(aux[j], aux[i])) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }

    }

    private static void sort(Comparable a[], Comparable aux[], int L, int R) {
        if (L >= R) return;
        int mid = L + (R - L) / 2; // найти средний элемент
        sort(a, aux, L, mid);
        sort(a, aux, mid + 1, R);
        if (!less(a[mid + 1], a[mid])) return; //проверка если правая часть больше левой
        merge(a, aux, L, mid, R);
    }

    private static void sort(Comparable a[]) {
        if (a.length < 0) return;
        Comparable aux[] = new Comparable[a.length];
        int mid = a.length / 2;
        sort(a, aux, 0, a.length - 1);
    }

    private static void bottomUpSort(Comparable a[]) {
        if (a.length < 0) return;
        int N = a.length;
        Comparable[] aux = new Comparable[N];
        for (int sz = 1; sz < N; sz = sz + sz) {
            for (int lo =0; lo<N-sz; lo+=sz+sz) {
                merge(a,aux,lo,lo+sz-1, Math.min(lo+sz+sz-1,N-1));
            }

        }
    }

    public static void main(String[] args) {
        MergeSort ss = new MergeSort();
        Comparable<Character>[] a = new Comparable[]{'m', 'e', 'r', 'g', 'e', 's', 'o', 'r', 't', 'e', 'x', 'a', 'm', 'p', 'l', 'e'};
        System.out.println(ss.isSorted(a));
        ss.sort(a);
        System.out.println(ss.isSorted(a));
        Shuffling shuffling = new Shuffling();
        shuffling.shuffle (a);
        System.out.println(ss.isSorted(a));
        ss.bottomUpSort(a);
        System.out.println(ss.isSorted(a));
    }

}
