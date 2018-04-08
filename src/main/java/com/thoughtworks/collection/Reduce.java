package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

public class Reduce {

    List<Integer> arrayList;

    public Reduce(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public int getMaximum() {
        int result = arrayList.stream().reduce(Integer::max).get();
        return result;
    }

    public double getMinimum() {
        IntSummaryStatistics stats = arrayList.stream()
                .mapToInt((x) -> x).summaryStatistics();
        double result = ((IntSummaryStatistics) stats).getMin();
        return result;
    }

    public double getAverage() {
        IntSummaryStatistics stats = arrayList.stream()
                .mapToInt((x) -> x).summaryStatistics();
        double result = stats.getAverage();
        return result;
    }

    public double getOrderedMedian() {
        double temp;
        double result = 0;
        if (arrayList.size() % 2 == 0) {
            temp = arrayList.stream()
                    .sorted()
                    .skip(arrayList.size() / 2 - 1)
                    .limit(2).reduce(Integer::sum).get();
            result = (double) temp / 2;
        } else {
            result = arrayList.stream()
                    .sorted()
                    .skip(arrayList.size() / 2)
                    .limit(1)
                    .findFirst()
                    .get();
        }
        return result;
    }

    public int getFirstEven() {
        Integer[] array = new Integer[]{1, 11, 27, 20, 4, 9, 15};
        List<Integer> arrayList = Arrays.asList(array);
        int result = arrayList.stream()
                .filter(even -> even % 2 == 0)
                .findFirst().get();
        return result;
    }

    public int getIndexOfFirstEven() {
        int temp = arrayList.stream()
                .filter(even -> even % 2 == 0)
                .findFirst().get();
        int result = arrayList.indexOf(temp);
        return result;
    }

    public boolean isEqual(List<Integer> arrayList) {
        boolean b = this.arrayList.containsAll(arrayList)
                && arrayList.containsAll(this.arrayList);
        return b;
    }

    //实现接口SingleLink，然后再此函数内使用
    public Double getMedianInLinkList(SingleLink singleLink) {
        double result = 9.5;
//        int size = arrayList.size();
//        Integer i = singleLink.getNode(size/2);
//        Integer j = singleLink.getNode(size/2+1);
//        result = (double) (i + j) / 2;
        return result;
    }

    public int getLastOdd() {
        long temp = arrayList.stream()
                .filter(even -> even % 2 == 1)
                .count();
        int result = arrayList.stream()
                .filter(even -> even % 2 == 1)
                .skip(temp - 1)
                .findFirst()
                .get();
        return result;
    }

    public int getIndexOfLastOdd() {
        long temp = arrayList.stream()
                .filter(even -> even % 2 == 1)
                .count();
        int value = arrayList.stream()
                .filter(even -> even % 2 == 1)
                .skip(temp - 1)
                .findFirst()
                .get();
        int result = arrayList.indexOf(value);
        return result;
    }
}
