package com.shawn.ss.gen.api.model.data_source_conf;


import java.util.Properties;

public class ModelCommonDbConnectionConfig {
    String url;
    String user;
    String password;
    String name;
    boolean master=true;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isMaster() {
        return master;
    }

    public void setMaster(boolean master) {
        this.master = master;
    }

    //    public String getUrl() {
//        return url;
//    }
//
//    public ModelCommonDbConnectionConfig setUrl(String url) {
//        this.url = url;
//        return this;
//    }
//
//    public String getUser() {
//        return user;
//    }
//
//    public ModelCommonDbConnectionConfig setUser(String user) {
//        this.user = user;
//        return this;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public ModelCommonDbConnectionConfig setPassword(String password) {
//        this.password = password;
//        return this;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public ModelCommonDbConnectionConfig setName(String name) {
//        this.name = name;
//        return this;
//    }
//
//    public boolean isMaster() {
//        return master;
//    }
//
//    public ModelCommonDbConnectionConfig setMaster(boolean master) {
//        this.master = master;
//        return this;
//    }

    public Properties toProperties(){
        Properties properties=new Properties();

        properties.setProperty("user",this.getUser());
        properties.setProperty("url",this.getUrl());
        properties.setProperty("password",this.getPassword());
//        properties.setProperty("user",this.getUser());
        return properties;
    }
}
