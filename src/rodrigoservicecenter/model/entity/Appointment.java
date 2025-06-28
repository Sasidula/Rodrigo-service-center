package rodrigoservicecenter.model.entity;

import java.sql.Time;
import java.sql.Date;

public class Appointment {
    private int appointmentId;
    private Customer customer;
    private Vehicle vehicle;
    private ServiceOutlet outlet;
    private String status;
    private Service service;
    private String description;
    private Date scheduledDate;
    private Time scheduledTime;

    public Appointment(int appointmentId, Customer customer, Vehicle vehicle, ServiceOutlet outlet, String status, Service service, String description, Date scheduledDate, Time scheduledTime) {
        this.appointmentId = appointmentId;
        this.customer = customer;
        this.vehicle = vehicle;
        this.outlet = outlet;
        this.status = status;
        this.service = service;
        this.description = description;
        this.scheduledDate = scheduledDate;
        this.scheduledTime = scheduledTime;
    }

    public Appointment() {

    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public String getStatus() {
        return status;
    }

    public ServiceOutlet getOutlet() {
        return outlet;
    }

    public void setOutlet(ServiceOutlet outlet) {
        this.outlet = outlet;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public Date getScheduledDate() {
        return scheduledDate;
    }

    public void setScheduledDate(Date scheduledDate) {
        this.scheduledDate = scheduledDate;
    }

    public Time getScheduledTime() {
        return scheduledTime;
    }

    public void setScheduledTime(Time scheduledTime) {
        this.scheduledTime = scheduledTime;
    }
}
