/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtilXml;
import domain.MdDataIdentificationCharset;
import java.math.BigDecimal;
import model.table.MdDataIdentificationCharsetModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author wallet
 */
public class MdDataIdentificationCharsetController {

    public MdDataIdentificationCharsetController() {
    }

    HibernateUtilXml hibernateUtilXml;
    Session session;

    public MdDataIdentificationCharsetController(Session session, HibernateUtilXml hibernateUtilXml) {
        this.hibernateUtilXml = hibernateUtilXml;
        this.session = session;
    }

    public MdDataIdentificationCharset getDataById(BigDecimal Id) {

        MdDataIdentificationCharset charset = new MdDataIdentificationCharset();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdDataIdentificationCharset.class);
            criteria.add(Restrictions.eq("mdDataIdentificationId", Id));
            charset = (MdDataIdentificationCharset) criteria.uniqueResult();

            if (charset == null) {
                return null;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally {
            //session.close();
        }

        return charset;
    }
    
    public String deletedMdDataIdentificationCharset(BigDecimal Id) {

        MdDataIdentificationCharset charset = new MdDataIdentificationCharset();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdDataIdentificationCharset.class);
            criteria.add(Restrictions.eq("mdDataIdentificationId", Id));
            charset = (MdDataIdentificationCharset) criteria.uniqueResult();

            session.delete(charset);
            trx.commit();
            
            return "berhasil dihapus......!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
    }

    public String saveMdDataIdentificationCharset(MdDataIdentificationCharsetModel mdDataIdentificationCharsetModel) {
        MdDataIdentificationCharset mdDataIdentificationCharset = new MdDataIdentificationCharset();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
         Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            mdDataIdentificationCharset.setMdDataIdentificationId(mdDataIdentificationCharsetModel.getMdDataIdentificationId());
            mdDataIdentificationCharset.setCharacterSet(mdDataIdentificationCharsetModel.getCharacterSet());

            //System.out.println(md);
            session.save(mdDataIdentificationCharset);
            trx.commit();

            return "berhasil disimpan.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
    }

    public String updateMdDataIdentificationCharset(BigDecimal id,MdDataIdentificationCharsetModel mdModel) {

        MdDataIdentificationCharset charset = new MdDataIdentificationCharset();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdDataIdentificationCharset.class);
            criteria.add(Restrictions.eq("mdDataIdentificationId", id));
            charset = (MdDataIdentificationCharset) criteria.uniqueResult();
            
            charset.setCharacterSet(mdModel.getCharacterSet());

            session.update(charset);
            trx.commit();

            return "berhasil diubah.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
    }

}
