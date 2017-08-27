package Cadastro;

public class medico extends Funcionario {

	private String crm;

	public medico(String cpf, String nome, String endereco, String crm) {
		super(cpf, nome, endereco);
		this.crm = crm;
	}

	@Override
	public String toString() {
		return "medico [crm=" + crm + ""+super.toString();
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((crm == null) ? 0 : crm.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		medico other = (medico) obj;
		if (crm == null) {
			if (other.crm != null)
				return false;
		} else if (!crm.equals(other.crm))
			return false;
		return true;
	}
	
	
    

}
