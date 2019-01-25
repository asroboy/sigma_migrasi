/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtilXml;
import domain.RsIdentifier;
import java.math.BigDecimal;
import java.util.List;
import model.table.RsIdentifierModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Fauzy Ramedia
 */
public class RsIdentifierController {

    public RsIdentifierController() {
    }

    HibernateUtilXml hibernateUtilXml;
    Session session;

    public RsIdentifierController(Session session, HibernateUtilXml hibernateUtilXml) {
        this.hibernateUtilXml = hibernateUtilXml;
        this.session = session;
    }

    public BigDecimal getMaxRsIdentifierId() {

        BigDecimal maxId = null;

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(RsIdentifier.class);
            criteria.addOrder(Order.desc("id"));
            criteria.setMaxResults(1);
            List results = criteria.list();

            if (results.size() > 0) {
                maxId = ((RsIdentifier) results.get(0)).getId();
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

    public RsIdentifier getDataById(String column,BigDecimal Id) {

        RsIdentifier rsIdentifier = new RsIdentifier();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(RsIdentifier.class);
            criteria.add(Restrictions.eq(column, Id));
            rsIdentifier = (RsIdentifier) criteria.uniqueResult();

            if (rsIdentifier == null) {
                return null;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally {
            //session.close();
        }

        return rsIdentifier;
    }
    
    public String deletedRsIdentifier(BigDecimal Id) {

        RsIdentifier rsIdentifier = new RsIdentifier();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(RsIdentifier.class);
            criteria.add(Restrictions.eq("id", Id));
            rsIdentifier = (RsIdentifier) criteria.uniqueResult();

            session.delete(rsIdentifier);
            trx.commit();
            
            return "berhasil dihapus.....!!";         
  
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }

    }

    public RsIdentifier getDataByProperty(BigDecimal Id, String codespace) {

        RsIdentifier rsIdentifier = new RsIdentifier();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(RsIdentifier.class);
            criteria.add(Restrictions.eq("mdReferenceSystemId", Id))
                    .add(Restrictions.eq("codeSpace", codespace));

            rsIdentifier = (RsIdentifier) criteria.uniqueResult();

            if (rsIdentifier == null) {
                return null;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally {
            //session.close();
        }

        return rsIdentifier;
    }

    public String saveRsIdentifier(RsIdentifierModel mdModel) {
        RsIdentifier RsIdentifier = new RsIdentifier();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            RsIdentifier.setId(mdModel.getId());
            RsIdentifier.setVersion(mdModel.getVersion());
            RsIdentifier.setCodeSpace(mdModel.getCodeSpace());
            RsIdentifier.setCode(mdModel.getCode());
            RsIdentifier.setMdReferenceSystemId(mdModel.getMdReferenceSystemId());
            RsIdentifier.setMdIdentifierId(mdModel.getMdIdentifierId());

            session.save(RsIdentifier);
            trx.commit();

            return "berhasil disimpan.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
    }

    public String updateRsIdentifier(BigDecimal id,RsIdentifierModel mdModel) {

        RsIdentifier rsIdentifier = new RsIdentifier();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(RsIdentifier.class);
            criteria.add(Restrictions.eq("id", id));
            rsIdentifier = (RsIdentifier) criteria.uniqueResult();

            rsIdentifier.setCodeSpace(mdModel.getCodeSpace());
            rsIdentifier.setCode(mdModel.getCode());
            rsIdentifier.setVersion(mdModel.getVersion());
            rsIdentifier.setMdReferenceSystemId(mdModel.getMdReferenceSystemId());
            rsIdentifier.setMdIdentifierId(mdModel.getMdIdentifierId());

            session.update(rsIdentifier);
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
