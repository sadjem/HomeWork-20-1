import Responses.Album;
import Responses.Post;

public class Main {
    public static void main(String[] args) {
        MyApiService myApiService = MyApiService.getInstance();
        Post post = myApiService.getPostById(1);
        System.out.println(post);

        System.out.println("============");
        Album album = myApiService.getAlbumById(1);
        System.out.println(album);
    }
}
