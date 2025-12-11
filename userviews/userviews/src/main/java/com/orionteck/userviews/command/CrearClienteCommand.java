package com.orionteck.userviews.command;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.orionteck.userviews.domain.Direccion;
import org.springframework.validation.annotation.Validated;

import java.util.List;

public record CrearClienteCommand(
        @JsonProperty("nombre") String name,  //se pdoria usar etiquetas de jakarta como @NotBlank y @Email
        @JsonProperty("email")  String email,
        List<CrearDireccionesCommnad> direcciones
) {
}
