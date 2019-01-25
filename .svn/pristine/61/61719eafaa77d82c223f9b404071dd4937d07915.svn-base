/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtilXml;
import domain.MdVectorSpatialRepresentation;
import java.math.BigDecimal;
import java.util.List;
import model.table.MdVectorSpatialRepresentationModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Fauzy Ramedia
 */
public class MdVectorSpatialRepresentationController {

    public MdVectorSpatialRepresentationController() {
    }
    HibernateUtilXml hibernateUtilXml;
    Session session;

    public MdVectorSpatialRepresentationController(Session session, HibernateUtilXml hibernateUtilXml) {
        this.hibernateUtilXml = hibernateUtilXml;
        this.session = session;
    }

    public BigDecimal getMaxMdVectorSpatialRepresentationId() {

        BigDecimal maxId = null;

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdVectorSpatialRepresentation.class);
            criteria.addOrder(Order.desc("id"));
            criteria.setMaxResults(1);
            List results = criteria.list();

            if (results.size() > 0) {
                maxId = ((MdVectorSpatialRepresentation) results.get(0)).getId();
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

    public MdVectorSpatialRepresentation getDataByProperty(BigDecimal Id, String code) {

        MdVectorSpatialRepresentation mdVectorSpatialRepresentation = new MdVectorSpatialRepresentation();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdVectorSpatialRepresentation.class);
            criteria.add(Restrictions.eq("id", Id))
                    .add(Restrictions.eq("topologyLevel", code));

            mdVectorSpatialRepresentation = (MdVectorSpatialRepresentation) criteria.uniqueResult();

            if (mdVectorSpatialRepresentation == null) {
                return null;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally {
            //session.close();
        }

        return mdVectorSpatialRepresentation;
    }

    public MdVectorSpatialRepresentation getDataById(BigDecimal Id,String code) {

        MdVectorSpatialRepresentation mdVectorSpatialRepresentation = new MdVectorSpatialRepresentation();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdVectorSpatialRepresentation.class);
            criteria.add(Restrictions.eq("id", Id))
                    .add(Restrictions.eq(MdVectorSpatialRepresentationModel.TOPOLOGY_LEVEL, code));

            mdVectorSpatialRepresentation = (MdVectorSpatialRepresentation) criteria.uniqueResult();

            if (mdVectorSpatialRepresentation == null) {
                return null;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally {
            //session.close();
        }

        return mdVectorSpatialRepresentation;
    }
    
    public MdVectorSpatialRepresentation getDataById(BigDecimal Id) {

        MdVectorSpatialRepresentation mdVectorSpatialRepresentation = new MdVectorSpatialRepresentation();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdVectorSpatialRepresentation.class);
            criteria.add(Restrictions.eq("id", Id));

            mdVectorSpatialRepresentation = (MdVectorSpatialRepresentation) criteria.uniqueResult();

            if (mdVectorSpatialRepresentation == null) {
                return null;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally {
            //session.close();
        }

        return mdVectorSpatialRepresentation;
    }

    public MdVectorSpatialRepresentation getDataByProperty(String code) {

        MdVectorSpatialRepresentation mdVectorSpatialRepresentation = new MdVectorSpatialRepresentation();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdVectorSpatialRepresentation.class);
            criteria.add(Restrictions.eq("topologyLevel", code));

            mdVectorSpatialRepresentation = (MdVectorSpatialRepresentation) criteria.uniqueResult();

            if (mdVectorSpatialRepresentation == null) {
                return null;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally {
            //session.close();
        }

        return mdVectorSpatialRepresentation;
    }

    public String saveMdVectorSpatialRepresentation(MdVectorSpatialRepresentationModel mdModel) {
        MdVectorSpatialRepresentation MdVectorSpatialRepresentation = new MdVectorSpatialRepresentation();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            MdVectorSpatialRepresentation.setId(mdModel.getId());
            MdVectorSpatialRepresentation.setTopologyLevel(mdModel.getTopologyLevel());

            session.save(MdVectorSpatialRepresentation);
            trx.commit();

            return "berhasil disimpan.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
    }

    public String updateMdVectorSpatialRepresentation(BigDecimal id,MdVectorSpatialRepresentationModel mdModel) {

        MdVectorSpatialRepresentation mdVectorSpatialRepresentation = new MdVectorSpatialRepresentation();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdVectorSpatialRepresentation.class);
            criteria.add(Restrictions.eq("id",id));

            mdVectorSpatialRepresentation = (MdVectorSpatialRepresentation) criteria.uniqueResult();

            mdVectorSpatialRepresentation.setTopologyLevel(mdModel.getTopologyLevel());

            session.update(mdVectorSpatialRepresentation);
            trx.commit();

            return "berhasil diubah.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
    }
    
    public String deletedMdVectorSpatialRepresentation(BigDecimal Id) {

        MdVectorSpatialRepresentation mdVectorSpatialRepresentation = new MdVectorSpatialRepresentation();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdVectorSpatialRepresentation.class);
            criteria.add(Restrictions.eq("id", Id));

            mdVectorSpatialRepresentation = (MdVectorSpatialRepresentation) criteria.uniqueResult();

            session.delete(mdVectorSpatialRepresentation);
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
