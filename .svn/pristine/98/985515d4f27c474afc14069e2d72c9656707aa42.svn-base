/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtil;
import config.HibernateUtilXml;
import domain.MdApplicationSchemaInfo;
import domain.MdExtendedElementInfo;
import domain.MdMetadataExtensionInfo;
import java.math.BigDecimal;
import java.util.List;
import model.table.MdApplicationSchemaInfoModel;
import model.table.MdMetadataExtensionInfoModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Fauzy Ramedia
 */
public class MdMetadataExtensionInfoController {

    Session session;
    HibernateUtilXml hibernateUtilXml;

    public MdMetadataExtensionInfoController(Session session, HibernateUtilXml hibernateUtilXml) {
        this.session = session;
        this.hibernateUtilXml = hibernateUtilXml;
    }

    public BigDecimal getMaxMdMetadataExtensionInfoId() {
        
         BigDecimal maxId = null;

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdMetadataExtensionInfo.class);
            criteria.addOrder(Order.desc("id"));
            criteria.setMaxResults(1);
            List results = criteria.list();

            if (results.size() > 0) {
                maxId = ((MdMetadataExtensionInfo) results.get(0)).getId();
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
    
    public MdMetadataExtensionInfo getDataById(BigDecimal Id) {

        MdMetadataExtensionInfo info = new MdMetadataExtensionInfo();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdMetadataExtensionInfo.class);
            criteria.add(Restrictions.eq("mdMetadataId", Id));
            info = (MdMetadataExtensionInfo) criteria.uniqueResult();

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

    public String saveMdMetadataExtensionInfo(MdMetadataExtensionInfoModel mdModel) {
        
        MdMetadataExtensionInfo MdMetadataExtensionInfo = new MdMetadataExtensionInfo();

        Session session = hibernateUtilXml.buildSession().openSession();
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            MdMetadataExtensionInfo.setId(mdModel.getId());
            MdMetadataExtensionInfo.setMdMetadataId(mdModel.getMdMetadataId());

            session.save(MdMetadataExtensionInfo);
            trx.commit();

            return "berhasil disimpan.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
    }
    
    public String UpdateMdMetadataExtensionInfo(BigDecimal id,MdMetadataExtensionInfoModel mdModel) {

        MdMetadataExtensionInfo info = new MdMetadataExtensionInfo();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }
                                    
            Criteria criteria = session.createCriteria(MdMetadataExtensionInfo.class);
            criteria.add(Restrictions.eq("id", id));
            info = (MdMetadataExtensionInfo) criteria.uniqueResult();

            info.setMdMetadataId(mdModel.getMdMetadataId());
            
            session.update(info);
            trx.commit();

            return "berhasil diubah.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
    }
    
    public String deleteMdMetadataExtensionInfo(BigDecimal Id) {

        MdMetadataExtensionInfo info = new MdMetadataExtensionInfo();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdMetadataExtensionInfo.class);
            criteria.add(Restrictions.eq("id", Id));
            info = (MdMetadataExtensionInfo) criteria.uniqueResult();

            session.delete(info);
            trx.commit();
            
            return "berhasil dihapus......!!";

        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
      
    }
}
