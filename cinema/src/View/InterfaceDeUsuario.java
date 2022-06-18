package View;

import java.util.ArrayList;
import java.util.Scanner;

import Model.Filme;
import Model.Funcionario;
import Model.Sala;
import Persistencia.IPersistencia;
import Persistencia.Persistencia;

import java.util.Map;
import java.util.HashMap;

public class InterfaceDeUsuario {
	private static ArrayList<Filme> filmes = new ArrayList<Filme>();
	private static ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
	private static ArrayList<Sala> salas = new ArrayList<Sala>();
	private static Map<String, ArrayList<Funcionario>> horariosFuncionarios = new HashMap<String, ArrayList<Funcionario>>();
	private static Scanner leitor = new Scanner(System.in);  
	private static IPersistencia persistidor = new Persistencia();
	
	private static void opcoes(){
        System.out.println("\tCinema");
        System.out.println("1. Cadastrar Filme");
        System.out.println("2. Filmes em Cartaz");
        System.out.println("3. Cadastrar Funcionário");
        System.out.println("4. Mostrar Funcionários");
        System.out.println("5. Cadatra Sala");
        System.out.println("6. Mostra Salas");
        System.out.println("7. Registrar Conjunto de Funcionarios de Determinado Horario.");
        System.out.println("8. Adicionar Filme em Determinado Horario em uma Sala.");
        System.out.println("9. Consultar Sala/Horários Para Determinado Filme");
        System.out.println("0. Sair");
        System.out.print("Opcao: ");
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
    
    private static void setFuncionarios() {
    	System.out.println("Digite o Nome do Funcionário: ");
        String nome = leitor.nextLine();
        System.out.println("Digite o CPF do Funcionário (999.999.999-99): ");
        String cpf = leitor.nextLine();
        System.out.println("Digite a Data de Admissão do Funcionário (dd/mm/YYYY): ");
        String admissao = leitor.nextLine();
        System.out.println("Digite o Salário do Funcionário: ");
        float salario = leitor.nextFloat();
        
        funcionarios.add(new Funcionario(nome, cpf, admissao, salario));
    }
    
    private static void getFuncionarios(){
    	if(funcionarios.size() == 0) {
    		System.out.println("Nenhum Filme Cadastrado!\n"); 
    	} else {
    		funcionarios.forEach((n) -> {
    			System.out.println("\tFuncionário " + (funcionarios.indexOf(n) + 1)); 
        		n.getFuncionario();
        		System.out.println(); 
        	});
    	}
    }
    
    private static void setSalas() {
    	System.out.println("Digite o Nome da Sala: ");
    	String nome = leitor.nextLine();
    	System.out.println("Digite a Capacidade da Sala: ");
    	int capacidade = leitor.nextInt();

    	salas.add(new Sala(nome, capacidade));
    }
    
    private static void getSalas() {
    	if(salas.size() == 0) {
    		System.out.println("Nenhuma Sala Cadastrada!\n"); 
    	} else {
    		salas.forEach((n) -> {
    			System.out.println("\tSala " + (salas.indexOf(n) + 1)); 
        		n.getSala();
        		System.out.println(); 
        	});
    	}
    }
    
    private static void setHorarios() {
    	System.out.println("Selecione os Funcionarios (Minimo 4 para realizar registro): \n"); 
    	ArrayList<Funcionario> funcionariosSelecionados = new ArrayList<Funcionario>();
    	 
    	while(true) {
    		System.out.print("Nome: "); 
    		String nome = leitor.nextLine();
    		
    		boolean achouFuncionario = false;
    		
    		for(Funcionario funcionario : funcionarios) {
    			if(funcionario.comparaFuncionario(nome)) {
    				funcionariosSelecionados.add(funcionario);
    				achouFuncionario = true;
    				break;
    			}
    		}
    		
    		System.out.println(); 
    		if(!achouFuncionario) {
    			System.out.println("Funcionario não encontrado."); 
    			System.out.println(); 
    		}
    		
    		
    		int opcao;
    		
    		do {
    			System.out.println("Deseja Adicionar outro funcionario?\n1. Sim\n2. Não"); 
    			System.out.print("Opção: "); 
        		opcao = leitor.nextInt();
        		
        		if(opcao != 1 && opcao != 2) {
        			System.out.println("Opção Invalida."); 
        		}
    		} while (opcao != 1 && opcao != 2);
    		
    		if(opcao == 2) {
    			break;
    		}
    		
    		System.out.println(); 
    		leitor.nextLine();
    	}
    	
    	if(funcionariosSelecionados.size() < 4) {
    		System.out.println();
    		System.out.println("Funcionarios Insuficientes (Menos do que 4 selecionados). Cancelando operação!");
    	} else {
    		System.out.println();
    		String horario = "";
    		
    		leitor.nextLine();
    		
    		while(true) {
    			System.out.println("Selecione um dos Horários: \n1. 16h\n2. 18h\n3. 20h\n4. 22h\n5. 24h"); 
    			System.out.print("Opção: "); 
    			String opcao = leitor.nextLine();
    			
    			if(opcao.equalsIgnoreCase("sair")) {
    				break;
    			}
    			
    			switch (opcao) {
    			case "1":
    				horario = "16h";
    				break;
    				
    			case "2":
    				horario = "18h";
    				break;
    				
    			case "3":
    				horario = "20h";
    				break;
    				
    			case "4":
    				horario = "22h";
    				break;
    				
    			case "5":
    				horario = "24h";
    				break;
    				
    			default:
    				break;
    			}
    			
    			if(horario.equals("")) {
    				System.out.println("Horário Invalido. Tente novamente ou digite \"Sair\" para cancelar a operação."); 
    			} else {
    				break;
    			}
    		}
    		
    		if(!horario.equals("")) {
    			horariosFuncionarios.put(horario, funcionariosSelecionados);
    		}
    	}
    	
    }
    
    private static void addFilmeNaSala(){
        Filme filmeSelecionado = null;
        String horarioSelecionado = "";
        Sala salaSelecionada = null;
        
        while(true) {
        	System.out.print("Digite o nome da Sala: ");
        	String nomeSala = leitor.nextLine();
        	
        	boolean achouSala = false;
        	
        	if(nomeSala.equalsIgnoreCase("sair")) {
				break;
			}
        	
        	for(Sala sala : salas) {
        		if(sala.comparaSala(nomeSala)) {
        			salaSelecionada = sala;
        			achouSala = true;
    				break;
    			}
        	}
        	
        	System.out.println(); 
        	
        	if(!achouSala) {
        		System.out.println("Sala não encontrado. Tente novamente ou digite \"Sair\" para cancelar a operação."); 
        		System.out.println(); 
        	} else {
        		break;
        	}
        }
        
        if(salaSelecionada == null) {
        	System.out.println(); 
        	System.out.println("Cancelando operação!"); 
        } else {
        	while(true) {
        		System.out.print("Digite o nome Original do Filme: ");
        		String nomeFilme = leitor.nextLine();
        		
        		boolean achouFilme = false;
        		
        		if(nomeFilme.equalsIgnoreCase("sair")) {
        			break;
        		}
        		
        		for(Filme filme : filmes) {
        			if(filme.comparaFilme(nomeFilme)) {
        				filmeSelecionado = filme;
        				achouFilme = true;
        				break;
        			}
        		}
        		
        		System.out.println(); 
        		
        		if(!achouFilme) {
        			System.out.println("Filme não encontrado. Tente novamente ou digite \"Sair\" para cancelar a operação."); 
        			System.out.println(); 
        		} else {
        			break;
        		}
        	}
        	
        	if(filmeSelecionado == null) {
        		System.out.println(); 
        		System.out.println("Cancelando operação!"); 
        	} else {
        		ArrayList<String> horarios = new ArrayList<>(horariosFuncionarios.keySet());
        		
        		if(horarios.size() > 0) {
        			while(true) {
        				System.out.println("Selecione um horario (Caso o horario desejado não esteja presente, define o conjunto de funcionarios para o mesmo): ");
        				
        				for(String horario : horarios){
        					System.out.println(horarios.indexOf(horario) + ". " + horario);
        				}
        				
        				System.out.print("Opção: ");
        				String opcao = leitor.nextLine();
        				
        				if(horarios.get(Integer.parseInt(opcao)) != null) {
        					horarioSelecionado = horarios.get(Integer.parseInt(opcao));
        					break;
        				} else {
        					System.out.println("Horário Invalido. Tente novamente ou digite \\\"Sair\\\" para cancelar a operação.");
        					System.out.println();
        				}
        			}
        			
        			if(horarioSelecionado != "") {
        				salaSelecionada.setFilmesHorarios(horarioSelecionado, filmeSelecionado);
        			}
        			
        		} else {
        			System.out.print("Não há nenhum horário cadastrado. Para cadastra-los, defina o conjunto de funcionarios para o mesmo. Cancelando Operação");
        		}
        	}
        }
    }
    
    private static void getFilmeHorarioSala() {
    	System.out.println("Digite o Nome Original do filme: ");
        String filme = leitor.nextLine();
        
        System.out.println();
        System.out.println("Todas as Salas - Horarios para o filme: " + filme);
        for(Sala sala : salas) {
        	sala.getFilmeHorarios(filme);
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
                
            case 3:
            	leitor.nextLine();
            	setFuncionarios();
            	System.out.println();
                break;
                
            case 4:
            	leitor.nextLine();
            	getFuncionarios();
                break;
                
            case 5:
            	leitor.nextLine();
            	setSalas();
            	System.out.println();
                break;
                
            case 6:
            	leitor.nextLine();
            	getSalas();
                break;
                
            case 7:
            	leitor.nextLine();
            	setHorarios();
            	System.out.println();
                break;
                
            case 8:
            	leitor.nextLine();
            	addFilmeNaSala();
            	System.out.println();
                break;
                
            case 9:
            	leitor.nextLine();
            	getFilmeHorarioSala();
            	System.out.println();
                break;
            
            default:
                System.out.println("Opção inválida.");
            }
        } while(opcao != 0);

        leitor.close();
        persistidor.salvaDados(filmes, funcionarios, salas, horariosFuncionarios);
        
    }
}
