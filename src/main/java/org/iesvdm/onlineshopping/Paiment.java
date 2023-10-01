package org.iesvdm.onlineshopping;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Paiment {
    private static int contId = 0;


    private String idPaiment;
    private Account account;
    private Order order;
    private LocalDate datePaiment;
    private BigDecimal TotalBD;
    private String datails;
    private boolean paimentStatus;

    public Paiment(Order order, String datails) {
        contId++;

        this.idPaiment = contId+"";
        this.order = order;
        this.account = this.getAccount();
        this.datePaiment = LocalDate.now();
        this.TotalBD = this.order.getTotal();
        this.datails = datails;
        this.paimentStatus = false;
    }

    public String getIdPaiment() { return idPaiment; }

    public Account getAccount() { return account; }

    public Order getOrder() { return order; }

    public LocalDate getDatePaiment() { return datePaiment; }

    public void setDatePaiment(LocalDate datePaiment) { this.datePaiment = datePaiment; }

    public BigDecimal getTotalBD() { return TotalBD; }

    public String getDatails() { return datails; }

    public void setDatails(String datails) { this.datails = datails; }

    public boolean isPaimentStatus() {  return paimentStatus; }

    public void setPaimentStatus(boolean paimentStatus) { this.paimentStatus = paimentStatus; }
}
