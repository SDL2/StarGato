package com.example.sdl.stargato;

import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.Arrays;


public class MainActivity extends AppCompatActivity {
    int[] casillas = {0, 0, 0, 0, 0, 0, 0, 0, 0};//en cero casillas no usadas
    int [] [] combinacionesGanadoras = {{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7,}, {2,5,8}, {0,4,8}, {6,4,2}};
    static int playerStar = 1; // player 1 =1   player 2 = 2
    boolean juegoTerminado = false;
    int contadorEmpate = 0;


    public void marcarCasilla(View n){

        if(juegoTerminado == false) {

            TextView winnerMessage = findViewById(R.id.tvWinner);

            ImageView marca = (ImageView) n;
            int usado = Integer.parseInt(marca.getTag().toString());

            if (casillas[usado] == 0) {

                casillas[usado] = playerStar;//marcando la casilla seleccionada en el array
                AnimationsR.entrada(marca, playerStar);//animacion, set estrella , cambio valor de jugador en la otra clase

                contadorEmpate++;

                                    //VALIDANDO GANADOR****

//en cada iteracion se asigna una de las combinaciones ganadoras a la variable combinacionG para que
// el if revise si los numeros del array casilla que corresponden a la actual combinacionG
// tienen un mismo numero o jugador y que este no sea el numero inicial de casilla no utilizada "0"
   // cuando estos coinciden y no son el cero, este jugador logro una combinacion ganadora y se cambia el
   //valor del boolean de "juego terminado" a TRUE lo que no deja continuar el juego,,,

                for (int[] combinacionG : combinacionesGanadoras){ //*** quiza esto despues de la animacion? se borra antes de fin de animacion, o boton "OK"

                    if(casillas[combinacionG[0]] == casillas[combinacionG[1]] &&
                            casillas[combinacionG[1]] == casillas[combinacionG[2]] &&
                            casillas[combinacionG[0]] != 0){

                        System.out.println("GANADOR JUGADOR #: " + casillas[combinacionG[0]]);
                        /*Toast.makeText(getApplicationContext(), "YOU WIN PLAYER " +
                                casillas[combinacionG[0]] + "!!!", Toast.LENGTH_LONG).show(); *//////////
                        juegoTerminado = true;


                        ImageView marcaWinner = findViewById(R.id.winnerImage);
                        if(playerStar == 1) {
                            winnerMessage.setText(R.string.winner2);

                            AnimationsR.entrada(marcaWinner, playerStar);
                        } else {
                            winnerMessage.setText(R.string.winner1);
                            playerStar = 2;
                            AnimationsR.entrada(marcaWinner, playerStar);
                        }

                        LinearLayout messajeLayout = findViewById(R.id.lPlayAgain);
                        messajeLayout.setVisibility(View.VISIBLE);

                        AnimationsR.entrada(marcaWinner, playerStar);

                    }

                }// fin revision de array


                //VALIDANDO EMPATE*****
                if(contadorEmpate == casillas.length){
                    //////Toast.makeText(getApplicationContext(), "DRAW! \nPLAY AGAIN!!", Toast.LENGTH_LONG).show();
                    juegoTerminado = true;

                        winnerMessage.setText(R.string.draw);

                    ImageView marcaWinner = findViewById(R.id.winnerImage);
                    marcaWinner.setImageResource(R.drawable.cats_moon);
                    LinearLayout messajeLayout = findViewById(R.id.lPlayAgain);
                    messajeLayout.setVisibility(View.VISIBLE);




                }// fin else validador de empate


            }// enf if filtro de casilla, solo marcar casillas NO usadas

        }// if de juego terminado fin

    }// marcarCasilla end





    //pasar variable View "marca" al metodo y hacer alguna animacion antes del reset de las cosas
    public void resetGame(View n){

        for(int i = 0; i < casillas.length; i++){
            casillas[i] = 0;

        }//fin for

//reiniciando imagen de las casillas
        LinearLayout linea1 = findViewById(R.id.L1);
        LinearLayout linea2 = findViewById(R.id.L2);
        LinearLayout linea3 = findViewById(R.id.L3);
        for(int i = 0; i < linea1.getChildCount(); i++){
            ((ImageView) linea1.getChildAt(i)).setImageResource(R.drawable.transparent);
        }
        for(int i = 0; i < linea2.getChildCount(); i++){
            ((ImageView) linea2.getChildAt(i)).setImageResource(R.drawable.transparent);
        }
        for(int i = 0; i < linea3.getChildCount(); i++){
            ((ImageView) linea3.getChildAt(i)).setImageResource(R.drawable.transparent);
        }

        playerStar = 1;
        juegoTerminado = false;
        contadorEmpate = 0;
        LinearLayout messajeLayout = findViewById(R.id.lPlayAgain);
        messajeLayout.setVisibility(View.INVISIBLE);

    }//reset game end


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }// onCreate end
}// Main end
