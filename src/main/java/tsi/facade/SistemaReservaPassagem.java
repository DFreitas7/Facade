package tsi.facade;

import java.util.HashMap;

public class SistemaReservaPassagem {
    HashMap<String, Integer> passagensDisponiveis;

    public SistemaReservaPassagem() {
        passagensDisponiveis = new HashMap<>();
        passagensDisponiveis.put("Gol", 3);
        passagensDisponiveis.put("Aero", 1);
        passagensDisponiveis.put("FlyTAP", 2);
    }
    
    void reservar(PacoteViagem pacote) throws Exception {
        if (passagensDisponiveis.containsKey(pacote.passagem)) {
            if (passagensDisponiveis.get(pacote.passagem) < 1)
                throw new Exception("Passagem " + pacote.passagem + " indisponível no momento");
        
            System.out.println(pacote.passagem + " reservada com sucesso!");
            passagensDisponiveis.replace(pacote.passagem, passagensDisponiveis.get(pacote.passagem) - 1);
            return;
        }
        
        System.out.println("Passagem " + pacote.passagem + " não encontrada");
    }
    
    void cancelarReserva(PacoteViagem pacote) {
        if (passagensDisponiveis.containsKey(pacote.passagem)) {
            System.out.println("Reserva " + pacote.passagem + " cancelada com sucesso!");
            passagensDisponiveis.replace(pacote.passagem, passagensDisponiveis.get(pacote.passagem) + 1);
            return;
        }
        
        System.out.println("Passagem " + pacote.passagem + " não encontrada");
    }
    
    void listar() {
        System.out.println("Hoteis disponíveis:");
        for (String carro : passagensDisponiveis.keySet()) {
            System.out.println(carro+ ": " + passagensDisponiveis.get(carro));
        }
    }
}
