/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtilXml;
import domain.CiCitation;
import domain.CiDate;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import model.table.CiDateModel;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Fauzy Ramedia
 */
public class CiDateController {

    public CiDateController() {
    }
    HibernateUtilXml hibernateUtilXml;
    Session session;

    public CiDateController(Session session, HibernateUtilXml hibernateUtilXml) {
        this.hibernateUtilXml = hibernateUtilXml;
        this.session = session;
    }

    public BigDecimal getMaxCiDateId() {
        BigDecimal maxId = null;

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(CiDate.class);
            criteria.addOrder(Order.desc("id"));
            criteria.setMaxResults(1);
            List results = criteria.list();

            if (results.size() > 0) {
                maxId = ((CiDate) results.get(0)).getId();
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

    public CiDate getDataById(BigDecimal Id,String code) {

        CiDate ciDate = new CiDate();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(CiDate.class);
            criteria.add(Restrictions.eq("ciCitationId", Id))
                    .add(Restrictions.eqOrIsNull("dateType", code));
            ciDate = (CiDate) criteria.uniqueResult();

            if (ciDate == null) {
                return null;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally {
            //session.close();
        }

        return ciDate;
    }
    
    public CiDate getDataById(BigDecimal Id) {

        CiDate ciDate = new CiDate();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(CiDate.class);
            criteria.add(Restrictions.eq("ciCitationId", Id));
            ciDate = (CiDate) criteria.uniqueResult();

            if (ciDate == null) {
                return null;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally {
            //session.close();
        }

        return ciDate;
    }
        
    public ArrayList<CiDate> getAllData() {

        CiDate cd = new CiDate();
        List list = new ArrayList();
        ArrayList<CiDate> cdList = new ArrayList();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(CiDate.class);
            list = criteria.list();
            Iterator iterator = list.iterator();

            while (iterator.hasNext()) {
                
                CiDate ciDate = new CiDate();
                cd = (CiDate) iterator.next();
                ciDate.setId(cd.getId());
                ciDate.setDate_(cd.getDate_());
                ciDate.setDateType(cd.getDateType());
                ciDate.setCiCitationId(cd.getCiCitationId());
                
                cdList.add(cd);
                
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally {
            //session.close();
        }

        return cdList;
    }
    
    
    
    public String deletedCiDate(BigDecimal Id) {

        CiDate ciDate = new CiDate();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(CiDate.class);
            criteria.add(Restrictions.eq("id", Id));
            ciDate = (CiDate) criteria.uniqueResult();

            session.delete(ciDate);
            trx.commit();
            
            return "berhasil dihapus.....!!";
            
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }

    }

    public String saveCiDate(CiDateModel mdModel) {
        CiDate CiDate = new CiDate();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            CiDate.setId(mdModel.getId());
            CiDate.setDate_(mdModel.getDate_());
            CiDate.setDateType(mdModel.getDateType());
            CiDate.setCiCitationId(mdModel.getCiCitationId());

            session.save(CiDate);
            trx.commit();

            return "berhasil disimpan.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
    }

    public String updateCiDate(BigDecimal id,CiDateModel mdModel) {

        CiDate ciDate = new CiDate();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(CiDate.class);
            criteria.add(Restrictions.eq("id", id));
            ciDate = (CiDate) criteria.uniqueResult();

            ciDate.setDateType(mdModel.getDateType());
            ciDate.setDate_(mdModel.getDate_());
            ciDate.setCiCitationId(mdModel.getCiCitationId());

            session.update(ciDate);
            trx.commit();

            return "berhasil diubah.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
    }    
        
    public List getListOfId(BigDecimal Id) {

        CiDate ciDate = new CiDate();
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

            Criteria criteria = session.createCriteria(CiDate.class);
            criteria.add(Restrictions.eq("ciCitationId", Id));
            //criteria.setMaxResults(3);

            list = criteria.list();
            Iterator iterator = list.iterator();

            while (iterator.hasNext()) {

                ciDate = (CiDate) iterator.next();
                id.add(ciDate.getId());
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


}
