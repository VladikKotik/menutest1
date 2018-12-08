package things.test.ru.menutest1;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

public class GalleryActivity extends BaseActivity {//baseactivity описывает логики менюхи

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        SpaceGalleryActivity spaceGalleryActivity=(SpaceGalleryActivity)findViewById(R.id.sga);
        spaceGalleryActivity=new SpaceGalleryActivity(this,null,0);
        NavigationView navigationView = (NavigationView) findViewById(R.id.gallery_nav_view);//навигейшн вю у каждой активити свой
        navigationView.setNavigationItemSelectedListener(this);////шоб менюха была живая и чета делала
    }

}
