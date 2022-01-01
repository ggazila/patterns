package behavioral.chain_of_responsibility.refactoring;

import behavioral.chain_of_responsibility.refactoring.middleware.Middleware;
import behavioral.chain_of_responsibility.refactoring.middleware.RoleCheckMiddleware;
import behavioral.chain_of_responsibility.refactoring.middleware.ThrottlingMiddleware;
import behavioral.chain_of_responsibility.refactoring.middleware.UserExistsMiddleware;
import behavioral.chain_of_responsibility.refactoring.server.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Demo {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Server server;

    private static void init() {
        server = new Server();
        server.register("admin@example.com", "admin_pass");
        server.register("user@example.com", "user_pass");

        Middleware middleware = new ThrottlingMiddleware(2);
        middleware.linkWith(new UserExistsMiddleware(server))
                .linkWith(new RoleCheckMiddleware());

        server.setMiddleware(middleware);
    }

    public static void main(String[] args) throws IOException {
        init();

        boolean success;
        do {
            System.out.print("Enter email: ");
            String email = reader.readLine();
            System.out.print("Input password: ");
            String password = reader.readLine();
            success = server.logIn(email, password);
        } while (!success);

    }
}
