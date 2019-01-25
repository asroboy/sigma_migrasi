/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtilXml;
import domain.CiOnlineResource;
import java.math.BigDecimal;
import java.util.List;
import model.table.CiOnlineResourceModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Fauzy Ramedia
 */
public class CiOnlineResourceController {

    public CiOnlineResourceController() {
    }
    HibernateUtilXml hibernateUtilXml;
    Session session;

    public CiOnlineResourceController(Session session, HibernateUtilXml hibernateUtilXml) {
        this.hibernateUtilXml = hibernateUtilXml;
        this.session = session;
    }

    public BigDecimal getMaxCiOnlineResourceId() {

        BigDecimal maxId = null;

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(CiOnlineResource.class);
            criteria.addOrder(Order.desc("id"));
            criteria.setMaxResults(1);
            List results = criteria.list();

            if (results.size() > 0) {
                maxId = ((CiOnlineResource) results.get(0)).getId();
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

    public CiOnlineResource getDataById(String column,BigDecimal Id,String code) {

        CiOnlineResource ciOnlineResource = new CiOnlineResource();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(CiOnlineResource.class);
            criteria.add(Restrictions.eq(column, Id))
                    .add(Restrictions.eqOrIsNull(CiOnlineResourceModel.FUNCTION_, code));
            ciOnlineResource = (CiOnlineResource) criteria.uniqueResult();

            if (ciOnlineResource == null) {
                return null;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally {
            //session.close();
        }

        return ciOnlineResource;
    }
    
    public CiOnlineResource getDataById(String column,BigDecimal Id) {

        CiOnlineResource ciOnlineResource = new CiOnlineResource();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(CiOnlineResource.class);
            criteria.add(Restrictions.eq(column, Id));
            ciOnlineResource = (CiOnlineResource) criteria.uniqueResult();

            if (ciOnlineResource == null) {
                return null;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally {
            //session.close();
        }

        return ciOnlineResource;
    }
    
    public String deletedCiOnlineResource(BigDecimal Id) {

        CiOnlineResource ciOnlineResource = new CiOnlineResource();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(CiOnlineResource.class);
            criteria.add(Restrictions.eq("id", Id));
            ciOnlineResource = (CiOnlineResource) criteria.uniqueResult();

            session.delete(ciOnlineResource);
            trx.commit();
            
            return "berhasil dihapus.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
    }

    public String saveCiOnlineResource(CiOnlineResourceModel mdModel) {
        CiOnlineResource CiOnlineResource = new CiOnlineResource();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            CiOnlineResource.setId(mdModel.getId());
            CiOnlineResource.setApplicationProfile(mdModel.getApplicationProfile());
            CiOnlineResource.setDescription(mdModel.getDescription());
            CiOnlineResource.setLinkage(mdModel.getLinkage());
            CiOnlineResource.setName(mdModel.getName());
            CiOnlineResource.setProtocol(mdModel.getProtocol());
            CiOnlineResource.setCiContactId(mdModel.getCiContactId());
            CiOnlineResource.setMdDigitalTransferOptionsId(mdModel.getMdDigitalTransferOptionsId());
            CiOnlineResource.setFunction_(mdModel.getFunction_());
            CiOnlineResource.setMdMetadataExtensionInfoId(mdModel.getMdMetadataExtensionInfoId());
            CiOnlineResource.setSvOperationMetadataId(mdModel.getSvOperationMetadataId());

            session.save(CiOnlineResource);
            trx.commit();

            return "berhasil disimpan.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
    }

    public String updateCiOnlineResource(BigDecimal id,CiOnlineResourceModel mdModel) {

        CiOnlineResource ciOnlineResource = new CiOnlineResource();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(CiOnlineResource.class);
            criteria.add(Restrictions.eq("id",id));
            ciOnlineResource = (CiOnlineResource) criteria.uniqueResult();

            ciOnlineResource.setApplicationProfile(mdModel.getApplicationProfile());
            ciOnlineResource.setDescription(mdModel.getDescription());
            ciOnlineResource.setLinkage(mdModel.getLinkage());
            ciOnlineResource.setName(mdModel.getName());
            ciOnlineResource.setProtocol(mdModel.getProtocol());
            ciOnlineResource.setCiContactId(mdModel.getCiContactId());
            ciOnlineResource.setMdDigitalTransferOptionsId(mdModel.getMdDigitalTransferOptionsId());
            ciOnlineResource.setFunction_(mdModel.getFunction_());
            ciOnlineResource.setMdMetadataExtensionInfoId(mdModel.getMdMetadataExtensionInfoId());
            ciOnlineResource.setSvOperationMetadataId(mdModel.getSvOperationMetadataId());

            session.update(ciOnlineResource);
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