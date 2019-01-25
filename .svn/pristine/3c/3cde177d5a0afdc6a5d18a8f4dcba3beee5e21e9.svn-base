/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtil;
import config.HibernateUtilXml;
import domain.MdGeorectifiedCornerPoints;
import model.table.MdGeorectifiedCornerPointsModel;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Fauzy Ramedia
 */
public class MdGeorectifiedCornerPointsController {

    HibernateUtilXml hibernateUtilXml;

    public MdGeorectifiedCornerPointsController(HibernateUtilXml hibernateUtilXml) {
        this.hibernateUtilXml = hibernateUtilXml;

    }

    public String saveMdGeorectifiedCornerPoints(MdGeorectifiedCornerPointsModel mdModel) {
        MdGeorectifiedCornerPoints MdGeorectifiedCornerPoints = new MdGeorectifiedCornerPoints();

        Session session = hibernateUtilXml.buildSession().openSession();
      Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            MdGeorectifiedCornerPoints.setMdGeorectifiedId(mdModel.getMdGeorectifiedId());
            MdGeorectifiedCornerPoints.setCornerPoints(mdModel.getCornerPoints());

            session.save(MdGeorectifiedCornerPoints);
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
