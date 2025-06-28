package rodrigoservicecenter.model;

import rodrigoservicecenter.connect.connect;
import rodrigoservicecenter.model.entity.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductModel {

    ServiceOutletModel serviceOutletModel = new ServiceOutletModel();
    SupplierModel supplierModel = new SupplierModel();

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        connect db = new connect();
        Connection con = db.createConnection();

        String sql = "SELECT * FROM Product";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Product product = new Product(
                        rs.getInt("productId"),
                        rs.getString("productName"),
                        rs.getString("category"),
                        serviceOutletModel.getOutletById(rs.getInt("outletId")),
                        rs.getString("vehicleCompatibility"),
                        rs.getString("brand"),
                        rs.getString("description"),
                        rs.getInt("unitPrice"),
                        supplierModel.getSupplierById(rs.getInt("supplierId"))
                );
                products.add(product);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return products;
    }

    public Product getProductById(int productId) {
        Product product = null;
        connect db = new connect();
        Connection con = db.createConnection();

        String sql = "SELECT * FROM Product WHERE productId = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, productId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                product = new Product(
                        rs.getInt("productId"),
                        rs.getString("productName"),
                        rs.getString("category"),
                        serviceOutletModel.getOutletById(rs.getInt("outletId")),
                        rs.getString("vehicleCompatibility"),
                        rs.getString("brand"),
                        rs.getString("description"),
                        rs.getInt("unitPrice"),
                        supplierModel.getSupplierById(rs.getInt("supplierId"))
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return product;
    }


    public List<Product> getProductsByOutletId(int outletId) {
        List<Product> products = new ArrayList<>();
        connect db = new connect();
        Connection con = db.createConnection();

        String sql = "SELECT * FROM Product WHERE outletId = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, outletId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Product product = new Product(
                        rs.getInt("productId"),
                        rs.getString("productName"),
                        rs.getString("category"),
                        serviceOutletModel.getOutletById(rs.getInt("outletId")),
                        rs.getString("vehicleCompatibility"),
                        rs.getString("brand"),
                        rs.getString("description"),
                        rs.getInt("unitPrice"),
                        supplierModel.getSupplierById(rs.getInt("supplierId"))
                );
                products.add(product);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return products;
    }

    public List<Product> searchProducts(String keyword, int outletId) {
        List<Product> products = new ArrayList<>();
        connect db = new connect();
        Connection con = db.createConnection();

        StringBuilder sql = new StringBuilder("SELECT * FROM Product");
        List<Object> params = new ArrayList<>();
        boolean hasCondition = false;

        if (keyword != null && !keyword.trim().isEmpty()) {
            sql.append(" WHERE productName LIKE ?");
            params.add("%" + keyword + "%");
            hasCondition = true;
        }

        if (outletId != 0) {
            if (hasCondition) {
                sql.append(" AND outletId = ?");
            } else {
                sql.append(" WHERE outletId = ?");
            }
            params.add(outletId);
        }

        try {
            PreparedStatement ps = con.prepareStatement(sql.toString());

            for (int i = 0; i < params.size(); i++) {
                ps.setObject(i + 1, params.get(i));
            }

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Product product = new Product(
                        rs.getInt("productId"),
                        rs.getString("productName"),
                        rs.getString("category"),
                        serviceOutletModel.getOutletById(rs.getInt("outletId")),
                        rs.getString("vehicleCompatibility"),
                        rs.getString("brand"),
                        rs.getString("description"),
                        rs.getInt("unitPrice"),
                        supplierModel.getSupplierById(rs.getInt("supplierId"))
                );
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return products;
    }
}