/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtilXml;
import domain.MdKeywordTypeCode;
import model.table.MdKeywordTypeCodeModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Fauzy Ramedia
 */
public class MdKeywordTypeCodeController {

    public MdKeywordTypeCodeController() {
    }
    HibernateUtilXml hibernateUtilXml;
    Session session;

    public MdKeywordTypeCodeController(Session session, HibernateUtilXml hibernateUtilXml) {
        this.hibernateUtilXml = hibernateUtilXml;
        this.session = session;
    }

    public MdKeywordTypeCode getDataByDomain(String domainName) {

        MdKeywordTypeCode mdKeywordTypeCode = new MdKeywordTypeCode();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdKeywordTypeCode.class);
            criteria.add(Restrictions.eq("domainName", domainName).ignoreCase());
            mdKeywordTypeCode = (MdKeywordTypeCode) criteria.uniqueResult();

            if (mdKeywordTypeCode == null) {
                return null;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally {
            //session.close();
        }

        return mdKeywordTypeCode;
    }

    public String saveMdKeywordTypeCode(MdKeywordTypeCodeModel mdModel) {
        MdKeywordTypeCode MdKeywordTypeCode = new MdKeywordTypeCode();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            MdKeywordTypeCode.setCode(mdModel.getCode());
            MdKeywordTypeCode.setDefinition(mdModel.getDefinition());
            MdKeywordTypeCode.setDomainName(mdModel.getDomainName());

            session.save(MdKeywordTypeCode);
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
