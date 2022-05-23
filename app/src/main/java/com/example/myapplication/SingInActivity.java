package com.example.myapplication;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;

import com.example.myapplication.databinding.ActivityRegistreBinding;
import com.example.myapplication.models.Result;
import com.example.myapplication.utils.PreferencesProvider;
import com.example.myapplication.utils.UIUtils;
import com.example.myapplication.viewModel.SingInViewModel;
import com.google.android.material.snackbar.Snackbar;

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


        ActionBar actionBar =  getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        singInViewModel.iscreated.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {

                Context context = getApplicationContext();
                int duration = Toast.LENGTH_SHORT;


                if(singInViewModel.iscreated.getValue() == true){
                    CharSequence text = "BENVINGUT! :)";
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();

                    goTo();

                } else{
                    CharSequence text = "Aquest username ja existeix :(";
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }

            }
        });
    }

    public void initDataBinding() {
        activitySinginBinding =  DataBindingUtil.setContentView(this,R.layout.activity_registre);

        activitySinginBinding.setSingInViewModel(singInViewModel);
        activitySinginBinding.setLifecycleOwner(this);
    }

    public void goTo(){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }



}
