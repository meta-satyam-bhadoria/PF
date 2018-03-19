/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.util;

/**
 *
 * @author MACWUS
 */
public class Main {
    public static void main(String[] args) {
        InfixToPostfix l = new InfixToPostfix();
        System.out.println(l.convertToPostfix("a * b * ()ce + d ) "));
    }
}
