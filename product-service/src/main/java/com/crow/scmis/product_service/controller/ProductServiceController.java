package com.crow.scmis.product_service.controller;

import com.crow.scmis.product_service.entity.Category;
import com.crow.scmis.product_service.entity.Product;
import com.crow.scmis.product_service.service.ICategoryService;
import com.crow.scmis.product_service.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/product")
public class ProductServiceController {
    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private IProductService productService;

    private final Path fileStorageLocation = Paths.get("C:\\uploads");

    @PostMapping("/category")
    public ResponseEntity<Category> createCategory(@RequestBody Category category){
        return new ResponseEntity<>(categoryService.create(category), HttpStatus.CREATED);
    }

    @GetMapping("/categories")
    public ResponseEntity<List<Category>> getAllCategories(){
        return new ResponseEntity<>(categoryService.getAll(),HttpStatus.OK);
    }

    @PostMapping("/product")
    public ResponseEntity<Product> create(@RequestBody Product product){
        System.out.println(product.getName());
        return new ResponseEntity<>(productService.create(product), HttpStatus.CREATED);
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAll(){
        return new ResponseEntity<>(productService.getAll(),HttpStatus.OK);
    }

    @PostMapping("/product-image")
    public ResponseEntity<Map<String, String>> handleFileUploadUsingCurl( @RequestParam("file") MultipartFile file) throws IOException {
        String filePath = System.getProperty("user.dir") + "/uploads" + File.separator + file.getOriginalFilename();
        String fileUploadStatus;

        // Try block to check exceptions
        try {

            // Creating an object of FileOutputStream class
            FileOutputStream fout = new FileOutputStream(filePath);
            fout.write(file.getBytes());

            // Closing the connection
            fout.close();
            fileUploadStatus = "File Uploaded Successfully";

        }
        // Catch block to handle exceptions
        catch (Exception e) {
            e.printStackTrace();
            fileUploadStatus =  "Error in uploading file: " + e;
        }

        Map<String, String> map = new HashMap<>();
        // Populate the map with file details
        map.put("fileName", file.getOriginalFilename());
        map.put("fileSize", file.getSize()+"");
        map.put("fileContentType", file.getContentType());
        // File upload is successful
        map.put("message", "File upload done");
        map.put("path",filePath);
        map.put("url",ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/uploads/")
                .path(this.fileStorageLocation.resolve(file.getOriginalFilename()).normalize().normalize().toString())
                .toUriString());
        return ResponseEntity.ok(map);
    }

    @GetMapping("/download/{filename:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String filename) {
        try {
            Path filePath = this.fileStorageLocation.resolve(filename).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if (resource.exists() || resource.isReadable()) {
                return ResponseEntity.ok().body(resource);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }



}
