package com.jhorghifratama201103643.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import java.text.DecimalFormat;

public class ForexMainActivity extends AppCompatActivity {
    private ProgressBar loadingProgressBar;
    private SwipeRefreshLayout swipeRefreshLayout1;
    private TextView audTextView, bndTextView, btcTextView, eurTextView, gbpTextView, hkdTextView, inrTextView, jpyTextView, myrTextView, usdTextView, idrTextView;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forex_main);

        swipeRefreshLayout1 = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout1);
        audTextView = (TextView)findViewById(R.id.audTextView);
        bndTextView = (TextView)findViewById(R.id.bndTextView);
        btcTextView = (TextView)findViewById(R.id.btcTextView);
        eurTextView = (TextView)findViewById(R.id.eurTextView);
        gbpTextView = (TextView)findViewById(R.id.gbpTextView);
        hkdTextView = (TextView)findViewById(R.id.hkdTextView);
        inrTextView = (TextView)findViewById(R.id.inrTextView);
        jpyTextView = (TextView)findViewById(R.id.jpyTextView);
        myrTextView = (TextView)findViewById(R.id.myrTextView);
        usdTextView = (TextView)findViewById(R.id.usdTextView);
        idrTextView = (TextView)findViewById(R.id.idrTextView);
        loadingProgressBar = (ProgressBar) findViewById(R.id.loadingProgressBar);

        initSwipeRefreshLayout();
        initForex();
    }

    private void initSwipeRefreshLayout() {
        swipeRefreshLayout1.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                initForex();

                swipeRefreshLayout1.setRefreshing(false);
            }
        });
    }
    public String formatNumber(Double number,String format){
        DecimalFormat decimalFormat = new DecimalFormat(format);
        return decimalFormat.format(number);
    }
    private void initForex() {
        loadingProgressBar.setVisibility(TextView.VISIBLE);

        String url = "https://openexchangerates.org/api/latest.json?app_id=835235e2406141d685addeb8f5b9ad35";

        AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
        asyncHttpClient.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, byte[] responseBody) {
                Gson gson = new Gson();
                ForexRootModel rootModel = gson.fromJson(new String(responseBody),ForexRootModel.class);
                ForexRatesModel ratesModel = rootModel.getRatesModel();

                double aud = ratesModel.getIDR() / ratesModel.getAUD();
                double jpy = ratesModel.getIDR() / ratesModel.getJPY();
                double eur = ratesModel.getIDR() / ratesModel.getEUR();
                double bnd = ratesModel.getIDR() / ratesModel.getBND();
                double gbp = ratesModel.getIDR() / ratesModel.getGBP();
                double btc = ratesModel.getIDR() / ratesModel.getBTC();
                double hkd = ratesModel.getIDR() / ratesModel.getHKD();
                double inr = ratesModel.getIDR() / ratesModel.getINR();
                double usd = ratesModel.getIDR() / ratesModel.getUSD();
                double myr = ratesModel.getIDR() / ratesModel.getMYR();

                double idr = ratesModel.getIDR();

                audTextView.setText(formatNumber(aud,"###,##0.##"));
                jpyTextView.setText(formatNumber(jpy,"###,##0.##"));
                eurTextView.setText(formatNumber(eur,"###,##0.##"));
                bndTextView.setText(formatNumber(bnd,"###,##0.##"));
                gbpTextView.setText(formatNumber(gbp,"###,##0.##"));
                btcTextView.setText(formatNumber(btc,"###,##0.##"));
                hkdTextView.setText(formatNumber(hkd,"###,##0.##"));
                inrTextView.setText(formatNumber(inr,"###,##0.##"));
                usdTextView.setText(formatNumber(usd,"###,##0.##"));
                myrTextView.setText(formatNumber(myr,"###,##0.##"));
                idrTextView.setText(formatNumber(idr,"###,##0.##"));


                loadingProgressBar.setVisibility(TextView.INVISIBLE);

            }

            @Override
            public void onFailure(int statusCode, cz.msebera.android.httpclient.Header[] headers, byte[] responseBody, Throwable error) {
                Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_LONG).show();
                loadingProgressBar.setVisibility(TextView.INVISIBLE);
            }
        });
    }
}