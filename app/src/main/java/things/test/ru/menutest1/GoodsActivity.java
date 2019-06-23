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

public class GoodsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods);


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



        WebView view = (WebView) findViewById(R.id.textGoods);
        String text;
        text = "<html><body bgcolor=\"#EEEEEE\">";
        text+= "<ul>\n" +
                " <li>Выездная выставка - от 10 000 рублей</li>\n" +
                " <li>Онлайн-трансляция экскурсии с выставки - по договоренности</li>\n" +
                " <li>Мастер-классы по тематике 150-250 рублей </li>\n" +
                " <li>Квест по выставке - по договоренности </li>\n" +
                " <li>Посещение выставки от 100 до 250 рублей. Цены уточняйте в кассе </li>\n" +
                "</ul>  </body></html>";
        view.loadDataWithBaseURL(null, text,"text/html", "UTF-8", null);
    }
}
