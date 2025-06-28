/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package rodrigoservicecenter.views;

import rodrigoservicecenter.controller.AppointmentController;
import rodrigoservicecenter.controller.CustomerController;
import rodrigoservicecenter.model.entity.Appointment;
import rodrigoservicecenter.model.entity.Customer;
import rodrigoservicecenter.model.entity.Employee;

import javax.swing.*;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


public class BookPanel extends javax.swing.JInternalFrame {

    Employee employee;

    AppointmentController appointmentController = new AppointmentController();
    CustomerController customerController = new CustomerController();


    String[] columnNames = {"Date", "Time", "Customer", "Vehicle", "Status", "Service", "Outlet", "Description"};
    List<Appointment> displayedAppointments = new ArrayList<>();
    DefaultTableModel model = new DefaultTableModel(columnNames, 0);

    public BookPanel(Employee employee) {

        this.employee = employee;

        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0)); 
        BasicInternalFrameUI ui= (BasicInternalFrameUI) this.getUI(); 
        ui.setNorthPane (null);

        update_apponitment_serviceid.removeAllItems();
        update_apponitment_serviceid.addItem("None");
        update_apponitment_serviceid.addItem("Oil Change");
        update_apponitment_serviceid.addItem("Tire Rotation");
        update_apponitment_serviceid.addItem("Brake Inspection");
        update_apponitment_serviceid.addItem("Battery Check");
        update_apponitment_serviceid.addItem("Full Service");

        serviceid.removeAllItems();
        serviceid.addItem("None");
        serviceid.addItem("Oil Change");
        serviceid.addItem("Tire Rotation");
        serviceid.addItem("Brake Inspection");
        serviceid.addItem("Battery Check");
        serviceid.addItem("Full Service");

        refreshTable(appointmentController.getupcomingAppointments());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        serviceid = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        search_appointment_bt = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        description = new javax.swing.JTextPane();
        delete_appointment_bt = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        mobile_number = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        upcoming_appointment = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        update_apponitment_serviceid = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        clear_bt = new javax.swing.JButton();
        book_bt = new javax.swing.JButton();
        update_appointment_bt = new javax.swing.JButton();
        refresh_bt = new javax.swing.JButton();
        dateTimePicker = new com.github.lgooddatepicker.components.DateTimePicker();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        dateTimePicker_updater = new com.github.lgooddatepicker.components.DateTimePicker();
        dateTimePickerSearch = new com.github.lgooddatepicker.components.DateTimePicker();

        setBackground(new java.awt.Color(255, 255, 255));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(1240, 700));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        serviceid.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        serviceid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serviceidActionPerformed(evt);
            }
        });
        getContentPane().add(serviceid, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 250, 160, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Customer Mobile :");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 170, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Select Time :");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, 130, 30));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 51, 153));
        jLabel9.setText("Upcoming Appoinments");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 30, 230, 30));

        search_appointment_bt.setText("Search");
        search_appointment_bt.setForeground(new java.awt.Color(102, 102, 102));
        search_appointment_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_appointment_btActionPerformed(evt);
            }
        });
        getContentPane().add(search_appointment_bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 80, 160, 30));

        jScrollPane1.setViewportView(description);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, 330, 120));

        delete_appointment_bt.setText("Delete");
        delete_appointment_bt.setBackground(new java.awt.Color(255, 51, 0));
        delete_appointment_bt.setBorder(null);
        delete_appointment_bt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        delete_appointment_bt.setForeground(new java.awt.Color(255, 255, 255));
        delete_appointment_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_appointment_btActionPerformed(evt);
            }
        });
        getContentPane().add(delete_appointment_bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 610, 160, 30));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("Note :");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, 170, 30));
        getContentPane().add(mobile_number, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, 160, 30));

        upcoming_appointment.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(upcoming_appointment);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 120, 690, 350));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setText("Select Date :");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 130, 30));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 51, 153));
        jLabel12.setText("Book Appoinment");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 230, 30));

        jSeparator1.setForeground(new java.awt.Color(0, 51, 204));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 330, 10));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rodrigoservicecenter/resources/icons8-search-40.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 70, 40, 50));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 51, 153));
        jLabel14.setText("Update Appoinments");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 490, 240, 30));

        update_apponitment_serviceid.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        update_apponitment_serviceid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_apponitment_serviceidActionPerformed(evt);
            }
        });
        getContentPane().add(update_apponitment_serviceid, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 610, 160, 30));

        jLabel15.setText("Select Service       :");
        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 102, 102));
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 610, 170, 30));

        clear_bt.setText("Clear");
        clear_bt.setBackground(new java.awt.Color(0, 51, 153));
        clear_bt.setBorder(null);
        clear_bt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        clear_bt.setForeground(new java.awt.Color(255, 255, 255));
        clear_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear_btActionPerformed(evt);
            }
        });
        getContentPane().add(clear_bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 570, 160, 30));

        book_bt.setText("Book");
        book_bt.setBackground(new java.awt.Color(0, 51, 153));
        book_bt.setBorder(null);
        book_bt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        book_bt.setForeground(new java.awt.Color(255, 255, 255));
        book_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                book_btActionPerformed(evt);
            }
        });
        getContentPane().add(book_bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 570, 160, 30));

        update_appointment_bt.setText("Update");
        update_appointment_bt.setBackground(new java.awt.Color(0, 51, 153));
        update_appointment_bt.setBorder(null);
        update_appointment_bt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        update_appointment_bt.setForeground(new java.awt.Color(255, 255, 255));
        update_appointment_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_appointment_btActionPerformed(evt);
            }
        });
        getContentPane().add(update_appointment_bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 570, 160, 30));

        refresh_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rodrigoservicecenter/resources/refresh-3104 (1).png"))); // NOI18N
        refresh_bt.setForeground(new java.awt.Color(102, 102, 102));
        refresh_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refresh_btActionPerformed(evt);
            }
        });
        getContentPane().add(refresh_bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 80, 30, 30));
        getContentPane().add(dateTimePicker, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 270, 30));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(102, 102, 102));
        jLabel17.setText("Select Service       :");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, 170, 30));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(102, 102, 102));
        jLabel18.setText("Select Time :");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 530, 130, 30));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(102, 102, 102));
        jLabel19.setText("Select Date :");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 530, 130, 30));
        getContentPane().add(dateTimePicker_updater, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 560, 270, 30));
        getContentPane().add(dateTimePickerSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 80, 290, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void delete_appointment_btActionPerformed(ActionEvent evt) {
        if (appointmentController.deleteAppointment(getSelectedAppointment().getAppointmentId())) {
            JOptionPane.showMessageDialog(null, "Appointment Deleted Successfully");
            refreshTable(appointmentController.getupcomingAppointments());
        }
    }

    private void serviceidActionPerformed(java.awt.event.ActionEvent evt) {}

    private void update_apponitment_serviceidActionPerformed(java.awt.event.ActionEvent evt) {}

    private void clear_btActionPerformed(java.awt.event.ActionEvent evt) {
        clearCreatePanel();
    }

    private void clearCreatePanel() {
        mobile_number.setText("");
        serviceid.setSelectedIndex(0);
        description.setText("");
        dateTimePicker.datePicker.setDate(null);
        dateTimePicker.timePicker.setTime(null);
    }

    public void clearUpdatePanel() {
        dateTimePicker_updater.datePicker.setDate(null);
        dateTimePicker_updater.timePicker.setTime(null);
        update_apponitment_serviceid.setSelectedIndex(0);
    }

    private void book_btActionPerformed(java.awt.event.ActionEvent evt) {

        if (CreatePanalValidate()){

            Customer customer = customerController.getCustomerByContactNumber(Integer.parseInt(mobile_number.getText()));

            Appointment appointment = new Appointment();
            appointment.setScheduledDate(addDate(dateTimePicker.datePicker.getDate(), dateTimePicker.timePicker.getTime()));
            appointment.setScheduledTime(addTime(dateTimePicker.timePicker.getTime(), dateTimePicker.datePicker.getDate()));
            appointment.setCustomer(customerController.getCustomerByContactNumber(Integer.parseInt(mobile_number.getText())));
            appointment.setCustomer(customer);
            appointment.setVehicle(customerController.getVehicleByCustomerId(customer.getCustomerId()));
            appointment.setService(appointmentController.getServiceById(serviceid.getSelectedIndex()));
            appointment.setOutlet(employee.getOutlet());
            appointment.setDescription(description.getText());
            appointment.setStatus("Pending");
            if (appointmentController.addAppointment(appointment)) {
                JOptionPane.showMessageDialog(null, "Appointment Booked Successfully");
                refreshTable(appointmentController.getupcomingAppointments());
                clearCreatePanel();
            }
        }
    }

    private Time addTime(LocalTime time, LocalDate date) {
        if (time != null && date != null) {
            LocalDateTime selectedDateTime = LocalDateTime.of(date, time);
            if (selectedDateTime.isBefore(LocalDateTime.now())) {
                System.out.println("invalid time and date");
                return null;
            }
        }
        return (time != null) ? Time.valueOf(time) : null;
    }

    private Date addDate(LocalDate date, LocalTime time) {
        if (date != null && time != null) {
            LocalDateTime selectedDateTime = LocalDateTime.of(date, time);
            if (selectedDateTime.isBefore(LocalDateTime.now())) {
                System.out.println("invalid time and date");
                return null;
            }
        }
        return (date != null) ? Date.valueOf(date) : null;
    }


    private void search_appointment_btActionPerformed(java.awt.event.ActionEvent evt) {
        LocalDate localDate = dateTimePickerSearch.datePicker.getDate();
        LocalTime localTime = dateTimePickerSearch.timePicker.getTime();

        java.sql.Date sqlDate = (localDate != null) ? Date.valueOf(localDate) : null;
        java.sql.Time sqlTime = (localTime != null) ? Time.valueOf(localTime) : null;

        //Integer outletId = (Select_oulet.getSelectedIndex() != 0) ? Select_oulet.getSelectedIndex() : null;

        refreshTable(appointmentController.searchAppointments(sqlDate, sqlTime, null));
    }

    private void refresh_btActionPerformed(java.awt.event.ActionEvent evt) {
        refreshTable(appointmentController.getAllAppointments());
    }

    private void update_appointment_btActionPerformed(java.awt.event.ActionEvent evt) {
        Appointment appointment = getSelectedAppointment();
        if (UpdatePanalValidate()) {
            Appointment updateAppointment = new Appointment();
            updateAppointment.setAppointmentId(appointment.getAppointmentId());
            if (update_apponitment_serviceid.getSelectedIndex() == 0) {
                updateAppointment.setService(appointment.getService());
            } else {
                updateAppointment.setService(appointmentController.getServiceById(update_apponitment_serviceid.getSelectedIndex()));
            }
            if(dateTimePicker_updater.datePicker.getDate() == null){
                updateAppointment.setScheduledDate(appointment.getScheduledDate());
            } else {
                updateAppointment.setScheduledDate(addDate(dateTimePicker_updater.datePicker.getDate(), dateTimePicker_updater.timePicker.getTime()));
            }
            if(dateTimePicker_updater.timePicker.getTime() == null){
                updateAppointment.setScheduledTime(appointment.getScheduledTime());
            } else {
                updateAppointment.setScheduledTime(addTime(dateTimePicker_updater.timePicker.getTime(), dateTimePicker_updater.datePicker.getDate()));
            }
            updateAppointment.setCustomer(appointment.getCustomer());
            updateAppointment.setVehicle(appointment.getVehicle());
            updateAppointment.setOutlet(appointment.getOutlet());
            updateAppointment.setDescription(appointment.getDescription());
            updateAppointment.setStatus(appointment.getStatus());
            updateAppointment.setAppointmentId(appointment.getAppointmentId());
            if (appointmentController.updateAppointment(updateAppointment)) {
                JOptionPane.showMessageDialog(null, "Appointment Updated Successfully");
                refreshTable(appointmentController.getupcomingAppointments());
                clearUpdatePanel();
                System.out.println(updateAppointment.getService().getServiceName() + " " + appointment.getService().getServiceName());
            }
        }
    }

    private void refreshTable(List<Appointment> appointments) {
        model.setRowCount(0);
        for (Appointment appointment : appointments) {
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
            displayedAppointments.add(appointment);
        }
        upcoming_appointment.setModel(model);
    }

    private Appointment getSelectedAppointment() {
        int selectedRow = upcoming_appointment.getSelectedRow();
        if (selectedRow >= 0 && selectedRow < displayedAppointments.size()) {
            return displayedAppointments.get(selectedRow);
        }else{
            JOptionPane.showMessageDialog(this, "Please select an appointment.");
            return null;
        }
    }

    private boolean CreatePanalValidate() {
        if (mobile_number.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please select a vehicle.");
            return false;
        }
        if (serviceid.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Please select a service.");
            return false;
        }
        if (dateTimePicker.datePicker.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Please select a date.");
            return false;
        }
        if (dateTimePicker.timePicker.getTime() == null) {
            JOptionPane.showMessageDialog(this, "Please select a time.");
            return false;
        }
        return true;
    }

    private boolean UpdatePanalValidate() {
        return true;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton book_bt;
    private javax.swing.JButton clear_bt;
    private com.github.lgooddatepicker.components.DateTimePicker dateTimePicker;
    private com.github.lgooddatepicker.components.DateTimePicker dateTimePickerSearch;
    private com.github.lgooddatepicker.components.DateTimePicker dateTimePicker_updater;
    private javax.swing.JButton delete_appointment_bt;
    private javax.swing.JTextPane description;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField mobile_number;
    private javax.swing.JButton refresh_bt;
    private javax.swing.JButton search_appointment_bt;
    private javax.swing.JComboBox<String> serviceid;
    private javax.swing.JTable upcoming_appointment;
    private javax.swing.JButton update_appointment_bt;
    private javax.swing.JComboBox<String> update_apponitment_serviceid;
    // End of variables declaration//GEN-END:variables
}
