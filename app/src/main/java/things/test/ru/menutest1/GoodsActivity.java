package things.test.ru.menutest1;

import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.widget.TextView;

public class GoodsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods);
        NavigationView navigationView = (NavigationView) findViewById(R.id.good_nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Resources res = getResources();


        TextView textView=(TextView) findViewById(R.id.good_text);
        String content= res.getString(R.string.good_about);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            textView.setText(Html.fromHtml(content, Html.FROM_HTML_MODE_COMPACT));
        } else {
            textView.setText(Html.fromHtml(content));
        }

    }
}
