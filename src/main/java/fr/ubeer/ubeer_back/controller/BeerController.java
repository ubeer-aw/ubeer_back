package fr.ubeer.ubeer_back.controller;

import fr.ubeer.ubeer_back.entity.Beer;
import fr.ubeer.ubeer_back.service.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
public class BeerController {

    @Autowired
    private BeerService beerService;

    @GetMapping( "/beer/{id}" )
    public Beer getBeerById(@PathVariable Integer id) {
        return beerService.findById(id);
    }

    @PostMapping( "/beer" )
    public void createBeer(@RequestParam Integer breweryId, @RequestBody Beer beer) {
        beerService.addBeer(breweryId,beer);
    }

    @PatchMapping( "/beer" )
    public void updateBeer(@RequestParam Integer breweryId, @RequestBody Beer beer) {
        beerService.updateBeer(breweryId,beer);
    }

    @DeleteMapping( "/beer/{id}" )
    public void deleteBeer(@PathVariable Integer id) {
        beerService.deleteBeerById(id);
    }
}

