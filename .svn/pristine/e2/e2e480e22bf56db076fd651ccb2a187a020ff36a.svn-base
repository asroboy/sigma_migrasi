/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import config.DataConfiguration;
import config.HibernateUtilXml;
import domain.PtLocale;
import java.math.BigDecimal;
import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import static test.Test.getIdByLanguage;

/**
 *
 * @author wallet
 */
public class testMain {

    /**
     * @param args the command line arguments
     */
    
    private  DataConfiguration config;

    public testMain(DataConfiguration config) {
        
        this.config = config;
        
//          for(DataConfiguration dc : list){
//            
//           System.out.println(dc.getIp());
//           System.out.println(dc.getDatabaseName());
//           System.out.println(dc.getPassword());
//           System.out.println(dc.getUsername());
//        }
    }
    
    public testMain() {
    }

    public void main() {
        // TODO code application logic here
        
//        ArrayList<DataConfiguration> list = new ArrayList<>();
//        DataConfiguration dataConfiguration = new DataConfiguration();
//        dataConfiguration.
//        dataConfiguration.setDatabaseName("produksisdo");
//        dataConfiguration.setUsername("metadata");
//        dataConfiguration.setPassword("oracle");
        
       // list.add(dataConfiguration);
        //HibernateUtil hibernateUtil = new HibernateUtil(listData);
        System.out.println(getIdByLanguage("INDONESIA", config).getId());
    }
    
     public PtLocale getIdByLanguage(String language, DataConfiguration config) {

        PtLocale ptLocale = new PtLocale();
        PtLocale local = new PtLocale();
        local.setId(BigDecimal.ONE);
        
        HibernateUtilXml util = new HibernateUtilXml(config);

        Session session = util.buildSession().openSession();
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(PtLocale.class);
            criteria.add(Restrictions.eq("country", language).ignoreCase());
            ptLocale = (PtLocale) criteria.uniqueResult();

            if (language == null) {
                return null;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return ptLocale;
    }
}
