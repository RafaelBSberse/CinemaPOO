package View;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import Exceptions.ExcecaoDeNomeJaExistenteFilme;
import Exceptions.ExcecaoDeNomeJaExistenteFuncionario;
import Exceptions.ExcecaoDeNomeJaExistenteSala;
import Model.Dados;
import Model.Filme;
import Model.Funcionario;
import Model.IDados;
import Model.Sala;
import Persistencia.IPersistencia;
import Persistencia.Persistencia;

import java.util.Map;
import java.util.HashMap;

public class InterfaceDeUsuario {
	private IDados dados = new Dados();
	private IPersistencia persistidor = new Persistencia();
	private Scanner leitor = new Scanner(System.in);  
	
	private void opcoes(){
        System.out.println("\tCinema");
        System.out.println("1. Cadastrar Filme");
        System.out.println("2. Filmes em Cartaz");
        System.out.println("3. Cadastrar Funcion�rio");
        System.out.println("4. Mostrar Funcion�rios");
        System.out.println("5. Cadatra Sala");
        System.out.println("6. Mostra Salas");
        System.out.println("7. Registrar Conjunto de Funcionarios de Determinado Horario.");
        System.out.println("8. Adicionar Filme em Determinado Horario em uma Sala.");
        System.out.println("9. Consultar Sala/Hor�rios Para Determinado Filme");
        System.out.println("10. Ordenar");
        System.out.println("0. Sair");
        System.out.print("Opcao: ");
    }

    private void sair(){
        System.out.println("Saindo do Sistema");
    }
    
    public void menu() {
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
            	try {
					dados.setFilmes();
				} catch (ExcecaoDeNomeJaExistenteFilme e2) {
					e2.printStackTrace();
				}
            	System.out.println();
                break;
                
            case 2:
            	leitor.nextLine();
            	dados.getFilmes();
                break;
                
            case 3:
            	leitor.nextLine();
            	try {
					dados.setFuncionarios();
				} catch (ExcecaoDeNomeJaExistenteFuncionario e1) {
					e1.printStackTrace();
				}
            	System.out.println();
                break;
                
            case 4:
            	leitor.nextLine();
            	dados.getFuncionarios();
                break;
                
            case 5:
            	leitor.nextLine();
            	try {
					dados.setSalas();
				} catch (ExcecaoDeNomeJaExistenteSala e) {
					e.printStackTrace();
				}
            	System.out.println();
                break;
                
            case 6:
            	leitor.nextLine();
            	dados.getSalas();
                break;
                
            case 7:
            	leitor.nextLine();
            	dados.setHorarios();
            	System.out.println();
                break;
                
            case 8:
            	leitor.nextLine();
            	dados.addFilmeNaSala();
            	System.out.println();
                break;
                
            case 9:
            	leitor.nextLine();
            	dados.getFilmeHorarioSala();
            	System.out.println();
                break;
                
            case 10:
            	leitor.nextLine();
            	System.out.println("\tEscolha uma das opcoes para ordenar: ");
            	System.out.println("1. Funcionarios por salario (Decrescente)");
            	System.out.println("2. Filmes por data de lancamento (Crescente)");
            	System.out.println("3. Salas por capacidade (Decrescente)");
            	int opcaoOrdenacao = leitor.nextInt();
            	dados.ordenar(opcaoOrdenacao);
            	System.out.println();
                break;
            
            default:
                System.out.println("Op��o inv�lida.");
            }
        } while(opcao != 0);

        leitor.close();
        dados.salvarDados();
    }
}
