/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtil;
import config.HibernateUtilXml;
import domain.MdLegalConstraints;
import domain.MdLegalConstraints;
import java.math.BigDecimal;
import java.util.List;
import model.table.MdLegalConstraintsModel;
import model.table.MdLegalConstraintsModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Fauzy Ramedia
 */
public class MdLegalConstraintsController {

    HibernateUtilXml hibernateUtilXml;
    Session session;

    public MdLegalConstraintsController(Session session,HibernateUtilXml hibernateUtilXml) {
        this.hibernateUtilXml = hibernateUtilXml;
        this.session = session;

    }

    public String saveMdLegalConstraints(MdLegalConstraintsModel mdModel) {
        MdLegalConstraints MdLegalConstraints = new MdLegalConstraints();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            MdLegalConstraints.setMdConstraintsId(mdModel.getMdConstraintsId());

            session.save(MdLegalConstraints);
            trx.commit();

            return "berhasil disimpan.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
    }
    
    public MdLegalConstraints getDataById(BigDecimal id) {

        MdLegalConstraints md = new MdLegalConstraints();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdLegalConstraints.class);
            criteria.add(Restrictions.eq("mdConstraintsId", id));
            md = (MdLegalConstraints) criteria.uniqueResult();

            if (md == null) {
                return null;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally {
            //session.close();
        }

        return md;
    }
    
    public String updateMdLegalConstraints(BigDecimal id,MdLegalConstraintsModel mdModel) {

        MdLegalConstraints md = new MdLegalConstraints();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdLegalConstraints.class);
            criteria.add(Restrictions.eq("mdConstraintsId", id));
            md = (MdLegalConstraints) criteria.uniqueResult();

            md.setMdConstraintsId(mdModel.getMdConstraintsId());
            
            session.update(md);
            trx.commit();

            return "berhasil diubah.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
    }
    
    public String deletedMdLegalConstraints(BigDecimal Id) {

        MdLegalConstraints md = new MdLegalConstraints();        

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdLegalConstraints.class);
            criteria.add(Restrictions.eq("mdConstraintsId", Id));
            md = (MdLegalConstraints) criteria.uniqueResult();

            session.delete(md);
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
