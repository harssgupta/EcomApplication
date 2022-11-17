import com.project.ecomapplication.entities.register.Address;
import com.project.ecomapplication.entities.register.Roles;
import com.project.ecomapplication.entities.register.UserEntity;
import com.project.ecomapplication.repository.RolesRepository;
import com.project.ecomapplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class Bootstrap implements ApplicationRunner {

    @Autowired
    RolesRepository rolesRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        if (userRepository.count() < 1) {
            UserEntity user = new UserEntity();
            user.setUsername("Harsh_TTN");
            user.setFirstName("Harsh");
            user.setMiddleName("Kumar");
            user.setLastName("Gupta");
            user.setEmail("yourharshh@.com");
//            user.setMobile(9718122312L);
            user.setPassword(bCryptPasswordEncoder.encode("Admin@123"));
            user.setInvalidAttemptCount(3);

            List<Address> addresses = new ArrayList<>();
            Address address = new Address();
            address.setCity("Faridabad");
            address.setCountry("India");
            address.setLabel("HomeTown");
            address.setState("UP");
            address.setZipcode(121002);
            addresses.add(address);

            address.setUser(user);

            user.setAddresses(addresses);

            List<Roles> roles = new ArrayList<>();
            Roles role = new Roles();
            role.setAuthority("ROLE_ADMIN");

            roles.add(role);
            user.setRoles(roles);

            userRepository.save(user);
            System.out.println("Total users saved::" + userRepository.count());
        }
    }
}