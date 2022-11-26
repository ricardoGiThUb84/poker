package br.letscode.poker;

public class Jogador {

    private Carta[] cartas;
    private double valorAposta = 0;

    private Boolean abandonarJogo = false;

    public void setValorAposta(double valorAposta) {
        this.valorAposta += valorAposta;
    }

    public double getValorAposta() {
        return valorAposta;
    }

    public void setCartas(Carta[] cartas) {
        this.cartas = cartas;
    }

    public void  getCartas(int i) {

        System.out.println("Jogador " + i);
        for (Carta carta: cartas
             ) {
            System.out.println(carta);
        }

    }

    public void setAbandonarJogo() {

      this.abandonarJogo = true;

    }

    public Boolean getAbandonarJogo() {
        return abandonarJogo;
    }
}
