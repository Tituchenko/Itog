package ru.gb;

import java.util.List;

public class Calc {
    /**
     * Метод возвращает среднее значение списка
     * @param list список чисел
     * @return среднее значение
     */
    public static double calcAverage(List<Integer> list){
        if (list.size()==0) return 0;
        Integer sum= 0;
        for (Integer val:list) {
            sum+=val;
        }
        return sum/list.size();
    }

    public static String checkLists (List<Integer> list1,List<Integer> list2){
        String result;
        double calcAverage1=calcAverage(list1);
        double calcAverage2=calcAverage(list2);
        if (calcAverage1==calcAverage2){
            result="Средние значения равны";
        } else if (calcAverage1>calcAverage2) {
            result="Первый список имеет большее среднее значение";
        } else {
            result="Воторой список имеет большее среднее значение";
        }
        return result;
    }
}
