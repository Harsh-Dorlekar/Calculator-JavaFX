package com.example.assignment2javafx;

public class Excel {

    public static int calculateSum(int[] values) {
        int sum = 0;
        for (int value : values) {
            sum += value;
        }
        return sum;
    }

    public static int calculateAverage(int[] values) {
        if (values.length == 0) {
            return 0;
        }

        int sum = calculateSum(values);
        return sum / values.length;
    }

    public static int findMinimum(int[] values) {
        if (values.length == 0) {
            return 0;
        }

        int minimum = values[0];
        for (int value : values) {
            if (value < minimum) {
                minimum = value;
            }
        }
        return minimum;
    }

    public static int findMaximum(int[] values) {
        if (values.length == 0) {
            return 0;
        }

        int maximum = values[0];
        for (int value : values) {
            if (value > maximum) {
                maximum = value;
            }
        }
        return maximum;
    }
}
