/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtilXml;
import domain.MdLegalConstraintsOther;
import java.math.BigDecimal;
import model.table.MdLegalConstraintsOtherModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
/**
 *
 * @author Fauzy Ramedia
 */
public class MdLegalConstraintsOtherController {
    
    
    HibernateUtilXml hibernateUtilXml;
    Session session;

    public MdLegalConstraintsOtherController(Session session,HibernateUtilXml hibernateUtilXml) {
        this.hibernateUtilXml = hibernateUtilXml;
        this.session = session;

    }

    public String saveMdLegalConstraintsOther(MdLegalConstraintsOtherModel mdModel) {
        MdLegalConstraintsOther MdLegalConstraintsOther = new MdLegalConstraintsOther();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            MdLegalConstraintsOther.setMdLegalConstraintsId(mdModel.getMdLegalConstraintsId());
            MdLegalConstraintsOther.setOtherContraints(mdModel.getOtherConstraints());

            session.save(MdLegalConstraintsOther);
            trx.commit();

            return "berhasil disimpan.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
    }
    
    public MdLegalConstraintsOther getDataById(BigDecimal id) {

        MdLegalConstraintsOther md = new MdLegalConstraintsOther();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdLegalConstraintsOther.class);
            criteria.add(Restrictions.eq("mdLegalConstraintsId", id));
            md = (MdLegalConstraintsOther) criteria.uniqueResult();

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
    
    public String updateMdLegalConstraintsOther(BigDecimal id,MdLegalConstraintsOtherModel mdModel) {

        MdLegalConstraintsOther md = new MdLegalConstraintsOther();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdLegalConstraintsOther.class);
            criteria.add(Restrictions.eq("mdLegalConstraintsId", id));
            md = (MdLegalConstraintsOther) criteria.uniqueResult();

            md.setOtherContraints(mdModel.getOtherConstraints());
            
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
    
    public String deletedMdLegalConstraintsOther(BigDecimal Id) {

        MdLegalConstraintsOther md = new MdLegalConstraintsOther();        

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdLegalConstraintsOther.class);
            criteria.add(Restrictions.eq("mdLegalConstraintsId", Id));
            md = (MdLegalConstraintsOther) criteria.uniqueResult();

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
