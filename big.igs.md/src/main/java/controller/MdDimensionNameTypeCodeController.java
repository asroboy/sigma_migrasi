/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtil;
import config.HibernateUtilXml;
import domain.MdDimensionNameTypeCode;
import java.math.BigDecimal;
import java.util.List;
import model.table.MdDimensionNameTypeCodeModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Fauzy Ramedia
 */
public class MdDimensionNameTypeCodeController {

 
    HibernateUtilXml hibernateUtilXml;

    public MdDimensionNameTypeCodeController(HibernateUtilXml hibernateUtilXml) {
        this.hibernateUtilXml = hibernateUtilXml;

    }
    
    public long getMaxMdDimensionNameTypeCodeId() {
        long x = 999;
        long maxId = 1;
        
        Session session = hibernateUtilXml.buildSession().openSession();
        Transaction trx = session.beginTransaction();
        
        try {          
            if (!trx.isActive()) {
                trx.begin();
            }
                        
            Criteria criteria = session.createCriteria(MdDimensionNameTypeCode.class);
            criteria.add(Restrictions.ne("code", new BigDecimal(x)));
            criteria.setMaxResults(1);
            List results = criteria.list();

            if (results.size() > 0) {
                maxId = 1;
            } else {
                maxId = results.size() + 1;
            }
            
            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally {
            //session.close();
        }

        return maxId;
    }

    public String saveMdDimensionNameTypeCode(MdDimensionNameTypeCodeModel mdModel) {
        MdDimensionNameTypeCode MdDimensionNameTypeCode = new MdDimensionNameTypeCode();
        
        Session session = hibernateUtilXml.buildSession().openSession();
         Transaction trx = session.getTransaction();
        
        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            MdDimensionNameTypeCode.setCode(mdModel.getCode());
            MdDimensionNameTypeCode.setDefinition(mdModel.getDefinition());
            MdDimensionNameTypeCode.setDomainName(mdModel.getDomainName());
                    
            session.save(MdDimensionNameTypeCode);
            trx.commit();
            
            return "saved successfully.....!!";
        } catch (Exception e) {
            trx.rollback();
            return e.getMessage();
        } finally { 
            //session.close();
        }
    }
}
