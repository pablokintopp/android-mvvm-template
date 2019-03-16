package com.kintopp.pablo.androidmvvmtemplate.ui.base;

import android.app.Activity;
import android.content.Context;

import com.kintopp.pablo.androidmvvmtemplate.utils.AppConstants;

import androidx.fragment.app.Fragment;

public class BaseFragment extends Fragment implements AppConstants {

    protected Activity activity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.activity = (Activity) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
