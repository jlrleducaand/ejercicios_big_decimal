package org.iesvdm.onlineshopping;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class Account {
    // static
    private static int contId = 0;


    private String id;
    private Customer customer;
    private Address billing_Address;
    private Phone phone;
    private boolean is_closed;
    private LocalDate opened;
    private LocalDate closed;
    private ShoppingCart shoppingCart;
    private Set<Paiment> paiments;
    private Set<Order>  orders;

    //Constructor
    public Account(Customer customer)
    {
        contId++;
        this.id = contId+"";
        this.customer = customer;
        this.shoppingCart = new ShoppingCart(this.getCustomer().getWebUser(), this);
        this.billing_Address = this.customer.getAddress();
        this.phone = this.customer.getPhone();
        this.is_closed = false;
        this.opened = LocalDate.now();
        this.closed = closed;
        this.paiments = new LinkedHashSet<>();
        this.orders = new LinkedHashSet<>();

    }


    public String getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Address getBilling_Address() {
        return billing_Address;
    }

    public void setBilling_Address(Address billing_Address) {
        this.billing_Address = billing_Address;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public boolean isIs_closed() {
        return is_closed;
    }

    public void setIs_closed(boolean is_closed) {
        this.is_closed = is_closed;
    }

    public LocalDate getOpened() {
        return opened;
    }

    public void setOpened(LocalDate opened) {
        this.opened = opened;
    }

    public LocalDate getClosed() {
        return closed;
    }

    public void setClosed(LocalDate closed) {
        this.closed = closed;
    }

    public ShoppingCart getShoppingCart() { return shoppingCart; }

    public void setShoppingList(ShoppingCart shoppingCart) { this.shoppingCart= shoppingCart;}

    public Set<Paiment> getPaiments() {
        return paiments;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(id, account.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
