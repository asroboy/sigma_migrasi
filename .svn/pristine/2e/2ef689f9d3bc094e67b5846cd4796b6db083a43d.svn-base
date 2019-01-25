/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtilXml;
import domain.MdMediumNameCode;
import model.table.MdMediumNameCodeModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Fauzy Ramedia
 */
public class MdMediumNameCodeController {

    public MdMediumNameCodeController() {
    }
    HibernateUtilXml hibernateUtilXml;
    Session session;

    public MdMediumNameCodeController(Session session, HibernateUtilXml hibernateUtilXml) {
        this.hibernateUtilXml = hibernateUtilXml;
        this.session = session;
    }

    public MdMediumNameCode getDataByDomain(String domainName) {

        MdMediumNameCode mdMediumNameCode = new MdMediumNameCode();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdMediumNameCode.class);
            criteria.add(Restrictions.eq("domainName", domainName).ignoreCase());
            mdMediumNameCode = (MdMediumNameCode) criteria.uniqueResult();

            if (mdMediumNameCode == null) {
                return null;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally {
            //session.close();
        }

        return mdMediumNameCode;
    }

    public String saveMdMediumNameCode(MdMediumNameCodeModel mdModel) {
        MdMediumNameCode MdMediumNameCode = new MdMediumNameCode();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            MdMediumNameCode.setCode(mdModel.getCode());
            MdMediumNameCode.setDefinition(mdModel.getDefinition());
            MdMediumNameCode.setDomainName(mdModel.getDomainName());

            session.save(MdMediumNameCode);
            trx.commit();

            return "saved successfully.....!!";
        } catch (Exception e) {
            trx.rollback();
            return e.getMessage();
        } finally {
            //session.close();
        }
    }
}
