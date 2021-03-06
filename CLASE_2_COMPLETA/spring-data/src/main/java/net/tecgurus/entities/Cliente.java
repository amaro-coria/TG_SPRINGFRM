package net.tecgurus.entities;
// Generated 11/03/2017 01:07:56 PM by Hibernate Tools 3.6.0.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Cliente generated by hbm2java
 */
@Entity
@Table(name = "Cliente", catalog = "tec_gurus")
public class Cliente implements java.io.Serializable {

	private Integer idCte;
	private String nomCte;
	private String apePatCte;
	private String apeMatCte;
	private String telCte;
	private String dirCte;
	private Integer idEdoCte;

	public Cliente() {
	}

	public Cliente(String nomCte, String apePatCte) {
		this.nomCte = nomCte;
		this.apePatCte = apePatCte;
	}

	public Cliente(String nomCte, String apePatCte, String apeMatCte, String telCte, String dirCte, Integer idEdoCte) {
		this.nomCte = nomCte;
		this.apePatCte = apePatCte;
		this.apeMatCte = apeMatCte;
		this.telCte = telCte;
		this.dirCte = dirCte;
		this.idEdoCte = idEdoCte;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id_cte", unique = true, nullable = false)
	public Integer getIdCte() {
		return this.idCte;
	}

	public void setIdCte(Integer idCte) {
		this.idCte = idCte;
	}

	@Column(name = "nom_cte", nullable = false, length = 30)
	public String getNomCte() {
		return this.nomCte;
	}

	public void setNomCte(String nomCte) {
		this.nomCte = nomCte;
	}

	@Column(name = "ape_pat_cte", nullable = false, length = 30)
	public String getApePatCte() {
		return this.apePatCte;
	}

	public void setApePatCte(String apePatCte) {
		this.apePatCte = apePatCte;
	}

	@Column(name = "ape_mat_cte", length = 30)
	public String getApeMatCte() {
		return this.apeMatCte;
	}

	public void setApeMatCte(String apeMatCte) {
		this.apeMatCte = apeMatCte;
	}

	@Column(name = "tel_cte", length = 20)
	public String getTelCte() {
		return this.telCte;
	}

	public void setTelCte(String telCte) {
		this.telCte = telCte;
	}

	@Column(name = "dir_cte", length = 200)
	public String getDirCte() {
		return this.dirCte;
	}

	public void setDirCte(String dirCte) {
		this.dirCte = dirCte;
	}

	@Column(name = "id_edo_cte")
	public Integer getIdEdoCte() {
		return this.idEdoCte;
	}

	public void setIdEdoCte(Integer idEdoCte) {
		this.idEdoCte = idEdoCte;
	}

}
