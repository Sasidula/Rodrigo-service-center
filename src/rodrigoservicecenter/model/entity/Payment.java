package rodrigoservicecenter.model.entity;

import java.sql.Date;

public class Payment {
    private int paymentId;
    private Customer customer;
    private Invoice invoice;
    private int totalAmount;
    private Date paymentDate;
    private String paymentMethod;
    private String paymentStatus;

    // Constructors
    public Payment() {}

    public Payment(int paymentId, Customer customer, Invoice invoice,
                   int totalAmount, Date paymentDate, String paymentMethod, String paymentStatus) {
        this.paymentId = paymentId;
        this.customer = customer;
        this.invoice = invoice;
        this.totalAmount = totalAmount;
        this.paymentDate = paymentDate;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
    }

    // Getters and setters
    public int getPaymentId() { return paymentId; }
    public void setPaymentId(int paymentId) { this.paymentId = paymentId; }

    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }

    public Invoice getInvoice() { return invoice; }
    public void setInvoice(Invoice invoice) { this.invoice = invoice; }

    public int getTotalAmount() { return totalAmount; }
    public void setTotalAmount(int totalAmount) { this.totalAmount = totalAmount; }

    public Date getPaymentDate() { return paymentDate; }
    public void setPaymentDate(Date paymentDate) { this.paymentDate = paymentDate; }

    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }

    public String getPaymentStatus() { return paymentStatus; }
    public void setPaymentStatus(String paymentStatus) { this.paymentStatus = paymentStatus; }
}
