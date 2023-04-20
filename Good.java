package entity;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;

@Entity
@Table(name = "good")
public class Good {
    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Good name cannot be blank!")
    @Size(max = 20, message = "Good name has to be with up to 20 characters!")
    @Pattern(regexp = "^([a-z]).*", message = "Good name has to start with non-capital letter!")
    @Column(name = "name", nullable = false)
    private String name;

    @Positive
    @DecimalMin(value = "100.00", message = "Good weight has to be more than or equal to 100.00", inclusive = true)
    @DecimalMax(value = "900.00", message = "Good weight has to be less than or equal to 1000.00")
    @Digits(integer = 3, fraction = 2, message = "Good weight has to be with 3 digits before and 2 digits after the decimal separator!")
    @Column(name = "weight", nullable = false)
    private BigDecimal weight;

    @ManyToOne (fetch = FetchType.LAZY)
    private Transportation transportation;

    public Good() {
    }

    public Good(long id, String name, BigDecimal weight) {
        this.id = id;
        this.name = name;
        this.weight = weight;
    }

    public Good(long id, String name, BigDecimal weight, Transportation transportation) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.transportation = transportation;
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

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public Transportation getTransportation() {
        return transportation;
    }

    public void setTransportation(Transportation transportation) {
        this.transportation = transportation;
    }

    @Override
    public String toString() {
        return "Good{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }
}
