package kz.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static int firstUniqChar(String s) {
        HashMap<Character, Integer> chars = new HashMap<>();
        HashMap<Character, Integer> index = new HashMap<>();

        for(int i = 0; i<s.length(); i++){
            if(!chars.containsKey(s.charAt(i))){
                chars.put(s.charAt(i), 1);
                index.put(s.charAt(i), i);
            }else{
                chars.put(s.charAt(i),chars.get(s.charAt(i)) +1);
            }
        }
        for(Character ch: chars.keySet()){
            if(chars.get(ch) == 1){
                return index.get(ch);
            }
        }


        return -1;
    }

    public static boolean wordPattern(String pattern, String s) {
        char [] patterns = pattern.toCharArray();
        String [] sArr = s.split(" ");
        if(patterns.length != sArr.length){
            return false;
        }

        HashMap<Character, String> finalize = new HashMap<Character, String>();
        for(int i = 0; i<patterns.length && i<sArr.length; i++ ){
            if(!finalize.containsKey(patterns[i])){
                if(finalize.containsValue(sArr[i])){
                    return false;
                }
                finalize.put(patterns[i], sArr[i]);
            }else{
                if(!finalize.get(patterns[i]).equals(sArr[i])){
                    return false;
                }
            }


        }
        return true;

    }


    public static List<String> commonChars(String[] words) {
        Map<Character, Map<Integer, Integer>> words_index_count = new HashMap<>();
        List<String> result = new ArrayList<>();
        for(int i = 0; i < words.length; i++){
            for(Character ch : words[i].toCharArray()){
                if(!words_index_count.containsKey(ch)){
                    Map<Integer, Integer> index_count = new HashMap<>();
                    index_count.put(i ,1);
                    words_index_count.put(ch,index_count);
                }else{
                    if(!words_index_count.get(ch).containsKey(i)){
                        words_index_count.get(ch).put(i,1);
                    }else{
                        words_index_count.get(ch).put(i,words_index_count.get(ch).get(i)+1);
                    }
                }
            }
        }


        for(Character ch : words_index_count.keySet()){
            if(words_index_count.get(ch).size() != words.length){
                continue;
            }
            int min = Integer.MAX_VALUE;
            for(Integer k: words_index_count.get(ch).values()){
                if(min > k){
                    min = k;
                }
            }

            for(int i = 0; i< min;i++){
                result.add(ch.toString());
            }

        }


        return result;
    }
    public static void main(String[] args) {
        //System.out.println(firstUniqChar("leetcode"));
        String [] array = {"cool","lock", "cook"};
        System.out.println(commonChars(array));
        System.out.println(wordPattern("aaaa","dog cat cat dog"));
    }
}
