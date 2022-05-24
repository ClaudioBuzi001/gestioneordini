package it.prova.gestioneordini.model;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "ordine")
public class Ordine {

	// id
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

//	nomeDestinatario
	@Column(name = "nomedestinatario")
	private String nomeDestinatario;
//	indirizzoSpedizione
	@Column(name = "indirizzospedizione")
	private String indirizzoSpedizione;
//	dataSpedizione
	@Column(name = "dataspedizione")
	private Date dataSpedizione;

	@CreationTimestamp
	private LocalDateTime createDateTime;
	@UpdateTimestamp
	private LocalDateTime updateDateTime;

//	Set<Articoli>
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "articolo")
	private Set<Articolo> articoli;

	public Ordine(long id, String nomeDestinatario, String indirizzoSpedizione, Date dataSpedizione,
			Set<Articolo> articoli) {
		super();
		this.id = id;
		this.nomeDestinatario = nomeDestinatario;
		this.indirizzoSpedizione = indirizzoSpedizione;
		this.dataSpedizione = dataSpedizione;
		this.articoli = articoli;
	}

	public Ordine() {
		super();
	}

	public Ordine(String nomeDestinatario, String indirizzoSpedizione, Date dataSpedizione, Set<Articolo> articoli) {
		super();
		this.nomeDestinatario = nomeDestinatario;
		this.indirizzoSpedizione = indirizzoSpedizione;
		this.dataSpedizione = dataSpedizione;
		this.articoli = articoli;
	}

	public Ordine(String nomeDestinatario, String indirizzoSpedizione, Date dataSpedizione) {
		super();
		this.nomeDestinatario = nomeDestinatario;
		this.indirizzoSpedizione = indirizzoSpedizione;
		this.dataSpedizione = dataSpedizione;
	}

	public Ordine(long id, String nomeDestinatario, String indirizzoSpedizione, Date dataSpedizione) {
		super();
		this.id = id;
		this.nomeDestinatario = nomeDestinatario;
		this.indirizzoSpedizione = indirizzoSpedizione;
		this.dataSpedizione = dataSpedizione;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNomeDestinatario() {
		return nomeDestinatario;
	}

	public void setNomeDestinatario(String nomeDestinatario) {
		this.nomeDestinatario = nomeDestinatario;
	}

	public String getIndirizzoSpedizione() {
		return indirizzoSpedizione;
	}

	public void setIndirizzoSpedizione(String indirizzoSpedizione) {
		this.indirizzoSpedizione = indirizzoSpedizione;
	}

	public Date getDataSpedizione() {
		return dataSpedizione;
	}

	public void setDataSpedizione(Date dataSpedizione) {
		this.dataSpedizione = dataSpedizione;
	}

	public Set<Articolo> getArticoli() {
		return articoli;
	}

	public void setArticoli(Set<Articolo> articoli) {
		this.articoli = articoli;
	}

}
