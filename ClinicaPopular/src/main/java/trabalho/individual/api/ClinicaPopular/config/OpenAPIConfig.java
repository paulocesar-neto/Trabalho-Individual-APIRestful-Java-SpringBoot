package trabalho.individual.api.ClinicaPopular.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI myOpenAPI() {
        Contact contato = new Contact();
        contato.setEmail("paulo.neto@residente.serratec.org");
        contato.setName("Paulo Cesar");
        contato.setUrl("https://github.com/paulo-neto");

        License apacheLicense = new License()
                .name("Apache License")
                .url("https://www.apache.org/licenses/LICENSE-2.0");

        Info info = new Info()
                .title("API Clinica Popular")
                .version("1.0")
                .contact(contato)
                .description("API de CLinica Popular,para cadastro de pacientes," +
                        "agendamento de consultas com diversas especialidades" +
                        "cadastro de Médicos")
                .termsOfService("https://github.com/paulo-neto")
                .license(apacheLicense);

       return new OpenAPI().info(info);
    }
}
