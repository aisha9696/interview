package kz.algorithm.data_structure.stack;
/**
 * Every operation gets O(1) time in array representation
 * depends on capacity of array
 * */
public class FixedCapacityArrayRepr {
    private String [] array;
    private int N =0; //capacity

    public FixedCapacityArrayRepr(int capacity) {
        this.array = new String[capacity];
    }

    public boolean isEmpty(){
        return N == 0;

    }

    public void push(String item){
        array[N++] = item;
    }
    public String pop(){
        return array[N--];
    }


    /** что будет если мы хотим увеличить массив на 1
     *  1) создаем новый массив и пересохраняем все элементы туда
     *
     *
     * */


}
