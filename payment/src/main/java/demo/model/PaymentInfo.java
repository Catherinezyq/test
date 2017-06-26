package demo.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.security.PrivateKey;
import java.util.List;


@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
//@RequiredArgsConstructor
@Entity
public class PaymentInfo {
    private String userName;
    private String creditCard;
    private String expirationDate;
    private String securityCode;
    private String address;

    public PaymentInfo(String userName, String creditCard, String expirationDate, String securityCode, String address) {
        this.userName = userName;
        this.creditCard = creditCard;
        this.expirationDate = expirationDate;
        this.securityCode = securityCode;
        this.address = address;
    }
}
