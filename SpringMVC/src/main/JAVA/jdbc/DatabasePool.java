package jdbc;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DatabasePool {

    private static HikariDataSource hikariDataSource;
    public HikariDataSource getHikariDataSource(){
        if(null!=hikariDataSource){
            return hikariDataSource;
        }

        synchronized (DatabasePool.class){
            if(null==hikariDataSource){
                String url="jdbc:mysql://localhost:3306/zy?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=GMT";
                String driverName="com.mysql.jdbc.Driver";
                HikariConfig hikariConfig=new HikariConfig();
                hikariConfig.setUsername("root");
                hikariConfig.setPassword("zhangying");
                hikariConfig.setDriverClassName(driverName);
                hikariConfig.setJdbcUrl(url);
                hikariDataSource=new HikariDataSource(hikariConfig);
                return hikariDataSource;
            }
        }
        return null;
    }

}
