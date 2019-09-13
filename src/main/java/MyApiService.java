import Responses.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;


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
    public List<Post> getPosts(){
        Type listType = new TypeToken<List<Post>>(){}.getType();
        return gson.fromJson(takeJson("posts" ), listType);
    }
    public List<Album> getAlbums(){
        Type listType = new TypeToken<List<Album>>(){}.getType();
        return gson.fromJson(takeJson("albums" ), listType);
    }
    public List<Comment> getComments(){
        Type listType = new TypeToken<List<Comment>>(){}.getType();
        return gson.fromJson(takeJson("comments" ), listType);
    }
    public List<Photo> getPhotos(){
        Type listType = new TypeToken<List<Photo>>(){}.getType();
        return gson.fromJson(takeJson("photos" ), listType);
    }
    public List<Todo> getTodos(){
        Type listType = new TypeToken<List<Todo>>(){}.getType();
        return gson.fromJson(takeJson("todos" ), listType);
    }
    public List<User> getUsers(){
        Type listType = new TypeToken<List<User>>(){}.getType();
        return gson.fromJson(takeJson("users" ), listType);
    }
}
