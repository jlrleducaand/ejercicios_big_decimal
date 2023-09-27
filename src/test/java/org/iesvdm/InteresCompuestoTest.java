package org.iesvdm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class InteresCompuestoTest {

    @Test
    public void cuandoPrincipal1000Interes5porcientoY10peridos() {

        String principal = "1000";
        int interes = 5;
        int periodos = 10;

        //TODO

        InteresCompuesto interesCompuesto = new InteresCompuesto();
        interesCompuesto.setP(new BigDecimal(principal));
        interesCompuesto.setR(new BigDecimal(interes));
        interesCompuesto.setN(periodos);

        BigDecimal cantidadFinal = interesCompuesto.calculaMontoFinal().setScale(2, RoundingMode.HALF_UP);

        Assertions.assertEquals(new BigDecimal("1628.89"), cantidadFinal);

    }

}
