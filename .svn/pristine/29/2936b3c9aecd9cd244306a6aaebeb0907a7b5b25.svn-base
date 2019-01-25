/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtil;
import config.HibernateUtilXml;
import domain.MdMediumDensity;
import model.table.MdMediumDensityModel;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Fauzy Ramedia
 */
public class MdMediumDensityController {

    HibernateUtilXml hibernateUtilXml;

    public MdMediumDensityController(HibernateUtilXml hibernateUtilXml) {
        this.hibernateUtilXml = hibernateUtilXml;

    }

    public String saveMdMediumDensity(MdMediumDensityModel mdModel) {
        MdMediumDensity MdMediumDensity = new MdMediumDensity();

        Session session = hibernateUtilXml.buildSession().openSession();
      Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            MdMediumDensity.setMdMetadataId(mdModel.getMdMetadataId());
            MdMediumDensity.setFloat_(mdModel.getFloat_());

            session.save(MdMediumDensity);
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
