package demo.service.impl;

import demo.model.DishInfo;
import demo.model.DishInfoRepository;
import demo.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultMenuService implements MenuService {

    private DishInfoRepository dishInfoRepository;

    @Autowired
    public DefaultMenuService(DishInfoRepository locationRepository) {
        this.dishInfoRepository = locationRepository;
    }

    @Override
    public void init() {}

    @Override
    public Page<DishInfo> findByRestaurantName(String restaurantName, Pageable pageable) {
        return this.dishInfoRepository
                .findByRestaurantName(restaurantName, pageable);
    }

    @Override
    public DishInfo findById(String id) {
        return this.dishInfoRepository.findById(id);
    }

    @Override
    public Page<DishInfo>findAllRunningInfoOrderBySingleProperty(int page, int size, String sortDir, String sortBy) {
        Pageable pageable = new PageRequest(page, size, Sort.Direction.fromString(sortDir.toLowerCase()), sortBy);
        return this.dishInfoRepository.findAll(pageable);
    }
}
