/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtil;
import config.HibernateUtilXml;
import domain.DqQuantitativeResult;
import java.math.BigDecimal;
import java.util.List;
import model.table.DqQuantitativeResultModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author wallet
 */
public class DqQuantitativeResultController {
    
    private Session session;
    private HibernateUtilXml hibernateUtilXml;
    private String tagOpen="<gml:BaseUnit gml:id=\"-\">";
    private String tagClose="</gml:BaseUnit>";
    private String[] valueUnit={
            "<gml:remarks>-</gml:remarks>",
            "<gml:quantityType>-</gml:quantityType>",
            "<gml:quantityTypeReference>-</gml:quantityTypeReference>",
            "<gml:catalogSymbol>-</gml:catalogSymbol>",
            "<gml:description>-</gml:description>",
            "<gml:descriptionReference>-</gml:descriptionReference>",
            "<gml:metaDataProperty>-</gml:metaDataProperty>",
            "<gml:identifier>-</gml:identifier>",
            "<gml:unitsSystem>-</gml:unitsSystem>",
    };
    private String[] val={
            "gml:remarks",
            "gml:quantityType",
            "gml:quantityTypeReference",
            "gml:catalogSymbol",
            "gml:description",
            "gml:descriptionReference",
            "gml:metaDataProperty",
            "gml:identifier",
            "gml:unitsSystem",
    };

    

    public DqQuantitativeResultController() {
    }

    public DqQuantitativeResultController(Session session, HibernateUtilXml hibernateUtilXml) {
        this.session = session;
        this.hibernateUtilXml = hibernateUtilXml;
    }
    
    public String listToStringTag(List list){
        
        String tagElement="";
        String nullValue="";
        
        tagElement+=tagOpen+"\n";
       
        
        if(list.size()==0){
            
            return nullValue;
        }

        for(int i=0;i<list.size();i++){
           
            try{

                String tag=list.get(i).toString().split("_:_")[0];
                String value=list.get(i).toString().split("_:_")[1];

                if(!value.contains("null")){

                    if(tag.equals(val[i])){
                        tagElement+=valueUnit[i].replace("-", value);
                        tagElement+="\n";

                    }
                }
            }catch(ArrayIndexOutOfBoundsException ae){
                
            }
        }
        
        tagElement+=tagClose;
        
        return tagElement;
    
    }
        
    public DqQuantitativeResult getDataById(BigDecimal id) {
        DqQuantitativeResult dq = new DqQuantitativeResult();
                
         if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();
        
        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(DqQuantitativeResult.class);
            criteria.add(Restrictions.eq("dqResultId", id));
            dq = (DqQuantitativeResult) criteria.uniqueResult();

            if (dq == null) {
                return null;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally { 
            //session.close();
        }

        return dq;
    }
    
    public String deletedDqQuantitativeResult(BigDecimal id) {
        DqQuantitativeResult dq = new DqQuantitativeResult();
                
         if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();
        
        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(DqQuantitativeResult.class);
            criteria.add(Restrictions.eq("dqResultId", id));
            dq = (DqQuantitativeResult) criteria.uniqueResult();

            session.delete(dq);
            trx.commit();
            
            return "berhasil dihapus.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally { 
            //session.close();
        }
    }
    
    public String saveDqQuantitativeResult(DqQuantitativeResultModel mdModel) {
       
        DqQuantitativeResult dq = new DqQuantitativeResult();
        
         if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();
        
        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            dq.setDqResultId(mdModel.getDqResultId());
            dq.setErrorStatistic(mdModel.getErrorStatistic());
            dq.setValueType(mdModel.getValueType());
            dq.setValueUnit(mdModel.getValueUnit());
                        
            session.save(dq);
            trx.commit();
            
            return "berhasil disimpan.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally { 
            //session.close();
        }
    }

    public String updateDqQuantitativeResult(DqQuantitativeResultModel mdModel) {
        
        DqQuantitativeResult dq = new DqQuantitativeResult();
        
         if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();
        
        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(DqQuantitativeResult.class);
            criteria.add(Restrictions.eq("dqResultId", mdModel.getDqResultId()));
            dq = (DqQuantitativeResult) criteria.uniqueResult();

            dq.setErrorStatistic(mdModel.getErrorStatistic());
            dq.setValueType(mdModel.getValueType());
            dq.setValueUnit(mdModel.getValueUnit());

            session.update(dq);
            trx.commit();

            return "berhasil diubah.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
    }
    
}
