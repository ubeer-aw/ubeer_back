package fr.ubeer.ubeer_back.service;

import fr.ubeer.ubeer_back.repository.BeerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BeerService {

    @Autowired
    private BeerRepository beerRepository;
}
