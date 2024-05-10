package com.amehirs.store.model;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Setter
@Getter
public class ProductDto {
    @NotEmpty(message = "The name is Required")
    private String name;

    @NotEmpty(message = "The brand is required")
    private String brand;

    @NotEmpty(message="Category is required")
    private String category;

    @Min(0) //0 is positive number
    private double price;

    @Size(min = 10,message = "The description should be at least 10 characters")
    @Size (max = 2000,message = "The description cannot exceed 2000 characters")
    private String description;

    private MultipartFile imageFile;
}
