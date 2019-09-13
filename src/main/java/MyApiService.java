import Responses.*;
import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;


public class MyApiService {
    private static MyApiService instance;
    private final String URL = "https://jsonplaceholder.typicode.com/";
    private OkHttpClient client = new OkHttpClient();
    private Gson gson = new Gson();

    private MyApiService() {
    }

    public static synchronized MyApiService getInstance() {
        if (instance == null) {
            instance = new MyApiService();
        }
        return instance;
    }
    public String takeJson(String addURL){
        Request request = new Request
                .Builder()
                .url(URL + addURL)
                .build();
        try {
            Response response = client.newCall(request).execute();
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    public Post getPostById (int id){
        return gson.fromJson(takeJson("posts/" + id), Post.class);
    }
    public Album getAlbumById(int id){
        return gson.fromJson(takeJson("albums/"+id), Album.class);
    }
    public Comment getCommentById(int id){
        return gson.fromJson(takeJson("comments/"+id), Comment.class);
    }
    public Photo getPhotoById(int id){
        return gson.fromJson(takeJson("photos/"+id), Photo.class);
    }
    public Todo getTodoById (int id){
        return gson.fromJson(takeJson("todos/"+id), Todo.class);
    }
    public User getUserById(int id){
        return gson.fromJson(takeJson("users"+id), User.class);
    }
    /*public List <Post> getPosts(){
        List <Post> list = new ArrayList<Post>();
        return gson.fromJson(takeJson("posts/" + list));
    }*/
}
