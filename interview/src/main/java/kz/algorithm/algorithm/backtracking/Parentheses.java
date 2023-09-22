package kz.algorithm.algorithm.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Parentheses {
    static List<String> result = new ArrayList<>();

    public static boolean isValid(String s){
        Stack<Character> stacks = new Stack<>();

        for(Character ch : s.toCharArray()){
            if(stacks.isEmpty() && ch == ')'){
                return false;
            }
            else if(ch == '('){
                stacks.push(ch);
            }else if(ch == ')' && stacks.peek() == '('){
                stacks.pop();
            }
        }

        return stacks.isEmpty();
    }

    /// decision tree is "(" and  ")"
    public static void dfs(StringBuilder s, int n, int countOpen, int countClose){
        // GOAL момент когда мы должны сохранить в массив вывода и выйти из рекурсии
        if( s.length() ==2*n ){
           result.add(s.toString());
            return;
        }
        /**
         * обязательно вызывать рекурсию при каждом элементе выборки
         * */
        /// наш элемент для выбоки  открывающая скобка
        if(countOpen < n){ // <-- это момент выборки CONSTRAINT
            // (как мы помним это decision restrict somehow)
            s.append("(");
            dfs(s, n, countOpen+1, countClose);
            s.deleteCharAt(s.length()-1);
        }
        /// закрывающая скобка
        if(countClose < countOpen){// <-- то момент выборки CONSTRAINT
            s.append(")");
            dfs(s, n, countOpen, countClose+1);
            s.deleteCharAt(s.length()-1);
        }
    }

    public static List<String> generateParenthesis(int n) {
        if(n == 0) return result;
        dfs(new StringBuilder(),n,0,0);
        return  result;
    }

    public static void main(String[] args) {
        generateParenthesis(3);
        System.out.println("s");
    }
}
