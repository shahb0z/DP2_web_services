
package it.polito.dp2.WF.sol4.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for statusInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="statusInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="instanceOf" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="actor" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="role" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="instanceInfo" type="{http://www.example.org/Workflow}infoType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "statusInfo", propOrder = {
    "instanceOf",
    "actor",
    "role",
    "instanceInfo"
})
public class StatusInfo {

    @XmlElement(required = true)
    protected String instanceOf;
    @XmlElement(required = true)
    protected String actor;
    @XmlElement(required = true)
    protected String role;
    @XmlElement(required = true)
    protected InfoType instanceInfo;

    /**
     * Gets the value of the instanceOf property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInstanceOf() {
        return instanceOf;
    }

    /**
     * Sets the value of the instanceOf property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInstanceOf(String value) {
        this.instanceOf = value;
    }

    /**
     * Gets the value of the actor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActor() {
        return actor;
    }

    /**
     * Sets the value of the actor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActor(String value) {
        this.actor = value;
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
     * Gets the value of the instanceInfo property.
     * 
     * @return
     *     possible object is
     *     {@link InfoType }
     *     
     */
    public InfoType getInstanceInfo() {
        return instanceInfo;
    }

    /**
     * Sets the value of the instanceInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link InfoType }
     *     
     */
    public void setInstanceInfo(InfoType value) {
        this.instanceInfo = value;
    }

}
