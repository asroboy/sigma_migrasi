/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtil;
import config.HibernateUtilXml;
import domain.MdMaintenanceFrequencyCode;
import domain.PtLocale;
import java.math.BigDecimal;
import java.util.List;
import model.table.PtLocaleModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Fauzy Ramedia
 */
public class PtLocaleController {

    public PtLocaleController() {
    }

    HibernateUtilXml hibernateUtilXml;
    Session session;

    public PtLocaleController(Session session, HibernateUtilXml hibernateUtilXml) {
        this.hibernateUtilXml = hibernateUtilXml;
        this.session = session;
    }

    public PtLocale getIdByLanguage(String language) {

        PtLocale ptLocale = new PtLocale();
        PtLocale locale = new PtLocale();
        BigDecimal error = new BigDecimal("1");
        locale.setId(error);

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }

        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(PtLocale.class);
            criteria.add(Restrictions.eq("country", language).ignoreCase());
            ptLocale = (PtLocale) criteria.uniqueResult();

            if (ptLocale == null) {
                return locale;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally {
            ////session.close();
        }

        return ptLocale;
    }

    public String savePtLocale(PtLocaleModel mdModel) {
        PtLocale PtLocale = new PtLocale();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
      Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            PtLocale.setId(mdModel.getId());
            PtLocale.setCountry(mdModel.getCountry());
            PtLocale.setLanguageCode(mdModel.getLanguageCode());
            PtLocale.setCharacterEncoding(mdModel.getCharacterEncoding());

            session.save(PtLocale);
            trx.commit();

            return "saved successfully.....!!";
        } catch (Exception e) {
            trx.rollback();
            return e.getMessage();
        } finally {
            ////session.close();
        }
    }
}
