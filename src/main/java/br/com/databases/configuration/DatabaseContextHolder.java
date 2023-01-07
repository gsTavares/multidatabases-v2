package br.com.databases.configuration;

import org.springframework.util.Assert;

import br.com.databases.router.entity.dto.DatabaseCredentialDTO;

public class DatabaseContextHolder {
    
    private static final ThreadLocal<DatabaseCredentialDTO> CONTEXT = 
    new ThreadLocal<>();

    public static void set(DatabaseCredentialDTO dbCredential) {
        Assert.notNull(dbCredential, "database credential can't be null");
        CONTEXT.set(dbCredential);
    }

    public static DatabaseCredentialDTO getDatabaseCredential() {
        return CONTEXT.get();
    }

    public static void clear() {
        CONTEXT.remove();   
    }
}
