package com.example.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;

import com.example.myapplication.databinding.ActivityRegistreBinding;
import com.example.myapplication.models.Result;
import com.example.myapplication.utils.PreferencesProvider;
import com.example.myapplication.utils.UIUtils;
import com.example.myapplication.viewModel.SingInViewModel;

public class SingInActivity extends AppCompatActivity {

    private final String TAG = "SingInActivity";
    private SingInViewModel singInViewModel;
    private ActivityRegistreBinding activitySinginBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registre);
        singInViewModel = new SingInViewModel();
        initDataBinding();

    }

    public void initDataBinding() {
        activitySinginBinding =  DataBindingUtil.setContentView(this,R.layout.activity_registre);

        activitySinginBinding.setSingInViewModel(singInViewModel);
        activitySinginBinding.setLifecycleOwner(this);
    }



}
