package rodrigoservicecenter.views.reports;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.print.Printable;
import java.awt.print.PrinterJob;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.*;

public class ChartGenerator {

    private Connection con;

    public JScrollPane getPanel(Connection con) {
        this.con = con;

        // === Colors ===
        Color primaryBlue = new Color(30, 136, 229);
        Color accentOrange = new Color(255, 152, 0);
        Color White = new Color(255, 255, 255, 255);
;
        // === Main A4 Panel ===
        JPanel chartGrid = new JPanel(new GridLayout(3, 2, 10, 10));
        chartGrid.setBackground(Color.WHITE);
        chartGrid.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        chartGrid.add(wrapChartPanel(createAppointmentChart(), "Appointments per Month"));
        chartGrid.add(wrapChartPanel(createIncomeChart(), "Income Overview"));
        chartGrid.add(wrapChartPanel(createServiceUsageChart(), "Service Usage Count"));
        chartGrid.add(wrapChartPanel(createPaymentStatusPie(), "Payment Status Distribution"));
        chartGrid.add(wrapChartPanel(createCustomerGrowthChart(), "Customer Growth"));
        chartGrid.add(wrapChartPanel(createDepartmentCountChart(), "Department Staff Count"));

        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.setBackground(Color.WHITE);
        contentPanel.add(createHeader(primaryBlue, White), BorderLayout.NORTH);
        contentPanel.add(chartGrid, BorderLayout.CENTER);
        contentPanel.add(createFooter(), BorderLayout.SOUTH);

        contentPanel.setPreferredSize(new Dimension(794, 1123));

        // === Toolbar ===
        JToolBar toolbar = new JToolBar();
        toolbar.setFloatable(false);
        JButton printBtn = new JButton("Print");
        JButton saveBtn = new JButton("Save as PNG");
        toolbar.add(printBtn);
        toolbar.add(saveBtn);

        // === Main Wrapper ===
        JPanel a4Panel = new JPanel(new BorderLayout());
        a4Panel.add(toolbar, BorderLayout.NORTH);
        a4Panel.add(contentPanel, BorderLayout.CENTER);

        JScrollPane scrollPane = new JScrollPane(a4Panel);

        // === Print Action ===
        printBtn.addActionListener(e -> {
            PrinterJob job = PrinterJob.getPrinterJob();
            job.setJobName("Print Charts");

            job.setPrintable((graphics, pageFormat, pageIndex) -> {
                if (pageIndex > 0) return Printable.NO_SUCH_PAGE;
                Graphics2D g2d = (Graphics2D) graphics;
                double scaleX = pageFormat.getImageableWidth() / contentPanel.getPreferredSize().width;
                double scaleY = pageFormat.getImageableHeight() / contentPanel.getPreferredSize().height;
                double scale = Math.min(scaleX, scaleY);

                g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
                g2d.scale(scale, scale);
                contentPanel.printAll(g2d);
                return Printable.PAGE_EXISTS;
            });

            if (job.printDialog()) {
                try {
                    job.print();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        // === Save PNG ===
        saveBtn.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser();
            if (chooser.showSaveDialog(chartGrid) == JFileChooser.APPROVE_OPTION) {
                try {
                    Dimension size = contentPanel.getPreferredSize();
                    BufferedImage image = new BufferedImage(size.width, size.height, BufferedImage.TYPE_INT_RGB);
                    Graphics2D g2d = image.createGraphics();
                    contentPanel.paint(g2d);
                    g2d.dispose();

                    File file = chooser.getSelectedFile();
                    if (!file.getName().toLowerCase().endsWith(".png")) {
                        file = new File(file.getAbsolutePath() + ".png");
                    }

                    ImageIO.write(image, "png", file);
                    JOptionPane.showMessageDialog(chartGrid, "Saved as PNG: " + file.getName());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        return scrollPane;
    }

    private JPanel createHeader(Color primary, Color accent) {
        JPanel panel = new JPanel();
        panel.setBackground(primary);
        panel.setPreferredSize(new Dimension(794, 60));

        JLabel label = new JLabel("Rodrigo Car Service Center - Visual Graphs", JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setForeground(accent);

        panel.setLayout(new BorderLayout());
        panel.add(label, BorderLayout.CENTER);
        return panel;
    }

    private JPanel createFooter() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setPreferredSize(new Dimension(794, 30));

        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        JLabel label = new JLabel("Generated on: " + timestamp, JLabel.RIGHT);
        label.setFont(new Font("Arial", Font.PLAIN, 12));

        panel.setLayout(new BorderLayout());
        panel.add(label, BorderLayout.EAST);
        return panel;
    }

    private JPanel wrapChartPanel(JFreeChart chart, String title) {
        ChartPanel panel = new ChartPanel(chart);
        panel.setPreferredSize(new Dimension(360, 260));
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
