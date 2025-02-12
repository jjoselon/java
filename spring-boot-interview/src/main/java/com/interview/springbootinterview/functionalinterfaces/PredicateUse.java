package com.interview.springbootinterview.functionalinterfaces;

import java.util.function.Function;
import java.util.function.Predicate;

public class PredicateUse {

    public static void main(String[] args) {
        Predicate<Integer> predicate = i -> i < 10;
        Predicate<Integer> predicate2 = t -> t > 5;

        System.out.println(predicate.and(predicate).and(predicate2).test(11));

        Function<String, Integer> function = Integer::parseInt;
    }
}
