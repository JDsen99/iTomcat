package com.ss.itomcat.util;

import com.ss.itomcat.catalina.*;
import com.ss.itomcat.core.*;
import com.ss.itomcat.coyote.Adapter;
import com.ss.itomcat.coyote.Http11Protocol;
import com.ss.itomcat.coyote.ProtocolHandler;
import com.ss.itomcat.loader.WebappClassLoader;
import com.ss.itomcat.net.AbstractEndpoint;
import com.ss.itomcat.net.BioEndpoint;
import com.ss.itomcat.net.Connector;
import com.ss.itomcat.net.CoyoteAdapter;
import com.ss.itomcat.startup.Catalina;
import com.sun.xml.internal.ws.spi.db.WrapperAccessor;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * @author JDsen99
 * @description 解析server.xml文件
 * @createDate 2021/8/28-17:27
 */
public class Digester {
    //TODO 用digester 依赖替换 tomcat 使用digester依赖源码 https://www.jianshu.com/p/8d9a6ae40303

    private Catalina root;

    public void push(Catalina catalina) {
        this.root = catalina;
    }

    public Catalina parse(FileInputStream inputStream) throws DocumentException {
        SAXReader reader = new SAXReader();
        try {
            Document doc = reader.read(inputStream);
            Element rootElement = doc.getRootElement();
            Server server = createServer();
            //初始化service
            List<Element> serviceList = rootElement.selectNodes("Service");
            Service[] services = new Service[serviceList.size()];
            for (int i = 0; i < serviceList.size(); i++) {
                services[i] = createService(server, serviceList.get(i));
            }
            server.setServices(services);
            this.root.setServer(server);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return root;
    }

    private Server createServer() {
        return new StandardServer();
    }

    private Service createService(Server server, Element element) throws FileNotFoundException  {
        List<Element> listConnector = element.selectNodes("Connector");
        List<Element> listEngine = element.selectNodes("Engine");
        Service service = new StandardService();

        for (int i = 0; i < listEngine.size(); i++) {
            Engine engine = createEngine(service, listEngine.get(i));
            service.addEngine(engine);
        }
        service.setServer(server);

        for (int i = 0; i < listConnector.size(); i++) {
            Element elementConnector = listConnector.get(i);
            Adapter adapter = new CoyoteAdapter();
            AbstractEndpoint endpoint = new BioEndpoint(adapter);
            ProtocolHandler protocolHandler = new Http11Protocol(endpoint);
            Connector connector = new Connector(protocolHandler);
            adapter.setConnector(connector);
            protocolHandler.setConnector(connector);
            endpoint.setProtocolHandler(protocolHandler);

            String port = elementConnector.attributeValue("port");
            connector.setPort(Integer.parseInt(port));
            connector.setServer(server);
            connector.setService(service);

            server.addConnector(connector);
        }


        return service;
    }

    private Engine createEngine(Service service, Element element) throws FileNotFoundException  {
        List<Element> listHost = element.selectNodes("Host");
        Engine engine = new StandardEngine();
        Host[] hosts = new Host[listHost.size()];
        for (int i = 0; i < listHost.size(); i++) {
            hosts[i] = createHost(engine, listHost.get(i));
        }
        engine.setHost(hosts);
        return engine;
    }

    private Host createHost(Engine engine, Element element) throws FileNotFoundException  {
        Host host = new StandardHost();

        String name = element.attributeValue("name");
        String appBase = element.attributeValue("appBase");

        host.setName(name);
        host.setAppBase(appBase);
        host.setEngine(engine);

        File baseFile = new File(host.getAppBase());
        File[] files = baseFile.listFiles();
        for (int i = 0; i < files.length; i++) {
            File web = files[i];
            if (web.isDirectory()) {
                //初始化Context
                Context context = createContext(web);
                host.addContext(context);
            }
        }
        return host;
    }

    private Context createContext(File web) throws FileNotFoundException {
        Context context = new StandardContext();
        String name = web.getName();
        context.setContextName(name);
        File classPath = new File(web, "/WEB-INF/classes");
        URL[] urls = new URL[1];

        try {
            urls[0] = classPath.toURI().toURL();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        context.setClassloader(new WebappClassLoader(urls));

        // 加载web.xml,并解析出Wrapper

        File webXml = new File(web, "/WEB-INF/web.xml");
        if (webXml.exists()) {
            createWrapper(context,webXml);
        }
        return context;
    }

    private void createWrapper(Context context, File webXml) throws FileNotFoundException {
        InputStream inputStream = new FileInputStream(webXml);
        SAXReader reader = new SAXReader();
        try {
            Document doc = reader.read(inputStream);
            Element rootElement = doc.getRootElement();
            List<Element> listServlet = rootElement.selectNodes("servlet");
            for (Element element:listServlet) {
                Element servletNameEle = (Element) element.selectSingleNode("servlet-name");
                String servletName = servletNameEle.getStringValue();
                Element servletClsEle = (Element) element.selectSingleNode("servlet-class");
                String servletClass = servletClsEle.getStringValue();

                Element servletMapping = (Element) rootElement.selectSingleNode("/web-app/servlet-mapping[servlet-name='" + servletName + "']");
                String urlPattern = servletMapping.selectSingleNode("url-pattern").getStringValue();

                Wrapper wrapper = new StandardWrapper();
                wrapper.setServletName(servletName);
                wrapper.setClassName(servletClass);
                wrapper.setUrlPattern(urlPattern);
                wrapper.setContext(context);
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
