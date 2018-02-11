package net.anviprojects.SpringMVCProject.mvc.bean;

public class User {
    private int idUser;
    private String username;
    private String password;
    private boolean enabled;

    public User() {}

    public User(int idUser, String username, String password, boolean enabled) {
        this.idUser = idUser;
        this.username = username;
        this.password = password;
        this.enabled = enabled;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}


