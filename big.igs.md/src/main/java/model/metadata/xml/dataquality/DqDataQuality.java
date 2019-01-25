/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.metadata.xml.dataquality;

import model.metadata.xml.ParentElement;
import model.metadata.xml.dataquality.subelement.DqAbsoluteExternalPositionalAccuracy;
import model.metadata.xml.dataquality.subelement.DqAccuracyOfATimeMeasurement;
import model.metadata.xml.dataquality.subelement.DqCompletenessCommission;
import model.metadata.xml.dataquality.subelement.DqCompletenessOmission;
import model.metadata.xml.dataquality.subelement.DqConceptualConsistency;
import model.metadata.xml.dataquality.subelement.DqDomainConsistency;
import model.metadata.xml.dataquality.subelement.DqFormatConsistency;
import model.metadata.xml.dataquality.subelement.DqGriddedDataPositionalAccuracy;
import model.metadata.xml.dataquality.subelement.DqNonQuantitativeAttributeAccuracy;
import model.metadata.xml.dataquality.subelement.DqQuantitativeAttributeAccuracy;
import model.metadata.xml.dataquality.subelement.DqRelativeInternalPositionalAccuracy;
import model.metadata.xml.dataquality.subelement.DqScope;
import model.metadata.xml.dataquality.subelement.DqTemporalConsistency;
import model.metadata.xml.dataquality.subelement.DqTemporalValidity;
import model.metadata.xml.dataquality.subelement.DqThematicClassificationCorrectness;
import model.metadata.xml.dataquality.subelement.DqTopologicalConsistency;
import model.metadata.xml.dataquality.lilineage.LiLineage;

/**
 *
 * @author wallet
 */
public class DqDataQuality {
    
    private String current="gmd:DQ_DataQuality";
    private String subparent;
    private DqScope dqScope;
    private DqCompletenessCommission dqCompletenessCommission;
    private DqCompletenessOmission dqCompletenessOmission;
    private DqConceptualConsistency dqConceptualConsistency;
    private DqDomainConsistency dqDomainConsistency;
    private DqFormatConsistency dqFormatConsistency;
    private DqTopologicalConsistency dqTopologicalConsistency;
    private DqAbsoluteExternalPositionalAccuracy dqAbsoluteExternalPositionalAccuracy;
    private DqGriddedDataPositionalAccuracy dqGriddedDataPositionalAccuracy;
    private DqRelativeInternalPositionalAccuracy dqRelativeInternalPositionalAccuracy;
    private DqThematicClassificationCorrectness dqThematicClassificationCorrectness;
    private DqNonQuantitativeAttributeAccuracy dqNonQuantitativeAttributeAccuracy;
    private DqQuantitativeAttributeAccuracy dqQuantitativeAttributeAccuracy;
    private DqAccuracyOfATimeMeasurement dqAccuracyOfATimeMeasurement;
    private DqTemporalConsistency dqTemporalConsistency;
    private DqTemporalValidity dqTemporalValidity;
    private LiLineage liLineage;

    public DqDataQuality(String parent) {
        this.subparent = parent+"."+current;
    }
    
    public String Current() {
        return this.subparent;
    }

    public DqScope DqScope() {
        dqScope = new DqScope(subparent+"."+ParentElement.SCOPE);
        return dqScope;
    }

    public DqCompletenessCommission DqCompletenessCommission() {
        dqCompletenessCommission = new DqCompletenessCommission(subparent+"."+ParentElement.REPORT);
        return dqCompletenessCommission;
    }

    public DqCompletenessOmission DqCompletenessOmission() {
        dqCompletenessOmission = new DqCompletenessOmission(subparent+"."+ParentElement.REPORT);
        return dqCompletenessOmission;
    }

    public DqConceptualConsistency DqConceptualConsistency() {
        dqConceptualConsistency = new DqConceptualConsistency(subparent+"."+ParentElement.REPORT);
        return dqConceptualConsistency;
    }

    public DqDomainConsistency DqDomainConsistency() {
        dqDomainConsistency = new DqDomainConsistency(subparent+"."+ParentElement.REPORT);
        return dqDomainConsistency;
    }

    public DqFormatConsistency DqFormatConsistency() {
        dqFormatConsistency = new DqFormatConsistency(subparent+"."+ParentElement.REPORT);
        return dqFormatConsistency;
    }

    public DqTopologicalConsistency DqTopologicalConsistency() {
        dqTopologicalConsistency = new DqTopologicalConsistency(subparent+"."+ParentElement.REPORT);
        return dqTopologicalConsistency;
    }

    public DqAbsoluteExternalPositionalAccuracy DqAbsoluteExternalPositionalAccuracy() {
        dqAbsoluteExternalPositionalAccuracy = new DqAbsoluteExternalPositionalAccuracy(subparent+"."+ParentElement.REPORT);
        return dqAbsoluteExternalPositionalAccuracy;
    }

    public DqGriddedDataPositionalAccuracy DqGriddedDataPositionalAccuracy() {
        dqGriddedDataPositionalAccuracy = new DqGriddedDataPositionalAccuracy(subparent+"."+ParentElement.REPORT);
        return dqGriddedDataPositionalAccuracy;
    }

    public DqThematicClassificationCorrectness DqThematicClassificationCorrectness() {
        dqThematicClassificationCorrectness = new DqThematicClassificationCorrectness(subparent+"."+ParentElement.REPORT);
        return dqThematicClassificationCorrectness;
    }

    public DqNonQuantitativeAttributeAccuracy DqNonQuantitativeAttributeAccuracy() {
        dqNonQuantitativeAttributeAccuracy = new DqNonQuantitativeAttributeAccuracy(subparent+"."+ParentElement.REPORT);
        return dqNonQuantitativeAttributeAccuracy;
    }

    public DqQuantitativeAttributeAccuracy DqQuantitativeAttributeAccuracy() {
        dqQuantitativeAttributeAccuracy = new DqQuantitativeAttributeAccuracy(subparent+"."+ParentElement.REPORT);
        return dqQuantitativeAttributeAccuracy;
    }

    public DqAccuracyOfATimeMeasurement DqAccuracyOfATimeMeasurement() {
        dqAccuracyOfATimeMeasurement = new DqAccuracyOfATimeMeasurement(subparent+"."+ParentElement.REPORT);
        return dqAccuracyOfATimeMeasurement;
    }

    public DqTemporalConsistency DqTemporalConsistency() {
        dqTemporalConsistency = new DqTemporalConsistency(subparent+"."+ParentElement.REPORT);
        return dqTemporalConsistency;
    }

    public DqTemporalValidity DqTemporalValidity() {
        dqTemporalValidity = new DqTemporalValidity(subparent+"."+ParentElement.REPORT);
        return dqTemporalValidity;
    }

    public DqRelativeInternalPositionalAccuracy DqRelativeInternalPositionalAccuracy() {
        dqRelativeInternalPositionalAccuracy = new DqRelativeInternalPositionalAccuracy(subparent+"."+ParentElement.REPORT);
        return dqRelativeInternalPositionalAccuracy;
    }
    
    public LiLineage LiLineage() {
        liLineage = new LiLineage(subparent+"."+ParentElement.LINEAGE);
        return liLineage;
    }
    
    
    
}
