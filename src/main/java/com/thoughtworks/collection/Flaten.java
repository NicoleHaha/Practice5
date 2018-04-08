package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Flaten {

    Integer[][] array;
    public Flaten(Integer[][] array) {
        this.array = array;
    }

    public List<Integer> transformToOneDimesional() {
        List<Integer> result = new ArrayList<Integer>();
        result = Stream.of(array)
                .flatMap((newarray)-> Arrays.stream(newarray))
                .collect(Collectors.toList());
        return result;
    }

    public List<Integer> transformToUnrepeatedOneDimesional() {
        List<Integer> result = new ArrayList<Integer>();
        result = Stream.of(array)
                .flatMap((newarray)-> Arrays.stream(newarray))
                .distinct()
                .collect(Collectors.toList());
        return result;
    }
}
