package view.report;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import javax.faces.event.ValueChangeEvent;

import view.DatabaseConnection.DatabaseConnection;

public class training_sch_report {
    public training_sch_report() {
    }
    

    private static String gotCluster = "";
    private static String gotTrainer = "";
    private static String gotPhase = "";   
    
    private static String  selectedReportType = "";

    public String get_report() {
        // Add event code here...
        DatabaseConnection dbconnect = new DatabaseConnection();
        OracleReportBean reportBean = new OracleReportBean(dbconnect.getUipReport(), dbconnect.getUportReport(), null);


        String url = "";
        reportBean.setReportParameter("P_Trainer_id", gotTrainer);
        reportBean.setReportParameter("P_Cluster_id", gotCluster);
        reportBean.setReportParameter("P_Phase_id", gotPhase);


        System.out.println("default");

        switch (selectedReportType) {
        case "trainingSchDetail":

            reportBean.setReportURLName("userid=emfp/emfp@orcl&domain=classicdomain&report=C:/EMFP_Reports/Grant_Approval_Detail&");
            reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESTYPE,
                                            "CACHE"); // which will be one of the [cashe - file - mail - printer]
            reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESFORMAT,
                                            "PDF"); // Which will be onr of the [HTML - HTML CSS - PDF - SPREADSHEET- RTF].
            reportBean.setReportParameter("paramform", "no");

            url = reportBean.getReportServerURL();
            System.out.println("Url => " + url);
            reportBean.openUrlInNewWindow(url);
            System.out.println("att detail wise");
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

    public void get_Cluster(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        gotCluster = (valueChangeEvent.getNewValue()).toString();
        System.out.println("Selected Cluster is : " + gotCluster);
    }

    public void get_trainer(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        gotTrainer = (valueChangeEvent.getNewValue()).toString();
        System.out.println("Selected Trainer is : " + gotTrainer);
    }

    public void get_phase(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        gotPhase = (valueChangeEvent.getNewValue()).toString();
        System.out.println("Selected Phase is : " + gotPhase);
    }
}
