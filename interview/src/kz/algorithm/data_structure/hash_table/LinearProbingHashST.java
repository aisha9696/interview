package kz.algorithm.data_structure.hash_table;

import java.util.Objects;

public class LinearProbingHashST<Key, Value> {
    private int M = 30001;
    private Value[] vals = (Value[]) new Object [M];
    private Key [] keys = (Key[]) new Object[M];

    private int toHash(Key key){
        return key.hashCode() % M;
    }

    public void put(Key key, Value value){
        int i;
        for(i = toHash(key); keys[i] != null; i = (i+1)%M){
            if(keys[i].equals(key)){
                break;
            }
            keys[i] = key;
            vals[i] = value;
        }

    }

    public void remove(Key key){
        int i;
        for(i = toHash(key); keys[i] != null; i = (i+1)%M){
            if(keys[i].equals(key)){
                while (keys[i+1] != null){
                    keys[i] = keys[i+1];
                    vals[i] = vals[i+1];
                }
            }
        }

    }

    public Value get(Key key){
        for(int i = toHash(key); keys[i] != null; i = (i+1)%M){
            if(keys[i].equals(key)){
                return vals[i];
            }
        }
        return null;
    }

    public static void main(String[] args) {
        LinearProbingHashST<Integer, Character> st = new LinearProbingHashST<>();
        st.put(1,'a');
        st.put(2,'b');
        st.put(3,'c');
        System.out.println(st.get(3));
        st.remove(3);
        System.out.println(st.get(3));
    }
}
