package com.example.myapplication.viewModel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.myapplication.models.Player;
import com.example.myapplication.models.Result;
import com.example.myapplication.repositories.AccountRepo;
import com.example.myapplication.repositories.PlayerRepo;
import com.example.myapplication.utils.AccountUtils;

public class SingInViewModel {
    private String TAG = "SingInViewModel";

    public MutableLiveData<String> name;
    public MutableLiveData<String> password;
    public MutableLiveData<String> correu;
    private PlayerRepo playerRepo;
    public MutableLiveData<Boolean> iscreated;

    public SingInViewModel(){
        this.name = new MutableLiveData<>();
        this.password = new MutableLiveData<>();
        this.correu = new MutableLiveData<>();
        playerRepo = new PlayerRepo(this);
        this.iscreated = new MutableLiveData<Boolean>();
    }


    public void singin(){

        String nom = name.getValue();
        String password = this.password.getValue();
        String email = correu.getValue();

        Log.d("nom", nom);
        Log.d("pwd", password);
        Log.d("email", email);


        if (isFormValid(email)){
            Player newPlyer = new Player(nom,email,password,0,0,0);
            playerRepo.addPlayer(newPlyer);
        }

    }


    private Boolean isFormValid(String email){
        boolean isValid = true;

        String validEmail= AccountUtils.isEmailValid(email);
        if ( validEmail != null){
            isValid = false;
        };

        return isValid;
    }
}
