package things.test.ru.menutest1;

import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.text.Html;
import android.widget.TextView;

public class ContactActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        NavigationView navigationView = (NavigationView) findViewById(R.id.contact_nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Resources res = getResources();

        TextView textView=(TextView) findViewById(R.id.TextView_000);
        String content= res.getString(R.string.contact_zagolovok);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            textView.setText(Html.fromHtml(content, Html.FROM_HTML_MODE_COMPACT));
        } else {
            textView.setText(Html.fromHtml(content));
        }

    }
}
