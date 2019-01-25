/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtilXml;
import domain.MdTopologyLevelCode;
import model.table.MdTopologyLevelCodeModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Fauzy Ramedia
 */
public class MdTopologyLevelCodeController {

    public MdTopologyLevelCodeController() {
    }
    HibernateUtilXml hibernateUtilXml;
    Session session;

    public MdTopologyLevelCodeController(Session session, HibernateUtilXml hibernateUtilXml) {
        this.hibernateUtilXml = hibernateUtilXml;
        this.session = session;
    }

    public MdTopologyLevelCode getDataByDomain(String domainName) {

        MdTopologyLevelCode mdTopologyLevelCode = new MdTopologyLevelCode();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdTopologyLevelCode.class);
            criteria.add(Restrictions.eq("domainName", domainName).ignoreCase());
            mdTopologyLevelCode = (MdTopologyLevelCode) criteria.uniqueResult();

            if (mdTopologyLevelCode == null) {
                return null;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally {
            //session.close();
        }

        return mdTopologyLevelCode;
    }

    public String saveMdTopologyLevelCode(MdTopologyLevelCodeModel mdModel) {
        MdTopologyLevelCode MdTopologyLevelCode = new MdTopologyLevelCode();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
       Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            MdTopologyLevelCode.setCode(mdModel.getCode());
            MdTopologyLevelCode.setDefinition(mdModel.getDefinition());
            MdTopologyLevelCode.setDomainName(mdModel.getDomainName());

            session.save(MdTopologyLevelCode);
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
