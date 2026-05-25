package co.com.udea.moduloprueba.models;

import java.util.List;

public final class Product {

    public static final String BACKPACK = "Sauce Labs Backpack";
    public static final String BIKE_LIGHT = "Sauce Labs Bike Light";
    public static final String BOLT_SHIRT = "Sauce Labs Bolt T-Shirt";
    public static final String FLEECE_JACKET = "Sauce Labs Fleece Jacket";
    public static final String ONESIE = "Sauce Labs Onesie";
    public static final String RED_T_SHIRT = "Test.allTheThings() T-Shirt (Red)";

    private final String name;
    private final double price;

    private Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public static Product of(String name, double price) {
        return new Product(name, price);
    }

    public static List<Product> catalog() {
        return List.of(
                of(BACKPACK, 29.99),
                of(BIKE_LIGHT, 9.99),
                of(BOLT_SHIRT, 15.99),
                of(FLEECE_JACKET, 49.99),
                of(ONESIE, 7.99),
                of(RED_T_SHIRT, 15.99)
        );
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String addButtonSelector() {
        return "#add-to-cart-" + toSlug(name);
    }

    public String removeButtonSelector() {
        return "#remove-" + toSlug(name);
    }

    public static String toSlug(String productName) {
        return productName.toLowerCase()
                .replace(" ", "-")
                .replace("(", "")
                .replace(")", "")
                .replace("'", "")
                .replace(".", "")
                .replace("é", "e");
    }

    private Product() {
        throw new UnsupportedOperationException("Utility class");
    }
}