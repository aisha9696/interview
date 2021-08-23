package kz.algorithm.data_structure.two_pointer_tech;

import java.util.Arrays;
import java.util.HashSet;

public class Leetcode {

    /**
     *
     */

    public static String reverseVowels(String s) {
        HashSet<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');

        char[] arr = s.toCharArray();

        int i = 0, j = arr.length - 1;
        while (i < j) {
            if (!vowels.contains(arr[i])) {
                i++;
            }
            if (!vowels.contains(arr[j])) {
                j--;
            }
            if (vowels.contains(arr[i]) && vowels.contains(arr[j])) {
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        return new String(arr);

    }

    public static boolean validPalindrome(String s) {
        if (s.length() <= 0) return false;

        int i = 0;
        int j = s.length() - 1;
        char[] arr = s.toCharArray();
        while (i < j) {
            if (arr[i] != arr[j]) {
                if (isPolindrom(arr, i + 1, j) || isPolindrom(arr, i, j - 1)) return true;
                i++;
                j--;
            }
        }
        return false;
    }

    public static boolean isSubsequence(String s, String t) {
        int i = 0, j = s.length()-1, k = 0, f = t.length()-1;
        while ( i<=j &&k <= f) {

            if (s.charAt(i) == t.charAt(k)) {
                i++;
            }
            if (s.charAt(j) == t.charAt(f)) {
                j--;
            }
            k++; f--;

        }
        if(i<j || i==j){
            return false;
        }
        return true;
    }

    public static boolean isPolindrom(char arr[], int i, int j) {
        while (i < j) {
            if (arr[i++] != arr[j--]) return false;

        }
        return true;
    }

    public static boolean checkIfExist(int[] arr) {
        Arrays.sort(arr);
        int i = 0, j =1;
        while (j<arr.length){
            if((i !=j && arr[i]*2== arr[j] )|| (i !=j && arr[j]*2== arr[i])) return true;
            if((arr[i] < 0 && arr[j]< 0 &&  (double)arr[i]/arr[j]<2.0) || (arr[i] >0 && arr[j]> 0 &&  (double)arr[j]/arr[i]<2.0)){
                j++;
            }else{
                i++;
            }
            if(i == j){
                j++;
            }
        }
        return false;
    }






    public static void main(String[] args) {
        System.out.println(reverseVowels("leetcode"));
        System.out.println(validPalindrome("deee"));
        System.out.println(isSubsequence("qwe", "sqdwfeg"));
        System.out.println(checkIfExist(new int[]{-10,12,-20,-8,15}));
    }
}
