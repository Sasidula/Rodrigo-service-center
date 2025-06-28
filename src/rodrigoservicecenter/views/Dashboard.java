package rodrigoservicecenter.views;

import rodrigoservicecenter.model.entity.Employee;

import java.awt.*;
import javax.swing.*;

public class Dashboard extends javax.swing.JFrame {

    Employee employee;

    Color DefaultColor, ClickedColor;

    public Dashboard(Employee gotEmployee) {

        employee = gotEmployee;

        initComponents();

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        //setLocationRelativeTo(null);
        setVisible(true);
        DefaultColor = new Color(0, 51, 153);
        ClickedColor = new Color(255, 153, 0);

        sell.setBackground(DefaultColor);
        book.setBackground(DefaultColor);
        register.setBackground(DefaultColor);
        customer.setBackground(DefaultColor);
        appoinment.setBackground(DefaultColor);
        stock.setBackground(DefaultColor);

        username.setText(employee.getName());

        title.setText("Welcome, " + employee.getName());
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Arial", Font.BOLD, 20));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        sell = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        register = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        customer = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        stock = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        book = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        appoinment = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        report = new javax.swing.JPanel();
        view_report_bt = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        title = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        mainpanel = new javax.swing.JDesktopPane();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        username = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 51, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Rodrigo");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 34, 174, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 153, 0));
        jLabel2.setText("Service Center");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 88, 197, 24));

        sell.setBackground(new java.awt.Color(0, 51, 153));
        sell.setForeground(new java.awt.Color(255, 255, 255));
        sell.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sellMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                sellMousePressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rodrigoservicecenter/resources/icons8-sell-40.png"))); // NOI18N
        jLabel5.setText("  Sell Products");

        javax.swing.GroupLayout sellLayout = new javax.swing.GroupLayout(sell);
        sell.setLayout(sellLayout);
        sellLayout.setHorizontalGroup(
            sellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sellLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );
        sellLayout.setVerticalGroup(
            sellLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sellLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(15, 15, 15))
        );

        jPanel1.add(sell, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 171, 290, 60));

        register.setBackground(new java.awt.Color(0, 51, 153));
        register.setForeground(new java.awt.Color(255, 255, 255));
        register.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registerMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                registerMousePressed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rodrigoservicecenter/resources/icons8-register-40.png"))); // NOI18N
        jLabel7.setText("  Register Customer");

        javax.swing.GroupLayout registerLayout = new javax.swing.GroupLayout(register);
        register.setLayout(registerLayout);
        registerLayout.setHorizontalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, registerLayout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        registerLayout.setVerticalGroup(
            registerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, registerLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(register, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 290, 60));

        customer.setBackground(new java.awt.Color(0, 51, 153));
        customer.setForeground(new java.awt.Color(255, 255, 255));
        customer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                customerMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                customerMousePressed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rodrigoservicecenter/resources/icons8-user-35.png"))); // NOI18N
        jLabel8.setText("   View Customer");

        javax.swing.GroupLayout customerLayout = new javax.swing.GroupLayout(customer);
        customer.setLayout(customerLayout);
        customerLayout.setHorizontalGroup(
            customerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, customerLayout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        customerLayout.setVerticalGroup(
            customerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel1.add(customer, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 290, 60));

        stock.setBackground(new java.awt.Color(0, 51, 153));
        stock.setForeground(new java.awt.Color(255, 255, 255));
        stock.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stockMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                stockMousePressed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rodrigoservicecenter/resources/icons8-product-40.png"))); // NOI18N
        jLabel10.setText("  Check Stock");

        javax.swing.GroupLayout stockLayout = new javax.swing.GroupLayout(stock);
        stock.setLayout(stockLayout);
        stockLayout.setHorizontalGroup(
            stockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(stockLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );
        stockLayout.setVerticalGroup(
            stockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(stockLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel1.add(stock, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 480, 284, 60));

        book.setBackground(new java.awt.Color(0, 51, 153));
        book.setForeground(new java.awt.Color(255, 255, 255));
        book.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bookMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                bookMousePressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rodrigoservicecenter/resources/icons8-appointment-40.png"))); // NOI18N
        jLabel6.setText("  Appointment");

        javax.swing.GroupLayout bookLayout = new javax.swing.GroupLayout(book);
        book.setLayout(bookLayout);
        bookLayout.setHorizontalGroup(
            bookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bookLayout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        bookLayout.setVerticalGroup(
            bookLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bookLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(book, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 290, 60));

        appoinment.setBackground(new java.awt.Color(0, 51, 153));
        appoinment.setForeground(new java.awt.Color(255, 255, 255));
        appoinment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                appoinmentMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                appoinmentMousePressed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rodrigoservicecenter/resources/icons8-time-40.png"))); // NOI18N
        jLabel13.setText("  Check Appointment");

        javax.swing.GroupLayout appoinmentLayout = new javax.swing.GroupLayout(appoinment);
        appoinment.setLayout(appoinmentLayout);
        appoinmentLayout.setHorizontalGroup(
            appoinmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 290, Short.MAX_VALUE)
            .addGroup(appoinmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(appoinmentLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel13)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        appoinmentLayout.setVerticalGroup(
            appoinmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
            .addGroup(appoinmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(appoinmentLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel13)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel1.add(appoinment, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 560, 290, 60));

        report.setBackground(new java.awt.Color(0, 51, 153));
        report.setForeground(new java.awt.Color(255, 255, 255));
        report.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reportMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                reportMousePressed(evt);
            }
        });

        view_report_bt.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        view_report_bt.setForeground(new java.awt.Color(255, 255, 255));
        view_report_bt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rodrigoservicecenter/resources/report-32.png"))); // NOI18N
        view_report_bt.setText("  View Reports");

        javax.swing.GroupLayout reportLayout = new javax.swing.GroupLayout(report);
        report.setLayout(reportLayout);
        reportLayout.setHorizontalGroup(
            reportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 290, Short.MAX_VALUE)
            .addGroup(reportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, reportLayout.createSequentialGroup()
                    .addContainerGap(39, Short.MAX_VALUE)
                    .addComponent(view_report_bt, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(66, Short.MAX_VALUE)))
        );
        reportLayout.setVerticalGroup(
            reportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
            .addGroup(reportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, reportLayout.createSequentialGroup()
                    .addContainerGap(14, Short.MAX_VALUE)
                    .addComponent(view_report_bt)
                    .addContainerGap(14, Short.MAX_VALUE)))
        );

        jPanel1.add(report, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 640, -1, 60));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 820));

        jPanel2.setBackground(new java.awt.Color(255, 153, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(255, 153, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 3)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 153, 0));
        jButton1.setText("Sign Out");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 60, 60, 10));

        title.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setText("Customer Registation");
        jPanel2.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 285, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rodrigoservicecenter/resources/icons8-sign-out-48.png"))); // NOI18N
        jLabel4.setText("Sign Out");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 20, -1, -1));

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 63, 310, 10));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 0, 1260, 90));

        mainpanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rodrigoservicecenter/resources/mechanic-auto-rapair-icon_18591-14025.jpg"))); // NOI18N
        jLabel11.setText("jLabel11");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 102, 204));
        jLabel12.setText("HI,");

        username.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        username.setForeground(new java.awt.Color(0, 102, 204));
        username.setText("NIMAL");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 153, 0));
        jLabel14.setText("Welcome to Rodrigo Service Center");

        jLabel15.setText("Lorem Ipsum is simply dummy text of the printing and typesetting industry. ");

        mainpanel.setLayer(jLabel11, javax.swing.JLayeredPane.DEFAULT_LAYER);
        mainpanel.setLayer(jLabel12, javax.swing.JLayeredPane.DEFAULT_LAYER);
        mainpanel.setLayer(username, javax.swing.JLayeredPane.DEFAULT_LAYER);
        mainpanel.setLayer(jLabel14, javax.swing.JLayeredPane.DEFAULT_LAYER);
        mainpanel.setLayer(jLabel15, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout mainpanelLayout = new javax.swing.GroupLayout(mainpanel);
        mainpanel.setLayout(mainpanelLayout);
        mainpanelLayout.setHorizontalGroup(
            mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainpanelLayout.createSequentialGroup()
                .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainpanelLayout.createSequentialGroup()
                        .addGap(401, 401, 401)
                        .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(mainpanelLayout.createSequentialGroup()
                        .addGap(356, 356, 356)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainpanelLayout.createSequentialGroup()
                        .addGap(514, 514, 514)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(375, Short.MAX_VALUE))
        );
        mainpanelLayout.setVerticalGroup(
            mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainpanelLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(username))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addContainerGap(142, Short.MAX_VALUE))
        );

        getContentPane().add(mainpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, 1250, 730));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void appoinmentMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_appoinmentMousePressed
        sell.setBackground(DefaultColor);
        book.setBackground(DefaultColor);
        register.setBackground(DefaultColor);
        customer.setBackground(DefaultColor);
        appoinment.setBackground(ClickedColor);
        stock.setBackground(DefaultColor);
        report.setBackground(DefaultColor);
    }//GEN-LAST:event_appoinmentMousePressed

    private void appoinmentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_appoinmentMouseClicked
        AppoinmentPanel AppoinmentPanel1 = new AppoinmentPanel(employee);
        mainpanel.removeAll();
        mainpanel.add(AppoinmentPanel1).setVisible(true);
    }//GEN-LAST:event_appoinmentMouseClicked

    private void stockMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stockMousePressed
        sell.setBackground(DefaultColor);
        book.setBackground(DefaultColor);
        register.setBackground(DefaultColor);
        customer.setBackground(DefaultColor);
        appoinment.setBackground(DefaultColor);
        stock.setBackground(ClickedColor);
        report.setBackground(DefaultColor);
    }//GEN-LAST:event_stockMousePressed

    private void stockMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stockMouseClicked
        StockPanel StockPanel1 = new StockPanel();
        mainpanel.removeAll();
        mainpanel.add(StockPanel1).setVisible(true);
    }//GEN-LAST:event_stockMouseClicked

    private void customerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerMousePressed
        sell.setBackground(DefaultColor);
        book.setBackground(DefaultColor);
        register.setBackground(DefaultColor);
        customer.setBackground(ClickedColor);
        appoinment.setBackground(DefaultColor);
        stock.setBackground(DefaultColor);
        report.setBackground(DefaultColor);
    }//GEN-LAST:event_customerMousePressed

    private void customerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerMouseClicked
        CustomerPanel CustomerPanel1 = new CustomerPanel(employee);
        mainpanel.removeAll();
        mainpanel.add(CustomerPanel1).setVisible(true);
    }//GEN-LAST:event_customerMouseClicked

    private void registerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerMousePressed
        sell.setBackground(DefaultColor);
        book.setBackground(DefaultColor);
        register.setBackground(ClickedColor);
        customer.setBackground(DefaultColor);
        appoinment.setBackground(DefaultColor);
        stock.setBackground(DefaultColor);
        report.setBackground(DefaultColor);
    }//GEN-LAST:event_registerMousePressed

    private void registerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerMouseClicked
        RegisterPanel RegisterPanel1 = new RegisterPanel(employee);
        mainpanel.removeAll();
        mainpanel.add(RegisterPanel1).setVisible(true);
    }//GEN-LAST:event_registerMouseClicked

    private void bookMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookMousePressed
        sell.setBackground(DefaultColor);
        book.setBackground(ClickedColor);
        register.setBackground(DefaultColor);
        customer.setBackground(DefaultColor);
        appoinment.setBackground(DefaultColor);
        stock.setBackground(DefaultColor);
        report.setBackground(DefaultColor);
    }//GEN-LAST:event_bookMousePressed

    private void bookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookMouseClicked
        BookPanel BookPanel1 = new BookPanel(employee);
        mainpanel.removeAll();
        mainpanel.add(BookPanel1).setVisible(true);
    }//GEN-LAST:event_bookMouseClicked

    private void sellMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sellMousePressed
        sell.setBackground(ClickedColor);
        book.setBackground(DefaultColor);
        register.setBackground(DefaultColor);
        customer.setBackground(DefaultColor);
        appoinment.setBackground(DefaultColor);
        stock.setBackground(DefaultColor);
        report.setBackground(DefaultColor);
    }//GEN-LAST:event_sellMousePressed

    private void sellMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sellMouseClicked
        SellPanel SellPanel1 = new SellPanel(employee);
        mainpanel.removeAll();
        mainpanel.add(SellPanel1).setVisible(true);
    }//GEN-LAST:event_sellMouseClicked

    private void reportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportMouseClicked
        Report Report = new Report();
        mainpanel.removeAll();
        mainpanel.add(Report).setVisible(true);
    }//GEN-LAST:event_reportMouseClicked

    private void reportMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportMousePressed
        sell.setBackground(DefaultColor);
        book.setBackground(DefaultColor);
        register.setBackground(DefaultColor);
        customer.setBackground(DefaultColor);
        appoinment.setBackground(DefaultColor);
        stock.setBackground(DefaultColor);
        report.setBackground(ClickedColor);
    }//GEN-LAST:event_reportMousePressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
    }

    /*
    
    private void sellMousePressed(java.awt.event.MouseEvent evt) {
        sell.setBackground (ClickedColor); 
        book.setBackground (DefaultColor); 
        register.setBackground (DefaultColor); 
        customer.setBackground (DefaultColor); 
        appoinment.setBackground (DefaultColor); 
        stock.setBackground (DefaultColor);
    }
    
    

    private void bookMousePressed(java.awt.event.MouseEvent evt) {
        sell.setBackground (DefaultColor); 
        book.setBackground (ClickedColor); 
        register.setBackground (DefaultColor); 
        customer.setBackground (DefaultColor); 
        appoinment.setBackground (DefaultColor); 
        stock.setBackground (DefaultColor);
    }

    private void registerMousePressed(java.awt.event.MouseEvent evt) {
        sell.setBackground (DefaultColor); 
        book.setBackground (DefaultColor); 
        register.setBackground (ClickedColor); 
        customer.setBackground (DefaultColor); 
        appoinment.setBackground (DefaultColor); 
        stock.setBackground (DefaultColor);
    }

    private void customerMousePressed(java.awt.event.MouseEvent evt) {
        sell.setBackground (DefaultColor); 
        book.setBackground (DefaultColor); 
        register.setBackground (DefaultColor); 
        customer.setBackground (ClickedColor); 
        appoinment.setBackground (DefaultColor); 
        stock.setBackground (DefaultColor);
    }

    private void stockMousePressed(java.awt.event.MouseEvent evt) {
        sell.setBackground (DefaultColor); 
        book.setBackground (DefaultColor); 
        register.setBackground (DefaultColor); 
        customer.setBackground (DefaultColor); 
        appoinment.setBackground (DefaultColor); 
        stock.setBackground (ClickedColor);
    }

    private void jLabel9MousePressed(java.awt.event.MouseEvent evt) {                                     
       sell.setBackground (DefaultColor); 
        book.setBackground (DefaultColor); 
        register.setBackground (DefaultColor); 
        customer.setBackground (DefaultColor); 
        appoinment.setBackground (ClickedColor); 
        stock.setBackground (DefaultColor);
        
        AppoinmentPanel AppoinmentPanel1=new AppoinmentPanel(employee);
        mainpanel.removeAll(); 
        mainpanel.add(AppoinmentPanel1).setVisible(true);
        //miss clicked lable on appoiment check lable
    }

    private void appoinmentMousePressed(java.awt.event.MouseEvent evt) {
        sell.setBackground (DefaultColor); 
        book.setBackground (DefaultColor); 
        register.setBackground (DefaultColor); 
        customer.setBackground (DefaultColor); 
        appoinment.setBackground (ClickedColor); 
        stock.setBackground (DefaultColor);
    }

    private void sellMouseClicked(java.awt.event.MouseEvent evt) {
        SellPanel SellPanel1=new SellPanel(employee);
        mainpanel.removeAll(); 
        mainpanel.add(SellPanel1).setVisible(true);
    }

    private void bookMouseClicked(java.awt.event.MouseEvent evt) {
        BookPanel BookPanel1=new BookPanel(employee);
        mainpanel.removeAll(); 
        mainpanel.add(BookPanel1).setVisible(true);
    }

    private void registerMouseClicked(java.awt.event.MouseEvent evt) {
        RegisterPanel RegisterPanel1=new RegisterPanel(employee);
        mainpanel.removeAll(); 
        mainpanel.add(RegisterPanel1).setVisible(true);
    }

    private void customerMouseClicked(java.awt.event.MouseEvent evt) {
        CustomerPanel CustomerPanel1=new CustomerPanel(employee);
        mainpanel.removeAll(); 
        mainpanel.add(CustomerPanel1).setVisible(true);
    }

    private void stockMouseClicked(java.awt.event.MouseEvent evt) {
        StockPanel StockPanel1=new StockPanel(); 
        mainpanel.removeAll(); 
        mainpanel.add(StockPanel1).setVisible(true);
    }

    private void appoinmentMouseClicked(java.awt.event.MouseEvent evt) {
        AppoinmentPanel AppoinmentPanel1=new AppoinmentPanel(employee);
        mainpanel.removeAll(); 
        mainpanel.add(AppoinmentPanel1).setVisible(true);
        
    }*/
    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {
        logout();
    }

    private void logout() {
        LoginForm LoginForm1 = new LoginForm();
        LoginForm1.setVisible(true);
        this.dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel appoinment;
    private javax.swing.JPanel book;
    private javax.swing.JPanel customer;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JDesktopPane mainpanel;
    private javax.swing.JPanel register;
    private javax.swing.JPanel report;
    private javax.swing.JPanel sell;
    private javax.swing.JPanel stock;
    private javax.swing.JLabel title;
    private javax.swing.JLabel username;
    private javax.swing.JLabel view_report_bt;
    // End of variables declaration//GEN-END:variables
}
