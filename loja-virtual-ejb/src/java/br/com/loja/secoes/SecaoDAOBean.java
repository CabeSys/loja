package br.com.loja.secoes;

import br.com.loja.persistencia.AbstractDAO;
import javax.ejb.Stateless;
import javax.persistence.Query;

@Stateless
public class SecaoDAOBean extends AbstractDAO<Secao> implements SecaoDAO {

    public SecaoDAOBean(){
        super(Secao.class);
    }

    @Override
    public Secao obter(String nome) {
        String sql = "select s from Secao s where s.nome = :nome";
        Query query = getEntityManager().createQuery(sql).setParameter("nome", nome);
        Secao secao = null;
        if (!query.getResultList().isEmpty()){
            secao = (Secao) query.getResultList().get(0);
        }
        return secao;
    }

}