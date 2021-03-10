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

    public cluster_att_report() {
        System.out.println("cluster att report constructor called");
    }
    
    private RichSelectOneChoice selected_module;
    private RichSelectOneChoice selected_cluster;
    private RichSelectOneChoice selected_trainer;
    private RichSelectOneChoice selected_farmer;
    private RichSelectOneChoice selected_crop;
    private RichSelectOneChoice selected_district;
    private RichSelectOneChoice selected_city;
    private RichSelectOneChoice format_type;
    private RichSelectOneChoice report_type;
    private RichInputDate fromDateParam;
    private RichInputDate toDateParam;



    private static Number gotCluster;
    private static Number gotTrainer;
    private static Number gotFarmer;
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
        
        selectedReportType = (String)this.getReport_type().getValue();
        gotFormat = (String)this.getFormat_type().getValue();
        
        
        DatabaseConnection dbconnect = new DatabaseConnection();
        OracleReportBean reportBean = new OracleReportBean(dbconnect.getUipReport(), dbconnect.getUportReport(), null);
        String url = "";
        
        if(gotModule != null){
            reportBean.setReportParameter("P_Module_id", gotModule.toString());
        }        
        if(gotDistrict != null){
            reportBean.setReportParameter("P_District_id", gotDistrict.toString());
        }        
        if(gotCrop != null){
            reportBean.setReportParameter("P_Crop_id", gotCrop.toString());
        }        
        if(gotCity != null){
            reportBean.setReportParameter("P_City_id", gotCity.toString());
        }        
        if(gotFarmer != null){
            reportBean.setReportParameter("P_Farmer_reg_id", gotFarmer.toString());
        }        
        if(gotTrainer != null){
            reportBean.setReportParameter("P_Trainer_id", gotTrainer.toString());
        }        
        if(gotCluster != null){
            reportBean.setReportParameter("P_Cluster_id", gotCluster.toString());
        }     
        
        if(getFromDate() != ""){
            reportBean.setReportParameter("P_Fdated", getFromDate());
        }
        
        if(getToDate() != ""){
            reportBean.setReportParameter("P_Tdated", getToDate());
        }
        
        
        
        
        
        
//        reportBean.setReportParameter("P_Trainer_id", gotTrainer);
//        reportBean.setReportParameter("P_Cluster_id", gotCluster); 
//        reportBean.setReportParameter("P_Module_id", gotModule);
//        reportBean.setReportParameter("P_Farmer_reg_id", gotFarmer);
//        reportBean.setReportParameter("P_Fdated", getFromDate());
//        reportBean.setReportParameter("P_Tdated", getToDate());
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
            
                case "attDetailCropWise":

                         reportBean.setReportURLName("userid=emfp/emfp@orcl&domain=classicdomain&report=C:/EMFP_Reports/Cluster_Attandence_Detail_Crop_Wise&");

                         System.out.println("att detail crop wise");
                         break;
                case "farmerAttModule":

                         reportBean.setReportURLName("userid=emfp/emfp@orcl&domain=classicdomain&report=C:/EMFP_Reports/Farmer_Attendance_Module&");

                         System.out.println("farmer att module");
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
}
