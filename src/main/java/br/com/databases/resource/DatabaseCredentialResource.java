package br.com.databases.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.databases.router.entity.dto.DatabaseCredentialDTO;
import br.com.databases.service.DatabaseCredentialService;

@RestController
@RequestMapping(value = "/api-multidatabase-v2", produces = {MediaType.APPLICATION_JSON_VALUE})
public class DatabaseCredentialResource {
    
    @Autowired
    private DatabaseCredentialService databaseCredentialService;

    @PostMapping(value = "/database-credential")
    public ResponseEntity<Object> save(@RequestBody DatabaseCredentialDTO databaseCredentialDTO) {
        return databaseCredentialService.save(databaseCredentialDTO);
    }

    @GetMapping(value = "/database-credential")
    public ResponseEntity<Object> list() {
        return databaseCredentialService.list();
    }

}
