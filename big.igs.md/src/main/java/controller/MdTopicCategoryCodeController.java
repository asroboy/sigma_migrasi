/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtilXml;
import domain.MdTopicCategoryCode;
import model.table.MdTopicCategoryCodeModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Fauzy Ramedia
 */
public class MdTopicCategoryCodeController {

    public MdTopicCategoryCodeController() {
    }

    HibernateUtilXml hibernateUtilXml;
    Session session;

    public MdTopicCategoryCodeController(Session session, HibernateUtilXml hibernateUtilXml) {
        this.hibernateUtilXml = hibernateUtilXml;
        this.session = session;
    }

    public MdTopicCategoryCode getDataByDomain(String domain) {
        MdTopicCategoryCode categoryCode = new MdTopicCategoryCode();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdTopicCategoryCode.class);
            criteria.add(Restrictions.eq("domainName", domain).ignoreCase());
            categoryCode = (MdTopicCategoryCode) criteria.uniqueResult();

            if (categoryCode == null) {
                return null;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally {
            //session.close();
        }

        return categoryCode;

    }

    public String saveMdTopicCategoryCode(MdTopicCategoryCodeModel mdModel) {
        MdTopicCategoryCode MdTopicCategoryCode = new MdTopicCategoryCode();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            MdTopicCategoryCode.setCode(mdModel.getCode());
            MdTopicCategoryCode.setDefinition(mdModel.getDefinition());
            MdTopicCategoryCode.setDomainName(mdModel.getDomainName());

            session.save(MdTopicCategoryCode);
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
