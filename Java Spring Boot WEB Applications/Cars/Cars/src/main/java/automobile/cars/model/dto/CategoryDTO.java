package automobile.cars.model.dto;

import javax.validation.constraints.NotNull;

public class CategoryDTO {

    private Long id;

    @NotNull
    private String category;

    public CategoryDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
