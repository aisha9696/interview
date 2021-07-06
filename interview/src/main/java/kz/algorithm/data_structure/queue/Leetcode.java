package kz.algorithm.data_structure.queue;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode {
    public static int countStudents(int[] students, int[] sandwiches) {
        if(students.length != sandwiches.length){
            return Integer.MIN_VALUE;
        }
        Queue<Integer> stud = toQueue(students);
        Queue<Integer> sand = toQueue(sandwiches);

        while(stud.size() != 0){
            if(stud.peek() == sand.peek()){
                stud.poll();
                sand.poll();
            }else{
                boolean check = true;
                Queue<Integer> current = new LinkedList();
                current.add(stud.poll());
                while(stud.size() != 0){
                    if(current.peek() != stud.peek()){
                        check = false;
                    }
                    current.add(stud.poll());
                }
                stud = current;
                if(check){
                    break;
                }else{
                    stud.add(stud.poll());
                }

            }

        }

        return stud.size();
    }
    public static Queue<Integer> toQueue(int[] array ){
        Queue<Integer> result = new LinkedList<>();
        for(int i : array){
            result.add(i);
        }
        return result;

    }


    public static void main(String[] args) {

        System.out.println(countStudents(new int[]{1,1,0,0},new int[]{0,1,0,1}));
    }
}
