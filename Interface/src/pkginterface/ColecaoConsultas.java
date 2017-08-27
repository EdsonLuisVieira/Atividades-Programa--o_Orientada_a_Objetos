package pkginterface;

import java.util.ArrayList;
import java.time.*;

public class ColecaoConsultas {
	
	ArrayList <Consulta> listaConsulta ; 
	
	public ColecaoConsultas(){
		listaConsulta = new ArrayList <Consulta>();
	}
	
	public void adicionaConsulta(Consulta con){
		listaConsulta.add(con);
	}
	public int qtdConsultaData(LocalDate data){
		int i=0;
		for (Consulta end : listaConsulta){
			if (end.getDate().equals(data)){
				i++;
			}
		}
		return i;
	}
	
	public String listagemConsultas() throws Exception{
		for (Consulta end : listaConsulta){
			return end.toString();
		}
		throw new Exception ("sem consultas cadastradas");
	}


	
	public int qtdConsultasPMedico( Medico medic){
		int i=0;
		for (Consulta end : listaConsulta){
			if (end.getMedico().equals(medic)){
				i++;
			}
		}
		return i;
	}
	
	public String listaConsultasPPaciente(Paciente pacient)throws Exception{
		for (Consulta end : listaConsulta){
				if (end.getPaciente().equals(pacient))
			return end.toString();
		}
		throw new Exception("sem consultas cadastradas");
	}
	

}
