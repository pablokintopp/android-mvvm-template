package com.kintopp.pablo.androidmvvmtemplate.ui.base;

import com.kintopp.pablo.androidmvvmtemplate.utils.AppConstants;

import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity  extends AppCompatActivity implements AppConstants {

    protected String getTag(){
        return getClass().getSimpleName();
    }

}
