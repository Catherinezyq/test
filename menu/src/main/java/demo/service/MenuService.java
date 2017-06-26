package demo.service;

import demo.model.DishInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MenuService {

    void init();

    Page<DishInfo> findByRestaurantName(String restaurantName, Pageable pageable);

    DishInfo findById(String id);

    Page<DishInfo>findAllRunningInfoOrderBySingleProperty(int page, int size, String sortDir, String sortBy);
}
