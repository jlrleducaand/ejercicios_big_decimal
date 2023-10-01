package org.iesvdm.onlineshopping;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;


public class testWebCustomerAccount {
  @Test

  public void testWebCustomerAccount() {

    // Creo dos Customer / dos WebUser / dos Accounts  y los asigno entre ellos.
    Customer customer1 = new Customer("c/ paris,28", "555 555 555", "pepe@gmail.com");
    WebUser webUser1 = new WebUser("1234", customer1);
    Account account1 = new Account(customer1);
    customer1.setAccount(account1);
    customer1.setWebUser(webUser1);

    Customer customer2 = new Customer("c/ España,24", "666 666 666", "juan@gmail.com");
    WebUser webUser2 = new WebUser("1234", customer2);
    Account account2 = new Account(customer2);
    customer2.setAccount(account2);
    customer2.setWebUser(webUser2);

    // Prueba de Asserts
    Assertions.assertEquals("1", webUser1.getLoginId());
    Assertions.assertEquals("2", webUser2.getLoginId());
    Assertions.assertEquals("555 555 555", customer1.getPhone().getPhone());
    Assertions.assertEquals("666 666 666", customer2.getPhone().getPhone());


    // Creo productos
    Product producto1 = new Product("patatas", "UNO", 5.40);
    Product producto2 = new Product("zanahorias", "UNO", 0.99);
    Product producto3 = new Product("Calabacines" , "DOS", 1.10);

    // Creo dos ordenes
    Order order1 = new Order(account1);
    Order order2 = new Order(account2);

    // Añado lineas al carrito del WebUser/Customer
    webUser1.getCustomer().getAccount().getShoppingCart().getListaItem().add(new LineItem(order1,producto1, 2));
    webUser2.getCustomer().getAccount().getShoppingCart().getListaItem().add(new LineItem(order2,producto2, 5));
    webUser1.getCustomer().getAccount().getShoppingCart().getListaItem().add(new LineItem(order1,producto3, 3));

    // Añado dos pagos
    Paiment p1 = new Paiment(order1,"Pago de orden 1 ");
    Paiment p2 = new Paiment(order2, "pago de orden 2 ");

    // Prueba de Asserts
    Assertions.assertEquals(2, order1.getMyLines().size());
    Assertions.assertEquals(1, order2.getMyLines().size());

    Assertions.assertEquals(new BigDecimal(14.1),p1.getTotalBD());
    Assertions.assertEquals(new BigDecimal(4.95),p2.getTotalBD());

  }
}