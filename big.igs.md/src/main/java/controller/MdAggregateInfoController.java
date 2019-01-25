/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtilXml;
import domain.MdAggregateInfo;
import java.math.BigDecimal;
import java.util.List;
import model.table.MdAggregateInfoModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author wallet
 */
public class MdAggregateInfoController {

    public MdAggregateInfoController() {
    }

    HibernateUtilXml hibernateUtilXml;
    Session session;

    public MdAggregateInfoController(Session session, HibernateUtilXml hibernateUtilXml) {
        this.hibernateUtilXml = hibernateUtilXml;
        this.session = session;
    }

    public BigDecimal getMaxMdAggregateInfoId() {

        BigDecimal maxId = null;

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdAggregateInfo.class);
            criteria.addOrder(Order.desc("id"));
            criteria.setMaxResults(1);
            List results = criteria.list();

            if (results.size() > 0) {
                maxId = ((MdAggregateInfo) results.get(0)).getId();
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

    public MdAggregateInfo getDataByObjek(MdAggregateInfoModel md) {

        MdAggregateInfo mdAggregateInfo = new MdAggregateInfo();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdAggregateInfo.class);
            criteria.add(Restrictions.eq("mdIdentificationId", md.getMdIdentificationId()))
                    .add(Restrictions.eqOrIsNull("initiativeType", md.getInitiativeType()))
                    .add(Restrictions.eqOrIsNull("assosiationType", md.getAssositionType()));
            
            mdAggregateInfo = (MdAggregateInfo) criteria.uniqueResult();

            if (mdAggregateInfo == null) {
                return null;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally {
            //session.close();
        }

        return mdAggregateInfo;
    }
    
    public MdAggregateInfo getDataById(BigDecimal mdIdentificationId) {

        MdAggregateInfo mdAggregateInfo = new MdAggregateInfo();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdAggregateInfo.class);
            criteria.add(Restrictions.eq("mdIdentificationId", mdIdentificationId));
            
            mdAggregateInfo = (MdAggregateInfo) criteria.uniqueResult();

            if (mdAggregateInfo == null) {
                return null;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally {
            //session.close();
        }

        return mdAggregateInfo;
    }
    
    public String deletedMdAggregateInfo(BigDecimal Id) {

        MdAggregateInfo mdAggregateInfo = new MdAggregateInfo();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdAggregateInfo.class);
            criteria.add(Restrictions.eq("id", Id));
            mdAggregateInfo = (MdAggregateInfo) criteria.uniqueResult();

            session.delete(mdAggregateInfo);
            trx.commit();
            
            return "berhasil dihapus.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
    }

    public MdAggregateInfo getDataByProperty(BigDecimal Id, String initatype, String associatype) {

        MdAggregateInfo mdAggregateInfo = new MdAggregateInfo();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdAggregateInfo.class);
            criteria.add(Restrictions.eq("mdIdentificationId", Id))
                    .add(Restrictions.eqOrIsNull("initiativeType", initatype))
                    .add(Restrictions.eqOrIsNull("assosiationType", associatype));
            mdAggregateInfo = (MdAggregateInfo) criteria.uniqueResult();

            if (mdAggregateInfo == null) {
                return null;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally {
            //session.close();
        }

        return mdAggregateInfo;
    }

    public String saveMdAggregateInfo(MdAggregateInfoModel mdAggregateInfoModel) {

        MdAggregateInfo mdAggregateInfo = new MdAggregateInfo();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            mdAggregateInfo.setId(mdAggregateInfoModel.getId());
            mdAggregateInfo.setAssosiationType(mdAggregateInfoModel.getAssositionType());
            mdAggregateInfo.setInitiativeType(mdAggregateInfoModel.getInitiativeType());
            mdAggregateInfo.setMdIdentificationId(mdAggregateInfoModel.getMdIdentificationId());

            //System.out.println(md);
            session.save(mdAggregateInfo);
            trx.commit();

            return "berhasil disimpan.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
    }

    public String updateMdAggregateInfo(BigDecimal id,MdAggregateInfoModel mdModel) {

        MdAggregateInfo mdAggregateInfo = new MdAggregateInfo();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdAggregateInfo.class);
            criteria.add(Restrictions.eq("id",id));
            mdAggregateInfo = (MdAggregateInfo) criteria.uniqueResult();

            mdAggregateInfo.setAssosiationType(mdModel.getAssositionType());
            mdAggregateInfo.setInitiativeType(mdModel.getInitiativeType());
            mdAggregateInfo.setMdIdentificationId(mdModel.getMdIdentificationId());

            session.update(mdAggregateInfo);
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
