
package it.polito.dp2.WF.sol4.jaxws;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * 
 * 			This interface is aimed to handle operations on
 * 			workflow.
 * 		
 * 
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "WorkflowOperations", targetNamespace = "http://www.example.org/Workflow")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface WorkflowOperations {


    /**
     * 
     * @param wfName
     * @return
     *     returns java.util.List<it.polito.dp2.WF.sol4.jaxws.WorkflowType>
     * @throws UnknownWorkflow
     */
    @WebMethod
    @WebResult(name = "Workflow", targetNamespace = "")
    @RequestWrapper(localName = "getWorkflows", targetNamespace = "http://www.example.org/Workflow", className = "it.polito.dp2.WF.sol4.jaxws.GetWorkflowsType")
    @ResponseWrapper(localName = "getWorkflowsResponse", targetNamespace = "http://www.example.org/Workflow", className = "it.polito.dp2.WF.sol4.jaxws.GetWorkflowsResponseType")
    public List<WorkflowType> getWorkflows(
        @WebParam(name = "wfName", targetNamespace = "")
        List<String> wfName)
        throws UnknownWorkflow
    ;

    /**
     * 
     * @param page
     * @return
     *     returns java.util.List<it.polito.dp2.WF.sol4.jaxws.InfoType>
     */
    @WebMethod
    @WebResult(name = "workflowName", targetNamespace = "")
    @RequestWrapper(localName = "getWorkflowNames", targetNamespace = "http://www.example.org/Workflow", className = "it.polito.dp2.WF.sol4.jaxws.GetWorkflowNamesType")
    @ResponseWrapper(localName = "getWorkflowNamesResponse", targetNamespace = "http://www.example.org/Workflow", className = "it.polito.dp2.WF.sol4.jaxws.GetWorkflowNamesResponseType")
    public List<InfoType> getWorkflowNames(
        @WebParam(name = "page", targetNamespace = "")
        int page);

    /**
     * 
     * @param info
     * @return
     *     returns java.util.List<it.polito.dp2.WF.sol4.jaxws.InstanceType>
     * @throws UnknownInstance
     */
    @WebMethod
    @WebResult(name = "Instance", targetNamespace = "")
    @RequestWrapper(localName = "getProcesses", targetNamespace = "http://www.example.org/Workflow", className = "it.polito.dp2.WF.sol4.jaxws.GetProcessesType")
    @ResponseWrapper(localName = "getProcessesResponse", targetNamespace = "http://www.example.org/Workflow", className = "it.polito.dp2.WF.sol4.jaxws.GetProcessesResponseType")
    public List<InstanceType> getProcesses(
        @WebParam(name = "info", targetNamespace = "")
        List<InfoType> info)
        throws UnknownInstance
    ;

    /**
     * 
     * @param page
     * @return
     *     returns java.util.List<it.polito.dp2.WF.sol4.jaxws.GetProcessesInfoResponseType.InstanceInfo>
     */
    @WebMethod
    @WebResult(name = "InstanceInfo", targetNamespace = "")
    @RequestWrapper(localName = "getProcessesInfo", targetNamespace = "http://www.example.org/Workflow", className = "it.polito.dp2.WF.sol4.jaxws.GetProcessesInfoType")
    @ResponseWrapper(localName = "getProcessesInfoResponse", targetNamespace = "http://www.example.org/Workflow", className = "it.polito.dp2.WF.sol4.jaxws.GetProcessesInfoResponseType")
    public List<it.polito.dp2.WF.sol4.jaxws.GetProcessesInfoResponseType.InstanceInfo> getProcessesInfo(
        @WebParam(name = "page", targetNamespace = "")
        int page);

}
