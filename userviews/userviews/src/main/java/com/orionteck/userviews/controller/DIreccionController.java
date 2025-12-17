package com.orionteck.userviews.controller;


import com.orionteck.userviews.command.CrearDireccionesCommnad;
import com.orionteck.userviews.respository.DireccionRepository;
import com.orionteck.userviews.service.ClienteCommandService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clientes/{clienteID}/direcciones")
public class DIreccionController {
    private final ClienteCommandService commandService;

    public DIreccionController(ClienteCommandService commandService){

        this.commandService = commandService;
    }

    @PostMapping
    public ResponseEntity<Long> agregarDireccion(  @PathVariable Long clienteID,
    @RequestBody CrearDireccionesCommnad commnad){
      Long nuevaDireccionId = commandService.AgregarDIreccionACLiente(clienteID,commnad);
      return new ResponseEntity<>(nuevaDireccionId, HttpStatus.CREATED);
    }



    //El Listado de direciones ya esta cuvierto por GET /api/v1/clientes/{id}
    // (el ClienteDetalleQuery incluye las direcciones). Si se necesitara un endpoint
    // independiente solo para listar direcciones, se inyectaría ClienteQueryService aquí.
}
