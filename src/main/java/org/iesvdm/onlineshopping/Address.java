package org.iesvdm.onlineshopping;

import java.util.Objects;

public class Address {
    private static int contId = 0;

    private String idAddress;
    private Customer customer;
    private String address;


    public Address(Customer customer, String address) {
        contId++;

        this.idAddress = contId+"";
        this.customer = customer;
        this.address = address;
    }
    public String getId(){return idAddress;}

    public Customer getCustomer() {return customer; }

    public String getAddress() {
        return address;
    }

    public void setAddress(String adress) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return idAddress.equals(address.idAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAddress);
    }
}
