package org.iesvdm.onlineshopping;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class LineItem {
    public static int contLinea = 0;

    private String linea;
    private Order order;
    private ShoppingCart shoppingCart;
    private Integer quantity;
    private String producto;
    private String nombre;
    private BigDecimal Price;
    private BigDecimal subtotal;
    private LocalDate dateOrdered;

    public LineItem(Order order, Product producto, Integer quantity) {
        contLinea++;

        this.linea = contLinea+"";
        this.order = order;
        this.dateOrdered = LocalDate.now();
        this.quantity = quantity;
        this.producto = producto.getIdProducto();
        this.nombre = producto.getNombre();
        this.Price = producto.getPrecio();
        this.shoppingCart = this.getOrder().getAccount().getShoppingCart();
        // actualiza datos
        producto.setStock(producto.getStock()- this.getQuantity());                 // actualiza el stock de productos
        this.getOrder().getAccount().getShoppingCart().getListaItem().add(this);    // actualiza el carrito
        this.getOrder().getMyLines().add(this);                                     // actualiza el Order
        this.subtotal = this.getPrice().multiply(new BigDecimal(this.quantity));    // actualiza el subtotal de la linea
        this.getOrder().setTotal(this.subtotal);                                    // actualiza el total del Order


    }

    public Order getOrder() { return order; }

    public void setOrder(Order order) { this.order = order; }

    public Integer getQuantity() { return quantity; }

    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    public BigDecimal getPrice() { return Price; }

    public void setPrice(BigDecimal price) { Price = price; }

    public LocalDate getDateOrdered() { return dateOrdered; }

    public String getLinea() { return linea;  }

    public String getProducto() { return producto;  }

    public void setProducto(String producto) { this.producto = producto;  }

    public ShoppingCart getShoppingCart() { return shoppingCart;  }

    public void setShoppingCart(ShoppingCart shoppingCart) { this.shoppingCart = shoppingCart;  }

    public BigDecimal getSubtotal() { return subtotal;  }

    public void setSubtotal(BigDecimal subtotal) { this.subtotal = subtotal;  }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LineItem lineItem = (LineItem) o;
        return Objects.equals(order, lineItem.order) && Objects.equals(linea, lineItem.linea);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order, linea);
    }



}
