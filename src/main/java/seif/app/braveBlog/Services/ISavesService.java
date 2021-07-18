package seif.app.braveBlog.Services;

import java.util.List;

import seif.app.braveBlog.Models.Saves;

public interface ISavesService {
    public String didSave(Long postId, Long userId);

    public String savePost(Saves saves);

    public List<Saves> getSavesByUserId(Long userId);

    public String unsavePost(Saves saves);
}