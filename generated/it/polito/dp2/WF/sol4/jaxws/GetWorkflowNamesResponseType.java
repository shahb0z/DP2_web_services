
package it.polito.dp2.WF.sol4.jaxws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 			This type represents request for workflow names.
 * 			It is a list of workflow names. This data is used for 
 * 			requesting workflows.		
 * 		
 * 
 * <p>Java class for getWorkflowNamesResponseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getWorkflowNamesResponseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="workflowName" type="{http://www.example.org/Workflow}infoType" maxOccurs="40" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getWorkflowNamesResponseType", propOrder = {
    "workflowName"
})
public class GetWorkflowNamesResponseType {

    protected List<InfoType> workflowName;

    /**
     * Gets the value of the workflowName property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the workflowName property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWorkflowName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InfoType }
     * 
     * 
     */
    public List<InfoType> getWorkflowName() {
        if (workflowName == null) {
            workflowName = new ArrayList<InfoType>();
        }
        return this.workflowName;
    }

}
