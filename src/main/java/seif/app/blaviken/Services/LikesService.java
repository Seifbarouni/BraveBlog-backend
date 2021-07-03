package seif.app.blaviken.Services;

import java.lang.StackWalker.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import seif.app.blaviken.Data.LikesRepository;
import seif.app.blaviken.Data.PostsRepository;
import seif.app.blaviken.Models.Likes;
import seif.app.blaviken.Models.Post;

@Service
public class LikesService implements ILikesService {

    @Autowired
    private LikesRepository likesRepository;

    @Autowired
    private PostsRepository postsRepository;

    @Override
    public String didLike(Long postId, Long userId) {
        Likes likesOp = likesRepository.getLike(postId, userId);
        if (likesOp != null)
            return "liked";
        return "not liked";
    }

    @Override
    public List<Long> getLikesByUserId(Long userId) {
        List<Likes> likes = likesRepository.findByUserId(userId);
        List<Long> res = new ArrayList<Long>();
        for (Likes like : likes) {
            res.add(like.getPostId());
        }
        return res;
    }

    @Override
    public String likePost(Likes likes) {
        Optional<Post> post = postsRepository.findById(likes.getPostId());
        if (post.isPresent()) {
            likesRepository.save(likes);
            Post res = post.get();
            res.setLikes(res.getLikes() + 1);
            res = postsRepository.save(res);
            if (res != null)
                return "Success";
            return "Error";
        }
        return "Error";
    }

    @Override
    public String dislikePost(Likes likes) {
        Optional<Post> post = postsRepository.findById(likes.getPostId());
        if (post.isPresent()) {
            likesRepository.delete(likes);
            Post res = post.get();
            res.setLikes(res.getLikes() - 1);
            res = postsRepository.save(res);
            if (res != null)
                return "Success";
            return "Error";
        }
        return "Error";
    }

}
