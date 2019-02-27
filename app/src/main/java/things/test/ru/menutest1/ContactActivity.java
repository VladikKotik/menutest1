package things.test.ru.menutest1;

import android.os.Bundle;
import android.support.design.widget.NavigationView;

public class ContactActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        NavigationView navigationView = (NavigationView) findViewById(R.id.contact_nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        

    }
}
