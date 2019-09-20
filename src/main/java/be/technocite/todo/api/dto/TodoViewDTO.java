package be.technocite.todo.api.dto;

import be.technocite.todo.model.User;

public class TodoViewDTO {

    private String text;
    private User user;

    public TodoViewDTO() {
    }

    public TodoViewDTO(String text, User user) {
        this.text = text;
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUsername(User user) {
        this.user = user;
    }


}
