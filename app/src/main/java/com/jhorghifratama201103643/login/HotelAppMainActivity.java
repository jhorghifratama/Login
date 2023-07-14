package com.jhorghifratama201103643.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class HotelAppMainActivity extends AppCompatActivity
{
    private ImageView _imageview1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_app_main);

        _imageview1 = (ImageView) findViewById(R.id.imageview1);

        String imageURL = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS7HboST5SvzXtnSrReY9HiYyBnNXaqMifVFw&usqp=CAU";
        Picasso.with(this).load(imageURL).into(_imageview1);
    }
}