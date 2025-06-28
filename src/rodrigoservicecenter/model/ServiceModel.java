package rodrigoservicecenter.model;

import rodrigoservicecenter.connect.connect;
import rodrigoservicecenter.model.entity.Service;

import java.sql.*;

public class ServiceModel {

    public Service getServiceById(int Id) {
        Service service = null;
        connect db = new connect();
        Connection con = db.createConnection();

        String sql = "SELECT * FROM Service WHERE serviceId = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, Id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int serviceId = rs.getInt("serviceId");
                String serviceName = rs.getString("serviceName");
                String description = rs.getString("description");
                Time estimatedDuration = rs.getTime("estimatedDuration");
                String vehicleCompatibility = rs.getString("vehicleCompatibility");
                int price = rs.getInt("price");

                service = new Service(serviceId, serviceName, description, estimatedDuration, vehicleCompatibility, price);
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

        return service;

    }

}
