package br.com.coopersystem.backendcoopersystem.resource;

import br.com.coopersystem.backendcoopersystem.model.Cliente;
import br.com.coopersystem.backendcoopersystem.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/cliente", produces = MediaType.APPLICATION_JSON_VALUE)
public class ClienteResource {

    private ClienteService clienteService;

    @Autowired
    public ClienteResource(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping(path = "/")
    public ResponseEntity<Cliente> salvar(@RequestBody Cliente cliente) {

        Cliente responseCliente = null;
        HttpStatus responseStatus;

        try {
            responseCliente = this.clienteService.salvarCliente(cliente);

            responseStatus = responseCliente != null
                    ? HttpStatus.OK
                    : HttpStatus.NO_CONTENT;
        }
        catch (Exception e) {
            responseStatus = HttpStatus.BAD_REQUEST;
            e.printStackTrace();
        }

        return new ResponseEntity<>(responseCliente, responseStatus);
    }

    // TODO fix update
    @PutMapping(path = "/{idCliente}")
    public ResponseEntity<Cliente> alterar(@RequestBody Cliente cliente, @PathVariable("idCliente") Long idCliente) {

        Cliente responseCliente = null;
        HttpStatus responseStatus;

        try {
            responseCliente = this.clienteService.buscarClientePorId(idCliente);
            responseCliente = this.clienteService.alterarCliente(cliente);

            responseStatus = responseCliente != null
                    ? HttpStatus.OK
                    : HttpStatus.NO_CONTENT;
        }
        catch (Exception e) {
            responseStatus = HttpStatus.BAD_REQUEST;
            e.printStackTrace();
        }

        return new ResponseEntity<>(responseCliente, responseStatus);
    }

    @DeleteMapping(path = "/{idCliente}")
    public ResponseEntity<Cliente> deletar(@PathVariable("idCliente") Long idCliente) {

        Cliente responseCliente = null;
        HttpStatus responseStatus;

        try {
            responseCliente = this.clienteService.removerClientePorId(idCliente);

            responseStatus = responseCliente != null
                    ? HttpStatus.OK
                    : HttpStatus.NO_CONTENT;
        }
        catch (Exception e) {
            responseStatus = HttpStatus.BAD_REQUEST;
            e.printStackTrace();
        }

        return new ResponseEntity<>(responseCliente, responseStatus);
    }

    @GetMapping(path = "/{idCliente}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable("idCliente") Long idCliente) {

        Cliente responseCliente = null;
        HttpStatus responseStatus;

        try {
            responseCliente = this.clienteService.buscarClientePorId(idCliente);

            responseStatus = responseCliente != null
                    ? HttpStatus.OK
                    : HttpStatus.NO_CONTENT;
        }
        catch (Exception e) {
            responseStatus = HttpStatus.BAD_REQUEST;
            e.printStackTrace();
        }

        return new ResponseEntity<>(responseCliente, responseStatus);
    }

    @GetMapping(path = "/")
    public ResponseEntity<List<Cliente>> listarClientes() {

        List<Cliente> responseClientes = null;
        HttpStatus responseStatus;

        try {
            responseClientes = this.clienteService.buscarClientes();

            responseStatus = responseClientes != null
                    ? HttpStatus.OK
                    : HttpStatus.NO_CONTENT;
        }
        catch (Exception e) {
            responseStatus = HttpStatus.BAD_REQUEST;
            e.printStackTrace();
        }

        return new ResponseEntity<>(responseClientes, responseStatus);
    }
}
