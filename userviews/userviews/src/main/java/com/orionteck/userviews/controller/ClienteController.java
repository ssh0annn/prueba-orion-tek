package com.orionteck.userviews.controller;


import com.orionteck.userviews.command.ActualizarClienteCommand;
import com.orionteck.userviews.command.CrearClienteCommand;
import com.orionteck.userviews.query.ClienteDetalleQuery;
import com.orionteck.userviews.query.ClienteQuery;
import com.orionteck.userviews.service.ClienteCommandService;
import com.orionteck.userviews.service.ClienteQueryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteCommandService commandService;
    private final ClienteQueryService queryService;

    public ClienteController(ClienteCommandService commandService, ClienteQueryService queryService) {
        this.commandService = commandService;
        this.queryService = queryService;
    }

    // Para mutar la informacion en la bases de datos(osea los command)


    @PostMapping
    public ResponseEntity<Long> crearCliente(@RequestBody CrearClienteCommand command) {
        Long nuevoId = commandService.CrearCliente(command);
        return new ResponseEntity<>(nuevoId, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> eliminarCliente(@PathVariable Long id) {
        commandService.eliminarCliente(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Long> actualizarCliente(@PathVariable Long id, @RequestBody ActualizarClienteCommand commad) {
       Long clienteActualizado =  commandService.actualizarCliente(id, commad);
        return ResponseEntity.ok(clienteActualizado);
    }

    // Para Consultas a las bases de datos(osea los querys)
    @GetMapping
    public ResponseEntity<List<ClienteQuery>> listarClientes(){
        List<ClienteQuery> clientes =  queryService.listarCliente();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDetalleQuery> obtenerClienteDetalle(@PathVariable Long id){
        ClienteDetalleQuery detalle = queryService.obtenerClienteDetalle(id);
        return ResponseEntity.ok(detalle);
    }


}
