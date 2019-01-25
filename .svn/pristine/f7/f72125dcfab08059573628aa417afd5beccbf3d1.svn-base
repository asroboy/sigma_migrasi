/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtil;
import config.HibernateUtilXml;
import domain.MdFeatureCatalogueDescLang;
import model.table.MdFeatureCatalogueDescLangModel;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Fauzy Ramedia
 */
public class MdFeatureCatalogueDescLangController {

    HibernateUtilXml hibernateUtilXml;

    public MdFeatureCatalogueDescLangController(HibernateUtilXml hibernateUtilXml) {
        this.hibernateUtilXml = hibernateUtilXml;

    }

    public String saveMdFeatureCatalogueDescLang(MdFeatureCatalogueDescLangModel mdModel) {
        MdFeatureCatalogueDescLang MdFeatureCatalogueDescLang = new MdFeatureCatalogueDescLang();

        Session session = hibernateUtilXml.buildSession().openSession();
         Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            MdFeatureCatalogueDescLang.setMdFeatureCatalogueDescId(mdModel.getMdFeatureCatalogueDescId());
            MdFeatureCatalogueDescLang.setLanguage(mdModel.getLanguage());

            session.save(MdFeatureCatalogueDescLang);
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
