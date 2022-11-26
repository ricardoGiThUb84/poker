package br.letscode.poker;

import java.util.Random;

public class Baralho {

    Carta[] cartas = new Carta[52];

    String[] nipes = {"OURO", "COPAS","PAUS", "ESPADA"};
    String[] nome = {"2","3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K","A"};

    public Baralho() {

        int contadorBaralho = 0;
        for (int i = 0; i < nipes.length; i++){

            for(int j = 0; j < nome.length; j++){

                cartas[contadorBaralho] = new Carta(nipes[i], nome[j]);
                contadorBaralho++;
            }


        }
    }

    public int jogadoresRodada(Jogador[] jogador){

        int contador = 0;

        for (int i = 0; i < jogador.length; i++){

            if(!jogador[i].getAbandonarJogo()) contador++;
        }

        return contador;

    }

    public Boolean temCartaParaRodada(Jogador[] jogadores){

        int quantidadeCartasRodada = (jogadoresRodada(jogadores) * 2) + 5;

        int totalCartas = cartas.length - 1;

        for(int i = totalCartas; i > totalCartas - quantidadeCartasRodada; i-- ){

            if(cartas[i] == null) return false;
        }

        return true;
    }

    public Carta[] darCartas() {

        Carta[] duasCartas = new Carta[2];
        int contador = 0;
        int contadorCartas = 0;


        while(contadorCartas < 2){

            if(cartas[contador] == null){

                contador++;
                continue;
            }

            duasCartas[contadorCartas] = cartas[contador];
            cartas[contador] = null;
            contador++;
            contadorCartas++;

        }

        return duasCartas;
    }

    public Carta[] imprimirCartasMesa(){

        Carta[] cincoCartas = new Carta[5];
        int contador = 0;
        int contadorCartas = 0;


        while(contadorCartas < 5){

            if(cartas[contador] == null){

                contador++;
                continue;
            }

            cincoCartas[contadorCartas] = cartas[contador];
            cartas[contador] = null;
            contador++;
            contadorCartas++;

        }

        return cincoCartas;



    }

    public void imprimeBaralho(){

        for (Carta carta: cartas) {

            System.out.println(carta);

        }

    }

    public void embaralha(){


        for (int i = 0; i < (cartas.length / 2); i++){

            Random aleatorio = new Random();
            int valor1 = (aleatorio.nextInt(52) + 1) - 1;
            int valor2 = (aleatorio.nextInt(52) + 1) - 1;

            if(valor1 != valor2){

                Carta temp = cartas[valor1];

                cartas[valor1] = cartas[valor2];
                cartas[valor2] = temp;

            }


        }
    }
}
