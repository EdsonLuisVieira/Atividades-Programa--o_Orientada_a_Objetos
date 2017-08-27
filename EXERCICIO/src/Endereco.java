
public class Endereco {

	String rua;
	String bairro;
	int numero;
	String cep;
	String comple;
	String gps_localizacao;
	
	public Endereco(String rua, String bairro, int numero, String cep,String comple,String gps){
		this.rua=rua;
		this.bairro=bairro;
		this.numero=numero;
		this.cep=cep;
		this.comple=comple;
		this.gps_localizacao=gps;
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

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		cep = cep;
	}

	public String getComple() {
		return comple;
	}

	public void setComple(String comple) {
		this.comple = comple;
	}

	public String getGps_localizacao() {
		return gps_localizacao;
	}

	public void setGps_localizacao(String gps_localizacao) {
		this.gps_localizacao = gps_localizacao;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		if (cep == null) {
			if (other.cep != null)
				return false;
		} else if (!cep.equals(other.cep))
			return false;
		if (bairro == null) {
			if (other.bairro != null)
				return false;
		} else if (!bairro.equals(other.bairro))
			return false;
		if (comple == null) {
			if (other.comple != null)
				return false;
		} else if (!comple.equals(other.comple))
			return false;
		if (gps_localizacao == null) {
			if (other.gps_localizacao != null)
				return false;
		} else if (!gps_localizacao.equals(other.gps_localizacao))
			return false;
		if (numero != other.numero)
			return false;
		if (rua == null) {
			if (other.rua != null)
				return false;
		} else if (!rua.equals(other.rua))
			return false;
		return true;
	}

	public String toString() {
		return "Endereco [rua=" + rua + ", bairro=" + bairro + ", numero=" + numero + ", Cep=" + cep + ", comple="
				+ comple + ", gps_localizacao=" + gps_localizacao + "]";
	}

}
