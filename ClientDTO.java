package dto;

import entity.Transportation;

public class ClientDTO {
    private long id;
    private String name;
    private Transportation transportation;
    private boolean isPaid;

    public ClientDTO() {
    }

    public ClientDTO(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public ClientDTO(long id, String name, Transportation transportation, boolean isPaid) {
        this.id = id;
        this.name = name;
        this.transportation = transportation;
        this.isPaid = isPaid;
    }

    @Override
    public String toString() {
        return "ClientDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", transportation=" + transportation +
                ", isPaid=" + isPaid +
                '}';
    }
}
