package things.test.ru.menutest1;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.Gravity;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_new);
//
//        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

//         final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//                drawer.addDrawerListener(toggle);
//                toggle.syncState();
//
//                toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                      // You have to manually toggle drawer and set icon here
//                      if (drawer.isDrawerOpen(GravityCompat.START))
//                          drawer.closeDrawer(GravityCompat.START);
//                      else
//                          drawer.openDrawer((int) Gravity.START);
//                    }
//                });
//
////        NavigationView navigationView = (NavigationView) findViewById(R.id.main_nav_view);
//        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_new);
//        navigationView.setNavigationItemSelectedListener(this);

     //   Resources res = getResources();

        WebView view = (WebView) findViewById(R.id.textMain);
        String text;
        text = "<html><body bgcolor=\"#EEEEEE\">";

        text+= getResources().getString(R.string.main_about) +"  </body></html>";
        view.loadDataWithBaseURL(null, text,"text/html", "UTF-8", null);

    }
}
