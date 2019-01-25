/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtil;
import config.HibernateUtilXml;
import domain.CiOnlineResource;
import domain.MdExtendedElementInfoParent;
import java.math.BigDecimal;
import java.util.List;
import model.table.CiOnlineResourceModel;
import model.table.MdExtendedElementInfoParentModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Fauzy Ramedia
 */
public class MdExtendedElementInfoParentController {
    
    Session session;
    HibernateUtilXml hibernateUtilXml;

    public MdExtendedElementInfoParentController(Session session, HibernateUtilXml hibernateUtilXml) {
        this.session = session;
        this.hibernateUtilXml = hibernateUtilXml;
    }
        
    public MdExtendedElementInfoParent getDataById(BigDecimal Id) {

        MdExtendedElementInfoParent info = new MdExtendedElementInfoParent();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdExtendedElementInfoParent.class);
            criteria.add(Restrictions.eq("mdExtendedElementInfoId", Id));
            info = (MdExtendedElementInfoParent) criteria.uniqueResult();

            if (info== null) {
                return null;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally {
            //session.close();
        }

        return info;
    }
    
    public String deleteMdExtendedElementInfoParent(BigDecimal Id) {

        MdExtendedElementInfoParent info = new MdExtendedElementInfoParent();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdExtendedElementInfoParent.class);
            criteria.add(Restrictions.eq("mdExtendedElementInfoId", Id));
            info = (MdExtendedElementInfoParent) criteria.uniqueResult();

            session.delete(info);
            trx.commit();
            
            return "berhasil dihapus......!!";

        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
      
    }

    public String saveMdExtendedElementInfoParentParent(MdExtendedElementInfoParentModel mdModel) {
        
        MdExtendedElementInfoParent parent = new MdExtendedElementInfoParent();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();
        
        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            parent.setMdExtendedElementInfoId(mdModel.getMdExtendedElementInfoId());
            parent.setParentEntity(mdModel.getParentEntity());

            session.save(parent);
            trx.commit();

            return "berhasil disimpan.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
    }
    
    public String updateMdExtendedElementInfoParent(BigDecimal id,MdExtendedElementInfoParentModel mdModel) {

        MdExtendedElementInfoParent info = new MdExtendedElementInfoParent();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdExtendedElementInfoParent.class);
            criteria.add(Restrictions.eq("id", id));
            info = (MdExtendedElementInfoParent) criteria.uniqueResult();
            
            info.setParentEntity(mdModel.getParentEntity());

            session.update(info);
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
