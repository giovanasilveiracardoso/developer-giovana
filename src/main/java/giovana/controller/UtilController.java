package giovana.controller;

import javax.faces.context.FacesContext;

import giovana.model.Contato;
import giovana.util.Util;

public class UtilController {

	public static void validaFormulario(Contato contato) throws Exception {
		if(contato.getNome().trim().isEmpty() || contato.getNome().length() > 50){
			Util.adicionarMensagemAoUsuario(Util.mensagemError("Campo Nome não pode ser vazio nem possuir mais de 50 caracteres!"));
		}
		
		if(contato.getEmail().trim().isEmpty() || contato.getEmail().length() > 100){
			Util.adicionarMensagemAoUsuario(Util.mensagemError("Campo E-mail não pode ser vazio nem possuir mais de 100 caracteres!"));
		}
		
		if(contato.getAssunto().trim().isEmpty() || contato.getAssunto().length() > 150){
			Util.adicionarMensagemAoUsuario(Util.mensagemError("Campo Assunto não pode ser vazio nem possuir mais de 150 caracteres!"));
		}
		
		if(contato.getDescricao().trim().isEmpty() || contato.getDescricao().length() > 500){
			Util.adicionarMensagemAoUsuario(Util.mensagemError("Campo Descrição não pode ser vazio nem possuir mais de 500 caracteres!"));
		}
		
		if(!FacesContext.getCurrentInstance().getMessageList().isEmpty()){
			throw new Exception();
		}
	}
	
}
