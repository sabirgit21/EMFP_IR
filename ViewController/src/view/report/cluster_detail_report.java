package view.report;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import view.DatabaseConnection.DatabaseConnection;


public class cluster_detail_report {

    private static String gotPhase = "";
    private static String gotCrop = "";
    private static String gotCity = "";
    private static String selectedReportType = "";
    private static String gotFormat = "";


    public cluster_detail_report() {
    }
    String param1;
    String reportType;

    public Object gen_cluster_detail_report() {
        // Add event code here...

        selectedReportType = getReportType();
        if (selectedReportType == null) {
            selectedReportType = "notSelected";
        }
        DatabaseConnection dbconnect = new DatabaseConnection();
        OracleReportBean reportBean = new OracleReportBean(dbconnect.getUipReport(), dbconnect.getUportReport(), null);


        if (gotPhase == "") {
            gotPhase = "";
        }
        if (gotCrop == "") {
            gotCrop = "";
        }
        if (gotCity == "") {
            gotCity = "";
        }
        
        //        reportBean.setReportURLName("userid=ir19/ir19@orcl&domain=classicdomain&report=C:/ERP/ir19/REPORTS/ReportsGl/SALE_INVOICE&");
        String url = "";
        reportBean.setReportParameter("P_Phase_id", gotPhase);
        reportBean.setReportParameter("P_Crop_id", gotCrop);
        reportBean.setReportParameter("P_City_id", gotCity);


        if (gotFormat == "") {
            showMessage("Please Select Report Format");
        } else {

            switch (selectedReportType) {
            case "phaseWise":
                System.out.println("phaseWise");
                reportBean.setReportURLName("userid=emfp/emfpir@orcl&domain=classicdomain&report=C:/EMFP_Reports/Cluster_Detail_Phase_Wise&");

                break;
            case "cropWise":
                System.out.println("cropWise");
                reportBean.setReportURLName("userid=emfp/emfpir@orcl&domain=classicdomain&report=C:/EMFP_Reports/Cluster_Detail_Crop_Wise&");

                break;
            case "cityWise":
                System.out.println("cityWise");
                reportBean.setReportURLName("userid=emfp/emfpir@orcl&domain=classicdomain&report=C:/EMFP_Reports/Cluster_Detail_City_Wise&");

                break;
            case "notSelected":
                showMessage("Please Select Report Type");
                break;
            case "null":
                showMessage("Please Select Report Type");
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

    public void setParam1(String param1) {
        this.param1 = param1;
    }

    public String getParam1() {
        return param1;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public String getReportType() {
        return reportType;
    }

    public void get_selected_phase(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        gotPhase = (valueChangeEvent.getNewValue()).toString();
        System.out.println("Selected Phase is : " + gotPhase);
    }

    public void get_selected_crop(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        gotCrop = (valueChangeEvent.getNewValue()).toString();
        System.out.println("Selected Crop is : " + gotCrop);
    }

    public void get_selected_city(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        gotCity = (valueChangeEvent.getNewValue()).toString();
        System.out.println("Selected City is : " + gotCity);
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

    public void get_report_format(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        gotFormat = (valueChangeEvent.getNewValue()).toString();
        System.out.println("Selected Format is : " + gotFormat);
    }
}
