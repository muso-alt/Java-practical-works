package SQL;

import java.sql.*;

public class SQLMain {
    /**
     * @param args
     */
    public static void main(String[] args) {
        String groupName = "Группа 1"; // заданный параметр группы
        int dolgCount = 3; // заданное значение количества долгов
        
        // формируем инструкцию SQL для выборки студентов из таблицы T_Student
        String sql = "SELECT id_student, first_name, last_name, id_Group " +
                     "FROM t_student " +
                     "WHERE id_group = '" + groupName + "' AND dolg_count > " + dolgCount;
                     
        // формируем инструкцию SQL для вставки строк в таблицу T_GroupSelected
        String insertSql = "INSERT INTO T_GroupSelected (id_student, first_name, last_name, id_group) VALUES ";
        
        try {
            // устанавливаем соединение с базой данных
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
            
            // создаем объект Statement для выполнения запросов к базе данных
            Statement stmt = conn.createStatement();
            
            // выполняем запрос на выборку студентов из таблицы T_Student
            ResultSet rs = stmt.executeQuery(sql);
            
            // обрабатываем результаты запроса
            boolean firstRow = true;
            while (rs.next()) {
                // добавляем новую строку в инструкцию SQL для вставки строк в таблицу T_GroupSelected
                if (firstRow) {
                    firstRow = false;
                } else {
                    insertSql += ", ";
                }
                insertSql += "('" + rs.getString("id_student") + "', '" + rs.getString("first_name") + "', '" + rs.getString("last_name") + "', '" + rs.getString("id_group") + "')";
            }
            
            // если были найдены студенты, вставляем строки в таблицу T_GroupSelected
            if (!firstRow) {
                stmt.executeUpdate(insertSql);
            }
            
            // закрываем ресурсы
            rs.close();
            stmt.close();
            conn.close();

            System.out.println("Succesfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}