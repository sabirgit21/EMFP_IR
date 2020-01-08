package model.EO;

import java.math.BigDecimal;

import java.sql.Timestamp;

import oracle.adf.share.ADFContext;

import oracle.jbo.Key;
import oracle.jbo.domain.Number;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.TransactionEvent;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Sat Nov 30 11:08:53 PKT 2019
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class TblB2bMeetingImpl extends EntityImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        B2bMeetingId,
        B2bMeetingType,
        ExhibitorsId,
        ExpoSchId,
        Name,
        IntlDelegAppMId,
        Remarks,
        Linkages,
        ExpDeal,
        ExpDealAmt,
        FinalDeal,
        FinalDealAmt,
        CreatedDate,
        CreatedBy,
        UpdatedDate,
        UpdatedBy,
        Commodity,
        TblExhibitors,
        TblIntlDelegAppM;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        public int index() {
            return AttributesEnum.firstIndex() + ordinal();
        }

        public static final int firstIndex() {
            return firstIndex;
        }

        public static int count() {
            return AttributesEnum.firstIndex() + AttributesEnum.staticValues().length;
        }

        public static final AttributesEnum[] staticValues() {
            if (vals == null) {
                vals = AttributesEnum.values();
            }
            return vals;
        }
    }


    public static final int B2BMEETINGID = AttributesEnum.B2bMeetingId.index();
    public static final int B2BMEETINGTYPE = AttributesEnum.B2bMeetingType.index();
    public static final int EXHIBITORSID = AttributesEnum.ExhibitorsId.index();
    public static final int EXPOSCHID = AttributesEnum.ExpoSchId.index();
    public static final int NAME = AttributesEnum.Name.index();
    public static final int INTLDELEGAPPMID = AttributesEnum.IntlDelegAppMId.index();
    public static final int REMARKS = AttributesEnum.Remarks.index();
    public static final int LINKAGES = AttributesEnum.Linkages.index();
    public static final int EXPDEAL = AttributesEnum.ExpDeal.index();
    public static final int EXPDEALAMT = AttributesEnum.ExpDealAmt.index();
    public static final int FINALDEAL = AttributesEnum.FinalDeal.index();
    public static final int FINALDEALAMT = AttributesEnum.FinalDealAmt.index();
    public static final int CREATEDDATE = AttributesEnum.CreatedDate.index();
    public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
    public static final int UPDATEDDATE = AttributesEnum.UpdatedDate.index();
    public static final int UPDATEDBY = AttributesEnum.UpdatedBy.index();
    public static final int COMMODITY = AttributesEnum.Commodity.index();
    public static final int TBLEXHIBITORS = AttributesEnum.TblExhibitors.index();
    public static final int TBLINTLDELEGAPPM = AttributesEnum.TblIntlDelegAppM.index();

    /**
     * This is the default constructor (do not remove).
     */
    public TblB2bMeetingImpl() {
    }

    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        return EntityDefImpl.findDefObject("model.EO.TblB2bMeeting");
    }


    /**
     * Gets the attribute value for B2bMeetingId, using the alias name B2bMeetingId.
     * @return the value of B2bMeetingId
     */
    public BigDecimal getB2bMeetingId() {
        return (BigDecimal) getAttributeInternal(B2BMEETINGID);
    }

    /**
     * Sets <code>value</code> as the attribute value for B2bMeetingId.
     * @param value value to set the B2bMeetingId
     */
    public void setB2bMeetingId(BigDecimal value) {
        setAttributeInternal(B2BMEETINGID, value);
    }

    /**
     * Gets the attribute value for B2bMeetingType, using the alias name B2bMeetingType.
     * @return the value of B2bMeetingType
     */
    public String getB2bMeetingType() {
        return (String) getAttributeInternal(B2BMEETINGTYPE);
    }

    /**
     * Sets <code>value</code> as the attribute value for B2bMeetingType.
     * @param value value to set the B2bMeetingType
     */
    public void setB2bMeetingType(String value) {
        setAttributeInternal(B2BMEETINGTYPE, value);
    }

    /**
     * Gets the attribute value for ExhibitorsId, using the alias name ExhibitorsId.
     * @return the value of ExhibitorsId
     */
    public BigDecimal getExhibitorsId() {
        return (BigDecimal) getAttributeInternal(EXHIBITORSID);
    }

    /**
     * Sets <code>value</code> as the attribute value for ExhibitorsId.
     * @param value value to set the ExhibitorsId
     */
    public void setExhibitorsId(BigDecimal value) {
        setAttributeInternal(EXHIBITORSID, value);
    }

    /**
     * Gets the attribute value for Name, using the alias name Name.
     * @return the value of Name
     */
    public String getName() {
        return (String) getAttributeInternal(NAME);
    }

    /**
     * Sets <code>value</code> as the attribute value for Name.
     * @param value value to set the Name
     */
    public void setName(String value) {
        setAttributeInternal(NAME, value);
    }

    /**
     * Gets the attribute value for IntlDelegAppMId, using the alias name IntlDelegAppMId.
     * @return the value of IntlDelegAppMId
     */
    public BigDecimal getIntlDelegAppMId() {
        return (BigDecimal) getAttributeInternal(INTLDELEGAPPMID);
    }

    /**
     * Sets <code>value</code> as the attribute value for IntlDelegAppMId.
     * @param value value to set the IntlDelegAppMId
     */
    public void setIntlDelegAppMId(BigDecimal value) {
        setAttributeInternal(INTLDELEGAPPMID, value);
    }

    /**
     * Gets the attribute value for Remarks, using the alias name Remarks.
     * @return the value of Remarks
     */
    public String getRemarks() {
        return (String) getAttributeInternal(REMARKS);
    }

    /**
     * Sets <code>value</code> as the attribute value for Remarks.
     * @param value value to set the Remarks
     */
    public void setRemarks(String value) {
        setAttributeInternal(REMARKS, value);
    }

    /**
     * Gets the attribute value for Linkages, using the alias name Linkages.
     * @return the value of Linkages
     */
    public BigDecimal getLinkages() {
        return (BigDecimal) getAttributeInternal(LINKAGES);
    }

    /**
     * Sets <code>value</code> as the attribute value for Linkages.
     * @param value value to set the Linkages
     */
    public void setLinkages(BigDecimal value) {
        setAttributeInternal(LINKAGES, value);
    }

    /**
     * Gets the attribute value for ExpDeal, using the alias name ExpDeal.
     * @return the value of ExpDeal
     */
    public BigDecimal getExpDeal() {
        return (BigDecimal) getAttributeInternal(EXPDEAL);
    }

    /**
     * Sets <code>value</code> as the attribute value for ExpDeal.
     * @param value value to set the ExpDeal
     */
    public void setExpDeal(BigDecimal value) {
        setAttributeInternal(EXPDEAL, value);
    }

    /**
     * Gets the attribute value for ExpDealAmt, using the alias name ExpDealAmt.
     * @return the value of ExpDealAmt
     */
    public BigDecimal getExpDealAmt() {
        return (BigDecimal) getAttributeInternal(EXPDEALAMT);
    }

    /**
     * Sets <code>value</code> as the attribute value for ExpDealAmt.
     * @param value value to set the ExpDealAmt
     */
    public void setExpDealAmt(BigDecimal value) {
        setAttributeInternal(EXPDEALAMT, value);
    }

    /**
     * Gets the attribute value for FinalDeal, using the alias name FinalDeal.
     * @return the value of FinalDeal
     */
    public BigDecimal getFinalDeal() {
        return (BigDecimal) getAttributeInternal(FINALDEAL);
    }

    /**
     * Sets <code>value</code> as the attribute value for FinalDeal.
     * @param value value to set the FinalDeal
     */
    public void setFinalDeal(BigDecimal value) {
        setAttributeInternal(FINALDEAL, value);
    }

    /**
     * Gets the attribute value for FinalDealAmt, using the alias name FinalDealAmt.
     * @return the value of FinalDealAmt
     */
    public BigDecimal getFinalDealAmt() {
        return (BigDecimal) getAttributeInternal(FINALDEALAMT);
    }

    /**
     * Sets <code>value</code> as the attribute value for FinalDealAmt.
     * @param value value to set the FinalDealAmt
     */
    public void setFinalDealAmt(BigDecimal value) {
        setAttributeInternal(FINALDEALAMT, value);
    }

    /**
     * Gets the attribute value for CreatedDate, using the alias name CreatedDate.
     * @return the value of CreatedDate
     */
    public Timestamp getCreatedDate() {
        return (Timestamp) getAttributeInternal(CREATEDDATE);
    }

    /**
     * Gets the attribute value for CreatedBy, using the alias name CreatedBy.
     * @return the value of CreatedBy
     */
    public oracle.jbo.domain.Number getCreatedBy() {
        return (oracle.jbo.domain.Number) getAttributeInternal(CREATEDBY);
    }

    /**
     * Sets <code>value</code> as the attribute value for CreatedBy.
     * @param value value to set the CreatedBy
     */
    public void setCreatedBy(oracle.jbo.domain.Number value) {
        setAttributeInternal(CREATEDBY, value);
    }

    /**
     * Gets the attribute value for UpdatedDate, using the alias name UpdatedDate.
     * @return the value of UpdatedDate
     */
    public Timestamp getUpdatedDate() {
        return (Timestamp) getAttributeInternal(UPDATEDDATE);
    }

    /**
     * Gets the attribute value for UpdatedBy, using the alias name UpdatedBy.
     * @return the value of UpdatedBy
     */
    public Number getUpdatedBy() {
        return (Number) getAttributeInternal(UPDATEDBY);
    }

    /**
     * Sets <code>value</code> as the attribute value for UpdatedBy.
     * @param value value to set the UpdatedBy
     */
    public void setUpdatedBy(Number value) {
        setAttributeInternal(UPDATEDBY, value);
    }

    /**
     * Gets the attribute value for Commodity, using the alias name Commodity.
     * @return the value of Commodity
     */
    public String getCommodity() {
        return (String) getAttributeInternal(COMMODITY);
    }

    /**
     * Sets <code>value</code> as the attribute value for Commodity.
     * @param value value to set the Commodity
     */
    public void setCommodity(String value) {
        setAttributeInternal(COMMODITY, value);
    }

    /**
     * Gets the attribute value for ExpoSchId, using the alias name ExpoSchId.
     * @return the value of ExpoSchId
     */
    public BigDecimal getExpoSchId() {
        return (BigDecimal) getAttributeInternal(EXPOSCHID);
    }

    /**
     * Sets <code>value</code> as the attribute value for ExpoSchId.
     * @param value value to set the ExpoSchId
     */
    public void setExpoSchId(BigDecimal value) {
        setAttributeInternal(EXPOSCHID, value);
    }

    /**
     * @return the associated entity oracle.jbo.server.EntityImpl.
     */
    public TblExhibitorsImpl getTblExhibitors() {
        return (TblExhibitorsImpl) getAttributeInternal(TBLEXHIBITORS);
    }

    /**
     * Sets <code>value</code> as the associated entity oracle.jbo.server.EntityImpl.
     */
    public void setTblExhibitors(TblExhibitorsImpl value) {
        setAttributeInternal(TBLEXHIBITORS, value);
    }

    /**
     * @return the associated entity oracle.jbo.server.EntityImpl.
     */
    public TblIntlDelegAppMImpl getTblIntlDelegAppM() {
        return (TblIntlDelegAppMImpl) getAttributeInternal(TBLINTLDELEGAPPM);
    }

    /**
     * Sets <code>value</code> as the associated entity oracle.jbo.server.EntityImpl.
     */
    public void setTblIntlDelegAppM(TblIntlDelegAppMImpl value) {
        setAttributeInternal(TBLINTLDELEGAPPM, value);
    }


    /**
     * @param b2bMeetingId key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(BigDecimal b2bMeetingId) {
        return new Key(new Object[] { b2bMeetingId });
    }

    /**
     * Add locking logic here.
     */
    public void lock() {
        super.lock();
    }

    /**
     * Custom DML update/insert/delete logic here.
     * @param operation the operation type
     * @param e the transaction event
     */
    protected void doDML(int operation, TransactionEvent e) {
        Number loginId = null;
        try {
            loginId = new Number((String) ADFContext.getCurrent().getSessionScope().get("sessRID"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        if (operation == DML_INSERT) {
            setCreatedBy(loginId);
            setUpdatedBy(loginId);
        } else if (operation == DML_UPDATE) {
            setUpdatedBy(loginId);
        }
        super.doDML(operation, e);
    }
}

