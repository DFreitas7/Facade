package tsi.facade;

public class PacoteViagem {
    String nome;
    String carro;
    String hotel;
    String passagem;
    Float valor;

    public PacoteViagem(String nome) {
        this.nome = nome;
        this.valor = 400f;
    }
    
    public PacoteViagem(String nome, String carro, String hotel, String passagem, Float valor) {
        this.nome = nome;
        this.carro = carro;
        this.hotel = hotel;
        this.passagem = passagem;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "PacoteViagem: {\n"+
                "\t nome: " + nome+ "\n" +
                "\t carro: " + carro+ "\n" +
                "\t hotel: " + hotel+ "\n" +
                "\t passagem: " + passagem+ "\n" +
                "\t valor: " + valor+ "\n" +
                "}";
    }

}
