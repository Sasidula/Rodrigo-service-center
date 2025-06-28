package rodrigoservicecenter.model.entity;

public class InvoiceProduct {
    private int productInvoiceId;
    private int invoiceId;
    private Product product;
    private int quantity;

    // Constructors
    public InvoiceProduct() {}

    public InvoiceProduct(int productInvoiceId, int invoiceId, Product product, int quantity) {
        this.productInvoiceId = productInvoiceId;
        this.invoiceId = invoiceId;
        this.product = product;
        this.quantity = quantity;
    }

    // Getters and setters
    public int getProductInvoiceId() { return productInvoiceId; }
    public void setProductInvoiceId(int productInvoiceId) { this.productInvoiceId = productInvoiceId; }

    public int getInvoiceId() { return invoiceId; }
    public void setInvoiceId(int invoiceId) { this.invoiceId = invoiceId; }

    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}
