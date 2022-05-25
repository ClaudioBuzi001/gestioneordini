package it.prova.gestioneordini.model;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "articolo")
public class Articolo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
//	descrizione
	@Column(name = "descrizione")
	private String descrizione;
//	nmumeroSeriale
	@Column(name = "numeroseriale")
	private String numeroSeriale;
//	prezzoSingolo
	@Column(name = "prezzosingolo")
	private int prezzoSingolo;
//	dataInserimenot
	@Column(name = "datainserimento")
	private Date dataInserimento;

	@CreationTimestamp
	private LocalDateTime createDateTime;
	@UpdateTimestamp
	private LocalDateTime updateDateTime;

//	Ordine
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ordine_id", nullable = false)
	private Ordine ordine;
//	Set<Categoria>

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
	@JoinTable(name = "articolo_categoria", joinColumns = @JoinColumn(name = "articolo_id", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "categoria_id", referencedColumnName = "ID"))
	private Set<Categoria> categorie = new HashSet<Categoria>(0);

	public Articolo() {
	}

	public Articolo(long id, String descrizione, String numeroSeriale, int prezzoSingolo, Date dataInserimento,
			LocalDateTime createDateTime, LocalDateTime updateDateTime, Ordine ordine, Set<Categoria> categorie) {
		super();
		this.id = id;
		this.descrizione = descrizione;
		this.numeroSeriale = numeroSeriale;
		this.prezzoSingolo = prezzoSingolo;
		this.dataInserimento = dataInserimento;
		this.createDateTime = createDateTime;
		this.updateDateTime = updateDateTime;
		this.ordine = ordine;
		this.categorie = categorie;
	}

	public Articolo(long id, String descrizione, String numeroSeriale, int prezzoSingolo, Date dataInserimento,
			LocalDateTime createDateTime, LocalDateTime updateDateTime, Set<Categoria> categorie) {
		super();
		this.id = id;
		this.descrizione = descrizione;
		this.numeroSeriale = numeroSeriale;
		this.prezzoSingolo = prezzoSingolo;
		this.dataInserimento = dataInserimento;
		this.createDateTime = createDateTime;
		this.updateDateTime = updateDateTime;
		this.categorie = categorie;
	}

	public Articolo(String descrizione, String numeroSeriale, int prezzoSingolo, Date dataInserimento,
			LocalDateTime createDateTime, LocalDateTime updateDateTime, Ordine ordine, Set<Categoria> categorie) {
		super();
		this.descrizione = descrizione;
		this.numeroSeriale = numeroSeriale;
		this.prezzoSingolo = prezzoSingolo;
		this.dataInserimento = dataInserimento;
		this.createDateTime = createDateTime;
		this.updateDateTime = updateDateTime;
		this.ordine = ordine;
		this.categorie = categorie;
	}

	public Articolo(String descrizione, String numeroSeriale, int prezzoSingolo, Date dataInserimento,
			LocalDateTime createDateTime, LocalDateTime updateDateTime, Set<Categoria> categorie) {
		super();
		this.descrizione = descrizione;
		this.numeroSeriale = numeroSeriale;
		this.prezzoSingolo = prezzoSingolo;
		this.dataInserimento = dataInserimento;
		this.createDateTime = createDateTime;
		this.updateDateTime = updateDateTime;
		this.categorie = categorie;
	}

	public Articolo(long id, String descrizione, String numeroSeriale, int prezzoSingolo, Date dataInserimento,
			LocalDateTime createDateTime, LocalDateTime updateDateTime, Ordine ordine) {
		super();
		this.id = id;
		this.descrizione = descrizione;
		this.numeroSeriale = numeroSeriale;
		this.prezzoSingolo = prezzoSingolo;
		this.dataInserimento = dataInserimento;
		this.createDateTime = createDateTime;
		this.updateDateTime = updateDateTime;
		this.ordine = ordine;
	}

	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getNumeroSeriale() {
		return numeroSeriale;
	}

	public void setNumeroSeriale(String numeroSeriale) {
		this.numeroSeriale = numeroSeriale;
	}

	public int getPrezzoSingolo() {
		return prezzoSingolo;
	}

	public void setPrezzoSingolo(int prezzoSingolo) {
		this.prezzoSingolo = prezzoSingolo;
	}

	public Date getDataInserimento() {
		return dataInserimento;
	}

	public void setDataInserimento(Date dataInserimento) {
		this.dataInserimento = dataInserimento;
	}

	public LocalDateTime getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(LocalDateTime createDateTime) {
		this.createDateTime = createDateTime;
	}

	public LocalDateTime getUpdateDateTime() {
		return updateDateTime;
	}

	public void setUpdateDateTime(LocalDateTime updateDateTime) {
		this.updateDateTime = updateDateTime;
	}

	public Ordine getOrdine() {
		return ordine;
	}

	public void setOrdine(Ordine ordine) {
		this.ordine = ordine;
	}

	public Set<Categoria> getCategorie() {
		return categorie;
	}

	public void setCategorie(Set<Categoria> categorie) {
		this.categorie = categorie;
	}

}
