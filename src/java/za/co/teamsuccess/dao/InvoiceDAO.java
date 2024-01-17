
package za.co.teamsuccess.dao;


public interface InvoiceDAO {
   public int getLastInvoiceNumber();
    boolean updateInvoiceNumber(int invoiceNumber);
}
