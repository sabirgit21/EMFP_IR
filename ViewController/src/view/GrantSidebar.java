package view;

import java.io.Serializable;

import javax.faces.event.ActionEvent;

import oracle.adf.controller.TaskFlowId;

public class GrantSidebar implements Serializable {
    private String taskFlowId = "/WEB-INF/Task_Flows/Modules/Grants/Grants_TaskFlow.xml#Grants_TaskFlow";

    public GrantSidebar() {
    }

    public TaskFlowId getDynamicTaskFlowId() {
        return TaskFlowId.parse(taskFlowId);
    }

    public void setDynamicTaskFlowId(String taskFlowId) {
        this.taskFlowId = taskFlowId;
    }

    public void Grant_App_Click(ActionEvent actionEvent) {
        // Add event code here...
        setDynamicTaskFlowId("/WEB-INF/Task_Flows/Modules/Grants/Grant_Application_TaskFlow.xml#Grant_Application_TaskFlow");
    }

    public void Grant_Rate_Click(ActionEvent actionEvent) {
        // Add event code here...
        setDynamicTaskFlowId("/WEB-INF/Task_Flows/Modules/Grants/Grant_Rate_TaskFlow.xml#Grant_Rate_TaskFlow");
    }

    public void Grant_Approval_Click(ActionEvent actionEvent) {
        // Add event code here...
        setDynamicTaskFlowId("/WEB-INF/Task_Flows/Modules/Grants/Grant_Approval_TaskFlow.xml#Grant_Approval_TaskFlow");
    }
    
    public void fragmentCall(ActionEvent actionEvent) {
        // Add event code here...
        String action = (String)actionEvent.getComponent().getAttributes().get("link");
        StringBuilder link = new StringBuilder();
        link.append("/WEB-INF/Task_Flows/Modules/Grants/");
        link.append(action);
        link.append(".xml#");
        link.append(action);
        setDynamicTaskFlowId(link.toString());
    }
}
