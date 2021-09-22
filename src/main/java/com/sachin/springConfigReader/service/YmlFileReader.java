package com.sachin.springConfigReader.service;

import com.sachin.springConfigReader.properties.AppProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

@Component
public class YmlFileReader {
    @Autowired
    AppProperties appProperties;

    @Value("${ipAddress}")
    String ipAddress;
    @Value("${port}")
    String port;
    @Value("${server-name}")
    String serverName;
    @Bean
    public void YmlFileRead() throws IOException
    {
        Yaml yaml = new Yaml();
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("sampleConfig.yml");
        Map<String, Object> allConfig = yaml.load(inputStream);
        inputStream.close();
        //pass env dev/uat param from controller if required
        Map<String, Object> devConfig = (Map) allConfig.get("dev");
        Map<String, Object> uatConfig = (Map) allConfig.get("uat");
        String ipAddressDev = devConfig.get("ipAddress").toString();
        String port = devConfig.get("port").toString();
        String serverName = devConfig.get("server-name").toString();
        List<String> users = (List) devConfig.get("user-names");
        System.out.println("IP address is: "+ ipAddressDev);
        System.out.println("port is : "+ port);
        System.out.println("Server name is : "+ serverName );
        for(int i= 0 ; i < users.size(); i++)
        {
            System.out.println("username is :" + users.get(i));
        }
    }

    @Bean
    public void YmlFileReadThruValue() throws IOException
    {
        System.out.println("Ip value thru @value:"+ ipAddress);
        System.out.println("port value thru @value:"+ port);
        System.out.println("server value thru @value:"+ serverName);

    }

    @Bean
    public void YmlFileReadThruProps() throws IOException
    {
        System.out.println("Ip value thru property:"+ appProperties.getIpAddress());
        System.out.println("port value thru property:"+ appProperties.getPort());
        System.out.println("server value thru property:"+ appProperties.getServerName());

    }
}
