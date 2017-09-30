package giovana.controller;

import giovana.business.ContatoBusiness;
import giovana.model.Contato;
import giovana.util.Util;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class ContatoController implements Serializable {

	private static final long serialVersionUID = 1L;
	private Contato contato = new Contato();
	private ContatoBusiness contatoBusiness = new ContatoBusiness();
	
	public Contato getContato() {
		return contato;
	}
	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public void enviar() {
        FacesMessage message = null;
        
        try {
        	UtilController.validaFormulario(contato);
        	contatoBusiness.enviarEmail(contato);
        	message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Contato enviado com sucesso", "Seu contato foi enviado com sucesso");
        	this.contato = new Contato();
        	
        	Util.adicionarMensagemAoUsuario(message);
		} catch (Exception e) {
			if(FacesContext.getCurrentInstance().getMessageList().isEmpty()){
				message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Não foi possível enviar o seu contato!", "Contato não enviado");
			
				Util.adicionarMensagemAoUsuario(message);
			}
		}
    }
	
}
