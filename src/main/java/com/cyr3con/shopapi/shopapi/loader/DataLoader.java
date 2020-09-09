package com.cyr3con.shopapi.shopapi.loader;


import com.cyr3con.shopapi.shopapi.entity.CatalogComponent;
import com.cyr3con.shopapi.shopapi.entity.Category;
import com.cyr3con.shopapi.shopapi.entity.Product;
import com.cyr3con.shopapi.shopapi.entity.ProductCatalog;
import com.cyr3con.shopapi.shopapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


@Component
public class DataLoader implements ApplicationRunner {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    public DataLoader(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * Populate dummy data to product database when the application is ready. You can also use @ApplicationReadyEvent . . .
     *
     * @param args unused
     */
    public void run(ApplicationArguments args) {
        initProduct();
    }

    /**
     * <p>Populate and save a dummy data to the database. . .
     * Used composite Design Pattern
     * </p>
     */
    public void initProduct() {
        //Create Apple Catalog
        CatalogComponent apple = new ProductCatalog("Apple Products");
        //Create Primary Catalog
        CatalogComponent mainCatalog = new ProductCatalog("Primary Catalog");

        /*
         * Create apple Products
         * */
        CatalogComponent iphone = new Product(null, "iPhone 11 Pro", 1000.0, 2000, "Triple-camera system (Ultra Wide, Wide, Telephoto)" +
                "Up to 20 hours of video playback1" +
                "Water resistant to a depth of 4 meters for up to 30 minutes2" +
                "5.8” or 6.5” Super Retina XDR display3", new Category(1, "mobile", "A mobile phone, cellular phone, cell phone, cellphone or hand phone, sometimes shortened to simply mobile, cell or just phone, is a portable telephone that can make and receive calls over a radio..."));

        CatalogComponent mac = new Product(null, "iMac", 2000.0, 2000, "21.5‑inch iMac" +
                "Starting at $2000" +
                "Up to 21.5 Retina 4K display " +
                "Up to 6-core Intel Core i7 processor" +
                "Up to 32GB memory" +
                "Up to 1TB SSD storage" +
                "Up to Radeon Pro Vega 20 with 4GB of HBM2 memory", new Category(2, "Laptop", " is a small, portable personal computer with a clamshell form factor, typically having a thin LCD or LED computer screen"));

        //add apple products to Apple catalog
        apple.add(iphone);
        apple.add(mac);

        //add Apple catalog to Primary Catalog
        mainCatalog.add(apple);

        //Save products to the database
        productRepository.addProduct((Product) iphone);
        productRepository.addProduct((Product) mac);
    }
}