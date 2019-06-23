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

        Resources res = getResources();


        WebView view = (WebView) findViewById(R.id.textDevelopers);
        String text;
        text = "<html><body bgcolor=\"#EEEEEE\">";
        text+=res.getString(R.string.dev_about);
        text+= "</body></html>";
        view.loadDataWithBaseURL(null, text,"text/html", "UTF-8", null);
    }
}
