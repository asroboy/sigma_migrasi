/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtilXml;
import domain.MdMetadataHierarchylv;
import domain.MdMetadataHierarchylvName;
import java.math.BigDecimal;
import model.table.MdMetadataHierarchylvNameModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author USER DELL
 */
public class MdMetadataHierarchyLvNameController {

    public MdMetadataHierarchyLvNameController() {
    }
    HibernateUtilXml hibernateUtilXml;
    Session session;

    public MdMetadataHierarchyLvNameController(Session session, HibernateUtilXml hibernateUtilXml) {
        this.hibernateUtilXml = hibernateUtilXml;
        this.session = session;
    }

    public MdMetadataHierarchylvName getDataById(BigDecimal Id) {
        MdMetadataHierarchylvName mdHierarchyLv = new MdMetadataHierarchylvName();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdMetadataHierarchylvName.class);
            criteria.add(Restrictions.eq(MdMetadataHierarchylvNameModel.MD_METADATAID, Id));
            mdHierarchyLv = (MdMetadataHierarchylvName) criteria.uniqueResult();

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

    public MdMetadataHierarchylvName getDataByCode(String HierarchyLvName) {
        MdMetadataHierarchylvName mdHierarchyLvName = new MdMetadataHierarchylvName();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdMetadataHierarchylv.class);
            criteria.add(Restrictions.eq("mdMetadataid", HierarchyLvName));
            mdHierarchyLvName = (MdMetadataHierarchylvName) criteria.uniqueResult();

            if (mdHierarchyLvName == null) {
                return null;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally {
            //session.close();
        }

        return mdHierarchyLvName;
    }

    public String saveMdMetadataHierarchyLvName(MdMetadataHierarchylvNameModel mdModel) {
        MdMetadataHierarchylvName mdHierarchyLvName = new MdMetadataHierarchylvName();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
       Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            mdHierarchyLvName.setMdMetadataid(mdModel.getMdMetadataid());
            mdHierarchyLvName.setHierarchylevelName(mdModel.getHierarchylevelName());

            session.save(mdHierarchyLvName);
            trx.commit();

            return "berhasil disimpan.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
    }

    public String updateMdMetadataHierarchyLvName(MdMetadataHierarchylvNameModel mdModel) {
        
        MdMetadataHierarchylvName mdHierarchyLvName = new MdMetadataHierarchylvName();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdMetadataHierarchylvName.class);
            criteria.add(Restrictions.eq(MdMetadataHierarchylvNameModel.MD_METADATAID, mdModel.getMdMetadataid()));
            mdHierarchyLvName = (MdMetadataHierarchylvName) criteria.uniqueResult();

            mdHierarchyLvName.setHierarchylevelName(mdModel.getHierarchylevelName());

            session.update(mdHierarchyLvName);
            trx.commit();

            return "berhasil diubah.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
    }
    
    public String deleteMdMetadataHierarchylvName(BigDecimal Id) {
        MdMetadataHierarchylvName mdHierarchyLv = new MdMetadataHierarchylvName();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdMetadataHierarchylvName.class);
            criteria.add(Restrictions.eq("mdMetadataid", Id));
            mdHierarchyLv = (MdMetadataHierarchylvName) criteria.uniqueResult();

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
