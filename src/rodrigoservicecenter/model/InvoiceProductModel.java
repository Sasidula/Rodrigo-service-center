package rodrigoservicecenter.model;

import rodrigoservicecenter.connect.connect;
import rodrigoservicecenter.model.entity.InvoiceProduct;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InvoiceProductModel {

    public boolean createInvoiceProduct(InvoiceProduct invoiceProduct) {
        connect db = new connect();
        Connection con = db.createConnection();

        String sql = "INSERT INTO invoice_product (invoiceId, productId, quantity) VALUES (?, ?, ?)";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, invoiceProduct.getInvoiceId());
            stmt.setInt(2, invoiceProduct.getProduct().getProductId());
            stmt.setInt(3, invoiceProduct.getQuantity());

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
