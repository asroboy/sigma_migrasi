/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtilXml;
import domain.MdProgressCode;
import model.table.MdProgressCodeModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Fauzy Ramedia
 */
public class MdProgressCodeController {

    public MdProgressCodeController() {
    }
    HibernateUtilXml hibernateUtilXml;
    Session session;

    public MdProgressCodeController(Session session, HibernateUtilXml hibernateUtilXml) {
        this.hibernateUtilXml = hibernateUtilXml;
        this.session = session;
    }

    public MdProgressCode getDataByDomain(String domainName) {

        MdProgressCode mdProgressCode = new MdProgressCode();
        MdProgressCode code = new MdProgressCode();
        code.setCode("000");

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdProgressCode.class);
            criteria.add(Restrictions.eq("domainName", domainName));
            mdProgressCode = (MdProgressCode) criteria.uniqueResult();

            if (mdProgressCode == null) {
                return code;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally {
            //session.close();
        }

        return mdProgressCode;
    }

    public String saveMdProgressCode(MdProgressCodeModel mdModel) {
        MdProgressCode MdProgressCode = new MdProgressCode();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
       Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            MdProgressCode.setCode(mdModel.getCode());
            MdProgressCode.setDefinition(mdModel.getDefinition());
            MdProgressCode.setDomainName(mdModel.getDomainName());

            session.save(MdProgressCode);
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
