/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtil;
import config.HibernateUtilXml;
import domain.MdMediumFormat;
import model.table.MdMediumFormatModel;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Fauzy Ramedia
 */
public class MdMediumFormatController {

    HibernateUtilXml hibernateUtilXml;

    public MdMediumFormatController(HibernateUtilXml hibernateUtilXml) {
        this.hibernateUtilXml = hibernateUtilXml;

    }

    public String saveMdMediumFormat(MdMediumFormatModel mdModel) {
        MdMediumFormat MdMediumFormat = new MdMediumFormat();

        Session session = hibernateUtilXml.buildSession().openSession();
       Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            MdMediumFormat.setMdMediumId(mdModel.getMdMediumId());
            MdMediumFormat.setMediumFormat(mdModel.getMediumFormat());

            session.save(MdMediumFormat);
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
