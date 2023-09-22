package kz.algorithm.algorithm.sort;

public class CountSort {

    public static void sort(int a[], int size){
        int count[]= new int[size];
        for(int i = 0; i<size;i++){
            count[i] = 0;
        }
        int out []= new int[a.length];

        for(int i = 0; i<a.length;i++){
            ++count[a[i]];
        }
        int k = 0;
        for(int i = 0; i<size;i++){
            int n = count[i];
            while (n!=0){
                out[k++] = i;
                n--;
            }
        }
        a = out;
    }

    /**
     * отсортировать негативные числа
     * */
    public static void sort(int a[]){
       int min = Integer.MAX_VALUE;
       int max = Integer.MIN_VALUE;

        for(int i = 0; i<a.length;i++){
            if(a[i]>max) max =a[i];
            if(a[i]<min) min = a[i];
        }

        int range = max - min +1;

        int count[] = new int[range];
        for (int i = 0; i < a.length; i++) {
            count[a[i] - min]++;
        }
        int out []= new int[a.length];
        int k = 0;
        for(int i = 0; i < range; i++){
            int n = count[i];
            while (n!=0){
                out[k++] = i + min;
                n--;
            }
        }
        a = out;

    }


    public static void sort(char arr[])
    {
        int n = arr.length;

        // The output character array that will have sorted arr
        char output[] = new char[n];

        // Create a count array to store count of inidividul
        // characters and initialize count array as 0
        int count[] = new int[256];
        for (int i = 0; i < 256; ++i)
            count[i] = 0;

        // store count of each character
        for (int i = 0; i < n; ++i)
            ++count[arr[i]];

        // Change count[i] so that count[i] now contains actual
        // position of this character in output array
        for (int i = 1; i <= 255; ++i)
            count[i] += count[i - 1];

        // Build the output character array
        // To make it stable we are operating in reverse order.
        for (int i = n - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            --count[arr[i]];
        }

        // Copy the output array to arr, so that arr now
        // contains sorted characters
        for (int i = 0; i < n; ++i)
            arr[i] = output[i];
    }


    public static void main(String[] args) {
        sort(new int[]{5,1,2,7,2,1,3,9,4,10,2,6,1,52,44,32,1,0},100);
        sort(new int[]{-1,5,-8,10,4,-2,3,-7,5,8,2,3,3,1,0});


        char arr[] = { 'g', 'e', 'e', 'k', 's', 'f', 'o',
                'r', 'g', 'e', 'e', 'k', 's' };

        sort(arr);

        System.out.print("Sorted character array is ");
        for (int i = 0; i < arr.length; ++i)
            System.out.print(arr[i]);
    }
}
