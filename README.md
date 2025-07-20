
# Rodrigo Car Service Center Management System

**Rodrigo Car Service Center** is a comprehensive Java-based desktop application built to manage daily operations in an automotive service center. It provides functionality for booking appointments, managing customers and vehicles, tracking services, generating invoices, and visualizing operational data using interactive charts and detailed reports.

---

## 🛠️ Features

### 🧾 Core Modules
- **Customer Management** – Add, update, and view registered customers.
- **Vehicle Management** – Track customer vehicles, including model, year, and service history.
- **Appointment Booking** – Schedule and update service appointments.
- **Service Tracking** – Record services performed, duration, and cost.
- **Inventory Management** – Manage products and parts used for services.
- **Invoice & Payments** – Generate invoices, track payments and status.

### 📊 Reporting & Visualization
- **Visual Reports Panel** using `JFreeChart`:
  - Monthly appointments bar chart
  - Monthly income line chart
  - Service usage bar chart
  - Payment status pie chart
  - Customer growth chart
  - Staff count by department
- **JasperReports**:
  - Customer Report
  - Appointment Report
  - Income Report
  - Product Inventory Report
  - Vehicle Service History Report

### 🖨️ Print & Export
- Save visual reports as high-quality PNG images.
- Print full A4-size visual dashboards.
- JasperReports are printable and exportable (PDF, Excel, etc.).

---

## 🧱 Technologies Used

- **Java SE (Swing)** – for the desktop application GUI
- **MySQL** – for the relational database
- **JDBC** – to connect Java to MySQL
- **JFreeChart** – for generating dynamic visual charts
- **JasperReports** – for structured business reports
- **NetBeans IDE** – for design and development

---

## 🏁 Getting Started

### 🖥️ Requirements
- Java JDK 8 or above
- MySQL Server
- NetBeans or IntelliJ IDEA
- Internet connection for Maven dependencies (JFreeChart, JasperReports)

### ⚙️ Setup

1. **Clone the Repository**
   git clone https://github.com/your-username/rodrigo-service-center.git

2. **Create the Database**

   * Use the provided SQL schema file (`schema.sql`) to create the necessary tables.
   * Insert sample data using the `insertSampleData(Connection con)` method in your code.

3. **Update Database Config**

   * Edit the `connect.java` file with your DB URL, username, and password.

4. **Build & Run**

   * Open in NetBeans or your favorite IDE.
   * Run the `Main` or `Dashboard` class.

---

## 📸 Screenshots

<details>
<summary>Click to expand</summary>

* Dashboard with Tabs
* Appointment Booking
* Vehicle Management
* Visual Reports (bar, line, pie)
* Printable Reports (Jasper)

</details>

---

## 📂 Project Structure

```
rodrigo-service-center/
├── connect/              # DB connection
├── views/                # Main UI and panels
├── views/reports/        # Chart and Jasper report handlers
├── assets/               # Icons, images (optional)
├── sql/                  # DB schema and sample data
└── README.md
```

---

## 📌 Notes

* Ensure your MySQL server is running before launching the app.
* Resize issues are resolved using dynamic layouts and scrollable panels.
* PNG export and printing are full-page A4 with all charts visible.

---

## 🙌 Acknowledgments

* [JFreeChart](https://www.jfree.org/jfreechart/)
* [JasperReports](https://community.jaspersoft.com/)
* Inspired by real-world car service centers and tailored for educational use.

---

## 📃 License

This project is open source and free to use for academic and non-commercial purposes.

```
