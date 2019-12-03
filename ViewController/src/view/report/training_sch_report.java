package view.report;

import com.tangosol.internal.sleepycat.je.utilint.Timestamp;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import javax.faces.event.ValueChangeEvent;

import java.util.Date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Calendar;

import java.util.Locale;

import view.DatabaseConnection.DatabaseConnection;

public class training_sch_report {
    public training_sch_report() {
    }


    private static String gotCluster = "";
    private static String gotTrainer = "";
    private static String gotPhase = "";
    private static String gotDate = "";

    private static String selectedReportType = "";
    private static String gotFormat = "";

    public String get_report() {
        // Add event code here...
        DatabaseConnection dbconnect = new DatabaseConnection();
        OracleReportBean reportBean = new OracleReportBean(dbconnect.getUipReport(), dbconnect.getUportReport(), null);


        if (gotCluster == "") {
            gotCluster = "";
        }
        if (gotTrainer == "") {
            gotTrainer = "";
        }
        if (gotPhase == "") {
            gotPhase = "";
        }
        if (gotDate == "") {
            gotDate = "";
        }
        
        
        String url = "";
        reportBean.setReportParameter("P_Trainer_id", gotTrainer);
        reportBean.setReportParameter("P_Cluster_id", gotCluster);
        reportBean.setReportParameter("P_Phase_id", gotPhase);
        reportBean.setReportParameter("P_Date", gotDate);


        if (gotFormat == "") {
            showMessage("Please Select Report Format");
        } else {

            switch (selectedReportType) {

            case "trainingSchDetail":

                reportBean.setReportURLName("userid=emfp/emfp@orcl&domain=classicdomain&report=C:/EMFP_Reports/Training_Sch_Detail&");

                System.out.println("training Sch Detail");
                break;

            case "trainingSchDetailCompWise":

                reportBean.setReportURLName("userid=emfp/emfp@orcl&domain=classicdomain&report=C:/EMFP_Reports/Training_Sch_Detail_Component_wise&");

                System.out.println("training Sch Detail Comp Wise");
                break;

            case "trainingSchDetailClusterWise":

                reportBean.setReportURLName("userid=emfp/emfp@orcl&domain=classicdomain&report=C:/EMFP_Reports/Training_Sch_Detail_Cluster_wise&");

                System.out.println("training Sch Detail Cluster Wise");
                break;

            case "trainingSchDetailDateWise":

                reportBean.setReportURLName("userid=emfp/emfp@orcl&domain=classicdomain&report=C:/EMFP_Reports/Training_Sch_Detail_Date_wise&");

                System.out.println("training Sch Detail Date Wise");
                break;

            case "trainingSchDetailModuleWise":

                reportBean.setReportURLName("userid=emfp/emfp@orcl&domain=classicdomain&report=C:/EMFP_Reports/Training_Sch_Detail_Module_wise&");

                System.out.println("training Sch Detail Module Wise");
                break;

            case "trainingSchDetailTeamFormaWise":

                reportBean.setReportURLName("userid=emfp/emfp@orcl&domain=classicdomain&report=C:/EMFP_Reports/Training_Sch_Detail_Team_Formation_wise&");

                System.out.println("training Sch Detail Team Forma Wise");
                break;

            case "trainingSchDetailTeamWise":

                reportBean.setReportURLName("userid=emfp/emfp@orcl&domain=classicdomain&report=C:/EMFP_Reports/Training_Sch_Detail_Team_wise&");

                System.out.println("training Sch Detail Team Wise");
                break;

            case "trainingSchDetailTrainerWise":

                reportBean.setReportURLName("userid=emfp/emfp@orcl&domain=classicdomain&report=C:/EMFP_Reports/Training_Sch_Detail_Trainer_wise&");

                System.out.println("training Sch Detail Trainer Wise");
                break;

            case "trainingSchDetailTrainingWise":

                reportBean.setReportURLName("userid=emfp/emfp@orcl&domain=classicdomain&report=C:/EMFP_Reports/Training_Sch_Detail_Training_wise&");

                System.out.println("training Sch Detail Training Wise");
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

    public void get_selected_date(ValueChangeEvent valueChangeEvent) {
        // Add event code here...

        gotDate = (valueChangeEvent.getNewValue()).toString();

        try {
            DateFormat sdf = new SimpleDateFormat("EE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
            Date parsedDate = sdf.parse(gotDate);
            SimpleDateFormat print = new SimpleDateFormat("dd-MMM-yy");
            gotDate = (print.format(parsedDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println("Selected Date is : " + gotDate);
    }

    public void get_phase(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        gotPhase = (valueChangeEvent.getNewValue()).toString();
        System.out.println("Selected Phase is : " + gotPhase);
    }

    public void get_report_type(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        selectedReportType = (valueChangeEvent.getNewValue()).toString();
        System.out.println("Selected Report Type is : " + selectedReportType);

    }

    public void get_report_format(ValueChangeEvent valueChangeEvent) {
        // Add event code here...
        gotFormat = (valueChangeEvent.getNewValue()).toString();
        System.out.println("Selected Format is : " + gotFormat);
    }
}
