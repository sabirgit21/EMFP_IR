package view.report;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;

import oracle.jbo.domain.Number;

import view.DatabaseConnection.DatabaseConnection;

public class Exhibition_Report {
    public Exhibition_Report() {
    }
    

    private static String gotFormat = "";    
    private static String selectedReportType = "";
    private static Number gotExpoSetup;
    
    private RichSelectOneChoice report_format;
    private RichSelectOneChoice selected_report_type;
    private RichSelectOneChoice selected_expoSetup;

    public String gen_report() {
        // Add event code here...
        DatabaseConnection dbconnect = new DatabaseConnection();
        OracleReportBean reportBean = new OracleReportBean(dbconnect.getUipReport(), dbconnect.getUportReport(), null);
        
        gotFormat = (String)this.getreport_format().getValue();
        gotExpoSetup = (Number)this.getselected_expoSetup().getValue();
        
        String url = "";
        
        if(gotExpoSetup != null){
            reportBean.setReportParameter("P_Expo_Setup_Id", gotExpoSetup.toString());
        } 
        
        if (gotFormat == "") {
            showMessage("Please Select Report Format");
        } else {
            
            switch (selectedReportType) {
            
            case "exhibitionBudgetDetail":

                reportBean.setReportURLName("userid=emfp/emfp@orcl&domain=classicdomain&report=C:/EMFP_Reports/Exhibition_Budget_Detail_Report&");
                System.out.println("Exhibition Budget Detail Report");
                break;

            default:
                showMessage("Please Select Report Type");
                break;

            }
            
        }
        reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESTYPE,
                                        "CACHE"); // which will be one of the [cashe - file - mail - printer]
        reportBean.setReportServerParam(OracleReportBean.RS_PARAM_DESFORMAT,
                                        gotFormat); // Which will be onr of the [HTML - HTML CSS - PDF - SPREADSHEET- RTF].
        reportBean.setReportParameter("paramform", "no");

        url = reportBean.getReportServerURL();
        System.out.println("Url => " + url);
        reportBean.openUrlInNewWindow(url);
        
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
    
    
    public void setselected_report_type(RichSelectOneChoice get_selected_report_type) {
        this.selected_report_type = get_selected_report_type;
    }

    public RichSelectOneChoice getselected_report_type() {
        return selected_report_type;
    }
    
    public void setreport_format(RichSelectOneChoice get_report_format) {
        this.report_format = get_report_format;
    }

    public RichSelectOneChoice getreport_format() {
        return report_format;
    }
    
    public void setselected_expoSetup(RichSelectOneChoice get_selected_expoSetup) {
        this.selected_expoSetup = get_selected_expoSetup;
    }

    public RichSelectOneChoice getselected_expoSetup() {
        return selected_expoSetup;
    }
}
