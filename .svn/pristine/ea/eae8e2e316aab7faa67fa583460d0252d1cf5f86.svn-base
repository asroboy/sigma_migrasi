/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtil;
import config.HibernateUtilXml;
import domain.SvOperationMetadataDcp;
import model.table.SvOperationMetadataDcpModel;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Fauzy Ramedia
 */
public class SvOperationMetadataDcpController {

    HibernateUtilXml hibernateUtilXml;

    public SvOperationMetadataDcpController(HibernateUtilXml hibernateUtilXml) {
        this.hibernateUtilXml = hibernateUtilXml;

    }

    public String saveSvOperationMetadataDcp(SvOperationMetadataDcpModel mdModel) {
        SvOperationMetadataDcp SvOperationMetadataDcp = new SvOperationMetadataDcp();

        Session session = hibernateUtilXml.buildSession().openSession();
       Transaction trx = session.getTransaction();
        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            SvOperationMetadataDcp.setSvOperationMetadataId(mdModel.getSvOperationMetadataId());
            SvOperationMetadataDcp.setDcp(mdModel.getDcp());

            session.save(SvOperationMetadataDcp);
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
