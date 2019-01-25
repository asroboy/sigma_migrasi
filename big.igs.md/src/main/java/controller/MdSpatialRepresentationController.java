/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtilXml;
import domain.MdSpatialRepresentation;
import java.math.BigDecimal;
import java.util.List;
import model.table.MdSpatialRepresentationModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Fauzy Ramedia
 */
public class MdSpatialRepresentationController {

    public MdSpatialRepresentationController() {
    }

    HibernateUtilXml hibernateUtilXml;
    Session session;

    public MdSpatialRepresentationController(Session session, HibernateUtilXml hibernateUtilXml) {
        this.hibernateUtilXml = hibernateUtilXml;
        this.session = session;
    }

    public BigDecimal getMaxMdSpatialRepresentationId() {

        BigDecimal maxId = null;

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdSpatialRepresentation.class);
            criteria.addOrder(Order.desc("id"));
            criteria.setMaxResults(1);
            List results = criteria.list();

            if (results.size() > 0) {
                maxId = ((MdSpatialRepresentation) results.get(0)).getId();
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

    public MdSpatialRepresentation getDataById(BigDecimal Id) {

        MdSpatialRepresentation mdSpatialRepresentation = new MdSpatialRepresentation();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdSpatialRepresentation.class);
            criteria.add(Restrictions.eq("mdMetadataId", Id));

            mdSpatialRepresentation = (MdSpatialRepresentation) criteria.uniqueResult();

            if (mdSpatialRepresentation == null) {
                return null;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally {
            //session.close();
        }

        return mdSpatialRepresentation;
    }

    public String saveMdSpatialRepresentation(MdSpatialRepresentationModel mdModel) {
        MdSpatialRepresentation mdSpatialRepresentation = new MdSpatialRepresentation();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            mdSpatialRepresentation.setId(mdModel.getId());
            mdSpatialRepresentation.setExtendsType(mdModel.getExtendsType());
            mdSpatialRepresentation.setMdMetadataId(mdModel.getMdMetadataId());

            session.save(mdSpatialRepresentation);
            trx.commit();

            return "berhasil disimpan.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
    }

    public String updateMdSpatialRepresentation(BigDecimal id,MdSpatialRepresentationModel mdModel) {

        MdSpatialRepresentation mdSpatialRepresentation = new MdSpatialRepresentation();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdSpatialRepresentation.class);
            criteria.add(Restrictions.eq("id", id));
            mdSpatialRepresentation = (MdSpatialRepresentation) criteria.uniqueResult();

            mdSpatialRepresentation.setExtendsType(mdModel.getExtendsType());
            mdSpatialRepresentation.setMdMetadataId(mdModel.getMdMetadataId());

            session.update(mdSpatialRepresentation);
            trx.commit();

            return "berhasil diubah.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
    }
    
    public String deletedMdSpatialRepresentation(BigDecimal Id) {

        MdSpatialRepresentation mdSpatialRepresentation = new MdSpatialRepresentation();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdSpatialRepresentation.class);
            criteria.add(Restrictions.eq("id", Id));

            mdSpatialRepresentation = (MdSpatialRepresentation) criteria.uniqueResult();

            session.delete(mdSpatialRepresentation);
            trx.commit();
            
             return "berhasil dihapus.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
    }

}
