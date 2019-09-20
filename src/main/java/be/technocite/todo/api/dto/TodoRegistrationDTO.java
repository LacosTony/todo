package be.technocite.todo.api.dto;

import javax.validation.constraints.NotEmpty;

public class TodoRegistrationDTO {

    @NotEmpty
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
