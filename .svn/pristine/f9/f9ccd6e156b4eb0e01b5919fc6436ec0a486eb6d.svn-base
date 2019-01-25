/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtilXml;
import domain.MdGeometricObjects;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import model.table.MdGeometricObjectsModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Fauzy Ramedia
 */
public class MdGeometricObjectsController {

    public MdGeometricObjectsController() {
    }
    HibernateUtilXml hibernateUtilXml;
    Session session;

    public MdGeometricObjectsController(Session session, HibernateUtilXml hibernateUtilXml) {
        this.hibernateUtilXml = hibernateUtilXml;
        this.session = session;
    }

    public BigDecimal getMaxMdGeometricObjectsId() {

        BigDecimal maxId = null;

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdGeometricObjects.class);
            criteria.addOrder(Order.desc("id"));
            criteria.setMaxResults(1);
            List results = criteria.list();

            if (results.size() > 0) {
                maxId = ((MdGeometricObjects) results.get(0)).getId();
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

    public MdGeometricObjects getDataById(BigDecimal Id) {

        MdGeometricObjects mdGeometricObjects = new MdGeometricObjects();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdGeometricObjects.class);
            criteria.add(Restrictions.eq("mdVectorSpatialRepresentId", Id));

            mdGeometricObjects = (MdGeometricObjects) criteria.uniqueResult();

            if (mdGeometricObjects == null) {
                return null;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally {
            //session.close();
        }

        return mdGeometricObjects;
    }

    public String deletedMdGeometricObjects(BigDecimal Id) {

        MdGeometricObjects mdGeometricObjects = new MdGeometricObjects();
        List list = new ArrayList();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdGeometricObjects.class);
            criteria.add(Restrictions.eq("id", Id));
//            criteria.setMaxResults(3);
//            
//            list = criteria.list();
//            Iterator iterator = list.iterator();
//
//            while (iterator.hasNext()) {

            mdGeometricObjects = (MdGeometricObjects)criteria.uniqueResult();
            session.delete(mdGeometricObjects);
               
  //          }
            
            trx.commit();
            return "berhasil dihapus.....!!";
            
        } catch (Exception e) {
             trx.rollback();
             return "Error "+e.getMessage();
        } finally {
            //session.close();
        }

    }
    
    public MdGeometricObjects getDataById(BigDecimal Id, BigDecimal idMdGeometricObject) {

        MdGeometricObjects mdGeometricObjects = new MdGeometricObjects();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdGeometricObjects.class);
            criteria.add(Restrictions.eq("mdVectorSpatialRepresentId", Id))
                    .add(Restrictions.eq("id", idMdGeometricObject));

            mdGeometricObjects = (MdGeometricObjects) criteria.uniqueResult();

            if (mdGeometricObjects == null) {
                return null;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally {
            //session.close();
        }

        return mdGeometricObjects;
    }

    public long getNumberOfRecord(BigDecimal Id) {

        // MdGeometricObjects mdGeometricObjects = new MdGeometricObjects();
        long count = 0;

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdGeometricObjects.class);
            criteria.add(Restrictions.eq("mdVectorSpatialRepresentId", Id));
            criteria.setProjection(Projections.rowCount());
            count = (long) criteria.uniqueResult();

            // mdGeometricObjects = (MdGeometricObjects) criteria.uniqueResult();
            if (count == 0) {
                return 0;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally {
            //session.close();
        }

        return count;
    }

    public MdGeometricObjects getDataByProperty(BigDecimal Id, BigDecimal geometricObjectCount, String code) {

        MdGeometricObjects mdGeometricObjects = new MdGeometricObjects();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdGeometricObjects.class);
            criteria.add(Restrictions.eq("mdVectorSpatialRepresentId", Id))
                    .add(Restrictions.eq("geometricObjectCount", geometricObjectCount))
                    .add(Restrictions.eq("geometricObjectType", code));

            mdGeometricObjects = (MdGeometricObjects) criteria.uniqueResult();

            if (mdGeometricObjects == null) {
                return null;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally {
            //session.close();
        }

        return mdGeometricObjects;
    }
    
    public MdGeometricObjects getDataByProperty(BigDecimal Id, String code) {

        MdGeometricObjects mdGeometricObjects = new MdGeometricObjects();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdGeometricObjects.class);
            criteria.add(Restrictions.eq("mdVectorSpatialRepresentId", Id))
                    .add(Restrictions.eq("geometricObjectType", code));

            mdGeometricObjects = (MdGeometricObjects) criteria.uniqueResult();

            if (mdGeometricObjects == null) {
                return null;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally {
            //session.close();
        }

        return mdGeometricObjects;
    }

    public String saveMdGeometricObjects(MdGeometricObjectsModel mdModel) {
        MdGeometricObjects MdGeometricObjects = new MdGeometricObjects();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();
        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            MdGeometricObjects.setId(mdModel.getId());
            MdGeometricObjects.setGeometricObjectCount(mdModel.getGeometricObjectCount());
            MdGeometricObjects.setGeometricObjectType(mdModel.getGeometricObjectType());
            MdGeometricObjects.setMdVectorSpatialRepresentId(mdModel.getMdVectorSpatialRepresentId());

            session.save(MdGeometricObjects);
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

        MdGeometricObjects mdGeometricObjects = new MdGeometricObjects();
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

            Criteria criteria = session.createCriteria(MdGeometricObjects.class);
            criteria.add(Restrictions.eq("mdVectorSpatialRepresentId", Id));
            criteria.setMaxResults(3);

            list = criteria.list();
            Iterator iterator = list.iterator();

            while (iterator.hasNext()) {

                mdGeometricObjects = (MdGeometricObjects) iterator.next();
                id.add(mdGeometricObjects.getId());
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


    public String updateMdGeometricObject(BigDecimal id,MdGeometricObjectsModel mdModel) {

        MdGeometricObjects mdGeometricObjects = new MdGeometricObjects();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdGeometricObjects.class);
            criteria.add(Restrictions.eq("id",id));
            mdGeometricObjects = (MdGeometricObjects) criteria.uniqueResult();

            mdGeometricObjects.setGeometricObjectCount(mdModel.getGeometricObjectCount());
            mdGeometricObjects.setGeometricObjectType(mdModel.getGeometricObjectType());
            mdGeometricObjects.setMdVectorSpatialRepresentId(mdModel.getMdVectorSpatialRepresentId());

            session.update(mdGeometricObjects);
            trx.commit();

            return "berhasil diubah.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
    }

    public String updateMdGeometricObjectProperty(MdGeometricObjectsModel mdModel) {

        MdGeometricObjects mdGeometricObjects = new MdGeometricObjects();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdGeometricObjects.class);
            criteria.add(Restrictions.eq("mdVectorSpatialRepresentId", mdModel.getMdVectorSpatialRepresentId()))
                    .add(Restrictions.eq("geometricObjectCount", mdModel.getGeometricObjectCount()))
                    .add(Restrictions.eq("geometricObjectType", mdModel.getGeometricObjectType()));
            mdGeometricObjects = (MdGeometricObjects) criteria.uniqueResult();

            mdGeometricObjects.setGeometricObjectCount(mdModel.getGeometricObjectCount());
            mdGeometricObjects.setGeometricObjectType(mdModel.getGeometricObjectType());
            mdGeometricObjects.setMdVectorSpatialRepresentId(mdModel.getMdVectorSpatialRepresentId());

            session.update(mdGeometricObjects);
            trx.commit();

            return "updated successfully.....!!";
        } catch (Exception e) {
            trx.rollback();
            return e.getMessage();
        } finally {
            //session.close();
        }
    }
}
