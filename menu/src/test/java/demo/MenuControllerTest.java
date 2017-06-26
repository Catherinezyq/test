package demo;

import demo.model.DishInfo;
import demo.model.DishInfoRepository;
import demo.rest.MenuController;
import demo.service.MenuService;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MenuControllerTest {
    private DishInfoRepository repository;
    private MenuService service;
    private MenuController controller;
    private DishInfo order;

    @Before
    public void setupMock() {
        repository = mock(DishInfoRepository.class);
        service = mock(MenuService.class);
        controller = new MenuController(service);
    }
}
