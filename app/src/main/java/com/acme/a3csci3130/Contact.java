package com.acme.a3csci3130;

import com.google.firebase.database.Exclude;


import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Class that defines how the data will be stored in the
 * Firebase databse. This is converted to a JSON format
 */
public class Contact implements Serializable {

    /**
     * The Uid.
     */
    public  String uid;
    /**
     * The Name.
     */
    public  String name;
    /**
     * The Address.
     */
    public  String address, /**
     * The Province.
     */
    province, /**
     * The Primary.
     */
    primary, /**
     * The Number.
     */
    number;

    /**
     * Instantiates a new Contact.
     */
    public Contact(){

    }

    /**
     * Contact method to contact the information and person
     * Shengnan
     *
     * @param uid      the uid
     * @param name     the name
     * @param number   the number
     * @param primary  the primary
     * @param address  the address
     * @param province the province
     */
    public Contact(String uid, String name, String number, String primary, String address, String province) {
        this.uid=uid;
        this.number=number;
        this.name=name;
        this.primary=primary;
        this.address=address;
        this.province=province;


    }

    /**
     * To map map.
     *
     * @return the map
     */
    @Exclude
    public Map<String, Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("uid", uid);
        result.put("name", name);
        result.put("number",number);
        result.put("primary",primary);
        result.put("address",address);
        result.put("province",province);
        return result;
    }
}
