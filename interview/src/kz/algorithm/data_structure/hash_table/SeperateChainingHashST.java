package kz.algorithm.data_structure.hash_table;

public class SeperateChainingHashST<Key,Value> {
    private int M  = 97; //число цепочек
    private HashTNode [] st = new HashTNode[M]; // массив цепочек

    private int getHash(Key key){
        return (key.hashCode()&Integer.MAX_VALUE)%M;
    }

    public Value get(Key key){
        int i = getHash(key);
        for (HashTNode x = st[i]; x != null; x = x.getNext()){
            if(key.equals(x.getKey())){
                return (Value) x.getValue();
            }
        }
        return null;
    }
    public void put(Key key, Value value){
        int i = getHash(key);
        for (HashTNode x = st[i]; x != null; x = x.getNext()){
            if(key.equals(x.getKey())){
                x.setValue(value);
                return ;
            }
            st[i] = new HashTNode(key, value, st[i]);
        }
    }

    public static void main(String[] args) {

    }
}
