package br.com.loja.secoes;

import br.com.loja.excecoes.LojaDLOException;
import java.util.List;
import javax.ejb.Local;

@Local
public interface SecaoDLO {
    
    void salvar(Secao secao) throws LojaDLOException ;
    
    void excluir(int id);
    
    Secao obter(int id);
    
    List<Secao> listar();
    
}