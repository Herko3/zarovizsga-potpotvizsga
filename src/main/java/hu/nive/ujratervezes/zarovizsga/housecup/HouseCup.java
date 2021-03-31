package hu.nive.ujratervezes.zarovizsga.housecup;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HouseCup {

    private MariaDbDataSource dataSource;

    public HouseCup(MariaDbDataSource dataSource) {
        this.dataSource = dataSource;
    }


    public int getPointsOfHouse(String houseName) {

        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement("SELECT * FROM house_points WHERE house_name = ?")
        ) {

            stmt.setString(1, houseName);
            return getPointsFromPreparedStatement(stmt);

        } catch (SQLException sql) {
            throw new IllegalStateException("Cannot connect", sql);
        }
    }

    private int getPointsFromPreparedStatement(PreparedStatement stmt) {
        int points = 0;

        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                points += rs.getInt("points_earned");
            }
        } catch (SQLException sql) {
            throw new IllegalStateException("Cannot query", sql);
        }
        return points;
    }
}
