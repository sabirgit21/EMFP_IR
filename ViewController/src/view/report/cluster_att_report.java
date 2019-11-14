package view.report;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import javax.faces.event.ValueChangeEvent;

import view.DatabaseConnection.DatabaseConnection;

public class cluster_att_report {
    public cluster_att_report() {
    }


    private static String gotCluster = "";
    private static String gotTrainer = "";
    private static String gotFarmer = "";
    private static String gotCity = "";
    private static String gotModule = "";
    

    private static String selectedReportType = "";
    private static String gotFormat = "";

    public String get_report() {
        // Add event code here...
        DatabaseConnection dbconnect = new DatabaseConnection();
        OracleReportBean reportBean = new OracleReportBean(dbconnect.getUipReport(), dbconnect.getUportReport(), null);


        String url = "";
        reportBean.setReportParameter("P_Trainer_id", gotTrainer);
        reportBean.setReportParameter("P_Cluster_id", gotCluster);
        reportBean.setReportParameter("P_Module_id", gotModule);
        reportBean.setReportParameter("P_Farmer_reg_id", gotFarmer);
        reportBean.setReportParameter("P_City_id", gotCity);


        if (gotFormat == "") {
            showMessage("Please Select Report Format");
        } else {

            switch (selectedReportType) {
            case "attDetailWise":

                reportBean.setReportURLName("userid=emfp/emfp@orcl&domain=classicdomain&report=C:/EMFP_Reports/Cluster_Attandence_Detail&");

                System.out.println("att detail wise");
                break;
            case "attDetailCityWise":

                reportBean.setReportURLName("userid=emfp/emfp@orcl&domain=classicdomain&report=C:/EMFP_Reports/Cluster_Attandence_Detail_City_Wise&");

                System.out.println("att detail city wise");
                break;
            case "attDetaiClusterlWise":

                reportBean.setReportURLName("userid=emfp/emfp@orcl&domain=classicdomain&report=C:/EMFP_Reports/Cluster_Attandence_Detail_Cluster_Wise&");

                System.out.println("att detail cluster wise");
                break;

            case "attDetailFarmerWise":

                reportBean.setReportURLName("userid=emfp/emfp@orcl&domain=classicdomain&report=C:/EMFP_Reports/Cluster_Attandence_Detail_Farmer_Wise&");

                System.out.println("att detail farmer wise");
                break;

            case "attDetailTrainerWise":

                reportBean.setReportURLName("userid=emfp/emfp@orcl&domain=classicdomain&report=C:/EMFP_Reports/Cluster_Attandence_Detail_Trainer_Wise&");

                System.out.println("att detail trainer wise");
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

    public void get_selected_report_type(ValueChangeEvent valueChangeEvent) {
        selectedReportType = (valueChangeEvent.getNewValue()).toString();
        System.out.println("Selected Report Type is : " + selectedReportType);
        // Add event code here...
    }

    public void get_module(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        gotModule = (valueChangeEvent.getNewValue()).toString();
        System.out.println("Selected Module is : " + gotModule);
    }

    public void get_selected_cluster(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        gotCluster = (valueChangeEvent.getNewValue()).toString();
        System.out.println("Selected Cluster is : " + gotCluster);
    }

    public void get_selected_trainer(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        gotTrainer = (valueChangeEvent.getNewValue()).toString();
        System.out.println("Selected Trainer is : " + gotTrainer);
    }

    public void get_selected_farmer(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        gotFarmer = (valueChangeEvent.getNewValue()).toString();
        System.out.println("Selected Farmer is : " + gotFarmer);
    }

    public void get_selected_city(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        gotCity = (valueChangeEvent.getNewValue()).toString();
        System.out.println("Selected City is : " + gotCity);
    }

    public void get_format_type(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        gotFormat = (valueChangeEvent.getNewValue()).toString();
        System.out.println("Selected Format is : " + gotFormat);
    }
}
