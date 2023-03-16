package com.JavaRandom;
import java.util.Random;

public class JavaRandom {
    public static void main(String[] args) {
        Random rand = new Random();
        int roll1 = rand.nextInt(6) + 1;
        int roll2 = rand.nextInt(6) + 1;
        System.out.println("您掷出了：" + roll1 + " 和 " + roll2);
        System.out.println("总共：" + (roll1 + roll2));
    }
}
