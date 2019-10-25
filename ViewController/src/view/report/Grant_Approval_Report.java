package view.report;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import view.DatabaseConnection.DatabaseConnection;

public class Grant_Approval_Report {
    
    private static String gotPhase = "";
    private static String gotCluster = "";
    private static String gotFarmer = "";
    private static String selectedReportType;
    
    public Grant_Approval_Report() {
    }
    
    public String gen_Report() {
        
        DatabaseConnection dbconnect = new DatabaseConnection();
        OracleReportBean reportBean = new OracleReportBean(dbconnect.getUipReport(), dbconnect.getUportReport(), null);


        String url = "";
        reportBean.setReportParameter("P_Phase_id",gotPhase);
        reportBean.setReportParameter("P_Cluster_id",gotCluster);
        reportBean.setReportParameter("P_farmer_reg_id",gotFarmer);
        
       
            System.out.println("default");
            
        switch (selectedReportType) {
        case "detailWise":
         
            reportBean.setReportURLName("userid=emfp/emfp@orcl&domain=classicdomain&report=C:/EMFP_Reports/Grant_Approval_Detail&");
            reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESTYPE,
                                            "CACHE"); // which will be one of the [cashe - file - mail - printer]
            reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESFORMAT,
                                            "PDF"); // Which will be onr of the [HTML - HTML CSS - PDF - SPREADSHEET- RTF].
            reportBean.setReportParameter("paramform", "no");
            
            url = reportBean.getReportServerURL();
            System.out.println("Url => " + url);
            reportBean.openUrlInNewWindow(url);
            System.out.println("detail wise");
            break;
        case "machineryWise":
         
            reportBean.setReportURLName("userid=emfp/emfp@orcl&domain=classicdomain&report=C:/EMFP_Reports/Grant_Approval_Machinery_wise_Detail&");
            reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESTYPE,
                                            "CACHE"); // which will be one of the [cashe - file - mail - printer]
            reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESFORMAT,
                                            "PDF"); // Which will be onr of the [HTML - HTML CSS - PDF - SPREADSHEET- RTF].
            reportBean.setReportParameter("paramform", "no");
            
            url = reportBean.getReportServerURL();
            System.out.println("Url => " + url);
            reportBean.openUrlInNewWindow(url);
            System.out.println("machinery wise");
            break;
        case "machineryPhaseWise":
         
            reportBean.setReportURLName("userid=emfp/emfp@orcl&domain=classicdomain&report=C:/EMFP_Reports/Grant_Approval_Machinery_Phase_Wise_Detail&");
            reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESTYPE,
                                            "CACHE"); // which will be one of the [cashe - file - mail - printer]
            reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESFORMAT,
                                            "PDF"); // Which will be onr of the [HTML - HTML CSS - PDF - SPREADSHEET- RTF].
            reportBean.setReportParameter("paramform", "no");
            
            url = reportBean.getReportServerURL();
            System.out.println("Url => " + url);
            reportBean.openUrlInNewWindow(url);
            System.out.println("machinery phase wise");
            break;
        default:
        showMessage("Please Select Report Type");
        break;

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

    public void get_selected_cluster(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        gotCluster = (valueChangeEvent.getNewValue()).toString();
        System.out.println("Selected Cluster is : " + gotCluster);
    }

    public void get_selected_phase(ValueChangeEvent valueChangeEvent) {
        // Add event code here...++
        gotPhase = (valueChangeEvent.getNewValue()).toString();
        System.out.println("Selected Phase is : " + gotPhase);
    }

    public void get_selected_farmer(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        gotFarmer = (valueChangeEvent.getNewValue()).toString();
        System.out.println("Selected Farmer is : " + gotFarmer);
    }

    public void get_selected_report_type(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        selectedReportType = (valueChangeEvent.getNewValue()).toString();
        System.out.println("Selected Report Type is : " + selectedReportType);
    }
}
