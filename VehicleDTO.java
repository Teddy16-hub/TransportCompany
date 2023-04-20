package dto;

import entity.Company;
import entity.TypeOfVehicle;


public class VehicleDTO {
    private long id;
    private TypeOfVehicle typeOfVehicle;
    private Company company;

    public VehicleDTO() {
    }

    public VehicleDTO(long id, TypeOfVehicle typeOfVehicle) {
        this.id = id;
        this.typeOfVehicle = typeOfVehicle;
    }

    public VehicleDTO(long id, TypeOfVehicle typeOfVehicle, Company company) {
        this.id = id;
        this.typeOfVehicle = typeOfVehicle;
        this.company = company;
    }

    @Override
    public String toString() {
        return "VehicleDTO{" +
                "id=" + id +
                ", typeOfVehicle=" + typeOfVehicle +
                ", company=" + company +
                '}';
    }
}
