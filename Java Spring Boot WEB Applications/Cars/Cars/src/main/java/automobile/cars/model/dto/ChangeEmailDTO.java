package automobile.cars.model.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class ChangeEmailDTO {

    @NotNull
    @Email
    private String newEmail;

    @NotNull
    @Email
    private String confirmNewEmail;

    public ChangeEmailDTO() {
    }

    public String getNewEmail() {
        return newEmail;
    }

    public void setNewEmail(String newEmail) {
        this.newEmail = newEmail;
    }

    public String getConfirmNewEmail() {
        return confirmNewEmail;
    }

    public void setConfirmNewEmail(String confirmNewEmail) {
        this.confirmNewEmail = confirmNewEmail;
    }
}
