package things.test.ru.menutest1;

import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.webkit.WebView;
import android.widget.TextView;

public class GoodsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods);
        NavigationView navigationView = (NavigationView) findViewById(R.id.good_nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Resources res = getResources();


//        TextView textView=(TextView) findViewById(R.id.good_text);
//        String content= res.getString(R.string.good_about);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//            textView.setText(Html.fromHtml(content, Html.FROM_HTML_MODE_COMPACT));
//        } else {
//            textView.setText(Html.fromHtml(content));
//        }

        WebView view = (WebView) findViewById(R.id.textContent);
        String text;
        text = "<html><body><p align=\"justify\">";
        text+= "This <h1>is</h1> the text </p> ";
        text+= "<ul>\n" +
                " <li>Первый пункт</li>\n" +
                " <li>Второй пункт</li>\n" +
                " <li>Третий пункт</li>\n" +
                "</ul> </body></html>";
        view.loadDataWithBaseURL(null, text,"text/html", "UTF-8", null);
    }
}
