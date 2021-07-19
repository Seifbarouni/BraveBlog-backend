package seif.app.braveBlog.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import seif.app.braveBlog.Models.Post;
import seif.app.braveBlog.Models.Saves;
import seif.app.braveBlog.Services.ISavesService;

@RestController
@RequestMapping("/s")
@CrossOrigin(origins = { "https://wonderful-knuth-debaec.netlify.app/",
                "http://localhost:3000" }, exposedHeaders = "**")
public class SavesController {

        @Autowired
        private ISavesService savesService;

        @GetMapping("/didSave/{postId}/{userId}")
        public String didSave(@PathVariable(name = "postId") Long postId, @PathVariable(name = "userId") Long userId) {
                return savesService.didSave(postId, userId);
        }

        @GetMapping("/save/{postId}/{userId}")
        public String save(@PathVariable(name = "postId") Long postId, @PathVariable(name = "userId") Long userId) {
                return savesService.savePost(new Saves(postId, userId));
        }

        @GetMapping("/unsave/{postId}/{userId}")
        public String unsave(@PathVariable(name = "postId") Long postId, @PathVariable(name = "userId") Long userId) {
                return savesService.unsavePost(new Saves(postId, userId));
        }

        @GetMapping("/getSavedPosts/{userId}")
        public List<Post> getPosts(@PathVariable(name = "userId") Long userId) {
                return savesService.getSavesByUserId(userId);
        }

}
