package br.com.loja.categorias;

import java.util.List;
import javax.ejb.Local;

@Local
public interface CategoriaDAO {
    
    void incluir(Categoria categoria);
    
    void alterar(Categoria categoria);
    
    void excluir(Categoria categoria);
    
    Categoria obter(Object id);
    
    Categoria obter(String nome);
    
    List<Categoria> listar();
    
}