/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtilXml;
import domain.MdPortrayalCatalogueRef;
import java.math.BigDecimal;
import java.util.List;
import model.table.MdPortrayalCatalogueRefModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Fauzy Ramedia
 */
public class MdPortrayalCatalogueRefController {

    public MdPortrayalCatalogueRefController() {
    }

    HibernateUtilXml hibernateUtilXml;
    Session session;

    public MdPortrayalCatalogueRefController(Session session, HibernateUtilXml hibernateUtilXml) {
        this.hibernateUtilXml = hibernateUtilXml;
        this.session = session;
    }

    public BigDecimal getMaxMdPortrayalCatalogueRefId() {
        BigDecimal maxId = null;

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdPortrayalCatalogueRef.class);
            criteria.addOrder(Order.desc("id"));
            criteria.setMaxResults(1);
            List results = criteria.list();

            if (results.size() > 0) {
                maxId = ((MdPortrayalCatalogueRef) results.get(0)).getId();
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

    public MdPortrayalCatalogueRef getDataById(BigDecimal Id) {

        MdPortrayalCatalogueRef mdPortrayalCatalogueRef = new MdPortrayalCatalogueRef();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdPortrayalCatalogueRef.class);
            criteria.add(Restrictions.eq("mdMetadataId", Id));
            mdPortrayalCatalogueRef = (MdPortrayalCatalogueRef) criteria.uniqueResult();

            if (mdPortrayalCatalogueRef == null) {
                return null;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally {
            //session.close();
        }

        return mdPortrayalCatalogueRef;
    }

    public String deletedMdPortrayalCatalogueRef(BigDecimal Id) {

        MdPortrayalCatalogueRef mdPortrayalCatalogueRef = new MdPortrayalCatalogueRef();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdPortrayalCatalogueRef.class);
            criteria.add(Restrictions.eq("id", Id));
            mdPortrayalCatalogueRef = (MdPortrayalCatalogueRef) criteria.uniqueResult();

            session.delete(mdPortrayalCatalogueRef);
            trx.commit();
            
            return "berhasil dihapus......!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
    }

     
    public String saveMdPortrayalCatalogueRef(MdPortrayalCatalogueRefModel mdModel) {
        MdPortrayalCatalogueRef MdPortrayalCatalogueRef = new MdPortrayalCatalogueRef();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            MdPortrayalCatalogueRef.setId(mdModel.getId());
            MdPortrayalCatalogueRef.setMdMetadataId(mdModel.getMdMetadataId());

            session.save(MdPortrayalCatalogueRef);
            trx.commit();

            return "berhasil disimpan.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
    }

    public String updateMdPortyalCatalagueRef(BigDecimal id,MdPortrayalCatalogueRefModel mdModel) {

        MdPortrayalCatalogueRef mdPortrayalCatalogueRef = new MdPortrayalCatalogueRef();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdPortrayalCatalogueRef.class);
            criteria.add(Restrictions.eq("id", id));
            mdPortrayalCatalogueRef = (MdPortrayalCatalogueRef) criteria.uniqueResult();

            //MdPortrayalCatalogueRef.setId(mdModel.getId());
            mdPortrayalCatalogueRef.setMdMetadataId(mdModel.getMdMetadataId());

            session.update(mdPortrayalCatalogueRef);
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
