package br.com.loja.secoes;

import java.util.Map;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "secaoConverter", forClass = Secao.class)
public class SecaoConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext contexto, UIComponent componente, String valor) {
        if (valor != null) {
            return this.getAttributesFrom(componente).get(valor);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext contexto, UIComponent componente, Object valor) {
        if (valor != null && ! "".equals(valor)) {
            Secao entidade = (Secao) valor;
 
            if (entidade.getId() != null) {
                this.addAttribute(componente, entidade);
 
                if (entidade.getId() != null) {
                    return String.valueOf(entidade.getId());
                }
                return (String) valor;
            }
        }
        return "";
    }
    
    private void addAttribute(UIComponent componente, Secao objeto) {
        this.getAttributesFrom(componente).put(objeto.getId().toString(), objeto);
    }
    
    private Map<String, Object> getAttributesFrom(UIComponent component) {
        return component.getAttributes();
    }
    
}