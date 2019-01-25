/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtilXml;
import domain.ExBoundingPolygonPolygon;
import java.math.BigDecimal;
import java.util.List;
import model.table.ExBoundingPolygonPolygonModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author wallet
 */
public class ExBoundingPolygonPolygonController {
    
    private HibernateUtilXml hibernateUtilXml;
    private Session session;
    private String tagOpen="<gml:Polygon gml:id=\"--\">";
    private String tagClose="</gml:Polygon>";
    private String[] valueUnit={
            "<gml:description>--</gml:description>",
            "<gml:descriptionReference>---</gml:descriptionReference>",
            "<gml:identifier>---</gml:identifier>",
            "<gml:metaDataProperty><gml:GenericMetaData>--</gml:GenericMetaData></gml:metaDataProperty>",
            "<gml:name>---</gml:name>",
    };                               
                                    
    private String[] val={
            "gml:description",
            "gml:descriptionReference",
            "gml:identifier",
            "gml:metaDataProperty",
            "gml:name",
    };
    
    public ExBoundingPolygonPolygonController() {

    }

    public ExBoundingPolygonPolygonController(Session session, HibernateUtilXml hibernateUtilXml) {
        this.hibernateUtilXml = hibernateUtilXml;
        this.session = session;
    }

    public ExBoundingPolygonPolygon getDataById(BigDecimal Id) {

        ExBoundingPolygonPolygon exGeographicBoundingBox = new ExBoundingPolygonPolygon();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(ExBoundingPolygonPolygon.class);
            criteria.add(Restrictions.eq("exBoundingPolygonId", Id));
            exGeographicBoundingBox = (ExBoundingPolygonPolygon) criteria.uniqueResult();

            if (exGeographicBoundingBox == null) {
                return null;
            }

            trx.commit();
        } catch (Exception e) {
            trx.rollback();
            e.printStackTrace();
        } finally {
            //session.close();
        }

        return exGeographicBoundingBox;
    }
    
    public String deletedExBoundingPolygonPolygon(BigDecimal Id) {

        ExBoundingPolygonPolygon exGeographicBoundingBox = new ExBoundingPolygonPolygon();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(ExBoundingPolygonPolygon.class);
            criteria.add(Restrictions.eq("exBoundingPolygonId", Id));
            exGeographicBoundingBox = (ExBoundingPolygonPolygon) criteria.uniqueResult();

           
            session.delete(exGeographicBoundingBox);
            trx.commit();
            
             return "berhasil dihapus.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }

    }
    
    public String listToStringTag(List list){
        
        String tagElement="";
        tagElement+=tagOpen+"\n";

        for(int i=0;i<list.size();i++){
           
            try{

                String tag=list.get(i).toString().split("_:_")[0];
                String value=list.get(i).toString().split("_:_")[1];

                if(!value.contains("null")){

                    if(tag.equals(val[i])){
                        tagElement+=valueUnit[i].replace("-", value);
                        tagElement+="\n";

                    }
                }
            }catch(ArrayIndexOutOfBoundsException ae){}
        }
        
        tagElement+=tagClose;
        
        return tagElement;
    
    }
  

    public String saveExBoundingPolygonPolygon(ExBoundingPolygonPolygonModel extentModel) {

        ExBoundingPolygonPolygon ex = new ExBoundingPolygonPolygon();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            ex.setExBoundingPolygonId(extentModel.getExBoundingPolygonId());
            ex.setPolygon(extentModel.getPolygon());

            session.save(ex);
            trx.commit();

            return "berhasil disimpan.....!!";
        } catch (Exception e) {
            trx.rollback();
            return "Error "+e.getMessage();
        } finally {
            //session.close();
        }
    }

    public String updateExBoundingPolygonPolygon(ExBoundingPolygonPolygonModel mdModel) {

        ExBoundingPolygonPolygon ex = new ExBoundingPolygonPolygon();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(ExBoundingPolygonPolygon.class);
            criteria.add(Restrictions.eq("exBoundingPolygonId", mdModel.getExBoundingPolygonId()));
            ex = (ExBoundingPolygonPolygon) criteria.uniqueResult();

            ex.setPolygon(mdModel.getPolygon());

            session.update(ex);
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
