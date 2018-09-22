/**
 * This file was generated by the JPA Modeler
 */
package io.github.jeddict.test.employee;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Cubicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Basic
    private String displayNumber;

    @OneToOne(mappedBy = "assignedCubicle")
    private Employee residentEmployee;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDisplayNumber() {
        return displayNumber;
    }

    public void setDisplayNumber(String displayNumber) {
        this.displayNumber = displayNumber;
    }

    public Employee getResidentEmployee() {
        return residentEmployee;
    }

    public void setResidentEmployee(Employee residentEmployee) {
        this.residentEmployee = residentEmployee;
    }

}