package rodrigoservicecenter.model.util;

import rodrigoservicecenter.model.entity.InvoiceProduct;
import rodrigoservicecenter.model.entity.InvoiceService;
import rodrigoservicecenter.model.entity.Product;
import rodrigoservicecenter.model.entity.Service;

import java.util.List;

public class priceUtil {

    public static int calculateTotalAmount(List<InvoiceProduct> products, List<InvoiceService> services) {
        int total = 0;

        // Sum of products: price × quantity
        for (InvoiceProduct ip : products) {
            Product p = ip.getProduct();
            total += p.getUnitPrice() * ip.getQuantity();
        }

        // Sum of services: just price
        for (InvoiceService is : services) {
            Service s = is.getService();
            total += s.getPrice();
        }

        return total;
    }

}
