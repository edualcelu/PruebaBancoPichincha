/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.4.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.pichincha.services.server;

import com.pichincha.services.server.models.Customer;
import com.pichincha.services.server.models.CustomerTransactions;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.http.codec.multipart.Part;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-06-23T13:28:31.646116600-05:00[America/Guayaquil]", comments = "Generator version: 7.4.0")
@Validated
@Tag(name = "business", description = "the business API")
public interface BusinessApi {

    /**
     * GET /business/celula/v1/customers/customer-transactions : Obtener informe detallado de cliente y cuentas bancarias con movimientos
     * Obtiene un informe detallado de un cliente, incluyendo detalles de cada cuenta bancaria y sus movimientos. 
     *
     * @param dateStart Fecha inicio para filtrar movimientos (required)
     * @param dateEnd Fecha Fin para filtrar movimientos (required)
     * @param customer Nombre de usuario para filtrar movimientos. (required)
     * @return Informe detallado de cliente obtenido correctamente (status code 200)
     */
    @Operation(
        operationId = "customerTransactions",
        summary = "Obtener informe detallado de cliente y cuentas bancarias con movimientos",
        description = "Obtiene un informe detallado de un cliente, incluyendo detalles de cada cuenta bancaria y sus movimientos. ",
        responses = {
            @ApiResponse(responseCode = "200", description = "Informe detallado de cliente obtenido correctamente", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = CustomerTransactions.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/business/celula/v1/customers/customer-transactions",
        produces = { "application/json" }
    )
    
    Mono<ResponseEntity<CustomerTransactions>> customerTransactions(
        @NotNull @Parameter(name = "dateStart", description = "Fecha inicio para filtrar movimientos", required = true, in = ParameterIn.QUERY) @Valid @RequestParam(value = "dateStart", required = true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateStart,
        @NotNull @Parameter(name = "dateEnd", description = "Fecha Fin para filtrar movimientos", required = true, in = ParameterIn.QUERY) @Valid @RequestParam(value = "dateEnd", required = true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateEnd,
        @NotNull @Parameter(name = "customer", description = "Nombre de usuario para filtrar movimientos.", required = true, in = ParameterIn.QUERY) @Valid @RequestParam(value = "customer", required = true) String customer,
        @Parameter(hidden = true) final ServerWebExchange exchange
    );


    /**
     * DELETE /business/celula/v1/customers/{id} : Eliminar un cliente por ID
     *
     * @param id  (required)
     * @return Cliente eliminado exitosamente (status code 204)
     *         or Cliente no encontrado (status code 404)
     */
    @Operation(
        operationId = "deleteCustomer",
        summary = "Eliminar un cliente por ID",
        responses = {
            @ApiResponse(responseCode = "204", description = "Cliente eliminado exitosamente"),
            @ApiResponse(responseCode = "404", description = "Cliente no encontrado")
        }
    )
    @RequestMapping(
        method = RequestMethod.DELETE,
        value = "/business/celula/v1/customers/{id}"
    )
    
    Mono<ResponseEntity<Void>> deleteCustomer(
        @Parameter(name = "id", description = "", required = true, in = ParameterIn.PATH) @PathVariable("id") String id,
        @Parameter(hidden = true) final ServerWebExchange exchange
    );


    /**
     * GET /business/celula/v1/customers : Obtener lista de clientes
     *
     * @return Lista de clientes (status code 200)
     */
    @Operation(
        operationId = "getCustomer",
        summary = "Obtener lista de clientes",
        responses = {
            @ApiResponse(responseCode = "200", description = "Lista de clientes", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Customer.class)))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/business/celula/v1/customers",
        produces = { "application/json" }
    )
    
    Mono<ResponseEntity<Flux<Customer>>> getCustomer(
        @Parameter(hidden = true) final ServerWebExchange exchange
    );


    /**
     * GET /business/celula/v1/customers/{id} : Obtener un cliente por ID
     *
     * @param id  (required)
     * @return Datos del cliente (status code 200)
     *         or Client no encontrado (status code 404)
     */
    @Operation(
        operationId = "getCustomerId",
        summary = "Obtener un cliente por ID",
        responses = {
            @ApiResponse(responseCode = "200", description = "Datos del cliente", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Customer.class))
            }),
            @ApiResponse(responseCode = "404", description = "Client no encontrado")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/business/celula/v1/customers/{id}",
        produces = { "application/json" }
    )
    
    Mono<ResponseEntity<Customer>> getCustomerId(
        @Parameter(name = "id", description = "", required = true, in = ParameterIn.PATH) @PathVariable("id") String id,
        @Parameter(hidden = true) final ServerWebExchange exchange
    );


    /**
     * POST /business/celula/v1/customers : Crear un nuevo cliente
     *
     * @param customer Datos del nuevo cliente (required)
     * @return Cliente creado exitosamente (status code 201)
     */
    @Operation(
        operationId = "postCustomer",
        summary = "Crear un nuevo cliente",
        responses = {
            @ApiResponse(responseCode = "201", description = "Cliente creado exitosamente", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Customer.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/business/celula/v1/customers",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    
    Mono<ResponseEntity<Customer>> postCustomer(
        @Parameter(name = "Customer", description = "Datos del nuevo cliente", required = true) @Valid @RequestBody Customer customer,
        @Parameter(hidden = true) final ServerWebExchange exchange
    );


    /**
     * PUT /business/celula/v1/customers/{id} : Actualizar un cliente por ID
     *
     * @param id  (required)
     * @param customer Datos actualizados del cliente (required)
     * @return Cliente actualizado exitosamente (status code 200)
     *         or Cliente no encontrado (status code 404)
     */
    @Operation(
        operationId = "putCustomer",
        summary = "Actualizar un cliente por ID",
        responses = {
            @ApiResponse(responseCode = "200", description = "Cliente actualizado exitosamente", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Customer.class))
            }),
            @ApiResponse(responseCode = "404", description = "Cliente no encontrado")
        }
    )
    @RequestMapping(
        method = RequestMethod.PUT,
        value = "/business/celula/v1/customers/{id}",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    
    Mono<ResponseEntity<Customer>> putCustomer(
        @Parameter(name = "id", description = "", required = true, in = ParameterIn.PATH) @PathVariable("id") String id,
        @Parameter(name = "Customer", description = "Datos actualizados del cliente", required = true) @Valid @RequestBody Customer customer,
        @Parameter(hidden = true) final ServerWebExchange exchange
    );

}
