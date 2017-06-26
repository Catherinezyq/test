package demo.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Entity;
import java.util.Date;


@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Entity
public class DishInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String restaurantName;
    private String dishName;

    private double price;

    public DishInfo(String restaurantName, String dishName, double price) {
        this.restaurantName = restaurantName;
        this.dishName = dishName;
        this.price = price;
    }
}
