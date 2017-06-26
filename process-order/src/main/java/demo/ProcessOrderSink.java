package demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import demo.model.OrderInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import java.util.concurrent.ThreadLocalRandom;


@MessageEndpoint
@EnableBinding(Sink.class)
@Slf4j
public class ProcessOrderSink {

    @Autowired
    private SimpMessagingTemplate template;

    @Autowired
    private ObjectMapper objectMapper;

    @ServiceActivator(inputChannel = Sink.INPUT)
    public void getAndProcessOrder(String input) throws Exception {
        log.info("order is processed: " + input);
        OrderInfo payload = this.objectMapper.readValue(input, OrderInfo.class);
    }

}
