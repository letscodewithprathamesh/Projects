package com.test.ecom_proj.controller;

import com.test.ecom_proj.model.Products;
import com.test.ecom_proj.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class ProductController
{
    @Autowired
    private ProductsService service; //Setter Injection

    @RequestMapping("/")
    public String greet()
    {
        return "Welcome to Spring Boot";
    }

    @GetMapping("/products")
    public ResponseEntity<List<Products>> getAllproducts()
    {
        return new ResponseEntity<>(service.getAllproducts(), HttpStatus.OK);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Products> getproductsById(@PathVariable int id)
    {
        Products product=service.getProductsById(id);

        if(product!=null)
        {
            return new ResponseEntity<>(product,HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/product")
    public ResponseEntity<?> addProduct(@RequestPart Products product,@RequestPart MultipartFile imageFile)
    {
        try
        {
            Products product1=service.addProduct(product,imageFile);

            return new ResponseEntity<>(product1,HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/product/{productId}/image")
    public ResponseEntity<byte[]> getProductById(@PathVariable int productId)
    {
        Products product=service.getProductsById(productId);

        if (product == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        byte[] imageFile=product.getImageData();

        return ResponseEntity.ok().contentType(MediaType.valueOf(product.getImageType())).body(imageFile);
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<String> updateProductById(@PathVariable int id,@RequestPart Products product,@RequestPart MultipartFile imageFile)
    {
        try {
            Products updatedProduct = service.updateProductById(id, product, imageFile);
            if (updatedProduct != null) {
                return new ResponseEntity<>("Updated", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Failed to Update", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to Update", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable int id)
    {
        Products product= service.getProductsById(id);

        if(product !=null)
        {
            service.deleteProductById(id);
            return new ResponseEntity<>("Deleted",HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>("Not Found",HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/products/search")
    public ResponseEntity<List<Products>> searchProducts(@RequestParam String keyword)
    {
        System.out.println("Searching with "+keyword);
       List<Products> product= service.searchProducts(keyword);

       return new ResponseEntity<>(product,HttpStatus.OK);
    }


}
