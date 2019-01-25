/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtil;
import config.HibernateUtilXml;
import domain.CiOnlineResource;
import domain.MdExtendedElementInfo;
import domain.MdExtendedElementInfoParent;
import java.math.BigDecimal;
import java.util.List;
import model.table.CiOnlineResourceModel;
import model.table.MdExtendedElementInfoModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Fauzy Ramedia
 */
public class MdExtendedElementInfoController {
    
    HibernateUtilXml hibernateUtilXml;
    Session session;

    public MdExtendedElementInfoController(Session session, HibernateUtilXml hibernateUtilXml) {
        this.hibernateUtilXml = hibernateUtilXml;
        this.session = session;
    }

    public BigDecimal getMaxMdExtendedElementInfoId() {

        BigDecimal maxId = null;

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdExtendedElementInfo.class);
            criteria.addOrder(Order.desc("id"));
            criteria.setMaxResults(1);
            List results = criteria.list();

            if (results.size() > 0) {
                maxId = ((MdExtendedElementInfo) results.get(0)).getId();
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

    public MdExtendedElementInfo getDataById(BigDecimal Id) {

        MdExtendedElementInfo info = new MdExtendedElementInfo();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdExtendedElementInfo.class);
            criteria.add(Restrictions.eq("mdMetadataExtensionInfoId", Id));
            info = (MdExtendedElementInfo) criteria.uniqueResult();

            if (info== null) {
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

    public String saveMdExtendedElementInfo(MdExtendedElementInfoModel mdModel) {
        
        MdExtendedElementInfo MdExtendedElementInfo = new MdExtendedElementInfo();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();
        
        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            MdExtendedElementInfo.setId(mdModel.getId());
            MdExtendedElementInfo.setCondition(mdModel.getCondition());
            MdExtendedElementInfo.setDefinition(mdModel.getDefinition());
            MdExtendedElementInfo.setDomainCode(mdModel.getDomainCode());
            MdExtendedElementInfo.setDomainValue(mdModel.getDomainValue());
            MdExtendedElementInfo.setMaximumOccurrence(mdModel.getMaximumOccurrence());
            MdExtendedElementInfo.setName(mdModel.getName());
            MdExtendedElementInfo.setRule(mdModel.getRule());
            MdExtendedElementInfo.setShortName(mdModel.getShortname());
            MdExtendedElementInfo.setDataType(mdModel.getDataType());
            MdExtendedElementInfo.setMdMetadataExtensionInfoId(mdModel.getMdMetadataExtensionInfoId());
            MdExtendedElementInfo.setObligation(mdModel.getObligation());

            session.save(MdExtendedElementInfo);
            trx.commit();

            return "berhasil disimpan.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
    }
    
    public String updateMdExtendedElementInfo(BigDecimal id,MdExtendedElementInfoModel mdModel) {

        MdExtendedElementInfo info = new MdExtendedElementInfo();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdExtendedElementInfo.class);
            criteria.add(Restrictions.eq("id", id));
            info = (MdExtendedElementInfo) criteria.uniqueResult();

            info.setCondition(mdModel.getCondition());
            info.setDefinition(mdModel.getDefinition());
            info.setDomainCode(mdModel.getDomainCode());
            info.setDomainValue(mdModel.getDomainValue());
            info.setMaximumOccurrence(mdModel.getMaximumOccurrence());
            info.setName(mdModel.getName());
            info.setRule(mdModel.getRule());
            info.setShortName(mdModel.getShortname());
            info.setDataType(mdModel.getDataType());
            info.setMdMetadataExtensionInfoId(mdModel.getMdMetadataExtensionInfoId());
            info.setObligation(mdModel.getObligation());
            
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
    
    public String deleteMdExtendedElementInfo(BigDecimal Id) {

        MdExtendedElementInfo info = new MdExtendedElementInfo();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdExtendedElementInfo.class);
            criteria.add(Restrictions.eq("id", Id));
            info = (MdExtendedElementInfo) criteria.uniqueResult();

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
