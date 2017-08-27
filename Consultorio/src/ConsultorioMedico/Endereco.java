package ConsultorioMedico;

public class Endereco {

	private String cep;
	private String rua;
	private String bairro;
	private String complemento;
	
	public Endereco(String cep, String rua, String bairro, String complemento){
		this.cep=cep;
		this.rua=rua;
		this.bairro=bairro;
		this.complemento=complemento;
	}
	public Endereco(String cep, String rua, String bairro){
		this.cep=cep;
		this.rua=rua;
		this.bairro=bairro;
	}
	
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		if (bairro == null) {
			if (other.bairro != null)
				return false;
		} else if (!bairro.equals(other.bairro))
			return false;
		if (cep == null) {
			if (other.cep != null)
				return false;
		} else if (!cep.equals(other.cep))
			return false;
		if (complemento == null) {
			if (other.complemento != null)
				return false;
		} else if (!complemento.equals(other.complemento))
			return false;
		if (rua == null) {
			if (other.rua != null)
				return false;
		} else if (!rua.equals(other.rua))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "--Endereco--\nRua: " + rua + "\nCep: " + cep + "\nBairro: " + bairro + "\nComplemento: " + complemento ;
	}
	
	
	
}
