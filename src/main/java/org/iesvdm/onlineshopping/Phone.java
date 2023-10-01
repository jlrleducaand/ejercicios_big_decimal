package org.iesvdm.onlineshopping;

import java.util.Objects;

public class Phone {

    private Customer customer;
    private String phone;

    public Phone(Customer customer, String phone) {
        this.customer = customer;
        this.phone = phone;
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Phone phone1 = (Phone) o;
        return Objects.equals(customer, phone1.customer) && Objects.equals(phone, phone1.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customer, phone);
    }
}
