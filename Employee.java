package entity;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "employee")
public class Employee{
    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Employee name cannot be blank!")
    @Size(max = 15, message = "Employee name has to be with up to 15 characters!")
    @Pattern(regexp = "^([A-Z]).*", message = "Employee name has to start with capital letter!")
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name="type_of_qualification", nullable = false)
    @Enumerated(EnumType.STRING)
    private TypeOfQualification typeOfQualification;

    @Positive
    @Digits(integer = 4, fraction = 2, message = "Salary has to be with 4 digits before and 2 digits after the decimal separator")
    @DecimalMin(value = "1000.00", message = "Salary has to be more than or equal to 1000.00", inclusive = true)
    @DecimalMax(value = "2000.00", message = "Salary has to be less than or equal to 2000.00")
    @Column(name="salary", nullable = false)
    private BigDecimal salary;

    @ManyToOne (fetch = FetchType.LAZY)
    private Company company;

    @OneToMany (mappedBy = "employee")
    private List<Transportation> transportationList;

    public Employee() {
    }

    public Employee(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Employee(long id, String name, TypeOfQualification typeOfQualification, Company company) {
        this.id = id;
        this.name = name;
        this.typeOfQualification = typeOfQualification;
        this.company = company;
    }

    public Employee(long id, String name, TypeOfQualification typeOfQualification, BigDecimal salary, Company company) {
        this.id = id;
        this.name = name;
        this.typeOfQualification = typeOfQualification;
        this.salary = salary;
        this.company = company;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TypeOfQualification getTypeOfQualification() {
        return typeOfQualification;
    }

    public void setTypeOfQualification(TypeOfQualification typeOfQualification) {
        this.typeOfQualification = typeOfQualification;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Transportation> getTransportationList() {
        return transportationList;
    }

    public void setTransportationList(List<Transportation> transportationList) {
        this.transportationList = transportationList;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", typeOfQualification=" + typeOfQualification +
                ", salary=" + salary +
                '}';
    }

}
