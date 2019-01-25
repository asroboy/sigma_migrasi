/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtil;
import config.HibernateUtilXml;
import domain.MdStandardOrderProcess;
import java.math.BigDecimal;
import java.util.List;
import model.table.MdStandardOrderProcessModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Fauzy Ramedia
 */
public class MdStandardOrderProcessController {

    HibernateUtilXml hibernateUtilXml;

    public MdStandardOrderProcessController(HibernateUtilXml hibernateUtilXml) {
        this.hibernateUtilXml = hibernateUtilXml;

    }

    public long getMaxMdStandardOrderProcessId() {
        long x = 999;
        long maxId = 1;

        Session session = hibernateUtilXml.buildSession().openSession();
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdStandardOrderProcess.class);
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

    public String saveMdStandardOrderProcess(MdStandardOrderProcessModel mdModel) {
        MdStandardOrderProcess MdStandardOrderProcess = new MdStandardOrderProcess();

        Session session = hibernateUtilXml.buildSession().openSession();
       Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            MdStandardOrderProcess.setId(mdModel.getId());
            MdStandardOrderProcess.setFees(mdModel.getFees());
            MdStandardOrderProcess.setOrderingInstruction(mdModel.getOrderingInstruction());
            MdStandardOrderProcess.setPlannedAvailableDateTime(mdModel.getPlannedAvailableDateTime());
            MdStandardOrderProcess.setTurnAround(mdModel.getTurnAround());
            MdStandardOrderProcess.setMdDistributorId(mdModel.getMdDistributorId());
            MdStandardOrderProcess.setSvServiceIdentificationId(mdModel.getSvServiceIdentificationId());

            session.save(MdStandardOrderProcess);
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
