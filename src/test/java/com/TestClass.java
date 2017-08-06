package com;

import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by xp on 2017/7/28.
 */
public class TestClass {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int pieces = Integer.parseInt(in.nextLine().trim());
        int[] parts = new int[pieces];
        for (int i = 0; i < pieces; i++) {
            parts[i] = Integer.parseInt(in.nextLine().trim());
        }
        Arrays.sort(parts);
        int count = 0;
        for (int i = 0; i <parts.length ; i++) {
            count+= parts[i];
        }
        if(pieces %2==0){

        }
    }

}
