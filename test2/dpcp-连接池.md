​                                                          ### dpcp-数据库连接池

官方文档：

http://commons.apache.org/dbcp/configuration.html

### 1.配置参数

![image-20210513213905396](C:\Users\M\AppData\Roaming\Typora\typora-user-images\image-20210513213905396.png)

当建立新连接时被发送给JDBC驱动的连接参数，格式必须是 [propertyName=property;]



![image-20210513213958371](C:\Users\M\AppData\Roaming\Typora\typora-user-images\image-20210513213958371.png)

连接池创建的连接的默认的auto-commit状态

![image-20210513214422271](C:\Users\M\AppData\Roaming\Typora\typora-user-images\image-20210513214422271.png)



initialSize 0 初始化连接:连接池启动时创建的初始化连接数量,1.2版本后支持maxActive8最大活动连接:连接池在同一时间能够分配的最大活动连接的数量, 如果设置为非正数则表示不限制maxIdle   8 最大空闲连接:连接池中容许保持空闲状态的最大连接数量,超过的空闲连接将被释放,如果设置为负数表示不限制

minIdle    0 最小空闲连接:连接池中容许保持空闲状态的最小连接数量,低于这个数量将创建新的连接,如果设置为0则不创建

maxWait  无限  最大等待时间:当没有可用连接时,连接池等待连接被归还的最大时间(以毫秒计数),超过时间则抛出异常,如果设置为-1表示无限等待

![image-20210513214633315](C:\Users\M\AppData\Roaming\Typora\typora-user-images\image-20210513214633315.png)



| 参数                          | 默认值         | 描述                                                         |
| ----------------------------- | -------------- | ------------------------------------------------------------ |
| validationQuery               |                | SQL查询,用来验证从连接池取出的连接,在将连接返回给调用者之前.如果指定,则查询必须是一个SQL SELECT并且必须返回至少一行记录 |
| testOnBorrow                  | true           | 指明是否在从池中取出连接前进行检验,如果检验失败,则从池中去除连接并尝试取出另一个. **注意:** 设置为true后如果要生效,validationQuery参数必须设置为非空字符串 |
| testOnReturn                  | false          | 指明是否在归还到池中前进行检验 **注意:** 设置为true后如果要生效,validationQuery参数必须设置为非空字符串 |
| testWhileIdle                 | false          | 指明连接是否被空闲连接回收器(如果有)进行检验.如果检测失败,则连接将被从池中去除. **注意:** 设置为true后如果要生效,validationQuery参数必须设置为非空字符串 |
| timeBetweenEvictionRunsMillis | -1             | 在空闲连接回收器线程运行期间休眠的时间值,以毫秒为单位. 如果设置为非正数,则不运行空闲连接回收器线程 |
| numTestsPerEvictionRun        | 3              | 在每次空闲连接回收器线程(如果有)运行时检查的连接数量         |
| minEvictableIdleTimeMillis    | 1000 * 60 * 30 | 连接在池中保持空闲而不被空闲连接回收器线程(如果有)回收的最小时间值，单位毫秒 |



![image-20210513214804328](C:\Users\M\AppData\Roaming\Typora\typora-user-images\image-20210513214804328.png)



![image-20210513214852001](C:\Users\M\AppData\Roaming\Typora\typora-user-images\image-20210513214852001.png)



![image-20210513214904610](C:\Users\M\AppData\Roaming\Typora\typora-user-images\image-20210513214904610.png)



#### #### BasicDataSourceFactory 设置默认的参数

```java
public class BasicDataSourceFactory implements ObjectFactory {
    private static final String PROP_DEFAULTAUTOCOMMIT = "defaultAutoCommit";
    private static final String PROP_DEFAULTREADONLY = "defaultReadOnly";
    private static final String PROP_DEFAULTTRANSACTIONISOLATION = "defaultTransactionIsolation";
    private static final String PROP_DEFAULTCATALOG = "defaultCatalog";
    private static final String PROP_DRIVERCLASSNAME = "driverClassName";
    private static final String PROP_MAXACTIVE = "maxActive";
    private static final String PROP_MAXIDLE = "maxIdle";
    private static final String PROP_MINIDLE = "minIdle";
    private static final String PROP_INITIALSIZE = "initialSize";
    private static final String PROP_MAXWAIT = "maxWait";
    private static final String PROP_TESTONBORROW = "testOnBorrow";
    private static final String PROP_TESTONRETURN = "testOnReturn";
    private static final String PROP_TIMEBETWEENEVICTIONRUNSMILLIS = "timeBetweenEvictionRunsMillis";
    private static final String PROP_NUMTESTSPEREVICTIONRUN = "numTestsPerEvictionRun";
    private static final String PROP_MINEVICTABLEIDLETIMEMILLIS = "minEvictableIdleTimeMillis";
    private static final String PROP_TESTWHILEIDLE = "testWhileIdle";
    private static final String PROP_PASSWORD = "password";
    private static final String PROP_URL = "url";
    private static final String PROP_USERNAME = "username";
    private static final String PROP_VALIDATIONQUERY = "validationQuery";
    private static final String PROP_ACCESSTOUNDERLYINGCONNECTIONALLOWED = "accessToUnderlyingConnectionAllowed";
    private static final String PROP_REMOVEABANDONED = "removeAbandoned";
    private static final String PROP_REMOVEABANDONEDTIMEOUT = "removeAbandonedTimeout";
    private static final String PROP_LOGABANDONED = "logAbandoned";
    private static final String PROP_POOLPREPAREDSTATEMENTS = "poolPreparedStatements";
    private static final String PROP_MAXOPENPREPAREDSTATEMENTS = "maxOpenPreparedStatements";
    private static final String PROP_CONNECTIONPROPERTIES = "connectionProperties";
    private static final String[] ALL_PROPERTIES = new String[]{"defaultAutoCommit", "defaultReadOnly", "defaultTransactionIsolation", "defaultCatalog", "driverClassName", "maxActive", "maxIdle", "minIdle", "initialSize", "maxWait", "testOnBorrow", "testOnReturn", "timeBetweenEvictionRunsMillis", "numTestsPerEvictionRun", "minEvictableIdleTimeMillis", "testWhileIdle", "password", "url", "username", "validationQuery", "accessToUnderlyingConnectionAllowed", "removeAbandoned", "removeAbandonedTimeout", "logAbandoned", "poolPreparedStatements", "maxOpenPreparedStatements", "connectionProperties"};

    public BasicDataSourceFactory() {
    }

    public Object getObjectInstance(Object obj, Name name, Context nameCtx, Hashtable environment) throws Exception {
        if (obj != null && obj instanceof Reference) {
            Reference ref = (Reference)obj;
            if (!"javax.sql.DataSource".equals(ref.getClassName())) {
                return null;
            } else {
                Properties properties = new Properties();

                for(int i = 0; i < ALL_PROPERTIES.length; ++i) {
                    String propertyName = ALL_PROPERTIES[i];
                    RefAddr ra = ref.get(propertyName);
                    if (ra != null) {
                        String propertyValue = ra.getContent().toString();
                        properties.setProperty(propertyName, propertyValue);
                    }
                }

                return createDataSource(properties);
            }
        } else {
            return null;
        }
    }

    public static DataSource createDataSource(Properties properties) throws Exception {
        BasicDataSource dataSource = new BasicDataSource();
        String value = null;
        
        value = properties.getProperty("defaultAutoCommit");
        if (value != null) {
            //进行强制转换
            dataSource.setDefaultAutoCommit(Boolean.valueOf(value));
        }

        value = properties.getProperty("defaultReadOnly");
        if (value != null) {
            dataSource.setDefaultReadOnly(Boolean.valueOf(value));
        }

        value = properties.getProperty("defaultTransactionIsolation");
        if (value != null) {
            int level = true;
            int level;
            if ("NONE".equalsIgnoreCase(value)) {
                level = 0;
            } else if ("READ_COMMITTED".equalsIgnoreCase(value)) {
                level = 2;
            } else if ("READ_UNCOMMITTED".equalsIgnoreCase(value)) {
                level = 1;
            } else if ("REPEATABLE_READ".equalsIgnoreCase(value)) {
                level = 4;
            } else if ("SERIALIZABLE".equalsIgnoreCase(value)) {
                level = 8;
            } else {
                try {
                    level = Integer.parseInt(value);
                } catch (NumberFormatException var6) {
                    System.err.println("Could not parse defaultTransactionIsolation: " + value);
                    System.err.println("WARNING: defaultTransactionIsolation not set");
                    System.err.println("using default value of database driver");
                    level = -1;
                }
            }

            dataSource.setDefaultTransactionIsolation(level);
        }

        value = properties.getProperty("defaultCatalog");
        if (value != null) {
            dataSource.setDefaultCatalog(value);
        }

        value = properties.getProperty("driverClassName");
        if (value != null) {
            dataSource.setDriverClassName(value);
        }

        value = properties.getProperty("maxActive");
        if (value != null) {
            dataSource.setMaxActive(Integer.parseInt(value));
        }

        value = properties.getProperty("maxIdle");
        if (value != null) {
            dataSource.setMaxIdle(Integer.parseInt(value));
        }

        value = properties.getProperty("minIdle");
        if (value != null) {
            dataSource.setMinIdle(Integer.parseInt(value));
        }

        value = properties.getProperty("initialSize");
        if (value != null) {
            dataSource.setInitialSize(Integer.parseInt(value));
        }

        value = properties.getProperty("maxWait");
        if (value != null) {
            dataSource.setMaxWait(Long.parseLong(value));
        }

        value = properties.getProperty("testOnBorrow");
        if (value != null) {
            dataSource.setTestOnBorrow(Boolean.valueOf(value));
        }

        value = properties.getProperty("testOnReturn");
        if (value != null) {
            dataSource.setTestOnReturn(Boolean.valueOf(value));
        }

        value = properties.getProperty("timeBetweenEvictionRunsMillis");
        if (value != null) {
            dataSource.setTimeBetweenEvictionRunsMillis(Long.parseLong(value));
        }

        value = properties.getProperty("numTestsPerEvictionRun");
        if (value != null) {
            dataSource.setNumTestsPerEvictionRun(Integer.parseInt(value));
        }

        value = properties.getProperty("minEvictableIdleTimeMillis");
        if (value != null) {
            dataSource.setMinEvictableIdleTimeMillis(Long.parseLong(value));
        }

        value = properties.getProperty("testWhileIdle");
        if (value != null) {
            dataSource.setTestWhileIdle(Boolean.valueOf(value));
        }

        value = properties.getProperty("password");
        if (value != null) {
            dataSource.setPassword(value);
        }

        value = properties.getProperty("url");
        if (value != null) {
            dataSource.setUrl(value);
        }

        value = properties.getProperty("username");
        if (value != null) {
            dataSource.setUsername(value);
        }

        value = properties.getProperty("validationQuery");
        if (value != null) {
            dataSource.setValidationQuery(value);
        }

        value = properties.getProperty("accessToUnderlyingConnectionAllowed");
        if (value != null) {
            dataSource.setAccessToUnderlyingConnectionAllowed(Boolean.valueOf(value));
        }

        value = properties.getProperty("removeAbandoned");
        if (value != null) {
            dataSource.setRemoveAbandoned(Boolean.valueOf(value));
        }

        value = properties.getProperty("removeAbandonedTimeout");
        if (value != null) {
            dataSource.setRemoveAbandonedTimeout(Integer.parseInt(value));
        }

        value = properties.getProperty("logAbandoned");
        if (value != null) {
            dataSource.setLogAbandoned(Boolean.valueOf(value));
        }

        value = properties.getProperty("poolPreparedStatements");
        if (value != null) {
            dataSource.setPoolPreparedStatements(Boolean.valueOf(value));
        }

        value = properties.getProperty("maxOpenPreparedStatements");
        if (value != null) {
            dataSource.setMaxOpenPreparedStatements(Integer.parseInt(value));
        }

        value = properties.getProperty("connectionProperties");
        if (value != null) {
            Properties p = getProperties(value);
            Enumeration e = p.propertyNames();

            while(e.hasMoreElements()) {
                String propertyName = (String)e.nextElement();
                dataSource.addConnectionProperty(propertyName, p.getProperty(propertyName));
            }
        }

        return dataSource;
    }

    private static Properties getProperties(String propText) throws Exception {
        Properties p = new Properties();
        if (propText != null) {
            p.load(new ByteArrayInputStream(propText.replace(';', '\n').getBytes()));
        }

        return p;
    }
}

```

