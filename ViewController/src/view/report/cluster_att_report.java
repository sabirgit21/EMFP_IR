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

import view.DatabaseConnection.DatabaseConnection;

import oracle.jbo.domain.Number;

public class cluster_att_report {
    private RichSelectOneChoice selected_module;
    private RichSelectOneChoice selected_cluster;
    private RichSelectOneChoice selected_trainer;
    private RichSelectOneChoice selected_farmer;
    private RichSelectOneChoice selected_crop;
    private RichSelectOneChoice selected_district;
    private RichSelectOneChoice selected_city;
    private RichInputDate from_date;
    private RichInputDate to_date;
    private RichSelectOneChoice format_type;
    private RichSelectOneChoice report_type;

    public cluster_att_report() {
    }


    private static Number gotCluster;
    private static Number gotTrainer;
    private static Number gotFarmer;
    private static String gotFromDate;
    private static String gotToDate;
    private static Number gotCity;
    private static Number gotCrop;
    private static Number gotDistrict;
    private static Number  gotModule;


    private static String selectedReportType = "";
    private static String gotFormat = "";

    public String get_report() {
        // Add event code here...
        
        gotModule = (Number)this.getselected_module().getValue(); // To recieve value from UI InputText Component
        gotDistrict = (Number)this.getSelected_district().getValue();
        gotCrop = (Number)this.getSelected_crop().getValue();
        gotCity = (Number)this.getSelected_city().getValue();
        gotFarmer = (Number)this.getSelected_farmer().getValue();
        gotTrainer = (Number)this.getSelected_trainer().getValue();
        gotCluster = (Number)this.getSelected_cluster().getValue();
        gotFromDate = (this.getFrom_date().getValue()).toString();
        gotToDate = (this.getTo_date().getValue()).toString();
        
        selectedReportType = (String)this.getReport_type().getValue();
        gotFormat = (String)this.getFormat_type().getValue();
        

        
        DatabaseConnection dbconnect = new DatabaseConnection();
        OracleReportBean reportBean = new OracleReportBean(dbconnect.getUipReport(), dbconnect.getUportReport(), null);

        
        if(gotModule != null){
            reportBean.setReportParameter("P_Module_id", gotModule.toString());
            System.out.println("lyy fir agiaaa eeeiiii");
        }        
        if(gotDistrict != null){
            reportBean.setReportParameter("P_District_id", gotDistrict.toString());
            System.out.println("lyy fir agiaaa eeeiiii");
        }        
        if(gotCrop != null){
            reportBean.setReportParameter("P_Crop_id", gotCrop.toString());
            System.out.println("lyy fir agiaaa eeeiiii");
        }        
        if(gotCity != null){
            reportBean.setReportParameter("P_City_id", gotCity.toString());
            System.out.println("lyy fir agiaaa eeeiiii");
        }        
        if(gotFarmer != null){
            reportBean.setReportParameter("P_Farmer_reg_id", gotFarmer.toString());
            System.out.println("lyy fir agiaaa eeeiiii");
        }        
        if(gotTrainer != null){
            reportBean.setReportParameter("P_Trainer_id", gotTrainer.toString());
            System.out.println("lyy fir agiaaa eeeiiii");
        }        
        if(gotCluster != null){
            reportBean.setReportParameter("P_Cluster_id", gotCluster.toString());
            System.out.println("lyy fir agiaaa eeeiiii");
        }        
        if(gotFromDate != null){

            try {
                DateFormat sdf = new SimpleDateFormat("EE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
                Date parsedDate = sdf.parse(gotFromDate);
                SimpleDateFormat print = new SimpleDateFormat("dd-MMM-yy");
                gotFromDate = (print.format(parsedDate));
            } catch (ParseException e) {
                e.printStackTrace();
            }

            System.out.println("Selected From Date is : " + gotFromDate);
            reportBean.setReportParameter("P_Fdated", gotFromDate.toString());
            System.out.println("lyy fir agiaaa eeeiiii");
        }      
        
        if(gotToDate != null){
            
            try {
                DateFormat sdf = new SimpleDateFormat("EE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
                Date parsedDate = sdf.parse(gotToDate);
                SimpleDateFormat print = new SimpleDateFormat("dd-MMM-yy");
                gotToDate = (print.format(parsedDate));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            
            System.out.println("Selected To Date is : " + gotToDate);
            reportBean.setReportParameter("P_Tdated", gotToDate.toString());
            System.out.println("lyy fir agiaaa eeeiiii");
        }
        
        
        
        
        
        String url = "";
//        reportBean.setReportParameter("P_Trainer_id", gotTrainer);
//        reportBean.setReportParameter("P_Cluster_id", gotCluster); 
//        reportBean.setReportParameter("P_Module_id", gotModule);
//        reportBean.setReportParameter("P_Farmer_reg_id", gotFarmer);
//        reportBean.setReportParameter("P_Fdated", gotFromDate);
//        reportBean.setReportParameter("P_Tdated", gotToDate);
//        reportBean.setReportParameter("P_City_id", gotCity);
//        reportBean.setReportParameter("P_Crop_id", gotCrop);
//        reportBean.setReportParameter("P_District_id", gotDistrict);


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

                System.out.println("att detail district wise");
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

//    public void get_module(ValueChangeEvent valueChangeEvent) {
//        // Add event code here...
//        gotModule = (valueChangeEvent.getNewValue()).toString();
//        System.out.println("Selected Module is : " + gotModule);
//    }

//    public void get_selected_cluster(ValueChangeEvent valueChangeEvent) {
//        // Add event code here...
//        gotCluster = (valueChangeEvent.getNewValue()).toString();
//        System.out.println("Selected Cluster is : " + gotCluster);
//    }
//
//    public void get_selected_trainer(ValueChangeEvent valueChangeEvent) {
//        // Add event code here...
//        gotTrainer = (valueChangeEvent.getNewValue()).toString();
//        System.out.println("Selected Trainer is : " + gotTrainer);
//    }
//
//    public void get_selected_farmer(ValueChangeEvent valueChangeEvent) {
//        // Add event code here...
//        gotFarmer = (valueChangeEvent.getNewValue()).toString();
//        System.out.println("Selected Farmer is : " + gotFarmer);
//    }
//
//    public void get_selected_city(ValueChangeEvent valueChangeEvent) {
//        // Add event code here...
//        gotCity = (valueChangeEvent.getNewValue()).toString();
//        System.out.println("Selected City is : " + gotCity);
//    }
//
//    public void get_selected_crop(ValueChangeEvent valueChangeEvent) {
//        // Add event code here...
//        gotCrop = (valueChangeEvent.getNewValue()).toString();
//        System.out.println("Selected Crop is : " + gotCrop);
//    }
//
//    public void get_selected_district(ValueChangeEvent valueChangeEvent) {
//        // Add event code here...
//        gotDistrict = (valueChangeEvent.getNewValue()).toString();
//        System.out.println("Selected District is : " + gotDistrict);
//    }

//    public void get_from_date(ValueChangeEvent valueChangeEvent) {
//        // Add event code here...
//        gotFromDate = (valueChangeEvent.getNewValue()).toString();
//
//        try {
//            DateFormat sdf = new SimpleDateFormat("EE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
//            Date parsedDate = sdf.parse(gotFromDate);
//            SimpleDateFormat print = new SimpleDateFormat("dd-MMM-yy");
//            gotFromDate = (print.format(parsedDate));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("Selected From Date is : " + gotFromDate);
//    }
//
//    public void get_to_date(ValueChangeEvent valueChangeEvent) {
//        // Add event code here...
//        gotToDate = (valueChangeEvent.getNewValue()).toString();
//
//        try {
//            DateFormat sdf = new SimpleDateFormat("EE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
//            Date parsedDate = sdf.parse(gotToDate);
//            SimpleDateFormat print = new SimpleDateFormat("dd-MMM-yy");
//            gotToDate = (print.format(parsedDate));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("Selected To Date is : " + gotToDate);
//    }

//    public void get_format_type(ValueChangeEvent valueChangeEvent) {
//        // Add event code here...
//        gotFormat = (valueChangeEvent.getNewValue()).toString();
//        System.out.println("Selected Format is : " + gotFormat);
//    }

    public void setselected_module(RichSelectOneChoice get_selected_module) {
        this.selected_module = get_selected_module;
    }

    public RichSelectOneChoice getselected_module() {
        return selected_module;
    }

    public void setSelected_cluster(RichSelectOneChoice selected_cluster) {
        this.selected_cluster = selected_cluster;
    }

    public RichSelectOneChoice getSelected_cluster() {
        return selected_cluster;
    }

    public void setSelected_trainer(RichSelectOneChoice selected_trainer) {
        this.selected_trainer = selected_trainer;
    }

    public RichSelectOneChoice getSelected_trainer() {
        return selected_trainer;
    }

    public void setSelected_farmer(RichSelectOneChoice selected_farmer) {
        this.selected_farmer = selected_farmer;
    }

    public RichSelectOneChoice getSelected_farmer() {
        return selected_farmer;
    }

    public void setSelected_crop(RichSelectOneChoice selected_crop) {
        this.selected_crop = selected_crop;
    }

    public RichSelectOneChoice getSelected_crop() {
        return selected_crop;
    }

    public void setSelected_district(RichSelectOneChoice selected_district) {
        this.selected_district = selected_district;
    }

    public RichSelectOneChoice getSelected_district() {
        return selected_district;
    }

    public void setSelected_city(RichSelectOneChoice selected_city) {
        this.selected_city = selected_city;
    }

    public RichSelectOneChoice getSelected_city() {
        return selected_city;
    }

    public void setFrom_date(RichInputDate from_date) {
        this.from_date = from_date;
    }

    public RichInputDate getFrom_date() {
        return from_date;
    }

    public void setTo_date(RichInputDate to_date) {
        this.to_date = to_date;
    }

    public RichInputDate getTo_date() {
        return to_date;
    }

    public void setFormat_type(RichSelectOneChoice format_type) {
        this.format_type = format_type;
    }

    public RichSelectOneChoice getFormat_type() {
        return format_type;
    }

    public void setReport_type(RichSelectOneChoice report_type) {
        this.report_type = report_type;
    }

    public RichSelectOneChoice getReport_type() {
        return report_type;
    }
}
