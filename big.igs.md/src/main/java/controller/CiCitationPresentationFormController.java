/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import config.HibernateUtilXml;
import domain.CiCitation;
import domain.CiCitationPresentationForm;
import domain.MdKeyword;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import model.table.CiCitationModel;
import model.table.CiCitationPresentationFormModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author wallet
 */

public class CiCitationPresentationFormController {

    HibernateUtilXml hibernateUtilXml;
    Session session;
    
     
    public CiCitationPresentationFormController() {
    }

    public CiCitationPresentationFormController(Session session, HibernateUtilXml hibernateUtilXml) {
        this.hibernateUtilXml = hibernateUtilXml;
        this.session = session;
    }

    
    public CiCitationPresentationForm getDataById(BigDecimal id) {

        CiCitationPresentationForm CiCitationPresentationForm = new CiCitationPresentationForm();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(CiCitationPresentationForm.class);
            criteria.add(Restrictions.eq("ciCitationId", id));
            CiCitationPresentationForm = (CiCitationPresentationForm) criteria.uniqueResult();

            if (CiCitationPresentationForm == null) {
                return null;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally {
            ////session.close();
        }

        return CiCitationPresentationForm;
    }
    
    public String deleteCiCitationPresentationForm(BigDecimal id) {

        CiCitationPresentationForm  ccpf = new CiCitationPresentationForm();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(CiCitationPresentationForm.class);
            criteria.add(Restrictions.eq("ciCitationId", id));
            ccpf = (CiCitationPresentationForm) criteria.uniqueResult();
            
            session.delete(ccpf);
            trx.commit();
            
            return "berhasil dihapus.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            ////session.close();
        }
    }

    public String saveCiCitationPresentationForm(CiCitationPresentationFormModel mdModel) {

        CiCitationPresentationForm CiCitationPresentationForm = new CiCitationPresentationForm();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
         Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            CiCitationPresentationForm.setCiCitationId(mdModel.getCiCitationId());
            CiCitationPresentationForm.setPresentationForm(mdModel.getPresentationForm());

            session.save(CiCitationPresentationForm);
            trx.commit();

            return "berhasil disimpan.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            ////session.close();
        }
    }

    public String updateCiCitationPresentationForm(CiCitationPresentationFormModel mdModel) {

        CiCitationPresentationForm CiCitationPresentationForm = new CiCitationPresentationForm();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(CiCitationPresentationForm.class);
            criteria.add(Restrictions.eq("ciCitationId", mdModel.getCiCitationId()));
            CiCitationPresentationForm = (CiCitationPresentationForm) criteria.uniqueResult();

            CiCitationPresentationForm.setPresentationForm(mdModel.getPresentationForm());
             
            session.update(CiCitationPresentationForm);
            trx.commit();

            return "berhasil diubah.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            ////session.close();
        }
    }
    
}
