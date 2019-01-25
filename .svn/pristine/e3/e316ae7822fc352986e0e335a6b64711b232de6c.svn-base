/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtilXml;
import domain.MdCharacterSetCode;
import java.math.BigDecimal;
import java.util.List;
import model.table.MdCharacterSetCodeModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author wallet
 */
public class MdCharacterSetCodeController {

    public MdCharacterSetCodeController() {
    }

    HibernateUtilXml hibernateUtilXml;
    Session session;

    public MdCharacterSetCodeController(Session session, HibernateUtilXml hibernateUtilXml) {
        this.hibernateUtilXml = hibernateUtilXml;
        this.session = session;
    }

    public MdCharacterSetCode getDataByDomain(String domain) {
        MdCharacterSetCode mdCharacterSetCode = new MdCharacterSetCode();
        MdCharacterSetCode mcsc = new MdCharacterSetCode();
        mcsc.setCode("000");

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdCharacterSetCode.class);
            criteria.add(Restrictions.eq("domainName", domain).ignoreCase());
            mdCharacterSetCode = (MdCharacterSetCode) criteria.uniqueResult();

            if (mdCharacterSetCode == null) {
                return mcsc;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally {
            //session.close();
        }

        return mdCharacterSetCode;
    }

    public String saveMdCharacterSetCode(MdCharacterSetCodeModel mdCharacterSetCodeModel) {

        MdCharacterSetCode mdCharacterSetCode = new MdCharacterSetCode();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
      Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            mdCharacterSetCode.setCode(mdCharacterSetCodeModel.getCode());
            mdCharacterSetCode.setDefinition(mdCharacterSetCodeModel.getDefinition());
            mdCharacterSetCode.setDomainName(mdCharacterSetCodeModel.getDomainName());

            //System.out.println(md);
            session.save(mdCharacterSetCode);
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
