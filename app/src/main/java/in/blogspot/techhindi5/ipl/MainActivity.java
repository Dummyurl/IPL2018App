package in.blogspot.techhindi5.ipl;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {
Button b1,b2,b3,b4,b5;
    AdView mAdView;
    public InterstitialAd interstitialAd,interstitialAd2,interstitialAd3,interstitialAd4,interstitialAd5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);
        b3=(Button)findViewById(R.id.b3);
        b4=(Button)findViewById(R.id.b4);
        MobileAds.initialize(this, "ca-app-pub-7565184612395429/9593526401");
        interstitialAd=new InterstitialAd(this);
        interstitialAd.setAdUnitId("ca-app-pub-7565184612395429/6256437695");
        interstitialAd.loadAd(new AdRequest.Builder().build());
        interstitialAd.setAdListener(new AdListener()
        {

            public void onAdClosed()
            {

                Intent i=new Intent(MainActivity.this,ScheduleActivity.class);
                startActivity(i);

                interstitialAd.loadAd(new AdRequest.Builder().build());

            }
        });

        interstitialAd2=new InterstitialAd(this);
        interstitialAd2.setAdUnitId("ca-app-pub-7565184612395429/6256437695");
        interstitialAd2.loadAd(new AdRequest.Builder().build());
        interstitialAd2.setAdListener(new AdListener()
        {

            public void onAdClosed()
            {

                Intent i=new Intent(MainActivity.this,TeamsActivity.class);
                startActivity(i);

                interstitialAd2.loadAd(new AdRequest.Builder().build());

            }
        });


        interstitialAd3=new InterstitialAd(this);
        interstitialAd3.setAdUnitId("ca-app-pub-7565184612395429/6256437695");
        interstitialAd3.loadAd(new AdRequest.Builder().build());
        interstitialAd3.setAdListener(new AdListener()
        {

            public void onAdClosed()
            {

                Intent i=new Intent(MainActivity.this,PointsActivity.class);
                startActivity(i);

                interstitialAd3.loadAd(new AdRequest.Builder().build());

            }
        });
        interstitialAd4=new InterstitialAd(this);
        interstitialAd4.setAdUnitId("ca-app-pub-7565184612395429/6256437695");
        interstitialAd4.loadAd(new AdRequest.Builder().build());
        interstitialAd4.setAdListener(new AdListener()
        {

            public void onAdClosed()
            {
                finish();
                System.exit(0);
                System.gc();
                interstitialAd4.loadAd(new AdRequest.Builder().build());
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(interstitialAd.isLoaded()){
                    interstitialAd.show();}
                else {
                    Intent i = new Intent(MainActivity.this, ScheduleActivity.class);
                    startActivity(i);
                }

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(interstitialAd2.isLoaded()){
                    interstitialAd2.show();}
                else {
                    Intent i = new Intent(MainActivity.this, TeamsActivity.class);
                    startActivity(i);
                }
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(interstitialAd3.isLoaded()){
                    interstitialAd3.show();}
                else {
                    Intent i = new Intent(MainActivity.this, PointsActivity.class);
                    startActivity(i);
                }
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Wait For Start IPL", Toast.LENGTH_SHORT).show();
            }
        });

    }
    @Override
    public void onBackPressed() {
        if (interstitialAd4.isLoaded()) {
            interstitialAd4.show();
        } else {
            finish();
            System.exit(0);
            System.gc();
        }
    }
    }
