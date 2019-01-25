/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtil;
import config.HibernateUtilXml;
import domain.MdFeatureCatalogueDescType;
import model.table.MdFeatureCatalogueDescTypeModel;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Fauzy Ramedia
 */
public class MdFeatureCatalogueDescTypeController {

    HibernateUtilXml hibernateUtilXml;

    public MdFeatureCatalogueDescTypeController(HibernateUtilXml hibernateUtilXml) {
        this.hibernateUtilXml = hibernateUtilXml;

    }

    public String saveMdFeatureCatalogueDescType(MdFeatureCatalogueDescTypeModel mdModel) {
        MdFeatureCatalogueDescType MdFeatureCatalogueDescType = new MdFeatureCatalogueDescType();

        Session session = hibernateUtilXml.buildSession().openSession();
        Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            MdFeatureCatalogueDescType.setMdFeatureCatalogueDescId(mdModel.getMdFeatureCatalogueDescId());
            MdFeatureCatalogueDescType.setFeatureTypes(mdModel.getFeatureTypes());

            session.save(MdFeatureCatalogueDescType);
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
