package fr.ubeer.ubeer_back.controller;

import fr.ubeer.ubeer_back.service.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
public class BeerController {

    @Autowired
    private BeerService beerService;
}
