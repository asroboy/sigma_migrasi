/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtilXml;
import domain.MdMaintenanceInfo;
import java.math.BigDecimal;
import java.util.List;
import model.table.MdMaintenanceInfoModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Fauzy Ramedia
 */
public class MdMaintenanceInfoController {

    public MdMaintenanceInfoController() {
    }

    HibernateUtilXml hibernateUtilXml;
    Session session;

    public MdMaintenanceInfoController(Session session, HibernateUtilXml hibernateUtilXml) {
        this.hibernateUtilXml = hibernateUtilXml;
        this.session = session;
    }

    public BigDecimal getMaxMdMaintenanceInfoId() {

        BigDecimal maxId = null;

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdMaintenanceInfo.class);
            criteria.addOrder(Order.desc("id"));
            criteria.setMaxResults(1);
            List results = criteria.list();

            if (results.size() > 0) {
                maxId = ((MdMaintenanceInfo) results.get(0)).getId();
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

    public MdMaintenanceInfo getDataById(String column,BigDecimal Id) {

        MdMaintenanceInfo mdMaintenanceInfo = new MdMaintenanceInfo();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdMaintenanceInfo.class);
            criteria.add(Restrictions.eq(column, Id));
            mdMaintenanceInfo = (MdMaintenanceInfo) criteria.uniqueResult();

            if (mdMaintenanceInfo == null) {
                return null;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally {
            //session.close();
        }

        return mdMaintenanceInfo;
    }
    
    public String deletedMdMaintenanceInfo(BigDecimal Id) {

        MdMaintenanceInfo mdMaintenanceInfo = new MdMaintenanceInfo();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdMaintenanceInfo.class);
            criteria.add(Restrictions.eq("id", Id));
            mdMaintenanceInfo = (MdMaintenanceInfo) criteria.uniqueResult();

            session.delete(mdMaintenanceInfo);
            trx.commit();
            
            return "berhasil dihapus.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
    }

    public String saveMdMaintenanceInfo(MdMaintenanceInfoModel mdModel) {
        MdMaintenanceInfo MdMaintenanceInfo = new MdMaintenanceInfo();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            MdMaintenanceInfo.setId(mdModel.getId());
            MdMaintenanceInfo.setDateOfNextUpdate(mdModel.getDateOfNextUpdate());
            MdMaintenanceInfo.setUserDefinedMaintenanceFreq(mdModel.getUserDefinedMaintenanceFreq());
            MdMaintenanceInfo.setMdIdentificationId(mdModel.getMdIdentificationId());
            MdMaintenanceInfo.setMaintenanceAndUpdateFrequency(mdModel.getMaintenanceAndUpdateFrequency());
            MdMaintenanceInfo.setMdMetadataId(mdModel.getMdMetadataId());

            session.save(MdMaintenanceInfo);
            trx.commit();

            return "berhasil disimpan.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
    }

    public String updateMdMaintenanceInfo(BigDecimal id,MdMaintenanceInfoModel mdModel) {

        MdMaintenanceInfo mdMaintenanceInfo = new MdMaintenanceInfo();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdMaintenanceInfo.class);
            criteria.add(Restrictions.eq("id", id));
            mdMaintenanceInfo = (MdMaintenanceInfo) criteria.uniqueResult();

            mdMaintenanceInfo.setDateOfNextUpdate(mdModel.getDateOfNextUpdate());
            mdMaintenanceInfo.setUserDefinedMaintenanceFreq(mdModel.getUserDefinedMaintenanceFreq());
            mdMaintenanceInfo.setMdIdentificationId(mdModel.getMdIdentificationId());
            mdMaintenanceInfo.setMaintenanceAndUpdateFrequency(mdModel.getMaintenanceAndUpdateFrequency());
            mdMaintenanceInfo.setMdMetadataId(mdModel.getMdMetadataId());

            session.update(mdMaintenanceInfo);
            trx.commit();

            return "berhasil diubah.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
    }

    public String updateMdMaintenanceInfoProperty(MdMaintenanceInfoModel mdModel) {

        MdMaintenanceInfo mdMaintenanceInfo = new MdMaintenanceInfo();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdMaintenanceInfo.class);
            criteria.add(Restrictions.eq("mdMetadataId", mdModel.getMdMetadataId()))
                    .add(Restrictions.eq("mdIdentificationId", mdModel.getMdIdentificationId()));;
            mdMaintenanceInfo = (MdMaintenanceInfo) criteria.uniqueResult();

            mdMaintenanceInfo.setDateOfNextUpdate(mdModel.getDateOfNextUpdate());
            mdMaintenanceInfo.setUserDefinedMaintenanceFreq(mdModel.getUserDefinedMaintenanceFreq());
            mdMaintenanceInfo.setMdIdentificationId(mdModel.getMdIdentificationId());
            mdMaintenanceInfo.setMaintenanceAndUpdateFrequency(mdModel.getMaintenanceAndUpdateFrequency());
            mdMaintenanceInfo.setMdMetadataId(mdModel.getMdMetadataId());

            session.update(mdMaintenanceInfo);
            trx.commit();

            return "updated successfully.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
    }
}
