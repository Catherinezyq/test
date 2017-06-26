package demo;

import demo.model.PaymentInfo;
import demo.model.PaymentResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class PaymentController {

    @RequestMapping(value = "/pay", method = RequestMethod.POST)
    public PaymentResult putPayment(@RequestBody PaymentInfo paymentInfo) {
        PaymentResult result = new PaymentResult();

        return result;
    }
}
