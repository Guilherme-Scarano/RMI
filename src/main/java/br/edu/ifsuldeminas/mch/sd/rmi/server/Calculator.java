package br.edu.ifsuldeminas.mch.sd.rmi.server;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import br.edu.ifsuldeminas.mch.sd.rmi.remote.Operations;

public class Calculator implements Operations {

    private List<String> lastOperations = new ArrayList<String>();

    public Number sum(Number x, Number y) {
        Number result = x.doubleValue() + y.doubleValue();
        log(x, "+", y, result);
        return result;
    }

    public Number sub(Number x, Number y) {
        Number result = x.doubleValue() - y.doubleValue();
        log(x, "-", y, result);
        return result;
    }

    public Number mul(Number x, Number y) {
        Number result = x.doubleValue() * y.doubleValue();
        log(x, "*", y, result);
        return result;
    }

    public Number div(Number x, Number y) {
        Number result = Double.NaN;
        if (y.doubleValue() != 0) {
            result = x.doubleValue() / y.doubleValue();
        }
        log(x, "/", y, result);
        return result;
    }

    public Number sqrt(Number x) {
        double result = Math.sqrt(x.doubleValue());
        log(x, "√", null, result);
        return result;
    }

    public Number cbrt(Number x) {
        double result = Math.cbrt(x.doubleValue());
        log(x, "∛", null, result);
        return result;
    }
    
    public Number sqrt4(Number x) {
        double result = Math.pow(x.doubleValue(), 1.0 / 4.0);
        log(x, "√⁴", null, result);
        return result;
    }

    public Number sqrt5(Number x) {
        double result = Math.pow(x.doubleValue(), 1.0 / 5.0);
        log(x, "√⁵", null, result);
        return result;
    }

    public Number pow(Number base, int exponent) {
        double result = Math.pow(base.doubleValue(), exponent);
        log(base, "^" + exponent, null, result);
        return result;
    }

    public Number percent(Number total, Number percentage) {
        double result = total.doubleValue() * (percentage.doubleValue() / 100.0);
        log(total, "% of", percentage, result);
        return result;
    }

    public Number mod(Number x, Number y) {
        if (y.doubleValue() == 0) {
            throw new ArithmeticException("Divisão por zero");
        }
        Number result = x.doubleValue() % y.doubleValue();
        log(x, "%", y, result);
        return result;
    }

    public Number factorial(Number x) {
        int n = x.intValue();
        if (n < 0) {
            throw new ArithmeticException("Fatorial de número negativo não definido");
        }
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        log(x, "!", null, result);
        return result;
    }

    public List<String> lastOperations(int howMany) {
        if (lastOperations.size() < howMany) {
            return lastOperations();
        }
        return new ArrayList<>(lastOperations.subList(
                lastOperations.size() - howMany, lastOperations.size()));
    }

    public List<String> lastOperations() {
        return lastOperations;
    }

    private void log(Number operatorOne, String operation, Number operatorTwo, Number result) {
        String formattedOperation = String.format("%s %s %s = %s",
                operatorOne.toString(), operation, (operatorTwo != null ? operatorTwo.toString() : ""),
                result.toString());
        lastOperations.add(formattedOperation);
        System.out.printf("%s at %s\n", formattedOperation, new Date());
    }
}