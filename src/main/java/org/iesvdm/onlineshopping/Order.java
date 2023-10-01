package org.iesvdm.onlineshopping;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

public class Order {

    private static int contId = 0;
    public  enum OrderStatus{
        NEW, HOLD, SHIPPED, DELIVERED, CLOSED
    }

    private String idOrder;
    private Account account;
    private LocalDate dateOrdered;
    private LocalDate dateShipped;
    private Address Ship_To;
    private OrderStatus status;
    private BigDecimal total;
    private Set<LineItem> myLines ;
    private Paiment paiment;

    public Order(Account account) {
        contId++;
        this.myLines = new LinkedHashSet<>();

        this.account = account;
        this.idOrder = contId + "";
        this.dateOrdered = LocalDate.now();
        this.dateShipped = null;
        this.Ship_To = this.account.getCustomer().getAddress();
        this.setStatus(OrderStatus.NEW);
        this.total = calculoTotalOrden((LinkedHashSet<LineItem>) this.getMyLines());
        this.paiment = new Paiment(this, "");
        this.getAccount().getOrders().add(this);
    }


    public String getIdOrder() { return idOrder;    }

    public Account getAccount() { return account;    }

    public void setAccount(Account account) { this.account = account;    }

    public LocalDate getOrdered() { return dateOrdered;    }

    public void setOrdered(LocalDate dateOrdered) { this.dateOrdered = dateOrdered;    }

    public LocalDate getShipped() { return dateShipped;    }

    public void setShipped(LocalDate dateShipped) { this.dateShipped = dateOrdered;    }

    public Address getShip_To() { return Ship_To;    }

    public OrderStatus getStatus() { return status;    }

    public void setStatus(OrderStatus status) { this.status = status;    }

    public BigDecimal getTotal() { return total;    }

    public void setTotal(BigDecimal subtotal) { this.total.add(subtotal);  }

    public Set<LineItem> getMyLines() { return myLines;    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(idOrder, order.idOrder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idOrder);
    }

    public BigDecimal calculoTotalOrden(LinkedHashSet<LineItem> myLines){
        BigDecimal total = BigDecimal.ZERO;
        for (LineItem linea: myLines){
            total.add(linea.getSubtotal());
        }
        return total;
    }

}
