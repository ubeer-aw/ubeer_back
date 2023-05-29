package fr.ubeer.ubeer_back.controller;

import fr.ubeer.ubeer_back.entity.Brewery;
import fr.ubeer.ubeer_back.entity.BreweryCategory;
import fr.ubeer.ubeer_back.service.BreweryCategoryService;
import fr.ubeer.ubeer_back.service.BreweryService;
import fr.ubeer.ubeer_back.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@CrossOrigin(origins = "*")
@RestController
public class BreweryController {

    @Autowired
    private BreweryService breweryService;

    @Autowired
    private UserService userService;

    @Autowired
    private BreweryCategoryService breweryCategoryService;



    @GetMapping("/api/public/brewery")
    public Page<Brewery> getBrewery(
            @RequestParam("categories") Set<Integer> categoryIds,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam("page") int page, @RequestParam("size") int size
    ) {
        Pageable pageable = PageRequest.of(page - 1, size);
        Set<BreweryCategory> categories = new HashSet<>();
        if ((categoryIds != null && !categoryIds.isEmpty()) && (name.length() > 0)) {
            System.out.println("1 : " + name);
            System.out.println("1 : " + categoryIds);
            for (Integer categoryId : categoryIds) {
                BreweryCategory category = new BreweryCategory();
                category.setId(categoryId);
                categories.add(category);
            }
            return breweryService.getBreweriesByCategoriesAndName(categories, name, pageable);
        } else if (categoryIds != null && !categoryIds.isEmpty()) {
            System.out.println("2 : " + categoryIds);
            for (Integer categoryId : categoryIds) {
                BreweryCategory category = new BreweryCategory();
                category.setId(categoryId);
                categories.add(category);
            }
            return breweryService.getBreweriesByCategories(categories, pageable);
        } else if ((name.length() > 0)) {
            System.out.println("3 : " + name );
            return breweryService.getBreweriesByName(name, pageable);
        } else {
            System.out.println("4");
            return breweryService.findAll(pageable);
        }
    }


    @GetMapping( "/api/public/brewery/{id}" )
    public Brewery getBreweryById(@PathVariable Integer id) {
        return breweryService.findById(id);
    }

    @PostMapping( "/api/private/brewery" )
    public void createBrewery(@RequestBody Brewery brewery,@RequestParam(value = "categories", required = false) List<String> categories, @RequestParam(value = "email") String email) {
        brewery.setUser(userService.findUserByEmail(email));
        for (String category : categories ) {
            brewery.getCategories().add(breweryCategoryService.findByName(category));
        }
        breweryService.addBrewery(brewery);
    }

    @PatchMapping( "/api/private/brewery" )
    public void updateBrewery(@RequestBody Brewery brewery,@RequestParam(value = "categories", required = false) List<String> categories, @RequestParam(value = "email")  String email) {
        if(userService.findUserByEmail(email).getId().equals(breweryService.findById(brewery.getId()).getUser().getId())) {
            brewery.setUser(userService.findUserByEmail(email));
            for (String category : categories ) {
                brewery.getCategories().add(breweryCategoryService.findByName(category));
            }
            breweryService.updateBrewery(brewery);
        }
    }

    @DeleteMapping( "/api/private/brewery/{id}" )
    public void deleteBrewery(@PathVariable Integer id, @RequestParam String email) {
        if(userService.findUserByEmail(email).getId().equals(breweryService.findById(id).getUser().getId())) {
            breweryService.deleteBreweryById(id);
        }

    }
}
