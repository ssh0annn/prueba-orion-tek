package com.orionteck.userviews.comannd_handler;

import com.orionteck.userviews.command.ActualizarClienteCommand;
import com.orionteck.userviews.command.CrearClienteCommand;
import com.orionteck.userviews.command.CrearDireccionesCommnad;
import com.orionteck.userviews.domain.Cliente;
import com.orionteck.userviews.domain.Direccion;
import com.orionteck.userviews.respository.ClienteRepository;
import com.orionteck.userviews.respository.DireccionRepository;
import com.orionteck.userviews.service.ClienteCommandService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.management.RuntimeErrorException;
import java.util.Optional;

@Service
public class ClienteCommandServiceImpl implements ClienteCommandService {

    private static final Logger log = LoggerFactory.getLogger(ClienteCommandServiceImpl.class);
    private final ClienteRepository clienteRepository;
    private final DireccionRepository direccionRepository; // <-- Nuevo campo


    public ClienteCommandServiceImpl(
            ClienteRepository clienteRepository,
            DireccionRepository direccionRepository
    ) {
        this.clienteRepository = clienteRepository;
        this.direccionRepository = direccionRepository;
    }

    @Override
    public Long CrearCliente(CrearClienteCommand commnad) {
        Cliente nuevoCliente = new Cliente();
        nuevoCliente.setNombre(commnad.name());
        nuevoCliente.setEmail(commnad.email());

        if (commnad.direcciones() != null) {

            // Usamos Strings para mapear la lista de DTOs a la lista de Entidades
            commnad.direcciones().forEach(direccionCommand -> {
                Direccion nuevaDireccion = new Direccion();
                nuevaDireccion.setCalle(direccionCommand.calle());
                nuevaDireccion.setCiudad(direccionCommand.ciudad());
                nuevaDireccion.setPais(direccionCommand.pais());


                nuevaDireccion.setCliente(nuevoCliente);
                nuevoCliente.getDirecciones().add(nuevaDireccion);
            });
        }

        Cliente clienteGuardado = clienteRepository.save(nuevoCliente);
        return clienteGuardado.getId();
    }

    @Override
    @Transactional
    public Long AgregarDIreccionACLiente(Long clienteId, CrearDireccionesCommnad commnad) {
        Cliente clienteExistente = clienteRepository.findById(clienteId)
                .orElseThrow();

        Direccion nuevaDireccion = new Direccion();
        nuevaDireccion.setCalle(commnad.calle());
        nuevaDireccion.setCiudad(commnad.ciudad());
        nuevaDireccion.setPais(commnad.pais());

        nuevaDireccion.setCliente(clienteExistente);
        clienteExistente.getDirecciones().add(nuevaDireccion);

        Direccion direccionGuardada = direccionRepository.save(nuevaDireccion);
        clienteRepository.save(clienteExistente);

        return direccionGuardada.getId();
    }
    @Override
    public void eliminarCliente(Long clienteId) {
        if (!clienteRepository.existsById(clienteId)) {
            throw new RuntimeException("Cliente con ID " + clienteId + " no encontrado.");
        }
        clienteRepository.deleteById(clienteId);

    }

    @Override
    @Transactional
    public Long actualizarCliente(Long idCliente, ActualizarClienteCommand command) {
        if (!clienteRepository.existsById(idCliente)){
            throw new RuntimeException("Cliente con id " + idCliente + " no encontrado" );
        }

        Cliente cliente = clienteRepository.findById(idCliente)
                 .orElseThrow(() -> new RuntimeException("No encontrado"));

        cliente.setNombre(command.nombre());
        cliente.setEmail(command.email());
        clienteRepository.save(cliente);
        return cliente.getId();

    }


}
