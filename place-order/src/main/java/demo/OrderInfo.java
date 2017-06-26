package demo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;


@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
//@RequiredArgsConstructor
@Entity
public class OrderInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String restaurantName;

    private List<Item> items;

    private String customerName;
    private String address;

    private double timeStamp;
    private Integer paymentId;
    private double price;
    private String notes;

    public OrderInfo(String restaurantName, List<Item> items, String customerName, String address, double timeStamp, Integer paymentId, double price, String notes) {
        this.restaurantName = restaurantName;
        this.items = items;
        this.customerName = customerName;
        this.address = address;
        this.timeStamp = timeStamp;
        this.paymentId = paymentId;
        this.price = price;
        this.notes = notes;
    }
}
