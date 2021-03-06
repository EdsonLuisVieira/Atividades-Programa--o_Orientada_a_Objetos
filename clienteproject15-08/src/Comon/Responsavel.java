package Comon;

/**
 * Classe que define informações do responsável por monitorar a rede
 * @author Edson Vieira
 * @author Miguel Cabral
 */
 
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("Responsavel")

public class Responsavel {
	
	/** Atributos */
	
	/** Identificação do Responsável */
	private String usuario;
	/** Senha do Responsável */
	private String senha;
	/** Matricula do Responsável */
	private String matricula;
	
	
	/** Métodos Construtores */
	/**
	 * @param usuario
	 * @param senha
	 * @param matricula
	 */
	public Responsavel(String usuario, String senha, String matricula) {
		this.usuario   = usuario;
		this.senha     = senha;
		this.matricula = matricula;
	}
	/**
	 * @param usuario
	 * @param senha
	 */
	public Responsavel(String usuario, String senha) {
		this.usuario   = usuario;
		this.senha     = senha;
		this.matricula = "0";
	}

	
	/** Métodos Getters */
	/** getUsuario @return usuario */
	public String getUsuario() {
		return usuario;
	}
	/** getSenha @return senha */
	public String getSenha() {
		return senha;
	}
	/** getMatricula @return matricula */
	public String getMatricula() {
		return matricula;
	}

	
	/** Métodos Setters */
	/** setUsuario @param usuario */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	/** setSenha @param senha */
	public void setSenha(String senha) {
		this.senha = senha;
	}
	/** setMatricula @param matricula */
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	
	/** Método HashCode */
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		return result;
	}

	
	/** Método Equals */

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Responsavel other = (Responsavel) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

	
	/** Método ToString
	 *  @return Os atributos do responsável numa formatação de string.
	 */

	@Override
	public String toString() {
		return "Usuario:" + usuario + "\n matricula:" + matricula ;
	}
}

