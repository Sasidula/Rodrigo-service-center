package rodrigoservicecenter.model.entity;

public class InvoiceService {
    private int serviceInvoiceId;
    private int invoiceId;
    private Service service;

    // Constructors
    public InvoiceService() {}

    public InvoiceService(int serviceInvoiceId, int invoiceId, Service service) {
        this.serviceInvoiceId = serviceInvoiceId;
        this.invoiceId = invoiceId;
        this.service = service;
    }

    // Getters and setters
    public int getServiceInvoiceId() { return serviceInvoiceId; }
    public void setServiceInvoiceId(int serviceInvoiceId) { this.serviceInvoiceId = serviceInvoiceId; }

    public int getInvoiceId() { return invoiceId; }
    public void setInvoiceId(int invoiceId) { this.invoiceId = invoiceId; }

    public Service getService() { return service; }
    public void setService(Service service) { this.service = service; }
}
