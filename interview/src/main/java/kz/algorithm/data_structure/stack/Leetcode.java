package kz.algorithm.data_structure.stack;

import java.util.HashMap;
import java.util.Stack;

public class Leetcode {

    /**
     * удалить повторяющиеся значения
     * abbaca --- 1) удаляется bb
     *            2) остается aaca
     *            3) удаляется aa
     *            4) остается ca
     * */
    public static String removeDuplicates(String s) {
        String result = "";
        if(s == null){
            return result;
        }
        Stack<Character> stacks = new Stack<>();
        for(Character chars : s.toCharArray()){
            if (stacks.isEmpty() ){
                stacks.push(chars);
            }else{
                if(stacks.peek() == chars){
                    stacks.pop();
                }else{
                    stacks.push(chars);
                }
            }
        }
        Stack<Character> reverse = new Stack<>();
        while(!stacks.isEmpty()){
            reverse.push(stacks.pop());
        }
        while(!reverse.isEmpty()){
            result += reverse.pop();
        }

        return result;
    }


    /**Валидный скобкий
     * пример: () true
     * ({}) treu
     * ({{{[[}}]} false
     * (({}))
     * */
    public static boolean isValid(String s) {
        if(s == null || s == "") return false;
        Stack<Character> stacks = new Stack<>();

        for(Character ch : s.toCharArray()){
            if(stacks.isEmpty() && (ch == ')' || ch == ']' || ch == '}') ){
                return false;
            }
            else if(ch == '(' || ch =='[' || ch == '{' ){
                stacks.push(ch);
            }else if(ch == ')' && stacks.peek() == '('){
                stacks.pop();
            }else if(ch == ']' && stacks.peek() == '['){
                stacks.pop();
            }else if(ch == '}' && stacks.peek() == '{'){
                stacks.pop();
            }else {
                return false;
            }
        }

        return stacks.isEmpty();

    }

    public static boolean backspaceCompare(String s, String t) {
        if(s == "" && t == ""){
            return false;
        }
        System.out.println(backspaced(s) +" " + backspaced(t));
        return backspaced(s).equals(backspaced(t)) ;
    }
    public static String backspaced(String str){
        String res = "";
        Stack<Character> stacks = new Stack<>();
        for(Character ch : str.toCharArray()){
            if(stacks.isEmpty() && ch == '#' ){
                return "";
            }else if(ch == '#'){
                stacks.pop();
            }else {
                stacks.push(ch);
            }
        }
        while(!stacks.isEmpty()){
            res += stacks.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates("AABBaac"));
        System.out.println(isValid("}"));
        System.out.println(backspaceCompare("ab#c", "ad#c"));
    }

}
