package com.offer;

public class No_11 {
    public static void main(String[] args) {
        System.out.println(0.001 == 0.001);
    }

    public double Power(double base, int exponent) {
        int temp = exponent;

        if (base == 0.0) {
            return 0;
        } else if (exponent == 0) {
            return 1.0;
        } else if (exponent == 1) {
            return base;
        } else if (exponent < 0) {
            temp = -exponent;
        }

        double res = 1.0;
        double curr = base;
        while (temp != 0) {
            if ((temp & 1) == 1) {
                res *= curr;
            }
            curr *= curr;
            temp >>= 1;
        }

        return exponent > 0 ? res : 1.0 / res;

//        double result = 1, curr = base;
//        int n;
//        if (exponent > 0) {
//            n = exponent;
//        } else if (exponent < 0) {
//            n = -exponent;
//        } else {
//            return 1;
//        }
//
//        while (n != 0) {
//            if ((n & 1) == 1) {
//                result *= curr;
//            }
//            curr *= curr;
//            n >>= 1;
//        }
//
//        return exponent >= 0 ? result : 1.0 / result;
    }
}
