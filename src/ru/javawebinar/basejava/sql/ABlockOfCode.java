package ru.javawebinar.basejava.sql;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface ABlockOfCode {
    Object accept(PreparedStatement ps)  throws SQLException;
}
