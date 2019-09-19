package be.technocite.todo.api.dto;

public class TodoViewDTO {

    private String text;
    private UserInfoDTO user;

    public TodoViewDTO() {
    }

    public TodoViewDTO(String text, UserInfoDTO user) {
        this.text = text;
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public UserInfoDTO getUser() {
        return user;
    }

    public void setUsername(UserInfoDTO user) {
        this.user = user;
    }


}
