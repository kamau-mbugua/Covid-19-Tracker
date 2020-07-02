package kamau_technerd.com.covid19;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class MyCustomAdapter extends ArrayAdapter<CountryModel> {

    private Context context;
    private List<CountryModel> countryModelList;
    private List<CountryModel> countryModelsListFiltered;

    public MyCustomAdapter(Context context, List<CountryModel> countryModelList) {
        super(context, R.layout.row_layout,countryModelList);

        this.context = context;
        this.countryModelList = countryModelList;
        this.countryModelsListFiltered = countryModelList;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout,null,true);
        TextView tvCountryName = view.findViewById(R.id.tvCountryName);
        ImageView imageView =view.findViewById(R.id.ivflag);
        tvCountryName.setText(countryModelsListFiltered.get(position).getCountry());
        Glide.with(context).load(countryModelsListFiltered.get(position).getFlag()).into(imageView);

        return view;
    }

    @Override
    public int getCount() {
        return countryModelsListFiltered.size();
    }

    @Nullable
    @Override
    public CountryModel getItem(int position) {
        return countryModelsListFiltered.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @NonNull
    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                FilterResults filterResults = new FilterResults();
                if (charSequence == null || charSequence.length() ==0){
                    filterResults.count = countryModelList.size();
                    filterResults.values = countryModelList;
                } else {
                    List<CountryModel> resultsModel = new ArrayList<>();
                    String searchstr =  charSequence.toString().toLowerCase();

                    for (CountryModel itemModel :countryModelList){
                        if (itemModel.getCountry().toLowerCase().contains(searchstr)){
                            resultsModel.add(itemModel);
                        }
                        filterResults.count = resultsModel.size();
                        filterResults.values = resultsModel;

                    }
                }
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {

                countryModelsListFiltered =(List<CountryModel>) filterResults .values;
                AffectedCountries.countryModelsList = (List<CountryModel>) filterResults.values;
                notifyDataSetChanged();
            }
        };
        return filter;
    }
}
