package kz.algorithm.algorithm;

import edu.princeton.cs.algs4.ST;

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
    public static int search(String heystack, String needle) {
        int N = needle.length();
        int M = heystack.length();
        if (N > M) return -1;
        if (M < 0 || N < 0) return 0;
        for (int i = 0; i <= N; i++) {
            int j = 0;
            for (j = 0; j < M; j++) {
                if (heystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            if (j == M) return i;
        }
        return -1;
    }

    /**
     * Knuth Morris Pratt algorithm
     * 1 шаг: создать префиксную функцию (это pi(i) обозначает длину максимального префикса строки собрадающая суффиксом)
     * пусть needle - a array
     * - если ai != aj тогда
     * - если j =0 то pi[i] =0; i++;
     * - иначе(т.е. j!=0 ) то j = pi[j-1]
     * <p>
     * - иначе (т.е. ai == aj) pi[i] =j+1; i++; j++;
     * 2 шаг: Поиск образа в строке
     * пусть heystack - t array, needle - a array
     * - если tk == al тогда
     * k++; l++;
     * - если l==n, то образ найден
     * <p>
     * - иначе (т.е. tk != al)
     * - если l == 0, тогда k++;
     * - если k == n то образ в строке нет
     * - иначе (т.е. l != 0) l = pi[l-1];
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

    public static void main(String[] args) {
        String needle = "abcabd";
        char []a = needle.toCharArray();
        System.out.println();
    }
}
