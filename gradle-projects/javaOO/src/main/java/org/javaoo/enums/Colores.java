package org.javaoo.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@RequiredArgsConstructor
@Getter
public enum Colores {

    COLOR_1(255, 0, 0, Colores.COLOR_NAME),
    COLOR_2(0, 255, 0, "green"),
    COLOR_3(0, 0, 255, "blue"),
    COLOR_4(0, 0, 0, "blanco");

    private final int r;
    private final int g;
    private final int b;
    private final String color;
    private static final String noLombokTracking = "";


    private static final String COLOR_NAME = "rojo intenso";

    public static Colores getRGB(String color) {
        return Arrays.stream(Colores.values())
                .filter(c -> c.getColor().equals(color))
                .findFirst()
                .orElse(COLOR_4);
    }
}
