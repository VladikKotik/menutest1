package things.test.ru.menutest1;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.webkit.WebView;

public class AboutDevActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_aboutdev);

        //NavigationView navigationView = (NavigationView) findViewById(R.id.dev_nav_view);

//        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_new);
//
//        navigationView.setNavigationItemSelectedListener(this);
//
//
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_new);
//        setSupportActionBar(toolbar);
//
//
//        final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        drawer.addDrawerListener(toggle);
//        toggle.syncState();
//
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                // You have to manually toggle drawer and set icon here
//                if (drawer.isDrawerOpen(GravityCompat.START))
//                    drawer.closeDrawer(GravityCompat.START);
//                else
//                    drawer.openDrawer((int) Gravity.START);
//            }
//        });

        //


//        TextView textView=(TextView) findViewById(R.id.good_text);
//        String content= res.getString(R.string.good_about);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//            textView.setText(Html.fromHtml(content, Html.FROM_HTML_MODE_COMPACT));
//        } else {
//            textView.setText(Html.fromHtml(content));
//        }
        Resources res = getResources();


        WebView view = (WebView) findViewById(R.id.textDevelopers);
        String text;
        text = "<html><body bgcolor=\"#EEEEEE\">";
        text+=res.getString(R.string.dev_about);
        text+= "</body></html>";
        view.loadDataWithBaseURL(null, text,"text/html", "UTF-8", null);
    }
}
