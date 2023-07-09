package designpatterns.creational;

import java.math.BigDecimal;

class Product {
    private int id;
    private String productName;
    private boolean isAvailable;
    private BigDecimal price;
    private int quantity;
    private String modelType;

    private Product(ProductBuilder productBuilder) {
        this.id=productBuilder.id;
        this.productName = productBuilder.productName;
        this.modelType= productBuilder.modelType;
        this.isAvailable = productBuilder.isAvailable;
        this.quantity = productBuilder.quantity;
        this.price = productBuilder.price;

    }

    public int getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getModelType() {
        return modelType;
    }

    public static class ProductBuilder {

        private int id;
        private String productName;
        private boolean isAvailable;
        private BigDecimal price;
        private int quantity;
        private String modelType;

        public ProductBuilder setId(int id) {
            if(this.id != 0) {
                throw new RuntimeException("Id already taken");
            }
            this.id = id;
            return this;
        }

        public ProductBuilder setProductName(String productName) {
            this.productName = productName;
            return this;
        }

        public ProductBuilder setAvailable(boolean available) {
            this.isAvailable = available;
            return this;
        }

        public ProductBuilder setPrice(BigDecimal price) {
            this.price = price;
            return this;
        }

        public ProductBuilder setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public ProductBuilder setModelType(String modelType) {
            if(this.modelType != null) {
                throw new RuntimeException("ModelType taken");
            }
            this.modelType = modelType;
            return this;
        }

        public Product build() {
            return new Product(this);
        }
    }
}



public class BuilderDesignPatternDemo {
    public static void main(String args[]) {
        Product p = new Product.ProductBuilder()
                .setId(2223)
                .setAvailable(true)
                .setModelType("Ihone13")
                .setProductName("Ihone")
                .setPrice(BigDecimal.valueOf(60000.00))
                .setQuantity(1)
                .build();

        System.out.println(p.getId());
        System.out.println(p.getProductName());
        System.out.println(p.isAvailable());
    }
}
