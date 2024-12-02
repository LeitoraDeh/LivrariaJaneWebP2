import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Permitir CORS para qualquer requisição que envolva o caminho /assets
        registry.addMapping("/assets/**")
                .allowedOrigins("http://localhost:4200")  // Permitir que o frontend acesse as imagens
                .allowedMethods("GET")                   // Permitir somente GET
                .allowCredentials(true);                 // Caso precise permitir cookies/autenticação
    }
}