package things.test.ru.menutest1;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.LazyHeaders;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ExpoActivity extends BaseActivity {

    private ImageView expo_image;
    private TextView expo_title;
    private TextView expo_content;
    ExpoModel expo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expo);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_new);
        navigationView.setNavigationItemSelectedListener(this);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_new);
        setSupportActionBar(toolbar);


        final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // You have to manually toggle drawer and set icon here
                if (drawer.isDrawerOpen(GravityCompat.START))
                    drawer.closeDrawer(GravityCompat.START);
                else
                    drawer.openDrawer((int) Gravity.START);
            }
        });

        int expo_id=getIntent().getIntExtra("expo_ID",-1);

        App.getMuzeyApiPosts().getExpo(expo_id).enqueue(new Callback<ExpoModel>() {
            @Override
            public void onResponse(Call<ExpoModel> call, Response<ExpoModel> response) {
                expo=response.body();
                expo_title=findViewById(R.id.expo_title);
                expo_content=findViewById(R.id.expo_content);
                expo_image=findViewById(R.id.expo_image);

                expo_title.setText("\t\t"+expo.getPostTitle());

                String result_post_content = expo.getPostContent().replaceAll("[<].*?[>]", "");

                expo_content.setText(result_post_content);

                if (expo != null) {


                    GlideUrl url = new GlideUrl(expo.getGuid(), new LazyHeaders.Builder()
                            .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0")
                            .build());

                    Glide.with(ExpoActivity.this)
                            .load(url)
                            .placeholder(R.drawable.ic_cloud_off_red)
                            .skipMemoryCache(true)
                            .diskCacheStrategy(DiskCacheStrategy.NONE)
                            .into(expo_image);
                }
            }

            @Override
            public void onFailure(Call<ExpoModel> call, Throwable t) {
                Toast.makeText(ExpoActivity.this, "An error occurred during networking", Toast.LENGTH_SHORT).show();
            }
        });


    }

}

