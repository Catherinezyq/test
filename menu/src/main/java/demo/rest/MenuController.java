package demo.rest;

import demo.model.DishInfo;
import demo.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class MenuController {

    // Default value for pageable
    private static final String DEFAULT_PAGE_NUMBER = "0";
    private static final String DEFAULT_PAGE_SIZE = "10";
    private static final String DEFAULT_SORT_DIR = "desc";
    private static final String DEFAULT_SORT_BY = "restaurantName";

    private MenuService menuService;

    @Autowired
    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @RequestMapping(value = "/menu/{id}", method = RequestMethod.GET)
    public DishInfo findById(@PathVariable String id) {
        return this.menuService.findById(id);
    }

    @RequestMapping(value = "/menu/{restaurant}", method = RequestMethod.GET)
    public Page<DishInfo> findByMovementType(@PathVariable String restaurantName, @RequestParam(name = "page") int page, @RequestParam(name = "size") int size) {
        return this.menuService.findByRestaurantName(restaurantName, new PageRequest(page, size));
    }

    @RequestMapping(value = "/menu", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<DishInfo> findAllRunningInfoOrderBySingleProperty(
            @RequestParam(value = "page", required = false, defaultValue = DEFAULT_PAGE_NUMBER) int page,
            @RequestParam(value = "size", required = false, defaultValue = DEFAULT_PAGE_SIZE) int size,
            @RequestParam(value = "sortDir", required = false, defaultValue = DEFAULT_SORT_DIR) String sortDir,
            @RequestParam(value = "sortBy", required = false, defaultValue = DEFAULT_SORT_BY) String sortBy) {
        return this.menuService.findAllRunningInfoOrderBySingleProperty(page, size, sortDir, sortBy);
    }

}
