package dto;

import entity.Company;
import entity.Employee;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TransportationDTO {
    private long id;
    private String startingPoint;
    private String endingPoint;
    private LocalDate startingDate;
    private LocalDate endingDate;
    private long typeOfLoad;
    private BigDecimal price;
    private Company company;
    private Employee employee;

    public TransportationDTO() {
    }

    public TransportationDTO(long id, String startingPoint, String endingPoint, LocalDate startingDate, LocalDate endingDate, long typeOfLoad, BigDecimal price) {
        this.id = id;
        this.startingPoint = startingPoint;
        this.endingPoint = endingPoint;
        this.startingDate = startingDate;
        this.endingDate = endingDate;
        this.typeOfLoad = typeOfLoad;
        this.price = price;
    }

    public TransportationDTO(long id, String startingPoint, String endingPoint, LocalDate startingDate, LocalDate endingDate, long typeOfLoad, BigDecimal price, Company company, Employee employee) {
        this.id = id;
        this.startingPoint = startingPoint;
        this.endingPoint = endingPoint;
        this.startingDate = startingDate;
        this.endingDate = endingDate;
        this.typeOfLoad = typeOfLoad;
        this.price = price;
        this.company = company;
        this.employee = employee;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "TransportationDTO{" +
                "id=" + id +
                ", startingPoint='" + startingPoint + '\'' +
                ", endingPoint='" + endingPoint + '\'' +
                ", startingDate=" + startingDate +
                ", endingDate=" + endingDate +
                ", typeOfLoad=" + typeOfLoad +
                ", price=" + price +
                ", company=" + company +
                ", employee=" + employee +
                '}';
    }
}
