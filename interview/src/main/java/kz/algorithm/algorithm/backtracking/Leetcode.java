package kz.algorithm.algorithm.backtracking;


import java.util.ArrayList;
import java.util.List;

public class Leetcode {
    public static List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();
        int countOfHourLED = 4;
        int countOfMinutLED = 6;
        if(turnedOn >= countOfHourLED+countOfMinutLED) return null; //first constraints
        /**
         * choice - all possible numbers
         * */

        if(turnedOn < countOfHourLED){

            addTimeList(0,turnedOn,result,turnedOn);
        }

        return result;
    }
    public static int shift(int num){
        return  num<<1;
    }

    public static int countOfBitToNum(int countOfBit){
        int num = 0;
        for(int i =0; i<countOfBit; i++){
            num+=Math.pow(2,i);
        }
        return num;
    }

    public static List<String> addTimeList(int hourBit, int minutBit, List<String> res, int turnedOn){
        if(hourBit>turnedOn) return res;
        minutBit = turnedOn-hourBit;
        int hour = countOfBitToNum(hourBit);
        int minut = countOfBitToNum(minutBit);

        if(hour == 0){
            int curMinut = minut;
            while (curMinut<60){
                String min = "";
                if(curMinut<10){
                    min+="0"+curMinut;
                }else{
                    min+= curMinut;
                }
                res.add(hour +":" +min);
                curMinut=shift(curMinut);
            }
        }
        else if(minut ==0){
            while (hour<13 ){
                res.add(hour +":00");
                hour=shift(hour);
            }
        }else{
            while (hour<13 ){
                int curMinut = minut;
                while (curMinut<60){
                    String min = "";
                    if(curMinut<10){
                        min+="0"+curMinut;
                    }else{
                        min+= curMinut;
                    }
                    res.add(hour +":" +min);
                    curMinut=shift(curMinut);
                }
                hour=shift(hour);
            }
        }
        return addTimeList(hourBit+1, minutBit,res,turnedOn);

    }



    static final int[] map = {1,2,4,8,1,2,4,8,16,32};
    public static List<String> readBinaryWatch1(int num) {
        List<String> res = new ArrayList<>();
        backtrack(res, 0, 0, 0, num);
        return res;
    }
    /**
     * left counter для ячейек заполнения
     * index - это индекс LED
     * */
    public static void backtrack(List<String> res, int curHour, int curMinute, int index, int left){
        if(index == 10 && left!=0) return;
        else if(left==0){
            res.add(translate(curHour, curMinute));
            return;
        }else{
            if(index<4&&curHour+map[index]<12) {
                backtrack(res, curHour+map[index], curMinute, index+1, left-1);
            }else if(index>=4 && curMinute+map[index]<60){
                backtrack(res, curHour, curMinute+map[index], index+1, left-1);
            }
            /** чтобы если не подходить по constraints то идем след index но не заполняеем box*/
            backtrack(res, curHour, curMinute, index+1, left);
        }
    }
    public static String translate(int hour, int minute){
        if(minute<10) return String.valueOf(hour)+":0"+String.valueOf(minute);
        else return String.valueOf(hour)+":"+String.valueOf(minute);
    }

    public static int subsetXORSum(int[] nums) {
        int sum = 0;
        backtracking(nums, sum,0,0);
        return sum;
    }


    public static void backtracking (int []num, int sum, int index, int currNum){
        if(index == num.length || index>num.length)return;

        currNum^=num[index];
        sum+=currNum;
        for(int i = index+1; i<num.length; i++){
            backtracking(num,sum,i,num[index]);
        }

        backtracking(num,sum,index+1,currNum);
        System.out.println();

    }
    public static void main(String[] args) {
        readBinaryWatch1(4  ).stream().forEach(a-> System.out.println(a));
        System.out.println(subsetXORSum(new int[]{3,4,5,6,7,8}));
    }


}
