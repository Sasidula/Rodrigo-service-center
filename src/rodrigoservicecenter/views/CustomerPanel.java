/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package rodrigoservicecenter.views;

import rodrigoservicecenter.controller.CustomerController;
import rodrigoservicecenter.model.entity.Customer;
import rodrigoservicecenter.model.entity.Employee;
import rodrigoservicecenter.model.entity.Vehicle;

import javax.swing.*;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CustomerPanel extends javax.swing.JInternalFrame {

    Employee employee;

    CustomerController customerController = new CustomerController();

    String[] columnNames = {"Username", "Email", "Address", "Contact Number", "Vehicle"};
    List<Customer> displayedCustomers = new ArrayList<>(); // keep reference list
    DefaultTableModel model = new DefaultTableModel(columnNames, 0); // table model

    public CustomerPanel(Employee gotEmployee) {

        employee = gotEmployee;

        initComponents();

        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0)); 
        BasicInternalFrameUI ui= (BasicInternalFrameUI) this.getUI(); 
        ui.setNorthPane (null);

        ((AbstractDocument) mobile_number.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr)
                    throws BadLocationException {
                if (string == null) return;
                if (string.matches("\\d*")) {
                    super.insertString(fb, offset, string, attr);
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
                    throws BadLocationException {
                if (text == null) return;
                if (text.matches("\\d*")) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });

        ((AbstractDocument) nic.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr)
                    throws BadLocationException {
                if (string == null) return;
                if (string.matches("\\d*")) {
                    super.insertString(fb, offset, string, attr);
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
                    throws BadLocationException {
                if (text == null) return;
                if (text.matches("\\d*")) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });

        mileage_combo.removeAllItems();
        mileage_combo.addItem("");
        mileage_combo.addItem("0 - 10,000 miles");
        mileage_combo.addItem("10,001 - 50,000 miles");
        mileage_combo.addItem("50,001 - 100,000 miles");
        mileage_combo.addItem("100,001 - 200,000 miles");
        mileage_combo.addItem("200,001+ miles");

        refreshTable();
        clearForm();

    }

    private int getMileage() {
        String mileage = Objects.requireNonNull(mileage_combo.getSelectedItem()).toString();
        switch (mileage) {
            case "":
                mileage = "0";
                break;
            case "0 - 10,000 miles":
                mileage = "10000";
                break;
            case "10,001 - 50,000 miles":
                mileage = "50000";
                break;
            case "50,001 - 100,000 miles":
                mileage = "100000";
                break;
            case "100,001 - 200,000 miles":
                mileage = "200000";
                break;
            case "200,001+ miles":
                mileage = "500000";
                break;
            default:
                break;
        }

        return Integer.parseInt(mileage);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        refresh_bt = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        search_customer = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        customers = new javax.swing.JTable();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        name = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        address = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        nic = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        mobile_number = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel18 = new javax.swing.JLabel();
        cus_update_bt = new javax.swing.JButton();
        password = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel13 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jSeparator11 = new javax.swing.JSeparator();
        veh_update_bt = new javax.swing.JButton();
        jSeparator12 = new javax.swing.JSeparator();
        vehicleModel = new javax.swing.JTextField();
        jSeparator13 = new javax.swing.JSeparator();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        carYearScroller = new javax.swing.JSpinner();
        LastServiceDate = new com.toedter.calendar.JDateChooser();
        jLabel27 = new javax.swing.JLabel();
        petrolBt = new javax.swing.JRadioButton();
        dieselBt = new javax.swing.JRadioButton();
        fualOtherBt = new javax.swing.JRadioButton();
        jLabel28 = new javax.swing.JLabel();
        mileage_combo = new javax.swing.JComboBox<>();
        jSeparator10 = new javax.swing.JSeparator();
        jSeparator14 = new javax.swing.JSeparator();
        jSeparator15 = new javax.swing.JSeparator();
        jLabel21 = new javax.swing.JLabel();
        search_bt1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1240, 700));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rodrigoservicecenter/resources/6.png"))); // NOI18N
        jLabel1.setText("Customer");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 0, 340, 180));

        refresh_bt.setForeground(new java.awt.Color(102, 102, 102));
        refresh_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rodrigoservicecenter/resources/refresh-3104 (1).png"))); // NOI18N
        refresh_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refresh_btActionPerformed(evt);
            }
        });
        getContentPane().add(refresh_bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 70, 30, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rodrigoservicecenter/resources/icons8-search-40.png"))); // NOI18N
        jLabel3.setText("jLabel1");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 40, 50));
        getContentPane().add(search_customer, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 250, 30));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(102, 102, 102));
        jLabel14.setText("Search Customer");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        customers.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(customers);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 730, 550));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        name.setText("Enter name");
        name.setActionCommand("null");
        name.setBorder(null);
        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });
        jPanel1.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 360, 30));

        jSeparator2.setForeground(new java.awt.Color(0, 51, 153));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 360, 10));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Name");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 140, -1));

        email.setText("E-mail");
        email.setActionCommand("null");
        email.setBorder(null);
        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });
        jPanel1.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 360, 30));

        jSeparator3.setForeground(new java.awt.Color(0, 51, 153));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 360, 10));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("E-mail");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 140, -1));

        address.setText("Address");
        address.setActionCommand("null");
        address.setBorder(null);
        address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressActionPerformed(evt);
            }
        });
        jPanel1.add(address, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 360, 30));

        jSeparator4.setForeground(new java.awt.Color(0, 51, 153));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 360, 10));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setText("Address");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 160, -1));

        nic.setText("Enter name");
        nic.setActionCommand("null");
        nic.setBorder(null);
        nic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nicActionPerformed(evt);
            }
        });
        jPanel1.add(nic, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 360, 30));

        jSeparator5.setForeground(new java.awt.Color(0, 51, 153));
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 360, 10));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setText("NIC");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 130, -1));

        jSeparator6.setForeground(new java.awt.Color(0, 51, 153));
        jPanel1.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 360, 10));

        mobile_number.setText("Enter name");
        mobile_number.setActionCommand("null");
        mobile_number.setBorder(null);
        mobile_number.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mobile_numberActionPerformed(evt);
            }
        });
        jPanel1.add(mobile_number, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 360, 30));

        jSeparator7.setForeground(new java.awt.Color(0, 51, 153));
        jPanel1.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 360, 10));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(102, 102, 102));
        jLabel18.setText("Mobile Number");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 130, -1));

        cus_update_bt.setBackground(new java.awt.Color(0, 51, 153));
        cus_update_bt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cus_update_bt.setForeground(new java.awt.Color(255, 255, 255));
        cus_update_bt.setText("Update");
        cus_update_bt.setBorder(null);
        cus_update_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cus_update_btActionPerformed(evt);
            }
        });
        jPanel1.add(cus_update_bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 360, 40));

        password.setText("Enter name");
        password.setActionCommand("null");
        password.setBorder(null);
        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });
        jPanel1.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 360, 30));

        jSeparator8.setForeground(new java.awt.Color(0, 51, 153));
        jPanel1.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 360, 10));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 102, 102));
        jLabel13.setText("Password");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 130, -1));

        jTabbedPane1.addTab("Customer", jPanel1);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator11.setForeground(new java.awt.Color(0, 51, 153));
        jPanel2.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 360, 10));

        veh_update_bt.setBackground(new java.awt.Color(0, 51, 153));
        veh_update_bt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        veh_update_bt.setForeground(new java.awt.Color(255, 255, 255));
        veh_update_bt.setText("Update");
        veh_update_bt.setBorder(null);
        veh_update_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                veh_update_btActionPerformed(evt);
            }
        });
        jPanel2.add(veh_update_bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 360, 40));

        jSeparator12.setForeground(new java.awt.Color(0, 51, 153));
        jPanel2.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 360, 10));

        vehicleModel.setText("Vehicles");
        vehicleModel.setActionCommand("null");
        vehicleModel.setBorder(null);
        vehicleModel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vehicleModelActionPerformed(evt);
            }
        });
        jPanel2.add(vehicleModel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 360, 30));

        jSeparator13.setForeground(new java.awt.Color(0, 51, 153));
        jPanel2.add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 80, 10));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(102, 102, 102));
        jLabel25.setText("Mileage");
        jPanel2.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 110, -1));

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(102, 102, 102));
        jLabel26.setText("Fual Type :");
        jPanel2.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 80, -1));

        carYearScroller.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(carYearScroller, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 80, 30));
        jPanel2.add(LastServiceDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 250, 30));

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(102, 102, 102));
        jLabel27.setText("Year");
        jPanel2.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 160, -1));

        petrolBt.setText("Petrol");
        jPanel2.add(petrolBt, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 370, -1, -1));

        dieselBt.setText(" Diesel");
        jPanel2.add(dieselBt, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 370, -1, -1));

        fualOtherBt.setText("Other");
        jPanel2.add(fualOtherBt, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 370, -1, -1));

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(102, 102, 102));
        jLabel28.setText("Last Service Date");
        jPanel2.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 160, -1));

        mileage_combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0 - 10,000 miles", "10,001 - 50,000 miles", "50,001 - 100,000 miles", "100,001 - 200,000 miles", "200,001+ miles" }));
        jPanel2.add(mileage_combo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 360, 30));

        jSeparator10.setForeground(new java.awt.Color(0, 51, 153));
        jPanel2.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 360, 10));

        jSeparator14.setForeground(new java.awt.Color(0, 51, 153));
        jPanel2.add(jSeparator14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 250, 10));

        jSeparator15.setForeground(new java.awt.Color(0, 51, 153));
        jPanel2.add(jSeparator15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 360, 10));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(102, 102, 102));
        jLabel21.setText("Vehicle Model");
        jPanel2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 160, -1));

        jTabbedPane1.addTab("Vehicle", jPanel2);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 190, 400, 510));

        search_bt1.setForeground(new java.awt.Color(102, 102, 102));
        search_bt1.setText("Search");
        search_bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_bt1ActionPerformed(evt);
            }
        });
        getContentPane().add(search_bt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 70, 160, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {}

    private void mobile_numberActionPerformed(java.awt.event.ActionEvent evt) {}

    private void nicActionPerformed(java.awt.event.ActionEvent evt) {}

    private void addressActionPerformed(java.awt.event.ActionEvent evt) {}

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {}

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {}

    private void vehicleModelActionPerformed(java.awt.event.ActionEvent evt) {}

    private void search_bt1ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        if (search_customer.getText().isEmpty()) {
            refreshTable();
        } else {
            displayedCustomers.clear(); // clear before refill
            model.setRowCount(0);       // reset table rows
            filterTableByName();
        }
    }

    private void refresh_btActionPerformed(java.awt.event.ActionEvent evt) {                                           
        refreshTable();
    }

    private void cus_update_btActionPerformed(java.awt.event.ActionEvent evt) {                                              
        Customer selectedCustomer = getSelectedCustomer();

        if (selectedCustomer != null) {
            Customer updatedCustomer = getCustomer();
            updatedCustomer.setCustomerId(selectedCustomer.getCustomerId());

            // Preserve unchanged fields
            if (updatedCustomer.getUsername().isEmpty()) updatedCustomer.setUsername(selectedCustomer.getUsername());
            if (updatedCustomer.getPassword() == null || updatedCustomer.getPassword().isEmpty()) updatedCustomer.setPassword(selectedCustomer.getPassword());
            if (updatedCustomer.getEmail().isEmpty()) updatedCustomer.setEmail(selectedCustomer.getEmail());
            if (updatedCustomer.getAddress().isEmpty()) updatedCustomer.setAddress(selectedCustomer.getAddress());
            if (updatedCustomer.getContactNumber() == 0) updatedCustomer.setContactNumber(selectedCustomer.getContactNumber());

            updatedCustomer.setRegistrationDate(selectedCustomer.getRegistrationDate());

            boolean success = customerController.updateCustomer(updatedCustomer);

            if (success) {
                JOptionPane.showMessageDialog(this, "Customer updated successfully.");
                refreshTable();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to update customer.");
            }

        } else {
            JOptionPane.showMessageDialog(this, "Please select a customer to update.");
        }
    }

    private void veh_update_btActionPerformed(java.awt.event.ActionEvent evt) {                                              
        Customer selectedCustomer = getSelectedCustomer();

        if (selectedCustomer != null) {
            Vehicle existingVehicle = customerController.getVehicleByCustomerId(selectedCustomer.getCustomerId());
            Vehicle updatedVehicle = getVehicle(selectedCustomer);

            updatedVehicle.setCustomer(selectedCustomer);

            boolean success = false;

            if (existingVehicle == null) {
                JOptionPane.showMessageDialog(this, "Please select a vehicle to update.");
                success = false;
            } else {
                updatedVehicle.setVehicleId(existingVehicle.getVehicleId());
                if (updatedVehicle.getModel().isEmpty()) updatedVehicle.setModel(existingVehicle.getModel());
                if (updatedVehicle.getYear() == 0) updatedVehicle.setYear(existingVehicle.getYear());
                if (updatedVehicle.getFuelType().isEmpty()) updatedVehicle.setFuelType(existingVehicle.getFuelType());
                if (updatedVehicle.getLastServicedDate() == null) updatedVehicle.setLastServicedDate(existingVehicle.getLastServicedDate());
                if (updatedVehicle.getMileage() == 0) updatedVehicle.setMileage(existingVehicle.getMileage());

                success = customerController.updateVehicle(updatedVehicle);
            }

            if (success) {
                JOptionPane.showMessageDialog(this, "Vehicle updated successfully.");
                refreshTable();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to update vehicle.");
            }

        } else {
            JOptionPane.showMessageDialog(this, "Please select a customer to update vehicle.");
        }

    }

    public void refreshTable() {
        displayedCustomers.clear(); // clear before refill
        model.setRowCount(0);       // reset table rows

        List<Customer> customerList = customerController.getAllCustomers();

        for (Customer customer : customerList) {
            Vehicle vehicle = customerController.getVehicleByCustomerId(customer.getCustomerId());
            Object[] rowData = {
                    customer.getUsername(),
                    customer.getEmail(),
                    customer.getAddress(),
                    customer.getContactNumber(),
                    (vehicle != null) ? vehicle.getModel() : "N/A"
            };
            model.addRow(rowData);
            displayedCustomers.add(customer); // keep track
        }
        customers.setModel(model);
    }


    private void filterTableByName() {
        String searchTerm = search_customer.getText();
        List<Customer> filteredCustomers = customerController.searchCustomers(searchTerm);

        for (Customer customer : filteredCustomers) {
            Vehicle vehicle = customerController.getVehicleByCustomerId(customer.getCustomerId());

            Object[] rowData = {
                    customer.getUsername(),
                    customer.getEmail(),
                    customer.getAddress(),
                    customer.getContactNumber(),
                    (vehicle != null) ? vehicle.getModel() : "N/A"
            };

            model.addRow(rowData);
            displayedCustomers.add(customer); // track customer corresponding to row
        }

        customers.setModel(model);
    }

    private void DeleteCustomer(){
        Customer selectedCustomer = getSelectedCustomer();
        if (selectedCustomer != null) {
            if (customerController.deleteCustomer(selectedCustomer.getCustomerId())) {
                JOptionPane.showMessageDialog(this, "Customer deleted successfully.");
                refreshTable();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to delete customer.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a customer to delete.");
        }
    }

    private Customer getSelectedCustomer() {
        int selectedRow = customers.getSelectedRow();
        if (selectedRow != -1) {
            return displayedCustomers.get(selectedRow);
        }
        return null;
    }


    private  Customer getCustomer() {
        Customer customer = new Customer();
        customer.setUsername(name.getText());
        customer.setEmail(email.getText());
        customer.setAddress(address.getText());
        //customer.setNic(nic.getText());
        customer.setPassword(password.getText());
        String contactStr = mobile_number.getText().trim();
        if (!contactStr.isEmpty() && contactStr.matches("\\d+")) {
            customer.setContactNumber(Integer.parseInt(contactStr));
        } else {
            customer.setContactNumber(0);
        }
        return customer;
    }

    private  Vehicle getVehicle(Customer customerData) {

        Vehicle vehicle = new Vehicle();
        vehicle.setCustomer(customerData);
        vehicle.setModel(vehicleModel.getText());
        vehicle.setYear((int)carYearScroller.getValue());
        if (petrolBt.isSelected()) {
            vehicle.setFuelType("Petrol");
        } else if (dieselBt.isSelected()) {
            vehicle.setFuelType("Diesel");
        } else if (fualOtherBt.isSelected()) {
            vehicle.setFuelType("Other");
        } else {
            vehicle.setFuelType("");
        }
        java.util.Date utilDate = LastServiceDate.getDate();
        java.sql.Date sqlDate = utilDate != null ? new java.sql.Date(utilDate.getTime()) : null;
        vehicle.setLastServicedDate(sqlDate);
        vehicle.setMileage(getMileage());
        return vehicle;
    }

    private void clearForm() {
        name.setText("");
        email.setText("");
        address.setText("");
        mobile_number.setText("");
        nic.setText("");
        password.setText("");
        vehicleModel.setText("");
        petrolBt.setSelected(false);
        dieselBt.setSelected(false);
        fualOtherBt.setSelected(false);
        LastServiceDate.setDate(null);
        mileage_combo.setSelectedIndex(0);
        yearValue();
    }

    private void yearValue() {
        carYearScroller.setModel(new javax.swing.SpinnerNumberModel(0, 0, 2030, 1));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser LastServiceDate;
    private javax.swing.JTextField address;
    private javax.swing.JSpinner carYearScroller;
    private javax.swing.JButton cus_update_bt;
    private javax.swing.JTable customers;
    private javax.swing.JRadioButton dieselBt;
    private javax.swing.JTextField email;
    private javax.swing.JRadioButton fualOtherBt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JComboBox<String> mileage_combo;
    private javax.swing.JTextField mobile_number;
    private javax.swing.JTextField name;
    private javax.swing.JTextField nic;
    private javax.swing.JTextField password;
    private javax.swing.JRadioButton petrolBt;
    private javax.swing.JButton refresh_bt;
    private javax.swing.JButton search_bt1;
    private javax.swing.JTextField search_customer;
    private javax.swing.JButton veh_update_bt;
    private javax.swing.JTextField vehicleModel;
    // End of variables declaration//GEN-END:variables
}
