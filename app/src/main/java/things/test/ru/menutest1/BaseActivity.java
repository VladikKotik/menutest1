package things.test.ru.menutest1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class BaseActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
//                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        drawer.addDrawerListener(toggle);
//        toggle.syncState();
//
//        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
//        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_maps) {

            Intent intent = new Intent(this, MapsActivity.class);
            startActivity(intent);//все активити над прописывать в манифесте!!

        } else if (id == R.id.nav_gallery) {
            if(!(this instanceof GalleryActivity)) {
                Intent intent = new Intent(this, GalleryActivity.class);
                startActivity(intent);//все активити над прописывать в манифесте!!
            }


        } else if (id == R.id.nav_main) {
            if(!(this instanceof MainActivity)){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);//все активити над прописывать в манифесте!!
            }

        } //else if (id == R.id.nav_manage) {}

        else if(id==R.id.nav_goods){
            if(!(this instanceof GoodsActivity)) {
                Intent intent = new Intent(this, GoodsActivity.class);
                startActivity(intent);//все активити над прописывать в манифесте!!
            }
        }
        else if(id==R.id.nav_contact){
            if(!(this instanceof ContactActivity)){
            Intent intent = new Intent(this, ContactActivity.class);
            startActivity(intent);//все активити над прописывать в манифесте!!
            }
        }
        else if(id==R.id.nav_inclusive){
            if(!(this instanceof InclusiveActivity)){
                Intent intent = new Intent(this, InclusiveActivity.class);
                startActivity(intent);//все активити над прописывать в манифесте!!
            }
        }
        else if(id==R.id.nav_xzibits){
            if(!(this instanceof XzibitActivity) && !(this instanceof PostActivity)){
                Intent intent = new Intent(this, XzibitActivity.class);
                startActivity(intent);//все активити над прописывать в манифесте!!
            }
        }

//        else if (id == R.id.nav_share) {
//
//        } else if (id == R.id.nav_send) {
//
//        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

