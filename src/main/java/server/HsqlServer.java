package server;

import org.hsqldb.Server;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

// To see hsql db in idea/databases run it
// change app.hsql datasource url to hsql.url2 to add data in it

public class HsqlServer {

    public static void main(String[] args) {
        Server server = new Server();
        server.setDatabasePath(0, "mem:db1;sql.syntax_pgs=true");
        server.setDatabaseName(0, "db1");
        server.setLogWriter(new Logger(System.out));
        server.start();
    }

    private static class Logger extends PrintWriter {
        public Logger(OutputStream out) {
            super(out);
        }

        @Override
        public void print(String line) {
            if (isSql(line)) {
                System.out.println(line);
            }
        }

        @Override
        public void println() {
        }

        private boolean isSql(String line) {
            for (String key : List.of("insert", "create",
                    "select", "alter", "update")) {
                if (line.toLowerCase().contains(key)) {
                    return true;
                }
            }
            return false;
        }
    }

}
