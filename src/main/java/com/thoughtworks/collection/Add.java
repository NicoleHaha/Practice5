package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Add {
    public int getSumOfEvens(int leftBorder, int rightBorder) {
        int result = 0;
        if(leftBorder<rightBorder){
            result =IntStream.range(leftBorder, rightBorder + 1)
                    .filter(even -> even % 2 == 0)
                    .sum();
        }
        else {
            result =IntStream.range(rightBorder,  leftBorder+ 1)
                    .filter(even -> even % 2 == 0)
                    .sum();
        }
        return result;
    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {
        int result = 0;
        if(leftBorder<rightBorder){
            result =IntStream.range(leftBorder, rightBorder + 1)
                    .filter(even -> even % 2 == 1)
                    .sum();
        }
        else {
            result =IntStream.range(rightBorder,  leftBorder+ 1)
                    .filter(even -> even % 2 == 1)
                    .sum();
        }
        return result;

    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
        int result = arrayList.stream().map(item -> item = item * 3 + 2).reduce(0, Integer::sum);
        return result;
    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
        List<Integer> result = arrayList.stream().map(item -> {
            if (item % 2 == 1) item = item * 3 + 2;
            return item;
        }).collect(Collectors.toList());
        return result;
    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        int result = arrayList.stream()
                .filter(item -> item % 2 == 1)
                .map(item -> item * 3 + 5)
                .reduce(0, Integer::sum);
        return result;
    }

    public double getMedianOfEvenIndex(List<Integer> arrayList) {
        double result = 0;
        long count = arrayList.stream()
                .filter(even->(even%2==0)).count();
        if(count%2==1){
            List<Integer> tlist = arrayList.stream()
                    .filter(even->(even%2==0))
                    .skip(count/2)
                    .limit(1).collect(Collectors.toList());

            result =(double) tlist.get(0);
        }
        else {
            int tem = arrayList.stream()
                    .filter(even->(even%2==0))
                    .skip(count/2-1)
                    .limit(2)
                    .reduce(0,Integer::sum);
            result = tem/2;
        }
        return result;
    }

    public double getAverageOfEvenIndex(List<Integer> arrayList) {
        IntSummaryStatistics sum = arrayList.stream()
                .filter(even->(even%2==0)).mapToInt(x->x)
                .summaryStatistics();
        return sum.getAverage();
    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
        boolean result = arrayList.stream()
                .filter(even->(even%2==0)).anyMatch(x->x==specialElment);
        return result;
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        List<Integer> result = arrayList.stream()
                .filter(even->(even%2==0))
                .distinct()
                .collect(Collectors.toList());
        return result;
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        List<Integer> result = arrayList.stream()
                .filter(even->(even%2==0))
                .sorted()
                .collect(Collectors.toList());
        List<Integer> oddlist = arrayList.stream()
                .filter(odd->(odd%2==1))
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        result.addAll(oddlist);
        return result;
    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {
        List<Integer> result = new ArrayList<Integer>();
        arrayList.stream().reduce((a,b)->{
            int temp = (a+b)*3;
            result.add(temp);
            return b;
        });
        return result;
    }
}
