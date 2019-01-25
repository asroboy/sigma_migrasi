/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtil;
import config.HibernateUtilXml;
import domain.MdGeorectified;
import java.math.BigDecimal;
import java.util.List;
import model.table.MdGeorectifiedModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Fauzy Ramedia
 */
public class MdGeorectifiedController {

    HibernateUtilXml hibernateUtilXml;

    public MdGeorectifiedController(HibernateUtilXml hibernateUtilXml) {
        this.hibernateUtilXml = hibernateUtilXml;

    }

    public long getMaxMdGeorectifiedId() {
        long x = 999;
        long maxId = 1;

        Session session = hibernateUtilXml.buildSession().openSession();
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdGeorectified.class);
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

    public String saveMdGeorectified(MdGeorectifiedModel mdModel) {
        MdGeorectified MdGeorectified = new MdGeorectified();

        Session session = hibernateUtilXml.buildSession().openSession();
        Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            MdGeorectified.setCenterPoint(mdModel.getCenterPoint());
            MdGeorectified.setCheckPointAvailability(mdModel.getCheckPointAvailability());
            MdGeorectified.setCheckPointDescription(mdModel.getCheckPointDescription());
            MdGeorectified.setTransformationDimensionDesc(mdModel.getTransformationDimensionDesc());
            MdGeorectified.setId(mdModel.getId());
            MdGeorectified.setPointInPixel(mdModel.getPointInPixel());

            session.save(MdGeorectified);
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
