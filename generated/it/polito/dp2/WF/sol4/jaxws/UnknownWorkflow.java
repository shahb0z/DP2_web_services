
package it.polito.dp2.WF.sol4.jaxws;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "UnknownWorkflow", targetNamespace = "http://www.example.org/Workflow")
public class UnknownWorkflow
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private UnknownWorkflowType faultInfo;

    /**
     * 
     * @param message
     * @param faultInfo
     */
    public UnknownWorkflow(String message, UnknownWorkflowType faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param message
     * @param faultInfo
     * @param cause
     */
    public UnknownWorkflow(String message, UnknownWorkflowType faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: it.polito.dp2.WF.sol4.jaxws.UnknownWorkflowType
     */
    public UnknownWorkflowType getFaultInfo() {
        return faultInfo;
    }

}
