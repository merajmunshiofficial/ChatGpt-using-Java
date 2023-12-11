package Monoluge;

import java.io.BufferedInputStream; 
import java.util.Scanner; 
 
public class multiLine { 
 
    public static void main(String args[]) { 
        Scanner stdin = new Scanner(new BufferedInputStream(System.in)); 
        while (stdin.hasNext()) { 
            System.out.println(Math.abs(stdin.nextLong() - stdin.nextLong())); 
        } 
    } 
} 