package com.it_academy.practice.junit_basics;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//        CommonLang.createLang();
        int n = 5;
        int[] parametersForCalc;// = new int[n];

        CalculatorVersion1 calculatorMulti = new CalculatorVersion1(0,0);
        parametersForCalc =  calculatorMulti.getParameterList(n);

        System.out.println("Plus result: " + calculatorMulti.calculate(parametersForCalc, '+'));
        System.out.println("Minus result: " + calculatorMulti.calculate(parametersForCalc, '-'));
        System.out.println("Division result: " + calculatorMulti.calculate(parametersForCalc,'/'));
        System.out.println("Multiply result: " + calculatorMulti.calculate(parametersForCalc,'*'));
        System.out.println("Power result: " + calculatorMulti.calculate(parametersForCalc,'^'));
        System.out.println("Root result: " + calculatorMulti.calculate(parametersForCalc,'|'));

//        Scanner sc = new Scanner(System.in);

//        int n1 = Integer.parseInt(sc.next());
//        int n2 = Integer.parseInt(sc.next());
//
//        CalculatorVersion1 calculator = new CalculatorVersion1(n1, n2);
//
//        System.out.println("Plus result: " + calculator.calculate('+'));
//        System.out.println("Minus result: " + calculator.calculate('-'));
//        System.out.println("Division result: " + calculator.calculate('/'));
//        System.out.println("Multiply result: " + calculator.calculate('*'));
//        System.out.println("Power result: " + calculator.calculate('^'));
//        System.out.println("Root result: " + calculator.calculate('|'));
    }
}
