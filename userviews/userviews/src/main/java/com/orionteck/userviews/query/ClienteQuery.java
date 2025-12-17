package com.orionteck.userviews.query;


//Para el listados de Clientes
public record ClienteQuery(
        Long id,
        String nombre,
        String email
) {
}
