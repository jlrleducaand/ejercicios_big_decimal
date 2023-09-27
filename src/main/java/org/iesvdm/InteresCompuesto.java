package org.iesvdm;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class InteresCompuesto {

    //ATRIBUTOS
    private BigDecimal p;
    private BigDecimal r;
    private int n;
    private BigDecimal c;

    // CONSTRUCTOR
    public InteresCompuesto(){};

    public InteresCompuesto(BigDecimal p, BigDecimal r, int n) {
        this.p = p;
        this.r = r;
        this.n = n;
    }
    // G & S
    public BigDecimal getP() { return p; }

    public void setP(BigDecimal p) {
        this.p = p;
    }

    public BigDecimal getR() {
        return r;
    }

    public void setR(BigDecimal r) {
        this.r = r;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public BigDecimal getC() {
        return c;
    }

    public void setC(BigDecimal c) {
        this.c = c;
    }


    // METODOS
    public BigDecimal calculaMontoFinal() {
        //TODO
        BigDecimal p = getP();
        BigDecimal c = getC();
        int n = getN();
        BigDecimal r = getR();

        c = p.multiply(BigDecimal.ONE.add(r.divide(BigDecimal.valueOf(100),3, RoundingMode.HALF_UP)).pow((n)));

        return c;
    }


}
