package tsi.facade;

import java.util.Scanner;

public class Facade {
    public static void main(String[] args) {
        SistemaVendaPacoteViagens sistema = new SistemaVendaPacoteViagens();
        System.out.println("Bem-vindo ao Sistema de Pacotes de Viagem");
        
        Scanner scanner = new Scanner(System.in);
        String comando;
        do {
            System.out.println("Selecione uma viagem para comprar ou crie a sua digitando 1:");
            sistema.listar();
            comando = scanner.nextLine();
            
            if (comando.equals("1")) {
                sistema.venderPacoteCustomizado();
            } else {
                sistema.venderPacote(comando);
            }
            
        } while(!comando.equals("sair"));
    }
}
