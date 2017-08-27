package Comon;
/**
 * Classe que manipula um conjunto de responsáveis por monitorar a rede
 * @author Edson Vieira
 * @author Miguel Cabral
 */
import java.util.ArrayList;

public class ColecaoResponsavel {
	
	/** Atributos */
	
	/** Lista de Responsáveis */
	ArrayList <Responsavel> listaResponsavel ;
	
	
	/** Metodo Construtor */
	
	public ColecaoResponsavel(){
		listaResponsavel = new ArrayList <Responsavel>();
	}
	
	
	/** Metodo Adiciona Responsável
	 * @param resp
	 * @throws Exception caso já exista um responsável com a mesma matrícula.
	 */
	public void addResponsavel (Responsavel resp) throws Exception {
		try{
			if (pesquisaPmatricula(resp.getMatricula())!=null)
				throw new Exception ("Já existe Responsável com esta Matrícula.");
		} catch (Exception e) {
			listaResponsavel.add(resp);
		}
	}
	
	
	/** Metodo Remover Responsável por Matrícula
	 * @param matricula
	 * @throws Exception caso não consiga achar um resposável com a matrícula informada.
	 */
	public void removerAdmin(String id,String pass) throws Exception {
		for (Responsavel r : listaResponsavel)
			if (r.getSenha().equals(pass) && r.getMatricula().equals(id))
				listaResponsavel.remove(r);
		throw new Exception ("Sem Responsaveis com esta Matricula");
	}
	
	
	
	/** Metodo Pesquisar Responsável por Matrícula
	 * @param matricula
	 * @return Responsavel
	 * @throws Exception  caso não consiga achar um resposável com a matrícula informada.
	 */
	public Responsavel pesquisaPmatricula(String matricula) throws Exception {
		for (Responsavel r : listaResponsavel)
			if (r.getMatricula().equals(matricula))
				return r;

		throw new Exception ("Sem Responsaveis com esta Matricula");
	}
	
	public void editar(String matriculaOrig, String pass, String matricula, String usuario, String senha) {
		for (Responsavel rep : listaResponsavel) {
			if ((rep.getSenha().equals(pass)) && (rep.getMatricula().equals(matriculaOrig))) {	
				rep.setMatricula(matricula);
				rep.setSenha(senha);
				rep.setUsuario(usuario);
			}
		}
	}
	
	public boolean verificar(String matricula,String pass)  {
		for (Responsavel r : listaResponsavel)
			if ((r.getSenha().equals(pass)) && (r.getMatricula().equals(matricula)))
				return true;
		return false;
	}
	
	
	public void listar() {
		for (Responsavel rep : listaResponsavel) {
			System.out.println(rep.toString());
			}
		}
	
	public boolean verificarResp( Responsavel resp) {
		for (Responsavel rep : listaResponsavel) {
			if (rep.equals(resp)){
				return true;
			}
		}
	return false;
	}
	
}