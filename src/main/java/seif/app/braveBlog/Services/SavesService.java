package seif.app.braveBlog.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import seif.app.braveBlog.Data.PostsRepository;
import seif.app.braveBlog.Data.SavesRepository;
import seif.app.braveBlog.Models.Post;
import seif.app.braveBlog.Models.Saves;

@Service
public class SavesService implements ISavesService {

    @Autowired
    private SavesRepository savesRepository;

    @Autowired
    private PostsRepository postsRepository;

    @Override
    public String didSave(Long postId, Long userId) {
        Saves savesOp = savesRepository.getSave(postId, userId);
        if (savesOp != null)
            return "saved";
        return "not saved";
    }

    @Override
    public String savePost(Saves saves) {
        Optional<Post> post = postsRepository.findById(saves.getPostId());
        if (post.isPresent()) {
            savesRepository.save(saves);
            Post res = post.get();
            if (res.getSaves() != null)
                res.setSaves(res.getSaves() + 1);
            else
                res.setSaves(1L);
            res = postsRepository.save(res);
            if (res != null)
                return "Success";
            return "Error";
        }
        return "Error";
    }

    @Override
    public String unsavePost(Saves saves) {
        Optional<Post> post = postsRepository.findById(saves.getPostId());
        if (post.isPresent()) {
            savesRepository.delete(saves);
            Post res = post.get();
            if (res.getSaves() != null)
                res.setSaves(res.getSaves() - 1);
            else
                res.setSaves(0L);
            res = postsRepository.save(res);
            if (res != null)
                return "Success";
            return "Error";
        }
        return "Error";
    }

    @Override
    public List<Saves> getSavesByUserId(Long userId) {
        Optional<List<Saves>> savesOp = savesRepository.findByUserId(userId);
        if (savesOp.isPresent())
            return savesOp.get();
        return new ArrayList<Saves>();
    }

}
