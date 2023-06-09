package model.vo;

import java.time.LocalDate;

public class Seguro {

	private Integer id;
	private Pessoa pessoa;
	private Veiculo veiculo;
	private int numeroProposta;
	private LocalDate dtInicioVigencia;
	private LocalDate dtFimVigencia;
	private double rcfDanosMateriais;
	private double rcfDanosCorporais;
	private String franquia;
	private String assistencia;
	private String carroReserva;

	public Seguro(Integer id, Pessoa pessoa, Veiculo veiculo, int numeroProposta,
			LocalDate dtInicioVigencia, LocalDate dtFimVigencia, double rcfDanosMateriais, double rcfDanosCorporais,
			String franquia, String assistencia, String carroReserva) {
		super();
		this.id = id;
		this.pessoa = pessoa;
		this.veiculo = veiculo;
		this.numeroProposta = numeroProposta;
		this.dtInicioVigencia = dtInicioVigencia;
		this.dtFimVigencia = dtFimVigencia;
		this.rcfDanosMateriais = rcfDanosMateriais;
		this.rcfDanosCorporais = rcfDanosCorporais;
		this.franquia = franquia;
		this.assistencia = assistencia;
		this.carroReserva = carroReserva;
	}

	public Seguro() {
	
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public int getNumeroProposta() {
		return numeroProposta;
	}

	public void setNumeroProposta(int numeroProposta) {
		this.numeroProposta = numeroProposta;
	}

	public LocalDate getDtInicioVigencia() {
		return dtInicioVigencia;
	}

	public void setDtInicioVigencia(LocalDate dtInicioVigencia) {
		this.dtInicioVigencia = dtInicioVigencia;
	}

	public LocalDate getDtFimVigencia() {
		return dtFimVigencia;
	}

	public void setDtFimVigencia(LocalDate dtFimVigencia) {
		this.dtFimVigencia = dtFimVigencia;
	}

	public double getRcfDanosMateriais() {
		return rcfDanosMateriais;
	}

	public void setRcfDanosMateriais(double rcfDanosMateriais) {
		this.rcfDanosMateriais = rcfDanosMateriais;
	}

	public double getRcfDanosCorporais() {
		return rcfDanosCorporais;
	}

	public void setRcfDanosCorporais(double rcfDanosCorporais) {
		this.rcfDanosCorporais = rcfDanosCorporais;
	}

	public String getFranquia() {
		return franquia;
	}

	public void setFranquia(String franquia) {
		this.franquia = franquia;
	}

	public String getAssistencia() {
		return assistencia;
	}

	public void setAssistencia(String assistencia) {
		this.assistencia = assistencia;
	}

	public String getCarroReserva() {
		return carroReserva;
	}

	public void setCarroReserva(String carroReserva) {
		this.carroReserva = carroReserva;
	}

	public String toString() {
		return "Proposta: " + numeroProposta
				+ "| Segurado : " + pessoa.getNome();
	}
}
