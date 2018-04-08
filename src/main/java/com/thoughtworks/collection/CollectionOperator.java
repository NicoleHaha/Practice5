package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CollectionOperator {
    public List<Integer> getListByInterval(int left, int right) {
        List<Integer> result = new ArrayList<Integer>();
        if (left < right) {
            result = Stream.iterate(left, n -> n + 1)
                    .limit(right - left + 1)
                    .collect(Collectors.toList());
        } else {
            result = Stream.iterate(left, n -> n - 1)
                .limit(left - right + 1)
                .collect(Collectors.toList());
        }
        return result;
    }

    public List<Integer> getEvenListByIntervals(int left, int right) {
        List<Integer> result = new ArrayList<Integer>();
        if (left < right) {
            result = Stream.iterate(left, n -> n + 1)
                    .limit(right - left + 1)
                    .filter(even -> (even % 2 == 0))
                    .collect(Collectors.toList());
        } else {
            result = Stream.iterate(right, n -> n + 1)
                    .limit(left - right + 1)
                    .filter(even -> (even % 2 == 0))
                    .sorted(Comparator.reverseOrder())
                    .collect(Collectors.toList());
        }
        return result;
    }

    public List<Integer> popEvenElments(int[] array) {
        int[] s = IntStream.of(array)
                .filter(even -> even % 2 == 0)
                .toArray();
        List<Integer> result = new ArrayList<Integer>();
        for (Integer i : s) {
            result.add(i);
        }
        return result;
    }

    public int popLastElment(int[] array) {
        Stack<Integer> stack = new Stack<Integer>();
        for (Integer i : array) {
            stack.push(i);
        }
        return stack.pop();
    }

    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
        List<Integer> result = new ArrayList<Integer>();
        for (Integer i : firstArray) {
            for (Integer j : secondArray) {
                if (j == i) {
                    result.add(j);
                }
            }
        }
        return result;
    }

    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
        List<Integer> result = new ArrayList<Integer>();
        int i = firstArray.length;
        int j = secondArray.length;
        int r = 0;
        int[] newArray = new int[i + j];
        for (Integer t : firstArray) {
            newArray[r++] = t;
        }
        for (Integer t : secondArray) {
            newArray[r++] = t;
        }
        int[] temp = IntStream.of(newArray).distinct().toArray();
        for (Integer t : temp) {
            result.add(t);
        }
        return result;
    }
}