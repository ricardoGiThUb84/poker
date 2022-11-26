package br.letscode.poker;

import java.util.Scanner;

public class Mesa {

    public static void main(String[] args) {

        Baralho baralho = new Baralho();


        Scanner scan = new Scanner(System.in);

        mensagem("Digite a quantidade de jogadores: ");

        int quantidadeJogadores = scan.nextInt();
        scan.nextLine();

        Jogador[] jogadores = new Jogador[quantidadeJogadores];

        double[] listaApostas = new double[quantidadeJogadores];


        inicializaJogadores(jogadores , baralho);

        double maiorAposta = 0;
        double valor = 0.0;


       mesa:while(!checaApostas(jogadores)) {

            destribuirCartas(jogadores, baralho);

            for (int i = 0; i < jogadores.length; i++) {

                if(jogadores[i].getAbandonarJogo()) continue;

                mostrarCartas(jogadores, baralho);

                mensagem("Jogador " + i + " deseja apostar ou abandonar a mão? ");

                String continuaJogo = scan.nextLine();

                if (!continuaJogo.equalsIgnoreCase("apostar")) {

                    jogadores[i].setAbandonarJogo();

                    if(checaSeUnicoJogador(jogadores)) {

                        System.out.println("O jogador " + posicaoUltimoJogador(jogadores) + " é o vencedor");
                        System.out.println("O valor da mesa é: " + totalApostas(jogadores));

                        jogadores[i].getCartas(i);

                        mostrarCartasMesa(baralho);

                        break mesa;
                    }
                    destribuirCartas(jogadores, baralho);
                    System.out.println("-------------nova rodada-----------------");
                    continue;

                    }

                mensagem("Quanto quer apostar?");

                valor = scan.nextDouble();
                scan.nextLine();

                if(valor >= maiorAposta) {
                    jogadores[i].setValorAposta(valor);
                    maiorAposta = valor;
                };

                if(maiorAposta == 0) maiorAposta = valor;


                while(valor < maiorAposta) {
                    mensagem("Sua aposta deve ser superior ou igual a: " + maiorAposta);
                    mensagem("Quanto quer apostar?");

                    valor = scan.nextInt();
                    scan.nextLine();
                    jogadores[i].setValorAposta(valor);

                    if(valor > maiorAposta) maiorAposta = valor;
                }
            }

        }

        try{

            if(checaSeUnicoJogador(jogadores)) {
                System.out.println("O jogador " + posicaoUltimoJogador(jogadores) + " é o vencedor");
                System.out.println("O valor da mesa é: " + totalApostas(jogadores));

                jogadores[posicaoUltimoJogador(jogadores)].getCartas(posicaoUltimoJogador(jogadores));

            }else{

                mensagem("Escolha uma posição para definir o ganhador");

                int posicaoGanhador = scan.nextInt();


                escolherGanhador(posicaoGanhador, jogadores);

                mostrarCartas(jogadores, baralho);

                mostrarCartasMesa(baralho);


                System.out.println("O jogador " + posicaoGanhador + " é o vencedor");
                System.out.println("total aposta: " + totalApostas(jogadores));


            }

        }catch (Exception e){

            System.out.println(e);



        }finally {

            scan.close();
        }




    }


//repita esse processo até todos apostarem a mesma quantia

   public static void mensagem(String mensagem){

       System.out.println(mensagem);
   }


   public static boolean checaSeUnicoJogador(Jogador[] jogadores){

        int contador = jogadores.length;

       for (int i = 0; i < jogadores.length; i++ ){

           if(jogadores[i].getAbandonarJogo()) contador--;
       }

        return contador == 1;
   }

    public static int posicaoUltimoJogador(Jogador[] jogadores){



        for (int i = 0; i < jogadores.length; i++ ){

            if(!jogadores[i].getAbandonarJogo()) return i;
        }

       return -1;
    }

    public static void escolherGanhador(int posicao, Jogador[] jogadores){

        if(posicao > jogadores.length - 1) throw new RuntimeException("A posição é maior do que as já existentes");

        for (int i = 0; i < jogadores.length; i++ ){

           if(i != posicao) jogadores[i].setAbandonarJogo();
        }


    }

    public static void inicializaJogadores(Jogador[] jogadores , Baralho baralho){

        for (int i = 0; i < jogadores.length; i++ ){

            jogadores[i] = new Jogador();

        }
    }

    public static void destribuirCartas(Jogador[] jogadores , Baralho baralho){

        if(!baralho.temCartaParaRodada(jogadores)) throw new RuntimeException("Cartas insuficientes");
        baralho.embaralha();
        for (int i = 0; i < jogadores.length; i++ ){

            if(jogadores[i].getAbandonarJogo()) continue;
            jogadores[i].setCartas( baralho.darCartas());
//            jogadores[i].getCartas(i);
        }
    }

    public static void mostrarCartas(Jogador[] jogadores , Baralho baralho){

        for (int i = 0; i < jogadores.length; i++ ){

            if(jogadores[i].getAbandonarJogo()) continue;
            jogadores[i].getCartas(i);
        }
    }

    public static double totalApostas(Jogador[] jogadores){

        double total = 0;

        for (int i = 0; i < jogadores.length; i++ ){

          total += jogadores[i].getValorAposta();
        }

        return total;
    }

    public static void mostrarCartasMesa(Baralho baralho){

        System.out.println("----------");
        for (int i = 0; i < 5; i++ )System.out.println(baralho.imprimirCartasMesa()[i]);
        System.out.println("----------");
    }

    public static double pegaMaiorValor(Jogador[] lista){

        double maior = 0;

        for(int i = 0; i < lista.length; i++)
            if(lista[i].getValorAposta() > maior) maior = lista[i].getValorAposta();


        return maior;
    }

    public static boolean checaApostas(Jogador[] lista){

        double temp = pegaMaiorValor(lista);
        boolean valores = false;

        for(int i = 0; i < lista.length; i++){

            if(lista[i].getAbandonarJogo()) continue;

            if(lista[i].getValorAposta() < temp){
                valores = false;
                break;
            }

            valores = true;
        }

        if(temp == 0 ) return false;

        return valores;
    }

}
