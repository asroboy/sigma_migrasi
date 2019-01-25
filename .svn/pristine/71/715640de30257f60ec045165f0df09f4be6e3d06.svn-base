/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtil;
import config.HibernateUtilXml;
import domain.MdMaintenanceInfoNote;
import model.table.MdMaintenanceInfoNoteModel;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Fauzy Ramedia
 */
public class MdMaintenanceInfoNoteController {

    HibernateUtilXml hibernateUtilXml;

    public MdMaintenanceInfoNoteController(HibernateUtilXml hibernateUtilXml) {
        this.hibernateUtilXml = hibernateUtilXml;

    }

    public String saveMdMaintenanceInfoNote(MdMaintenanceInfoNoteModel mdModel) {
        MdMaintenanceInfoNote MdMaintenanceInfoNote = new MdMaintenanceInfoNote();

        Session session = hibernateUtilXml.buildSession().openSession();
        Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            MdMaintenanceInfoNote.setMdMaintenanceInfoId(mdModel.getMdMaintenanceInfoId());
            MdMaintenanceInfoNote.setMaintenanceNote(mdModel.getMaintenanceNote());

            session.save(MdMaintenanceInfoNote);
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
