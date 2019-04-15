package models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item {
    @Expose
    @SerializedName("number")
    private Integer number;


    @Expose
    @SerializedName("price")
    private Integer price;


    @Expose
    @SerializedName("_id")
    private String _id;


    @Expose
    @SerializedName("name")
    private String name;

    @Expose
    @SerializedName("type")
    private String type;


    @Expose
    @SerializedName("branch")
    private Integer branch;

    public  Item() {

    }

    public Item(Integer number, Integer price, String _id, String name, String type, Integer branch) {
        this.number = number;
        this.price = price;
        this._id = _id;
        this.name = name;
        this.type = type;
        this.branch = branch;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getBranch() {
        return branch;
    }

    public void setBranch(Integer branch) {
        this.branch = branch;
    }
}
