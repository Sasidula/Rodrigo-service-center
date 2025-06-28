package rodrigoservicecenter.model;

import rodrigoservicecenter.connect.connect;
import rodrigoservicecenter.model.entity.Supplier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SupplierModel {

    public Supplier getSupplierById(int Id) {
        Supplier supplier = null;
        connect db = new connect();
        Connection con = db.createConnection();

        String sql = "SELECT * FROM Supplier WHERE supplierId = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, Id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int supplierId = rs.getInt("supplierId");
                String supplierName = rs.getString("supplierName");
                String address = rs.getString("address");
                int contactNumber = rs.getInt("contactNumber");
                String email = rs.getString("email");

                supplier = new Supplier( address, contactNumber, email, supplierId, supplierName);
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

        return supplier;
    }

}
