package kz.algorithm;

import java.util.HashMap;

public class Main {
    public static int firstUniqChar(String s) {
        if(s.length() < 3) return s.length();
        HashMap<Character, Integer> chars = new HashMap<>();

        for(Character ch: s.toCharArray()){
            if(!chars.containsKey(ch)){
                chars.put(ch, 1);
            }else{
                chars.put(ch,chars.get(ch) +1);
            }
        }

        int sum = 0;
        boolean first1 = true;
        for(int val : chars.values()){
            if(val == 1 && first1){
                first1 = false;
                sum+=val;
            }else{
                if(val%2 == 0){
                    sum+=val;
                }else{
                    sum+=val-1;
                }
            }
        }

        return sum;
    }
    public static void main(String[] args) {
        System.out.println(firstUniqChar("abccccdd"));
    }
}
