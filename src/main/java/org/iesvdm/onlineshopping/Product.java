package org.iesvdm.onlineshopping;

import java.math.BigDecimal;
import java.util.Objects;

public class Product {

    private static int contProd =  0;

    private enum Supliers {
        UNO, DOS, TRES
    }

    private String idProducto;
    private int Stock;
    private String nombre;
    private String suplier;
    private BigDecimal precio;

    public Product(String nombre, String  distribuidor, double precio) {
        this.idProducto = idProducto;
        Stock = getStock();
        this.nombre = nombre;
        this.setSuplier(distribuidor);
        this.precio = BigDecimal.valueOf(precio);
    }

    public String getIdProducto() {  return idProducto;    }

    public void setIdProducto(String idProducto) {  this.idProducto = idProducto;    }

    public int getStock() {  return Stock;    }

    public void setStock(int stock) {  Stock = stock;    }

    public String getNombre() {  return nombre;    }

    public void setNombre(String nombre) {  this.nombre = nombre;    }

    public String getSuplier() {  return suplier;    }

    public void setSuplier(String suplier) {  this.suplier = suplier;    }

    public BigDecimal getPrecio() {  return precio;    }

    public void setPrecio(BigDecimal precio) {  this.precio = precio;    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(idProducto, product.idProducto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProducto);
    }
}
