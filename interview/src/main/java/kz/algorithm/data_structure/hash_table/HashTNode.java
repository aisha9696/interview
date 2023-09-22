package kz.algorithm.data_structure.hash_table;


import java.util.HashMap;

public class HashTNode {
    private Integer key;
    private Integer value;

    public HashTNode(Integer key, Integer value) {
        this.key = key;
        this.value = value;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
/*public HashTNode(Object key, Object value) {
        this.key = key;
        this.value = value;
    }*/
}
