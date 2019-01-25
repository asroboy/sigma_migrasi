/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtilXml;
import domain.CiResponsibleParty;
import java.math.BigDecimal;
import java.util.List;
import model.table.CiResponsiblePartyModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author wallet
 */
public class CiResponsiblePartyController {

    public CiResponsiblePartyController() {
    }
    HibernateUtilXml hibernateUtilXml;
    Session session;

    public CiResponsiblePartyController(Session session, HibernateUtilXml hibernateUtilXml) {
        this.hibernateUtilXml = hibernateUtilXml;
        this.session = session;
    }

    public BigDecimal getMaxResponsiblePartyId() {

        BigDecimal maxId = null;

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(CiResponsibleParty.class);
            criteria.addOrder(Order.desc("id"));
            criteria.setMaxResults(1);
            List results = criteria.list();

            if (results.size() > 0) {
                maxId = ((CiResponsibleParty) results.get(0)).getId();
            } else {
                //  maxId = 0;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally {
            //session.close();
        }

        return maxId;
    }

    public CiResponsibleParty getDataById(String column,BigDecimal Id,String code) {

        CiResponsibleParty ciResponsibleParty = new CiResponsibleParty();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(CiResponsibleParty.class);
            criteria.add(Restrictions.eq(column, Id))
                    .add(Restrictions.eqOrIsNull(CiResponsiblePartyModel.ROLE, code));
            ciResponsibleParty = (CiResponsibleParty) criteria.uniqueResult();

            if (ciResponsibleParty == null) {
                return null;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally {
            //session.close();
        }

        return ciResponsibleParty;
    }
    
    public CiResponsibleParty getDataById(String column,BigDecimal Id) {

        CiResponsibleParty ciResponsibleParty = new CiResponsibleParty();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(CiResponsibleParty.class);
            criteria.add(Restrictions.eq(column, Id));
            ciResponsibleParty = (CiResponsibleParty) criteria.uniqueResult();

            if (ciResponsibleParty == null) {
                return null;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally {
            //session.close();
        }

        return ciResponsibleParty;
    }
     
    public CiResponsibleParty getDataByIdMetadataEntity(BigDecimal Id) {

        CiResponsibleParty ciResponsibleParty = new CiResponsibleParty();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(CiResponsibleParty.class);
            criteria.add(Restrictions.eq("mdMetadataId", Id))
                    .add(Restrictions.isNull("ciCitationId"))
                    .add(Restrictions.isNull("mdIdentificationId"))
                    .add(Restrictions.isNull("mdDistributorId"))
                    .add(Restrictions.isNull("mdExtendedElementInfoId"))
                    .add(Restrictions.isNull("mdMaintenanceInfoId"))
                    .add(Restrictions.isNull("liProcessStepId"))
                    .add(Restrictions.isNull("mdUsageId"));
            ciResponsibleParty = (CiResponsibleParty) criteria.uniqueResult();

            if (ciResponsibleParty == null) {
                return null;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally {
            //session.close();
        }

        return ciResponsibleParty;
    }    

    public CiResponsibleParty getDataByProperty(BigDecimal mdMetadataId, String positionName, String organisationName, String role) {

        CiResponsibleParty ciResponsibleParty = new CiResponsibleParty();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(CiResponsibleParty.class);
            criteria.add(Restrictions.eq("mdMetadataId", mdMetadataId))
                    .add(Restrictions.eq("positionName", positionName))
                    .add(Restrictions.eq("organisationName", organisationName))
                    .add(Restrictions.eq("role", role));
            ciResponsibleParty = (CiResponsibleParty) criteria.uniqueResult();

            if (ciResponsibleParty == null) {
                return null;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally {
            //session.close();
        }

        return ciResponsibleParty;
    }

    public String saveCiResponsibleParty(CiResponsiblePartyModel mdModel) {

        CiResponsibleParty ciResponsibleParty = new CiResponsibleParty();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            ciResponsibleParty.setId(mdModel.getId());
            ciResponsibleParty.setIndividualName(mdModel.getIndividualName());
            ciResponsibleParty.setOrganisationName(mdModel.getOrganisationName());
            ciResponsibleParty.setPositionName(mdModel.getPositionName());
            ciResponsibleParty.setCiCitationId(mdModel.getCiCitationId());
            ciResponsibleParty.setMdDistributorId(mdModel.getMdDistributorId());
            ciResponsibleParty.setMdExtendedElementInfoId(mdModel.getMdExtendedElementInfoId());
            ciResponsibleParty.setMdIdentificationId(mdModel.getMdIdentificationId());
            ciResponsibleParty.setMdMaintenanceInfoId(mdModel.getMdMaintenanceInfoId());
            ciResponsibleParty.setMdMetadataId(mdModel.getMdMetadataId());
            ciResponsibleParty.setLiProcessStepId(mdModel.getLiProcessStepId());
            ciResponsibleParty.setRole(mdModel.getRole());
            ciResponsibleParty.setMdUsageId(mdModel.getMdUsageId());
            

            session.save(ciResponsibleParty);
            trx.commit();

            return "berhasil disimpan.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
    }

    public String updateCiResponsibleParty(BigDecimal id,CiResponsiblePartyModel mdModel) {

        CiResponsibleParty ciResponsibleParty = new CiResponsibleParty();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(CiResponsibleParty.class);
            criteria.add(Restrictions.eq("id", id));
            ciResponsibleParty = (CiResponsibleParty) criteria.uniqueResult();

            ciResponsibleParty.setIndividualName(mdModel.getIndividualName());
            ciResponsibleParty.setOrganisationName(mdModel.getOrganisationName());
            ciResponsibleParty.setPositionName(mdModel.getPositionName());
            ciResponsibleParty.setCiCitationId(mdModel.getCiCitationId());
            ciResponsibleParty.setMdDistributorId(mdModel.getMdDistributorId());
            ciResponsibleParty.setMdExtendedElementInfoId(mdModel.getMdExtendedElementInfoId());
            ciResponsibleParty.setMdIdentificationId(mdModel.getMdIdentificationId());
            ciResponsibleParty.setMdMaintenanceInfoId(mdModel.getMdMaintenanceInfoId());
            ciResponsibleParty.setMdMetadataId(mdModel.getMdMetadataId());
            ciResponsibleParty.setLiProcessStepId(mdModel.getLiProcessStepId());
            ciResponsibleParty.setRole(mdModel.getRole());
            ciResponsibleParty.setMdUsageId(mdModel.getMdUsageId());

            session.update(ciResponsibleParty);
            trx.commit();

            return "berhasil diubah.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
    }
    
    public String deleteCiResponsibleParty(BigDecimal Id) {

        CiResponsibleParty ciResponsibleParty = new CiResponsibleParty();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(CiResponsibleParty.class);
            criteria.add(Restrictions.eq("id", Id));
            ciResponsibleParty = (CiResponsibleParty) criteria.uniqueResult();

            session.delete(ciResponsibleParty);
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
