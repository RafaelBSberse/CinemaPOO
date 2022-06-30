package Model;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import Exceptions.ExcecaoDeNomeJaExistenteFilme;
import Exceptions.ExcecaoDeNomeJaExistenteFuncionario;
import Exceptions.ExcecaoDeNomeJaExistenteSala;
import Persistencia.IPersistencia;
import Persistencia.Persistencia;

public class Dados implements IDados {
	private IPersistencia persistidor = new Persistencia();
	
	//Fiz dessa forma pois achei mais pratico, mas reconheço que caso não exista os documentos necessarios ira gerar um erro
	private ArrayList<Filme> filmes = persistidor.recuperaFilmes();
	private ArrayList<Funcionario> funcionarios = persistidor.recuperaFuncionarios();
	private ArrayList<Sala> salas = persistidor.recuperaSalas(filmes);
	private Map<String, ArrayList<Funcionario>> horariosFuncionarios = persistidor.recuperaHorarioFuncionarios(funcionarios);
	private Scanner leitor = new Scanner(System.in);  
	
	public void setFilmes() throws ExcecaoDeNomeJaExistenteFilme{
        System.out.println("Digite o Nome do Filme em PT-BR: ");
        String tituloPT = leitor.nextLine();
        System.out.println("Digite o Nome Original do Filme: ");
        String tituloOriginal = leitor.nextLine();
        System.out.println("Digite o Nome do Diretor: ");
        String diretor = leitor.nextLine();
        System.out.println("Digite o Ano de Lanï¿½amento do Filme: ");
        int ano = leitor.nextInt();
        
        for(Filme f: filmes) {
        	if(f.comparaFilme(tituloOriginal)) {
        		throw new ExcecaoDeNomeJaExistenteFilme();
        	}
        }
        
        filmes.add(new Filme(tituloPT, tituloOriginal, diretor, ano));
        leitor.nextLine();
    }
    
    public void getFilmes(){
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
    
    public void setFuncionarios() throws ExcecaoDeNomeJaExistenteFuncionario {
    	System.out.println("Digite o Nome do Funcionï¿½rio: ");
        String nome = leitor.nextLine();
        System.out.println("Digite o CPF do Funcionï¿½rio (999.999.999-99): ");
        String cpf = leitor.nextLine();
        System.out.println("Digite a Data de Admissï¿½o do Funcionï¿½rio (dd/mm/YYYY): ");
        String admissao = leitor.nextLine();
        System.out.println("Digite o Salï¿½rio do Funcionï¿½rio: ");
        float salario = leitor.nextFloat();
        
        for(Funcionario f: funcionarios) {
        	if(f.comparaFuncionario(nome)) {
        		throw new ExcecaoDeNomeJaExistenteFuncionario();
        	}
        }
        
        funcionarios.add(new Funcionario(nome, cpf, admissao, salario));
        leitor.nextLine();
    }
    
    public void getFuncionarios(){
    	if(funcionarios.size() == 0) {
    		System.out.println("Nenhum Filme Cadastrado!\n"); 
    	} else {
    		funcionarios.forEach((n) -> {
    			System.out.println("\tFuncionï¿½rio " + (funcionarios.indexOf(n) + 1)); 
        		n.getFuncionario();
        		System.out.println(); 
        	});
    	}
    }
    
    public void setSalas() throws ExcecaoDeNomeJaExistenteSala {
    	System.out.println("Digite o Nome da Sala: ");
    	String nome = leitor.nextLine();
    	System.out.println("Digite a Capacidade da Sala: ");
    	int capacidade = leitor.nextInt();
    	
    	for(Sala f: salas) {
        	if(f.comparaSala(nome)) {
        		throw new ExcecaoDeNomeJaExistenteSala();
        	}
        }

    	salas.add(new Sala(nome, capacidade));
    	leitor.nextLine();
    }
    
    public void getSalas() {
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
    
    public void setHorarios() {
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
    			System.out.println("Funcionario nï¿½o encontrado."); 
    			System.out.println(); 
    		}
    		
    		
    		int opcao;
    		
    		do {
    			System.out.println("Deseja Adicionar outro funcionario?\n1. Sim\n2. Nï¿½o"); 
    			System.out.print("Opï¿½ï¿½o: "); 
        		opcao = leitor.nextInt();
        		
        		if(opcao != 1 && opcao != 2) {
        			System.out.println("Opï¿½ï¿½o Invalida."); 
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
    		System.out.println("Funcionarios Insuficientes (Menos do que 4 selecionados). Cancelando operaï¿½ï¿½o!");
    	} else {
    		System.out.println();
    		String horario = "";
    		
    		leitor.nextLine();
    		
    		while(true) {
    			System.out.println("Selecione um dos Horï¿½rios: \n1. 16h\n2. 18h\n3. 20h\n4. 22h\n5. 24h"); 
    			System.out.print("Opï¿½ï¿½o: "); 
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
    				System.out.println("Horï¿½rio Invalido. Tente novamente ou digite \"Sair\" para cancelar a operaï¿½ï¿½o."); 
    			} else {
    				break;
    			}
    		}
    		
    		if(!horario.equals("")) {
    			horariosFuncionarios.put(horario, funcionariosSelecionados);
    		}
    	}
    	leitor.nextLine();
    }
    
    public void addFilmeNaSala(){
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
        		System.out.println("Sala nï¿½o encontrado. Tente novamente ou digite \"Sair\" para cancelar a operaï¿½ï¿½o."); 
        		System.out.println(); 
        	} else {
        		break;
        	}
        }
        
        if(salaSelecionada == null) {
        	System.out.println(); 
        	System.out.println("Cancelando operaï¿½ï¿½o!"); 
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
        			System.out.println("Filme nï¿½o encontrado. Tente novamente ou digite \"Sair\" para cancelar a operaï¿½ï¿½o."); 
        			System.out.println(); 
        		} else {
        			break;
        		}
        	}
        	
        	if(filmeSelecionado == null) {
        		System.out.println(); 
        		System.out.println("Cancelando operaï¿½ï¿½o!"); 
        	} else {
        		ArrayList<String> horarios = new ArrayList<>(horariosFuncionarios.keySet());
        		
        		if(horarios.size() > 0) {
        			while(true) {
        				System.out.println("Selecione um horario (Caso o horario desejado nï¿½o esteja presente, define o conjunto de funcionarios para o mesmo): ");
        				
        				for(String horario : horarios){
        					System.out.println(horarios.indexOf(horario) + ". " + horario);
        				}
        				
        				System.out.print("Opï¿½ï¿½o: ");
        				String opcao = leitor.nextLine();
        				
        				if(horarios.get(Integer.parseInt(opcao)) != null) {
        					horarioSelecionado = horarios.get(Integer.parseInt(opcao));
        					break;
        				} else {
        					System.out.println("Horï¿½rio Invalido. Tente novamente ou digite \\\"Sair\\\" para cancelar a operaï¿½ï¿½o.");
        					System.out.println();
        				}
        			}
        			
        			if(horarioSelecionado != "") {
        				salaSelecionada.setFilmesHorarios(horarioSelecionado, filmeSelecionado);
        			}
        			
        		} else {
        			System.out.print("Nï¿½o hï¿½ nenhum horï¿½rio cadastrado. Para cadastra-los, defina o conjunto de funcionarios para o mesmo. Cancelando Operaï¿½ï¿½o");
        		}
        	}
        }
        leitor.nextLine();
    }
    
    public void getFilmeHorarioSala() {
    	System.out.println("Digite o Nome Original do filme: ");
        String filme = leitor.nextLine();
        
        System.out.println();
        System.out.println("Todas as Salas - Horarios para o filme: " + filme);
        for(Sala sala : salas) {
        	sala.getFilmeHorarios(filme);
        }
    }
    
    public void salvarDados() {
    	persistidor.salvaDados(filmes, funcionarios, salas, horariosFuncionarios);
    }
}
