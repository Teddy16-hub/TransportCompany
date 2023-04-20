package dto;

import entity.Transportation;

import java.math.BigDecimal;

public class GoodDTO {
    private long id;
    private String name;
    private BigDecimal weight;
    private Transportation transportation;

    public GoodDTO() {
    }

    public GoodDTO(long id, String name, BigDecimal weight) {
        this.id = id;
        this.name = name;
        this.weight = weight;
    }

    public GoodDTO(long id, String name, BigDecimal weight, Transportation transportation) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.transportation = transportation;
    }

    @Override
    public String toString() {
        return "GoodDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", transportation=" + transportation +
                '}';
    }
}
