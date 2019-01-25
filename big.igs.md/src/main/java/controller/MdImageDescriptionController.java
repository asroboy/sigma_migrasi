/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import config.HibernateUtil;
import config.HibernateUtilXml;
import domain.MdImageDescription;
import java.math.BigDecimal;
import java.util.List;
import model.table.MdImageDescriptionModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Fauzy Ramedia
 */
public class MdImageDescriptionController {

    HibernateUtilXml hibernateUtilXml;

    public MdImageDescriptionController(HibernateUtilXml hibernateUtilXml) {
        this.hibernateUtilXml = hibernateUtilXml;

    }

    public long getMaxMdImageDescriptionId() {
        long x = 999;
        long maxId = 1;

        Session session = hibernateUtilXml.buildSession().openSession();
        Transaction trx = session.beginTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            Criteria criteria = session.createCriteria(MdImageDescription.class);
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

    public String saveMdImageDescription(MdImageDescriptionModel mdModel) {
        MdImageDescription MdImageDescription = new MdImageDescription();

        Session session = hibernateUtilXml.buildSession().openSession();
        Transaction trx = session.getTransaction();

        try {
            if (!trx.isActive()) {
                trx.begin();
            }

            MdImageDescription.setCameraCalibrationInfoAvailable(mdModel.getCameraCalibrationInfoAvailable());
            MdImageDescription.setCloudCoverPercentage(mdModel.getCloudCoverPercentage());
            MdImageDescription.setCompressionGenerationQuantity(mdModel.getCompressionGenerationQuantity());
            MdImageDescription.setFilmDistortionInfoAvailability(mdModel.getFilmDistortionInfoAvailability());
            MdImageDescription.setIlluminationAzimuthAngle(mdModel.getIlluminationAzimuthAngle());
            MdImageDescription.setIllmuniationElevationAngle(mdModel.getIllmuniationElevationAngle());
            MdImageDescription.setLenDistortionInfoAvailability(mdModel.getLenDistortionInfoAvailability());
            MdImageDescription.setRadioMetricCalibDataAvailable(mdModel.getRadioMetricCalibDataAvailable());
            MdImageDescription.setTriangulationIndicator(mdModel.getTriangulationIndicator());
            MdImageDescription.setId(mdModel.getId());
            MdImageDescription.setImagingCondition(mdModel.getImagingCondition());

            session.save(MdImageDescription);
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
