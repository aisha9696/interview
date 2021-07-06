package kz.algorithm.data_structure.sort;

//import edu.princeton.cs.algs4.Shell;
/**
 * Сортировка Шелла 1995
 * Похож на сортировку вставкой (InsertionSort)
 * но меняем элементы по зазору (gap size)
 * в конечном итоге оно переходит InsertionSort где размер зазора равен 1
 * временная сложность зависит от зазора для текущего  3 * h + 1 размер равен O(n^(3/2))
 * **/
public class ShellSort extends ComparableClass {
    public static void sort(Comparable[] a) {
        int N = a.length;
        int h = 1; //gap size
        /**
         * определяем размер зазора
         * */
        while (h < N / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) { // пока не дойдем до размера
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) { // меняем элементы по рахмеру зазора
                    exch(a, j, j - h);
                }
            }
            h = h / 3; /// уменьшаем размер зазора при каждой итерации
        }
    }

    public static void main(String[] args) {
        ShellSort ss = new ShellSort();
        Comparable<Character>[] a = new Comparable[]{'s', 'h', 'e', 'l', 'l', 's', 'o', 'r', 't'};
        System.out.println(ss.isSorted(a));
        ss.sort(a);
        System.out.println(ss.isSorted(a));
    }
}
