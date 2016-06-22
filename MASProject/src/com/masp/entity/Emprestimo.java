package com.masp.entity;

import java.util.Date;

public class Emprestimo {
	private long id;
	private Obra obra;
	private String destino;
	private Date dataInicial;
	private Date dataFinal;
	private String museu;
	private String responsavel;
	private float custo;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Obra getObra() {
		return obra;
	}
	public void setObra(Obra obra) {
		this.obra = obra;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public Date getDataInicial() {
		return dataInicial;
	}
	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}
	public Date getDataFinal() {
		return dataFinal;
	}
	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}
	public String getMuseu() {
		return museu;
	}
	public void setMuseu(String museu) {
		this.museu = museu;
	}
	public String getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}
	public float getCusto() {
		return custo;
	}
	public void setCusto(float custo) {
		this.custo = custo;
	}
}
