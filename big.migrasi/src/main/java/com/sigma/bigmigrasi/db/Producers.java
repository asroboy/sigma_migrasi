/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sigma.bigmigrasi.db;

import java.util.HashMap;
import java.util.Map;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.spi.PersistenceUnitInfo;
import org.eclipse.persistence.jpa.PersistenceProvider;

/**
 *
 * @author Ridho
 */
public class Producers {

    @Produces
    public EntityManager getEntityManager() {
        final Map<String, String> properties = new HashMap<>();

//        properties.put(Persistence.PERSISTENCE_PROVIDER, "org.hibernate.jpa.HibernatePersistenceProvider");
        properties.put("javax.persistence.transactionType", "RESOURCE_LOCAL");
        properties.put("javax.persistence.jdbc.url", "jdbc:oracle:thin:@localhost:1521:orcl");
        properties.put("javax.persistence.jdbc.driver", "oracle.jdbc.OracleDriver");
        properties.put("javax.persistence.jdbc.user", "unsur");
        properties.put("javax.persistence.jdbc.password", "unsur");

        properties.put("hibernate.cache.provider_class", "org.hibernate.cache.NoCacheProvider");

        PersistenceProvider persistenceProvider = new PersistenceProvider();
        final EntityManagerFactory factory = persistenceProvider.createEntityManagerFactory("LOCAL_SDO", properties);

        
//        final EntityManagerFactory factory = Persistence.createEntityManagerFactory("LOCAL_SDO", properties);
        return factory.createEntityManager();
    }
}
