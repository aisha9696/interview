package kz.algorithm;

import jdk.internal.org.objectweb.asm.commons.SerialVersionUIDAdder;

public class Laba7 {

    static int even(int N, int count) {
        if (N == 0) return count;
        int f = N % 10;
        if (f % 2 == 0) count++;

        return even(N / 10, count++);
    }





    public static void main(String[] args) {
        int N = 987456123;
        System.out.println(even(N, 0));
    }
}
