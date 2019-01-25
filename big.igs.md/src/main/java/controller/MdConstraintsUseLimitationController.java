/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtil;
import config.HibernateUtilXml;
import domain.MdConstraintsUseLimitation;
import java.math.BigDecimal;
import model.table.MdConstraintsUselimitationModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author wallet
 */
public class MdConstraintsUseLimitationController {
    
    HibernateUtilXml hibernateUtilXml;
    Session session;

    public MdConstraintsUseLimitationController() {
    }

    public MdConstraintsUseLimitationController(Session session, HibernateUtilXml hibernateUtilXml) {
        this.hibernateUtilXml = hibernateUtilXml;
        this.session = session;
    }

    public MdConstraintsUseLimitation getDataById(BigDecimal Id) {

        MdConstraintsUseLimitation mdConstraints = new MdConstraintsUseLimitation();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdConstraintsUseLimitation.class);
            criteria.add(Restrictions.eq("mdConstraintsId", Id));
            mdConstraints = (MdConstraintsUseLimitation) criteria.uniqueResult();

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
    
    public String deletedMdConstraintsUseLimitation(BigDecimal Id) {

        MdConstraintsUseLimitation mdConstraints = new MdConstraintsUseLimitation();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdConstraintsUseLimitation.class);
            criteria.add(Restrictions.eq("mdConstraintsId", Id));
            mdConstraints = (MdConstraintsUseLimitation) criteria.uniqueResult();

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

    public String saveMdConstraintsUseLimitation(MdConstraintsUselimitationModel mdConstraintsUselimitationModel) {

        MdConstraintsUseLimitation mdConstraintsUselimitation = new MdConstraintsUseLimitation();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            mdConstraintsUselimitation.setMdConstraintsId(mdConstraintsUselimitationModel.getMdConstraintsId());
            mdConstraintsUselimitation.setUseLimitation(mdConstraintsUselimitationModel.getUseLimitation());

            session.save(mdConstraintsUselimitation);
            trx.commit();

            return "berhasil disimpan.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
    }

    public String updateMdConstraintsUseLimitation(BigDecimal id,MdConstraintsUselimitationModel mdModel) {

        MdConstraintsUseLimitation mdConstraints = new MdConstraintsUseLimitation();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdConstraintsUseLimitation.class);
            criteria.add(Restrictions.eq("id",id));
            mdConstraints = (MdConstraintsUseLimitation) criteria.uniqueResult();
            
            mdConstraints.setUseLimitation(mdModel.getUseLimitation());

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

}
