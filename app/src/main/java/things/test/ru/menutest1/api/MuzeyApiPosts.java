package things.test.ru.menutest1.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import things.test.ru.menutest1.CategoryModel;
import things.test.ru.menutest1.ExpoModel;
import things.test.ru.menutest1.ExpoPreviewModel;
import things.test.ru.menutest1.PostModel;
import things.test.ru.menutest1.PostPreviewModel;


public interface MuzeyApiPosts {

    @Headers({
        "Accept: application/json",
                "User-Agent: Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0",
                "Cache-Control: max-age=640000"
    })

    //@GET("/muzey/api/posts.php")
    @GET("/api/posts.php/")
    Call<List<PostPreviewModel>> getData();



    @Headers({
            "Accept: application/json",
            "User-Agent: Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0",
            "Cache-Control: max-age=640000"
    })
//    @GET("/muzey/api/post.php")
    @GET("/api/post.php")
    Call<PostModel>getPost(@Query("ID") int id);

    @Headers({
            "Accept: application/json",
            "User-Agent: Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0",
            "Cache-Control: max-age=640000"
    })
    @GET("/api/category.php/")
    Call<List<CategoryModel>> getCategories();


    @Headers({
            "Accept: application/json",
            "User-Agent: Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0",
            "Cache-Control: max-age=640000"
    })
    @GET("/api/exp.php")
    Call<ExpoModel>getExpo(@Query("ID") int id);

    //в эекспонатах категории id МАЛЕНЬКИМИ!!!

    @Headers({
            "Accept: application/json",
            "User-Agent: Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0",
            "Cache-Control: max-age=640000"
    })
    @GET("/api/category_exp.php/")
    Call<List<ExpoPreviewModel>> getExpos(@Query("id") int id);
}
