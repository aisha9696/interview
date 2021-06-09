package kz.algorithm.data_structure.stack;

public class ResizedArrayRepr {
    /**
     * Every operation takes O(n) in worst case
     * */
    private String [] array;
    private int N =1; //capacity

    public ResizedArrayRepr() {
        this.array = new String[1];
    }

    public void push(String val){
        if(N == array.length){
            resize(2*array.length);
        }
        array[N++] = val;
    }

    private void resize(int capacity) {
        String[] copy = new String[capacity];
        for(int i= 0; i< N; i++){
            copy[i] = array[i];
        }
        array = copy;
    }

    public String pop(){
        String item = array[N--];
        array[N] = null;
        if(N>0 && N == array.length/4){
            resize(array.length/2);
        }
        return item;
    }
}
