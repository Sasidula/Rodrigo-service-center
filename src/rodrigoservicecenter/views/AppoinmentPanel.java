/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package rodrigoservicecenter.views;

import com.toedter.calendar.JDateChooser;
import rodrigoservicecenter.controller.AppointmentController;
import rodrigoservicecenter.model.entity.Appointment;
import rodrigoservicecenter.model.entity.Employee;

import javax.swing.*;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


public class AppoinmentPanel extends javax.swing.JInternalFrame {

    AppointmentController appointmentController = new AppointmentController();

    String[] columnNames = {"Date", "Time", "Customer", "Vehicle", "Status", "Service", "Outlet", "Description"};
    DefaultTableModel model = new DefaultTableModel(columnNames, 0);

    public AppoinmentPanel(Employee employee) {

        initComponents();

        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0)); 
        BasicInternalFrameUI ui= (BasicInternalFrameUI) this.getUI(); 
        ui.setNorthPane (null);

        Select_oulet.removeAllItems();
        Select_oulet.addItem("All");
        Select_oulet.addItem("New York");
        Select_oulet.addItem("Chicago");
        Select_oulet.addItem("Los Angeles");
        Select_oulet.addItem("Houston");
        Select_oulet.addItem("Miami");

        refreshTable(appointmentController.getAllAppointments());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        appointments = new javax.swing.JTable();
        Search_bt = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Select_oulet = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        clean_datetime_bt = new javax.swing.JButton();
        dateTimePicker1 = new com.github.lgooddatepicker.components.DateTimePicker();
        refresh_bt1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1240, 700));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        appointments.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        appointments.setRowHeight(30);
        jScrollPane1.setViewportView(appointments);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 1120, 430));

        Search_bt.setBackground(new java.awt.Color(0, 51, 153));
        Search_bt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Search_bt.setForeground(new java.awt.Color(255, 255, 255));
        Search_bt.setText("Search");
        Search_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Search_btActionPerformed(evt);
            }
        });
        getContentPane().add(Search_bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 100, 190, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rodrigoservicecenter/resources/icons8-search-40.png"))); // NOI18N
        jLabel3.setText("jLabel1");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 40, 50));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(102, 102, 102));
        jLabel14.setText("Search for Appinment ");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, -1, -1));

        jLabel4.setText("Select Date");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 170, -1));

        jLabel5.setText("Select Location");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 80, 170, -1));

        Select_oulet.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Select_oulet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Select_ouletActionPerformed(evt);
            }
        });
        getContentPane().add(Select_oulet, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 100, 220, 30));

        jLabel6.setText("Select Time");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 80, 170, -1));

        clean_datetime_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rodrigoservicecenter/resources/cancel.png"))); // NOI18N
        clean_datetime_bt.setForeground(new java.awt.Color(102, 102, 102));
        clean_datetime_bt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clean_datetime_btMouseClicked(evt);
            }
        });
        clean_datetime_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clean_datetime_btActionPerformed(evt);
            }
        });
        getContentPane().add(clean_datetime_bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 100, 30, 30));
        getContentPane().add(dateTimePicker1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 340, 30));

        refresh_bt1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rodrigoservicecenter/resources/refresh-3104 (1).png"))); // NOI18N
        refresh_bt1.setForeground(new java.awt.Color(102, 102, 102));
        refresh_bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refresh_bt1ActionPerformed(evt);
            }
        });
        getContentPane().add(refresh_bt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 100, 30, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clean_datetime_btActionPerformed(ActionEvent evt) {
        dateTimePicker1.datePicker.setDate(null);
        dateTimePicker1.timePicker.setTime(null);
    }

    private void refresh_bt1ActionPerformed(java.awt.event.ActionEvent evt) {
        refreshTable(appointmentController.getAllAppointments());
    }

    private void clean_datetime_btMouseClicked(java.awt.event.MouseEvent evt) {
        dateTimePicker1.datePicker.setDate(null);
        dateTimePicker1.timePicker.setTime(null);
    }

    private void Select_ouletActionPerformed(java.awt.event.ActionEvent evt) {
        if(Select_oulet.getSelectedIndex() == 0){
            refreshTable(appointmentController.searchAppointments(null, null, null));
        } else {
            refreshTable(appointmentController.searchAppointments(null, null, Select_oulet.getSelectedIndex()));
        }
    }

    private void Search_btActionPerformed(java.awt.event.ActionEvent evt) {
        LocalDate localDate = dateTimePicker1.datePicker.getDate();
        LocalTime localTime = dateTimePicker1.timePicker.getTime();

        java.sql.Date sqlDate = (localDate != null) ? Date.valueOf(localDate) : null;
        java.sql.Time sqlTime = (localTime != null) ? Time.valueOf(localTime) : null;

        Integer outletId = (Select_oulet.getSelectedIndex() != 0) ? Select_oulet.getSelectedIndex() : null;

        refreshTable(appointmentController.searchAppointments(sqlDate, sqlTime, outletId));
    }

    private void refresh_btActionPerformed(java.awt.event.ActionEvent evt) {
        refreshTable(appointmentController.getAllAppointments());
    }

    private void refreshTable(List<Appointment> appoint) {

        model.setRowCount(0);

        for(Appointment appointment : appoint) {
            Object[] rowData = {
                    appointment.getScheduledDate(),
                    appointment.getScheduledTime(),
                    appointment.getCustomer().getUsername(),
                    appointment.getVehicle().getModel(),
                    appointment.getStatus(),
                    appointment.getService().getServiceName(),
                    appointment.getOutlet().getOutletName(),
                    appointment.getDescription(),
            };
            model.addRow(rowData);
        }
        appointments.setModel(model);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Search_bt;
    private javax.swing.JComboBox<String> Select_oulet;
    private javax.swing.JTable appointments;
    private javax.swing.JButton clean_datetime_bt;
    private com.github.lgooddatepicker.components.DateTimePicker dateTimePicker1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton refresh_bt1;
    // End of variables declaration//GEN-END:variables
}
