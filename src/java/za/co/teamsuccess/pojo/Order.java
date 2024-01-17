package za.co.teamsuccess.pojo;

public class Order {

    private int orderId;
    private int addresid;
    private int personid;
    private String orderdate;


    public Order() {
    }

    public Order(int orderId, int addresid, int personid, String orderdate) {
        this.orderId = orderId;
        this.addresid = addresid;
        this.personid = personid;
        this.orderdate = orderdate;
    }

    public Order(int addresid, int personid, String orderdate) {
        this.addresid = addresid;
        this.personid = personid;
        this.orderdate = orderdate;
    }
    

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getAddresid() {
        return addresid;
    }

    public void setAddresid(int addresid) {
        this.addresid = addresid;
    }

    public int getPersonid() {
        return personid;
    }

    public void setPersonid(int personid) {
        this.personid = personid;
    }

    public String getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(String orderdate) {
        this.orderdate = orderdate;
    }

    @Override
    public String toString() {
        return "Order{" + "orderId=" + orderId + ", addresid=" + addresid + ", personid=" + personid + ", orderdate=" + orderdate + '}';
    }
    
}
