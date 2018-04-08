package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Filter {

    List<Integer>  array;

    public Filter(List<Integer> array) {
     this.array = array;
    }

    public List<Integer> filterEven() {
        List<Integer> result = array.stream()
                .filter(even -> even % 2 == 0)
                .collect(Collectors.toList());
        return result;
    }

    public List<Integer> filterMultipleOfThree() {
        List<Integer> result = array.stream()
                .filter(t->t%3==0)
                .collect(Collectors.toList());
        return result;
    }

    public List<Integer> getCommonElements(List<Integer> firstList, List<Integer> secondList) {
        List<Integer> result = new ArrayList<Integer>();
        for(Integer i:firstList){
            if(secondList.contains(i)){
                result.add(i);
            }
        }
        return result;
    }

    public List<Integer> getDifferentElements() {
        List<Integer> result = array.stream()
                .distinct()
                .collect(Collectors.toList());
        return result;
    }
}