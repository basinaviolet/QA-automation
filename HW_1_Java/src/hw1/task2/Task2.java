package main.task2;

import java.util.List;

public class Task2 {
    Logic help = new Logic();

    public static int getLengthOfNumber(float number) {
        return Integer
                .toString(Math.round(Math.abs(number)))
                .length()
                + getMantissaLength(number);
    }

    public static int getMantissaLength (float number) {
        String mantissaOfFloatNumber = String.valueOf(number);
        mantissaOfFloatNumber = mantissaOfFloatNumber
                .substring(mantissaOfFloatNumber.indexOf("."))
                .substring(1);
        return (mantissaOfFloatNumber.equals("0")) ? 0 : mantissaOfFloatNumber.length();
    }

    public void main(String[] args) {
        List<Float> numbersList = help.getNumberList();

        System.out.println("Enter numbers separated by a space and ending the number list by the 'end': ");
        if (!numbersList.isEmpty()) {
            minAndMaxNumber(numbersList);
            minAndMaxLength(numbersList);
        } else {
            System.out.println("The number list is empty!");
        }
    }

    public void minAndMaxNumber(List<Float> numberList) {

        float min = Float.MAX_VALUE;
        float max = -Float.MAX_VALUE;

        for (Float item : numberList) {
            min = (item < min) ? item : min;
            max = (item > max) ? item : max;
        }
        System.out.printf(help.toPrint("number", getMantissaLength(min), getMantissaLength(max)), min, max);
    }

    public void minAndMaxLength(List<Float> numberList) {

        int minIndex = 0;
        int maxIndex = 0;

        for (Float item : numberList) {
            minIndex = (getLengthOfNumber(item) < getLengthOfNumber(numberList.get(minIndex)))
                    ? numberList.indexOf(item)
                    : minIndex;
            maxIndex = (getLengthOfNumber(item) > getLengthOfNumber(numberList.get(maxIndex)))
                    ? numberList.indexOf(item)
                    : maxIndex;
        }

        System.out.printf(help.toPrint("length has number (the first from other with similar length)",
                getMantissaLength(numberList.get(minIndex)), getMantissaLength(numberList.get(maxIndex))),
                numberList.get(minIndex), getLengthOfNumber(numberList.get(minIndex)),
                numberList.get(maxIndex), getLengthOfNumber(numberList.get(maxIndex)));
    }
}

