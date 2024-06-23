package com.pichincha.bs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.web.reactive.config.EnableWebFlux;

/**
 * Arquitectura tradicional para el recurso liq-msa-bs-bank-clients extendiendo
 * de la interfaz generada.
<br/>
 * <b>Class</b>: PichinchaOptimusMainApplication<br/>
 * <b>Copyright</b>: &copy; 2024 Banco Pichincha<br/>
 *
 * @author Banco Pichincha <br/>
 * <u>Developed by</u>: <br/>
 * <ul>
*
<li>Eduardo Araujo</li>
*
</ul>
 * <u>Changes</u>:<br/>
 * <ul>
*
<li>Jun 17, 2024 Creaci&oacute;n de Clase.</li>
*
</ul>
 * @version 1.0
 */
@EnableR2dbcRepositories
@EnableWebFlux
@SpringBootApplication(scanBasePackages = "com.pichincha.bs")
public class OptimusMainApplication {

  public static void main(String[] args) {
        SpringApplication.run(OptimusMainApplication.class, args);
    }
}