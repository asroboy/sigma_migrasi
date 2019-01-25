/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtil;
import config.HibernateUtilXml;
import domain.CiTelephone;
import domain.MdIdentifier;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import model.table.CiTelephoneModel;
import model.table.MdIdentifierModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Fauzy Ramedia
 */
public class MdIdentifierController {

    public MdIdentifierController() {
    }

    HibernateUtilXml hibernateUtilXml;
    Session session;

    public MdIdentifierController(Session session, HibernateUtilXml hibernateUtilXml) {
        this.hibernateUtilXml = hibernateUtilXml;
        this.session = session;
    }

    public BigDecimal getMaxMdIdentifierId() {

        BigDecimal maxId = null;

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdIdentifier.class);
            criteria.addOrder(Order.desc("id"));
            criteria.setMaxResults(1);
            List results = criteria.list();

            if (results.size() > 0) {
                maxId = ((MdIdentifier) results.get(0)).getId();
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

    public MdIdentifier getDataById(String column,BigDecimal Id) {

        MdIdentifier mdIdentifier = new MdIdentifier();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdIdentifier.class);
            criteria.add(Restrictions.eq(column, Id));
            mdIdentifier = (MdIdentifier) criteria.uniqueResult();

            if (mdIdentifier == null) {
                return null;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally {
            //session.close();
        }

        return mdIdentifier;
    }
        
    public String deletedMdIdentifier(BigDecimal Id) {

        MdIdentifier mdIdentifier = new MdIdentifier();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdIdentifier.class);
            criteria.add(Restrictions.eq("id", Id));
            mdIdentifier = (MdIdentifier) criteria.uniqueResult();

            session.delete(mdIdentifier);
            trx.commit();
            
            return "berhasil dihapus.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
    }

    public String saveMdIdentifier(MdIdentifierModel mdModel) {
        MdIdentifier MdIdentifier = new MdIdentifier();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            MdIdentifier.setId(mdModel.getId());
            MdIdentifier.setExtendsType(mdModel.getExtendsType());
            MdIdentifier.setCode(mdModel.getCode());
            MdIdentifier.setDqElementId(mdModel.getDqElementId());
            MdIdentifier.setCiCitationId(mdModel.getCiCitationId());
            MdIdentifier.setExGeographicDescriptionId(mdModel.getExGeographicDescriptionId());
            MdIdentifier.setMdAggregateInfoId(mdModel.getMdAggregationInfoId());
            MdIdentifier.setMdImageDescriptionIqc(mdModel.getMdImageDescriptionIdIqc());
            MdIdentifier.setMdImageDescriptionPlc(mdModel.getMdImageDescriptionIdPlc());

            session.save(MdIdentifier);
            trx.commit();

            return "berhasil disimpan.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
    }

    public String updateMdIdentifier(BigDecimal id,MdIdentifierModel mdModel) {

        MdIdentifier mdIdentifier = new MdIdentifier();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdIdentifier.class);
            criteria.add(Restrictions.eq("id",id));
            mdIdentifier = (MdIdentifier) criteria.uniqueResult();

            mdIdentifier.setExtendsType(mdModel.getExtendsType());
            mdIdentifier.setCode(mdModel.getCode());
            mdIdentifier.setDqElementId(mdModel.getDqElementId());
            mdIdentifier.setCiCitationId(mdModel.getCiCitationId());
            mdIdentifier.setExGeographicDescriptionId(mdModel.getExGeographicDescriptionId());
            mdIdentifier.setMdAggregateInfoId(mdModel.getMdAggregationInfoId());
            mdIdentifier.setMdImageDescriptionIqc(mdModel.getMdImageDescriptionIdIqc());
            mdIdentifier.setMdImageDescriptionPlc(mdModel.getMdImageDescriptionIdPlc());

            session.update(mdIdentifier);
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
