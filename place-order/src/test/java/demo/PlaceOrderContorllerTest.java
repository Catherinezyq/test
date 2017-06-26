package demo;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PlaceOrderContorllerTest {
    private OrderInfoRepository repository;
    private PlaceOrder service;
    private PlaceOrderController controller;

    @Before
    public void setupMock() {
        repository = mock(OrderInfoRepository.class);
        service = mock(PlaceOrder.class);
        controller = new PlaceOrderController(service);
    }
}
