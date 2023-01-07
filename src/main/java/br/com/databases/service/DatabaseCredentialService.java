package br.com.databases.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.databases.router.entity.DatabaseCredential;
import br.com.databases.router.entity.dto.DatabaseCredentialDTO;
import br.com.databases.router.repository.DatabaseCredentialRepository;

@Service
public class DatabaseCredentialService {

    @Autowired
    private DatabaseCredentialRepository databaseCredentialRepository;

    public ResponseEntity<Object> save(DatabaseCredentialDTO databaseCredentialDTO) {
        DatabaseCredential databaseCredential = new DatabaseCredential(databaseCredentialDTO);
        try {
            DatabaseCredential result = databaseCredentialRepository.saveAndFlush(databaseCredential);
            return ResponseEntity.ok().body(new DatabaseCredentialDTO(result));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    public ResponseEntity<Object> list() {
        try {
            List<DatabaseCredentialDTO> result = databaseCredentialRepository.findAll()
                    .stream().map(dbCredential -> new DatabaseCredentialDTO(dbCredential))
                    .collect(Collectors.toList());
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

}
