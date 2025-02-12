/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gamesmall.java.interviews.functionalinterfaces;

import com.gamesmall.java.interviews.functionalinterfaces.interfaces.Custom;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author jjose
 */
public class Home {
    public static void main(String[] args) {
        
        Custom largo = (t) -> t.length();
        Custom largo2 = Integer::parseInt;
        
        System.out.println(largo.execute("feo"));
        System.out.println(largo2.execute("500000"));
    }
}
