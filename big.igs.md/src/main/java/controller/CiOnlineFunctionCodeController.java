/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtilXml;
import domain.CiOnlineFunctionCode;
import model.table.CiOnlineFunctionCodeModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Fauzy Ramedia
 */
public class CiOnlineFunctionCodeController {

    public CiOnlineFunctionCodeController() {
    }
    HibernateUtilXml hibernateUtilXml;
    Session session;

    public CiOnlineFunctionCodeController(Session session, HibernateUtilXml hibernateUtilXml) {
        this.hibernateUtilXml = hibernateUtilXml;
        this.session = session;
    }

    public CiOnlineFunctionCode getDataByDomain(String domainName) {

        CiOnlineFunctionCode ciOnlineFunctionCode = new CiOnlineFunctionCode();
        CiOnlineFunctionCode code = new CiOnlineFunctionCode();
        code.setCode("000");

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(CiOnlineFunctionCode.class);
            criteria.add(Restrictions.eq("domainname", domainName).ignoreCase());
            ciOnlineFunctionCode = (CiOnlineFunctionCode) criteria.uniqueResult();

            if (ciOnlineFunctionCode == null) {
                return code;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally {
            //session.close();
        }

        return ciOnlineFunctionCode;
    }

    public String saveCiOnlineFunctionCode(CiOnlineFunctionCodeModel mdModel) {
        CiOnlineFunctionCode CiOnlineFunctionCode = new CiOnlineFunctionCode();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();
        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            CiOnlineFunctionCode.setCode(mdModel.getCode());
            CiOnlineFunctionCode.setDefinition(mdModel.getDefinition());
            CiOnlineFunctionCode.setDomainname(mdModel.getDomainname());

            session.save(CiOnlineFunctionCode);
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
