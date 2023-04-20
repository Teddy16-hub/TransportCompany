package entity;

import javax.persistence.*;

@Entity
@Table(name = "vehicle")
public class Vehicle {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="type_of_vehicle", nullable = false)
    @Enumerated(EnumType.STRING)
    private TypeOfVehicle typeOfVehicle;

    @ManyToOne (fetch = FetchType.LAZY)
    private Company company;

    public Vehicle() {
    }

    public Vehicle(long id, TypeOfVehicle typeOfVehicle) {
        this.id = id;
        this.typeOfVehicle = typeOfVehicle;
    }

    public Vehicle(long id, TypeOfVehicle typeOfVehicle, Company company) {
        this.id = id;
        this.typeOfVehicle = typeOfVehicle;
        this.company = company;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public TypeOfVehicle getTypeOfVehicle() {
        return typeOfVehicle;
    }

    public void setTypeOfVehicle(TypeOfVehicle typeOfVehicle) {
        this.typeOfVehicle = typeOfVehicle;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", typeOfVehicle=" + typeOfVehicle +
                '}';
    }
}
