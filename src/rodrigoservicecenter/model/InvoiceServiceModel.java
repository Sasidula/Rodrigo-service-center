package rodrigoservicecenter.model;

import rodrigoservicecenter.connect.connect;
import rodrigoservicecenter.model.entity.InvoiceService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InvoiceServiceModel {

    public boolean createInvoiceService(InvoiceService invoiceService) {
        connect db = new connect();
        Connection con = db.createConnection();

        String sql = "INSERT INTO invoice_service (invoiceId, serviceId) VALUES (?, ?)";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, invoiceService.getInvoiceId());
            stmt.setInt(2, invoiceService.getService().getServiceId());

            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
