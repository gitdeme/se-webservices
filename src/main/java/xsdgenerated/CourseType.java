
package xsdgenerated;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CourseType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CourseType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="courseCode" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="title" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="ects" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CourseType", namespace = "http://example.com/course", propOrder = {
    "courseCode",
    "title",
    "ects"
})
public class CourseType {

    @XmlElement(namespace = "http://example.com/course", required = true)
    protected String courseCode;
    @XmlElement(namespace = "http://example.com/course", required = true)
    protected String title;
    @XmlElement(namespace = "http://example.com/course")
    protected int ects;

    /**
     * Gets the value of the courseCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCourseCode() {
        return courseCode;
    }

    /**
     * Sets the value of the courseCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCourseCode(String value) {
        this.courseCode = value;
    }

    /**
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * Gets the value of the ects property.
     * 
     */
    public int getEcts() {
        return ects;
    }

    /**
     * Sets the value of the ects property.
     * 
     */
    public void setEcts(int value) {
        this.ects = value;
    }

}
