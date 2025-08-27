package Esfe.Aurora.Seguridad;

import javax.sql.DataSource;

import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.provisioning.*;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.*;
import org.springframework.security.crypto.password.*;

@Configuration
@EnableWebSecurity
public class DatabaseWebSecurity {
        @Bean
    public UserDetailsManager customUsers(DataSource dataSource){
        JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
        users.setUsersByUsernameQuery("select login, clave, status as enabled from usuario where login = ?");
        users.setAuthoritiesByUsernameQuery("select u.login, r.nombre as authority from usuario_rol ur " +
                "inner join usuario u on u.id = ur.usuario_id " +
                "inner join rol r on r.id = ur.rol_id " +
                "where u.login = ?");


        return users;
    }

   @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/assets/**", "/css/**", "/js/**","/images/**","/fonts/**","/error", "/", "/privacy", "/terms").permitAll()
                .requestMatchers("/anillos/**").hasAuthority("admin")
                .requestMatchers("/clientes/**").hasAuthority("admin")
                .requestMatchers("/detalleventa/**").hasAuthority("admin")
                .requestMatchers("/venta/**").hasAuthority("admin")
                .anyRequest().authenticated()
        );
        http.formLogin(form -> form
            .loginPage("/login").permitAll()
            .defaultSuccessUrl("/", true) 
     );
        return http.build();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}    