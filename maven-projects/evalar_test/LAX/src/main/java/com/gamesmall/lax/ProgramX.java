package com.gamesmall.lax;

public class ProgramX {

    public static void main(String[] args) {
        String resultado = "";
        int n = 7;
        if (n == 0) {
            System.out.println("ERROR");
        } else {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    resultado += (j == i || j == n - i - 1) ? "X" : "_";
                }
                resultado += "\n";
            }
            System.out.println(resultado);
        }
    }

}
