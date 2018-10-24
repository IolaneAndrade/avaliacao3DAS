package Cadastros;

public class DuracaoMinutos {
	
	private int duracaoMinutos;
	private Viagem viagem;
	
	
	public DuracaoMinutos(int duracaoMinutos) {
		super();
		this.duracaoMinutos = duracaoMinutos;
	}


	public int getDuracaoMinutos() {
		if (minutosTerminoMaior()) 
			duracaoMinutos = variacaoTempoMinutos();
		else {
			duracaoMinutos = variacaoTempoMinutosNumCicloDeRelogio();
			if (duracaoMinutos == 60) //caso especial
				duracaoMinutos = 0;
		}
		return duracaoMinutos;
	}


	public int variacaoTempoMinutosNumCicloDeRelogio() {
		return 60 - viagem.getMinutoInicio() + viagem.getMinutosTermino();
	}


	public int variacaoTempoMinutos() {
		return viagem.getMinutosTermino() - viagem.getMinutoInicio();
	}


	public boolean minutosTerminoMaior() {
		return viagem.getMinutosTermino() > viagem.getMinutoInicio();
	}

}
