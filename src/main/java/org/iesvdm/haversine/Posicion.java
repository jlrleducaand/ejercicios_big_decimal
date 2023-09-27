package org.iesvdm.haversine;

import java.math.BigDecimal;
import java.math.MathContext;

public class Posicion {

    public BigDecimal longitud;
    public BigDecimal latitud;

    public Posicion(float longitud, float latitud) {
        this.longitud = new BigDecimal(longitud);
        this.latitud = new BigDecimal(latitud);
    }

    public BigDecimal getLongitud() {
        return longitud;
    }

    public void setLongitud(float longitud) {
        this.longitud = new BigDecimal(longitud);
    }

    public BigDecimal getLatitud() {
        return latitud;
    }

    public void setLatitud(float latitud) {
        this.latitud = new BigDecimal(latitud);
    }



    public BigDecimal distanciaKm(Posicion p2) {
        //TODO
        //a = sin²(Δlat/2) + cos(lat1) · cos(lat2) · sin²(Δlong/2)

        BigDecimal R = new BigDecimal("6371"); // Radio de la Tierra en kilómetros
        MathContext mc = new MathContext(10); // Contexto de precisión para los cálculos

        BigDecimal dLat = BigDecimal.valueOf(Math.toRadians(this.latitud.floatValue() - ((p2.getLatitud().floatValue()))));
        BigDecimal dLon = BigDecimal.valueOf(Math.toRadians(this.longitud.floatValue() - ((p2.getLongitud().floatValue()))));

        BigDecimal a =(
                // Cuadrado 1
                (new BigDecimal (Math.sin(dLat.divide(new BigDecimal("2"), mc).doubleValue()), mc)).pow(2)
                //Suma
                .add(new BigDecimal(Math.cos(Math.toRadians(this.latitud.doubleValue())))
                // Multiplicacion intermedia
                        .multiply(new BigDecimal(Math.cos(Math.toRadians(p2.latitud.doubleValue())))
                // cuadrado 2
                        .multiply(new BigDecimal(Math.sin(dLon.divide(new BigDecimal("2"), mc).doubleValue()), mc), mc).pow(2))));

        BigDecimal c = new BigDecimal(2).multiply(new BigDecimal(Math.atan2(Math.sqrt(a.doubleValue()), Math.sqrt(1 - a.doubleValue())), mc), mc);

        BigDecimal distance = R.multiply(c, mc);

        return distance;
    }

}
