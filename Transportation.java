package entity;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "transportation")
public class Transportation{

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Transportation starting point cannot be blank!")
    @Size(max = 20, message = "Transportation starting point has to be with up to 20 characters!")
    @Pattern(regexp = "^([A-Z]).*", message = "Transportation starting point has to start with capital letter!")
    @Column(name = "startingPoint", nullable = false)
    private String startingPoint;

    @NotBlank(message = "Transportation ending point cannot be blank!")
    @Size(max = 20, message = "Transportation ending point has to be with up to 20 characters!")
    @Pattern(regexp = "^([A-Z]).*", message = "Transportation ending point has to start with capital letter!")
    @Column(name = "endingPoint", nullable = false)
    private String endingPoint;

    @PastOrPresent(message = "Starting date must be in the past or in the present")
    @Column(name = "startingDate")
    private LocalDate startingDate;

    @Column(name = "endingDate")
    private LocalDate endingDate;

    @Column(name = "type_of_load", nullable = false)
    private long typeOfLoad;

    @Positive
    @DecimalMin(value = "100.00", message = "Price has to be more than or equal to 100.00", inclusive = true)
    @DecimalMax(value = "900.00", message = "Price has to be less than or equal to 900.00")
    @Digits(integer = 3, fraction = 2, message = "Price has to be with 3 digits before and 2 digits after the decimal separator!")
    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @ManyToOne (fetch = FetchType.LAZY)
    private Company company;

    @OneToMany(mappedBy = "transportation")
    private List<Good> goods;

    @OneToMany(mappedBy = "transportation")
    private List<Client> clients;

    @ManyToOne (fetch = FetchType.LAZY)
    private Employee employee;


    public Transportation() {
    }

    public Transportation(long id, String startingPoint, String endingPoint, LocalDate startingDate, LocalDate endingDate, long typeOfLoad, BigDecimal price, Company company, Employee employee) {
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStartingPoint() {
        return startingPoint;
    }

    public void setStartingPoint(String startingPoint) {
        this.startingPoint = startingPoint;
    }

    public String getEndingPoint() {
        return endingPoint;
    }

    public void setEndingPoint(String endingPoint) {
        this.endingPoint = endingPoint;
    }

    public LocalDate getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(LocalDate startingDate) {
        this.startingDate = startingDate;
    }

    public LocalDate getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(LocalDate ending_date) {
        this.endingDate = endingDate;
    }

    public long getTypeOfLoad() {
        return typeOfLoad;
    }

    public void setTypeOfLoad(long typeOfLoad) {
        this.typeOfLoad = typeOfLoad;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Good> getGoods() {
        return goods;
    }

    public void setGoods(List<Good> goods) {
        this.goods = goods;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Transportation{" +
                "id=" + id +
                ", startingPoint='" + startingPoint + '\'' +
                ", endingPoint='" + endingPoint + '\'' +
                ", startingDate=" + startingDate +
                ", endingDate=" + endingDate +
                ", typeOfLoad=" + typeOfLoad +
                ", price=" + price +
                '}';
    }
}
