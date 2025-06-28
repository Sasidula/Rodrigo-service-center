package rodrigoservicecenter.controller;

import rodrigoservicecenter.model.*;
import rodrigoservicecenter.model.entity.*;

import java.util.List;

public class ProductController {

    public List<Product> getAllProducts(){
        ProductModel productModel = new ProductModel();
        return productModel.getAllProducts();
    }

    public Product getProductById(Product product){
        ProductModel productModel = new ProductModel();
        return productModel.getProductById(product.getProductId());
    }

    public List<Product> getProductsByOutletId(int id){
        ProductModel productModel = new ProductModel();
        return productModel.getProductsByOutletId(id);
    }

    public List<Product> productSearch(String Keyword, int outletId){
        ProductModel productModel = new ProductModel();
        return productModel.searchProducts(Keyword, outletId);
    }

    public ServiceOutlet getOutletById(int id){
        ServiceOutletModel serviceOutletModel = new ServiceOutletModel();
        return serviceOutletModel.getOutletById(id);
    }

    public boolean addPayment(Payment payment){
        PaymentModel paymentModel = new PaymentModel();
        return paymentModel.AddPayment(payment);
    }

    public boolean createProductInvoice(InvoiceProduct invoiceProduct){
        InvoiceProductModel invoiceProductModel = new InvoiceProductModel();
        return invoiceProductModel.createInvoiceProduct(invoiceProduct);
    }

    public Invoice createInvoice(Invoice invoice){
        InvoiceModel invoiceModel = new InvoiceModel();
        return invoiceModel.createInvoice(invoice);
    }

}
