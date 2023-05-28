package fr.ubeer.ubeer_back.service;

import fr.ubeer.ubeer_back.entity.BreweryCategory;
import fr.ubeer.ubeer_back.repository.BreweryCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BreweryCategoryService {

    @Autowired
    private BreweryCategoryRepository breweryCategoryRepository;

    public List<BreweryCategory> findAll() {
        return (List<BreweryCategory>) breweryCategoryRepository.findAll();
    }

    public BreweryCategory findByName(String name) {
        return breweryCategoryRepository.findByName(name);
    }

    public void addCategory(BreweryCategory breweryCategory) {
        breweryCategoryRepository.save(breweryCategory);
    }
}
