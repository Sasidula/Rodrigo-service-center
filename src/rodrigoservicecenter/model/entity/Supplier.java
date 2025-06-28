package rodrigoservicecenter.model.entity;

public class Supplier {
    private int supplierId;
    private String supplierName;
    private String address;
    private int contactNumber;
    private String email;

    public Supplier(String address, int contactNumber, String email, int supplierId, String supplierName) {
        this.address = address;
        this.contactNumber = contactNumber;
        this.email = email;
        this.supplierId = supplierId;
        this.supplierName = supplierName;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(int contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
