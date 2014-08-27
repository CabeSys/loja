package br.com.loja.categorias;

import br.com.loja.excecoes.LojaDLOException;
import java.util.List;
import javax.ejb.Local;

@Local
public interface CategoriaDLO {
    
    void salvar(Categoria categoria) throws LojaDLOException ;
    
    void excluir(int id);
    
    Categoria obter(int id);
    
    List<Categoria> listar();
    
}