package rodrigoservicecenter.model;

import rodrigoservicecenter.connect.connect;
import rodrigoservicecenter.model.entity.Payment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PaymentModel {

    public boolean AddPayment(Payment payment) {
        connect db = new connect();
        Connection con = db.createConnection();

        String sql = "INSERT INTO payment (customerId, invoiceId, totalAmount, paymentDate, paymentMethod, paymentStatus) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, payment.getCustomer().getCustomerId());
            stmt.setInt(2, payment.getInvoice().getInvoiceId());
            stmt.setInt(3, payment.getTotalAmount());
            stmt.setDate(4, new java.sql.Date(payment.getPaymentDate().getTime()));
            stmt.setString(5, payment.getPaymentMethod());
            stmt.setString(6, payment.getPaymentStatus());

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
