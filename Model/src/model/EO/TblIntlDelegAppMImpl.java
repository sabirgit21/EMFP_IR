package model.EO;

import java.math.BigDecimal;

import java.sql.Timestamp;

import oracle.adf.share.ADFContext;

import oracle.jbo.Key;
import oracle.jbo.RowIterator;
import oracle.jbo.domain.Number;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.TransactionEvent;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Sat Nov 30 12:52:36 PKT 2019
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class TblIntlDelegAppMImpl extends EntityImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        IntlDelegAppMId,
        ExpoSetupId,
        Dated,
        Name,
        CoName,
        RepDesig,
        EMail,
        Mobile,
        Address,
        PassportNo,
        PassportCntr,
        WebsiteAddr,
        PassportIssDate,
        WhatsappNo,
        PassportExpDate,
        BizNature,
        AnnTurnSale,
        AnnImports,
        ProIntrExpo,
        TradeProfile,
        ChamberName,
        GovtRepres,
        LibrInterpretReq,
        TrvDateExp,
        TrvFrom,
        TrvTo,
        Status,
        Remarks,
        CreatedDate,
        CreatedBy,
        UpdatedDate,
        UpdatedBy,
        TblB2bMeeting,
        TblIntlDelegAccom,
        TblExpoSetup,
        TblIntlDelegImportIntr,
        TblIntlDelegImportOth,
        TblIntlDelegImportPk,
        TblIntlDelegTrade;
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
    public static final int INTLDELEGAPPMID = AttributesEnum.IntlDelegAppMId.index();
    public static final int EXPOSETUPID = AttributesEnum.ExpoSetupId.index();
    public static final int DATED = AttributesEnum.Dated.index();
    public static final int NAME = AttributesEnum.Name.index();
    public static final int CONAME = AttributesEnum.CoName.index();
    public static final int REPDESIG = AttributesEnum.RepDesig.index();
    public static final int EMAIL = AttributesEnum.EMail.index();
    public static final int MOBILE = AttributesEnum.Mobile.index();
    public static final int ADDRESS = AttributesEnum.Address.index();
    public static final int PASSPORTNO = AttributesEnum.PassportNo.index();
    public static final int PASSPORTCNTR = AttributesEnum.PassportCntr.index();
    public static final int WEBSITEADDR = AttributesEnum.WebsiteAddr.index();
    public static final int PASSPORTISSDATE = AttributesEnum.PassportIssDate.index();
    public static final int WHATSAPPNO = AttributesEnum.WhatsappNo.index();
    public static final int PASSPORTEXPDATE = AttributesEnum.PassportExpDate.index();
    public static final int BIZNATURE = AttributesEnum.BizNature.index();
    public static final int ANNTURNSALE = AttributesEnum.AnnTurnSale.index();
    public static final int ANNIMPORTS = AttributesEnum.AnnImports.index();
    public static final int PROINTREXPO = AttributesEnum.ProIntrExpo.index();
    public static final int TRADEPROFILE = AttributesEnum.TradeProfile.index();
    public static final int CHAMBERNAME = AttributesEnum.ChamberName.index();
    public static final int GOVTREPRES = AttributesEnum.GovtRepres.index();
    public static final int LIBRINTERPRETREQ = AttributesEnum.LibrInterpretReq.index();
    public static final int TRVDATEEXP = AttributesEnum.TrvDateExp.index();
    public static final int TRVFROM = AttributesEnum.TrvFrom.index();
    public static final int TRVTO = AttributesEnum.TrvTo.index();
    public static final int STATUS = AttributesEnum.Status.index();
    public static final int REMARKS = AttributesEnum.Remarks.index();
    public static final int CREATEDDATE = AttributesEnum.CreatedDate.index();
    public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
    public static final int UPDATEDDATE = AttributesEnum.UpdatedDate.index();
    public static final int UPDATEDBY = AttributesEnum.UpdatedBy.index();
    public static final int TBLB2BMEETING = AttributesEnum.TblB2bMeeting.index();
    public static final int TBLINTLDELEGACCOM = AttributesEnum.TblIntlDelegAccom.index();
    public static final int TBLEXPOSETUP = AttributesEnum.TblExpoSetup.index();
    public static final int TBLINTLDELEGIMPORTINTR = AttributesEnum.TblIntlDelegImportIntr.index();
    public static final int TBLINTLDELEGIMPORTOTH = AttributesEnum.TblIntlDelegImportOth.index();
    public static final int TBLINTLDELEGIMPORTPK = AttributesEnum.TblIntlDelegImportPk.index();
    public static final int TBLINTLDELEGTRADE = AttributesEnum.TblIntlDelegTrade.index();

    /**
     * This is the default constructor (do not remove).
     */
    public TblIntlDelegAppMImpl() {
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
     * Gets the attribute value for ExpoSetupId, using the alias name ExpoSetupId.
     * @return the value of ExpoSetupId
     */
    public BigDecimal getExpoSetupId() {
        return (BigDecimal) getAttributeInternal(EXPOSETUPID);
    }

    /**
     * Sets <code>value</code> as the attribute value for ExpoSetupId.
     * @param value value to set the ExpoSetupId
     */
    public void setExpoSetupId(BigDecimal value) {
        setAttributeInternal(EXPOSETUPID, value);
    }

    /**
     * Gets the attribute value for Dated, using the alias name Dated.
     * @return the value of Dated
     */
    public Timestamp getDated() {
        return (Timestamp) getAttributeInternal(DATED);
    }

    /**
     * Sets <code>value</code> as the attribute value for Dated.
     * @param value value to set the Dated
     */
    public void setDated(Timestamp value) {
        setAttributeInternal(DATED, value);
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
     * Gets the attribute value for CoName, using the alias name CoName.
     * @return the value of CoName
     */
    public String getCoName() {
        return (String) getAttributeInternal(CONAME);
    }

    /**
     * Sets <code>value</code> as the attribute value for CoName.
     * @param value value to set the CoName
     */
    public void setCoName(String value) {
        setAttributeInternal(CONAME, value);
    }

    /**
     * Gets the attribute value for RepDesig, using the alias name RepDesig.
     * @return the value of RepDesig
     */
    public String getRepDesig() {
        return (String) getAttributeInternal(REPDESIG);
    }

    /**
     * Sets <code>value</code> as the attribute value for RepDesig.
     * @param value value to set the RepDesig
     */
    public void setRepDesig(String value) {
        setAttributeInternal(REPDESIG, value);
    }

    /**
     * Gets the attribute value for EMail, using the alias name EMail.
     * @return the value of EMail
     */
    public String getEMail() {
        return (String) getAttributeInternal(EMAIL);
    }

    /**
     * Sets <code>value</code> as the attribute value for EMail.
     * @param value value to set the EMail
     */
    public void setEMail(String value) {
        setAttributeInternal(EMAIL, value);
    }

    /**
     * Gets the attribute value for Mobile, using the alias name Mobile.
     * @return the value of Mobile
     */
    public String getMobile() {
        return (String) getAttributeInternal(MOBILE);
    }

    /**
     * Sets <code>value</code> as the attribute value for Mobile.
     * @param value value to set the Mobile
     */
    public void setMobile(String value) {
        setAttributeInternal(MOBILE, value);
    }

    /**
     * Gets the attribute value for Address, using the alias name Address.
     * @return the value of Address
     */
    public String getAddress() {
        return (String) getAttributeInternal(ADDRESS);
    }

    /**
     * Sets <code>value</code> as the attribute value for Address.
     * @param value value to set the Address
     */
    public void setAddress(String value) {
        setAttributeInternal(ADDRESS, value);
    }

    /**
     * Gets the attribute value for PassportNo, using the alias name PassportNo.
     * @return the value of PassportNo
     */
    public String getPassportNo() {
        return (String) getAttributeInternal(PASSPORTNO);
    }

    /**
     * Sets <code>value</code> as the attribute value for PassportNo.
     * @param value value to set the PassportNo
     */
    public void setPassportNo(String value) {
        setAttributeInternal(PASSPORTNO, value);
    }

    /**
     * Gets the attribute value for PassportCntr, using the alias name PassportCntr.
     * @return the value of PassportCntr
     */
    public String getPassportCntr() {
        return (String) getAttributeInternal(PASSPORTCNTR);
    }

    /**
     * Sets <code>value</code> as the attribute value for PassportCntr.
     * @param value value to set the PassportCntr
     */
    public void setPassportCntr(String value) {
        setAttributeInternal(PASSPORTCNTR, value);
    }

    /**
     * Gets the attribute value for WebsiteAddr, using the alias name WebsiteAddr.
     * @return the value of WebsiteAddr
     */
    public String getWebsiteAddr() {
        return (String) getAttributeInternal(WEBSITEADDR);
    }

    /**
     * Sets <code>value</code> as the attribute value for WebsiteAddr.
     * @param value value to set the WebsiteAddr
     */
    public void setWebsiteAddr(String value) {
        setAttributeInternal(WEBSITEADDR, value);
    }

    /**
     * Gets the attribute value for PassportIssDate, using the alias name PassportIssDate.
     * @return the value of PassportIssDate
     */
    public Timestamp getPassportIssDate() {
        return (Timestamp) getAttributeInternal(PASSPORTISSDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for PassportIssDate.
     * @param value value to set the PassportIssDate
     */
    public void setPassportIssDate(Timestamp value) {
        setAttributeInternal(PASSPORTISSDATE, value);
    }

    /**
     * Gets the attribute value for WhatsappNo, using the alias name WhatsappNo.
     * @return the value of WhatsappNo
     */
    public String getWhatsappNo() {
        return (String) getAttributeInternal(WHATSAPPNO);
    }

    /**
     * Sets <code>value</code> as the attribute value for WhatsappNo.
     * @param value value to set the WhatsappNo
     */
    public void setWhatsappNo(String value) {
        setAttributeInternal(WHATSAPPNO, value);
    }

    /**
     * Gets the attribute value for PassportExpDate, using the alias name PassportExpDate.
     * @return the value of PassportExpDate
     */
    public Timestamp getPassportExpDate() {
        return (Timestamp) getAttributeInternal(PASSPORTEXPDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for PassportExpDate.
     * @param value value to set the PassportExpDate
     */
    public void setPassportExpDate(Timestamp value) {
        setAttributeInternal(PASSPORTEXPDATE, value);
    }

    /**
     * Gets the attribute value for BizNature, using the alias name BizNature.
     * @return the value of BizNature
     */
    public String getBizNature() {
        return (String) getAttributeInternal(BIZNATURE);
    }

    /**
     * Sets <code>value</code> as the attribute value for BizNature.
     * @param value value to set the BizNature
     */
    public void setBizNature(String value) {
        setAttributeInternal(BIZNATURE, value);
    }

    /**
     * Gets the attribute value for AnnTurnSale, using the alias name AnnTurnSale.
     * @return the value of AnnTurnSale
     */
    public BigDecimal getAnnTurnSale() {
        return (BigDecimal) getAttributeInternal(ANNTURNSALE);
    }

    /**
     * Sets <code>value</code> as the attribute value for AnnTurnSale.
     * @param value value to set the AnnTurnSale
     */
    public void setAnnTurnSale(BigDecimal value) {
        setAttributeInternal(ANNTURNSALE, value);
    }

    /**
     * Gets the attribute value for AnnImports, using the alias name AnnImports.
     * @return the value of AnnImports
     */
    public BigDecimal getAnnImports() {
        return (BigDecimal) getAttributeInternal(ANNIMPORTS);
    }

    /**
     * Sets <code>value</code> as the attribute value for AnnImports.
     * @param value value to set the AnnImports
     */
    public void setAnnImports(BigDecimal value) {
        setAttributeInternal(ANNIMPORTS, value);
    }

    /**
     * Gets the attribute value for ProIntrExpo, using the alias name ProIntrExpo.
     * @return the value of ProIntrExpo
     */
    public String getProIntrExpo() {
        return (String) getAttributeInternal(PROINTREXPO);
    }

    /**
     * Sets <code>value</code> as the attribute value for ProIntrExpo.
     * @param value value to set the ProIntrExpo
     */
    public void setProIntrExpo(String value) {
        setAttributeInternal(PROINTREXPO, value);
    }

    /**
     * Gets the attribute value for TradeProfile, using the alias name TradeProfile.
     * @return the value of TradeProfile
     */
    public String getTradeProfile() {
        return (String) getAttributeInternal(TRADEPROFILE);
    }

    /**
     * Sets <code>value</code> as the attribute value for TradeProfile.
     * @param value value to set the TradeProfile
     */
    public void setTradeProfile(String value) {
        setAttributeInternal(TRADEPROFILE, value);
    }

    /**
     * Gets the attribute value for ChamberName, using the alias name ChamberName.
     * @return the value of ChamberName
     */
    public String getChamberName() {
        return (String) getAttributeInternal(CHAMBERNAME);
    }

    /**
     * Sets <code>value</code> as the attribute value for ChamberName.
     * @param value value to set the ChamberName
     */
    public void setChamberName(String value) {
        setAttributeInternal(CHAMBERNAME, value);
    }

    /**
     * Gets the attribute value for GovtRepres, using the alias name GovtRepres.
     * @return the value of GovtRepres
     */
    public String getGovtRepres() {
        return (String) getAttributeInternal(GOVTREPRES);
    }

    /**
     * Sets <code>value</code> as the attribute value for GovtRepres.
     * @param value value to set the GovtRepres
     */
    public void setGovtRepres(String value) {
        setAttributeInternal(GOVTREPRES, value);
    }

    /**
     * Gets the attribute value for LibrInterpretReq, using the alias name LibrInterpretReq.
     * @return the value of LibrInterpretReq
     */
    public BigDecimal getLibrInterpretReq() {
        return (BigDecimal) getAttributeInternal(LIBRINTERPRETREQ);
    }

    /**
     * Sets <code>value</code> as the attribute value for LibrInterpretReq.
     * @param value value to set the LibrInterpretReq
     */
    public void setLibrInterpretReq(BigDecimal value) {
        setAttributeInternal(LIBRINTERPRETREQ, value);
    }

    /**
     * Gets the attribute value for TrvDateExp, using the alias name TrvDateExp.
     * @return the value of TrvDateExp
     */
    public Timestamp getTrvDateExp() {
        return (Timestamp) getAttributeInternal(TRVDATEEXP);
    }

    /**
     * Sets <code>value</code> as the attribute value for TrvDateExp.
     * @param value value to set the TrvDateExp
     */
    public void setTrvDateExp(Timestamp value) {
        setAttributeInternal(TRVDATEEXP, value);
    }

    /**
     * Gets the attribute value for TrvFrom, using the alias name TrvFrom.
     * @return the value of TrvFrom
     */
    public String getTrvFrom() {
        return (String) getAttributeInternal(TRVFROM);
    }

    /**
     * Sets <code>value</code> as the attribute value for TrvFrom.
     * @param value value to set the TrvFrom
     */
    public void setTrvFrom(String value) {
        setAttributeInternal(TRVFROM, value);
    }

    /**
     * Gets the attribute value for TrvTo, using the alias name TrvTo.
     * @return the value of TrvTo
     */
    public String getTrvTo() {
        return (String) getAttributeInternal(TRVTO);
    }

    /**
     * Sets <code>value</code> as the attribute value for TrvTo.
     * @param value value to set the TrvTo
     */
    public void setTrvTo(String value) {
        setAttributeInternal(TRVTO, value);
    }

    /**
     * Gets the attribute value for Status, using the alias name Status.
     * @return the value of Status
     */
    public String getStatus() {
        return (String) getAttributeInternal(STATUS);
    }

    /**
     * Sets <code>value</code> as the attribute value for Status.
     * @param value value to set the Status
     */
    public void setStatus(String value) {
        setAttributeInternal(STATUS, value);
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
    public Number getCreatedBy() {
        return (Number) getAttributeInternal(CREATEDBY);
    }

    /**
     * Sets <code>value</code> as the attribute value for CreatedBy.
     * @param value value to set the CreatedBy
     */
    public void setCreatedBy(Number value) {
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
     * @return the associated entity oracle.jbo.RowIterator.
     */
    public RowIterator getTblB2bMeeting() {
        return (RowIterator) getAttributeInternal(TBLB2BMEETING);
    }

    /**
     * @return the associated entity oracle.jbo.RowIterator.
     */
    public RowIterator getTblIntlDelegAccom() {
        return (RowIterator) getAttributeInternal(TBLINTLDELEGACCOM);
    }

    /**
     * @return the associated entity TblExpoSetupImpl.
     */
    public TblExpoSetupImpl getTblExpoSetup() {
        return (TblExpoSetupImpl) getAttributeInternal(TBLEXPOSETUP);
    }

    /**
     * Sets <code>value</code> as the associated entity TblExpoSetupImpl.
     */
    public void setTblExpoSetup(TblExpoSetupImpl value) {
        setAttributeInternal(TBLEXPOSETUP, value);
    }

    /**
     * @return the associated entity oracle.jbo.RowIterator.
     */
    public RowIterator getTblIntlDelegImportIntr() {
        return (RowIterator) getAttributeInternal(TBLINTLDELEGIMPORTINTR);
    }

    /**
     * @return the associated entity oracle.jbo.RowIterator.
     */
    public RowIterator getTblIntlDelegImportOth() {
        return (RowIterator) getAttributeInternal(TBLINTLDELEGIMPORTOTH);
    }

    /**
     * @return the associated entity oracle.jbo.RowIterator.
     */
    public RowIterator getTblIntlDelegImportPk() {
        return (RowIterator) getAttributeInternal(TBLINTLDELEGIMPORTPK);
    }

    /**
     * @return the associated entity oracle.jbo.RowIterator.
     */
    public RowIterator getTblIntlDelegTrade() {
        return (RowIterator) getAttributeInternal(TBLINTLDELEGTRADE);
    }

    /**
     * @param intlDelegAppMId key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(BigDecimal intlDelegAppMId) {
        return new Key(new Object[] { intlDelegAppMId });
    }

    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        return EntityDefImpl.findDefObject("model.EO.TblIntlDelegAppM");
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
                     loginId = new Number((String) ADFContext.getCurrent().getSessionScope().get("sessUID"));
                 } catch(Exception ex) {
                     ex.printStackTrace();
                 }
                 
                 if (operation == DML_INSERT) {
                     setCreatedBy(loginId);
                     setUpdatedBy(loginId);
                     } else if(operation == DML_UPDATE) {
                     setUpdatedBy(loginId);
                 }
        super.doDML(operation, e);
    }
}

