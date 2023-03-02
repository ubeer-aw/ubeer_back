package fr.ubeer.ubeer_back.service;

import fr.ubeer.ubeer_back.entity.Beer;
import fr.ubeer.ubeer_back.entity.Brewery;
import fr.ubeer.ubeer_back.repository.BeerRepository;
import fr.ubeer.ubeer_back.repository.BreweryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeerService {

    @Autowired
    private BeerRepository beerRepository;
    @Autowired
    private BreweryRepository breweryRepository;

    public List<Beer> findAllByBreweryId(Integer breweryId) {
        return beerRepository.findAllByBreweryId(breweryId);
    }

    public Beer findById(Integer beerId) {
        return beerRepository.findById(beerId).orElse(null);
    }

    public void addBeer(Integer breweryId, Beer beer) {
        beer.setBrewery(breweryRepository.findById(breweryId).orElse(null));
        beerRepository.save(beer);
    }

    public void updateBeer(Integer breweryId, Beer beer) {
        beer.setBrewery(breweryRepository.findById(breweryId).orElse(null));
        beerRepository.save(beer);
    }

    public void deleteBeerById(Integer beerId) {
        beerRepository.deleteById(beerId);
    }
}
