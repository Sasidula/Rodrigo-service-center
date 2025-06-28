package rodrigoservicecenter.model.entity;

public class ServiceOutlet {
    private int outletId;
    private String outletName;
    private String location;
    private int contactNumber;
    private String email;

    public ServiceOutlet(int outletId, String outletName, String location, int contactNumber, String email) {
        this.outletId = outletId;
        this.outletName = outletName;
        this.location = location;
        this.contactNumber = contactNumber;
        this.email = email;
    }

    public int getOutletId() {
        return outletId;
    }

    public void setOutletId(int outletId) {
        this.outletId = outletId;
    }

    public String getOutletName() {
        return outletName;
    }

    public void setOutletName(String outletName) {
        this.outletName = outletName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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
