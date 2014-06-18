package math;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by chace on 6/17/14.
 */
public class EvaluateArithmaticExpression {

    public static double evaluate(String[] args) {
        if (args == null) {
            throw new NullPointerException();
        }
        LinkedList<Double> numberCache = new LinkedList<Double>();
        LinkedList<String> operationCache = new LinkedList<String>();
        int len = args.length;
        for (int i = 0; i < len; i++) {
            if (isDigital(args[i])) {
                numberCache.push(Double.parseDouble(args[i]));
            } else if (args[i].equals("*") || args[i].equals("/")) {
                if (numberCache.isEmpty() || i == len -1 || !isDigital(args[i+1])) {
                    throw new ArithmeticException();
                }
                double d1 = numberCache.pop();
                double d2 = Double.parseDouble(args[i+1]);
                numberCache.push(cal(d1, d2, args[i]));
                i++;
            } else if (args[i].equals("+") || args[i].equals("-")) {
                operationCache.push(args[i]);
            }
        }
        while (!operationCache.isEmpty()) {
            double d2 = numberCache.get(0);
            numberCache.remove(0);
            double d1 = numberCache.get(0);
            numberCache.remove(0);
            String op = operationCache.get(0);
            operationCache.remove(0);
            numberCache.add(0, cal(d1, d2, op));
        }
        return numberCache.get(0);
    }

    public static double cal(double d1, double d2, String op) {
        if (op.equals("+")) {
            return d1 + d2;
        } else if (op.equals("-")) {
            return d1 - d2;
        } else if (op.equals("*")) {
            return d1 * d2;
        } else if (op.equals("/")) {
            return d1 / d2;
        }
        return d1 + d2;
    }

    public static boolean isDigital(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(evaluate(new String[]{"4", "*", "7", "+", "4"}));
        System.out.println(evaluate(new String[]{"4", "-", "7", "+", "4"}));
        System.out.println(evaluate(new String[]{"4", "-", "7", "*", "4"}));
        System.out.println(evaluate(new String[]{"4", "-", "7", "/", "4"}));
        System.out.println(evaluate(new String[]{"20", "-", "7", "*", "4"}));
        System.out.println(evaluate(new String[]{"20", "-", "0", "*", "4"}));
    }
}
