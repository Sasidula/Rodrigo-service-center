package rodrigoservicecenter.model;

import rodrigoservicecenter.connect.connect;
import rodrigoservicecenter.model.entity.*;

import java.sql.*;

public class InvoiceModel {

    public Invoice createInvoice(Invoice invoice) {
        connect db = new connect();
        Connection con = db.createConnection();

        String invoiceSql = "INSERT INTO invoice (customerId, issueDate, dueDate, totalAmount, paymentStatus) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = con.prepareStatement(invoiceSql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, invoice.getCustomer().getCustomerId());
            stmt.setDate(2, new java.sql.Date(invoice.getIssueDate().getTime()));
            stmt.setDate(3, new java.sql.Date(invoice.getDueDate().getTime()));
            stmt.setInt(4, invoice.getTotalAmount());
            stmt.setString(5, invoice.getPaymentStatus());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            int invoiceId = -1;
            if (rs.next()) {
                invoiceId = rs.getInt(1);
            }

            /*if(invoice.getProducts().isEmpty() && invoice.getServices().isEmpty()){
                System.out.println("Nothing Selected");
                return null;
            } else if(invoice.getProducts().isEmpty() && !invoice.getServices().isEmpty()){
                // Save products
                for (Product p : invoice.getProducts()) {
                    InvoiceProductModel ipc = new InvoiceProductModel();
                    ipc.createInvoiceProduct(new InvoiceProduct(0, invoiceId, p, 1));
                }
            } else if(!invoice.getProducts().isEmpty() && invoice.getServices().isEmpty()){
                // Save services
                for (Service s : invoice.getServices()) {
                    InvoiceServiceModel isc = new InvoiceServiceModel();
                    isc.createInvoiceService(new InvoiceService(0, invoiceId, s));
                }
            }*/

            return invoice;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
