package view.report;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Locale;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;

import oracle.jbo.domain.Number;

import view.DatabaseConnection.DatabaseConnection;

public class Grant_Approval_Report {

    private static Number gotPhase;
    private static Number gotToPhase;
    private static Number gotCluster;
    private static Number gotFarmer;
    private static Number gotGrantappD;
    private RichInputDate fromDateParam;
    private RichInputDate toDateParam;
    
    
    
//    private static String selectedgrantType;   
    
    private static String selectedReportType = "";
    private static String gotFormat = "";
    

    private RichSelectOneChoice selected_phase;
    private RichSelectOneChoice selected_to_phase;
    private RichSelectOneChoice selected_cluster;
    private RichSelectOneChoice selected_farmer;
    private RichSelectOneChoice selected_grantappid;
    private RichSelectOneChoice report_format;
//    private RichSelectOneChoice selected_grant_type;
    private RichSelectOneChoice selected_report_type;
    
        
  
    
    
    

    public Grant_Approval_Report() {
        System.out.println("grant approval report constructor called");
    }

    public String gen_Report() {

        DatabaseConnection dbconnect = new DatabaseConnection();
        OracleReportBean reportBean = new OracleReportBean(dbconnect.getUipReport(), dbconnect.getUportReport(), null);

        
            gotPhase = (Number)this.getselected_phase().getValue(); // To recieve value from UI InputText Component
            gotToPhase = (Number)this.getselected_to_phase().getValue();
            gotCluster = (Number)this.getselected_cluster().getValue();    
            gotFarmer = (Number)this.getselected_farmer().getValue();
            gotGrantappD = (Number)this.getselected_grantappid().getValue();
//            selectedgrantType = (this.getselected_grant_type().getValue()).toString();
            
            
        gotFormat = (String)this.getreport_format().getValue();
        selectedReportType = (String)this.getselected_report_type().getValue();
       
        
        String url = "";
        
        
        if(gotPhase != null){
            reportBean.setReportParameter("P_Phase_id", gotPhase.toString());
        }         
        if(gotToPhase != null){
            reportBean.setReportParameter("P_To_Phase", gotToPhase.toString());
        }         
        if(gotCluster != null){
            reportBean.setReportParameter("P_Cluster_id", gotCluster.toString());
        }         
        if(gotFarmer != null){
            reportBean.setReportParameter("P_farmer_reg_id", gotFarmer.toString());
        } 
        if(gotGrantappD != null){
        reportBean.setReportParameter("P_Grant_Approval_Detail_id", gotGrantappD.toString());
        }  
        if(getFromDate() != ""){
        reportBean.setReportParameter("P_STDT", getFromDate());
        }
        if(getToDate() != ""){
        reportBean.setReportParameter("P_ENDT", getToDate());
        }   
       
//        if(selectedgrantType != null){
//            reportBean.setReportParameter("P_Grant_Type", selectedgrantType.toString());
//        } 

        if (gotFormat == "") {
            showMessage("Please Select Report Format");
        } else {

            switch (selectedReportType) {
            case "detailWise":

                reportBean.setReportURLName("userid=emfp/emfp@orcl&domain=classicdomain&report=C:/EMFP_Reports/Grant_Approval_Detail&");

                System.out.println("detail wise");
                break;
            case "machineryWise":

                reportBean.setReportURLName("userid=emfp/emfp@orcl&domain=classicdomain&report=C:/EMFP_Reports/Grant_Approval_Machinery_wise_Detail&");

                System.out.println("machinery wise");
                break;
            case "machineryPhaseWise":

                reportBean.setReportURLName("userid=emfp/emfp@orcl&domain=classicdomain&report=C:/EMFP_Reports/Grant_Approval_Machinery_Phase_Wise_Detail&");

                System.out.println("machinery phase wise");
                break;

            case "consolidatedDetail":

                reportBean.setReportURLName("userid=emfp/emfp@orcl&domain=classicdomain&report=C:/EMFP_Reports/Grant_Consolidated_Detail&");

                System.out.println("consolidated detail");
                break;
            
                case "grantApprovalDisbursementDetail":

                    reportBean.setReportURLName("userid=emfp/emfp@orcl&domain=classicdomain&report=C:/EMFP_Reports/Grant_Approval_Disbursement_Detail&");

                    System.out.println("Grant Approval Disbursement Detail");
                    break;

            case "grantFarmerEligibilty":

                reportBean.setReportURLName("userid=emfp/emfp@orcl&domain=classicdomain&report=C:/EMFP_Reports/Grant_Farmers_Eligibility_Detail&");

                System.out.println("Grant Farmer Eligibility Detail");
                break;

            case "grantsummary":

                reportBean.setReportURLName("userid=emfp/emfp@orcl&domain=classicdomain&report=C:/EMFP_Reports/RO_Grant_Summary&");

                System.out.println("RO Grant Summary");
                break;
            
                case "grantVoucherDetail":

                    reportBean.setReportURLName("userid=emfp/emfp@orcl&domain=classicdomain&report=C:/EMFP_Reports/Grant_Voucher_Detail&");

                    System.out.println("Grant Voucher Detail");
                    break;
            
                case "grantMachineryInspection":

                    reportBean.setReportURLName("userid=emfp/emfp@orcl&domain=classicdomain&report=C:/EMFP_Reports/Grant_Approval_Detail_Machinery_Inspection&");

                    System.out.println("Grant Machinery Inspection");
                    break;

            default:
                showMessage("Please Select Report Type");
                break;

            }
            
            

           
            reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESTYPE,
                                            "CACHE"); // which will be one of the [cashe - file - mail - printer]
            reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESFORMAT,
                                            gotFormat); // Which will be onr of the [HTML - HTML CSS - PDF - SPREADSHEET- RTF].
            reportBean.setReportParameter("paramform", "no");

            url = reportBean.getReportServerURL();
            System.out.println("Url => " + url);
            reportBean.openUrlInNewWindow(url);


        }
        return null;
    }

    public String showMessage(String msgs) {
        String messageText = msgs;
        FacesMessage fm = new FacesMessage(messageText);
        /**
             * set the type of the message.
             * Valid types: error, fatal,info,warning
             */
        fm.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, fm);
        return null;
    }
    
    private String getFromDate() {
        if(fromDateParam.getValue() != null && fromDateParam.getValue() != "") {
            try {
                DateFormat sdf = new SimpleDateFormat("EE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
                Date parsedDate = sdf.parse(fromDateParam.getValue().toString());
                SimpleDateFormat print = new SimpleDateFormat("dd-MMM-yy");
                return (print.format(parsedDate));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return "";
    }
    
    private String getToDate() {
        if(toDateParam.getValue() != null && toDateParam.getValue() != "") {
            try {
                DateFormat sdf = new SimpleDateFormat("EE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
                Date parsedDate = sdf.parse(toDateParam.getValue().toString());
                SimpleDateFormat print = new SimpleDateFormat("dd-MMM-yy");
                return (print.format(parsedDate));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return "";
    }


    
//
//    public void get_selected_report_type(ValueChangeEvent valueChangeEvent) {
//        // Add event code here...
//        selectedReportType = (valueChangeEvent.getNewValue()).toString();
//        System.out.println("Selected Report Type is : " + selectedReportType);
//    }
//
//    public void get_report_format(ValueChangeEvent valueChangeEvent) {
//        // Add event code here...
//        gotFormat = (valueChangeEvent.getNewValue()).toString();
//        System.out.println("Selected Format is : " + gotFormat);
//    }
    
    
    
    
        
    
    public void setselected_phase(RichSelectOneChoice get_selected_phase) {
        this.selected_phase = get_selected_phase;
    }

    public RichSelectOneChoice getselected_phase() {
        return selected_phase;
    }       
    
    public void setselected_to_phase(RichSelectOneChoice get_selected_to_phase) {
        this.selected_to_phase = get_selected_to_phase;
    }

    public RichSelectOneChoice getselected_to_phase() {
        return selected_to_phase;
    }    
    
    
    
    
    public void setselected_cluster(RichSelectOneChoice get_selected_cluster) {
        this.selected_cluster = get_selected_cluster;
    }

    public RichSelectOneChoice getselected_cluster() {
        return selected_cluster;
    }    
    
    
    
    
    public void setselected_farmer(RichSelectOneChoice get_selected_farmer) {
        this.selected_farmer = get_selected_farmer;
    }

    public RichSelectOneChoice getselected_farmer() {
        return selected_farmer;
    } 
    public void setselected_grantappid(RichSelectOneChoice get_selected_grantappid) {
        this.selected_grantappid = get_selected_grantappid;
    }

    public RichSelectOneChoice getselected_grantappid() {
        return selected_grantappid;
    } 
    
    
    
    
    public void setreport_format(RichSelectOneChoice get_report_format) {
        this.report_format = get_report_format;
    }

    public RichSelectOneChoice getreport_format() {
        return report_format;
    }    
    
    public void setFromDateParam(RichInputDate fromDateParam) {
        this.fromDateParam = fromDateParam;
    }

    public RichInputDate getFromDateParam() {
        return fromDateParam;
    }

    public void setToDateParam(RichInputDate toDateParam) {
        this.toDateParam = toDateParam;
    }

    public RichInputDate getToDateParam() {
        return toDateParam;
    }
   
    
    
    
//    public void setselected_grant_type(RichSelectOneChoice get_selected_grant_type) {
//        this.selected_grant_type = get_selected_grant_type;
//    }
//
//    public RichSelectOneChoice getselected_grant_type() {
//        return selected_grant_type;
//    }    
    
    
    
    
    public void setselected_report_type(RichSelectOneChoice get_selected_report_type) {
        this.selected_report_type = get_selected_report_type;
    }

    public RichSelectOneChoice getselected_report_type() {
        return selected_report_type;
    }
    
}
