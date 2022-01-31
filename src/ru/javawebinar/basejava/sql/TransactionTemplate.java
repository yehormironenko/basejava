package ru.javawebinar.basejava.sql;

import ru.javawebinar.basejava.exception.StorageException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionTemplate {

    public final ConnectionFactory connectionFactory;

    public TransactionTemplate(String dbUrl, String dbUser, String dbPassword) {
        connectionFactory = () -> DriverManager.getConnection(dbUrl, dbUser, dbPassword);
    }

    public Object action(String sql, ABlockOfCode aBlockOfCode) {
        try (Connection conn = connectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            return aBlockOfCode.accept(ps);
        } catch (SQLException e) {
            throw new StorageException(e);
        }
    }
}
