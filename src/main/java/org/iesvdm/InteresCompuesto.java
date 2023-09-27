package org.iesvdm;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class InteresCompuesto {

    //ATRIBUTOS
    private BigDecimal principal;
    private BigDecimal rate;
    private int nPeriodos;
    private BigDecimal capital;

    // CONSTRUCTOR
    public InteresCompuesto(){};

    public InteresCompuesto(BigDecimal p, BigDecimal r, int n) {
        this.principal = p;
        this.rate = r;
        this.nPeriodos = n;
    }
    // G & S
    public BigDecimal getP() { return principal; }

    public void setP(BigDecimal p) {
        this.principal = p;
    }

    public BigDecimal getR() {
        return rate;
    }

    public void setR(BigDecimal r) {
        this.rate = r;
    }

    public int getN() {
        return nPeriodos;
    }

    public void setN(int n) {
        this.nPeriodos = n;
    }

    public BigDecimal getC() {
        return capital;
    }

    public void setC(BigDecimal c) {
        this.capital = c;
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
