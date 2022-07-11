package tsi.facade;

import java.util.HashMap;

public class SistemaReservaCarro {
    HashMap<String, Integer> carrosDisponiveis;

    public SistemaReservaCarro() {
        carrosDisponiveis = new HashMap<>();
        carrosDisponiveis.put("Onix", 3);
        carrosDisponiveis.put("Jetta", 1);
        carrosDisponiveis.put("Civic", 2);
        carrosDisponiveis.put("Corolla", 2);
    }
    
    void reservar(PacoteViagem pacote) throws Exception {
        if (carrosDisponiveis.containsKey(pacote.carro)) {
            if (carrosDisponiveis.get(pacote.carro) < 1)
                throw new Exception("Carro " + pacote.carro + " indisponível no momento");
        
            System.out.println(pacote.carro + " reservado com sucesso!");
            carrosDisponiveis.replace(pacote.carro, carrosDisponiveis.get(pacote.carro) - 1);
            return;
        }
        
        System.out.println("Carro " + pacote.carro + " não encontrado");
    }
    void cancelarReserva(PacoteViagem pacote) {
        if (carrosDisponiveis.containsKey(pacote.carro)) {
            System.out.println("Reserva " + pacote.carro + " cancelada com sucesso!");
            carrosDisponiveis.replace(pacote.carro, carrosDisponiveis.get(pacote.carro) + 1);
            return;
        }
        
        System.out.println("Carro " + pacote.carro + " não encontrado");
    }
    
    void listar() {
        System.out.println("Carros disponíveis:");
        for (String carro : carrosDisponiveis.keySet()) {
            System.out.println(carro+ ": " + carrosDisponiveis.get(carro));
        }
    }
    
}
