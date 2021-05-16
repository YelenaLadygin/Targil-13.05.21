package com.example.demo.Spring;

import java.sql.*;
import java.util.ArrayList;

public class SpecialDayDAO {

        private String m_conn;

        public SpecialDayDAO (String m_conn) {
            this.m_conn = m_conn;
        }

        public void insertSpday(SpecialDay c) {
            try (Connection conn = DriverManager.getConnection(m_conn)) {
                if (conn != null) {

                    String sql = String.format("INSERT INTO SpecialDays (id,name,day,month) " +
                            "VALUES ( '%d', %s,%d, %d )",c.getId(), c.getSpDname(), c.getDay(),c.getMonth());
                    Statement stmt = conn.createStatement();

                    stmt.executeUpdate(sql);
                }
            }
            catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        public void updateSpday(SpecialDay c, int id) {
            try (Connection conn = DriverManager.getConnection(m_conn)) {
                if (conn != null) {
                    String sql = String.format(
                            "UPDATE SpecialDays set name = '%s',day = %d, month = %d " +
                                    " WHERE id = %d"
                            , c.getSpDname(), c.getDay(), c.getMonth(),id);
                    Statement stmt = conn.createStatement();

                    stmt.executeUpdate(sql);
                }
            }
            catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        public void deleteSpday (int id) {
            try (Connection conn = DriverManager.getConnection(m_conn)) {
                if (conn != null) {
                    String sql = String.format("DELETE from SpecialDays where id = " + id);
                    Statement stmt = conn.createStatement();

                    stmt.executeUpdate(sql);
                }
            }
            catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        public ArrayList<SpecialDay> getAllspdays(){

            ArrayList<SpecialDay> spdays = new ArrayList<>();

            try (Connection conn = DriverManager.getConnection(m_conn)) {

                if (conn != null) {

                    String sql = "SELECT * FROM SpecialDays";

                    Statement stmt = conn.createStatement();

                    ResultSet rs = stmt.executeQuery(sql);
                    while (rs.next()) {
                        SpecialDay e = new SpecialDay(
                                rs.getInt("id"),
                                rs.getString("name"),
                                rs.getInt("day"),
                                rs.getInt("month"));
                        spdays.add(e);
                    }
                }
            }
            catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            return  spdays;
        }

        public SpecialDay getSpdayById(int id){
            // try to connect to db
            try (Connection conn = DriverManager.getConnection(m_conn)) {
                // check if connection succeed
                if (conn != null) {

                    // prepare query string
                    String sql = String.format("Select * from SpecialDays where id= %d", id );

                    // prepare statement
                    Statement stmt = conn.createStatement();

                    // fire query
                    ResultSet rs = stmt.executeQuery(sql);

                    // read results
                    while (rs.next()) {
                        SpecialDay e = new SpecialDay (
                                rs.getInt("id"),
                                rs.getString("name"),
                                rs.getInt("day"),
                                rs.getInt("month"));
                        return e;
                    }
                }
            }
            catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            return null;

        }
    }

