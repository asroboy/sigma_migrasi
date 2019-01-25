/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtilXml;
import domain.MdDataIdentificationLang;
import java.math.BigDecimal;
import model.table.MdDataIdentificationLangModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author wallet
 */
public class MdDataIdentificationLangController {

    public MdDataIdentificationLangController() {
    }

    HibernateUtilXml hibernateUtilXml;
    Session session;

    public MdDataIdentificationLangController(Session session, HibernateUtilXml hibernateUtilXml) {
        this.hibernateUtilXml = hibernateUtilXml;
        this.session = session;
    }

    public MdDataIdentificationLang getDataById(BigDecimal Id) {

        MdDataIdentificationLang lang = new MdDataIdentificationLang();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdDataIdentificationLang.class);
            criteria.add(Restrictions.eq("mdDataIdentificationId", Id));
            lang = (MdDataIdentificationLang) criteria.uniqueResult();

            if (lang == null) {
                return null;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally {
            //session.close();
        }

        return lang;
    }
    
    public String deletedMdDataIdentificationLang(BigDecimal Id) {

        MdDataIdentificationLang lang = new MdDataIdentificationLang();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdDataIdentificationLang.class);
            criteria.add(Restrictions.eq("mdDataIdentificationId", Id));
            lang = (MdDataIdentificationLang) criteria.uniqueResult();

            session.delete(lang);
            trx.commit();
            
            return "berhasil dihapus.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
    }

    public String saveMdDataIdentificationLang(MdDataIdentificationLangModel mdDataIdentificationLangModel) {

        domain.MdDataIdentificationLang mdDataIdentificationLang = new domain.MdDataIdentificationLang();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            mdDataIdentificationLang.setLanguage(mdDataIdentificationLangModel.getLanguage());
            mdDataIdentificationLang.setMdDataIdentificationId(mdDataIdentificationLangModel.getMdDataIdentificationId());

            //System.out.println(md);
            session.save(mdDataIdentificationLang);
            trx.commit();

            return "berhasil disimpan.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
    }

    public String updateMdDataIdentificationLang(BigDecimal id,MdDataIdentificationLangModel mdModel) {

        MdDataIdentificationLang lang = new MdDataIdentificationLang();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdDataIdentificationLang.class);
            criteria.add(Restrictions.eq("mdDataIdentificationId", id));
            lang = (MdDataIdentificationLang) criteria.uniqueResult();

            lang.setLanguage(mdModel.getLanguage());

            session.update(lang);
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
