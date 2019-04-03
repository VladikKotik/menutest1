package things.test.ru.menutest1;

import android.app.Application;


import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import things.test.ru.menutest1.api.MuzeyApiPosts;
//import things.test.ru.resttest1.api.UmoriliApi;
//import things.test.ru.resttest1.api.UmoriliApiRandom;

public class App extends Application {

//    private static UmoriliApi umoriliApi;
//    private static UmoriliApiRandom umoriliApiRandom;
    private static MuzeyApiPosts muzeyApiPosts;
    private Retrofit retrofit;

    @Override
    public void onCreate() {
        super.onCreate();


        retrofit = new Retrofit.Builder()
                //.baseUrl("https://umorili.herokuapp.com") //Базовая часть адреса
                //.baseUrl("http://82.179.9.49") //Базовая часть адреса
                .baseUrl("http://is_muz.o91328yq.beget.tech") //Базовая часть адреса
                .addConverterFactory(GsonConverterFactory.create()) //Конвертер, необходимый для преобразования JSON'а в объекты
                .build();

//        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
//
//        httpClient.addInterceptor(new Interceptor() {
//            @Override
//            public okhttp3.Response intercept(Chain chain) throws IOException {
//                Request request = chain.request().newBuilder().addHeader("User-Agent", "Other").build();
//                return chain.proceed(request);
//            }
//        });
//        Retrofit retrofit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl("http://is_muz.o91328yq.beget.tech").client(httpClient.build()).build();

       // umoriliApi = retrofit.create(UmoriliApi.class); //Создаем объект, при помощи которого будем выполнять запросы
        //umoriliApiRandom = retrofit.create(UmoriliApiRandom.class);// для рандома


        muzeyApiPosts = retrofit.create(MuzeyApiPosts.class);
    }

//    public static UmoriliApi getApi() {
//        return umoriliApi;
//    }
//
//    public static UmoriliApiRandom getUmoriliApiRandom(){
//        return umoriliApiRandom;
//    }

    public static MuzeyApiPosts getMuzeyApiPosts(){return muzeyApiPosts;}
}