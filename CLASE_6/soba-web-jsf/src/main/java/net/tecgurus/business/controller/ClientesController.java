package net.tecgurus.business.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.tecgurus.business.dto.ClienteDTO;
import net.tecgurus.business.service.ClienteService;
import net.tecgurus.business.service.ServiceException;

@ManagedBean(name = "cteCtrl")
@ViewScoped
public class ClientesController extends GenericController{

	private List<ClienteDTO> listItems;
	private ClienteDTO currentItem = new ClienteDTO();
	@ManagedProperty(value="#{clienteServiceImpl}") 
	private ClienteService servieCliente;
	
	private static final Logger log = LoggerFactory.getLogger(ClientesController.class);

	private void initListItems() {
		if (listItems == null || CollectionUtils.isEmpty(listItems)) {
			try {
				listItems = servieCliente.getAll();
			} catch (ServiceException e) {
				super.addErrorMessage("Error al obtener clientes");
			}
		}
	}

	public String preAddCliente(){
		log.debug("Cliente preAdd");
		currentItem = new ClienteDTO();
		return "";
	}
	
	public String addCliente() {
		try {
			servieCliente.save(currentItem);
			super.addInfoMessage("Guardado exitoso");
			refreshItems();
			initListItems();
		} catch (ServiceException e) {
			super.addErrorMessage("Error al guardar cliente");
		}
		return "";
	}
	
	public String addClienteCancel(){
		super.addInfoMessage("Accion cancelada");
		return "";
	}

	private void refreshItems() {
		listItems = null;
		initListItems();
	}

	public List<ClienteDTO> getListItems() {
		initListItems();
		return listItems;
	}

	public void setListItems(List<ClienteDTO> listItems) {
		this.listItems = listItems;
	}

	public ClienteDTO getCurrentItem() {
		return currentItem;
	}

	public void setCurrentItem(ClienteDTO currentItem) {
		this.currentItem = currentItem;
	}

	public ClienteService getServieCliente() {
		return servieCliente;
	}

	public void setServieCliente(ClienteService servieCliente) {
		this.servieCliente = servieCliente;
	}

}
