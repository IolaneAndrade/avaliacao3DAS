package Cadastros;

public class DuracaoHoras {
	
	private Viagem viagem;
	private int duracaoHoras = 0;
		
	
	public DuracaoHoras(int duracaoHoras) {
		super();
		this.duracaoHoras = duracaoHoras;
	}
	
	public int getDuracaoHoras() {
		if (horasIguais())
			duracaoHoras = 0;
		if (horaTerminoMaior()) //varias possibilidades... 
			if (viagem.getHoraTermino() == viagem.getHoraInicio() + 1) {  
				if (minutosTerminoMenor())  //nao chegou a uma hora
					duracaoHoras = 0;
				else //durou pelo menos uma hora
					duracaoHoras = 1;
			} else { //possivelmente ultrapassou duas horas
				if (variacaoTempoEmHoras() > 2) //
					duracaoHoras = variacaoTempoEmHoras();
				else if (variacaoTempoEmHoras() == 2 &&   //certamente menos de duas horas  
						minutosTerminoMenor())    //e mais de uma hora
					duracaoHoras = 1;
				else //duracao de duas horas, certamente
					duracaoHoras = 2;
					
			}
		if (horaTerminoMenor()) 
			duracaoHoras = -1; //para casos em que a hora de termino nao foi registrada
		return duracaoHoras;
	}

	public boolean horaTerminoMenor() {
		return viagem.getHoraTermino() < viagem.getHoraInicio();
	}

	public int variacaoTempoEmHoras() {
		return viagem.getHoraTermino() - viagem.getHoraInicio();
	}

	public boolean minutosTerminoMenor() {
		return viagem.getMinutosTermino() < viagem.getMinutoInicio();
	}

	public boolean horaTerminoMaior() {
		return viagem.getHoraTermino() > viagem.getHoraInicio();
	}

	public boolean horasIguais() {
		return viagem.getHoraTermino() == viagem.getHoraInicio();
	}


}
