package za.co.teamsuccess.service.impl;

import za.co.teamsuccess.dao.InvoiceDAO;
import za.co.teamsuccess.dao.impl.InvoiceDAOImpl;
import za.co.teamsuccess.manager.DBPoolManagerBasic;
import za.co.teamsuccess.pojo.Invoice;
import za.co.teamsuccess.pojo.Order;
import za.co.teamsuccess.service.InvoiceService;

public class InvoiceServiceImpl implements InvoiceService {
    private InvoiceDAO invoiceDAO;
    int invoiceId = 0;
    private final DBPoolManagerBasic dbpm;

    public InvoiceServiceImpl(DBPoolManagerBasic dbpm) {
        this.dbpm = dbpm;
    }

    @Override
    public boolean createInvoice(Order order) {
        invoiceDAO = new InvoiceDAOImpl(dbpm);
        int invoiceNumber = invoiceDAO.getLastInvoiceNumber();
        invoiceNumber+=1;
        if(invoiceDAO.updateInvoiceNumber(invoiceNumber)){
            
    }
        return true;
    }

    @Override
    public int updateInvoiceId(Invoice invoiceId) {

        return this.invoiceId;
    }

}
