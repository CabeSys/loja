package br.com.loja.categorias;

import br.com.loja.excecoes.LojaDLOException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class CategoriaDLOBean implements CategoriaDLO {

    @EJB
    CategoriaDAO dao;

    @Override
    public void salvar(Categoria categoria) throws LojaDLOException {
        if (categoria.getId() != null){
            Categoria categoriaFinal = dao.obter(categoria.getId());
            categoriaFinal.setNome(categoria.getNome());
            categoriaFinal.setDescricao(categoria.getDescricao());
            categoriaFinal.setSecao(categoria.getSecao());
        } else {
            if (dao.obter(categoria.getNome()) == null){
                dao.incluir(categoria);
            } else {
                throw new LojaDLOException("Este nome já existe");
            }            
        }
    }

    @Override
    public void excluir(int id) {
        Categoria categoria = dao.obter(id);
        if (categoria != null){
            dao.excluir(categoria);
        }        
    }

    @Override
    public Categoria obter(int id) {
        return dao.obter(id);
    }

    @Override
    public List<Categoria> listar() {
        return dao.listar();
    }
    
}