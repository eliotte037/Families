package ru.live.caprice.the.domain.entity;

/**
 * Created by tatiana.mayorova on 13.10.2016.
 */

import javax.persistence.*;

@Entity
@Table(name = "FAMILY")
public class Family {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int flatNumber;
    private String lodger;
    private Integer familyNumber;

    public Family() {
    }

    public Family(int flatNumber, String lodger) {
        this.flatNumber = flatNumber;
        this.lodger = lodger;
    }

    public Integer getFamilyNumber() {
        return familyNumber;
    }

    public void setFamilyNumber(Integer familyNumber) {
        this.familyNumber = familyNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(int flatNumber) {
        this.flatNumber = flatNumber;
    }

    public String getLodger() {
        return lodger;
    }

    public void setLodger(String lodger) {
        this.lodger = lodger;
    }

    @Override
    public String toString() {
        return "Family{" +
                "id=" + id +
                ", flatNumber=" + flatNumber +
                ", lodger='" + lodger + '\'' +
                '}';
    }
}
