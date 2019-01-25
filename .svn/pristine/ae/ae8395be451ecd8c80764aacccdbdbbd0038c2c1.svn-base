/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtil;
import config.HibernateUtilXml;
import domain.MdGeorectifiedTransMapping;
import model.table.MdGeorectifiedTransMappingModel;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Fauzy Ramedia
 */
public class MdGeorectifiedTransMappingController {

    HibernateUtilXml hibernateUtilXml;

    public MdGeorectifiedTransMappingController(HibernateUtilXml hibernateUtilXml) {
        this.hibernateUtilXml = hibernateUtilXml;

    }

    public String saveMdGeorectifiedTransMapping(MdGeorectifiedTransMappingModel mdModel) {
        MdGeorectifiedTransMapping MdGeorectifiedTransMapping = new MdGeorectifiedTransMapping();

        Session session = hibernateUtilXml.buildSession().openSession();
       Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            MdGeorectifiedTransMapping.setMdGeorecitifedId(mdModel.getMdGeorecitifedId());
            MdGeorectifiedTransMapping.setTranformationDimensionMapping(mdModel.getTranformationDimensionMapping());

            session.save(MdGeorectifiedTransMapping);
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
