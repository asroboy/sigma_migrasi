/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtil;
import config.HibernateUtilXml;
import domain.MdCellGeometryCode;
import domain.MdClassificationCode;
import domain.MdClassificationCode;
import java.math.BigDecimal;
import java.util.List;
import model.table.MdCellGeometryCodeModel;
import model.table.MdClassificationCodeModel;
import model.table.MdClassificationCodeModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author wallet
 */
public class MdClassificationCodeController {

    HibernateUtilXml hibernateUtilXml;
    Session session;
    
    public MdClassificationCodeController() {
    }

    public MdClassificationCodeController(Session session, HibernateUtilXml hibernateUtilXml) {
        this.hibernateUtilXml = hibernateUtilXml;
        this.session = session;
    }

    public MdClassificationCode getDataByDomain(String domain) {
        MdClassificationCode mdCharacterSetCode = new MdClassificationCode();
        MdClassificationCode mcsc = new MdClassificationCode();
        mcsc.setCode("000");

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdClassificationCode.class);
            criteria.add(Restrictions.eq("domainName", domain).ignoreCase());
            mdCharacterSetCode = (MdClassificationCode) criteria.uniqueResult();

            if (mdCharacterSetCode == null) {
                return mcsc;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally {
            //session.close();
        }

        return mdCharacterSetCode;
    }

    public String saveMdClassificationCode(MdClassificationCodeModel mdCharacterSetCodeModel) {

        MdClassificationCode mdCharacterSetCode = new MdClassificationCode();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
      Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            mdCharacterSetCode.setCode(mdCharacterSetCodeModel.getCode());
            mdCharacterSetCode.setDefinition(mdCharacterSetCodeModel.getDefinition());
            mdCharacterSetCode.setDomainName(mdCharacterSetCodeModel.getDomainName());

            //System.out.println(md);
            session.save(mdCharacterSetCode);
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
