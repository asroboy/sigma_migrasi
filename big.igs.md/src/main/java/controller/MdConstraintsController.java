/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtilXml;
import java.math.BigDecimal;
import java.util.List;
import model.table.MdConstraintsModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author wallet
 */
public class MdConstraintsController {

    public MdConstraintsController() {
    }

    HibernateUtilXml hibernateUtilXml;
    Session session;

    public MdConstraintsController(Session session, HibernateUtilXml hibernateUtilXml) {
        this.hibernateUtilXml = hibernateUtilXml;
        this.session = session;
    }

    public BigDecimal getMaxMdConstraintsId() {

        BigDecimal maxId = null;

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(domain.MdConstraints.class);
            criteria.addOrder(Order.desc("id"));
            criteria.setMaxResults(1);
            List results = criteria.list();

            if (results.size() > 0) {
                maxId = ((domain.MdConstraints) results.get(0)).getId();
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
    
    public domain.MdConstraints getDataById(String column,BigDecimal Id) {

        domain.MdConstraints mdConstraints = new domain.MdConstraints();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(domain.MdConstraints.class);
            criteria.add(Restrictions.eq(column, Id));
            mdConstraints = (domain.MdConstraints) criteria.uniqueResult();

            if (mdConstraints == null) {
                return null;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally {
            //session.close();
        }

        return mdConstraints;
    }
    
    public String deletedMdConstraints(BigDecimal id) {

        domain.MdConstraints mdConstraints = new domain.MdConstraints();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(domain.MdConstraints.class);
            criteria.add(Restrictions.eq("id", id));
            mdConstraints = (domain.MdConstraints) criteria.uniqueResult();

            session.delete(mdConstraints);
            trx.commit();
            
            return "berhasil dihapus.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
    }

    public String saveMdConstraints(MdConstraintsModel mdModel) {

        domain.MdConstraints mdConstraints = new domain.MdConstraints();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            mdConstraints.setId(mdModel.getId());
            mdConstraints.setExtendsType(mdModel.getExtendsType());
            mdConstraints.setMdIdentificationId(mdModel.getMdIdentificationId());
            mdConstraints.setMdMetadataId(mdModel.getMdMetadataId());
            mdConstraints.setSvServiceIdentificationId(mdModel.getSvServiceidentificationId());

            session.save(mdConstraints);
            trx.commit();

            return "berhasil disimpan.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
    }

    public String updateMdConstraints(BigDecimal id,MdConstraintsModel mdModel) {

        domain.MdConstraints mdConstraints = new domain.MdConstraints();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(domain.MdConstraints.class);
            criteria.add(Restrictions.eq("id", id));
            mdConstraints = (domain.MdConstraints) criteria.uniqueResult();

            mdConstraints.setExtendsType(mdModel.getExtendsType());
            mdConstraints.setMdIdentificationId(mdModel.getMdIdentificationId());
            mdConstraints.setMdMetadataId(mdModel.getMdMetadataId());
            mdConstraints.setSvServiceIdentificationId(mdModel.getSvServiceidentificationId());

            session.update(mdConstraints);
            trx.commit();

            return "berhasil diubah.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
    }
    
    public String updateMdConstraintsByIdMetadata(MdConstraintsModel mdModel) {

        domain.MdConstraints mdConstraints = new domain.MdConstraints();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(domain.MdConstraints.class);
            criteria.add(Restrictions.eq("mdMetadataId", mdModel.getMdMetadataId()));
            mdConstraints = (domain.MdConstraints) criteria.uniqueResult();

            mdConstraints.setExtendsType(mdModel.getExtendsType());
            mdConstraints.setMdIdentificationId(mdModel.getMdIdentificationId());
            mdConstraints.setMdMetadataId(mdModel.getMdMetadataId());
            mdConstraints.setSvServiceIdentificationId(mdModel.getSvServiceidentificationId());

            session.update(mdConstraints);
            trx.commit();

            return "updated successfully.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
    }

}
