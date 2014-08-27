package br.com.loja.secoes;

import br.com.loja.excecoes.LojaDLOException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class SecaoBean {
    
    @EJB
    private SecaoDLO dlo;
    
    //Atributos ------------------------------------------------------
    private Secao secao;
    private List<Secao> secoes;

    //Construtor e postconstruct    
    public SecaoBean(){
        secao = new Secao();
    }
    
    @PostConstruct
    public void iniciar(){
        secoes = dlo.listar();
        String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
        if (id != null){
            secao = dlo.obter(Integer.parseInt(id));
        }
    }
    
    //Gets e Sets ------------------------------------------------------
    public Secao getSecao() {
        return secao;
    }

    public void setSecao(Secao secao) {
        this.secao = secao;
    }   

    public List<Secao> getSecoes() {
        return secoes;
    }

    public void setSecoes(List<Secao> secoes) {
        this.secoes = secoes;
    }
    
    //Metodos ------------------------------------------------------  
    public void excluir(int id){
        dlo.excluir(id);
        for (int i = 0; i < secoes.size(); i++){
            if (secoes.get(i).getId() == id){
                secoes.remove(i);
                break;
            }
        }
        exibirMensagem("Seção excluída com sucesso");
    }
   
    public void salvar(){        
        try {
            dlo.salvar(secao);
            exibirMensagem("Seção salva com sucesso");
        } catch (LojaDLOException ex) {
            exibirMensagem(ex.getMessage());
        }    
    }
    
    public void exibirMensagem(String mensagem){
        FacesMessage fm = new FacesMessage();
        fm.setSummary(mensagem);
        
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.addMessage(null, fm);
    }
    
}