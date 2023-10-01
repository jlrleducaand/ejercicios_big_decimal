package org.iesvdm.onlineshopping;

import java.util.Objects;

public class Customer {
    private static int contId =0;

    private String id;
    private Address address;
    private Phone phone;
    private String email;
    private Account account;
    private WebUser webUser;



    public Customer(String address, String phone, String email) {
        contId++;
        this.id = contId+"";
        this.address = new Address(this,address );
        this.phone = new Phone(this, phone);
        this.email = email;
        this.account = null;
        this.webUser = null;



    }

    public Account getAccount() { return account; }

    public void setAccount(Account account) { this.account = account; }

    public String getId() { return id; }

    public Address getAddress() {  return address; }

    public void setAddress(Address address) { this.address = address; }

    public Phone getPhone() { return phone; }

    public void setPhone(Phone phone) { this.phone = phone; }

    public String getEmail() { return email;  }

    public void setEmail(String email) { this.email = email; }

    public WebUser getWebUser() {  return webUser;  }

    public void setWebUser(WebUser webUser) { this.webUser = webUser; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
