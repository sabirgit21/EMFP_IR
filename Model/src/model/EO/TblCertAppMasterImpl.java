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
// ---    Sat Nov 30 12:14:21 PKT 2019
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class TblCertAppMasterImpl extends EntityImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        CertAppMasterId,
        CertificationId,
        AppStatus,
        AppType,
        FarmerRegId,
        CoName,
        BussNature,
        OwnType,
        Website,
        Ntn,
        CoAddress,
        OwnerName,
        Cnic,
        Acres,
        Tel,
        Fax,
        Email,
        ContPerson,
        Designation,
        Mobile,
        NoOfEmpM,
        NoOfEmpF,
        Ast,
        CreatedDate,
        CreatedBy,
        UpdatedDate,
        UpdatedBy,
        TblCertAppDetail,
        TblCertApproval,
        TblCertification1;
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


    public static final int CERTAPPMASTERID = AttributesEnum.CertAppMasterId.index();
    public static final int CERTIFICATIONID = AttributesEnum.CertificationId.index();
    public static final int APPSTATUS = AttributesEnum.AppStatus.index();
    public static final int APPTYPE = AttributesEnum.AppType.index();
    public static final int FARMERREGID = AttributesEnum.FarmerRegId.index();
    public static final int CONAME = AttributesEnum.CoName.index();
    public static final int BUSSNATURE = AttributesEnum.BussNature.index();
    public static final int OWNTYPE = AttributesEnum.OwnType.index();
    public static final int WEBSITE = AttributesEnum.Website.index();
    public static final int NTN = AttributesEnum.Ntn.index();
    public static final int COADDRESS = AttributesEnum.CoAddress.index();
    public static final int OWNERNAME = AttributesEnum.OwnerName.index();
    public static final int CNIC = AttributesEnum.Cnic.index();
    public static final int ACRES = AttributesEnum.Acres.index();
    public static final int TEL = AttributesEnum.Tel.index();
    public static final int FAX = AttributesEnum.Fax.index();
    public static final int EMAIL = AttributesEnum.Email.index();
    public static final int CONTPERSON = AttributesEnum.ContPerson.index();
    public static final int DESIGNATION = AttributesEnum.Designation.index();
    public static final int MOBILE = AttributesEnum.Mobile.index();
    public static final int NOOFEMPM = AttributesEnum.NoOfEmpM.index();
    public static final int NOOFEMPF = AttributesEnum.NoOfEmpF.index();
    public static final int AST = AttributesEnum.Ast.index();
    public static final int CREATEDDATE = AttributesEnum.CreatedDate.index();
    public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
    public static final int UPDATEDDATE = AttributesEnum.UpdatedDate.index();
    public static final int UPDATEDBY = AttributesEnum.UpdatedBy.index();
    public static final int TBLCERTAPPDETAIL = AttributesEnum.TblCertAppDetail.index();
    public static final int TBLCERTAPPROVAL = AttributesEnum.TblCertApproval.index();
    public static final int TBLCERTIFICATION1 = AttributesEnum.TblCertification1.index();

    /**
     * This is the default constructor (do not remove).
     */
    public TblCertAppMasterImpl() {
    }

    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        return EntityDefImpl.findDefObject("model.EO.TblCertAppMaster");
    }


    /**
     * Gets the attribute value for CertAppMasterId, using the alias name CertAppMasterId.
     * @return the value of CertAppMasterId
     */
    public BigDecimal getCertAppMasterId() {
        return (BigDecimal) getAttributeInternal(CERTAPPMASTERID);
    }

    /**
     * Sets <code>value</code> as the attribute value for CertAppMasterId.
     * @param value value to set the CertAppMasterId
     */
    public void setCertAppMasterId(BigDecimal value) {
        setAttributeInternal(CERTAPPMASTERID, value);
    }

    /**
     * Gets the attribute value for CertificationId, using the alias name CertificationId.
     * @return the value of CertificationId
     */
    public BigDecimal getCertificationId() {
        return (BigDecimal) getAttributeInternal(CERTIFICATIONID);
    }

    /**
     * Sets <code>value</code> as the attribute value for CertificationId.
     * @param value value to set the CertificationId
     */
    public void setCertificationId(BigDecimal value) {
        setAttributeInternal(CERTIFICATIONID, value);
    }

    /**
     * Gets the attribute value for AppStatus, using the alias name AppStatus.
     * @return the value of AppStatus
     */
    public String getAppStatus() {
        return (String) getAttributeInternal(APPSTATUS);
    }

    /**
     * Sets <code>value</code> as the attribute value for AppStatus.
     * @param value value to set the AppStatus
     */
    public void setAppStatus(String value) {
        setAttributeInternal(APPSTATUS, value);
    }

    /**
     * Gets the attribute value for AppType, using the alias name AppType.
     * @return the value of AppType
     */
    public String getAppType() {
        return (String) getAttributeInternal(APPTYPE);
    }

    /**
     * Sets <code>value</code> as the attribute value for AppType.
     * @param value value to set the AppType
     */
    public void setAppType(String value) {
        setAttributeInternal(APPTYPE, value);
    }

    /**
     * Gets the attribute value for FarmerRegId, using the alias name FarmerRegId.
     * @return the value of FarmerRegId
     */
    public BigDecimal getFarmerRegId() {
        return (BigDecimal) getAttributeInternal(FARMERREGID);
    }

    /**
     * Sets <code>value</code> as the attribute value for FarmerRegId.
     * @param value value to set the FarmerRegId
     */
    public void setFarmerRegId(BigDecimal value) {
        setAttributeInternal(FARMERREGID, value);
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
     * Gets the attribute value for BussNature, using the alias name BussNature.
     * @return the value of BussNature
     */
    public String getBussNature() {
        return (String) getAttributeInternal(BUSSNATURE);
    }

    /**
     * Sets <code>value</code> as the attribute value for BussNature.
     * @param value value to set the BussNature
     */
    public void setBussNature(String value) {
        setAttributeInternal(BUSSNATURE, value);
    }

    /**
     * Gets the attribute value for OwnType, using the alias name OwnType.
     * @return the value of OwnType
     */
    public String getOwnType() {
        return (String) getAttributeInternal(OWNTYPE);
    }

    /**
     * Sets <code>value</code> as the attribute value for OwnType.
     * @param value value to set the OwnType
     */
    public void setOwnType(String value) {
        setAttributeInternal(OWNTYPE, value);
    }

    /**
     * Gets the attribute value for Website, using the alias name Website.
     * @return the value of Website
     */
    public String getWebsite() {
        return (String) getAttributeInternal(WEBSITE);
    }

    /**
     * Sets <code>value</code> as the attribute value for Website.
     * @param value value to set the Website
     */
    public void setWebsite(String value) {
        setAttributeInternal(WEBSITE, value);
    }

    /**
     * Gets the attribute value for Ntn, using the alias name Ntn.
     * @return the value of Ntn
     */
    public String getNtn() {
        return (String) getAttributeInternal(NTN);
    }

    /**
     * Sets <code>value</code> as the attribute value for Ntn.
     * @param value value to set the Ntn
     */
    public void setNtn(String value) {
        setAttributeInternal(NTN, value);
    }

    /**
     * Gets the attribute value for CoAddress, using the alias name CoAddress.
     * @return the value of CoAddress
     */
    public String getCoAddress() {
        return (String) getAttributeInternal(COADDRESS);
    }

    /**
     * Sets <code>value</code> as the attribute value for CoAddress.
     * @param value value to set the CoAddress
     */
    public void setCoAddress(String value) {
        setAttributeInternal(COADDRESS, value);
    }

    /**
     * Gets the attribute value for OwnerName, using the alias name OwnerName.
     * @return the value of OwnerName
     */
    public String getOwnerName() {
        return (String) getAttributeInternal(OWNERNAME);
    }

    /**
     * Sets <code>value</code> as the attribute value for OwnerName.
     * @param value value to set the OwnerName
     */
    public void setOwnerName(String value) {
        setAttributeInternal(OWNERNAME, value);
    }

    /**
     * Gets the attribute value for Cnic, using the alias name Cnic.
     * @return the value of Cnic
     */
    public String getCnic() {
        return (String) getAttributeInternal(CNIC);
    }

    /**
     * Sets <code>value</code> as the attribute value for Cnic.
     * @param value value to set the Cnic
     */
    public void setCnic(String value) {
        setAttributeInternal(CNIC, value);
    }

    /**
     * Gets the attribute value for Acres, using the alias name Acres.
     * @return the value of Acres
     */
    public BigDecimal getAcres() {
        return (BigDecimal) getAttributeInternal(ACRES);
    }

    /**
     * Sets <code>value</code> as the attribute value for Acres.
     * @param value value to set the Acres
     */
    public void setAcres(BigDecimal value) {
        setAttributeInternal(ACRES, value);
    }

    /**
     * Gets the attribute value for Tel, using the alias name Tel.
     * @return the value of Tel
     */
    public String getTel() {
        return (String) getAttributeInternal(TEL);
    }

    /**
     * Sets <code>value</code> as the attribute value for Tel.
     * @param value value to set the Tel
     */
    public void setTel(String value) {
        setAttributeInternal(TEL, value);
    }

    /**
     * Gets the attribute value for Fax, using the alias name Fax.
     * @return the value of Fax
     */
    public String getFax() {
        return (String) getAttributeInternal(FAX);
    }

    /**
     * Sets <code>value</code> as the attribute value for Fax.
     * @param value value to set the Fax
     */
    public void setFax(String value) {
        setAttributeInternal(FAX, value);
    }

    /**
     * Gets the attribute value for Email, using the alias name Email.
     * @return the value of Email
     */
    public String getEmail() {
        return (String) getAttributeInternal(EMAIL);
    }

    /**
     * Sets <code>value</code> as the attribute value for Email.
     * @param value value to set the Email
     */
    public void setEmail(String value) {
        setAttributeInternal(EMAIL, value);
    }

    /**
     * Gets the attribute value for ContPerson, using the alias name ContPerson.
     * @return the value of ContPerson
     */
    public String getContPerson() {
        return (String) getAttributeInternal(CONTPERSON);
    }

    /**
     * Sets <code>value</code> as the attribute value for ContPerson.
     * @param value value to set the ContPerson
     */
    public void setContPerson(String value) {
        setAttributeInternal(CONTPERSON, value);
    }

    /**
     * Gets the attribute value for Designation, using the alias name Designation.
     * @return the value of Designation
     */
    public String getDesignation() {
        return (String) getAttributeInternal(DESIGNATION);
    }

    /**
     * Sets <code>value</code> as the attribute value for Designation.
     * @param value value to set the Designation
     */
    public void setDesignation(String value) {
        setAttributeInternal(DESIGNATION, value);
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
     * Gets the attribute value for NoOfEmpM, using the alias name NoOfEmpM.
     * @return the value of NoOfEmpM
     */
    public BigDecimal getNoOfEmpM() {
        return (BigDecimal) getAttributeInternal(NOOFEMPM);
    }

    /**
     * Sets <code>value</code> as the attribute value for NoOfEmpM.
     * @param value value to set the NoOfEmpM
     */
    public void setNoOfEmpM(BigDecimal value) {
        setAttributeInternal(NOOFEMPM, value);
    }

    /**
     * Gets the attribute value for NoOfEmpF, using the alias name NoOfEmpF.
     * @return the value of NoOfEmpF
     */
    public BigDecimal getNoOfEmpF() {
        return (BigDecimal) getAttributeInternal(NOOFEMPF);
    }

    /**
     * Sets <code>value</code> as the attribute value for NoOfEmpF.
     * @param value value to set the NoOfEmpF
     */
    public void setNoOfEmpF(BigDecimal value) {
        setAttributeInternal(NOOFEMPF, value);
    }

    /**
     * Gets the attribute value for Ast, using the alias name Ast.
     * @return the value of Ast
     */
    public String getAst() {
        return (String) getAttributeInternal(AST);
    }

    /**
     * Sets <code>value</code> as the attribute value for Ast.
     * @param value value to set the Ast
     */
    public void setAst(String value) {
        setAttributeInternal(AST, value);
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
     * @return the associated entity oracle.jbo.RowIterator.
     */
    public RowIterator getTblCertAppDetail() {
        return (RowIterator) getAttributeInternal(TBLCERTAPPDETAIL);
    }

    /**
     * @return the associated entity oracle.jbo.RowIterator.
     */
    public RowIterator getTblCertApproval() {
        return (RowIterator) getAttributeInternal(TBLCERTAPPROVAL);
    }

    /**
     * @return the associated entity oracle.jbo.server.EntityImpl.
     */
    public EntityImpl getTblCertification1() {
        return (EntityImpl) getAttributeInternal(TBLCERTIFICATION1);
    }

    /**
     * Sets <code>value</code> as the associated entity oracle.jbo.server.EntityImpl.
     */
    public void setTblCertification1(EntityImpl value) {
        setAttributeInternal(TBLCERTIFICATION1, value);
    }


    /**
     * @param certAppMasterId key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(BigDecimal certAppMasterId) {
        return new Key(new Object[] { certAppMasterId });
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

