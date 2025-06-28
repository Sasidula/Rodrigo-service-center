package rodrigoservicecenter.model;

import rodrigoservicecenter.connect.connect;
import rodrigoservicecenter.model.entity.Department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DepartmentModel {

    public Department getDepartmentById(int departmentId) {
        Department department = null;
        connect db = new connect();
        Connection con = db.createConnection();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Department WHERE departmentId = ?");
            ps.setInt(1, departmentId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("departmentId");
                String name = rs.getString("departmentName");
                String location = rs.getString("location");
                department = new Department(id, name, location);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return department;
    }

}
