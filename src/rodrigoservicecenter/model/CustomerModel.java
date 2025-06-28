package rodrigoservicecenter.model;

import rodrigoservicecenter.connect.connect;
import rodrigoservicecenter.model.entity.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerModel {

    // Add customer
    public Customer addCustomer(Customer customer) {
        connect db = new connect();
        Connection con = db.createConnection();

        String sql = "INSERT INTO Customers (username, password, contactNumber, email, address, registrationDate) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            // Enable retrieval of auto-generated keys
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, customer.getUsername());
            ps.setString(2, customer.getPassword());
            ps.setInt(3, customer.getContactNumber());
            ps.setString(4, customer.getEmail());
            ps.setString(5, customer.getAddress());
            ps.setDate(6, new Date(customer.getRegistrationDate().getTime()));

            int rowsInserted = ps.executeUpdate();

            if (rowsInserted > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    int generatedId = rs.getInt(1);
                    customer.setCustomerId(generatedId); // ✅ Set the generated ID
                    return customer;
                }
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



    // Get all customers
    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        connect db = new connect();
        Connection con = db.createConnection();

        String sql = "SELECT * FROM Customers";

        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int customerId = rs.getInt("customerId");
                String username = rs.getString("username");
                String password = rs.getString("password");
                int contactNumber = rs.getInt("contactNumber");
                String email = rs.getString("email");
                String address = rs.getString("address");
                Date registrationDate = rs.getDate("registrationDate");

                Customer customer = new Customer(customerId, username, password, contactNumber, email, address, registrationDate);
                customers.add(customer);
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
        return customers;
    }


    // Get customer by ID
    public Customer getCustomerById(int id) {
        Customer customer = null;
        connect db = new connect();
        Connection con = db.createConnection();

        String sql = "SELECT * FROM Customers WHERE customerId = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int customerId = rs.getInt("customerId");
                String username = rs.getString("username");
                String password = rs.getString("password");
                int contactNumber = rs.getInt("contactNumber");
                String email = rs.getString("email");
                String address = rs.getString("address");
                Date registrationDate = rs.getDate("registrationDate");

                customer = new Customer(customerId, username, password, contactNumber, email, address, registrationDate);
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
        return customer;
    }




    // Update an existing customer
    public boolean updateCustomer(Customer customer) {
        connect db = new connect();
        Connection con = db.createConnection();

        String sql = "UPDATE Customers SET username = ?, password = ?, contactNumber = ?, email = ?, address = ?, registrationDate = ? WHERE customerId = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, customer.getUsername());
            ps.setString(2, customer.getPassword());
            ps.setInt(3, customer.getContactNumber());
            ps.setString(4, customer.getEmail());
            ps.setString(5, customer.getAddress());
            ps.setDate(6, new java.sql.Date(customer.getRegistrationDate().getTime()));
            ps.setInt(7, customer.getCustomerId());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;

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




    // Delete a customer by ID
    public boolean deleteCustomer(int id) {
        connect db = new connect();
        Connection con = db.createConnection();

        String sql = "DELETE FROM Customers WHERE customerId = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;

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


    // Login
    public Customer loginCustomer(String username, String password) {
        Customer customer = null;
        connect db = new connect();
        Connection con = db.createConnection();

        String sql = "SELECT * FROM Customers WHERE username = ? AND password = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int customerId = rs.getInt("customerId");
                int contactNumber = rs.getInt("contactNumber");
                String email = rs.getString("email");
                String address = rs.getString("address");
                Date registrationDate = rs.getDate("registrationDate");

                customer = new Customer(customerId, username, password, contactNumber, email, address, registrationDate);
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

        return customer;
    }


    public List<Customer> searchCustomersByName(String keyword) {
        List<Customer> customers = new ArrayList<>();
        connect db = new connect();
        Connection con = db.createConnection();

        String sql = "SELECT * FROM Customers WHERE username LIKE ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Customer customer = new Customer(
                        rs.getInt("customerId"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getInt("contactNumber"),
                        rs.getString("email"),
                        rs.getString("address"),
                        rs.getDate("registrationDate")
                );
                customers.add(customer);
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

        return customers;
    }

    public Customer getCustomerByContactNumber(int contactNumber) {
        Customer customer = null;
        connect db = new connect();
        Connection con = db.createConnection();

        String sql = "SELECT * FROM Customers WHERE contactNumber = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, contactNumber);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int customerId = rs.getInt("customerId");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String email = rs.getString("email");
                String address = rs.getString("address");
                Date registrationDate = rs.getDate("registrationDate");

                customer = new Customer(customerId, username, password, contactNumber, email, address, registrationDate);
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

        return customer;
    }

}
