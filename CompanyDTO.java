package dto;

public class CompanyDTO {
    private long id;
    private String name;

    public CompanyDTO() {
    }

    public CompanyDTO(long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "CompanyDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
