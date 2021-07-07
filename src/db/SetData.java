package db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class SetData {

    public void CRUD(String query) {

        Connection connection = DBConfig.getDatabaseConnection();

        try {
            Statement statement = connection.createStatement();
            statement.execute(query);
        } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    public void initial(){
        CRUD("CREATE TABLE IF NOT EXISTS pf "
                + "(id int primary key, nume varchar(40), cnp varchar(40), rez varchar(40), sc varchar(40), cet varchar(40))");
        CRUD("INSERT IGNORE INTO pf "
                + "VALUES (1, 'Ilie Popescu', '5006786492813', 'România', 'necăsătorit', 'română')");
        CRUD("INSERT IGNORE INTO pf "
                + "VALUES (2, 'Laura Popa', '2780408678234', 'Suedia', 'căsătorită', 'română')");
        CRUD("INSERT IGNORE INTO pf "
                + "VALUES (3, 'Andrei Popa', '17790672383', 'România', 'căsătorit', 'română')");
        CRUD("CREATE TABLE IF NOT EXISTS pj "
                + "(id int primary key, nume varchar(40), cif varchar(40), rez varchar(40), sed varchar(40), cs int)");
        CRUD("INSERT IGNORE INTO pj "
                + "VALUES (1, 'Universitatea din București', '168140', 'România', 'Șos. Panduri', 0)");
        CRUD("INSERT IGNORE INTO pj "
                + "VALUES (2, 'Coca Cola', '892782', 'SUA', 'Str. Garii', 9999999)");
        CRUD("INSERT IGNORE INTO pj "
                + "VALUES (3, '5 To Go', '909090', 'România', 'Str. Academiei', 200)");
        CRUD("CREATE TABLE IF NOT EXISTS conturi "
                + "(id int primary key, idtitular int, sold int)");
        CRUD("INSERT IGNORE INTO conturi "
                + "VALUES(1, 1, 50000)");
        CRUD("INSERT IGNORE INTO conturi "
                + "VALUES(2, 2, 900000)");
        CRUD("INSERT IGNORE INTO conturi "
                + "VALUES(3, 2, 100000)");
        CRUD("INSERT IGNORE INTO conturi "
                + "VALUES(4, 3, 60000)");
        CRUD("CREATE TABLE IF NOT EXISTS carduri "
                + "(id int primary key, idtitular int, idcont int)");
        CRUD("INSERT IGNORE INTO carduri "
                + "VALUES(1,2,1)");
        CRUD("INSERT IGNORE INTO carduri "
                + "VALUES(2,1,2)");
        CRUD("INSERT IGNORE INTO carduri "
                + "VALUES(3,1,3)");
        CRUD("INSERT IGNORE INTO carduri "
                + "VALUES(4,3,3)");

    }
}