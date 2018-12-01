package things.test.ru.menutest1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ContentGalleryZaglushka2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_gallery_zaglushka2);
        TextView tv=(TextView)findViewById(R.id.textView2);
        tv.setText("helloworld228");
    }
}
