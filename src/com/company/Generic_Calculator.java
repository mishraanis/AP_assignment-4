package com.company;

public class Generic_Calculator {

    public static <T>T calculate(T a, T b) throws NullPointerException, NumberFormatException, ArithmeticException {
        try {
            if (a instanceof Integer && b instanceof Integer) {
                return (T)(Integer)((Integer)a/(Integer) b);
            } else if (a instanceof String && b instanceof String) {
                return (T) (a.toString() + b.toString());
            }
        }
        catch (NullPointerException e) {
            NullPointerException nullPointerException = new NullPointerException("either of the operands is null");
            System.out.println("Error: " + nullPointerException.getMessage());
        }
        catch (NumberFormatException e) {
            NumberFormatException numberFormatException = new NumberFormatException("either of the operands is not a number");
            System.out.println("Error: " + numberFormatException.getMessage());
        }
        catch (ArithmeticException e) {
            ArithmeticException division_by_zero = new ArithmeticException("division by zero");
            System.out.println("Error: " + division_by_zero.getMessage());
        }
        return null;
    }
}
