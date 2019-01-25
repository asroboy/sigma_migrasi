/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtilXml;
import domain.MdKeyword;
import domain.MdMetadata;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import model.table.MdMetadataModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author USER DELL
 */
public class MdMetadataController {

    HibernateUtilXml hibernateUtilXml;
    Session session;

    public MdMetadataController() {
    }

    public MdMetadataController(Session session, HibernateUtilXml hibernateUtilXml) {
        this.hibernateUtilXml = hibernateUtilXml;
        this.session = session;
    }
    
    public String checkFileidentifier(String fileIdentifier){
        
//        String newIdentifier = "";
//        boolean isBlankSpaceInFirst = fileIdentifier.charAt(0) == ' ';
//
//        if (isBlankSpaceInFirst) {
//            newIdentifier = fileIdentifier.replace(" ", "").toUpperCase();
//        } else {
//            newIdentifier = fileIdentifier.toUpperCase();
//        }
        
        return fileIdentifier.toUpperCase().trim();
        
    }    

    public BigDecimal getMaxMetadataId() {
        BigDecimal maxId = null;

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdMetadata.class);
            criteria.addOrder(Order.desc("id"));
            criteria.setMaxResults(1);
            List results = criteria.list();

            if (results.size() > 0) {
                maxId = ((MdMetadata) results.get(0)).getId();
            } else {
                //  maxId = 0;
            }

            trx.commit();

        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        }
        System.out.println("Session close");
        ////session.close();
        return maxId;
    }

    public MdMetadata getDataById(String column, String fileIdentifier) {
        MdMetadata md = new MdMetadata();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdMetadata.class);
            criteria.add(Restrictions.eq(column, fileIdentifier).ignoreCase());
            md = (MdMetadata) criteria.uniqueResult();

            if (md == null) {
                return null;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally {
            System.out.println("Session close");
            ////session.close();
        }

        return md;
    }
    
    
    public List getAllFileIdentifier() {
        
        List list = new ArrayList();
        List fileIdentifier = new ArrayList();
        
        MdMetadata md = new MdMetadata();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdMetadata.class);
            list = criteria.list();
            Iterator iterator = list.iterator();
            
            while (iterator.hasNext()) {

                md = (MdMetadata) iterator.next();
                fileIdentifier.add(md.getFileidentifier());
            }
            
            if (list.size() == 0) {
                 return null;
            }
            
            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally {
            //System.out.println("Session close");
            //session.close();
        }

        return fileIdentifier;
    }

    public String saveMdMetadata(MdMetadataModel mdModel) {
        MdMetadata md = new MdMetadata();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
       Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            md.setId(mdModel.getId());
            md.setDataseturi(mdModel.getDataseturi());
            md.setDatestamp(mdModel.getDatestamp());
            md.setFileidentifier(mdModel.getFileidentifier());
            md.setHarvestid(mdModel.getHarvestid());
            md.setMetadatastandardname(mdModel.getMetadatastandardname());
            md.setMetadatastandardversion(mdModel.getMetadatastandardversion());
            md.setParentidentifier(mdModel.getParentidentifier());
            md.setCharacterset(mdModel.getCharacterset());
            md.setLocale(mdModel.getLocale());

            //System.out.println(md);
            session.save(md);
            trx.commit();

            return "berhasil disimpan.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            System.out.println("Session close");
            ////session.close();
        }
    }

    public String updateMdMetadata(MdMetadataModel mdModel) {
        MdMetadata md = new MdMetadata();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdMetadata.class);
            criteria.add(Restrictions.eq(MdMetadataModel.FILEIDENTIFIER, mdModel.getFileidentifier()));
            md = (MdMetadata) criteria.uniqueResult();

            md.setDataseturi(mdModel.getDataseturi());
            md.setDatestamp(mdModel.getDatestamp());
            md.setFileidentifier(mdModel.getFileidentifier());
            md.setHarvestid(mdModel.getHarvestid());
            md.setMetadatastandardname(mdModel.getMetadatastandardname());
            md.setMetadatastandardversion(mdModel.getMetadatastandardversion());
            md.setParentidentifier(mdModel.getParentidentifier());
            md.setCharacterset(mdModel.getCharacterset());
            md.setLocale(mdModel.getLocale());

            session.update(md);
            trx.commit();

            return "berhasil diubah.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            System.out.println("Session close");
            ////session.close();
        }
    }
    
    public String deletedMdMetadata(String fileIdentifier) {
        MdMetadata md = new MdMetadata();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdMetadata.class);
            criteria.add(Restrictions.eq("fileidentifier", fileIdentifier));
            md = (MdMetadata) criteria.uniqueResult();

            session.delete(md);
            trx.commit();
            
            return "deleted successfully.....!!";
        } catch (Exception e) {
            trx.rollback();
            return e.getMessage();
        } finally {
            System.out.println("Session close");
            ////session.close();
        }
        
    }
    
    public String deletedMdMetadata(BigDecimal id) {
        MdMetadata md = new MdMetadata();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdMetadata.class);
            criteria.add(Restrictions.eq("id", id));
            md = (MdMetadata) criteria.uniqueResult();

            session.delete(md);
            trx.commit();
            
            return "berhasil dihapus.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            System.out.println("Session close");
            ////session.close();
        }
        
    }
}
