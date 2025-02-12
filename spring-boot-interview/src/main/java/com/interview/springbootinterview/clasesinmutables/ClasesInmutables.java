package com.interview.springbootinterview.clasesinmutables;

public class ClasesInmutables {
    public static void main(String[] args) {
        Rectangle myRect;
        myRect.width = 40;
        myRect.height = 50;
        System.out.println( “El área de mi rectángulo es ”
                +myRect.area());
    }
}
