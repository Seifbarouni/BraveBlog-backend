package seif.app.braveBlog.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "all_posts")
public class Post {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "title", nullable = false)
    private String title;

    @Lob
    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "user", nullable = false)
    private String user;

    @Column(name = "bg_url")
    private String bgUrl;

    @Column(name = "created", nullable = false)
    private String createdAt;

    @Column(name = "likes", nullable = false)
    private Long likes;

    public Post(String title, String content, String user, String bgUrl, String createdAt, Long likes) {
        this.title = title;
        this.content = content;
        this.user = user;
        this.bgUrl = bgUrl;
        this.createdAt = createdAt;
        this.likes = likes;
    }

    public Post() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getBgUrl() {
        return bgUrl;
    }

    public void setBgUrl(String bgUrl) {
        this.bgUrl = bgUrl;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Long getLikes() {
        return likes;
    }

    public void setLikes(Long likes) {
        this.likes = likes;
    }

}
