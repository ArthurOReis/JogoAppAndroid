package com.example.jogorandom;

import static com.example.jogorandom.Dificuldade.dificuldade;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.Random;
import java.util.Scanner;

public class Jogo extends AppCompatActivity {
    TextView tentativas;
    int total_tentativas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo2);
        tentativas = findViewById(R.id.campotentativas);
        getSupportActionBar().hide();

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
    }

    public void main() {

        Random gerador = new Random();
        int numero_secreto = gerador.nextInt(100)+1, i = 1, pontos = 1000;

        while(i <= total_tentativas){
            tentativas.setHint("Tentativa "+i+" De "+ total_tentativas);
            Scanner sc2 = new Scanner(System.in);

            System.out.println("Dê o seu chute");
            int chute = Integer.parseInt(sc2.next());

            if(chute < 1){
                System.out.println("Chute algo acima de 1 ou abaixo de 100");
                continue;
            }
            else if(chute > 100){
                System.out.println("Chute algo acima de 1 ou abaixo de 100");
                continue;
            }

            if(chute == numero_secreto){
                System.out.println("Você acertou o número!");
                System.out.println("Sua pontuação foi: "+ pontos);
                break;
            }
            if(chute < numero_secreto){
                System.out.println("O número secreto é maior");
                int pontos_perdidos = Math.abs(numero_secreto - chute);
                pontos = pontos - pontos_perdidos;
                i++;
            }
            if (chute > numero_secreto){
                System  .out.println("O número secreto é menor");
                int pontos_perdidos = Math.abs(numero_secreto - chute);
                pontos = pontos - pontos_perdidos;
                i++;
            }

        }
        System.out.println("Fim de Jogo.");
    }
}