package rodrigoservicecenter.views.reports;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import rodrigoservicecenter.connect.connect;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.awt.print.Printable;
import java.awt.print.PrinterJob;
import java.io.File;
import java.sql.*;

public class ChartGenerator {

    private Connection con;

    public JScrollPane getPanel(Connection con) {
        this.con = con;

        // A4 panel that contains all charts
        JPanel a4Panel = new JPanel(new BorderLayout());
        a4Panel.setPreferredSize(new Dimension(794, 1123)); // A4

        // === Toolbar ===
        JToolBar toolbar = new JToolBar();
        toolbar.setFloatable(false);

        JButton printBtn = new JButton("Print");
        JButton saveBtn = new JButton("Save as PNG");

        toolbar.add(printBtn);
        toolbar.add(saveBtn);

        // === Chart Grid ===
        JPanel chartGrid = new JPanel(new GridLayout(3, 2, 10, 10));
        chartGrid.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        chartGrid.setBackground(Color.WHITE);

        // Chart Panels (with fixed size to ensure consistent layout)
        chartGrid.add(wrapChartPanel(createAppointmentChart(), "Appointments per Month"));
        chartGrid.add(wrapChartPanel(createIncomeChart(), "Income Overview"));
        chartGrid.add(wrapChartPanel(createServiceUsageChart(), "Service Usage Count"));
        chartGrid.add(wrapChartPanel(createPaymentStatusPie(), "Payment Status Distribution"));
        chartGrid.add(wrapChartPanel(createCustomerGrowthChart(), "Customer Growth"));
        chartGrid.add(wrapChartPanel(createDepartmentCountChart(), "Department Staff Count"));

        a4Panel.add(toolbar, BorderLayout.NORTH);
        a4Panel.add(chartGrid, BorderLayout.CENTER);

        // === Wrap A4 Panel in ScrollPane ===
        JScrollPane scrollPane = new JScrollPane(a4Panel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        // === Print Action ===
        printBtn.addActionListener(e -> {
            PrinterJob job = PrinterJob.getPrinterJob();
            job.setJobName("Print A4 Charts");

            job.setPrintable((graphics, pageFormat, pageIndex) -> {
                if (pageIndex > 0) return Printable.NO_SUCH_PAGE;

                Graphics2D g2d = (Graphics2D) graphics;
                g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
                a4Panel.printAll(g2d);
                return Printable.PAGE_EXISTS;
            });

            if (job.printDialog()) {
                try {
                    job.print();
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(a4Panel, "Print failed: " + ex.getMessage());
                }
            }
        });

        // === Save as PNG Action ===
        saveBtn.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser();
            if (chooser.showSaveDialog(a4Panel) == JFileChooser.APPROVE_OPTION) {
                try {
                    BufferedImage image = new BufferedImage(
                            a4Panel.getWidth(), a4Panel.getHeight(), BufferedImage.TYPE_INT_RGB
                    );
                    Graphics2D g2d = image.createGraphics();
                    a4Panel.paintAll(g2d);
                    g2d.dispose();

                    ImageIO.write(image, "png", chooser.getSelectedFile());
                    JOptionPane.showMessageDialog(a4Panel, "Saved as PNG.");
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(a4Panel, "Save failed: " + ex.getMessage());
                }
            }
        });

        return scrollPane;
    }

    private JPanel wrapChartPanel(JFreeChart chart, String title) {
        ChartPanel panel = new ChartPanel(chart);
        panel.setPreferredSize(new Dimension(350, 300));
        panel.setBorder(BorderFactory.createTitledBorder(title));
        return panel;
    }


    private JFreeChart createAppointmentChart() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        String query = "SELECT MONTHNAME(scheduledDate) as month, COUNT(*) as count FROM appointment GROUP BY MONTH(scheduledDate)";
        try (Statement st = con.createStatement(); ResultSet rs = st.executeQuery(query)) {
            while (rs.next()) {
                dataset.addValue(rs.getInt("count"), "Appointments", rs.getString("month"));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return ChartFactory.createBarChart("Appointments Per Month", "Month", "Count", dataset);
    }

    private JFreeChart createIncomeChart() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        String query = "SELECT MONTHNAME(issueDate) as month, SUM(totalAmount) as income FROM invoice GROUP BY MONTH(issueDate)";
        try (Statement st = con.createStatement(); ResultSet rs = st.executeQuery(query)) {
            while (rs.next()) {
                dataset.addValue(rs.getInt("income"), "Income", rs.getString("month"));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return ChartFactory.createLineChart("Monthly Income", "Month", "LKR", dataset);
    }

    private JFreeChart createServiceUsageChart() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        String query = "SELECT s.serviceName, COUNT(*) AS `usage` FROM servicerecord sr JOIN service s ON sr.serviceId = s.serviceId GROUP BY sr.serviceId";
        try (Statement st = con.createStatement(); ResultSet rs = st.executeQuery(query)) {
            while (rs.next()) {
                dataset.addValue(rs.getInt("usage"), "Usage", rs.getString("serviceName"));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return ChartFactory.createBarChart("Service Usage", "Service", "Usage Count", dataset);
    }

    private JFreeChart createPaymentStatusPie() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        String query = "SELECT paymentStatus, COUNT(*) as count FROM payment GROUP BY paymentStatus";
        try (Statement st = con.createStatement(); ResultSet rs = st.executeQuery(query)) {
            while (rs.next()) {
                dataset.setValue(rs.getString("paymentStatus"), rs.getInt("count"));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return ChartFactory.createPieChart("Payment Status", dataset);
    }

    private JFreeChart createCustomerGrowthChart() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        String query = "SELECT MONTHNAME(registrationDate) as month, COUNT(*) as count FROM customers GROUP BY MONTH(registrationDate)";
        try (Statement st = con.createStatement(); ResultSet rs = st.executeQuery(query)) {
            while (rs.next()) {
                dataset.addValue(rs.getInt("count"), "New Customers", rs.getString("month"));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return ChartFactory.createBarChart("Customer Growth", "Month", "Count", dataset);
    }

    private JFreeChart createDepartmentCountChart() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        String query = "SELECT d.departmentName, COUNT(e.employeeId) as count FROM employee e JOIN department d ON e.departmentId = d.departmentId GROUP BY d.departmentName";
        try (Statement st = con.createStatement(); ResultSet rs = st.executeQuery(query)) {
            while (rs.next()) {
                dataset.addValue(rs.getInt("count"), "Employees", rs.getString("departmentName"));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return ChartFactory.createBarChart("Employees per Department", "Department", "Count", dataset);
    }
}
