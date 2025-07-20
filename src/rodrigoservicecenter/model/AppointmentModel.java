package rodrigoservicecenter.model;

import rodrigoservicecenter.connect.connect;
import rodrigoservicecenter.model.entity.Appointment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AppointmentModel {

    private final CustomerModel customerModel = new CustomerModel();
    private final VehicleModel vehicleModel = new VehicleModel();
    private final ServiceOutletModel serviceOutletModel = new ServiceOutletModel();
    private final ServiceModel serviceModel = new ServiceModel();

    // Create an appointment
    public boolean createAppointment(Appointment appointment) {
        connect db = new connect();
        Connection con = db.createConnection();

        String sql = "INSERT INTO Appointment (customerId, vehicleId, outletId, status, serviceId, description, scheduledDate, scheduledTime) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, appointment.getCustomer().getCustomerId());
            ps.setInt(2, appointment.getVehicle().getVehicleId());
            ps.setInt(3, appointment.getOutlet().getOutletId());
            ps.setString(4, appointment.getStatus());
            ps.setInt(5, appointment.getService().getServiceId());
            ps.setString(6, appointment.getDescription());
            ps.setDate(7, appointment.getScheduledDate());
            ps.setTime(8, appointment.getScheduledTime());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    int generatedId = rs.getInt(1);
                    appointment.setAppointmentId(generatedId);
                }
                return true;
            } else {
                return false;
            }

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



    // Update an existing appointment
    public boolean updateAppointment(Appointment appointment) {
        connect db = new connect();
        Connection con = db.createConnection();

        String sql = "UPDATE Appointment SET customerId = ?, vehicleId = ?, outletId = ?, status = ?, serviceId = ?, description = ?, scheduledDate = ?, scheduledTime = ? "
                + "WHERE appointmentId = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, appointment.getCustomer().getCustomerId());
            ps.setInt(2, appointment.getVehicle().getVehicleId());
            ps.setInt(3, appointment.getOutlet().getOutletId());
            ps.setString(4, appointment.getStatus());
            ps.setInt(5, appointment.getService().getServiceId());
            ps.setString(6, appointment.getDescription());
            ps.setDate(7, appointment.getScheduledDate());
            ps.setTime(8, appointment.getScheduledTime());
            ps.setInt(9, appointment.getAppointmentId());

            int rows = ps.executeUpdate();
            return rows > 0;

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


    // Delete an existing appointment
    public boolean deleteAppointment(int appointmentId) {
        connect db = new connect();
        Connection con = db.createConnection();

        String sql = "DELETE FROM Appointment WHERE appointmentId = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, appointmentId);

            int rows = ps.executeUpdate();
            return rows > 0;

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


    //
    public Appointment getAppointmentById(int appointmentId) {
        connect db = new connect();
        Connection con = db.createConnection();

        String sql = "SELECT * FROM Appointment WHERE appointmentId = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, appointmentId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Appointment(
                        rs.getInt("appointmentId"),
                        customerModel.getCustomerById(rs.getInt("customerId")),
                        vehicleModel.getVehicleById(rs.getInt("vehicleId")),
                        serviceOutletModel.getOutletById(rs.getInt("OutletId")),
                        rs.getString("status"),
                        serviceModel.getServiceById(rs.getInt("serviceId")),
                        rs.getString("description"),
                        rs.getDate("scheduledDate"),
                        rs.getTime("scheduledTime")
                );
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

        return null;
    }

    public List<Appointment> searchAppointments(Date date, Time time, Integer outletId) {
        connect db = new connect();
        Connection con = db.createConnection();
        List<Appointment> list = new ArrayList<>();

        StringBuilder sql = new StringBuilder("SELECT * FROM Appointment WHERE 1=1");

        if (date != null) {
            sql.append(" AND scheduledDate = ?");
        }
        if (time != null) {
            sql.append(" AND scheduledTime = ?");
        }
        if (outletId != null) {
            sql.append(" AND outletId = ?");
        }

        try {
            PreparedStatement ps = con.prepareStatement(sql.toString());

            int index = 1;
            if (date != null) {
                ps.setDate(index++, date);
            }
            if (time != null) {
                ps.setTime(index++, time);
            }
            if (outletId != null) {
                ps.setInt(index++, outletId);
            }

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Appointment appointment = new Appointment(
                        rs.getInt("appointmentId"),
                        customerModel.getCustomerById(rs.getInt("customerId")),
                        vehicleModel.getVehicleById(rs.getInt("vehicleId")),
                        serviceOutletModel.getOutletById(rs.getInt("OutletId")),
                        rs.getString("status"),
                        serviceModel.getServiceById(rs.getInt("serviceId")),
                        rs.getString("description"),
                        rs.getDate("scheduledDate"),
                        rs.getTime("scheduledTime")
                );
                list.add(appointment);
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

        return list;
    }

    public List<Appointment> getAllAppointments() {
        connect db = new connect();
        Connection con = db.createConnection();
        List<Appointment> list = new ArrayList<>();

        String sql = "SELECT * FROM Appointment";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Appointment appointment = new Appointment(
                        rs.getInt("appointmentId"),
                        customerModel.getCustomerById(rs.getInt("customerId")),
                        vehicleModel.getVehicleById(rs.getInt("vehicleId")),
                        serviceOutletModel.getOutletById(rs.getInt("OutletId")),
                        rs.getString("status"),
                        serviceModel.getServiceById(rs.getInt("serviceId")),
                        rs.getString("description"),
                        rs.getDate("scheduledDate"),
                        rs.getTime("scheduledTime")
                );
                list.add(appointment);
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

        return list;
    }

    public List<Appointment> getUpcomingAppointments() {
        connect db = new connect();
        Connection con = db.createConnection();

        List<Appointment> list = new ArrayList<>();

        String sql = "SELECT * FROM Appointment WHERE scheduledDate >= CURDATE()";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Appointment appointment = new Appointment(
                        rs.getInt("appointmentId"),
                        customerModel.getCustomerById(rs.getInt("customerId")),
                        vehicleModel.getVehicleById(rs.getInt("vehicleId")),
                        serviceOutletModel.getOutletById(rs.getInt("OutletId")),
                        rs.getString("status"),
                        serviceModel.getServiceById(rs.getInt("serviceId")),
                        rs.getString("description"),
                        rs.getDate("scheduledDate"),
                        rs.getTime("scheduledTime")
                );
                list.add(appointment);
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

        return list;
    }

}
