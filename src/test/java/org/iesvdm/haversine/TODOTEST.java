package org.iesvdm.haversine;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class TODOTEST {
    @Test
    public void Test()
    {
        Posicion Igualada = new Posicion(41.57879F,  1.617221F);
        Posicion Granada = new Posicion(37.176487F, -3.597929F);
        BigDecimal distancia =
                Igualada.distanciaKm(Granada);
        Assertions.assertEquals((new BigDecimal(664.0D)),distancia);
    }
}
