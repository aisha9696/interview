package kz.algorithm.algorithm;


import java.util.Arrays;
import java.util.List;

public class StrString {

    /**
     * Поиск подстроки в строке
     * Релизовать можно двумя способами:
     * 1) Бруте Форс O(m*n)
     * 2) Кнут Моррис Прат O(m*n)
     * */


    /**
     * Brute Force algorithm
     */
    public static int searchBF(String haystack, String needle) {
        if(needle.isEmpty()) return 0;
        if(needle.length()>haystack.length()) return -1;


        for(int i = 0; i < haystack.length(); i++) {
            int j = 0;
            for(;j < needle.length(); j++) {
                if(haystack.charAt(i+j) != needle.charAt(j)) break;
            }
            if(j == needle.length()) return i;
        }
        return -1;
    }

    /**
     * Knuth Morris Pratt algorithm
     * 1 шаг: создать префиксную функцию (это pi(i) обозначает длину максимального префикса строки собрадающая суффиксом)
     * пусть needle - a array, j=0, i=1;
     * - если ai != aj тогда
     * ----- если j =0 то pi[i] =0; i++;
     * - иначе(т.е. j!=0 ) то j = pi[j-1]
     * <p>
     * - иначе (т.е. ai == aj) pi[i] =j+1; i++; j++;
     * 2 шаг: Поиск образа в строке
     * пусть heystack - t array, needle - a array, k=0, l=0
     * - если tk == al тогда
     * ----------------k++; l++;
     * -------- если l==n, то образ найден
     * <p>
     * - иначе (т.е. tk != al)
     * -------- если l == 0, тогда k++;
     * ------------- если k == n то образ в строке нет
     * -------- иначе (т.е. l != 0) l = pi[l-1];
     */






    public static int[] createPrefix(char a[], int lengthA) {
        int pi[] = new int[lengthA];
        int j = 0;
        int i = 1;

        while (i < lengthA) {
            if (a[i] == a[j]) {
                pi[i] = j + 1;
                i++;
                j++;
            } else {
                if (j == 0) {
                    pi[i] = 0;
                    i++;
                } else {
                    j = pi[j - 1];
                }
            }
        }
        return pi;
    }

    public static int searchKMP(String heystack, String needle) {
        int N = needle.length();
        int M = heystack.length();
        if (N > M) return -1;
        if (M < 0 || N < 0) return 0;
        char[] t = heystack.toCharArray();
        char[] a = needle.toCharArray();

        int[] prefixF = createPrefix(a, N);
        int k = 0, l = 0;
        while (k < M) {
            if (t[k] == a[l]) {
                k++;
                l++;
                if (l == N) {
                    return k - l;
                }
            } else {
                if (l == 0) {
                    k++;
                    if (k == M) {
                        return -1;
                    }
                } else {
                    l = prefixF[l - 1];
                }
            }
        }

        return 0;

    }


    public static void main(String[] args) {
        String heystack = "abcbeabcabcabd";
        String needle = "abcabd";
        char[] a = needle.toCharArray();
        System.out.println(searchKMP(heystack, needle));
        System.out.println(searchBF(heystack, needle));

        StringBuffer builder = new StringBuffer();
        
        System.out.println("asd"+builder.toString()+"asd");
    }
}
