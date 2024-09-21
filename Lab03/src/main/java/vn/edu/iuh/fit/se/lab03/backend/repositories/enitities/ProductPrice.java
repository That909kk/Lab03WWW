package vn.edu.iuh.fit.se.lab03.backend.repositories.enitities;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "product_price")
public class ProductPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "price_id", nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id", insertable = false, updatable = false)
    private Product product;


    @Column(name = "product_id", nullable = false)
    private Integer productId;

    @Column(name = "apply_date", nullable = false)
    private Instant applyDate;

    @Column(name = "value", nullable = false)
    private Double value;

    @Lob
    @Column(name = "note")
    private String note;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Instant getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Instant applyDate) {
        this.applyDate = applyDate;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public ProductPrice(Integer id, Product product, Integer productId, Instant applyDate, Double value, String note) {
        this.id = id;
        this.product = product;
        this.productId = productId;
        this.applyDate = applyDate;
        this.value = value;
        this.note = note;
    }

    public ProductPrice() {
    }

    public ProductPrice(Product product, Integer productId, Instant applyDate, Double value, String note) {
        this.product = product;
        this.productId = productId;
        this.applyDate = applyDate;
        this.value = value;
        this.note = note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductPrice that = (ProductPrice) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ProductPrice{" +
                "id=" + id +
                ", product=" + product +
                ", productId=" + productId +
                ", applyDate=" + applyDate +
                ", value=" + value +
                ", note='" + note + '\'' +
                '}';
    }
}