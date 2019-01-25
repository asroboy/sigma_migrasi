/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtilXml;
import domain.MdFormat;
import java.math.BigDecimal;
import java.util.List;
import model.table.MdFormatModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Fauzy Ramedia
 */
public class MdFormatController {

    public MdFormatController() {
    }
    HibernateUtilXml hibernateUtilXml;
    Session session;

    public MdFormatController(Session session, HibernateUtilXml hibernateUtilXml) {
        this.hibernateUtilXml = hibernateUtilXml;
        this.session = session;
    }

    public BigDecimal getMaxMdFormatId() {

        BigDecimal maxId = null;

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdFormat.class);
            criteria.addOrder(Order.desc("id"));
            criteria.setMaxResults(1);
            List results = criteria.list();

            if (results.size() > 0) {
                maxId = ((MdFormat) results.get(0)).getId();
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

    public String saveMdFormat(MdFormatModel mdModel) {
        MdFormat MdFormat = new MdFormat();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            MdFormat.setId(mdModel.getId());
            MdFormat.setAmenDmentNumber(mdModel.getAmendmentNumber());
            MdFormat.setFileDecompressionTechnique(mdModel.getFileDecompressionTechnique());
            MdFormat.setName(mdModel.getName());
            MdFormat.setSpesification(mdModel.getSpesification());
            MdFormat.setVersion(mdModel.getVersion());
            MdFormat.setMdDistributionId(mdModel.getMdDistributionId());
            MdFormat.setMdDistributorId(mdModel.getMdDistributorId());
            MdFormat.setMdIdentificationId(mdModel.getMdIdentificationId());

            session.save(MdFormat);
            trx.commit();

            return "berhasil disimpan.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
    }

    public MdFormat getDataById(String column,BigDecimal Id) {

        MdFormat mdFormat = new MdFormat();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdFormat.class);
            criteria.add(Restrictions.eq(column, Id));
            mdFormat = (MdFormat) criteria.uniqueResult();

            if (mdFormat == null) {
                return null;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally {
            //session.close();
        }

        return mdFormat;
    }
    
    public String deletedMdFormat(BigDecimal Id) {

        MdFormat mdFormat = new MdFormat();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdFormat.class);
            criteria.add(Restrictions.eq("id", Id));
            mdFormat = (MdFormat) criteria.uniqueResult();

            session.delete(mdFormat);
            trx.commit();
            
            return "berhasil dihapus.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
    }

    public MdFormat getDataByProperty(BigDecimal Id, String name) {

        MdFormat mdFormat = new MdFormat();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdFormat.class);
            criteria.add(Restrictions.eq("mdIdentificationId", Id))
                    .add(Restrictions.eqOrIsNull("name", name));
            mdFormat = (MdFormat) criteria.uniqueResult();

            if (mdFormat == null) {
                return null;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally {
            //session.close();
        }

        return mdFormat;
    }

    public String updateMdFormat(BigDecimal id,MdFormatModel mdModel) {

        MdFormat mdFormat = new MdFormat();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdFormat.class);
            criteria.add(Restrictions.eq("id",id));
            mdFormat = (MdFormat) criteria.uniqueResult();

            mdFormat.setAmenDmentNumber(mdModel.getAmendmentNumber());
            mdFormat.setFileDecompressionTechnique(mdModel.getFileDecompressionTechnique());
            mdFormat.setName(mdModel.getName());
            mdFormat.setSpesification(mdModel.getSpesification());
            mdFormat.setVersion(mdModel.getVersion());
            mdFormat.setMdDistributionId(mdModel.getMdDistributionId());
            mdFormat.setMdDistributorId(mdModel.getMdDistributorId());
            mdFormat.setMdIdentificationId(mdModel.getMdIdentificationId());
                    
            session.update(mdFormat);
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