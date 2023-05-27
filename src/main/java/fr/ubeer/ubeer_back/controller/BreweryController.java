package fr.ubeer.ubeer_back.controller;

import fr.ubeer.ubeer_back.entity.Brewery;
import fr.ubeer.ubeer_back.service.BreweryService;
import fr.ubeer.ubeer_back.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class BreweryController {

    @Autowired
    private BreweryService breweryService;

    @Autowired
    private UserService userService;

    @GetMapping("/api/public/brewery")
    public Page<Brewery> getBrewery(@RequestParam("page") int page, @RequestParam("size") int size) {
        return breweryService.findAll(page, size);
    }

    @GetMapping( "/api/public/brewery/{id}" )
    public Brewery getBreweryById(@PathVariable Integer id) {
        return breweryService.findById(id);
    }

    @PostMapping( "/api/private/brewery" )
    public void createBrewery(@RequestBody Brewery brewery, @RequestParam String email) {
        brewery.setUser(userService.findUserByEmail(email));
        breweryService.addBrewery(brewery);
    }

    @PatchMapping( "/api/private/brewery" )
    public void updateBrewery(@RequestBody Brewery brewery, @RequestParam String email) {
        if(userService.findUserByEmail(email).getId().equals(breweryService.findById(brewery.getId()).getUser().getId())) {
            brewery.setUser(userService.findUserByEmail(email));
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
