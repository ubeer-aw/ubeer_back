package fr.ubeer.ubeer_back.controller;

import fr.ubeer.ubeer_back.entity.BreweryCategory;
import fr.ubeer.ubeer_back.service.BreweryCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class BreweryCategoryController {

    @Autowired
    private BreweryCategoryService breweryCategoryService;

    @GetMapping("/api/public/brewery/category")
    public List<BreweryCategory> getCategories() {
        return breweryCategoryService.findAll();
    }

    @PostMapping("/api/private/brewery/category")
    public void addCategory(@RequestBody BreweryCategory breweryCategory) {
        breweryCategoryService.addCategory(breweryCategory);
    }
}
