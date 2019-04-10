package things.test.ru.menutest1;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.LazyHeaderFactory;
import com.bumptech.glide.load.model.LazyHeaders;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostActivity extends BaseActivity {

    private ImageView post_image;
    private TextView post_title;
    private TextView post_content;
    PostModel post;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        NavigationView navigationView = (NavigationView) findViewById(R.id.post_nav_view);
        navigationView.setNavigationItemSelectedListener(this);
//        //final PostModel[] post = new PostModel[1];

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

        int post_id=getIntent().getIntExtra("post_ID",-1);
        App.getMuzeyApiPosts().getPost(post_id).enqueue(new Callback<PostModel>() {
            @Override
            public void onResponse(Call<PostModel> call, Response<PostModel> response) {
                post=response.body();
                post_title=findViewById(R.id.post_title);
                post_content=findViewById(R.id.post_content);
                post_image=findViewById(R.id.post_image);

                post_title.setText("\t\t"+post.getPostTitle());
                //post_content.setText(post.getPostContent());

//                //String result_post_title= "<![CDATA[<h1>\\t"+post.getPostTitle()+"</h1>]]>";
//                String result_post_title= "<![CDATA[<h1>\t Контактная информация</h1>]]>";
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//                    post_title.setText(Html.fromHtml(result_post_title, Html.FROM_HTML_MODE_COMPACT));
//                } else {
//                    post_title.setText(Html.fromHtml(result_post_title));
//                }



                //System.out.println(post.getPostContent());
                String result_post_content = post.getPostContent().replaceAll("[<].*?[>]", "");
                //String result_post_content2 = result_post_content.replaceFirst("\r\n\r", "\n\t\t");

                post_content.setText(result_post_content);

                if (post != null) {


                    GlideUrl url = new GlideUrl(post.getGuid(), new LazyHeaders.Builder()
                            .addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0")
                            .build());

                    Glide.with(PostActivity.this).load(url)
                            .placeholder(R.drawable.ic_cloud_off_red)
                            .into(post_image);
                }
            }

            @Override
            public void onFailure(Call<PostModel> call, Throwable t) {
                Toast.makeText(PostActivity.this, "An error occurred during networking", Toast.LENGTH_SHORT).show();
            }
        });

        //вот тут пост уже нулл cyfчала всё до запроса, а потом уже запрос так шо над все внутри во время выполнения запроса

        //тут мб сделать регеэкспом шоб игнорил <img * />



    }

}

