package fr.ubeer.ubeer_back.controller;

import fr.ubeer.ubeer_back.entity.Brewery;
import fr.ubeer.ubeer_back.service.BreweryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class BreweryController {

    @Autowired
    private BreweryService breweryService;

    @GetMapping( "/api/public/brewery" )
    public List<Brewery> getBrewery() {
        return breweryService.findAll();
    }

    @GetMapping( "/api/public/brewery/{id}" )
    public Brewery getBreweryById(@PathVariable Integer id) {
        return breweryService.findById(id);
    }

    @PostMapping( "/api/private/brewery" )
    public void createBrewery(@RequestBody Brewery brewery) {
        breweryService.addBrewery(brewery);
    }

    @PatchMapping( "/api/private/brewery" )
    public void updateBrewery(@RequestBody Brewery brewery) {
        breweryService.updateBrewery(brewery);
    }

    @DeleteMapping( "/api/private/brewery/{id}" )
    public void deleteBrewery(@PathVariable Integer id) {
        breweryService.deleteBreweryById(id);
    }
}
