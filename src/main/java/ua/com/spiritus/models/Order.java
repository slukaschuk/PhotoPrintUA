package ua.com.spiritus.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "clientorder")
@Setter
@Getter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private Integer orderId;
    @Column(name = "order_date")
    private LocalDateTime orderDate;
    @Column(name = "address", length = 150)
    private String address;
    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status = Status.NEW;
    public enum Status{
        NEW,
        PUBLISHED,
        ACCEPTED,
        PERFORMED
    }
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderDetails;
    @Column(name = "sum")
    private Float sum;
   /* @Column(name = "nova_poshta_id")
    private Integer novaPoshtaId;*/


}

