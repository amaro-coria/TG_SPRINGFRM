package net.tecgurus.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class CatalogoGeneralDTO implements Serializable{

	private Integer idCat;
	private String dscCorCat;
	private String dscComCat;
	private Integer idEstCat;
	private Date fchCre;
	private Date fchMod;
	
}
