package things.test.ru.menutest1;

import android.app.Application;


import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import things.test.ru.menutest1.api.MuzeyApiPosts;


public class App extends Application {

    private static MuzeyApiPosts muzeyApiPosts;
    private Retrofit retrofit;

    @Override
    public void onCreate() {
        super.onCreate();


        retrofit = new Retrofit.Builder()

                .baseUrl("http://is_muz.o91328yq.beget.tech") //Базовая часть адреса
                .addConverterFactory(GsonConverterFactory.create()) //Конвертер, необходимый для преобразования JSON'а в объекты
                .build();


        muzeyApiPosts = retrofit.create(MuzeyApiPosts.class);
    }


    public static MuzeyApiPosts getMuzeyApiPosts(){return muzeyApiPosts;}
}