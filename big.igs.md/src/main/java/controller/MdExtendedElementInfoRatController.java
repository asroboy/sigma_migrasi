/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtil;
import config.HibernateUtilXml;
import domain.MdExtendedElementInfoRat;
import model.table.MdExtendedElementInfoRatModel;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Fauzy Ramedia
 */
public class MdExtendedElementInfoRatController {

    HibernateUtilXml hibernateUtilXml;

    public MdExtendedElementInfoRatController(HibernateUtilXml hibernateUtilXml) {
        this.hibernateUtilXml = hibernateUtilXml;

    }

    public String saveMdExtendedElementInfoRat(MdExtendedElementInfoRatModel mdModel) {
        MdExtendedElementInfoRat MdExtendedElementInfoRat = new MdExtendedElementInfoRat();

        Session session = hibernateUtilXml.buildSession().openSession();
         Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            MdExtendedElementInfoRat.setMdExtendedElementInfoId(mdModel.getMdExtendedElementInfoId());
            MdExtendedElementInfoRat.setRationale(mdModel.getRationale());

            session.save(MdExtendedElementInfoRat);
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
