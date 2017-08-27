package logistica;

import java.util.*;


public class Estoque {
	
	private ArrayList <Produto> lista;
	
	public Estoque (){
		 lista = new ArrayList <Produto> ();
	}
	
	public Produto pesquisaPid (int id){
		for (Produto var : lista ){
			if (var.getId()==id){
				return var;
			}
		}
		return null;
	}
	
	public int quantidade(){
		return lista.size();
	}
	
	public int qtdMarcas (String marca){
		int cont =0;
		for (Produto var :lista){
			if (var.getMarca().equals(marca)){
				cont++;
			}
		}
	return cont;
	}
	
	public int contPCaros (double preco){
		int cont=0;
		for (Produto var : lista){
			if (var.getPreco() > preco){
				cont++;
			}
		}
		return cont;
	}
		
	public void removePId(int id){
		Produto var =pesquisaPid(id);		
		lista.remove(var);
	}
	
	public void addProduto (Produto p){
		lista.add(p);
	}
}
