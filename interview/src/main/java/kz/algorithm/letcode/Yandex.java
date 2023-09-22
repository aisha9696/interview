package kz.algorithm.letcode;

import java.util.*;

public class Yandex {
    /**
     *  49. Group Anagrams
     *  Given an array of strings strs, group the anagrams together. You can return the answer in any order.
     *
     * An Anagram is a word or phrase formed by rearranging the letters of a
     * different word or phrase, typically using all the original letters exactly once.
     *
     * Input: strs = ["eat","tea","tan","ate","nat","bat"]
     * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
     * */

    public static List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> finaly = new ArrayList<>();
        if(strs.length == 1){
            finaly.add(Arrays.asList(strs[0]));
        }else{
            HashMap<String, List<String>> grMap = new HashMap<>();

            for(String str : strs){
                char[] strAr = str.toCharArray();
                Arrays.sort(strAr);
                String s = String.valueOf(strAr);
                if(!grMap.containsKey(s)){
                    List<String> arr = new ArrayList<>();
                    arr.add(str);
                    grMap.put(s, arr);
                }else{
                    List<String> list = grMap.get(s);
                    list.add(str);

                }
            }
            for(String key : grMap.keySet()){
                finaly.add(grMap.get(key));
            }

        }
        return finaly;
    }

    public static void main(String[] args) {
        groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});

    }
}
