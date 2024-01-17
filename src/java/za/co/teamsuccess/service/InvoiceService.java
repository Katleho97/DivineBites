
package za.co.teamsuccess.service;

import za.co.teamsuccess.pojo.Invoice;
import za.co.teamsuccess.pojo.Order;

public interface InvoiceService {
    boolean createInvoice(Order order);
    int updateInvoiceId(Invoice invoiceid);
}
