/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtil;
import config.HibernateUtilXml;
import domain.SvOperationMetadata;
import java.math.BigDecimal;
import java.util.List;
import model.table.SvOperationMetadataModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Fauzy Ramedia
 */
public class SvOperationMetadataController {

    HibernateUtilXml hibernateUtilXml;

    public SvOperationMetadataController(HibernateUtilXml hibernateUtilXml) {
        this.hibernateUtilXml = hibernateUtilXml;

    }

    public long getMaxSvOperationMetadataId() {
        long x = 999;
        long maxId = 1;

        Session session = hibernateUtilXml.buildSession().openSession();
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(SvOperationMetadata.class);
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

    public String saveSvOperationMetadata(SvOperationMetadataModel mdModel) {
        SvOperationMetadata SvOperationMetadata = new SvOperationMetadata();

        Session session = hibernateUtilXml.buildSession().openSession();
        Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            SvOperationMetadata.setId(mdModel.getId());
            SvOperationMetadata.setInvocationName(mdModel.getInvocationName());
            SvOperationMetadata.setOperationDescription(mdModel.getOperationDescription());
            SvOperationMetadata.setOperationName(mdModel.getOperationName());
            SvOperationMetadata.setSvOperationMetadataId(mdModel.getSvOperationMetadataId());
            SvOperationMetadata.setSvServiceIdentificationId(mdModel.getSvServiceIdentificationId());

            session.save(SvOperationMetadata);
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
