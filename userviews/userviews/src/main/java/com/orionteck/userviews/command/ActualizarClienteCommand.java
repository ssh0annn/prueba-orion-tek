package com.orionteck.userviews.command;

public record ActualizarClienteCommand(
        String nombre,
        String email
) {
}
