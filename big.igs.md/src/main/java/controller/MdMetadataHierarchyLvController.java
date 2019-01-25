/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtil;
import config.HibernateUtilXml;
import domain.MdMetadataHierarchylv;
import java.math.BigDecimal;
import model.table.MdMetadataHierarchylvModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author USER DELL
 */
public class MdMetadataHierarchyLvController {

    public MdMetadataHierarchyLvController() {

    }
    HibernateUtilXml hibernateUtilXml;
    Session session;

    public MdMetadataHierarchyLvController(Session session, HibernateUtilXml hibernateUtilXml) {
        this.hibernateUtilXml = hibernateUtilXml;
        this.session = session;
    }

    public MdMetadataHierarchylv getDataById(BigDecimal Id,String code) {
        MdMetadataHierarchylv mdHierarchyLv = new MdMetadataHierarchylv();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdMetadataHierarchylv.class);
            criteria.add(Restrictions.eq(MdMetadataHierarchylvModel.MD_METADATAID, Id))
                    .add(Restrictions.eqOrIsNull(MdMetadataHierarchylvModel.HIERARCYLEVEL, code));
            mdHierarchyLv = (MdMetadataHierarchylv) criteria.uniqueResult();

            if (mdHierarchyLv == null) {
                return null;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally {
            //session.close();
        }

        return mdHierarchyLv;
    }
    
    public MdMetadataHierarchylv getDataById(BigDecimal Id) {
        MdMetadataHierarchylv mdHierarchyLv = new MdMetadataHierarchylv();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdMetadataHierarchylv.class);
            criteria.add(Restrictions.eq(MdMetadataHierarchylvModel.MD_METADATAID, Id));
            mdHierarchyLv = (MdMetadataHierarchylv) criteria.uniqueResult();

            if (mdHierarchyLv == null) {
                return null;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally {
            //session.close();
        }

        return mdHierarchyLv;
    }

    public MdMetadataHierarchylv getDataByCode(String HierarchyLv) {
        MdMetadataHierarchylv mdHierarchyLv = new MdMetadataHierarchylv();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdMetadataHierarchylv.class);
            criteria.add(Restrictions.eq("mdMetadataid", HierarchyLv));
            mdHierarchyLv = (MdMetadataHierarchylv) criteria.uniqueResult();

            if (mdHierarchyLv == null) {
                return null;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally {
            //session.close();
        }

        return mdHierarchyLv;
    }

    public String saveMdMetadataHierarchyLv(MdMetadataHierarchylvModel mdModel) {
        MdMetadataHierarchylv mdHierarchyLv = new MdMetadataHierarchylv();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            mdHierarchyLv.setMdMetadataid(mdModel.getMdMetadataid());
            mdHierarchyLv.setHierarchylevel(mdModel.getHierarchylevel());

            session.save(mdHierarchyLv);
            trx.commit();

            return "berhasil disimpan.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
    }

    public String updateMdMetadataHierarchyLv(MdMetadataHierarchylvModel mdModel) {
        MdMetadataHierarchylv mdHierarchyLv = new MdMetadataHierarchylv();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdMetadataHierarchylv.class);
            criteria.add(Restrictions.eq(MdMetadataHierarchylvModel.MD_METADATAID, mdModel.getMdMetadataid()));
            mdHierarchyLv = (MdMetadataHierarchylv) criteria.uniqueResult();

            mdHierarchyLv.setHierarchylevel(mdModel.getHierarchylevel());

            session.update(mdHierarchyLv);
            trx.commit();

            return "berhasil diubah.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
    }
    
    public String deleteMdMetadataHierarchyLv(BigDecimal Id) {
        
        MdMetadataHierarchylv mdHierarchyLv = new MdMetadataHierarchylv();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdMetadataHierarchylv.class);
            criteria.add(Restrictions.eq("mdMetadataid", Id));
            mdHierarchyLv = (MdMetadataHierarchylv) criteria.uniqueResult();

            session.delete(mdHierarchyLv);
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
