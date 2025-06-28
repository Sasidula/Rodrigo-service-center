package rodrigoservicecenter.model.entity;

import java.sql.Date;

public class ServiceRecord {
    private int recordId;
    private Appointment appointment;
    private Vehicle vehicle;
    private Customer customer;
    private Service service;
    private String description;
    private Date dateOfService;
    private int totalCost;

    public ServiceRecord(Appointment appointment, Customer customer, Date dateOfService, String description, int recordId, Service service, int totalCost, Vehicle vehicle) {
        this.appointment = appointment;
        this.customer = customer;
        this.dateOfService = dateOfService;
        this.description = description;
        this.recordId = recordId;
        this.service = service;
        this.totalCost = totalCost;
        this.vehicle = vehicle;
    }

    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateOfService() {
        return dateOfService;
    }

    public void setDateOfService(Date dateOfService) {
        this.dateOfService = dateOfService;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }
}
