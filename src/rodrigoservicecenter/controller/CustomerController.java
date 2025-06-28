package rodrigoservicecenter.controller;

import rodrigoservicecenter.model.CustomerModel;
import rodrigoservicecenter.model.InvoiceModel;
import rodrigoservicecenter.model.VehicleModel;
import rodrigoservicecenter.model.entity.Customer;
import rodrigoservicecenter.model.entity.Invoice;
import rodrigoservicecenter.model.entity.Vehicle;

import java.util.List;

public class CustomerController {

    public List<Customer> getAllCustomers(){
        CustomerModel customerModel = new CustomerModel();
        return customerModel.getAllCustomers();
    }

    public Customer addCustomer(Customer customer){
        CustomerModel customerModel = new CustomerModel();
        return customerModel.addCustomer(customer);
    }

    public boolean updateCustomer(Customer customer){
        CustomerModel customerModel = new CustomerModel();
        return customerModel.updateCustomer(customer);
    }

    public boolean deleteCustomer(int id){
        CustomerModel customerModel = new CustomerModel();
        return customerModel.deleteCustomer(id);
    }

    public Customer getCustomerById(int id){
        CustomerModel customerModel = new CustomerModel();
        return customerModel.getCustomerById(id);
    }

    public List<Customer> searchCustomers(String keyword) {
        CustomerModel customerModel = new CustomerModel();
        return customerModel.searchCustomersByName(keyword);
    }

    public Customer loginCustomer(String username, String password) {
        CustomerModel customerModel = new CustomerModel();
        return customerModel.loginCustomer(username, password);
    }

    public Customer getCustomerByContactNumber(int contactNumber) {
        CustomerModel customerModel = new CustomerModel();
        return customerModel.getCustomerByContactNumber(contactNumber);
    }

    public Invoice createInvoice(Invoice invoice) {
        InvoiceModel invoiceModel = new InvoiceModel();
        return invoiceModel.createInvoice(invoice);
    }

    public Vehicle getVehicleById(int id) {
        VehicleModel vehicleModel = new VehicleModel();
        return vehicleModel.getVehicleById(id);
    }

    public Vehicle getVehicleByCustomerId(int id) {
        VehicleModel vehicleModel = new VehicleModel();
        return vehicleModel.getVehicleByCustomerId(id);
    }

    public boolean updateVehicle(Vehicle vehicle) {
        VehicleModel vehicleModel = new VehicleModel();
        return vehicleModel.updateVehicle(vehicle);
    }

    public boolean addVehicle(Vehicle vehicle) {
        VehicleModel vehicleModel = new VehicleModel();
        return vehicleModel.addVehicle(vehicle);
    }

}
