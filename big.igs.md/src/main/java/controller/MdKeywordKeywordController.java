/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtilXml;
import domain.MdKeyword;
import domain.MdKeywordKeyword;
import java.math.BigDecimal;
import static java.util.Collections.list;
import java.util.Iterator;
import java.util.List;
import model.table.MdKeywordKeywordModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Fauzy Ramedia
 */
public class MdKeywordKeywordController {

    public MdKeywordKeywordController() {
    }
    HibernateUtilXml hibernateUtilXml;
    Session session;

    public MdKeywordKeywordController(Session session, HibernateUtilXml hibernateUtilXml) {
        this.hibernateUtilXml = hibernateUtilXml;
        this.session = session;
    }

    public MdKeywordKeyword getDataById(BigDecimal Id) {

        MdKeywordKeyword mdKeywordKeyword = new MdKeywordKeyword();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdKeywordKeyword.class);
            criteria.add(Restrictions.eq("mdKeywordId", Id));

            mdKeywordKeyword = (MdKeywordKeyword) criteria.uniqueResult();

            if (mdKeywordKeyword == null) {
                return null;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally {
            //session.close();
        }

        return mdKeywordKeyword;
    }
    
    public String deletedMdKeywordKeyword(BigDecimal Id) {

        MdKeywordKeyword mdKeywordKeyword = new MdKeywordKeyword();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdKeywordKeyword.class);
            criteria.add(Restrictions.eq("mdKeywordId", Id));

            mdKeywordKeyword = (MdKeywordKeyword) criteria.uniqueResult();
//            List list = criteria.list();
//            Iterator iterator = list.iterator();
//
//            while (iterator.hasNext()) {
//
//                mdKeywordKeyword = (MdKeywordKeyword) iterator.next();
                //id.add(mdKeyword.getId());
            session.delete(mdKeywordKeyword);
           // }
           
            trx.commit();
            
            return "berhasil dihapus....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
    }

    public String saveMdKeywordKeyword(MdKeywordKeywordModel mdModel) {
        MdKeywordKeyword MdKeywordKeyword = new MdKeywordKeyword();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            MdKeywordKeyword.setMdKeywordId(mdModel.getMdKeywordId());
            MdKeywordKeyword.setKeyword(mdModel.getKeyword());

            session.save(MdKeywordKeyword);
            trx.commit();

            return "berhasil disimpan.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
    }

    public String updateMdKeywordKeyword(MdKeywordKeywordModel mdModel) {

        MdKeywordKeyword mdKeyword = new MdKeywordKeyword();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdKeywordKeyword.class);
            criteria.add(Restrictions.eq("mdKeywordId", mdModel.getMdKeywordId()));
            mdKeyword = (MdKeywordKeyword) criteria.uniqueResult();

            mdKeyword.setMdKeywordId(mdModel.getMdKeywordId());
            mdKeyword.setKeyword(mdModel.getKeyword());

            session.update(mdKeyword);
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
