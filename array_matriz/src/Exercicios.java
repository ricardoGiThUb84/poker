import java.util.Scanner;

public class Exercicios {

    public static void lista1(){

        int[] lista1 = new int[10];

        for (int i = 0; i < lista1.length; i++){
            lista1[i] = 10 - i;
        }

        for (int item: lista1
             ) {
            System.out.print(item + " ");
        }

        System.out.println();


    }

    public static void lista2(){

        double[] lista2 = new double[11];


        for (int i = 0; i < lista2.length; i++){

            lista2[i] = Math.pow(i,2.0);

        }

        for (double item: lista2
        ) {
            System.out.print((int)item + " ");
        }

        System.out.println();
    }

    public static void lista3(){

        int[] lista3 = new int[10];


        for (int i = 1; i <= lista3.length; i++) {

            if(i > 5) lista3[i - 1] = (i - (lista3.length / 2)) * 10;
            else lista3[i - 1] = i;

        }

        for (int item: lista3
        ) {
            System.out.print(item + " ");
        }

        System.out.println();
    }

    public static void lista4(){

        int[] lista4 = new int[10];

        int total = 0;
        int totalPar = 0;
        int impar = -1;
        int par = -4;
        int contimpar = 1;
        int contpar = 1;


        for (int i = 1; i <= lista4.length; i++) {

            if(i % 2 != 0) {
                total = impar + (4 * contimpar);
                lista4[i - 1] = total;
                impar = total;
                if(i == 1) continue;
                contimpar+=2;
            } else {
                totalPar = par + (8 * contpar);
                lista4[i - 1] = totalPar;
                par = totalPar;
                if(i == 2) continue;
                contpar++;
            }

        }

        for (int i = 0; i < lista4.length; i++) {

            System.out.print(lista4[i] + " ");

        }

        System.out.println();

    }

    public static void lista5(){

        double[] a = {3.4, 4.5, 6.7};

        for (double valor: a
             ) {

            System.out.print(valor + " ");
        }

        System.out.println();

    }

    public static void lista6(){

        Scanner scan = new Scanner(System.in);
        int quantidadeelementos = 10;

        double[] d = new double[quantidadeelementos];

        System.out.println("Insira 10 números do tipo double");

        for (int i = 0; i < quantidadeelementos; i++){

            d[i] = scan.nextDouble();

        }

        scan.close();

        for (double valor: d
        ) {

            System.out.print(valor + " ");
        }

        System.out.println();
    }

    public static int lista7(int[] numeros){

        int quantidadeNegativos = 0;

        for (int negativos: numeros
             ) {

            if(negativos < 0) quantidadeNegativos++;

        }

        return quantidadeNegativos;
    }

    public static int lista8(int[] numeros, int elemento){

        int quantidadeelementos = 0;

        for (int numero: numeros
        ) {

            if(numero == elemento) quantidadeelementos++;

        }

        return quantidadeelementos;
    }

    public static void lista9(int[] numeros){

        String[] listaBool = new String[numeros.length];

        for (int i = 0; i < listaBool.length; i++){

                if(numeros[i] < 0 || numeros[i] == 0){

                    listaBool[i] = "false";
                    continue;
                }

                listaBool[i] = "true";

        }

        for (String item: listaBool
             ) {

            System.out.print(item + " ");
        }

        System.out.println();
    }

    public static void lista10(int[] numeros){

        int maior = numeros[0];

        for (int i = 0; i < numeros.length; i++){

                if(numeros[i] > maior) maior = numeros[i];
        }

        for (int i = 0; i < numeros.length; i++){

            if(numeros[i] == maior){
                System.out.println("A posição do maior é: " + i);
                break;
            }
        }


    }

    public static void lista11(){

        Scanner scan = new Scanner(System.in);

        System.out.println("Digite o tamanho da lista");
        int quantidadeelementos = scan.nextInt();

        int[] d = new int[quantidadeelementos];

        System.out.println("Insira "+  quantidadeelementos +  " números");

        for (int i = 0; i < quantidadeelementos; i++){

            d[i] = scan.nextInt();

        }

        scan.close();

        for (int valor: d
        ) {

            System.out.print(valor + " ");
        }

        System.out.println();
    }


    public static void lista12(int[] numeros){

        String[] lista = new String[numeros.length];

        for (int i = 0; i < lista.length; i++){

            if(numeros[i] % 2 == 0) lista[i] = "+1";
            else lista[i] = "-1";

        }


        for (String item: lista
        ) {

            System.out.print(item + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {

        lista1();
        lista2();
        lista3();
        lista4();
        lista5();
//        lista6();
        System.out.println("----------------------------");

        int[] inteiros = {4,6,-2,-7,8,12,-11,2,0,39, 1,9,2};

        System.out.println("Quantidade negativos: " + lista7(inteiros));


        System.out.println("Quantidade elementos repetidos: " + lista8(inteiros, 2));

        lista9(inteiros);

        lista10(inteiros);

        lista11();

        int[] positivos = {4,6,7,8,12,11,2,0,39, 1,9,2};

        lista12(positivos);
    }
}
