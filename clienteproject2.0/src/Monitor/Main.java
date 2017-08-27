package Monitor;
/**
 * Classe principal que roda no sistema monitor
 * @author Edson Vieira
 * @author Miguel Cabral
 */

import Comon.ColecaoResponsavel;
import Comon.ColecaoComputador;
import Comon.Computador;
import io.Ler;

public class Main {

	public static void main(String[] args) {

		
		ColecaoComputador pcs   = new ColecaoComputador();
		ColecaoResponsavel resp = new ColecaoResponsavel();
		Computador host;
		int opcao;
		while(true) {
			menu();
			opcao = Ler.inteiro();
			if (opcao == 1) {
				while(true){
					menuInfo();
					opcao = Ler.inteiro();
					if (opcao == 1)        { listarTudo();
					} else if (opcao == 2) { buscarInfo();
					} else if (opcao == 3) { listarIntrusos();
					} else if (opcao == 4) { gerarLogDispositivos();
					} else if (opcao == 5) { break;
					} else { System.out.println("Digite um Valor entre 1 e 5");
				    }
				}
			} else if (opcao == 2) {
				while(true){ 
					menuProcesso();
					opcao = Ler.inteiro();
					if (opcao == 1)        { capturarPortas();
					} else if (opcao == 2) { // checar necessidade
					} else if (opcao == 3) { gerarLogPortas();
					} else if (opcao == 4) { // perguntar o significado
					} else if (opcao == 5) { break;
					} else { System.out.println("Digite um Valor entre 1 e 5");
				    }
				}
			} else if (opcao == 3) {
				while(true) {
					menuCaptura();
					opcao = Ler.inteiro();
					if (opcao == 1)		   { capturaTela();
					} else if (opcao == 2) { // checar necessidade
					} else if (opcao == 3) { break;
					} else { System.out.println("Digite um Valor entre 1 e 3");
			        }
			    }
			} else if (opcao == 4) {
				while(true) {
					menuDesligar();
					opcao = Ler.inteiro();
					if (opcao == 1) 	   { desligarPC();
					} else if (opcao == 2) { desligarTodos();
					} else if (opcao == 3) { break;
					} else { System.out.println("Digite um Valor entre 1 e 3");
			        }
			    }
			} else if (opcao == 5) { break;
			} else { System.out.println("Digite um Valor entre 1 e 5");
			}
		}
		
	}

	private static void menu(){
		System.out.println(	"\n---------MONITOR DE REDE-----------\n"						 +
							"1- Buscar Informacoes de Dispositivos Conectados\n"			 + // menuInfo()
							"2- Capturar Processos de Rede ativos em Dispositivo Conectado\n"+ // menuProcesso()
							"3- Capturar tela de Dispositivos Conectados\n"					 + // menuCaptura()
							"4- Desligar Dispositivos Conectados\n"							 + // menuDesligar()
							"5- Encerrar programa");
		System.out.print("opcao: ");
	}
	
	private static void menuInfo() {
		System.out.println( "\n----------Menu Informacoes-----------\n"			+
							"1- Listar Informacoes de Dispositivos Conectados\n"+ // listarTudo()
							"2- Buscar Informacoes de um Dispositivo por IP\n"	+ // buscarInfo()
							"3- Listar IP de dispositivos intrusos\n"			+ // listarIntrusos()
							"4- Salvar log de informacoes em arquivo\n"			+ // gerarLogDispositivos()
							"5- Retornar ao menu principal");
		System.out.print("opcao: ");
	}
	
	private static void menuProcesso() {
		System.out.println(	"\n----------Menu Processos-----------\n"					  +
							"1- Capturar Processos de um Dispositivo IP\n"				  + // capturarPortas()
							"2- Capturar Processos de Todos os Dispositivos de uma rede\n"+
							"3- Salvar todos os Processos em um arquivo\n"				  + // gerarLogPortas()
							"4- Processos Salvos da ultima inicialização\n"				  + // perguntar o significado
							"5- Retornar ao menu principal");
		System.out.print("opcao: ");
	}
	
	private static void menuCaptura(){
		System.out.println(	"\n----------Menu Consultas-----------\n"				 +
							"1- Capturar tela de um único Dispositivo por ip\n"		 + // capturaTela()
							"2- Capturar tela de Todos os Dispositivos de uma Rede\n"+
							"3- Retornar ao menu Principal");						
		System.out.print("opcao: ");
	}
	
	private static void menuDesligar(){
		System.out.println(	"\n----------Menu Desligar-----------\n"		 +
							"1- Desligar Dispositivo por ip\n"				 + // desligarPC()
							"2- Desligar todos os Dispositivos de uma Rede\n"+ // desligarTodos()
							"3- Retornar ao menu Principal");
		System.out.print("opcao: ");
	}

	private static void listarTudo(){
		System.out.printf("Digite a rede que deseja analisar: ");
		String rede=Ler.string();
		Monitorar.DispConectados(rede);
	}
	
	private static void buscarInfo(){
		Computador lab = Monitorar.infoUmDisp("10.0.2.180");
		System.out.println(lab.toString());
		/* mandar flag 1 para Aluno
		 * receber o XML
		 * interpretar o objeto Aluno no XML
		 * exibir as informações
		 */
	}
	
	private static void listarIntrusos(){
		/* pegar a lista de ips alcançados se tiver (LIA)
		 * se não tiver, chama listaTudo()
		 * captura as informações de todos os Alunos
		 * gera uma lista de ips com as informações recebidas
		 * compara as informações recebidas com os ips alcançados
		 */
		System.out.printf("Digite a rede que deseja analisar: ");
		String rede=Ler.string();
	//	ArrayList<String> listaintruso=intruso(rede);
	}
	
	private static void gerarLogDispositivos(){
		/* Salvar informações dos Alunos e intrusos com cabeçalho
		 * cabeçalho: Data, Hora, Professor
		 */
	}
	
	private static void capturarPortas(){
		Monitorar.capturaProcessos("10.0.2.180", "arquivo.txt");
		/* lerIp
		 * enviar flag 3 para Aluno
		 * receber e abrir o arquivo
		 * mostrar opção de deletar, caso contrário deixa salvo: "portas.ip.data.hora"
		 */
	}
	
	private static void gerarLogPortas(){
		// verificar se é necessário
	}
	
	private static void capturaTela(){
		/* lerIp
		 * enviar flag 2 para Aluno
		 * receber e abrir a imagem
		 * deletar
		 */
		Monitorar.capturaTela("10.0.2.180", "text11.png");
	}
	
	private static void desligarPC(){
		/* lerIp
		 * enviar flag 4 para Aluno
		 */
		Monitorar.desligarPIp("10.0.2.180");
	}
	
	private static void desligarTodos(){
		/* ler lista de ips
		 * enviar flag 4 para  todos eles
		 */
	}
	
}