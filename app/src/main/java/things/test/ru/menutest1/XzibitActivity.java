package things.test.ru.menutest1;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class XzibitActivity extends BaseActivity {

    RecyclerView recyclerView;
    List<PostPreviewModel> posts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xzibit);
        //NavigationView navigationView = (NavigationView) findViewById(R.id.xzibit_nav_view);
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

        posts = new ArrayList<>();

        recyclerView = (RecyclerView) findViewById(R.id.posts_recycle_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        PostsAdapter adapter = new PostsAdapter(this,posts);
        recyclerView.setAdapter(adapter);


        //App.getApi().getData("bash", 50).enqueue(new Callback<List<PostPreviewModel>>() {
        //App.getUmoriliApiRandom().getRandomData( 10).enqueue(new Callback<List<PostPreviewModel>>() {
        App.getMuzeyApiPosts().getData().enqueue(new Callback<List<PostPreviewModel>>() {
            @Override
            public void onResponse(Call<List<PostPreviewModel>> call, Response<List<PostPreviewModel>> response) {
                //System.out.println("=========responded");
                //System.out.println(response);
                posts.addAll(response.body());
                //posts.
                Collections.reverse(posts);
                //System.out.println("======got some to add");
                recyclerView.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<PostPreviewModel>> call, Throwable t) {
                Toast.makeText(XzibitActivity.this, "An error occurred during networking", Toast.LENGTH_SHORT).show();
            }
        });

    }



}