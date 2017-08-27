package Comon;
/**
 * Classe que manipula um conjunto de responsaveis por monitorar a rede
 * @author Edson Vieira
 * @author Miguel Cabral
 */
import java.util.ArrayList;

public class ColecaoResponsavel {
	
	/** Atributos */
	
	/** Lista de Responsaveis */
	ArrayList <Responsavel> listaResponsavel ;
	
	
	/** Metodo Construtor */
	
	public ColecaoResponsavel(){
		listaResponsavel = new ArrayList <Responsavel>();
	}
	
	
	/** Metodo Adiciona Responsavel
	 * @param resp Responsavel
	 * @throws Exception caso ja exista um responsavel com a mesma matricula.
	 */
	public void addResponsavel (Responsavel resp) throws Exception {
		try{
			if (pesquisaPmatricula(resp.getMatricula())!=null)
				throw new Exception ("Ja existe Responsavel com esta Matricula.");
		} catch (Exception e) {
			listaResponsavel.add(resp);
		}
	}
	
	
	/** Metodo Remover Responsavel por Matricula
	 * @param id Matricula do Responsavel
	 * @param pass Senha do Responsavel 
	 * @throws Exception caso nao consiga achar um resposavel com a matricula informada.
	 */
	public void removerAdmin(String id,String pass) throws Exception {
		for (Responsavel r : listaResponsavel)
			if (r.getSenha().equals(pass) && r.getMatricula().equals(id))
				listaResponsavel.remove(r);
		throw new Exception ("Sem Responsaveis com esta Matricula");
	}
	
	
	/** Metodo Pesquisar Responsavel por Matricula
	 * @param matricula do Responsavel
	 * @return Responsavel
	 * @throws Exception  caso nao consiga achar um resposavel com a matricula informada.
	 */
	public Responsavel pesquisaPmatricula(String matricula) throws Exception {
		for (Responsavel r : listaResponsavel)
			if (r.getMatricula().equals(matricula))
				return r;

		throw new Exception ("Sem Responsaveis com esta Matricula");
	}
	
	
	/**
	 * Metodo editar() Responsavel apenas se matricula e senha forem as antigas
	 * @param matriculaOrig Matricula antes de ser editada
	 * @param pass Senha antes de ser editada
	 * @param matricula Nova matricula
	 * @param usuario Novo nome de usuario
	 * @param senha Nova senha
	 */
	public void editar(String matriculaOrig, String pass, String matricula, String usuario, String senha) {
		for (Responsavel rep : listaResponsavel)
			if ((rep.getSenha().equals(pass)) && (rep.getMatricula().equals(matriculaOrig))) {	
				rep.setMatricula(matricula);
				rep.setSenha(senha);
				rep.setUsuario(usuario);
				return;
			}
	}
	
	
	/**
	 * Metodo verificar() se existe Responsavel especificado na Colecao
	 * @param matricula do Responsavel
	 * @param pass Senha do Responsavel
	 * @return Verdadeiro se encontrar Responsavel com matricula e senha informada. Falso se nao.
	 */
	public boolean verificar(String matricula,String pass) {
		for (Responsavel r : listaResponsavel)
			if ((r.getSenha().equals(pass)) && (r.getMatricula().equals(matricula)))
				return true;
		return false;
	}
	
	
	/**
	 * Metodo listar() imprime todos os responsaveis da Colecao
	 */
	public void listar() {
		for (Responsavel rep : listaResponsavel)
			System.out.println(rep.toString());
			
	}
	
	
	/**
	 * Metodo Verificar Responsavel na Colecao
	 * @param resp Responsavel
	 * @return Verdadeiro se encontrar, Falso se nao.
	 */
	public boolean verificarResp( Responsavel resp) {
		for (Responsavel rep : listaResponsavel)
			if (rep.equals(resp))
				return true;
		return false;
	}
	
}