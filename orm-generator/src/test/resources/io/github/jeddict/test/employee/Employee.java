/**
 * This file was generated by the JPA Modeler
 */
package io.github.jeddict.test.employee;

import java.util.Date;
import java.util.List;
import javax.json.bind.annotation.JsonbProperty;
import javax.persistence.AttributeOverride;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;

@Entity
@DiscriminatorColumn(length = 31)
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Basic
    @JsonbProperty("firstame")
    private String firstName;

    @Basic
    private String lastName;

    @Basic
    @Enumerated
    private GenderType gender;

    @Basic
    @Column(name = "BIRTH_DATE")
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @Lob
    @Basic
    private byte[] profilePic;

    @Basic
    private boolean active;

    @ElementCollection
    private List<String> mobileNumbers;

    @ElementCollection
    private List<Certification> certifications;

    @Embedded
    @AttributeOverride(name = "city", column = @Column(name = "HM_CITY"))
    @AttributeOverride(name = "country", column = @Column(name = "HM_COUNTRY"))
    @AttributeOverride(name = "state", column = @Column(name = "HM_STATE"))
    @AttributeOverride(name = "street", column = @Column(name = "HM_STREET"))
    @AttributeOverride(name = "zipCode.codeSuffix", column = @Column(name = "HM_CODESUFFIX"))
    @AttributeOverride(name = "zipCode.maincode", column = @Column(name = "HM_MAINCODE"))
    private Address homeAddress;

    @Embedded
    private Address officeAddress;

    @OneToOne
    @JoinTable(name = "ACUB", joinColumns = @JoinColumn(name = "EMP_ID"), inverseJoinColumns = @JoinColumn(name = "AC_ID"))
    private Cubicle assignedCubicle;

    @ManyToOne
    private Employee manager;

    @OneToMany(mappedBy = "manager")
    private List<Employee> subordinates;

    @ManyToMany
    @JoinTable(joinColumns = @JoinColumn(name = "EMPLOYEES_ID"))
    private List<Project> projects;

    @Version
    private long version;

    @Transient
    private int age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public GenderType getGender() {
        return gender;
    }

    public void setGender(GenderType gender) {
        this.gender = gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public byte[] getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(byte[] profilePic) {
        this.profilePic = profilePic;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<String> getMobileNumbers() {
        return mobileNumbers;
    }

    public void setMobileNumbers(List<String> mobileNumbers) {
        this.mobileNumbers = mobileNumbers;
    }

    public List<Certification> getCertifications() {
        return certifications;
    }

    public void setCertifications(List<Certification> certifications) {
        this.certifications = certifications;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Address getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(Address officeAddress) {
        this.officeAddress = officeAddress;
    }

    public Cubicle getAssignedCubicle() {
        return assignedCubicle;
    }

    public void setAssignedCubicle(Cubicle assignedCubicle) {
        this.assignedCubicle = assignedCubicle;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public List<Employee> getSubordinates() {
        return subordinates;
    }

    public void setSubordinates(List<Employee> subordinates) {
        this.subordinates = subordinates;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}