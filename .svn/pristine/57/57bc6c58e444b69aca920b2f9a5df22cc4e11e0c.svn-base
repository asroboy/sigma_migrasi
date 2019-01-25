/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtilXml;
import domain.MdContentInfo;
import java.math.BigDecimal;
import java.util.List;
import model.table.MdContentInfoModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author wallet
 */
public class MdContentInfoController {

    public MdContentInfoController() {
    }

    HibernateUtilXml hibernateUtilXml;
    Session session;

    public MdContentInfoController(Session session, HibernateUtilXml hibernateUtilXml) {
        this.hibernateUtilXml = hibernateUtilXml;
        this.session = session;
    }

    public BigDecimal getMaxMdContentInfoId() {
        BigDecimal maxId = null;

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdContentInfo.class);
            criteria.addOrder(Order.desc("id"));
            criteria.setMaxResults(1);
            List results = criteria.list();

            if (results.size() > 0) {
                maxId = ((MdContentInfo) results.get(0)).getId();
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

    public MdContentInfo getDataById(BigDecimal id) {
        MdContentInfo mdContentInfo = new MdContentInfo();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdContentInfo.class);
            criteria.add(Restrictions.eq("mdMetadataId", id));
            mdContentInfo = (MdContentInfo) criteria.uniqueResult();

            if (mdContentInfo == null) {
                return null;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally {
            //session.close();
        }

        return mdContentInfo;
    }
    
    public String deletedMdContentInfo(BigDecimal id) {
        MdContentInfo mdContentInfo = new MdContentInfo();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdContentInfo.class);
            criteria.add(Restrictions.eq("id", id));
            mdContentInfo = (MdContentInfo) criteria.uniqueResult();

            session.delete(mdContentInfo);
            trx.commit();
            
            return "berhasil dihapus.....!!";
        
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }

    }


    public String saveMdContentInfo(MdContentInfoModel mdContentInfoModel) {

        MdContentInfo mdContentInfo = new MdContentInfo();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
       Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            mdContentInfo.setId(mdContentInfoModel.getId());
            mdContentInfo.setExtendsType(mdContentInfoModel.getExtendsType());
            mdContentInfo.setMdMetadataId(mdContentInfoModel.getMdMetadataId());

            //System.out.println(md);
            session.save(mdContentInfo);
            trx.commit();

            return "berhasil disimpan.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
    }

    public String updateMdContentInfo(BigDecimal id,MdContentInfoModel mdModel) {

        MdContentInfo mdContentInfo = new MdContentInfo();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdContentInfo.class);
            criteria.add(Restrictions.eq("id", id));
            mdContentInfo = (MdContentInfo) criteria.uniqueResult();

            mdContentInfo.setExtendsType(mdModel.getExtendsType());
            mdContentInfo.setMdMetadataId(mdModel.getMdMetadataId());

            session.update(mdContentInfo);
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
