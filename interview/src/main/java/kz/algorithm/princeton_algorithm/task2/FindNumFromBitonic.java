package kz.algorithm.princeton_algorithm.task2;

import kz.algorithm.algorithm.binary_search.BinarySearch;

public class FindNumFromBitonic {
    BinarySearch binarySearch = new BinarySearch();

    public  int findNum(int a[],int key){

        int mid = a.length/2;

        if(a[mid-1]>a[mid] || a[mid+1]<a[mid]){
            return binarySearch.recursiveFunction(a,key, 0,mid-1);
        }else if(a[mid+1]>a[mid] || a[mid-1]<a[mid]){
            return binarySearch.descResursiveFunction(a,key,mid+1,a.length-1);
        }else if(a[mid]==key) {
            return mid;
        }

        return -1;
    }


    public static void main(String[] args) {
        int []a={3,4,7,8,9,5,2,1};
        FindNumFromBitonic findNumFromBitonic=new FindNumFromBitonic();
        System.out.println(findNumFromBitonic.findNum(a,5));
    }

}
