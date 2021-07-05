package seif.app.blaviken.Models;

public class UpdateUser {
    private String username;
    private String newUsername;
    private String newEmail;
    private String newImage;

    public UpdateUser() {
    }

    public UpdateUser(String username, String newUsername, String newEmail, String newImage) {
        this.username = username;
        this.newUsername = newUsername;
        this.newEmail = newEmail;
        this.newImage = newImage;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNewUsername() {
        return newUsername;
    }

    public void setNewUsername(String newUsername) {
        this.newUsername = newUsername;
    }

    public String getNewEmail() {
        return newEmail;
    }

    public void setNewEmail(String newEmail) {
        this.newEmail = newEmail;
    }

    public String getNewImage() {
        return newImage;
    }

    public void setNewImage(String newImage) {
        this.newImage = newImage;
    }

}
