package logistica;

public class Produto {
	
	private int id;
	private String descricao;
	private double preco;
	private String marca;
	
	
	public Produto (int id, String descricao, double preco, String marca){
		this.id=id;
		this.descricao=descricao;
		this.preco=preco;
		this.marca=marca;
	}
	
	public Produto (int id, double preco, String marca){
		this.id=id;
		this.preco=preco;
		this.marca=marca;
	}
	
	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public double getPreco() {
		return preco;
	}
	
	public void setPreço(double preço) {
		this.preco = preço;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}

	@Override
	public String toString() {
		return "produto [id=" + id + ", descricao=" + descricao + ", preço=" + preco + ", marca=" + marca + "]";
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (id != other.id)
			return false;
		if (marca == null) {
			if (other.marca != null)
				return false;
		} else if (!marca.equals(other.marca))
			return false;
		if (Double.doubleToLongBits(preco) != Double.doubleToLongBits(other.preco))
			return false;
		return true;
	}


	

}
