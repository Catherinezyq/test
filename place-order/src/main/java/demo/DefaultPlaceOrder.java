/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package demo;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.criterion.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Service
@Slf4j
public class DefaultPlaceOrder implements PlaceOrder {

    @Autowired
    private RestTemplate restTemplate;

//    @Value("${com.ross.running.location.distribution}")
//    private String runningLocationDistribution;

    public DefaultPlaceOrder() {
        super();
    }

    private OrderInfoRepository orderInfoRepository;

    @Autowired
    public DefaultPlaceOrder(OrderInfoRepository orderInfoRepository) {
        this.orderInfoRepository = orderInfoRepository;
    }

    @Override
    public void processOrderInfo(OrderInfo orderInfo) {

        OrderInfo savedOrder = orderInfoRepository.save(orderInfo);

        String runningLocationDistribution = "http://order";

        log.info("place-order is callling order REST API");
        this.restTemplate.postForLocation(runningLocationDistribution + "/api/orders", savedOrder);
    }
}
