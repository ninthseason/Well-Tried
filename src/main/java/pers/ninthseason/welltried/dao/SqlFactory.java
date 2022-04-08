package pers.ninthseason.welltried.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlFactory {

    private static final String resource = "mybatis-config.xml";
    private static InputStream inputStream = null;
    static {
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static final SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

    public static SqlSessionFactory getFactory() {
        return sqlSessionFactory;
    }
}
