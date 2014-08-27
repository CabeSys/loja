package br.com.loja.secoes;

import br.com.loja.categorias.Categoria;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-07-03T11:56:02")
@StaticMetamodel(Secao.class)
public class Secao_ { 

    public static volatile SingularAttribute<Secao, Integer> id;
    public static volatile SingularAttribute<Secao, String> nome;
    public static volatile ListAttribute<Secao, Categoria> categorias;
    public static volatile SingularAttribute<Secao, String> descricao;

}