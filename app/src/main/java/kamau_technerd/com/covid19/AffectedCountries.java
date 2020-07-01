package kamau_technerd.com.covid19;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListView;

import com.leo.simplearcloader.SimpleArcLoader;

public class AffectedCountries extends AppCompatActivity {

    EditText edtSearch;
    ListView listView;
    SimpleArcLoader simpleArcLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affected_countries);
        edtSearch= findViewById(R.id.edtSearch);
        simpleArcLoader = findViewById(R.id.loader);
    }
}
