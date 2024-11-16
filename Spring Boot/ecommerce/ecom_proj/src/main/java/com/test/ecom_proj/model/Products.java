package com.test.ecom_proj.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@AllArgsConstructor //its Lombok annotations
@NoArgsConstructor
@Entity
public class Products
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private String brand;
    private Long price;
    private String category;
    private Date releaseDate;
    @Column(name = "productAvailable")
    private boolean productAvailable;
    @Column(name = "stockQuantity")
    private int stockQuantity;



    private String imageName;
    private String imageType;

    public String getImageName() {
        return imageName;
    }

    public String getImageType() {
        return imageType;
    }

    public byte[] getImageData() {
        return imageData;
    }

    @Lob
    private byte[] imageData;

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}
