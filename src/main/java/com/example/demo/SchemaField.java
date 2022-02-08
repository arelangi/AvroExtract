package com.example.demo;

public class SchemaField {
    private String name;
    private String type;
    private String doc;

    public SchemaField(String name, String type, String doc) {
        this.name = name;
        this.type = type;
        this.doc = doc;
    }

    @Override
    public String toString() {
        return "SchemaField{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", doc='" + doc + '\'' +
                '}';
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

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc;
    }
}
