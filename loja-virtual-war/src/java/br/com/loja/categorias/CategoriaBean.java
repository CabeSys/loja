package br.com.loja.categorias;

import br.com.loja.excecoes.LojaDLOException;
import br.com.loja.secoes.Secao;
import br.com.loja.secoes.SecaoDLO;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class CategoriaBean {
    
    @EJB
    private CategoriaDLO dlo;
    
    @EJB
    private SecaoDLO secaoDLO;
    
    //Atributos ------------------------------------------------------
    private Categoria categoria;
    private List<Categoria> categorias;
    private List<Secao> secoes;

    //Construtor e postconstruct    
    public CategoriaBean(){
        categoria = new Categoria();
    }
    
    @PostConstruct
    public void iniciar(){
        categorias = dlo.listar();
        secoes = secaoDLO.listar();
        String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
        if (id != null){
            categoria = dlo.obter(Integer.parseInt(id));
        }
    }
    
    //Gets e Sets ------------------------------------------------------
    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
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
        for (int i = 0; i < categorias.size(); i++){
            if (categorias.get(i).getId() == id){
                categorias.remove(i);
                break;
            }
        }
        exibirMensagem("Categoria excluída com sucesso");
    }
   
    public void salvar(){        
        try {
            System.out.println("id -> " + categoria.getId());
            
            dlo.salvar(categoria);
            exibirMensagem("Categoria salva com sucesso");
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