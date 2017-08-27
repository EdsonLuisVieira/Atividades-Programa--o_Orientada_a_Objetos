package ConsultorioMedico;

import java.time.*;

public class Consulta {

	private Paciente paciente;
	private Medico medico;
	private LocalDate data_consulta;
	private LocalTime hora;

	public Consulta(Paciente paciente, Medico medico,LocalDate date, LocalTime hora){
		this.paciente=paciente;
		this.medico=medico;
		this.data_consulta=date;
		this.hora=hora;
				
	}
	public Consulta(Paciente paciente, Medico medico){
		this.paciente=paciente;
		this.medico=medico;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public Medico getMedico() {
		return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	public LocalDate getDate() {
		return data_consulta;
	}
	public void setDate(LocalDate date) {
		this.data_consulta = date;
	}
	public LocalTime getHora() {
		return hora;
	}
	public void setHora(LocalTime hora) {
		this.hora = hora;
	}
	

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Consulta other = (Consulta) obj;
		if (data_consulta == null) {
			if (other.data_consulta != null)
				return false;
		} else if (!data_consulta.equals(other.data_consulta))
			return false;
		if (hora == null) {
			if (other.hora != null)
				return false;
		} else if (!hora.equals(other.hora))
			return false;
		if (medico == null) {
			if (other.medico != null)
				return false;
		} else if (!medico.equals(other.medico))
			return false;
		if (paciente == null) {
			if (other.paciente != null)
				return false;
		} else if (!paciente.equals(other.paciente))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Paciente: " + paciente + "\nMedico: " + medico + "\nData: " + data_consulta + "\nHora: " + hora;
	}

	

}
