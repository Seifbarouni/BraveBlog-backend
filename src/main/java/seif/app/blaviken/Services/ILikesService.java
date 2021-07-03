package seif.app.blaviken.Services;

import java.util.List;

import seif.app.blaviken.Models.Likes;

public interface ILikesService {
    public String didLike(Long postId, Long userId);

    public List<Long> getLikesByUserId(Long userId);

    public String likePost(Likes likes);

    public String dislikePost(Likes likes);
}
