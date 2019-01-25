/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtil;
import config.HibernateUtilXml;
import domain.MdSecurityConstraints;
import domain.MdUploadFile;
import domain.SvServiceIdentification;
import java.math.BigDecimal;
import java.util.List;
import model.table.MdSecurityConstraintsModel;
import model.table.SvServiceIdentificationModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Fauzy Ramedia
 */
public class MdSecurityConstraintsController {
 
    HibernateUtilXml hibernateUtilXml;
    Session session;

    public MdSecurityConstraintsController(Session session,HibernateUtilXml hibernateUtilXml) {
        this.hibernateUtilXml = hibernateUtilXml;
        this.session = session;

    }

    public String saveMdSecurityConstraints(MdSecurityConstraintsModel mdModel) {
        MdSecurityConstraints MdSecurityConstraints = new MdSecurityConstraints();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            MdSecurityConstraints.setClassificationSystem(mdModel.getClassificationSystem());
            MdSecurityConstraints.setHandlingDescription(mdModel.getHandlingDescription());
            MdSecurityConstraints.setUserNote(mdModel.getUserNote());
            MdSecurityConstraints.setMdConstraintsId(mdModel.getMdConstraintsId());
            MdSecurityConstraints.setClassification(mdModel.getClassification());

            session.save(MdSecurityConstraints);
            trx.commit();

            return "berhasil disimpan.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
    }
    
    public MdSecurityConstraints getDataById(BigDecimal id) {

        MdSecurityConstraints md = new MdSecurityConstraints();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdSecurityConstraints.class);
            criteria.add(Restrictions.eq("mdConstraintsId", id));
            md = (MdSecurityConstraints) criteria.uniqueResult();

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
    
    public String updateMdSecurityConstraints(BigDecimal id,MdSecurityConstraintsModel mdModel) {

        MdSecurityConstraints md = new MdSecurityConstraints();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdSecurityConstraints.class);
            criteria.add(Restrictions.eq("mdConstraintsId", id));
            md = (MdSecurityConstraints) criteria.uniqueResult();

            md.setClassificationSystem(mdModel.getClassificationSystem());
            md.setHandlingDescription(mdModel.getHandlingDescription());
            md.setUserNote(mdModel.getUserNote());
            md.setClassification(mdModel.getClassification());

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
    
    public String deletedMdSecurityConstraints(BigDecimal Id) {

        MdSecurityConstraints md = new MdSecurityConstraints();        

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdSecurityConstraints.class);
            criteria.add(Restrictions.eq("mdConstraintsId", Id));
            md = (MdSecurityConstraints) criteria.uniqueResult();

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
