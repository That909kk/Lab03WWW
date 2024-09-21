package vn.edu.iuh.fit.se.lab03.backend.repositories.enitities;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 150)
    private String name;

    @Lob
    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "img_path", length = 250)
    private String imgPath;

    @OneToMany(mappedBy = "product")
    private Set<ProductPrice> productPrices;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public Product(Integer id, String name, String description, String imgPath, Set<ProductPrice> productPrices) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imgPath = imgPath;
        this.productPrices = productPrices;
    }

    public Product() {
    }

    public Product(String name, String description, String imgPath, Set<ProductPrice> productPrices) {

        this.name = name;
        this.description = description;
        this.imgPath = imgPath;
        this.productPrices = productPrices;
    }

    public Set<ProductPrice> getProductPrices() {
        return productPrices;
    }

    public void setProductPrices(Set<ProductPrice> productPrices) {
        this.productPrices = productPrices;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", imgPath='" + imgPath + '\'' +
                ", productPrices=" + productPrices +
                '}';
    }
}