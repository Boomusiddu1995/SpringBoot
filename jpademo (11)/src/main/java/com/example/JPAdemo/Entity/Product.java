package com.example.JPAdemo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Product {
    @Id
    private int id;
    private String prod_name;
    private String prod_model;
    private String status;

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProd_name() {
        return prod_name;
    }

    public void setProd_name(String prod_name) {
        this.prod_name = prod_name;
    }

    public String getProd_model() {
        return prod_model;
    }

    public void setProd_model(String prod_model) {
        this.prod_model = prod_model;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", prod_name='" + prod_name + '\'' +
                ", prod_model='" + prod_model + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
