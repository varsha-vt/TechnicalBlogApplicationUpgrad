package technicalblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import technicalblog.model.Post;
import technicalblog.repository.PostRepository;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public List<Post> getAllPosts(){
        return repository.getAllPosts();
    }

    public Post getOnePost(){
        return repository.getLatestPost();
    }

    public void createPost(Post newPost){

        repository.createPost(newPost);
        System.out.println("New Post:"+newPost);
    }

}
