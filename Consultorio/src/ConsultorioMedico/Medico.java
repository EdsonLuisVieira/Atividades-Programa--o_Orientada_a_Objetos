package ConsultorioMedico;

public class Medico {

	private String nome;
	private int crm;
	private String especialidade;
	
	public Medico(String nome, int crm, String especialidade){
		this.nome=nome;
		this.crm=crm;
		this.especialidade=especialidade;
	}
	
	public Medico(String nome, int crm){
		this.nome=nome;
		this.crm=crm;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCrm() {
		return crm;
	}

	public void setCrm(int crm) {
		this.crm = crm;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Medico other = (Medico) obj;
		if (crm != other.crm)
			return false;
		if (especialidade == null) {
			if (other.especialidade != null)
				return false;
		} else if (!especialidade.equals(other.especialidade))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	public String toString() {
		return "--Medico--\nNome: " + nome + "\nCrm: " + crm + "\nEspecialidade: " + especialidade;
	}
	
	
}
