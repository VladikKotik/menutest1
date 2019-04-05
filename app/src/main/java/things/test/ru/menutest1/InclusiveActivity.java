package things.test.ru.menutest1;

import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.Gravity;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;

public class InclusiveActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inclusive);
        NavigationView navigationView = (NavigationView) findViewById(R.id.inclusive_nav_view);
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

//        Resources res = getResources();
//
//
//        TextView textView=(TextView) findViewById(R.id.inclusive_text);
//        String content= res.getString(R.string.inclusive_about);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//            textView.setText(Html.fromHtml(content, Html.FROM_HTML_MODE_COMPACT));
//        } else {
//            textView.setText(Html.fromHtml(content));
//        }


        WebView view = (WebView) findViewById(R.id.textInclusive);
        String text;
        text = "<html><body><p align=\"justify\">";
        text+= "Посетить  экскурсии и мастер-классы  в музее могут вместе с родителями: </p> ";
        text+= "<ul>\n" +
                " <li>дети с врожденной инвалидностью;</li>\n" +
                " <li>дети, у которых ограниченные возможности в здоровой жизни</li>\n" +
                " <li>дети с отклонениями в развитии. </li></ul>\n" +
                "<p align=\"justify\">Инклюзия в культурно-образовательной сфере важна не только сама по себе," +
                " она является первым шагом на пути к открытому обществу.  </p>"+
                " </body></html>";
        view.loadDataWithBaseURL(null, text,"text/html", "UTF-8", null);

    }
}
