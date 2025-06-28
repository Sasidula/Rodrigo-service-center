package rodrigoservicecenter.controller;

import rodrigoservicecenter.model.EmployeeModel;
import rodrigoservicecenter.model.entity.Employee;

public class EmployeeController {

    public Employee loginEmployee(String username, String password) {
        EmployeeModel employeeModel = new EmployeeModel();
        return employeeModel.loginEmployee(username, password);
    }

}
