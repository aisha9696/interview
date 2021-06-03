package kz.algorithm.data_structure.hash_table;

import java.util.LinkedList;

public class SeperateChainingHashST {
    private static final int M  = 97; //число цепочек
    LinkedList<HashTNode>[] maps;

    private int getHash(Integer key){
        return key % M;
    }

    public SeperateChainingHashST() {
        maps = new LinkedList[M];
    }

    public Integer get(Integer key){
        int index = getHash(key);
        LinkedList<HashTNode> list = maps[index];
        if(maps[index] == null) return -1;
        for(HashTNode tNode: list){
            if(tNode.getKey() == key){
                return tNode.getValue();
            }
        }
        return -1;
    }
    public void put(Integer key, Integer value){
        int index = getHash(key);
        if(maps[index] == null){
            maps[index] = new LinkedList<>();
            maps[index].add(new HashTNode(key,value));
        }else{
            LinkedList<HashTNode> list = maps[index];
            for(HashTNode tNode: list){
                if(tNode.getKey() == key){
                    tNode.setValue(value);
                }
            }
            maps[index].add(new HashTNode(key,value));
        }


    }
    public void remove(Integer key){
        int index = getHash(key);
        if(maps[index] == null) return;
        LinkedList<HashTNode> list = maps[index];
        for(HashTNode tNode: list){
            if(tNode.getKey() == key){
                list.remove(tNode);
            }
        }

    }

    public static void main(String[] args) {
        SeperateChainingHashST hashST = new SeperateChainingHashST();
        hashST.put(1,1);
        hashST.put(5,2);
        hashST.put(3,1);
        hashST.put(1,3);
        System.out.println(hashST.get(1));

    }
}
