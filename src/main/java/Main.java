import Responses.Post;
import Responses.User;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        MyApiService myApiService = MyApiService.getInstance();
        Post post = myApiService.getPostById(1);
        System.out.println(post);
        List<Post> posts = myApiService.getPosts();
        System.out.println(posts);

        List<User> users = myApiService.getUsers();
        System.out.println(users);
    }
}
