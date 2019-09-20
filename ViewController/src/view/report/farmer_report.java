package view.report;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

public class farmer_report {

    private static String gotClusterNum;
    private static String gotFarmerNum;
    private static String gotCity;
    private static String gotCrop;
    private static String selectedReportType;


    public farmer_report() {
    }

    

    public String gen_farmer_report() {
        // Add event code here...
        System.out.println(selectedReportType);
        
        
        if (selectedReportType == null) {
            selectedReportType = "notSelected";
        }

        String url = "";
        OracleReportBean reportBean = new OracleReportBean("203.223.173.235", "7001", null);

        switch (selectedReportType) {
        case "clusterWise":
            System.out.println("clusterWise");

            reportBean.setReportURLName("userid=emfp/emfp@orcl&domain=classicdomain&report=C:/EMFP_Reports/Farmer_Reg_Cluster_Wise&");
            reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESTYPE,
                                            "CACHE"); // which will be one of the [cashe - file - mail - printer]
            reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESFORMAT,
                                            "PDF"); // Which will be onr of the [HTML - HTML CSS - PDF - SPREADSHEET- RTF].
            url = reportBean.getReportServerURL();
            System.out.println("Url => " + url);
            reportBean.openUrlInNewWindow(url);
            break;

        case "landWise":
            System.out.println("landWise");


            reportBean.setReportURLName("userid=emfp/emfp@orcl&domain=classicdomain&report=C:/EMFP_Reports/Farmer_Reg_Land_Wise_Detail&");
            reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESTYPE,
                                            "CACHE"); // which will be one of the [cashe - file - mail - printer]
            reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESFORMAT,
                                            "PDF"); // Which will be onr of the [HTML - HTML CSS - PDF - SPREADSHEET- RTF].
            url = reportBean.getReportServerURL();
            System.out.println("Url => " + url);
            reportBean.openUrlInNewWindow(url);
            break;

        case "cropWise":
            System.out.println("cropWise");

            reportBean.setReportURLName("userid=emfp/emfp@orcl&domain=classicdomain&report=C:/EMFP_Reports/Farmer_Reg_Crop_Wise&");
            reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESTYPE,
                                            "CACHE"); // which will be one of the [cashe - file - mail - printer]
            reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESFORMAT,
                                            "PDF"); // Which will be onr of the [HTML - HTML CSS - PDF - SPREADSHEET- RTF].
            url = reportBean.getReportServerURL();
            System.out.println("Url => " + url);
            reportBean.openUrlInNewWindow(url);
            break;

        case "cityWise":
            System.out.println("cityWise");

            reportBean.setReportURLName("userid=emfp/emfp@orcl&domain=classicdomain&report=C:/EMFP_Reports/Farmer_Reg_City_Wise&");
            reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESTYPE,
                                            "CACHE"); // which will be one of the [cashe - file - mail - printer]
            reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESFORMAT,
                                            "PDF"); // Which will be onr of the [HTML - HTML CSS - PDF - SPREADSHEET- RTF].
            url = reportBean.getReportServerURL();
            System.out.println("Url => " + url);
            reportBean.openUrlInNewWindow(url);
            break;
        case "notSelected":
            System.out.println("notSelected then generic report");

            reportBean.setReportURLName("userid=emfp/emfp@orcl&domain=classicdomain&report=C:/EMFP_Reports/Farmer_Reg_Detail&");
            reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESTYPE,
                                            "CACHE"); // which will be one of the [cashe - file - mail - printer]
            reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESFORMAT,
                                            "PDF"); // Which will be onr of the [HTML - HTML CSS - PDF - SPREADSHEET- RTF].
            url = reportBean.getReportServerURL();
            System.out.println("Url => " + url);
            reportBean.openUrlInNewWindow(url);
            break;
        default:
            showMessage("Please Select Report Type");
            break;

        }
        return null;

    }

    public void get_selected_report_type(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        selectedReportType = (valueChangeEvent.getNewValue()).toString();
        System.out.println("Selected Report Type is : " + selectedReportType);
    }

    public void get_selected_cluster_num(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        gotClusterNum = (valueChangeEvent.getNewValue()).toString();
        System.out.println("Selected Cluster No. is : " + gotClusterNum);
    }

    public void get_selected_farmer_num(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        gotFarmerNum = (valueChangeEvent.getNewValue()).toString();
        System.out.println("Selected Farmer No. is : " + gotFarmerNum);
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

}
