package pkginterface;

import java.util.ArrayList;

public class ColecaoPaciente {
			
	ArrayList <Paciente> lista_paciente ; 
	
	public ColecaoPaciente(){
		lista_paciente = new ArrayList <Paciente>();
	}
	
	
	public void adicionaPaciente(Paciente pacient){
		lista_paciente.add(pacient);
	}
	
	
	public String pesquisaPeloDocumento(String doc) throws Exception{
		for (Paciente end : lista_paciente){
			if (end.getDocumento().equals(doc))
		return end.toString();
		}
	throw new Exception("sem Pacientes cadastrados com esse documento");
	}
	
	
	public void removePeloDocumento(String doc)throws Exception{
		for (Paciente end : lista_paciente){
			if (end.getDocumento().equals(doc))
				lista_paciente.remove(end);
		}
	throw new Exception("sem Pacientes cadastrados com esse documento");
	}
	
	
	public int qtdPacientesPorSexo(String sexo){
		int i=0;
		for (Paciente end : lista_paciente){
			if (end.getSexo().equals(sexo)){
				i++;
			}
		}
		return i;
	}
	
	
	public String listagemPacientesComEndereco(Endereco endereco)throws Exception{
		for (Paciente end : lista_paciente){
			if (end.getEndereco().equals(endereco))
				return end.toString();
		}
	throw new Exception("sem pacientes com esse endereco");
	}
	
	
	
	public String listagemDePacienteM60Anos()throws Exception{
		int i;
		for (Paciente end : lista_paciente){
			i=end.Idade();
			if (i>60)
				return end.toString();
		}
	throw new Exception("sem pacientes com mais de 60 anos");
	}


}
