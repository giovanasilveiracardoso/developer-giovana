package giovana.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class Util {

    public static void adicionarMensagemAoUsuario(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public static FacesMessage mensagemError(String mensagem){
    	return new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, "");
    }
    
}
