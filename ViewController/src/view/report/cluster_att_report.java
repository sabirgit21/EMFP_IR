package view.report;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Locale;

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
    private static String gotFromDate = "";
    private static String gotToDate = "";
    private static String gotCity = "";
    private static String gotCrop = "";
    private static String gotDistrict = "";
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
        reportBean.setReportParameter("P_Fdated", gotFromDate);
        reportBean.setReportParameter("P_Tdated", gotToDate);
        reportBean.setReportParameter("P_City_id", gotCity);
        reportBean.setReportParameter("P_Crop_id", gotCrop);
        reportBean.setReportParameter("P_District_id", gotDistrict);


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
            case "attDetailDistrictWise":

                reportBean.setReportURLName("userid=emfp/emfp@orcl&domain=classicdomain&report=C:/EMFP_Reports/Cluster_Attandence_Detail_District_Wise&");

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
            
           case "attDetailTrainerModuleWise":

                    reportBean.setReportURLName("userid=emfp/emfp@orcl&domain=classicdomain&report=C:/EMFP_Reports/Cluster_Attandence_Detail_Trainer_Module_Wise&");

                    System.out.println("att detail trainer module wise");
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

    public void get_selected_crop(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        gotCrop = (valueChangeEvent.getNewValue()).toString();
        System.out.println("Selected Crop is : " + gotCrop);
    }

    public void get_selected_district(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        gotDistrict = (valueChangeEvent.getNewValue()).toString();
        System.out.println("Selected District is : " + gotDistrict);
    }

    public void get_from_date(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        gotFromDate = (valueChangeEvent.getNewValue()).toString();
        
        try {
            DateFormat sdf = new SimpleDateFormat("EE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
            Date parsedDate = sdf.parse(gotFromDate);
            SimpleDateFormat print = new SimpleDateFormat("dd-MMM-yy");
            gotFromDate = (print.format(parsedDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        System.out.println("Selected From Date is : " + gotFromDate);
    }

    public void get_to_date(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        gotToDate = (valueChangeEvent.getNewValue()).toString();
        
        try {
            DateFormat sdf = new SimpleDateFormat("EE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
            Date parsedDate = sdf.parse(gotToDate);
            SimpleDateFormat print = new SimpleDateFormat("dd-MMM-yy");
            gotToDate = (print.format(parsedDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        System.out.println("Selected To Date is : " + gotToDate);
    }

    public void get_format_type(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        gotFormat = (valueChangeEvent.getNewValue()).toString();
        System.out.println("Selected Format is : " + gotFormat);
    }
}
