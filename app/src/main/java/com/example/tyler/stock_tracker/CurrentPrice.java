package com.example.tyler.stock_tracker;

/**
 * Created by jordan on 8/11/17.
 */

public class CurrentPrice {


    // This is what the response from the server looks like.
    private String sampleJson = "" +
            "{\n" +
            "time: {\n" +
            "updated: \"Aug 11, 2017 17:06:00 UTC\",\n" +
            "updatedISO: \"2017-08-11T17:06:00+00:00\",\n" +
            "updateduk: \"Aug 11, 2017 at 18:06 BST\"\n" +
            "},\n" +
            "disclaimer: \"This data was produced from the CoinDesk Bitcoin Price Index (USD). Non-USD currency data converted using hourly conversion rate from openexchangerates.org\",\n" +
            "bpi: {\n" +
            "USD: {\n" +
            "code: \"USD\",\n" +
            "rate: \"3,548.2050\",\n" +
            "description: \"United States Dollar\",\n" +
            "rate_float: 3548.205\n" +
            "}\n" +
            "}\n" +
            "}";


    // You will need to define here in java:
    // a Time object
    // disclaimer property of type string
    // bpi object


    // the time object has 3 string properties

    // the bpi object has an object called USD
    // USD has 4 properties, 3 string, 1 double




    // make sure you have getters for each of these objects and properties.




    // after you do that google jsonschema2pojo
}
