package com.fomin.demo;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.fomin.autofind.impl.AutoLayoutImpl;
import com.fomin.autofind.inject.AutoLayout;

@AutoLayout( R.layout.activity_second)
public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AutoLayoutImpl.inject(this);
    }
}
