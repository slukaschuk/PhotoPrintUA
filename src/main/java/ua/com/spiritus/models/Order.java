package ua.com.spiritus.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer orderId;
    @Column(name = "orderdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;
    @Column(name = "address")
    private String address;
    @Column(name = "status")
    private String status;
    @Column(name = "userid")
    private Integer userId;
    @Column(name = "novaposhtaid")
    private Integer novaPoshtaId;

    public Order() {
    }

    public Order(Date orderDate, String address, String status, Integer userId, Integer novaPoshtaId) {
        this.orderDate      = orderDate;
        this.address        = address;
        this.status         = status;
        this.userId         = userId;
        this.novaPoshtaId   = novaPoshtaId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getNovaPoshtaId() {
        return novaPoshtaId;
    }

    public void setNovaPoshtaId(Integer novaPoshtaId) {
        this.novaPoshtaId = novaPoshtaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (!orderId.equals(order.orderId)) return false;
        if (!orderDate.equals(order.orderDate)) return false;
        if (address != null ? !address.equals(order.address) : order.address != null) return false;
        if (status != null ? !status.equals(order.status) : order.status != null) return false;
        if (userId != null ? !userId.equals(order.userId) : order.userId != null) return false;
        return novaPoshtaId != null ? novaPoshtaId.equals(order.novaPoshtaId) : order.novaPoshtaId == null;

    }

    @Override
    public int hashCode() {
        int result = orderId.hashCode();
        result = 31 * result + orderDate.hashCode();
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (novaPoshtaId != null ? novaPoshtaId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderDate=" + orderDate +
                ", address='" + address + '\'' +
                ", status='" + status + '\'' +
                ", userId=" + userId +
                ", novaPoshtaId=" + novaPoshtaId +
                '}';
    }
}

