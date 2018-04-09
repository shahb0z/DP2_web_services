
package it.polito.dp2.WF.sol4.jaxws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ActionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ActionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="role" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="isAutomaticallyInstantiated" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;choice>
 *           &lt;element name="NextPossibleAction" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *           &lt;element name="actionWorkflow" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ActionType", propOrder = {
    "name",
    "role",
    "isAutomaticallyInstantiated",
    "nextPossibleAction",
    "actionWorkflow"
})
public class ActionType {

    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected String role;
    @XmlElement(defaultValue = "false")
    protected boolean isAutomaticallyInstantiated;
    @XmlElement(name = "NextPossibleAction")
    protected List<String> nextPossibleAction;
    protected String actionWorkflow;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the role property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRole() {
        return role;
    }

    /**
     * Sets the value of the role property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRole(String value) {
        this.role = value;
    }

    /**
     * Gets the value of the isAutomaticallyInstantiated property.
     * 
     */
    public boolean isIsAutomaticallyInstantiated() {
        return isAutomaticallyInstantiated;
    }

    /**
     * Sets the value of the isAutomaticallyInstantiated property.
     * 
     */
    public void setIsAutomaticallyInstantiated(boolean value) {
        this.isAutomaticallyInstantiated = value;
    }

    /**
     * Gets the value of the nextPossibleAction property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nextPossibleAction property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNextPossibleAction().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getNextPossibleAction() {
        if (nextPossibleAction == null) {
            nextPossibleAction = new ArrayList<String>();
        }
        return this.nextPossibleAction;
    }

    /**
     * Gets the value of the actionWorkflow property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActionWorkflow() {
        return actionWorkflow;
    }

    /**
     * Sets the value of the actionWorkflow property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActionWorkflow(String value) {
        this.actionWorkflow = value;
    }

}
