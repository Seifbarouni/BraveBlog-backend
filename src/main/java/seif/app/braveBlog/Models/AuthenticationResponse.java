package seif.app.braveBlog.Models;

public class AuthenticationResponse {
    private String message;
    private String jwt;
    private String username;
    private String email;
    private String picUrl;
    private Long userId;

    public AuthenticationResponse(String message, String jwt, String username, String email, String picUrl,
            Long userId) {
        this.message = message;
        this.jwt = jwt;
        this.username = username;
        this.email = email;
        this.picUrl = picUrl;
        this.userId = userId;
    }

    public AuthenticationResponse() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

}
