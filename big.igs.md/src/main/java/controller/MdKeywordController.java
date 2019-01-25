/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtilXml;
import domain.MdKeyword;
import java.math.BigDecimal;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.Iterator;
import java.util.List;
import model.table.MdKeywordModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Fauzy Ramedia
 */
public class MdKeywordController {

    public MdKeywordController() {
    }
    HibernateUtilXml hibernateUtilXml;
    Session session;

    public MdKeywordController(Session session, HibernateUtilXml hibernateUtilXml) {
        this.hibernateUtilXml = hibernateUtilXml;
        this.session = session;
    }

    public BigDecimal getMaxMdKeywordId() {

        BigDecimal maxId = null;

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdKeyword.class);
            criteria.addOrder(Order.desc("id"));
            criteria.setMaxResults(1);
            List results = criteria.list();

            if (results.size() > 0) {
                maxId = ((MdKeyword) results.get(0)).getId();
            } else {
                //  maxId = 0;
            }

            trx.commit();

        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        }
        //session.close();

        return maxId;
    }

    public MdKeyword getDataById(BigDecimal Id) {

        MdKeyword mdKeyword = new MdKeyword();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdKeyword.class);
            criteria.add(Restrictions.eq("mdIdentificationId", Id));
            mdKeyword = (MdKeyword) criteria.uniqueResult();

            if (mdKeyword == null) {
                return null;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally {
            //session.close();
        }

        return mdKeyword;
    }
    
    public String deletedMdKeyword(BigDecimal Id) {

        MdKeyword mdKeyword = new MdKeyword();
        //List list = new ArrayList();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdKeyword.class);
            criteria.add(Restrictions.eq("id", Id));
            mdKeyword = (MdKeyword) criteria.uniqueResult();
            
//            list = criteria.list();
//            Iterator iterator = list.iterator();
            
//            while (iterator.hasNext()) {
//
//                mdKeyword = (MdKeyword) iterator.next();
//                id.add(mdKeyword.getId());
            session.delete(mdKeyword);
            //}
           
            trx.commit();
            
            return "berhasil dihapus.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
    }

    public MdKeyword getDataByPropery(BigDecimal Id, String type) {

        MdKeyword mdKeyword = new MdKeyword();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdKeyword.class);
            criteria.add(Restrictions.eq("mdIdentificationId", Id))
                    .add(Restrictions.eqOrIsNull("type", type));
            mdKeyword = (MdKeyword) criteria.uniqueResult();

            if (mdKeyword == null) {
                return null;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally {
            //session.close();
        }

        return mdKeyword;
    }

    public String saveMdKeyword(MdKeywordModel mdModel) {
        MdKeyword MdKeyword = new MdKeyword();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
       Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            MdKeyword.setId(mdModel.getId());
            MdKeyword.setMdIdentificationId(mdModel.getMdIdentificationId());
            MdKeyword.setSvServiceIdentificationId(mdModel.getSvServiceIdentificationId());
            MdKeyword.setType(mdModel.getType());

            session.save(MdKeyword);
            trx.commit();

            return "berhasil disimpan.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
    }

    public List getListOfId(BigDecimal Id) {

        MdKeyword mdKeyword = new MdKeyword();
        List list = new ArrayList();
        List id = new ArrayList();
        int[] errorList = {-999, -999, -999};

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdKeyword.class);
            criteria.add(Restrictions.eq("mdIdentificationId", Id));
            //criteria.setMaxResults(3);

            list = criteria.list();
            Iterator iterator = list.iterator();

            while (iterator.hasNext()) {

                mdKeyword = (MdKeyword) iterator.next();
                id.add(mdKeyword.getId());
            }

            if (id.size() == 0) {

                List<Integer> intList = new ArrayList<Integer>();

                for (int index = 0; index < errorList.length; index++) {
                    intList.add(errorList[index]);
                }

                return intList;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally {
            //session.close();
        }

        return id;
    }

    public List getListOfId(BigDecimal Id, String type) {

        MdKeyword mdKeyword = new MdKeyword();
        List list = new ArrayList();
        List id = new ArrayList();
        int[] errorList = {-999, -999, -999};

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdKeyword.class);
            criteria.add(Restrictions.eq("mdIdentificationId", Id))
                    .add(Restrictions.eq("type", type));
            //criteria.setMaxResults(3);

            list = criteria.list();
            Iterator iterator = list.iterator();

            while (iterator.hasNext()) {

                mdKeyword = (MdKeyword) iterator.next();
                id.add(mdKeyword.getId());
            }

            if (id.size() == 0) {

                List<Integer> intList = new ArrayList<Integer>();

                for (int index = 0; index < errorList.length; index++) {
                    intList.add(errorList[index]);
                }

                return intList;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally {
            //session.close();
        }

        return id;
    }

    public String updateMdKeywordByType(MdKeywordModel mdModel) {

        MdKeyword mdKeyword = new MdKeyword();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdKeyword.class);
            criteria.add(Restrictions.eq("mdIdentificationId", mdModel.getMdIdentificationId()))
                    .add(Restrictions.eq("type", mdModel.getType()));
            mdKeyword = (MdKeyword) criteria.uniqueResult();

            mdKeyword.setMdIdentificationId(mdModel.getMdIdentificationId());
            mdKeyword.setSvServiceIdentificationId(mdModel.getSvServiceIdentificationId());
            mdKeyword.setType(mdModel.getType());

            session.update(mdKeyword);
            trx.commit();

            return "updated successfully.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
    }

    public String updateMdKeywordByCurrentId(MdKeywordModel mdModel) {

        MdKeyword mdKeyword = new MdKeyword();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdKeyword.class);
            criteria.add(Restrictions.eq("id", mdModel.getId()));
            mdKeyword = (MdKeyword) criteria.uniqueResult();

            mdKeyword.setMdIdentificationId(mdModel.getMdIdentificationId());
            mdKeyword.setSvServiceIdentificationId(mdModel.getSvServiceIdentificationId());
            mdKeyword.setType(mdModel.getType());

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

    public String updateMdKeyword(MdKeywordModel mdModel) {

        MdKeyword mdKeyword = new MdKeyword();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdKeyword.class);
            criteria.add(Restrictions.eq("mdIdentificationId", mdModel.getMdIdentificationId()));
            mdKeyword = (MdKeyword) criteria.uniqueResult();

            mdKeyword.setMdIdentificationId(mdModel.getMdIdentificationId());
            mdKeyword.setSvServiceIdentificationId(mdModel.getSvServiceIdentificationId());
            mdKeyword.setType(mdModel.getType());

            session.update(mdKeyword);
            trx.commit();

            return "updated successfully.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
    }
}
