package net.tecgurus.business.service;

import java.io.Serializable;
import java.util.List;

public interface GenericService  <DTO, PK extends Serializable, Mapping>{

	  /**
     * M�todo g�nerico utilizado para obtener todos los objetos de
     * un tipo particular.
     * 
     * @return Listado de objetos
     */
    List<DTO> getAll() throws ServiceException;

    /**
     * M�todo gen�rico para obtener un objeto basandose en su clase
     * e identificador.
     * 
     * @param id Identificador (clave primaria) del objeto a obtener
     * @return Objeto cargado
     */
    DTO findByPK(PK id) throws ServiceException;


    /**
     * M�todo gen�rico para salvar un objeto - maneja 
     * actualizaci�n e inserci�n.
     * 
     * @param object Objeto a guardar
     */
    void update(DTO object) throws ServiceException;

    /**
     * M�todo gen�rico para borrar un objeto basado en su clase e
     * identificador
     * 
     * @param id el identificador (llave primaria) del objeto a eliminar
     */
    void remove(DTO object) throws ServiceException;

    /**
     * M�todo gen�rico para insertar un objeto.
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
