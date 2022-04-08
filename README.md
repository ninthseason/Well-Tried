需要在`src/main/resources`目录下添加`mybatis-config.xml`文件，内容如下：
```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <environments default="development">
        <environment id="development">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <property name="driver" value="com.mysql.cj.jdbc.Driver"/>
                <property name="url" value=""/>  <!-- 数据库URL -->
                <property name="username" value=""/>  <!-- 用户名 -->
                <property name="password" value=""/>  <!-- 密码 -->
            </dataSource>
        </environment>
    </environments>
    <mappers>
        <mapper resource="WordMapper.xml"/>
    </mappers>
</configuration>
```