
package xsdgenerated;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="course" type="{http://example.com/course}CourseType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "course"
})
@XmlRootElement(name = "CreateCourseRequest", namespace = "http://example.com/course")
public class CreateCourseRequest {

    @XmlElement(namespace = "http://example.com/course", required = true)
    protected CourseType course;

    /**
     * Gets the value of the course property.
     * 
     * @return
     *     possible object is
     *     {@link CourseType }
     *     
     */
    public CourseType getCourse() {
        return course;
    }

    /**
     * Sets the value of the course property.
     * 
     * @param value
     *     allowed object is
     *     {@link CourseType }
     *     
     */
    public void setCourse(CourseType value) {
        this.course = value;
    }

}
