package problems.design;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ConnectionPool {

    // Thread-safe Queue with initial Pool size already cached during load-on-startup
    private BlockingQueue<Connection> pool;

    // Maximum connetions which can be created and cached in queue if required
    private int maxPoolSize;

    // Actual Initial Pool size given by client to create and cached in BlockingQueue
    private int initialPoolSize;

    // Number of Connections Generated so far
    private int currentPoolSize;

    private String dbUrl;
    private String dbUser;
    private String dbPassword;

    // 1. Load Driver class
    // 2. Create Connection up to initialPoolSize and add into pool
    public ConnectionPool(int maxPoolSize, int initialPoolSize, String url, String userName,
                          String password, String driverClassName) throws ClassNotFoundException, SQLException {

        if ((initialPoolSize > maxPoolSize) || initialPoolSize < 1 || maxPoolSize < 1) {
            throw new IllegalArgumentException("Invalid pool size parameters");
        }

        // default max Pool size is 10
        this.maxPoolSize = maxPoolSize > 0 ? maxPoolSize : 10;
        this.initialPoolSize = initialPoolSize;
        this.dbUrl = url;
        this.dbPassword = password;
        this.dbUser = userName;

        // Can have max connections upto MaxPoolSize
        this.pool = new LinkedBlockingQueue<Connection>(maxPoolSize);

        initPooledConnections(driverClassName);
    }

    private void initPooledConnections(String driverClassName) throws ClassNotFoundException, SQLException {

        // 1. Attempt to load driver class
        Class.forName(driverClassName);

        // 2. create connections and add into pool
        for (int i = 0; i < initialPoolSize; i++) {
            openAndPoolConnection();
        }
    }

    // Thread-safe Connection creation and adding into Pool
    private synchronized void openAndPoolConnection() throws SQLException {

        // base check
        if (currentPoolSize == maxPoolSize) {
            return;
        }

        Connection connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
        pool.offer(connection);
        currentPoolSize++;
    }

    private Connection borrowConnection() throws SQLException, InterruptedException {

        // if there is scope of new connection creation is still possible
        if (pool.peek() == null && currentPoolSize < maxPoolSize) {
            openAndPoolConnection();
        }

        return pool.take();
    }

    private Connection borrowConnection(long timeoutInMillis) throws SQLException, InterruptedException {

        Instant startInstant = Instant.now();

        do {
            // if there is scope of new connection creation is still possible
            if (pool.peek() == null && currentPoolSize < maxPoolSize) {
                openAndPoolConnection();
            }

            return pool.take();
        } while (Duration.between(startInstant, Instant.now()).toMillis() < timeoutInMillis);
    }

    public void surrenderConnection(Connection conn) {
        pool.offer(conn); // offer() as we do not want to go beyond capacity
    }
}