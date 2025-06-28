package rodrigoservicecenter.model;

import rodrigoservicecenter.connect.connect;
import rodrigoservicecenter.model.entity.ServiceOutlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ServiceOutletModel {

    public ServiceOutlet getOutletById(int Id) {
        ServiceOutlet serviceOutlet = null;
        connect db = new connect();
        Connection con = db.createConnection();

        String sql = "SELECT * FROM ServiceOutlet WHERE outletId = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, Id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int outletId = rs.getInt("outletId");
                String name = rs.getString("outletName");
                String address = rs.getString("location");
                int contactNumber = rs.getInt("contactNumber");
                String email = rs.getString("email");

                serviceOutlet = new ServiceOutlet( outletId, name, address, contactNumber, email);
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

        return serviceOutlet;
    }

}
