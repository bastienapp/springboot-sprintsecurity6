package co.simplon.jpasecurity;

import co.simplon.jpasecurity.entity.Post;
import co.simplon.jpasecurity.entity.Role;
import co.simplon.jpasecurity.entity.User;
import co.simplon.jpasecurity.repository.PostRepository;
import co.simplon.jpasecurity.repository.RoleRepository;
import co.simplon.jpasecurity.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@SpringBootApplication
public class JpaSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaSecurityApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(PostRepository posts, UserRepository users, RoleRepository roles,
                                        PasswordEncoder encoder) {
        return args -> {
            Role roleUser = roles.save(new Role("USER"));
            Role roleAdmin = roles.save(new Role("ADMIN"));
            users.save(new User("user@simplon.co", encoder.encode("password"), Set.of(new Role[]{roleUser})));
            users.save(new User("admin@simplon.co", encoder.encode("password"), Set.of(new Role[]{roleUser, roleAdmin})));
            posts.save(new Post("Hello, World!", "Welcome to my new blog!", "Dan Vega"));
        };
    }
}
