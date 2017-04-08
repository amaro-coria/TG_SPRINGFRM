package net.tecgurus.business.service;

import java.io.Serializable;
import java.util.List;

public interface GenericService  <DTO, PK extends Serializable, Mapping>{

	  /**
     * Método génerico utilizado para obtener todos los objetos de
     * un tipo particular.
     * 
     * @return Listado de objetos
     */
    List<DTO> getAll() throws ServiceException;

    /**
     * Método genérico para obtener un objeto basandose en su clase
     * e identificador.
     * 
     * @param id Identificador (clave primaria) del objeto a obtener
     * @return Objeto cargado
     */
    DTO findByPK(PK id) throws ServiceException;


    /**
     * Método genérico para salvar un objeto - maneja 
     * actualización e inserción.
     * 
     * @param object Objeto a guardar
     */
    void update(DTO object) throws ServiceException;

    /**
     * Método genérico para borrar un objeto basado en su clase e
     * identificador
     * 
     * @param id el identificador (llave primaria) del objeto a eliminar
     */
    void remove(DTO object) throws ServiceException;

    /**
     * Método genérico para insertar un objeto.
     */
    PK save(DTO object) throws ServiceException;

    /**
     * Guarda o actualiza un registro
     * 
     * @param object
     */
    void saveOrUpdate(DTO object) throws ServiceException;
    
    /**
     * Verifica la existencia de un objeto por clave primaria
     * 
     * @param paramPK Clave primaria
     * @return Verdadero si existe un objeto relacionado con la llave primaria 
     */
    boolean exists(PK paramPK) throws ServiceException;
    
}
