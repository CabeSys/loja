package br.com.loja.categorias;

import br.com.loja.persistencia.AbstractDAO;
import javax.ejb.Stateless;
import javax.persistence.Query;

@Stateless
public class CategoriaDAOBean extends AbstractDAO<Categoria> implements CategoriaDAO {

    public CategoriaDAOBean(){
        super(Categoria.class);
    }

    @Override
    public Categoria obter(String nome) {
        String sql = "select c from Categoria c where c.nome = :nome";
        Query query = getEntityManager().createQuery(sql).setParameter("nome", nome);
        Categoria categoria = null;
        if (!query.getResultList().isEmpty()){
            categoria = (Categoria) query.getResultList().get(0);
        }
        return categoria;
    }

}