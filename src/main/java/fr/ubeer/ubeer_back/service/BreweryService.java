package fr.ubeer.ubeer_back.service;

import fr.ubeer.ubeer_back.entity.Brewery;
import fr.ubeer.ubeer_back.entity.BreweryCategory;
import fr.ubeer.ubeer_back.repository.BreweryPageRepository;
import fr.ubeer.ubeer_back.repository.BreweryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class BreweryService {

    @Autowired
    private BreweryRepository breweryRepository;

    @Autowired
    private BreweryPageRepository breweryPageRepository;

    public Page<Brewery> findAll(Pageable pageable) {
        return breweryPageRepository.findAll(pageable);
    }
    public Page<Brewery> getBreweriesByCategories(Set<BreweryCategory> categories, Pageable pageable) {
        return breweryPageRepository.findByCategoriesIn(categories, pageable);
    }

    public Page<Brewery> getBreweriesByName(String name, Pageable pageable) {
        return breweryPageRepository.findByNameContainingIgnoreCase(name, pageable);
    }

    public Page<Brewery> getBreweriesByCategoriesAndName(
            Set<BreweryCategory> categories, String name, Pageable pageable) {
        return breweryPageRepository.findByCategoriesInAndNameContainingIgnoreCase(categories, name, pageable);
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
