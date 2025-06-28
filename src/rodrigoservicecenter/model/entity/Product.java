package rodrigoservicecenter.model.entity;

public class Product {
    private int productId;
    private String productName;
    private String category;
    private ServiceOutlet outlet;
    private String vehicleCompatibility;
    private String brand;
    private String description;
    private int unitPrice;
    private Supplier supplier;

    public Product(int productId, String productName, String category, ServiceOutlet outlet, String vehicleCompatibility, String brand, String description, int unitPrice, Supplier supplier) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.outlet = outlet;
        this.vehicleCompatibility = vehicleCompatibility;
        this.brand = brand;
        this.description = description;
        this.unitPrice = unitPrice;
        this.supplier = supplier;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public ServiceOutlet getOutlet() {
        return outlet;
    }

    public void setOutlet(ServiceOutlet outlet) {
        this.outlet = outlet;
    }

    public String getVehicleCompatibility() {
        return vehicleCompatibility;
    }

    public void setVehicleCompatibility(String vehicleCompatibility) {
        this.vehicleCompatibility = vehicleCompatibility;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
}
