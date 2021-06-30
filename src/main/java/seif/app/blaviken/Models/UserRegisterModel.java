package seif.app.blaviken.Models;

public class UserRegisterModel {
    private String username;
    private String email;
    private String picUrl;
    private String password;

    public UserRegisterModel(String username, String email, String picUrl, String password) {
        this.username = username;
        this.email = email;
        this.picUrl = picUrl;
        this.password = password;
    }

    public UserRegisterModel() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
