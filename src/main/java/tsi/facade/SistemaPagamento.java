package tsi.facade;

public class SistemaPagamento {
    void realizarPagamento(PacoteViagem pacote) {
        System.out.println("Realizando pagamento de " + pacote.valor + " da viagem: "+ pacote.nome);
    }
}
