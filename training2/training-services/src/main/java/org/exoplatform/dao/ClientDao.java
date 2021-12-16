package org.exoplatform.dao;

import org.exoplatform.commons.persistence.impl.GenericDAOJPAImpl;
import org.exoplatform.entity.ClientEntity;

import javax.persistence.NamedQuery;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class ClientDao extends GenericDAOJPAImpl<ClientEntity, Long> {
    public List<ClientEntity> getClientByAddresse(String addresse){
        TypedQuery<ClientEntity> query=getEntityManager().createNamedQuery("ClientEntity.getClientByAddresse",ClientEntity.class);
        query.setParameter("addresse",addresse);
        return query.getResultList();
    }

    public long numberOfClient(String name){
        TypedQuery<Long> query = getEntityManager().createNamedQuery("ClientEntity.getNumber",Long.class);
        query.setParameter("name",name);
        return   query.getSingleResult();
    }
}