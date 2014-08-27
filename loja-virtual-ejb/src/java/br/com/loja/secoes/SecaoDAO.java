package br.com.loja.secoes;

import java.util.List;
import javax.ejb.Local;

@Local
public interface SecaoDAO {
    
    void incluir(Secao secao);
    
    void alterar(Secao secao);
    
    void excluir(Secao secao);
    
    Secao obter(Object id);
    
    Secao obter(String nome);
    
    List<Secao> listar();
    
}