package com.shop.novelbooking;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.io.File;


import com.google.common.base.Charsets;
import com.google.common.collect.Maps;
import com.google.common.io.Resources;
import com.google.common.io.Files;

import com.hubspot.jinjava.Jinjava;
import com.hubspot.jinjava.JinjavaConfig;
import com.hubspot.jinjava.loader.FileLocator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class Utility {
    public static void main(String[] args) throws Exception{
        System.out.println("***Start utility***");

        templateToFile();
        readXmlFile();

        System.out.println("***End utility***");
    }


    static void templateToFile() throws Exception{
        //https://github.com/HubSpot/jinjava
        // https://howtodoinjava.com/java/io/java-read-file-to-string-examples/#6-google-guava
        JinjavaConfig config = new JinjavaConfig();
        Jinjava jinjava = new Jinjava(config);

        Map<String, Object> context = Maps.newHashMap();
        context.put("name", "Jared");

        // String template = Resources.toString(Resources.getResource("my-template.html"), Charsets.UTF_8);
        // String renderedTemplate = jinjava.render(template, context);
        
        String dir = "C:\\workspace\\wso2\\apictl\\apictl-4.0.1-windows-x64\\apictl\\draft\\apictl.init.api\\";
        String filePath ="C:\\workspace\\wso2\\apictl\\apictl-4.0.1-windows-x64\\apictl\\draft\\apictl.init.api\\api.yaml";
        
        File templateFile = new File(filePath);
        // File templateDir = new File(dir);
        // String templateString = templateFile.toString();

        // FileLocator fl =  new FileLocator(templateDir);
        // jinjava.setResourceLocator(fl);

        // String content = com.google.common.io.Files.asCharSource(file, Charsets.UTF_8).read();

        String content = com.google.common.io.Files.asCharSource(templateFile, Charsets.UTF_8).read();
        
        // String template = Resources.toString(Resources.getResource("api.yaml"), Charsets.UTF_8);

        String renderedTemplate = jinjava.render(content, context);

        System.out.println(renderedTemplate);

        try (PrintWriter out = new PrintWriter("C:\\workspace\\wso2\\apictl\\apictl-4.0.1-windows-x64\\apictl\\draft\\apictl.init.api\\output_api.yaml")) {
            out.println(renderedTemplate);
        }
    }

    private static void readXmlFile() throws Exception{
        //https://stackoverflow.com/questions/4138754/getting-an-attribute-value-in-xml-element

        String fileName = "C:\\workspace\\wso2\\apictl\\apictl-4.0.1-windows-x64\\apictl\\draft\\apictl.init.api\\sample.xml";
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.parse(new File(fileName));
        NodeList nodeList = document.getElementsByTagName("Item");
        for(int x=0,size= nodeList.getLength(); x<size; x++) {
            System.out.println(nodeList.item(x).getAttributes().getNamedItem("name").getNodeValue());
        }


        System.out.println("***End readXmlFile***");

    }
}
