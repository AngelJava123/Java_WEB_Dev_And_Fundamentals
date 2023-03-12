package automobile.cars.model.dto;

import javax.validation.constraints.NotNull;

public class ProductionDateDTO {

    private Long id;

    @NotNull
    private String month;

    @NotNull
    private String year;


    public ProductionDateDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
