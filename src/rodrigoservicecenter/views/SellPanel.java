/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package rodrigoservicecenter.views;

import rodrigoservicecenter.controller.CustomerController;
import rodrigoservicecenter.controller.ProductController;
import rodrigoservicecenter.model.entity.*;

import javax.swing.*;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class SellPanel extends javax.swing.JInternalFrame {

    Employee employee;

    ProductController productController = new ProductController();

    List<selectedItem> selectedProducts = new ArrayList<>();
    List<Product> invoiceProducts = new ArrayList<>();
    int totalAmount = 0;

    String[] columnNames = {"Product Name", "Category", "Brand", "Description", "Vehicle Compatibility", "Price"};
    List<Product> displayedProducts = new ArrayList<>();
    DefaultTableModel model = new DefaultTableModel(columnNames, 0);

    public SellPanel(Employee gotEemployee) {

        employee = gotEemployee;

        initComponents();

        payment.setVisible(false);

        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0)); 
        BasicInternalFrameUI ui= (BasicInternalFrameUI) this.getUI(); 
        ui.setNorthPane (null);

        setClearTable();

        //refreshTable(productController.getProductsByOutletId(Integer.parseInt(employee.getWorkOutlet())));
        refreshTable(productController.getAllProducts());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        total_price = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        items = new javax.swing.JTable();
        payment = new javax.swing.JTextField();
        buy_bt = new javax.swing.JButton();
        quantity = new javax.swing.JSpinner();
        add_bt = new javax.swing.JButton();
        selected_delete_bt = new javax.swing.JButton();
        selected_clear_bt = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        Item_search = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        mobile_number = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        refresh_bt_1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        selected_items = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1240, 700));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("quantity :");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 600, 120, 30));

        total_price.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        total_price.setForeground(new java.awt.Color(102, 102, 102));
        total_price.setText("23 000");
        getContentPane().add(total_price, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 460, 80, 30));

        items.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(items);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 500, 490));
        getContentPane().add(payment, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 510, 380, 30));

        buy_bt.setBackground(new java.awt.Color(0, 51, 153));
        buy_bt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        buy_bt.setForeground(new java.awt.Color(255, 255, 255));
        buy_bt.setText("Pay Now");
        buy_bt.setBorder(null);
        buy_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buy_btActionPerformed(evt);
            }
        });
        getContentPane().add(buy_bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 600, 110, 30));
        getContentPane().add(quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 600, 80, 30));

        add_bt.setBackground(new java.awt.Color(0, 51, 153));
        add_bt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        add_bt.setForeground(new java.awt.Color(255, 255, 255));
        add_bt.setText("ADD");
        add_bt.setBorder(null);
        add_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_btActionPerformed(evt);
            }
        });
        getContentPane().add(add_bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 600, 110, 30));

        selected_delete_bt.setBackground(new java.awt.Color(255, 51, 51));
        selected_delete_bt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        selected_delete_bt.setForeground(new java.awt.Color(255, 255, 255));
        selected_delete_bt.setText("Delete");
        selected_delete_bt.setBorder(null);
        selected_delete_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selected_delete_btActionPerformed(evt);
            }
        });
        getContentPane().add(selected_delete_bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 600, 110, 30));

        selected_clear_bt.setBackground(new java.awt.Color(255, 51, 51));
        selected_clear_bt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        selected_clear_bt.setForeground(new java.awt.Color(255, 255, 255));
        selected_clear_bt.setText("Clear");
        selected_clear_bt.setBorder(null);
        selected_clear_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selected_clear_btActionPerformed(evt);
            }
        });
        getContentPane().add(selected_clear_bt, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 600, 110, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Selected Items And Quantity");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 40, 280, 30));

        Item_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Item_searchKeyPressed(evt);
            }
        });
        getContentPane().add(Item_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, 310, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Mobile Number :");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 550, 170, 30));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Payment   :");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 510, 140, 30));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("Total Amount :");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 460, 140, 30));
        getContentPane().add(mobile_number, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 550, 380, 30));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setText("Search item :");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 120, 30));

        refresh_bt_1.setForeground(new java.awt.Color(102, 102, 102));
        refresh_bt_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/rodrigoservicecenter/resources/refresh-3104 (1).png"))); // NOI18N
        refresh_bt_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refresh_bt_1ActionPerformed(evt);
            }
        });
        getContentPane().add(refresh_bt_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 40, 30, 30));

        selected_items.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(selected_items);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 90, 540, 360));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Item_searchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Item_searchKeyPressed
        String keyword = Item_search.getText();
        refreshTable(productController.productSearch(keyword,0));
    }

    private void buy_btActionPerformed(java.awt.event.ActionEvent evt) {

        CustomerController customerController = new CustomerController();

        if(selectedProducts.isEmpty()){
            JOptionPane.showMessageDialog(null, "No Items Selected");
        }else{

            if(mobile_number.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Please Enter Customer Mobile Number");
            } else {
                Customer customer = customerController.getCustomerByContactNumber(Integer.parseInt(mobile_number.getText()));
                if(customer == null) {
                    JOptionPane.showMessageDialog(null, "Customer Not Found");
                } else {
                    Invoice invoice = new Invoice();
                    invoice.setCustomer(customer);
                    invoice.setIssueDate(new Date(System.currentTimeMillis()));
                    invoice.setDueDate(new Date(invoice.getIssueDate().getTime() + 7 * 24 * 60 * 60 * 1000));
                    invoice.setProducts(invoiceProducts);
                    invoice.setServices(null);
                    invoice.setPaymentStatus("Paid");
                    invoice.setTotalAmount(totalAmount);
                    Invoice in = productController.createInvoice(invoice);

                    if(in == null){
                        JOptionPane.showMessageDialog(null, "Invoice Creation Failed");
                        return;
                    } else {
                        JOptionPane.showMessageDialog(null, "Invoice Created Successfully");

                        int count = 0;
                        InvoiceProduct invoiceProduct = new InvoiceProduct();
                        for(selectedItem selectedItem : selectedProducts){
                            invoiceProduct.setInvoiceId(in.getInvoiceId());
                            invoiceProduct.setProduct(selectedItem.getProduct());
                            invoiceProduct.setQuantity(selectedItem.getQuantity());
                            if(productController.createProductInvoice(invoiceProduct)){
                                count++;
                            }
                        }

                        if(count == 0){
                            JOptionPane.showMessageDialog(null, "Invoice Creation Failed");
                            return;
                        } else {
                            JOptionPane.showMessageDialog(null, "Invoice Created Successfully");

                            Payment payment = new Payment();
                            payment.setCustomer(customer);
                            payment.setInvoice(in);
                            payment.setTotalAmount(totalAmount);
                            payment.setPaymentDate(new Date(System.currentTimeMillis()));
                            payment.setPaymentMethod("Cash");
                            payment.setPaymentStatus("Paid");
                            if(productController.addPayment(payment)){
                                JOptionPane.showMessageDialog(null, "Payment Added Successfully");
                                setClearTable();
                            } else {
                                JOptionPane.showMessageDialog(null, "Payment Creation Failed");
                            }
                        }
                    }
                }
            }
        }
    }

    private void selected_delete_btActionPerformed(java.awt.event.ActionEvent evt) {
        int row = selected_items.getSelectedRow();
        if(row == -1){
            javax.swing.JOptionPane.showMessageDialog(null, "No Row Selected");
        } else{
            selectedProducts.remove(row);
            invoiceProducts.remove(row);
            makeSelectedItemTable();
        }
    }

    private void selected_clear_btActionPerformed(java.awt.event.ActionEvent evt) {
        setClearTable();
    }

    private void setClearTable(){

        selectedProducts.clear();
        invoiceProducts.clear();

        selected_items.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                },
                new String [] {
                        "Product Name", "Quantity", "Price"
                }
        ));
        total_price.setText("Total Amount : 0");
    }

    private void refresh_bt_1ActionPerformed(java.awt.event.ActionEvent evt) {
        refreshTable(productController.getAllProducts());
    }

    private void add_btActionPerformed(java.awt.event.ActionEvent evt) {

        if(getSelectedProduct() == null){
            javax.swing.JOptionPane.showMessageDialog(null, "No Product Selected");
            return;
        } else {
            invoiceProducts.add(getSelectedProduct());
            selectedProducts.add(new selectedItem(getSelectedProduct(), (Integer) quantity.getValue()));
        }

        makeSelectedItemTable();
    }

    private void makeSelectedItemTable(){
        String[] columnNames = {"Product Name", "Quantity", "Price"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        for (selectedItem selectedItem : selectedProducts) {
            Object[] rowData = {
                    selectedItem.getProduct().getProductName(),
                    selectedItem.getQuantity(),
                    selectedItem.getProduct().getUnitPrice()
            };
            model.addRow(rowData);
        }
        selected_items.setModel(model);

        for (selectedItem selectedItem : selectedProducts) {
            totalAmount += selectedItem.getProduct().getUnitPrice() * selectedItem.getQuantity();
        }
        total_price.setText("Total Amount : " + String.valueOf(totalAmount));

        System.out.println("Total Amount : " + totalAmount);
    }



    private void refreshTable(List<Product> products) {

        model.setRowCount(0);
        displayedProducts.clear();

        for (Product product : products) {
            Object[] rowData = {
                product.getProductId(),
                product.getProductName(),
                product.getCategory(),
                product.getBrand(),
                product.getDescription(),
                product.getVehicleCompatibility(),
                product.getUnitPrice()
            };
            model.addRow(rowData);
            displayedProducts.add(product);
        }
        items.setModel(model);
    }

    private Product getSelectedProduct() {
        int selectedRow = items.getSelectedRow();
        if (selectedRow != -1) {
            return displayedProducts.get(selectedRow);
        }
        return null;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Item_search;
    private javax.swing.JButton add_bt;
    private javax.swing.JButton buy_bt;
    private javax.swing.JTable items;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField mobile_number;
    private javax.swing.JTextField payment;
    private javax.swing.JSpinner quantity;
    private javax.swing.JButton refresh_bt_1;
    private javax.swing.JButton selected_clear_bt;
    private javax.swing.JButton selected_delete_bt;
    private javax.swing.JTable selected_items;
    private javax.swing.JLabel total_price;
    // End of variables declaration//GEN-END:variables
}

class selectedItem{
    Product product;
    int quantity;

    public selectedItem(Product product, int quantity){
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
