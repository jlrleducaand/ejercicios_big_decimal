package org.iesvdm.onlineshopping;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.*;

public class ShoppingCart {
    public static int contCarts = 0;

    private String idCarts;
    private WebUser webUser;
    private LocalDate dateCart;
    private Account account;
    private Set<LineItem> listaItem;

    public ShoppingCart(WebUser webUser, Account account) {
        contCarts++;
        this.idCarts = contCarts+"";
        this.webUser = account.getCustomer().getWebUser();
        this.dateCart = LocalDate.now();
        this.account = account;
        this.listaItem = new LinkedHashSet<>();
    }

    public String getIdCarts() {  return idCarts;    }

    public WebUser getWebUser() { return webUser;    }

    public void setWebUser(WebUser webUser) { this.webUser = webUser;    }

    public LocalDate getDateCart() {  return dateCart;    }

    public Account getAccount() { return account;    }

    public Set<LineItem> getListaItem() { return listaItem;    }

    public void setListaItem(Set<LineItem> listaItem) { this.listaItem = listaItem;   }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingCart that = (ShoppingCart) o;
        return Objects.equals(idCarts, that.idCarts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCarts);
    }
}
