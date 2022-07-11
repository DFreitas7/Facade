package tsi.facade;

import java.util.HashMap;

public class SistemaReservaHotel {
    HashMap<String, Integer> hoteisDisponiveis;

    public SistemaReservaHotel() {
        hoteisDisponiveis = new HashMap<>();
        hoteisDisponiveis.put("Bourbon", 3);
        hoteisDisponiveis.put("Novotel", 1);
        hoteisDisponiveis.put("Hyatt", 2);
        hoteisDisponiveis.put("Mercure", 2);
    }
    
    void reservar(PacoteViagem pacote) throws Exception {
        if (hoteisDisponiveis.containsKey(pacote.hotel)) {
            if (hoteisDisponiveis.get(pacote.hotel) < 1)
                throw new Exception("Hotel " + pacote.hotel + " indisponível no momento");
        
            System.out.println(pacote.hotel + " reservado com sucesso!");
            hoteisDisponiveis.replace(pacote.hotel, hoteisDisponiveis.get(pacote.hotel) - 1);
            return;
        }
        
        System.out.println("Hotel " + pacote.hotel + " não encontrado");
    }
    
    void cancelarReserva(PacoteViagem pacote) {
        if (hoteisDisponiveis.containsKey(pacote.hotel)) {
            System.out.println("Reserva " + pacote.hotel + " cancelada com sucesso!");
            hoteisDisponiveis.replace(pacote.hotel, hoteisDisponiveis.get(pacote.hotel) + 1);
            return;
        }
        
        System.out.println("Hotel " + pacote.hotel + " não encontrado");
    }
        
    void listar() {
        System.out.println("Hoteis disponíveis:");
        for (String carro : hoteisDisponiveis.keySet()) {
            System.out.println(carro+ ": " + hoteisDisponiveis.get(carro));
        }
    }
}
