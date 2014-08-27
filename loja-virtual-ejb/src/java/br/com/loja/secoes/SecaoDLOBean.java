package br.com.loja.secoes;

import br.com.loja.excecoes.LojaDLOException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class SecaoDLOBean implements SecaoDLO {

    @EJB
    SecaoDAO dao;

    @Override
    public void salvar(Secao secao) throws LojaDLOException {
        if (secao.getId() != null){
            Secao secaoFinal = dao.obter(secao.getId());
            secaoFinal.setNome(secao.getNome());
            secaoFinal.setDescricao(secao.getDescricao());
        } else {
            if (dao.obter(secao.getNome()) == null){
                dao.incluir(secao);
            } else {
                throw new LojaDLOException("Este nome já existe");
            }            
        }
    }

    @Override
    public void excluir(int id) {
        Secao secao = dao.obter(id);
        if (secao != null){
            dao.excluir(secao);
        }        
    }

    @Override
    public Secao obter(int id) {
        return dao.obter(id);
    }

    @Override
    public List<Secao> listar() {
        return dao.listar();
    }
    
}