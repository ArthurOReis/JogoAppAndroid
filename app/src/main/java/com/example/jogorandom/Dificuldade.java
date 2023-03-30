package com.example.jogorandom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.Random;
import java.util.Scanner;

public class Dificuldade extends AppCompatActivity {
    static int dificuldade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo);
        getSupportActionBar().hide();
    }

    public void facil (View v){
        dificuldade = 1;
        Intent i = new Intent(this, Jogo.class);
        startActivity(i);
    }

    public void medio (View v){
        dificuldade = 2;
        Intent i = new Intent(this, Jogo.class);
        startActivity(i);
    }

    public void dificil (View v){
        dificuldade = 3;
        Intent i = new Intent(this, Jogo.class);
        startActivity(i);
    }

}