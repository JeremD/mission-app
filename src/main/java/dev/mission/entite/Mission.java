package dev.mission.entite;

import java.math.BigDecimal;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Jeremy
 *
 */
@Entity
@Table(name = "mission")

public class Mission {

	/** id */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	/** libelle */
	private String libelle;
	
	/** dateDebut */
	private LocalDate dateDebut;
	
	/** dateFin */
	private LocalDate dateFin;
	
	/** tauxJournalier */
	private BigDecimal tauxJournalier;

	/**
	 * Getter
	 * 
	 * @return id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Setter
	 * 
	 * @param id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Getter
	 * 
	 * @return libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * Setter
	 * 
	 * @param libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * Getter
	 * 
	 * @return dateDebut
	 */
	public LocalDate getDateDebut() {
		return dateDebut;
	}

	/**
	 * Setter
	 * 
	 * @param dateDebut to set
	 */
	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}

	/**
	 * Getter
	 * 
	 * @return dateFin
	 */
	public LocalDate getDateFin() {
		return dateFin;
	}

	/**
	 * Setter
	 * 
	 * @param dateFin to set
	 */
	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	/**
	 * Getter
	 * 
	 * @return tauxJournalier
	 */
	public BigDecimal getTauxJournalier() {
		return tauxJournalier;
	}

	/**
	 * Setter
	 * 
	 * @param tauxJournalier to set
	 */
	public void setTauxJournalier(BigDecimal tauxJournalier) {
		this.tauxJournalier = tauxJournalier;
	}

}