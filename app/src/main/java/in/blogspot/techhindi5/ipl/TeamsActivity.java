package in.blogspot.techhindi5.ipl;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class TeamsActivity extends AppCompatActivity {
    AdView mAdView;
    public InterstitialAd interstitialAd,interstitialAd2,interstitialAd3,interstitialAd4,interstitialAd5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teams);
        MobileAds.initialize(this, "ca-app-pub-7565184612395429/9593526401");
        interstitialAd=new InterstitialAd(this);
        interstitialAd.setAdUnitId("ca-app-pub-7565184612395429/6256437695");
        interstitialAd.loadAd(new AdRequest.Builder().build());
        interstitialAd.setAdListener(new AdListener()
        {

            public void onAdClosed()
            {


                interstitialAd.loadAd(new AdRequest.Builder().build());

            }
        });
    }
}
