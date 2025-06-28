package rodrigoservicecenter.connect;

import java.sql.*;
import java.util.Scanner;

public class connect {

    private static Connection con;

    public Connection createConnection() {
        String schema = "rodrigo1";
        String host = "localhost";
        String urlCheck = "jdbc:mysql://" + host + "/";
        String urlWithSchema = "jdbc:mysql://" + host + "/" + schema;

        try {
            // Try default connection
            con = DriverManager.getConnection(urlWithSchema, "root", "");
            return con;

        } catch (SQLException e) {
            if (e.getMessage().contains("Unknown database")) {
                System.out.println("Database '" + schema + "' does not exist.");
                Scanner sc = new Scanner(System.in);

                System.out.print("Enter MySQL username: ");
                String user = sc.nextLine();

                System.out.print("Enter MySQL password: ");
                String pass = sc.nextLine();

                try (Connection tempCon = DriverManager.getConnection(urlCheck, user, pass)) {

                    System.out.print("Database not found. Do you want to create it? (yes/no): ");
                    String confirm = sc.nextLine().trim().toLowerCase();

                    if (confirm.equals("yes")) {
                        Statement stmt = tempCon.createStatement();
                        stmt.executeUpdate("CREATE DATABASE " + schema);
                        System.out.println("Database created successfully.");

                        con = DriverManager.getConnection(urlWithSchema, user, pass);
                        createTables(con);
                        insertSampleData(con);
                        return con;
                    } else {
                        System.out.println("Aborted by user.");
                        return null;
                    }

                } catch (SQLException ex) {
                    System.err.println("Failed to connect or create schema: " + ex.getMessage());
                }
            } else {
                System.err.println("SQL Error: " + e.getMessage());
            }
        }

        return null;
    }

    private void createTables(Connection con) {
        String[] queries = {
                """
            CREATE TABLE IF NOT EXISTS service (
              serviceId INT NOT NULL,
              serviceName VARCHAR(100),
              description VARCHAR(200),
              estimatedDuration TIME,
              vehicleCompatibility VARCHAR(100),
              price INT,
              PRIMARY KEY (serviceId)
            ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
            """,

                """
            CREATE TABLE IF NOT EXISTS serviceoutlet (
              outletId INT NOT NULL,
              outletName VARCHAR(100),
              location VARCHAR(100),
              contactNumber INT,
              email VARCHAR(100),
              PRIMARY KEY (outletId)
            ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
            """,

                """
            CREATE TABLE IF NOT EXISTS appointment (
              appointmentId INT NOT NULL,
              customerId INT,
              vehicleId VARCHAR(50),
              status VARCHAR(50),
              description VARCHAR(200),
              scheduledDate DATE,
              scheduledTime TIME,
              outletId INT,
              serviceId INT,
              PRIMARY KEY (appointmentId),
              FOREIGN KEY (serviceId) REFERENCES service(serviceId)
            ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
            """,

                """
            CREATE TABLE IF NOT EXISTS customers (
              customerId INT NOT NULL AUTO_INCREMENT,
              username VARCHAR(100),
              password VARCHAR(100),
              contactNumber INT,
              email VARCHAR(100),
              address VARCHAR(200),
              registrationDate DATE,
              PRIMARY KEY (customerId)
            ) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4;
            """,

                """
            CREATE TABLE IF NOT EXISTS department (
              departmentId INT NOT NULL,
              departmentName VARCHAR(100),
              location VARCHAR(100),
              PRIMARY KEY (departmentId)
            ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
            """,

                """
            CREATE TABLE IF NOT EXISTS employee (
              employeeId INT NOT NULL,
              nic INT,
              name VARCHAR(100),
              password VARCHAR(100),
              roleName VARCHAR(100),
              phone INT,
              email VARCHAR(100),
              address VARCHAR(200),
              dateOfJoining DATE,
              dateOfBirth DATE,
              outletId INT,
              departmentId INT,
              PRIMARY KEY (employeeId),
              FOREIGN KEY (outletId) REFERENCES serviceoutlet(outletId)
            ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
            """,

                """
            CREATE TABLE IF NOT EXISTS invoice (
              invoiceId INT NOT NULL AUTO_INCREMENT,
              customerId INT,
              issueDate DATE,
              dueDate DATE,
              totalAmount INT,
              paymentStatus VARCHAR(50),
              PRIMARY KEY (invoiceId)
            ) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;
            """,

                """
            CREATE TABLE IF NOT EXISTS invoice_product (
              productInvoiceId INT NOT NULL AUTO_INCREMENT,
              invoiceId INT,
              productId INT,
              quantity INT DEFAULT 1,
              PRIMARY KEY (productInvoiceId)
            ) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;
            """,

                """
            CREATE TABLE IF NOT EXISTS invoice_service (
              serviceInvoiceId INT NOT NULL AUTO_INCREMENT,
              invoiceId INT,
              serviceId INT,
              PRIMARY KEY (serviceInvoiceId)
            ) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;
            """,

                """
            CREATE TABLE IF NOT EXISTS payment (
              paymentId INT NOT NULL AUTO_INCREMENT,
              customerId INT,
              invoiceId INT,
              totalAmount INT,
              paymentDate DATE,
              paymentMethod VARCHAR(50),
              paymentStatus VARCHAR(50),
              PRIMARY KEY (paymentId)
            ) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;
            """,

                """
            CREATE TABLE IF NOT EXISTS product (
              productId INT NOT NULL,
              productName VARCHAR(100),
              category VARCHAR(100),
              vehicleCompatibility VARCHAR(100),
              brand VARCHAR(100),
              description VARCHAR(200),
              unitPrice INT,
              supplierId INT,
              outletId INT,
              PRIMARY KEY (productId)
            ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
            """,

                """
            CREATE TABLE IF NOT EXISTS servicerecord (
              recordId INT NOT NULL,
              appointmentId INT,
              vehicleId VARCHAR(50),
              customerId INT,
              serviceId INT,
              description VARCHAR(200),
              dateOfService DATE,
              totalCost INT,
              PRIMARY KEY (recordId)
            ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
            """,

                """
            CREATE TABLE IF NOT EXISTS supplier (
              supplierId INT NOT NULL,
              supplierName VARCHAR(100),
              address VARCHAR(200),
              contactNumber INT,
              email VARCHAR(100),
              PRIMARY KEY (supplierId)
            ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
            """,

                """
            CREATE TABLE IF NOT EXISTS vehicle (
              vehicleId INT NOT NULL AUTO_INCREMENT,
              customerId INT,
              model VARCHAR(100),
              year INT,
              fuelType VARCHAR(50),
              lastServicedDate DATE,
              mileage INT,
              PRIMARY KEY (vehicleId)
            ) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4;
            """
        };

        try (Statement stmt = con.createStatement()) {
            for (String query : queries) {
                stmt.execute(query);
            }
            System.out.println("All tables created successfully.");
        } catch (SQLException e) {
            System.err.println("Error creating tables: " + e.getMessage());
        }
    }

    private void insertSampleData(Connection con) {
        String[] inserts = {
                // Service table
                """
        INSERT INTO service (serviceId, serviceName, description, estimatedDuration, vehicleCompatibility, price) VALUES
        (1, 'Oil Change', 'Replace engine oil and filter', '01:00:00', 'All Models', 50),
        (2, 'Tire Rotation', 'Rotate tires to ensure even wear', '00:45:00', 'All Models', 30),
        (3, 'Brake Inspection', 'Inspect brake system components', '01:30:00', 'All Models', 60),
        (4, 'Battery Check', 'Test battery performance', '00:30:00', 'All Models', 20),
        (5, 'Full Service', 'Comprehensive vehicle check', '03:00:00', 'All Models', 150);
            """,

                // Service Outlet table
                """
        INSERT INTO serviceoutlet (outletId, outletName, location, contactNumber, email) VALUES
        (1, 'NY Service Center', 'New York', 5556667, 'ny.service@example.com'),
        (2, 'Chicago Service Center', 'Chicago', 5557778, 'chicago.service@example.com'),
        (3, 'LA Service Center', 'Los Angeles', 5558889, 'la.service@example.com'),
        (4, 'Houston Service Center', 'Houston', 555999, 'houston.service@example.com'),
        (5, 'Miami Service Center', 'Miami', 555000, 'miami.service@example.com');
            """,

                // Department table
                """
        INSERT INTO department (departmentId, departmentName, location) VALUES
        (1, 'Service', 'New York'),
        (2, 'Sales', 'Chicago'),
        (3, 'Inventory', 'Los Angeles'),
        (4, 'Customer Support', 'Houston'),
        (5, 'Administration', 'Miami');
            """,

                // Customers table
                """
        INSERT INTO customers (customerId, username, password, contactNumber, email, address, registrationDate) VALUES
        (1, 'john_doe', 'pass123', 1234567, 'john@example.com', 'NY', '2024-01-01'),
        (2, 'jane_smith', 'pass123', 2345678, 'jane@example.com', 'Chicago', '2024-01-02'),
        (3, 'alice_wong', 'pass123', 345678, 'alice@example.com', 'LA', '2024-01-03'),
        (4, 'bob_lee', 'pass123', 456789, 'bob@example.com', 'Houston', '2024-01-04'),
        (5, 'carol_kim', 'pass123', 5678901, 'carol@example.com', 'Miami', '2024-01-05');
        """,

                // Vehicle table
                """
        INSERT INTO vehicle (vehicleId, customerId, model, year, fuelType, lastServicedDate, mileage) VALUES
        (1, 1, 'Toyota Corolla', 2018, 'Petrol', '2024-05-01', 50000),
        (2, 2, 'Honda Civic', 2019, 'Diesel', '2024-05-02', 45000),
        (3, 3, 'Ford Focus', 2020, 'Hybrid', '2024-05-03', 30000),
        (4, 4, 'Tesla Model 3', 2021, 'Electric', '2024-05-04', 20000),
        (5, 5, 'Chevy Bolt', 2022, 'Electric', '2024-05-05', 15000);
        """,

                // Employee table
                """
        INSERT INTO employee (employeeId, nic, name, password, roleName, phone, email, address, dateOfJoining, dateOfBirth, outletId, departmentId) VALUES
        (1, 123456, 'Mike Smith', 'emp123', 'Manager', 987654, 'mike@example.com', 'NY', '2023-01-01', '1985-01-01', 1, 1),
        (2, 234567, 'Linda Ray', 'emp123', 'Technician', 876543, 'linda@example.com', 'Chicago', '2023-02-01', '1987-02-02', 2, 1),
        (3, 345678, 'Tom Brown', 'emp123', 'Sales Rep', 765432, 'tom@example.com', 'LA', '2023-03-01', '1990-03-03', 3, 2),
        (4, 456789, 'Sara Lee', 'emp123', 'Inventory Manager', 654321, 'sara@example.com', 'Houston', '2023-04-01', '1992-04-04', 4, 3),
        (5, 567890, 'Jack White', 'emp123', 'Support Staff', 54321, 'jack@example.com', 'Miami', '2023-05-01', '1994-05-05', 5, 4);
        """,

                // Appointment table
                """
        INSERT INTO appointment (appointmentId, customerId, vehicleId, status, description, scheduledDate, scheduledTime, outletId, serviceId) VALUES
        (1, 1, '1', 'Scheduled', 'Oil change', '2024-06-01', '09:00:00', 1, 1),
        (2, 2, '2', 'Completed', 'Tire rotation', '2024-06-02', '10:00:00', 2, 2),
        (3, 3, '3', 'Scheduled', 'Brake inspection', '2024-06-03', '11:00:00', 3, 3),
        (4, 4, '4', 'In Progress', 'Battery check', '2024-06-04', '12:00:00', 4, 4),
        (5, 5, '5', 'Scheduled', 'Full service', '2024-06-05', '13:00:00', 5, 5);
        """,

                // Product table
                """
        INSERT INTO product (productId, productName, category, vehicleCompatibility, brand, description, unitPrice, supplierId, outletId) VALUES
        (1, 'Engine Oil', 'Lubricants', 'All Models', 'Mobil', '5W-30 Synthetic', 25, 1, 1),
        (2, 'Brake Pads', 'Brakes', 'All Models', 'Brembo', 'Ceramic Pads', 40, 1, 1),
        (3, 'Air Filter', 'Filters', 'All Models', 'Bosch', 'Engine air filter', 15, 1, 2),
        (4, 'Spark Plug', 'Ignition', 'All Models', 'NGK', 'Iridium spark plug', 10, 1, 2),
        (5, 'Coolant', 'Fluids', 'All Models', 'Prestone', 'Radiator coolant', 18, 1, 3);
        """,

                // Supplier table
                """
        INSERT INTO supplier (supplierId, supplierName, address, contactNumber, email) VALUES
        (1, 'AutoParts Inc.', '123 Market St, NY', 1234567, 'parts@autoparts.com'),
        (2, 'AutoParts Co.', '456 Main St, LA', 9876543, 'parts@autopartsco.com'),
        (3, 'AutoParts Ltd.', '789 Main St, Chicago', 555555, 'parts@autoparts.com'),
        (4, 'AutoParts Corp.', '321 Main St, Houston', 111111, 'parts@autoparts.com'),
        (5, 'AutoParts LLC.', '654 Main St, Miami', 22222, 'parts@autoparts.com');
        """,

                // Invoice table
                """
        INSERT INTO invoice (invoiceId, customerId, issueDate, dueDate, totalAmount, paymentStatus) VALUES
        (1, 1, '2024-06-01', '2024-06-10', 75, 'Paid'),
        (2, 2, '2024-06-02', '2024-06-11', 40, 'Paid'),
        (3, 3, '2024-06-03', '2024-06-12', 55, 'Unpaid'),
        (4, 4, '2024-06-04', '2024-06-13', 80, 'Paid'),
        (5, 5, '2024-06-05', '2024-06-14', 150, 'Pending');
        """,

                // Invoice Product table
                """
        INSERT INTO invoice_product (productInvoiceId, invoiceId, productId, quantity) VALUES
        (1, 1, 1, 2),
        (2, 2, 2, 1),
        (3, 3, 3, 2),
        (4, 4, 4, 4),
        (5, 5, 5, 1);
        """,

                // Invoice Service table
                """
        INSERT INTO invoice_service (serviceInvoiceId, invoiceId, serviceId) VALUES
        (1, 1, 1),
        (2, 2, 2),
        (3, 3, 3),
        (4, 4, 4),
        (5, 5, 5);
        """,

                // Payment table
                """
        INSERT INTO payment (paymentId, customerId, invoiceId, totalAmount, paymentDate, paymentMethod, paymentStatus) VALUES
        (1, 1, 1, 75, '2024-06-01', 'Cash', 'Paid'),
        (2, 2, 2, 40, '2024-06-02', 'Card', 'Paid'),
        (3, 3, 3, 55, '2024-06-03', 'Online', 'Unpaid'),
        (4, 4, 4, 80, '2024-06-04', 'Cash', 'Paid'),
        (5, 5, 5, 150, '2024-06-05', 'Card', 'Pending');
        """,

                // Service Record table
                """
        INSERT INTO servicerecord (recordId, appointmentId, vehicleId, customerId, serviceId, description, dateOfService, totalCost) VALUES
        (1, 1, '1', 1, 1, 'Completed oil change', '2024-06-01', 50),
        (2, 2, '2', 2, 2, 'Rotated tires', '2024-06-02', 30),
        (3, 3, '3', 3, 3, 'Brake inspection complete', '2024-06-03', 60),
        (4, 4, '4', 4, 4, 'Battery tested', '2024-06-04', 20),
        (5, 5, '5', 5, 5, 'Full service done', '2024-06-05', 150);
        """
        };

        try (Statement stmt = con.createStatement()) {
            for (String insert : inserts) {
                stmt.executeUpdate(insert);
            }
            System.out.println("Sample data inserted successfully.");
        } catch (SQLException e) {
            System.err.println("Error inserting sample data: " + e.getMessage());
        }
    }
}
