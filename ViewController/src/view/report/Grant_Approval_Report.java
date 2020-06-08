package view.report;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;

import oracle.jbo.domain.Number;

import view.DatabaseConnection.DatabaseConnection;

public class Grant_Approval_Report {

    private static Number gotPhase;
    private static Number gotCluster;
    private static Number gotFarmer;
    
    private static String selectedgrantType;   
    
    private static String selectedReportType = "";
    private static String gotFormat = "";
    

    private RichSelectOneChoice selected_phase;
    private RichSelectOneChoice selected_cluster;
    private RichSelectOneChoice selected_farmer;
    private RichSelectOneChoice report_format;
    private RichSelectOneChoice selected_grant_type;
    private RichSelectOneChoice selected_report_type;
    
        
  
    
    
    

    public Grant_Approval_Report() {
        System.out.println("grant approval report constructor called");
    }

    public String gen_Report() {

        DatabaseConnection dbconnect = new DatabaseConnection();
        OracleReportBean reportBean = new OracleReportBean(dbconnect.getUipReport(), dbconnect.getUportReport(), null);

        
            gotPhase = (Number)this.getselected_phase().getValue(); // To recieve value from UI InputText Component
            gotCluster = (Number)this.getselected_cluster().getValue();    
            gotFarmer = (Number)this.getselected_farmer().getValue();
            selectedgrantType = (this.getselected_grant_type().getValue()).toString();
            
            
        gotFormat = (String)this.getreport_format().getValue();
        selectedReportType = (String)this.getselected_report_type().getValue();
       
        
        String url = "";
        
        
        if(gotPhase != null){
            reportBean.setReportParameter("P_Phase_id", gotPhase.toString());
        }         
        if(gotCluster != null){
            reportBean.setReportParameter("P_Cluster_id", gotCluster.toString());
        }         
        if(gotFarmer != null){
            reportBean.setReportParameter("P_farmer_reg_id", gotFarmer.toString());
        }           
        if(selectedgrantType != null){
            reportBean.setReportParameter("P_Grant_Type", selectedgrantType.toString());
        } 


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
    
    
    
    
    public void setreport_format(RichSelectOneChoice get_report_format) {
        this.report_format = get_report_format;
    }

    public RichSelectOneChoice getreport_format() {
        return report_format;
    }    
    
    
    
    
    public void setselected_grant_type(RichSelectOneChoice get_selected_grant_type) {
        this.selected_grant_type = get_selected_grant_type;
    }

    public RichSelectOneChoice getselected_grant_type() {
        return selected_grant_type;
    }    
    
    
    
    
    public void setselected_report_type(RichSelectOneChoice get_selected_report_type) {
        this.selected_report_type = get_selected_report_type;
    }

    public RichSelectOneChoice getselected_report_type() {
        return selected_report_type;
    }
    
}
