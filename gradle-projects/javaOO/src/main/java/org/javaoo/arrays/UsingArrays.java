package org.javaoo.arrays;


import java.util.Arrays;

public class UsingArrays {
    public static void print() {
        int[] numeros = {1, 2, 3, 4, 5};
        //Arrays.stream(numeros).forEach(System.out::println);

        // Tipo de dato no primitivo
        Integer[] numeros2 = {1, 2, 3, 4, 5};

        System.out.println(Arrays.asList(numeros2).get(1));
    }
}
