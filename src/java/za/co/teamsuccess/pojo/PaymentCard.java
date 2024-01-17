
package za.co.teamsuccess.pojo;

public class PaymentCard {
    private String cardNumber;
    private String cardHolder;
    private String cvv;

    public PaymentCard(){
        this("","","");
    }
    
    public PaymentCard(String cardNumber, String cardHolder, String cvv) {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
        this.cvv = cvv;
    }
    
    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    @Override
    public String toString() {
        return "PaymentCard{" + "cardNumber=" + cardNumber + ", cardHolder=" + cardHolder + ", cvv=" + cvv + '}';
    }
    
}
