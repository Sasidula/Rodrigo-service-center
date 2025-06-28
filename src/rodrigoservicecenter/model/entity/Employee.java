package rodrigoservicecenter.model.entity;

import java.sql.Date;

public class Employee {
    private int employeeId;
    private int nic;
    private String name;
    private String password;
    private String roleName;
    private int phone;
    private String email;
    private String address;
    private Date dateOfJoining;
    private Date dateOfBirth;
    private ServiceOutlet outlet;
    private Department department;

    public Employee(int employeeId, int nic, String name, String password, String roleName, int phone, String email, String address, Date dateOfJoining, Date dateOfBirth, ServiceOutlet outlet, Department department) {
        this.employeeId = employeeId;
        this.nic = nic;
        this.name = name;
        this.password = password;
        this.roleName = roleName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.dateOfJoining = dateOfJoining;
        this.dateOfBirth = dateOfBirth;
        this.outlet = outlet;
        this.department = department;
    }

    public int getNic() {
        return nic;
    }

    public void setNic(int nic) {
        this.nic = nic;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(Date dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public ServiceOutlet getOutlet() {
        return outlet;
    }

    public void setOutlet(ServiceOutlet outlet) {
        this.outlet = outlet;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
