package com.ss.itomcat.startup;

import com.ss.itomcat.catalina.Server;
import com.ss.itomcat.util.Digester;
import org.dom4j.DocumentException;

import javax.annotation.processing.Filer;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author JDsen99
 * @description
 * @createDate 2021/8/28-16:26
 */
public class Catalina {

    /**
     * 配置文件地址
     */
    protected static final String configFile = "conf/server.xml";

    protected Server server = null;



    public void load() {
        try {
            Digester digester = createStartDigester();
            File file = configFile();
            FileInputStream inputStream = new FileInputStream(file);
            digester.push(this);
            digester.parse(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        getServer().init();
    }

    protected File configFile() {
        String catalinaBase = this.getClass()
                .getResource("/")
                .getPath()
                .replace("/target/classes","") + "source/";

        File file = new File(configFile);
        if (!file.isAbsolute()) {
            file = new File(catalinaBase,configFile);
        }
        return file;
    }

    private Digester createStartDigester() {
        return new Digester();
    }
    public Server getServer() {
        return server;
    }

    public void setServer(Server server) {
        this.server = server;
    }
}
