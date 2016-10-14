package ru.live.caprice.the.domain.repository;

/**
 * Created by tatiana.mayorova on 13.10.2016.
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.live.caprice.the.domain.entity.Family;

import java.util.List;
import java.util.Set;

public interface FamilyRepository extends JpaRepository<Family, Long> {
    List<Family> findByLodger(String lodger);

    List<Family> findByFlatNumber(int flatNumber);


    @Query("SELECT DISTINCT c.lodger FROM Family c")
    List<String> findLodgers();
}