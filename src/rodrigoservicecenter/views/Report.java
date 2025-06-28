package rodrigoservicecenter.views;

import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;
import rodrigoservicecenter.connect.connect;
import rodrigoservicecenter.views.reports.ChartGenerator;

import javax.swing.*;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;


public class Report extends javax.swing.JInternalFrame {

  
    public Report() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0)); 
        BasicInternalFrameUI ui= (BasicInternalFrameUI) this.getUI(); 
        ui.setNorthPane (null);

        setReports();

    }

    private void setReports(){
        connect db = new connect();
        Connection con = db.createConnection();

        //String visualReport = "";
        String customerReport = "rodrigoservicecenter/views/reports/Customers.jasper";
        String appoinmentReport = "rodrigoservicecenter/views/reports/Appointments.jasper";
        String incomeReport = "rodrigoservicecenter/views/reports/Income.jasper";

        //loadReportToPanel(visual_panal, visualReport, con);
        loadReportToPanel(customer_panal, customerReport, con);
        loadReportToPanel(appointment_table, appoinmentReport, con);
        loadReportToPanel(income_panal, incomeReport, con);

        ChartGenerator chartGenerator = new ChartGenerator();
        JScrollPane chartPanel = chartGenerator.getPanel(con);
        visual_panal.setLayout(new BorderLayout());
        visual_panal.add(chartPanel, BorderLayout.CENTER);

        try {
            if (con != null) con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel14 = new javax.swing.JLabel();
        tab_panal = new javax.swing.JTabbedPane();
        visual_panal = new javax.swing.JPanel();
        customer_panal = new javax.swing.JPanel();
        appointment_table = new javax.swing.JPanel();
        income_panal = new javax.swing.JPanel();
        print_bt = new javax.swing.JButton();
        refresh_bt = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1240, 700));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(102, 102, 102));
        jLabel14.setText("Reports");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, -1, -1));

        tab_panal.addTab("Visual Report", visual_panal);
        tab_panal.addTab("Customer Report", customer_panal);
        tab_panal.addTab("Appointment Report", appointment_table);
        tab_panal.addTab("Income Report", income_panal);

        getContentPane().add(tab_panal, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 1110, 540));

        print_bt.setForeground(new java.awt.Color(102, 102, 102));
        print_bt.setText("Print");
        print_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                print_btActionPerformed(evt);
            }
        });
        getContentPane().add(print_bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 30, 130, 30));

        refresh_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rodrigoservicecenter/resources/refresh-3104 (1).png"))); // NOI18N
        refresh_bt.setForeground(new java.awt.Color(102, 102, 102));
        refresh_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refresh_btActionPerformed(evt);
            }
        });
        getContentPane().add(refresh_bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 30, 30, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void print_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_print_btActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_print_btActionPerformed

    private void refresh_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refresh_btActionPerformed
        setReports();
    }//GEN-LAST:event_refresh_btActionPerformed

    public void loadReportToPanel(JPanel targetPanel, String reportPath, Connection con) {
        try {
            InputStream reportStream = getClass().getClassLoader().getResourceAsStream(reportPath);
            if (reportStream == null) {
                throw new FileNotFoundException("Report file not found: " + reportPath);
            }

            JasperPrint print = JasperFillManager.fillReport(reportStream, null, con);
            JRViewer viewer = new JRViewer(print);
            targetPanel.removeAll();
            targetPanel.setLayout(new BorderLayout());
            targetPanel.add(viewer, BorderLayout.CENTER);
            targetPanel.revalidate();
            targetPanel.repaint();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed to load report: " + e.getMessage());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel appointment_table;
    private javax.swing.JPanel customer_panal;
    private javax.swing.JPanel income_panal;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JButton print_bt;
    private javax.swing.JButton refresh_bt;
    private javax.swing.JTabbedPane tab_panal;
    private javax.swing.JPanel visual_panal;
    // End of variables declaration//GEN-END:variables
}
