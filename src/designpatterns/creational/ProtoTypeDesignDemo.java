package designpatterns.creational;

import java.util.*;

interface ProductInterface {
    TshirtProduct cloneProduct();
}

class TshirtProduct implements ProductInterface {
    private String color;
    private String size;
    private List<String> tags;

    public TshirtProduct(String color, String size, List<String> tags) {
        this.color = color;
        this.size = size;
        this.tags = tags;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = new ArrayList<>(tags);
    }

    @Override
    public String toString() {
        return "TshirtProduct{" +
                "color='" + color + '\'' +
                ", size='" + size + '\'' +
                ", tags=" + tags +
                '}';
    }

    @Override
    public TshirtProduct cloneProduct() {
        return new TshirtProduct(color, size, tags);
    }
}

class MyntraProductRegistry {
    private Map<String, Object> productMap;

    public MyntraProductRegistry() {
        this.productMap = new HashMap<>();
    }

    public void registerProduct(String productKey, Object product) {
        productMap.put(productKey, product);
    }

    public TshirtProduct getProdcut(String prodcutKey) {
        TshirtProduct product = (TshirtProduct) productMap.get(prodcutKey);
        if(product == null) {
           throw new RuntimeException("Product is not found wth key:" +prodcutKey);
        }
        return product.cloneProduct();
    }
}

public class ProtoTypeDesignDemo {

    public static void main(String args[]) {
        List<String> tags = new ArrayList<>();
        tags.add("stripes");

        TshirtProduct baseTshirt = new TshirtProduct("Red", "M", tags);
        MyntraProductRegistry registry = new MyntraProductRegistry();
        registry.registerProduct("Tshirt", baseTshirt);
        System.out.println(baseTshirt.getTags());

        //customers demanded to sell Large tshirt with different colors with same stripes
        TshirtProduct clonenedProduct = registry.getProdcut("Tshirt");
        clonenedProduct.setColor("Blue");
        clonenedProduct.setSize("L");
        System.out.println(clonenedProduct.getTags());

    }
}
