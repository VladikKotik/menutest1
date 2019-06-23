package things.test.ru.menutest1;

import android.content.Context;
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
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class BaseActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;

    protected Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext=BaseActivity.this;


    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        initToolbar();
       // System.out.println("init toolbar");
    }

    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar_new);
        setSupportActionBar(toolbar);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_new);
                navigationView.setNavigationItemSelectedListener(this);

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



        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_maps) {
            if(!(this instanceof MapsActivity)) {
                Intent intent = new Intent(this, MapsActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);//все активити над прописывать в манифесте!!
            }


        } else if (id == R.id.nav_main) {
            if(!(this instanceof MainActivity)){
            Intent intent = new Intent(this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);//все активити над прописывать в манифесте!!
            }

        }
        else if (id == R.id.nav_gallery) {
            if(!(this instanceof CategoriesActivity) && !(this instanceof ExposActivity) && !(this instanceof ExpoActivity)){
            Intent intent = new Intent(this, CategoriesActivity.class);

            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);}
        }

        else if(id==R.id.nav_goods){
            if(!(this instanceof GoodsActivity)) {
                Intent intent = new Intent(this, GoodsActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);//все активити над прописывать в манифесте!!
            }
        }
        else if(id==R.id.nav_contact){
            if(!(this instanceof ContactActivity)){
            Intent intent = new Intent(this, ContactActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);//все активити над прописывать в манифесте!!
            }
        }
        else if(id==R.id.nav_inclusive){
            if(!(this instanceof InclusiveActivity)){
                Intent intent = new Intent(this, InclusiveActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);//все активити над прописывать в манифесте!!
            }
        }
        else if(id==R.id.nav_xzibits){
            if(!(this instanceof XzibitActivity) && !(this instanceof PostActivity)){
                Intent intent = new Intent(this, XzibitActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);//все активити над прописывать в манифесте!!
            }
        }
        else if(id==R.id.nav_about){
            if(!(this instanceof AboutDevActivity)){
                Intent intent = new Intent(this, AboutDevActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);//все активити над прописывать в манифесте!!
            }
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

