package cinema;

import java.util.ArrayList;
import java.util.Scanner;

public class InterfaceDeUsuario {
	private static ArrayList<Filme> filmes = new ArrayList<Filme>();
	private static Scanner leitor = new Scanner(System.in);
	
	private static void opcoes(){
        System.out.println("\tCinema");
        System.out.println("1. Cadastrar Filme");
        System.out.println("2. Filmes em Cartaz");
        System.out.println("0. Sair");
        System.out.println("Opcao:");
    }

    private static void setFilmes(){
        System.out.println("Digite o Nome do Filme em PT-BR: ");
        String tituloPT = leitor.nextLine();
        System.out.println("Digite o Nome Original do Filme: ");
        String tituloOriginal = leitor.nextLine();
        System.out.println("Digite o Nome do Diretor: ");
        String diretor = leitor.nextLine();
        System.out.println("Digite o Ano de Lançamento do Filme: ");
        int ano = leitor.nextInt();
        
        filmes.add(new Filme(tituloPT, tituloOriginal, diretor, ano));        	
    }
    
    private static void getFilmes(){
    	if(filmes.size() == 0) {
    		System.out.println("Nenhum Filme Cadastrado!\n"); 
    	} else {
    		filmes.forEach((n) -> {
    			System.out.println("\tFilme " + (filmes.indexOf(n) + 1)); 
        		n.getFilme();
        		System.out.println(); 
        	});
    	}
    }
    
    private static void sair(){
        System.out.println("Saindo do Sistema");
    }
    
    public static void menu() {
        int opcao;
        
        do{
            opcoes();
            opcao = leitor.nextInt();
            System.out.println(); 
            
            switch(opcao){
            case 0:
            	leitor.nextLine();
            	sair();
                break;
            
            case 1:
            	leitor.nextLine();
            	setFilmes();
            	System.out.println();
                break;
                
            case 2:
            	leitor.nextLine();
            	getFilmes();
                break;
            
            default:
                System.out.println("Opção inválida.");
            }
        } while(opcao != 0);

        leitor.close();
    }
}
