package kz.algorithm.data_structure.queue;

public class ArrayRep {

    int front, rear,size;
    int capacity;
    int array [];

    public ArrayRep(int capacity){
        this.capacity = capacity;
        this.front  = this.size =0;
        this.rear = this.capacity -1;
        array = new int[capacity];
    }

    boolean isFull(){
        return this.capacity == this.size;
    }

    boolean isEmpty(){
        return this.size == 0;
    }

    void enqueue(int value){
        if(isFull()) return;
        this.rear = (this.rear +1) % capacity;
        this.array[this.rear] = value;
        this.size = this.size +1;
        System.out.println(value + "enqueued");
    }

    int dequeue(){
        if(isEmpty()){
            return Integer.MIN_VALUE;
        }
        int item = this.array[this.front];
        this.front = (this.front + 1)% capacity;
        this.size = this.size -1;
        return item;

    }


}
