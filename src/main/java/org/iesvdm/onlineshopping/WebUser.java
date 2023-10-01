package org.iesvdm.onlineshopping;

import java.util.Objects;

public class WebUser {
    public static int contId = 0;
    public enum UserState{
        NEW, ACTIVE, BLOCKED, BANNED
    }

    private String loginId;
    private String password;
    private UserState state;
    private Customer customer;
    private ShoppingCart shoppingCart;



    public WebUser(String password, Customer customer) {
        contId++;
        this.loginId = contId+"";
        this.password = password;
        this.customer = customer;
        this.shoppingCart = null;
        this.setState(UserState.NEW);
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserState getState() {
        return state;
    }

    public void setState(UserState state) {
        this.state = state;
    }
    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public Customer getCustomer() { return customer;  }

    public void setCustomer(Customer customer) { this.customer = customer;  }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WebUser webUser = (WebUser) o;
        return Objects.equals(loginId, webUser.loginId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(loginId);
    }
}
