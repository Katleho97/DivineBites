package za.co.teamsuccess.pojo;

import java.sql.Date;
import java.util.Objects;

public class Invoice {

    private int invoiceId;
    private int orderId;
    private int personId;
    private Date invoiceDate;

    public Invoice() {
    }

    public Invoice(int invoiceId, int orderId, int personId, Date invoiceDate) {
        this.invoiceId = invoiceId;
        this.orderId = orderId;
        this.personId = personId;
        this.invoiceDate = invoiceDate;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.invoiceId;
        hash = 97 * hash + this.orderId;
        hash = 97 * hash + this.personId;
        hash = 97 * hash + Objects.hashCode(this.invoiceDate);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Invoice other = (Invoice) obj;
        if (this.invoiceId != other.invoiceId) {
            return false;
        }
        if (this.orderId != other.orderId) {
            return false;
        }
        if (this.personId != other.personId) {
            return false;
        }
        return Objects.equals(this.invoiceDate, other.invoiceDate);
    }

    @Override
    public String toString() {
        return "Invoice{" + "invoiceId=" + invoiceId + ", orderId=" + orderId + ", personId=" + personId + ", invoiceDate=" + invoiceDate + '}';
    }

}
