package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MyMap {

    List<Integer> array;
    private String[] letters = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
            "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private List<String> letterList = Arrays.asList(letters);

    public MyMap(List<Integer> array) {
        this.array = array;
    }

    public List<Integer> getTriple() {
        List<Integer> result = new ArrayList<Integer>();
        result = array.stream()
                .map(item -> item * 3)
                .collect(Collectors.toList());
        return result;
    }

    public List<String> mapLetter() {
        List<String> result = new ArrayList<String>();
        array.stream()
                .forEach(item->{
                    String str = letterList.get(item-1);
                    result.add(str);
                });

        return result;
    }

    public List<String> mapLetters() {
        List<String> result = new ArrayList<String>();
        for (Integer item : array) {
            int temp = item.intValue();//30
            String map = new String();
            double flag = Math.log(temp) / Math.log(26);
            for (int i = 0; i <= flag; i++) {//0 2
                char tt;
                int cur;
                cur = temp - i * 26;
                int div = cur / 26;
                int mod = cur % 26;
                if (mod == 0) {
                    div -= 1;
                    mod = 26;
                }
                if (div == 0) {

                    cur = 96 + mod;
                    tt = (char) cur;
                    map += tt;
                } else {
                    cur = 96 + div;
                    tt = (char) cur;
                    map += tt;
                }
            }
            result.add(map);
        }
        return result;
    }

    public List<Integer> sortFromBig() {
        List<Integer> result = array.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        return result;
    }

    public List<Integer> sortFromSmall() {
        List<Integer> result = array.stream()
                .sorted()
                .collect(Collectors.toList());
        return result;
    }
}
