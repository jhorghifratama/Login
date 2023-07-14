package com.jhorghifratama201103643.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.tabs.TabLayout;

public class MenuActivity extends AppCompatActivity
{
    private Button _tampilMahasiswaButton, _tampilForexButton, _tampilCuacaButton, _tampilImplicitIntentButton, _tampilTabLayoutButton, _tampilHotelAppButton, _tampilWebViewLanjutanButton;
    private Intent _tampilMahasiswaIntent, _tampilForexIntent, _tampilCuacaIntent, _tampilImplicitIntent, _tampilTabLayoutIntent, _tampilHotelAppIntent, _tampilWebViewLanjutanIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        initTampilMahasiswaButton();
        initTampilForexButton();
        initTampilCuacaButton();
        initTampilImplicitIntentButton();
        initTampilTabLayoutButton();
        initTampilHotelAppButton();
        initTampilWebViewLanjutanBUtton();


        Bundle bundle = getIntent().getExtras();
        String activityTitle = bundle.getString("username");

        this.setTitle("Menu " + activityTitle);
    }

    private void  initTampilMahasiswaButton()
    {
        _tampilMahasiswaButton = (Button) findViewById(R.id.tampilMahasiswaButton);
        _tampilMahasiswaButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                _tampilMahasiswaIntent = new Intent(getApplicationContext(), TampilMahasiswaActivity.class);
                startActivity(_tampilMahasiswaIntent);
            }
        });
    }

    private void initTampilForexButton()
    {
        _tampilForexButton = (Button) findViewById(R.id.tampilForexButton);
        _tampilForexButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                _tampilForexIntent = new Intent(getApplicationContext(), ForexMainActivity.class);
                startActivity(_tampilForexIntent);
            }
        });
    }


    private void initTampilCuacaButton()
    {
        _tampilCuacaButton = findViewById(R.id.tampilCuacaButton);

        _tampilCuacaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _tampilCuacaIntent = new Intent(getApplicationContext(), CuacaMainActivity.class);
                startActivity(_tampilCuacaIntent);
            }
        });
    }

    private void initTampilImplicitIntentButton()
    {
        _tampilImplicitIntentButton = findViewById(R.id.tampilImplicitButton);

        _tampilImplicitIntentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _tampilImplicitIntent = new Intent(getApplicationContext(), ImplicitIntentMainActivity.class);
                startActivity(_tampilImplicitIntent);
            }
        });
    }

    private void initTampilTabLayoutButton()
    {
        _tampilTabLayoutButton = findViewById(R.id.tampilTabLayout);

        _tampilTabLayoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _tampilTabLayoutIntent  = new Intent(getApplicationContext(), TabLayoutMainActivity.class);
                startActivity(_tampilTabLayoutIntent);
            }
        });
    }

    private void initTampilHotelAppButton()
    {
        _tampilHotelAppButton = findViewById(R.id.tampilHotelApp);

        _tampilHotelAppButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _tampilHotelAppIntent  = new Intent(getApplicationContext(), HotelAppMainActivity.class);
                startActivity(_tampilHotelAppIntent);
            }
        });
    }

    private void initTampilWebViewLanjutanBUtton()
    {
        _tampilWebViewLanjutanButton = findViewById(R.id.tampilWebViewLanjutan);

        _tampilWebViewLanjutanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _tampilWebViewLanjutanIntent  = new Intent(getApplicationContext(), WebViewLanjutanMainActivity.class);
                startActivity(_tampilWebViewLanjutanIntent);
            }
        });
    }
}