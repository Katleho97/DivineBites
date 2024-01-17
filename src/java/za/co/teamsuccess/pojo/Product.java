package za.co.teamsuccess.pojo;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author student17
 */
public class Product implements Serializable {

    private int categoryid;
    private int productid;
    private String name;
    private String description;
    private Date dateadded;
    private int price;
    private String allergies;
    private String dietary;
    private String ingredients;
    private String picture;
    private int active;

    public Product(String name, int price, String description, String allergies, String dietary, String ingredients, int categoryid, int productid) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.allergies = allergies;
        this.dietary = dietary;
        this.categoryid = categoryid;
        this.productid = productid;
        this.ingredients = ingredients;
    }

    public Product() {
    }

    public Product(String name, int price, String description, String allergies, String dietary, int categoryid, int productid, String ingredients, String picture, int active) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.allergies = allergies;
        this.dietary = dietary;
        this.categoryid = categoryid;
        this.productid = productid;
        this.ingredients = ingredients;
        this.picture = picture;
        this.active = active;
    }

    public Product(int categoryid, int productid, String name, String description, int price, String allergies, String dietary, String ingredients, int active) {
        this.categoryid = categoryid;
        this.productid = productid;
        this.name = name;
        this.description = description;
        this.price = price;
        this.allergies = allergies;
        this.dietary = dietary;
        this.ingredients = ingredients;
        this.active = active;
    }

    public Product(int categoryid, int productid, String name, String description, Date dateadded, int price, String allergies, String dietary, String ingredients, int active) {
        this.categoryid = categoryid;
        this.productid = productid;
        this.name = name;
        this.description = description;
        this.dateadded = dateadded;
        this.price = price;
        this.allergies = allergies;
        this.dietary = dietary;
        this.ingredients = ingredients;
        this.active = active;
    }

    public Product(int productid, int categoryid, String name, String desc, Date dateadded, String allergies, String dietary, int price, String ingredients, int active) {
        this.categoryid = categoryid;
        this.productid = productid;
        this.name = name;
        this.dateadded = dateadded;
        this.price = price;
        this.allergies = allergies;
        this.dietary = dietary;
        this.ingredients = ingredients;
        this.active = active;
    }

    public Product(int productid, int categoryid, String name, String desc, Date dateadded, String allergies, String dietary, int price, String ingredients) {
        this.categoryid = categoryid;
        this.productid = productid;
        this.name = name;
        this.dateadded = dateadded;
        this.price = price;
        this.allergies = allergies;
        this.dietary = dietary;
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public String getDietary() {
        return dietary;
    }

    public void setDietary(String dietary) {
        this.dietary = dietary;
    }

    public int getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(int categoryid) {
        this.categoryid = categoryid;
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.name);
        hash = 79 * hash + this.productid;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Product other = (Product) obj;
        return Objects.equals(this.name, other.name);
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "Product{" + "name=" + name + ", price=" + price + ", description=" + description + ", allergies=" + allergies + ", dietary=" + dietary + ", categoryid=" + categoryid + ", productid=" + productid + ", ingredients=" + ingredients + ", picture=" + picture + ", active=" + active + '}';
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

}
