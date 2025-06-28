package rodrigoservicecenter.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import rodrigoservicecenter.connect.connect;
import rodrigoservicecenter.model.entity.Appointment;
import rodrigoservicecenter.model.entity.ServiceRecord;

public class ServiceRecordModel {

    AppointmentModel appointmentModel = new AppointmentModel();

    public boolean createServiceRecord(ServiceRecord record) {
        connect db = new connect();
        Connection con = db.createConnection();
        boolean success = false;

        String sql = "INSERT INTO ServiceRecord (recordId, appointmentId, vehicleId, customerId, serviceId, description, dateOfService, totalCost) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, record.getRecordId());
            ps.setInt(2, record.getAppointment().getAppointmentId());
            ps.setInt(3, record.getVehicle().getVehicleId());
            ps.setInt(4, record.getCustomer().getCustomerId());
            ps.setInt(5, record.getService().getServiceId());
            ps.setString(6, record.getDescription());
            ps.setDate(7, record.getDateOfService());
            ps.setInt(8, record.getTotalCost());

            int rows = ps.executeUpdate();
            success = rows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return success;
    }
}
