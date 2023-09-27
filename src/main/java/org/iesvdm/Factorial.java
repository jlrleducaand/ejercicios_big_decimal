package org.iesvdm;

import java.math.BigInteger;


public class Factorial {
    // Atributos
    private long n;
    private BigInteger factorial;

    // G & S
    public long getN() {
        return n;
    }

    public void setN(long n) {
        this.n = n;
    }

    public BigInteger getFactorial() {
        return factorial;
    }

    public void setFactorial(BigInteger factorial) {
        this.factorial = factorial;
    }

    // Metodos
    public Factorial(long n) {
        if ( n >= 0)
            this.n = n;
        else
            throw new RuntimeException("Valor " + n + " no permitido.");
    }

    public BigInteger calcula() {
        //TODO
        this.factorial = BigInteger.ONE;

        for (long i = 2; i <= n; i++) {
            //System.out.println("Factorial de" + i);
            this.factorial = this.factorial.multiply(BigInteger.valueOf(i));
            //System.out.println(this.factorial);
        }

        return this.factorial;
    }
}
