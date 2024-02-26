package com.comprrhensiveAssisgnments;

public class ProgramOneInvoiceItemDemo 
{
private String invoiceId;
private String invoiceDesc;
private int invoiceQty;
private double invoiceItemPrice;

public ProgramOneInvoiceItemDemo(String invoiceId, String invoiceDesc, int invoiceQty, double invoiceItemPrice) {
    this.invoiceId = invoiceId;
    this.invoiceDesc = invoiceDesc;
    this.invoiceQty = invoiceQty;
    this.invoiceItemPrice = invoiceItemPrice;
}

public String getInvoiceId() {
    return invoiceId;
}

public void setInvoiceId(String invoiceId) {
    this.invoiceId = invoiceId;
}

public String getInvoiceDesc() {
    return invoiceDesc;
}

public void setInvoiceDesc(String invoiceDesc) {
    this.invoiceDesc = invoiceDesc;
}

public int getInvoiceQty() {
    return invoiceQty;
}

public void setInvoiceQty(int invoiceQty) {
    this.invoiceQty = invoiceQty;
}

public double getInvoiceItemPrice() {
    return invoiceItemPrice;
}

public void setInvoiceItemPrice(double invoiceItemPrice) {
    this.invoiceItemPrice = invoiceItemPrice;
}

public void calculateTotalPrice() {
    if (invoiceQty == 1) {
        System.out.println("Total Price: " + invoiceItemPrice);
    } else if (invoiceQty > 1) {
        double totalPrice = invoiceItemPrice * invoiceQty;
        System.out.println("Total Price: " + totalPrice);
    } else {
        System.out.println("Invalid quantity.");
    }
}

public static void main(String[] args) {
    
    ProgramOneInvoiceItemDemo invoiceItem = new ProgramOneInvoiceItemDemo("123", "Product 1", 2, 10.5);
    
    
    System.out.println("Invoice ID: " + invoiceItem.getInvoiceId());
    System.out.println("Invoice Description: " + invoiceItem.getInvoiceDesc());
    System.out.println("Invoice Quantity: " + invoiceItem.getInvoiceQty());
    System.out.println("Invoice Item Price: " + invoiceItem.getInvoiceItemPrice());
    invoiceItem.calculateTotalPrice();
}
}