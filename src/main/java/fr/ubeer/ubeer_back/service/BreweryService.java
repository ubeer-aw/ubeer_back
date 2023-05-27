package fr.ubeer.ubeer_back.service;

import fr.ubeer.ubeer_back.entity.Brewery;
import fr.ubeer.ubeer_back.repository.BreweryPageRepository;
import fr.ubeer.ubeer_back.repository.BreweryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BreweryService {

    @Autowired
    private BreweryRepository breweryRepository;

    @Autowired
    private BreweryPageRepository breweryPageRepository;

    public Page<Brewery> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        return breweryPageRepository.findAll(pageable);
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
