package kamau_technerd.com.covid19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class CountryDetails extends AppCompatActivity {
   /* ImageView ivFlagCountry;*/

    /*private String positionCountryFlag;*/

    AdView adView;

    private int positionCountry;

    TextView tvCountry, tvCases,tvRecovered,tvcritical, tvActive, tvTodayCases, tvDeaths, tvTodayDeaths;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_details);
        Intent intent = getIntent();
        positionCountry = intent.getIntExtra("position",0);

        tvCountry = findViewById(R.id.tvCountryDetails);
        tvCases = findViewById(R.id.tvCasesDetails);
        tvRecovered = findViewById(R.id.tvRecoveredDetails);
        tvcritical = findViewById(R.id.tvCriticalDetails);
        tvActive = findViewById(R.id.tvActiveDetails);
        tvTodayCases = findViewById(R.id.tvTodayCasesDetails);
        tvDeaths = findViewById(R.id.tvDeathsDetails);
        tvTodayDeaths = findViewById(R.id.tvTodayDeathsDetails);
        /*ivFlagCountry = findViewById(R.id.ivFlagCountry);*/

        getSupportActionBar().setTitle("Covid 19  Stats of"+ AffectedCountries.countryModelsList.get(positionCountry).getCountry());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);



        /*Intent inte = getIntent();
        positionCountryFlag = inte.getStringExtra("position");*/
      //  positionCountryFlag = intent.getIntExtra("position",0);

        tvCountry.setText(AffectedCountries.countryModelsList.get(positionCountry).getCountry());
        tvCases.setText(AffectedCountries.countryModelsList.get(positionCountry).getCases());
        tvRecovered.setText(AffectedCountries.countryModelsList.get(positionCountry).getRecovered());
        tvcritical.setText(AffectedCountries.countryModelsList.get(positionCountry).getCritical());
        tvActive.setText(AffectedCountries.countryModelsList.get(positionCountry).getActive());
        tvTodayCases.setText(AffectedCountries.countryModelsList.get(positionCountry).getTodayCases());
        tvDeaths.setText(AffectedCountries.countryModelsList.get(positionCountry).getDeaths());
        tvTodayDeaths.setText(AffectedCountries.countryModelsList.get(positionCountry).getTodayDeaths());
        /*ivFlagCountry.setImageResource(AffectedCountries.countryModelsList.get(positionCountryFlag).getFlag());*/
       // ivFlagCountry.setText(AffectedCountries.countryModelsList.get(positionCountry).getCountry());

        adView = findViewById(R.id.adView);
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {

            }
        });

        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);


    }
}
