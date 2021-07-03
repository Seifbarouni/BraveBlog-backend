package seif.app.blaviken.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import seif.app.blaviken.Models.Likes;
import seif.app.blaviken.Services.ILikesService;

@RestController
@RequestMapping("/l")
@CrossOrigin(origins = "http://localhost:3000", exposedHeaders = "**")
public class LikesController {
    @Autowired
    private ILikesService likesService;

    @GetMapping("/getLikes/{id}")
    public List<Long> getLikesByUserId(@PathVariable(name = "id") Long userId) {
        return likesService.getLikesByUserId(userId);
    }

    @GetMapping("/didLike/{postId}/{userId}")
    public String didLike(@PathVariable(name = "postId") Long postId, @PathVariable(name = "userId") Long userId) {
        return likesService.didLike(postId, userId);
    }

    @GetMapping("/like/{postId}/{userId}")
    public String like(@PathVariable(name = "postId") Long postId, @PathVariable(name = "userId") Long userId) {
        return likesService.likePost(new Likes(postId, userId));
    }

    @GetMapping("/dislike/{postId}/{userId}")
    public String dislike(@PathVariable(name = "postId") Long postId, @PathVariable(name = "userId") Long userId) {
        return likesService.dislikePost(new Likes(postId, userId));
    }
}
