package be.technocite.todo.model;

import java.util.Collection;
import java.util.Objects;

public class User {

    private long id;

    private String firstName;
    private String lastName;
    private String email;
    private String password;

    private Collection<Todo> todoList;

    public User(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<Todo> getTodoList() {
        return todoList;
    }

    public void setTodoList(Collection<Todo> todoList) {
        this.todoList = todoList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id==user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
