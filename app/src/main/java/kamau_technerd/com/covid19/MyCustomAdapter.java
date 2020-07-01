package kamau_technerd.com.covid19;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

public class MyCustomAdapter extends ArrayAdapter<CountryModel> {

    public MyCustomAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }
}
