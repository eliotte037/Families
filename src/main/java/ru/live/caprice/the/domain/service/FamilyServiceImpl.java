package ru.live.caprice.the.domain.service;

/**
 * Created by tatiana.mayorova on 13.10.2016.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.live.caprice.the.domain.entity.Family;
import ru.live.caprice.the.domain.repository.FamilyRepository;

import java.util.List;

@Service
public class FamilyServiceImpl implements FamilyService {

    @Autowired
    private FamilyRepository repository;

    @Override
    @Transactional
    public void fillFamilies() {
        int currentFamilyNumber = 1;
        List<String> lodgers = repository.findLodgers();

        for (String lodger : lodgers) {
            if (checkLodger(lodger, currentFamilyNumber)) {
                currentFamilyNumber++;
            }
        }
    }

    private boolean checkLodger(String lodger, int familyNumber) {
        boolean result = false;

        List<Family> flats = repository.findByLodger(lodger);
        for (Family flat : flats) {
            if (flat.getFamilyNumber() == null) {
                flat.setFamilyNumber(familyNumber);
                repository.save(flat);
                result = true;
            }
            List<Family> flatLodgers = repository.findByFlatNumber(flat.getFlatNumber());
            for (Family otherLodger : flatLodgers) {
                if (otherLodger.getFamilyNumber() == null) {
                    checkLodger(otherLodger.getLodger(), familyNumber);
                }
            }
        }
        return result;
    }
}

