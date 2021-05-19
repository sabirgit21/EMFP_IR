package view.report;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import view.DatabaseConnection.DatabaseConnection;

public class farmer_report {

    private static String gotClusterNum = "";
    private static String gotFarmerNum = "";
    private static String gotCity = "";
    private static String gotCrop = "";
    private static String gotPhase = "";
    private static String selectedReportType = "";
    private static String gotFormat = "";


    public farmer_report() {
    }


    public String gen_farmer_report() {
        // Add event code here...
        System.out.println(selectedReportType);


        if (selectedReportType == null) {
            selectedReportType = "notSelected";
        }
        if (gotClusterNum == "") {
            gotClusterNum = "";
        }
        if (gotFarmerNum == "") {
            gotFarmerNum = "";
        }
        if (gotCity == "") {
            gotCity = "";
        }
        if (gotCrop == "") {
            gotCrop = "";
        }
        if (gotPhase == "") {
            gotPhase = "";
        }
        
        String url = "";
        DatabaseConnection dbconnect = new DatabaseConnection();
        OracleReportBean reportBean = new OracleReportBean(dbconnect.getUipReport(), dbconnect.getUportReport(), null);

        reportBean.setReportParameter("P_Farmer_Reg_id", gotFarmerNum);
        reportBean.setReportParameter("P_Cluster_ID", gotClusterNum);
        reportBean.setReportParameter("P_City_id", gotCity);
        reportBean.setReportParameter("P_Phase_id", gotPhase);
        reportBean.setReportParameter("P_Crop_id", gotCrop);


        if (gotFormat == "") {
            showMessage("Please Select Report Format");
        } else {

            switch (selectedReportType) {
            case "clusterWise":
                System.out.println("clusterWise");

                reportBean.setReportURLName("userid=emfp/emfpir@orcl&domain=classicdomain&report=C:/EMFP_Reports/Farmer_Reg_Cluster_Wise&");

                break;

            case "landWise":
                System.out.println("landWise");


                reportBean.setReportURLName("userid=emfp/emfpir@orcl&domain=classicdomain&report=C:/EMFP_Reports/Farmer_Reg_Land_Wise_Detail&");

                break;

            case "cropWise":
                System.out.println("cropWise");

                reportBean.setReportURLName("userid=emfp/emfpir@orcl&domain=classicdomain&report=C:/EMFP_Reports/Farmer_Reg_Crop_Wise&");

                break;

            case "cityWise":
                System.out.println("cityWise");

                reportBean.setReportURLName("userid=emfp/emfpir@orcl&domain=classicdomain&report=C:/EMFP_Reports/Farmer_Reg_City_Wise&");

                break;
                case "clusterWiseSummary":
                    System.out.println("clusterWiseSummary");

                    reportBean.setReportURLName("userid=emfp/emfpir@orcl&domain=classicdomain&report=C:/EMFP_Reports/Farmer_Reg_Cluster_Wise_Summary&");

                    break;
            case "notSelected":
                System.out.println("notSelected then generic report");

                reportBean.setReportURLName("userid=emfp/emfpir@orcl&domain=classicdomain&report=C:/EMFP_Reports/Farmer_Reg_Detail&");

                break;
            default:
                showMessage("Please Select Report Type");
                break;

            }
            reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESTYPE,
                                            "CACHE"); // which will be one of the [cashe - file - mail - printer]
            reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESFORMAT,
                                            gotFormat); // Which will be onr of the [HTML - HTML CSS - PDF - SPREADSHEET- RTF].
            url = reportBean.getReportServerURL();
            System.out.println("Url => " + url);
            reportBean.openUrlInNewWindow(url);
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

    public void get_selected_phase(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        gotPhase = (valueChangeEvent.getNewValue()).toString();
        System.out.println("Selected Phase is : " + gotPhase);
    }

    public void get_report_format(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        gotFormat = (valueChangeEvent.getNewValue()).toString();
        System.out.println("Selected Format is : " + gotFormat);
    }
}
