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
import javax.swing.text.*;
import java.sql.Date;
import java.util.Objects;


public class RegisterPanel extends javax.swing.JInternalFrame {

    public RegisterPanel(Employee employee) {

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


        clearForm();
        yearValue();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel2 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
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
        vehicleModel = new javax.swing.JTextField();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        register_bt = new javax.swing.JButton();
        username = new javax.swing.JLabel();
        mobile_number = new javax.swing.JTextField();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel18 = new javax.swing.JLabel();
        password = new javax.swing.JTextField();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        carYearScroller = new javax.swing.JSpinner();
        LastServiceDate = new com.toedter.calendar.JDateChooser();
        jLabel19 = new javax.swing.JLabel();
        petrolBt = new javax.swing.JRadioButton();
        dieselBt = new javax.swing.JRadioButton();
        fualOtherBt = new javax.swing.JRadioButton();
        jLabel20 = new javax.swing.JLabel();
        mileage_combo = new javax.swing.JComboBox<>();
        jSeparator10 = new javax.swing.JSeparator();
        jSeparator11 = new javax.swing.JSeparator();
        jSeparator12 = new javax.swing.JSeparator();
        jLabel21 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1240, 700));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rodrigoservicecenter/resources/4.png"))); // NOI18N
        jLabel2.setText("register");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 180, 340, 170));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 153, 0));
        jLabel14.setText("Welcome to Rodrigo Service Center");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 400, -1, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 102, 204));
        jLabel13.setText("New Customer");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, -1, -1));

        jLabel15.setText("Lorem Ipsum is simply dummy text of the printing and typesetting industry. ");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 430, -1, -1));

        name.setText("Enter name");
        name.setActionCommand("null");
        name.setBorder(null);
        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });
        getContentPane().add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 360, 30));

        jSeparator2.setForeground(new java.awt.Color(0, 51, 153));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, 360, 10));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Name");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 140, -1));

        email.setText("E-mail");
        email.setActionCommand("null");
        email.setBorder(null);
        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });
        getContentPane().add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 320, 360, 30));

        jSeparator3.setForeground(new java.awt.Color(0, 51, 153));
        getContentPane().add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 350, 360, 10));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("E-mail");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 300, 140, -1));

        address.setText("Address");
        address.setActionCommand("null");
        address.setBorder(null);
        address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressActionPerformed(evt);
            }
        });
        getContentPane().add(address, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 380, 360, 30));

        jSeparator4.setForeground(new java.awt.Color(0, 51, 153));
        getContentPane().add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 410, 360, 10));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setText("Address");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 360, 160, -1));

        nic.setText("Enter nic");
        nic.setActionCommand("null");
        nic.setBorder(null);
        nic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nicActionPerformed(evt);
            }
        });
        getContentPane().add(nic, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 200, 360, 30));

        jSeparator5.setForeground(new java.awt.Color(0, 51, 153));
        getContentPane().add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 230, 360, 10));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setText("NIC");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, 130, -1));

        vehicleModel.setText("Vehicles");
        vehicleModel.setActionCommand("null");
        vehicleModel.setBorder(null);
        vehicleModel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vehicleModelActionPerformed(evt);
            }
        });
        getContentPane().add(vehicleModel, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 450, 360, 30));

        jSeparator6.setForeground(new java.awt.Color(0, 51, 153));
        getContentPane().add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 600, 80, 10));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(102, 102, 102));
        jLabel16.setText("Mileage");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 490, 110, -1));

        register_bt.setBackground(new java.awt.Color(0, 51, 153));
        register_bt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        register_bt.setForeground(new java.awt.Color(255, 255, 255));
        register_bt.setText("Register");
        register_bt.setBorder(null);
        register_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                register_btActionPerformed(evt);
            }
        });
        getContentPane().add(register_bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 660, 360, 30));

        username.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        username.setForeground(new java.awt.Color(0, 102, 204));
        username.setText("NIMAL");
        getContentPane().add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 350, -1, -1));

        mobile_number.setText("enter mobile number");
        mobile_number.setActionCommand("null");
        mobile_number.setBorder(null);
        mobile_number.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mobile_numberActionPerformed(evt);
            }
        });
        getContentPane().add(mobile_number, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 260, 360, 30));

        jSeparator7.setForeground(new java.awt.Color(0, 51, 153));
        getContentPane().add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 290, 360, 10));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(102, 102, 102));
        jLabel18.setText("Mobile Number");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 240, 130, -1));

        password.setText("Enter password");
        password.setActionCommand("null");
        password.setBorder(null);
        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });
        getContentPane().add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 360, 30));

        jSeparator8.setForeground(new java.awt.Color(0, 51, 153));
        getContentPane().add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 360, 10));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Password");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 140, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(102, 102, 102));
        jLabel17.setText("Fual Type :");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 620, 80, -1));

        carYearScroller.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(carYearScroller, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 570, 80, 30));
        getContentPane().add(LastServiceDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 570, 250, 30));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(102, 102, 102));
        jLabel19.setText("Year");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 550, 160, -1));

        buttonGroup1.add(petrolBt);
        petrolBt.setText("Petrol");
        getContentPane().add(petrolBt, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 620, -1, -1));

        buttonGroup1.add(dieselBt);
        dieselBt.setText(" Diesel");
        getContentPane().add(dieselBt, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 620, -1, -1));

        buttonGroup1.add(fualOtherBt);
        fualOtherBt.setText("Other");
        getContentPane().add(fualOtherBt, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 620, -1, -1));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(102, 102, 102));
        jLabel20.setText("Last Service Date");
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 550, 160, -1));

        mileage_combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0 - 10,000 miles", "10,001 - 50,000 miles", "50,001 - 100,000 miles", "100,001 - 200,000 miles", "200,001+ miles" }));
        getContentPane().add(mileage_combo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 510, 360, 30));

        jSeparator10.setForeground(new java.awt.Color(0, 51, 153));
        getContentPane().add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 540, 360, 10));

        jSeparator11.setForeground(new java.awt.Color(0, 51, 153));
        getContentPane().add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 600, 250, 10));

        jSeparator12.setForeground(new java.awt.Color(0, 51, 153));
        getContentPane().add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 480, 360, 10));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(102, 102, 102));
        jLabel21.setText("Vehicle Model");
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 430, 160, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {}

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {}

    private void addressActionPerformed(java.awt.event.ActionEvent evt) {}

    private void nicActionPerformed(java.awt.event.ActionEvent evt) {}

    private void vehicleModelActionPerformed(java.awt.event.ActionEvent evt) {}

    private void mobile_numberActionPerformed(java.awt.event.ActionEvent evt) {}

    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {}

    private void register_btActionPerformed(java.awt.event.ActionEvent evt) {

        if (validateCustomerForm()) {

            Customer customer = getCustomer();
            CustomerController customerController = new CustomerController();
            Customer customerData = customerController.addCustomer(customer);

            if (customerData == null) {
                JOptionPane.showMessageDialog(this, "Customer Registration Failed");
            } else {

                JOptionPane.showMessageDialog(this, "Customer Registered Successfully");

                Vehicle vehicle = getVehicle(customerData);

                if (customerController.addVehicle(vehicle)) {
                    JOptionPane.showMessageDialog(this, "Vehicle Registered Successfully");
                    clearForm();
                } else {
                    JOptionPane.showMessageDialog(this, "Vehicle Registration Failed");
                }

            }

        }else {
            JOptionPane.showMessageDialog(this, "Please fill all the fields");
        }

    }

    private Customer getCustomer() {
        Customer customer = new Customer();
        customer.setUsername(name.getText());
        customer.setEmail(email.getText());
        customer.setAddress(address.getText());
        //customer.setNic(nic.getText());
        customer.setContactNumber(Integer.parseInt(mobile_number.getText()));
        customer.setPassword(password.getText());
        customer.setRegistrationDate(new Date(System.currentTimeMillis()));
        return customer;
    }

    private Vehicle getVehicle(Customer customerData) {
        Vehicle vehicle = new Vehicle();
        vehicle.setCustomer(customerData);
        vehicle.setModel(vehicleModel.getText());
        vehicle.setYear((int)carYearScroller.getValue());
        if (petrolBt.isSelected()) {
            vehicle.setFuelType("Petrol");
        } else if (dieselBt.isSelected()) {
            vehicle.setFuelType("Diesel");
        } else {
            vehicle.setFuelType("Other");
        }

        // Get java.util.Date from JDateChooser
        java.util.Date utilDate = LastServiceDate.getDate();

        // Convert to java.sql.Date
        java.sql.Date sqlDate = utilDate != null ? new java.sql.Date(utilDate.getTime()) : null;

        // Set the converted date
        vehicle.setLastServicedDate(sqlDate);
        vehicle.setMileage(getMileage());
        return vehicle;
    }

    private boolean validateCustomerForm() {
        if (name.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter name");
            return false;
        } else if (email.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter email");
            return false;
        } else if (address.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter address");
            return false;
        } else if (mobile_number.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter mobile number");
            return false;
        } else if (password.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter password");
            return false;
        } else if (vehicleModel.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter vehicle model");
            return false;
        } else if (!petrolBt.isSelected() && !dieselBt.isSelected() && !fualOtherBt.isSelected()) {
            JOptionPane.showMessageDialog(this, "Please select fuel type");
            return false;
        } else if (LastServiceDate.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Please select last service date");
            return false;
        }
        else if (carYearScroller.getValue() == null) {
            JOptionPane.showMessageDialog(this, "Please select car year");
            return false;
        }
        else if (mileage_combo.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Please select mileage");
            return false;
        }
        else {
            return true;
        }
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
        carYearScroller.setModel(new javax.swing.SpinnerNumberModel(2000, 1900, 2030, 1));
    }

    private int getMileage() {
        String mileage = Objects.requireNonNull(mileage_combo.getSelectedItem()).toString();
        switch (mileage) {
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser LastServiceDate;
    private javax.swing.JTextField address;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JSpinner carYearScroller;
    private javax.swing.JRadioButton dieselBt;
    private javax.swing.JTextField email;
    private javax.swing.JRadioButton fualOtherBt;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JComboBox<String> mileage_combo;
    private javax.swing.JTextField mobile_number;
    private javax.swing.JTextField name;
    private javax.swing.JTextField nic;
    private javax.swing.JTextField password;
    private javax.swing.JRadioButton petrolBt;
    private javax.swing.JButton register_bt;
    private javax.swing.JLabel username;
    private javax.swing.JTextField vehicleModel;
    // End of variables declaration//GEN-END:variables
}