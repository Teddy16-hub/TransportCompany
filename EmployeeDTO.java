package dto;

import entity.Company;
import entity.TypeOfQualification;
import java.math.BigDecimal;

public class EmployeeDTO {
    private long id;
    private String name;
    private TypeOfQualification typeOfQualification;
    private BigDecimal salary;
    private Company company;

    public EmployeeDTO() {
    }

    public EmployeeDTO(long id, String name, TypeOfQualification typeOfQualification, BigDecimal salary) {
        this.id = id;
        this.name = name;
        this.typeOfQualification = typeOfQualification;
        this.salary = salary;
    }

    public EmployeeDTO(long id, String name, TypeOfQualification typeOfQualification, BigDecimal salary, Company company) {
        this.id = id;
        this.name = name;
        this.typeOfQualification = typeOfQualification;
        this.salary = salary;
        this.company = company;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", typeOfQualification=" + typeOfQualification +
                ", salary=" + salary +
                ", company=" + company +
                '}';
    }
}
