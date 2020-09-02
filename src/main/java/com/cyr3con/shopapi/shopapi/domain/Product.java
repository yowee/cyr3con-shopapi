package com.cyr3con.shopapi.shopapi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import java.beans.Transient;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Product implements Serializable {

    private Integer id;
    @NotBlank
    private String name;
    @NotNull
    private Double price;
    @NotNull
    private Integer stock;
    @NotBlank
    private String description;
    @NotNull
    private Category category;
}
