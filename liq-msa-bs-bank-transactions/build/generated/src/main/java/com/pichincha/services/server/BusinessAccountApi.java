/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.4.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.pichincha.services.server;

import com.pichincha.services.server.models.Account;
import com.pichincha.services.server.models.CustomerAccountInner;
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

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-06-23T15:21:26.073986-05:00[America/Guayaquil]", comments = "Generator version: 7.4.0")
@Validated
@Tag(name = "business-account", description = "the business-account API")
public interface BusinessAccountApi {

    /**
     * DELETE /business-account/celula/v1/account/{accountNumber} : Eliminar una cuenta
     *
     * @param accountNumber  (required)
     * @return Cuenta eliminada correctamente (status code 204)
     *         or Cuenta no encontrada (status code 404)
     */
    @Operation(
        operationId = "deleteAccount",
        summary = "Eliminar una cuenta",
        responses = {
            @ApiResponse(responseCode = "204", description = "Cuenta eliminada correctamente"),
            @ApiResponse(responseCode = "404", description = "Cuenta no encontrada")
        }
    )
    @RequestMapping(
        method = RequestMethod.DELETE,
        value = "/business-account/celula/v1/account/{accountNumber}"
    )
    
    Mono<ResponseEntity<Void>> deleteAccount(
        @Parameter(name = "accountNumber", description = "", required = true, in = ParameterIn.PATH) @PathVariable("accountNumber") String accountNumber,
        @Parameter(hidden = true) final ServerWebExchange exchange
    );


    /**
     * GET /business-account/celula/v1/account : Obtener todas las cuentas
     *
     * @return Lista de cuentas (status code 200)
     */
    @Operation(
        operationId = "getAccount",
        summary = "Obtener todas las cuentas",
        responses = {
            @ApiResponse(responseCode = "200", description = "Lista de cuentas", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Account.class)))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/business-account/celula/v1/account",
        produces = { "application/json" }
    )
    
    Mono<ResponseEntity<Flux<Account>>> getAccount(
        @Parameter(hidden = true) final ServerWebExchange exchange
    );


    /**
     * GET /business-account/celula/v1/accountCustomer : Obtener una cuenta por número de cuenta
     *
     * @param dateStart Fecha inicio para filtrar movimientos (required)
     * @param dateEnd Fecha Fin para filtrar movimientos (required)
     * @param account Nombre de usuario para filtrar movimientos. (required)
     * @return Cuenta encontrada (status code 200)
     *         or Cuenta no encontrada (status code 404)
     */
    @Operation(
        operationId = "getAccountCustomer",
        summary = "Obtener una cuenta por número de cuenta",
        responses = {
            @ApiResponse(responseCode = "200", description = "Cuenta encontrada", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = CustomerAccountInner.class)))
            }),
            @ApiResponse(responseCode = "404", description = "Cuenta no encontrada")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/business-account/celula/v1/accountCustomer",
        produces = { "application/json" }
    )
    
    Mono<ResponseEntity<Flux<CustomerAccountInner>>> getAccountCustomer(
        @NotNull @Parameter(name = "dateStart", description = "Fecha inicio para filtrar movimientos", required = true, in = ParameterIn.QUERY) @Valid @RequestParam(value = "dateStart", required = true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateStart,
        @NotNull @Parameter(name = "dateEnd", description = "Fecha Fin para filtrar movimientos", required = true, in = ParameterIn.QUERY) @Valid @RequestParam(value = "dateEnd", required = true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateEnd,
        @NotNull @Parameter(name = "account", description = "Nombre de usuario para filtrar movimientos.", required = true, in = ParameterIn.QUERY) @Valid @RequestParam(value = "account", required = true) String account,
        @Parameter(hidden = true) final ServerWebExchange exchange
    );


    /**
     * GET /business-account/celula/v1/account/{accountNumber} : Obtener una cuenta por número de cuenta
     *
     * @param accountNumber  (required)
     * @return Cuenta encontrada (status code 200)
     *         or Cuenta no encontrada (status code 404)
     */
    @Operation(
        operationId = "getAccountNumber",
        summary = "Obtener una cuenta por número de cuenta",
        responses = {
            @ApiResponse(responseCode = "200", description = "Cuenta encontrada", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Account.class))
            }),
            @ApiResponse(responseCode = "404", description = "Cuenta no encontrada")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/business-account/celula/v1/account/{accountNumber}",
        produces = { "application/json" }
    )
    
    Mono<ResponseEntity<Account>> getAccountNumber(
        @Parameter(name = "accountNumber", description = "", required = true, in = ParameterIn.PATH) @PathVariable("accountNumber") String accountNumber,
        @Parameter(hidden = true) final ServerWebExchange exchange
    );


    /**
     * POST /business-account/celula/v1/account : Crear una nueva cuenta
     *
     * @param account  (required)
     * @return Cuenta creada correctamente (status code 201)
     *         or Solicitud incorrecta (status code 400)
     */
    @Operation(
        operationId = "postAccount",
        summary = "Crear una nueva cuenta",
        responses = {
            @ApiResponse(responseCode = "201", description = "Cuenta creada correctamente", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Account.class))
            }),
            @ApiResponse(responseCode = "400", description = "Solicitud incorrecta")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/business-account/celula/v1/account",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    
    Mono<ResponseEntity<Account>> postAccount(
        @Parameter(name = "Account", description = "", required = true) @Valid @RequestBody Account account,
        @Parameter(hidden = true) final ServerWebExchange exchange
    );


    /**
     * PUT /business-account/celula/v1/account/{accountNumber} : Actualizar una cuenta existente
     *
     * @param accountNumber  (required)
     * @param account  (required)
     * @return Cuenta actualizada correctamente (status code 200)
     *         or Solicitud incorrecta (status code 400)
     *         or Cuenta no encontrada (status code 404)
     */
    @Operation(
        operationId = "putAccount",
        summary = "Actualizar una cuenta existente",
        responses = {
            @ApiResponse(responseCode = "200", description = "Cuenta actualizada correctamente", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Account.class))
            }),
            @ApiResponse(responseCode = "400", description = "Solicitud incorrecta"),
            @ApiResponse(responseCode = "404", description = "Cuenta no encontrada")
        }
    )
    @RequestMapping(
        method = RequestMethod.PUT,
        value = "/business-account/celula/v1/account/{accountNumber}",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    
    Mono<ResponseEntity<Account>> putAccount(
        @Parameter(name = "accountNumber", description = "", required = true, in = ParameterIn.PATH) @PathVariable("accountNumber") String accountNumber,
        @Parameter(name = "Account", description = "", required = true) @Valid @RequestBody Account account,
        @Parameter(hidden = true) final ServerWebExchange exchange
    );

}
