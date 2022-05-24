package it.prova.gestioneordini.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "categoria")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	@Column(name = "descrizione")
	private String descrizione;
	@Column(name = "codice")
	private String codice;

	@CreationTimestamp
	private LocalDateTime createDateTime;
	@UpdateTimestamp
	private LocalDateTime updateDateTime;

//	set<Articoli>
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "categorie")
	private Set<Articolo> articoli = new HashSet<Articolo>(0);

	public Categoria() {
		super();
	}

	public Categoria(String descrizione, String codice, LocalDateTime createDateTime, LocalDateTime updateDateTime,
			Set<Articolo> articoli) {
		super();
		this.descrizione = descrizione;
		this.codice = codice;
		this.createDateTime = createDateTime;
		this.updateDateTime = updateDateTime;
		this.articoli = articoli;
	}

	public Categoria(String descrizione, String codice, LocalDateTime createDateTime, LocalDateTime updateDateTime) {
		super();
		this.descrizione = descrizione;
		this.codice = codice;
		this.createDateTime = createDateTime;
		this.updateDateTime = updateDateTime;
	}

	public Categoria(String descrizione, String codice) {
		super();
		this.descrizione = descrizione;
		this.codice = codice;
	}

	public Categoria(long id, String descrizione, String codice, Set<Articolo> articoli) {
		super();
		this.id = id;
		this.descrizione = descrizione;
		this.codice = codice;
		this.articoli = articoli;
	}

	public Categoria(String descrizione, String codice, Set<Articolo> articoli) {
		super();
		this.descrizione = descrizione;
		this.codice = codice;
		this.articoli = articoli;
	}

	public Categoria(long id, String descrizione, String codice) {
		super();
		this.id = id;
		this.descrizione = descrizione;
		this.codice = codice;
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

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
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

	public Set<Articolo> getArticoli() {
		return articoli;
	}

	public void setArticoli(Set<Articolo> articoli) {
		this.articoli = articoli;
	}

}
