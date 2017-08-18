package com.example.tyler.stock_tracker;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CurrentPrice {

    @SerializedName("time")
    @Expose
    private Time time;
    @SerializedName("disclaimer")
    @Expose
    private String disclaimer;
    @SerializedName("bpi")
    @Expose
    private Bpi bpi;

    /**
     * No args constructor for use in serialization
     *
     */
    public CurrentPrice() {
    }

    /**
     *
     * @param time
     * @param disclaimer
     * @param bpi
     */
    public CurrentPrice(Time time, String disclaimer, Bpi bpi) {
        super();
        this.time = time;
        this.disclaimer = disclaimer;
        this.bpi = bpi;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getDisclaimer() {
        return disclaimer;
    }

    public void setDisclaimer(String disclaimer) {
        this.disclaimer = disclaimer;
    }

    public Bpi getBpi() {
        return bpi;
    }

    public void setBpi(Bpi bpi) {
        this.bpi = bpi;
    }



    public class Bpi {

        @SerializedName("USD")
        @Expose
        private USD uSD;

        /**
         * No args constructor for use in serialization
         *
         */
        public Bpi() {
        }

        /**
         *
         * @param uSD
         */
        public Bpi(USD uSD) {
            super();
            this.uSD = uSD;
        }

        public USD getUSD() {
            return uSD;
        }

        public void setUSD(USD uSD) {
            this.uSD = uSD;
        }

    }

    public class Time {

        @SerializedName("updated")
        @Expose
        private String updated;
        @SerializedName("updatedISO")
        @Expose
        private String updatedISO;
        @SerializedName("updateduk")
        @Expose
        private String updateduk;

        /**
         * No args constructor for use in serialization
         */
        public Time() {
        }

        /**
         * @param updatedISO
         * @param updated
         * @param updateduk
         */
        public Time(String updated, String updatedISO, String updateduk) {
            super();
            this.updated = updated;
            this.updatedISO = updatedISO;
            this.updateduk = updateduk;
        }

        public String getUpdated() {
            return updated;
        }

        public void setUpdated(String updated) {
            this.updated = updated;
        }

        public String getUpdatedISO() {
            return updatedISO;
        }

        public void setUpdatedISO(String updatedISO) {
            this.updatedISO = updatedISO;
        }

        public String getUpdateduk() {
            return updateduk;
        }

        public void setUpdateduk(String updateduk) {
            this.updateduk = updateduk;
        }

    }

    public class USD {

        @SerializedName("code")
        @Expose
        private String code;
        @SerializedName("rate")
        @Expose
        private String rate;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("rate_float")
        @Expose
        private Double rateFloat;

        /**
         * No args constructor for use in serialization
         *
         */
        public USD() {
        }

        /**
         *
         * @param rateFloat
         * @param rate
         * @param description
         * @param code
         */
        public USD(String code, String rate, String description, Double rateFloat) {
            super();
            this.code = code;
            this.rate = rate;
            this.description = description;
            this.rateFloat = rateFloat;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getRate() {
            return rate;
        }

        public void setRate(String rate) {
            this.rate = rate;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Double getRateFloat() {
            return rateFloat;
        }

        public void setRateFloat(Double rateFloat) {
            this.rateFloat = rateFloat;
        }

    }

}
