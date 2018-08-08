package in.blogspot.techhindi5.ipl;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class PointsActivity extends AppCompatActivity {
    SwipeRefreshLayout swipeRefreshLayout;
    WebView webview;
    AdView mAdView;
    public InterstitialAd interstitialAd,interstitialAd2,interstitialAd3,interstitialAd4,interstitialAd5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_points);
        MobileAds.initialize(this, "ca-app-pub-7565184612395429/9593526401");
        swipeRefreshLayout = (SwipeRefreshLayout)findViewById(R.id.swipe);
        webview=(WebView)findViewById(R.id.webview);
        webview.loadUrl("http://m.cricbuzz.com/cricket-series/2676/indian-premier-league-2018/points-table");
        webview.setWebViewClient(new myWebClient1());
        webview.isSaveEnabled();
        webview.getSettings().setJavaScriptEnabled(true);
        webview.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        webview.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        webview.getSettings().setAppCacheEnabled(true);
        webview.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webview.getSettings().setDomStorageEnabled(true);
        webview.getSettings().setLoadsImagesAutomatically(true);
        webview.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadweb();
            }
        });

    }
        public class myWebClient1 extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            //hide the swipe refresh layout
            swipeRefreshLayout.setRefreshing(false);
        }

    }

    //pull to refresh webview
    public void loadweb() {

        // load the web page
        String weburl = "http://m.cricbuzz.com/cricket-series/2676/indian-premier-league-2018/points-table";
        webview.loadUrl(weburl);
        webview.isSaveEnabled();
        webview.getSettings().setJavaScriptEnabled(true);
        webview.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        webview.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        webview.getSettings().setAppCacheEnabled(true);
        webview.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webview.getSettings().setDomStorageEnabled(true);
        webview.getSettings().setLoadsImagesAutomatically(true);
        webview.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        //swipe refresh

        swipeRefreshLayout.setRefreshing(true);
        webview.setWebViewClient(new myWebClient1());



    }
}
