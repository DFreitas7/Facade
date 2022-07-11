package tsi.facade;

import java.util.HashMap;
import java.util.Scanner;

public class SistemaVendaPacoteViagens {
    private SistemaReservaPassagem reservaPassagem;
    private SistemaReservaHotel reservaHotel;
    private SistemaReservaCarro reservaCarro;
    private SistemaPagamento pagamento;
    private HashMap<String, PacoteViagem> pacotesDisponiveis;

    public SistemaVendaPacoteViagens() {
        reservaPassagem = new SistemaReservaPassagem();
        reservaHotel = new SistemaReservaHotel();
        reservaCarro = new SistemaReservaCarro();
        pagamento = new SistemaPagamento();
        
        pacotesDisponiveis = new HashMap<>();
        
        pacotesDisponiveis.put("SP-Bourbon-S", new PacoteViagem("SP-Bourbon-S", "Jetta", "Bourbon", "Gol", 380f));
        pacotesDisponiveis.put("SP-Bourbon-A", new PacoteViagem("SP-Bourbon-A", "Onix", "Bourbon", "FlyTAP", 250.80f));
        pacotesDisponiveis.put("SP-Haytt", new PacoteViagem("SP-Hyatt", "Corolla", "Hyatt", "Gol", 360f));
        pacotesDisponiveis.put("SP-Novotel", new PacoteViagem("SP-Novotel", "Civic", "Novotel", "Aero", 300f));
        pacotesDisponiveis.put("SP-Mercure", new PacoteViagem("SP-Mercure", "Civic", "Mercure", "Aero", 310f));
    }
    
    public void venderPacoteCustomizado() {
        PacoteViagem pacoteCustomizado = new PacoteViagem("Customizado");
        
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("");
            try {
                System.out.println("Digite a passagem desejada:");
                reservaPassagem.listar();
                pacoteCustomizado.passagem = scanner.nextLine();
                System.out.println("Digite o hotel desejado:");
                reservaHotel.listar();
                pacoteCustomizado.hotel = scanner.nextLine();
                System.out.println("Digite o carro desejado:");
                reservaCarro.listar();
                pacoteCustomizado.carro = scanner.nextLine();
            } catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }
        
        venderPacote(pacoteCustomizado);
    }
    
    public void venderPacote(String nomePacote) {
        venderPacote(pacotesDisponiveis.get(nomePacote));
    }
    
    public void venderPacote(PacoteViagem pacote) {
        boolean passagemOK = false;
        boolean hotelOK = false;
        boolean carroOK = false;
        try {
            reservaPassagem.reservar(pacote);
            passagemOK = true;
            reservaHotel.reservar(pacote);
            hotelOK = true;
            reservaCarro.reservar(pacote);
            carroOK = true;
            pagamento.realizarPagamento(pacote);
        } catch(Exception e) {
            System.out.println("Erro ao vender o pacote " + pacote.nome + ": " + e.getMessage());
            if (carroOK) reservaCarro.cancelarReserva(pacote);
            if (hotelOK) reservaHotel.cancelarReserva(pacote);
            if (passagemOK) reservaPassagem.cancelarReserva(pacote);
        }
    }
    
    void listar() {
        for (String pacote : pacotesDisponiveis.keySet()) {
            System.out.println(pacote+ ": " + pacotesDisponiveis.get(pacote));
        }
    }
}
