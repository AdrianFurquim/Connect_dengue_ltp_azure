package connectdengue.connect_dengue.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import connectdengue.connect_dengue.security.service.MinhaUsuarioDetailsService;



@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    // Dentro de WebSecurityConfig
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                //.requiresChannel(channel -> channel.anyRequest().requiresSecure())
                .csrf().disable() // Necessário para permitir acesso ao POST
                //.httpBasic(Customizer.withDefaults())
                .authorizeHttpRequests(
                        authorize -> authorize
                                .requestMatchers(HttpMethod.GET, "/dengue/relatos").permitAll() // Relatos
                                .requestMatchers(HttpMethod.GET, "/dengue/relatos/{id}").permitAll()
                                .requestMatchers(HttpMethod.DELETE, "/dengue/relatos/remove/{id}").permitAll()

                                .requestMatchers(HttpMethod.GET, "/dengueshow/ver").permitAll() // Dengue Show
                                .requestMatchers(HttpMethod.GET, "/dengue/dengueShow/{id}").permitAll()
                                .requestMatchers(HttpMethod.DELETE, "/dengueshow/quiz/remove/{id}").permitAll()

                                .requestMatchers(HttpMethod.GET, "/dengue/sintomas").permitAll() // Sintomas
                                .requestMatchers(HttpMethod.GET, "/dengue/sintomas/{id}").permitAll()
                                .requestMatchers(HttpMethod.DELETE, "/dengue/sintomas/remove/{id}").permitAll()

                                .requestMatchers(HttpMethod.GET, "/dengue/denuncias").permitAll() // Denuncia
                                .requestMatchers(HttpMethod.GET, "/dengue/denuncias/{id}").permitAll()
                                .requestMatchers(HttpMethod.DELETE, "/dengue/denuncias/remove/{id}").permitAll()

                                .requestMatchers(HttpMethod.POST, "/criar").permitAll() //Usuario teste
                                .requestMatchers(HttpMethod.GET, "/login").permitAll())
                                
                .authorizeHttpRequests( 
                        authorize -> authorize
                                .requestMatchers(HttpMethod.POST, "/dengue/relatos/inserir").authenticated()
                                .requestMatchers(HttpMethod.POST, "/dengueshow/inserir").authenticated()
                                .requestMatchers(HttpMethod.POST, "/dengue/sintomas/inserir").authenticated()
                                .requestMatchers(HttpMethod.POST, "/dengue/denuncias/inserir").authenticated()
                                .requestMatchers(HttpMethod.GET, "/conteudo").authenticated())
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }

    // Dentro de WebSecurityConfig
    @Bean
    public UserDetailsService userDetailsService() {
        // UserDetails user = User.withDefaultPasswordEncoder()
        // .username("connectdengue")
        // .password("connectdengue")
        // .build();

        // return new InMemoryUserDetailsManager(user);
        return new MinhaUsuarioDetailsService();
    }

    @Bean
    // Obrigatório. Vai permitir criptografar as senhas das credenciais de login
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
