package br.com.ipsamambaia.cadastromembrosserver.config.app;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import br.com.ipsamambaia.cadastromembrosserver.CadastroMembrosServerApplication;

@Configuration
@EntityScan(basePackageClasses = {CadastroMembrosServerApplication.class, Jsr310JpaConverters.class})
public class AppConfig {

}
