/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtilXml;
import domain.ExBoundingPolygon;
import domain.ExBoundingPolygonPolygon;
import java.math.BigDecimal;
import java.util.List;
import model.table.ExBoundingPolygonModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author wallet
 */
public class ExBoundingPolygonController {
    
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
    
    public ExBoundingPolygonController() {

    }

    public ExBoundingPolygonController(Session session, HibernateUtilXml hibernateUtilXml) {
        this.hibernateUtilXml = hibernateUtilXml;
        this.session = session;
    }

    public ExBoundingPolygon getDataById(BigDecimal Id) {

        ExBoundingPolygon exGeographicBoundingBox = new ExBoundingPolygon();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(ExBoundingPolygon.class);
            criteria.add(Restrictions.eq("exGeographicExtentId", Id));
            exGeographicBoundingBox = (ExBoundingPolygon) criteria.uniqueResult();

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
    
    public String deletedExBoundingPolygon(BigDecimal Id) {

        ExBoundingPolygon ex = new ExBoundingPolygon();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(ExBoundingPolygon.class);
            criteria.add(Restrictions.eq("exGeographicExtentId", Id));
            ex = (ExBoundingPolygon) criteria.uniqueResult();

           
            session.delete(ex);
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
  

    public String saveExBoundingPolygon(ExBoundingPolygonModel extentModel) {

        ExBoundingPolygon ex = new ExBoundingPolygon();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            ex.setExGeographicExtentId(extentModel.getExGeographicExtentId());

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

    public String updateExBoundingPolygon(ExBoundingPolygonModel mdModel) {

        ExBoundingPolygon ex = new ExBoundingPolygon();

        if (!session.isOpen()) {
            session = hibernateUtilXml.buildSession().openSession();
        }
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(ExBoundingPolygon.class);
            criteria.add(Restrictions.eq("exGeographicExtentId", mdModel.getExGeographicExtentId()));
            ex = (ExBoundingPolygon) criteria.uniqueResult();

            ex.setExGeographicExtentId(mdModel.getExGeographicExtentId());

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
