package za.co.teamsuccess.pojo;

import java.sql.Date;
import java.util.Objects;

public class Checkout {

    private int paymentid;
    private int invoiceid;
    private String creditCard;
    private String cardHolder;
    private int cvc;
    private Date paymentDate;
    private int ammount;

    public Checkout() {
    }

    public Checkout(int paymentid, int invoiceid, String creditCard, String cardHolder, int cvc, Date paymentDate, int ammount) {
        this.paymentid = paymentid;
        this.invoiceid = invoiceid;
        this.creditCard = creditCard;
        this.cardHolder = cardHolder;
        this.cvc = cvc;
        this.paymentDate = paymentDate;
        this.ammount = ammount;
    }

    public Checkout(String creditCard, String cardHolder, int cvc, Date paymentDate) {
        this.creditCard = creditCard;
        this.cardHolder = cardHolder;
        this.cvc = cvc;
        this.paymentDate = paymentDate;
    }

    public Checkout(String creditCard, String cardHolder, int cvc) {
        this.creditCard = creditCard;
        this.cardHolder = cardHolder;
        this.cvc = cvc;
    }
    


    public int getPaymentid() {
        return paymentid;
    }

    public void setPaymentid(int paymentid) {
        this.paymentid = paymentid;
    }

    public int getInvoiceid() {
        return invoiceid;
    }

    public void setInvoiceid(int invoiceid) {
        this.invoiceid = invoiceid;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
    }

    public int getCvc() {
        return cvc;
    }

    public void setCvc(int cvc) {
        this.cvc = cvc;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public int getAmmount() {
        return ammount;
    }

    public void setAmmount(int ammount) {
        this.ammount = ammount;
    }

    @Override
    public String toString() {
        return "Checkout{" + "paymentid=" + paymentid + ", invoiceid=" + invoiceid + ", creditCard=" + creditCard + ", cardHolder=" + cardHolder + ", cvc=" + cvc + ", paymentDate=" + paymentDate + ", ammount=" + ammount + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + this.paymentid;
        hash = 59 * hash + this.invoiceid;
        hash = 59 * hash + Objects.hashCode(this.cardHolder);
        hash = 59 * hash + this.cvc;
        hash = 59 * hash + Objects.hashCode(this.paymentDate);
        hash = 59 * hash + this.ammount;
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
        final Checkout other = (Checkout) obj;
        if (this.paymentid != other.paymentid) {
            return false;
        }
        if (this.invoiceid != other.invoiceid) {
            return false;
        }
        if (this.creditCard == null ? other.creditCard != null : !this.creditCard.equals(other.creditCard)) {
            return false;
        }
        if (this.cvc != other.cvc) {
            return false;
        }
        if (this.ammount != other.ammount) {
            return false;
        }
        if (!Objects.equals(this.cardHolder, other.cardHolder)) {
            return false;
        }
        return Objects.equals(this.paymentDate, other.paymentDate);
    }
    
}
