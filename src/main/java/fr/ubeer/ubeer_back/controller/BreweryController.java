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

    @GetMapping( "/brewery" )
    public List<Brewery> getBrewery() {
        return breweryService.findAll();
    }

    @GetMapping( "/brewery/{id}" )
    public Brewery getBreweryById(@PathVariable Integer id) {
        return breweryService.findById(id);
    }

    @PostMapping( "/brewery" )
    public void createBrewery(@RequestBody Brewery brewery) {
        breweryService.addBrewery(brewery);
    }

    @PatchMapping( "/brewery" )
    public void updateBrewery(@RequestBody Brewery brewery) {
        breweryService.updateBrewery(brewery);
    }

    @DeleteMapping( "/brewery/{id}" )
    public void deleteBrewery(@PathVariable Integer id) {
        breweryService.deleteBreweryById(id);
    }
}
