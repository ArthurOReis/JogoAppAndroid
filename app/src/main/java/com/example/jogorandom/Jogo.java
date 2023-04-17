package com.example.jogorandom;

import static com.example.jogorandom.Dificuldade.dificuldade;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.Scanner;

public class Jogo extends AppCompatActivity {
    TextView tentativas, pistas, contadorTentativas, numeroSecreto;
    int total_tentativas = 0, numerosecretoInt, i = 1, pontos = 1000, pontos_perdidos, chute;
    Button Botaochute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo);
        tentativas = findViewById(R.id.campotentativas);
        numeroSecreto = findViewById(R.id.numerosecreto);
        Botaochute = findViewById(R.id.chute);
        pistas = findViewById(R.id.campopistas);
        contadorTentativas = findViewById(R.id.contadortentativas);
        getSupportActionBar().hide();

        numerosecretoInt = new Random().nextInt(100) + 1;

        switch(dificuldade){
            case 1:
                total_tentativas = 20;
                break;
            case 2:
                total_tentativas = 10;
                break;
            case 3:
                total_tentativas = 5;
                break;
        }
            contadorTentativas.setText("Tentativa "+0+" de "+total_tentativas);
            pistas.setText("");
        }


    public void chute(View v){
        if(Botaochute.getText().toString().equals("Tentar de novo?")){
            super.onBackPressed();
        }
        else{
            try{
                chute = Integer.parseInt(String.valueOf(tentativas.getText()));

                if(chute < numerosecretoInt){
                    pistas.setText("O número secreto é maior");
                    pontos_perdidos = Math.abs(numerosecretoInt - chute);
                    pontos = pontos - pontos_perdidos;
                    contadorTentativas.setText("Tentativa "+ (i++) +" de "+total_tentativas);
                } else if(chute > numerosecretoInt){
                    pistas.setText("O número secreto é menor");
                    pontos_perdidos = Math.abs(numerosecretoInt - chute);
                    pontos = pontos - pontos_perdidos;
                    contadorTentativas.setText("Tentativa "+ (i++) +" de "+total_tentativas);
                }

                if(chute == numerosecretoInt) {
                    numeroSecreto.setText(numerosecretoInt+" :D");
                    pistas.setText("Você acertou! O valor era "+numerosecretoInt+"!");
                    Botaochute.setText("Tentar de novo?");
                    contadorTentativas.setText("Você conseguiu "+pontos+" pontos depois de "+i+" tentativas!");
                }

                if(i-1 > total_tentativas){
                    numeroSecreto.setText(numerosecretoInt+" :(");
                    pistas.setText("Você perdeu! O valor era "+numerosecretoInt+"!");
                    Botaochute.setText("Tentar de novo?");
                    contadorTentativas.setText("Tente novamente!");
                }


            }catch (Exception e){
                Toast.makeText(this, "Insira um valor válido!", Toast.LENGTH_SHORT).show();
            }
        }
    }
}