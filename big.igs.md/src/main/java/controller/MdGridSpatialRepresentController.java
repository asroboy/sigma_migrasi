/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtil;
import config.HibernateUtilXml;
import domain.MdGridSpatialRepresent;
import java.math.BigDecimal;
import java.util.List;
import model.table.MdGridSpatialRepresentModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Fauzy Ramedia
 */
public class MdGridSpatialRepresentController {

    HibernateUtilXml hibernateUtilXml;

    public MdGridSpatialRepresentController(HibernateUtilXml hibernateUtilXml) {
        this.hibernateUtilXml = hibernateUtilXml;

    }

    public long getMaxMdGridSpatialRepresentId() {
        long x = 999;
        long maxId = 1;

        Session session = hibernateUtilXml.buildSession().openSession();
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdGridSpatialRepresent.class);
            criteria.add(Restrictions.ne("id", new BigDecimal(x)));
            criteria.setMaxResults(1);
            List results = criteria.list();

            if (results.size() > 0) {
                maxId = 1;
            } else {
                maxId = results.size() + 1;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally {
            //session.close();
        }

        return maxId;
    }

    public String saveMdGridSpatialRepresent(MdGridSpatialRepresentModel mdModel) {
        MdGridSpatialRepresent MdGridSpatialRepresent = new MdGridSpatialRepresent();

        Session session = hibernateUtilXml.buildSession().openSession();
        Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            MdGridSpatialRepresent.setNumberOfDimensions(mdModel.getNumberOfDimensions());
            MdGridSpatialRepresent.setTransformationParamAvail(mdModel.getTransformationParamAvail());
            MdGridSpatialRepresent.setId(mdModel.getId());
            MdGridSpatialRepresent.setCellGeometry(mdModel.getCellGeometry());

            session.save(MdGridSpatialRepresent);
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
