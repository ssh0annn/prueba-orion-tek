package com.orionteck.userviews.query;

import com.orionteck.userviews.command.CrearDireccionesCommnad;

import java.util.List;


//Aqui se consultaria la vista detallada( incluye toda las vista)
public record ClienteDetalleQuery
        (
                Long id,
                String nombre,
                String email,
                List<DireccionQuery> direcciones
        ){
}
