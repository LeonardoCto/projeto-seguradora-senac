package model.vo;

import java.time.LocalDate;

public class Seguro {

	private Integer id;
	//private Integer idSegurado;
	private String nomeSegurado;
	private int numero_proposta;
	private LocalDate dt_inicio_vigencia;
	private LocalDate dt_fim_vigencia;
	private String placaVeiculo;
	private double rcf_danos_materiais;
	private double rcf_danos_corporais;
	private String franquia;
	private String assistencia;
	private String carroReserva;
	private Coberturas coberturas;

	public Seguro() {

	}

	public Seguro(Integer id, String nomeSegurado, int numero_proposta, LocalDate dt_inicio_vigencia,
			LocalDate dt_fim_vigencia, String placaVeiculo, double rcf_danos_materiais, double rcf_danos_corporais,
			String franquia, String assistencia, String carroReserva, Coberturas coberturas) {
		super();
		this.id = id;
		this.nomeSegurado = nomeSegurado;
		this.numero_proposta = numero_proposta;
		this.dt_inicio_vigencia = dt_inicio_vigencia;
		this.dt_fim_vigencia = dt_fim_vigencia;
		this.placaVeiculo = placaVeiculo;
		this.rcf_danos_materiais = rcf_danos_materiais;
		this.rcf_danos_corporais = rcf_danos_corporais;
		this.franquia = franquia;
		this.assistencia = assistencia;
		this.carroReserva = carroReserva;
		this.coberturas = coberturas;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeSegurado() {
		return nomeSegurado;
	}

	public void setNomeSegurado(String nomeSegurado) {
		this.nomeSegurado = nomeSegurado;
	}

	public int getNumero_proposta() {
		return numero_proposta;
	}

	public void setNumero_proposta(int numero_proposta) {
		this.numero_proposta = numero_proposta;
	}

	public LocalDate getDt_inicio_vigencia() {
		return dt_inicio_vigencia;
	}

	public void setDt_inicio_vigencia(LocalDate dt_inicio_vigencia) {
		this.dt_inicio_vigencia = dt_inicio_vigencia;
	}

	public LocalDate getDt_fim_vigencia() {
		return dt_fim_vigencia;
	}

	public void setDt_fim_vigencia(LocalDate dt_fim_vigencia) {
		this.dt_fim_vigencia = dt_fim_vigencia;
	}

	public String getPlacaVeiculo() {
		return placaVeiculo;
	}

	public void setPlacaVeiculo(String placaVeiculo) {
		this.placaVeiculo = placaVeiculo;
	}

	public double getRcf_danos_materiais() {
		return rcf_danos_materiais;
	}

	public void setRcf_danos_materiais(double rcf_danos_materiais) {
		this.rcf_danos_materiais = rcf_danos_materiais;
	}

	public double getRcf_danos_corporais() {
		return rcf_danos_corporais;
	}

	public void setRcf_danos_corporais(double rcf_danos_corporais) {
		this.rcf_danos_corporais = rcf_danos_corporais;
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

	public Coberturas getCoberturas() {
		return coberturas;
	}

	public void setCoberturas(Coberturas coberturas) {
		this.coberturas = coberturas;
	}

	
}
