package fr.ubeer.ubeer_back.service;

import fr.ubeer.ubeer_back.entity.Brewery;
import fr.ubeer.ubeer_back.repository.BreweryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BreweryService {

    @Autowired
    private BreweryRepository breweryRepository;

    public List<Brewery> findAll() {
        return (List<Brewery>) breweryRepository.findAll();
    }

    public Brewery findById(Integer breweryId) {
        return breweryRepository.findById(breweryId).orElse(null);
    }

    public void addBrewery(Brewery brewery) {
        breweryRepository.save(brewery);
    }

    public void updateBrewery(Brewery brewery) {
        breweryRepository.save(brewery);
    }

    public void deleteBreweryById(Integer breweryId) {
        breweryRepository.deleteById(breweryId);
    }


}
