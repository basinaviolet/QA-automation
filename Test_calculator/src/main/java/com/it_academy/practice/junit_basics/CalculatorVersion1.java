package com.it_academy.practice.junit_basics;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CalculatorVersion1 {

    private int a;
    private int b;

    public CalculatorVersion1(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public float getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public float getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public float calculate(char operation) {
        switch (operation) {
            default: {
                return 0;
            }
            case '-': {
                return (float) a - b;
            }
            case '+': {
                return (float) a + b;
            }
            case '/': {
                try {
                    return (float) a / b;
                } catch (ArithmeticException e) {
                    System.out.println(e + "division by 0");
                }
            }
            case '*': {
                return (float) a * b;
            }
            case '^': {
                try {
                    if (a == 0 && b != 0) {
                        return 0;
                    } else if (b == 0 && a != 0) {
                        return 1;
                    } else if (b == 1) {
                        return a;
                    } else if (b > 1) {
                        float c = a;
                        for (int i = 2; i <= b; i++) {
                            c *= (float) a;
                        }
                        return c;
                    } else {
                        float c = a;
                        for (int i = 2; i <= -b; i++) {
                            c *= (float) a;
                        }
                        return 1 / c;
                    }
                } catch (ArithmeticException e) {
                    System.out.println(e + "Arithmetic Exception");
                }
            }
            case '|': {
               try {
                   return (float) Math.pow((double) a, (double) ((float) 1 / b));
               } catch (ArithmeticException e) {
                   System.out.println(e + "Arithmetic Exception");
                   return 0;
                }
            }
        }
    }

    /* block for method with multi-parameters
     * calculate parameters
     */
    public float calculate(int[] parameters, char operation) {
        float c;
        switch (operation) {
            default: {
                return 0;
            }
            case '-': {
                c = (float) parameters[0];
                for (int i = 1; i < parameters.length; i++) {
                    c -= parameters[i];
                }
                return c;
            }
            case '+': {
                c = (float) parameters[0];
                for (int i = 1; i < parameters.length; i++) {
                    c += parameters[i];
                }
                return c;
            }
            case '/': {
                c = (float) parameters[0];
                try {
                    for (int i = 1; i < parameters.length; i++) {
                        c = c / parameters[i];
                    }
                    return c;
                } catch (ArithmeticException e) {
                    System.out.println(e + "division by 0");
                }
            }
            case '*': {
                c = (float) parameters[0];
                for (int i = 1; i < parameters.length; i++) {
                    c *= parameters[i];
                }
                return c;
            }
        }
    }

    /* block for method with multi-parameters
     * getting parameters
     */
    public int[] getParameterList(int n) {

        Scanner inputPer = new Scanner(System.in);
        List numberContainer = new ArrayList<Integer>();
        int[] parameters = new int[n];
        int i = 0;

        while (i < n){
            while (!inputPer.hasNextInt()) {
                System.out.println("Enter correct int");
                inputPer.next();
            }
            parameters[i] = inputPer.nextInt();
            i++;
        }
        return parameters;
    }
}
