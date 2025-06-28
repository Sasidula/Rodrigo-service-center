package rodrigoservicecenter.model;

import rodrigoservicecenter.connect.connect;
import rodrigoservicecenter.model.entity.Department;
import rodrigoservicecenter.model.entity.Employee;
import rodrigoservicecenter.model.entity.ServiceOutlet;

import java.sql.*;

public class EmployeeModel {

    DepartmentModel departmentModel = new DepartmentModel();
    ServiceOutletModel serviceOutletModel = new ServiceOutletModel();

    // Login
    public Employee loginEmployee(String username, String password) {
        Employee employee = null;
        connect db = new connect();
        Connection con = db.createConnection();

        String sql = "SELECT * FROM Employee WHERE name = ? AND password = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int employeeId = rs.getInt("employeeId");
                int nic = rs.getInt("nic");
                String name = rs.getString("name");
                String pass = rs.getString("password");
                String roleName = rs.getString("roleName");
                int phone = rs.getInt("phone");
                String email = rs.getString("email");
                String address = rs.getString("address");
                Date dateOfJoining = rs.getDate("dateOfJoining");
                Date dateOfBirth = rs.getDate("dateOfBirth");
                ServiceOutlet outlet = serviceOutletModel.getOutletById(rs.getInt("outletId"));
                Department department = departmentModel.getDepartmentById(rs.getInt("departmentId"));

                employee = new Employee(employeeId, nic, name, pass,  roleName, phone, email, address, dateOfJoining, dateOfBirth, outlet, department);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return employee;
    }

}
