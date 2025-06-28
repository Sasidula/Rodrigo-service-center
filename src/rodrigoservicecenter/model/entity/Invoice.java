package rodrigoservicecenter.model.entity;

import java.sql.Date;
import java.util.List;

public class Invoice {
    private int invoiceId;
    private Customer customer;
    private Date issueDate;
    private Date dueDate;
    private List<Product> products;
    private List<Service> services;
    private int totalAmount;
    private String paymentStatus;

    // Constructors
    public Invoice() {}

    public Invoice(int invoiceId, Customer customer, Date issueDate, Date dueDate,
                   List<Product> products, List<Service> services,
                   int totalAmount, String paymentStatus) {
        this.invoiceId = invoiceId;
        this.customer = customer;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
        this.products = products;
        this.services = services;
        this.totalAmount = totalAmount;
        this.paymentStatus = paymentStatus;
    }

    // Getters and setters
    public int getInvoiceId() { return invoiceId; }
    public void setInvoiceId(int invoiceId) { this.invoiceId = invoiceId; }

    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }

    public Date getIssueDate() { return issueDate; }
    public void setIssueDate(Date issueDate) { this.issueDate = issueDate; }

    public Date getDueDate() { return dueDate; }
    public void setDueDate(Date dueDate) { this.dueDate = dueDate; }

    public List<Product> getProducts() { return products; }
    public void setProducts(List<Product> products) { this.products = products; }

    public List<Service> getServices() { return services; }
    public void setServices(List<Service> services) { this.services = services; }

    public int getTotalAmount() { return totalAmount; }
    public void setTotalAmount(int totalAmount) { this.totalAmount = totalAmount; }

    public String getPaymentStatus() { return paymentStatus; }
    public void setPaymentStatus(String paymentStatus) { this.paymentStatus = paymentStatus; }
}
