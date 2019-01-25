/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtil;
import config.HibernateUtilXml;
import domain.MdAggregateInfo;
import domain.MdApplicationSchemaInfo;
import java.math.BigDecimal;
import java.util.List;
import model.table.MdAggregateInfoModel;
import model.table.MdApplicationSchemaInfoModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author wallet
 */
public class MdApplicationSchemaInfoController {

    
    Session session;
    HibernateUtilXml hibernateUtilXml;

    public MdApplicationSchemaInfoController(Session session, HibernateUtilXml hibernateUtilXml) {
        this.session = session;
        this.hibernateUtilXml = hibernateUtilXml;
    }

    public BigDecimal getMaxMdApplicationSchemaInfoId() {
        
         BigDecimal maxId = null;

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(domain.MdApplicationSchemaInfo.class);
            criteria.addOrder(Order.desc("id"));
            criteria.setMaxResults(1);
            List results = criteria.list();

            if (results.size() > 0) {
                maxId = ((domain.MdApplicationSchemaInfo) results.get(0)).getId();
            } else {
                //  maxId = 0;
            }

            trx.commit();

        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        }
        //session.close();
        
        return maxId;
    }
    
    public MdApplicationSchemaInfo getDataById(BigDecimal Id) {

        MdApplicationSchemaInfo info = new MdApplicationSchemaInfo();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdApplicationSchemaInfo.class);
            criteria.add(Restrictions.eq("mdMetadataId", Id));
            info = (MdApplicationSchemaInfo) criteria.uniqueResult();

            if (info == null) {
                return null;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally {
            //session.close();
        }

        return info;
    }
    
    public String deletedMdApplicationSchemaInfo(BigDecimal Id) {

        MdApplicationSchemaInfo info = new MdApplicationSchemaInfo();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdApplicationSchemaInfo.class);
            criteria.add(Restrictions.eq("id", Id));
            info = (MdApplicationSchemaInfo) criteria.uniqueResult();

           
            session.delete(info);
            trx.commit();
            
            return "berhasil dihapus.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }

    }


    public String saveMdApplicationSchemaInfo(MdApplicationSchemaInfoModel mdModel) {

        MdApplicationSchemaInfo mdApplicationSchemaInfo = new MdApplicationSchemaInfo();

        Session session = hibernateUtilXml.buildSession().openSession();
        Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            mdApplicationSchemaInfo.setId(mdModel.getId());
            mdApplicationSchemaInfo.setConstraintLanguage(mdModel.getConstraintLanguage());
            mdApplicationSchemaInfo.setGraphicsFile(mdModel.getGraphicsFile());
            mdApplicationSchemaInfo.setSchemaAscii(mdModel.getSchemaAscii());
            mdApplicationSchemaInfo.setSchemaLanguage(mdModel.getSchemaLanguage());
            mdApplicationSchemaInfo.setSoftwareDevelopmentFile(mdModel.getSoftwareDevelopmentFile());
            mdApplicationSchemaInfo.setSoftwareDevelopmentFileFormat(mdModel.getSoftwareDevelopmentFileFormat());
            mdApplicationSchemaInfo.setMdMetadataId(mdModel.getMdMetadataId());

            //System.out.println(md);
            session.save(mdApplicationSchemaInfo);
            trx.commit();

            return "berhasil disimpan.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
    }
    
    public String UpdateMdApplicationSchemaInfo(BigDecimal id,MdApplicationSchemaInfoModel mdModel) {

        MdApplicationSchemaInfo mdApplicationSchemaInfo = new MdApplicationSchemaInfo();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }
                                    
            Criteria criteria = session.createCriteria(domain.MdApplicationSchemaInfo.class);
            criteria.add(Restrictions.eq("id", id));
            mdApplicationSchemaInfo = (domain.MdApplicationSchemaInfo) criteria.uniqueResult();

            mdApplicationSchemaInfo.setConstraintLanguage(mdModel.getConstraintLanguage());
            mdApplicationSchemaInfo.setGraphicsFile(mdModel.getGraphicsFile());
            mdApplicationSchemaInfo.setSchemaAscii(mdModel.getSchemaAscii());
            mdApplicationSchemaInfo.setSchemaLanguage(mdModel.getSchemaLanguage());
            mdApplicationSchemaInfo.setSoftwareDevelopmentFile(mdModel.getSoftwareDevelopmentFile());
            mdApplicationSchemaInfo.setSoftwareDevelopmentFileFormat(mdModel.getSoftwareDevelopmentFileFormat());
            mdApplicationSchemaInfo.setMdMetadataId(mdModel.getMdMetadataId());

            //System.out.println(md);
            session.update(mdApplicationSchemaInfo);
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