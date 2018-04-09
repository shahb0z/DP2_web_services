
package it.polito.dp2.WF.sol4.jaxws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 		This type represents request for workflows.
 * 		Here you should provide list of workflow names.
 * 		List size can maximum 20, because of performance issues.		
 * 	
 * 
 * <p>Java class for getWorkflowsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getWorkflowsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="wfName" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="20"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getWorkflowsType", propOrder = {
    "wfName"
})
public class GetWorkflowsType {

    @XmlElement(required = true)
    protected List<String> wfName;

    /**
     * Gets the value of the wfName property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the wfName property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWfName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getWfName() {
        if (wfName == null) {
            wfName = new ArrayList<String>();
        }
        return this.wfName;
    }

}
