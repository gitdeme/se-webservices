package org.wldu.webservices.enities;


import jakarta.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "categories")
public class CategoriesEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cat_id")
    private long catId;
    @Column(name = "cat_name", nullable = false)
    private String catName;

    @Column(name = "description")
    private String description;

    public CategoriesEntity() {
    }

    public CategoriesEntity(String catName, String description) {
        this.catName = catName;
        this.description = description;
    }


    public long getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public String getDescription() {
        return description;
    }


}