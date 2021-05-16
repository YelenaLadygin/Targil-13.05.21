package com.example.demo.Spring;

import java.sql.*;
import java.util.ArrayList;

public class HolidayDAO {

        private String m_conn;

        public HolidayDAO (String m_conn) {
            this.m_conn = m_conn;
        }

        public void insertHoliday(Holiday c) {
            try (Connection conn = DriverManager.getConnection(m_conn)) {
                if (conn != null) {

                    String sql = String.format("INSERT INTO Holidays (id,name,day,month,length) " +
                            "VALUES ( '%d', %s,%d, %d,%d )",c.getId(), c.getHolidayname(), c.getDay(),c.getMonth(), c.getLength());
                    Statement stmt = conn.createStatement();

                    stmt.executeUpdate(sql);
                }
            }
            catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        public void updateHolidayName (Holiday c, int id) {
            try (Connection conn = DriverManager.getConnection(m_conn)) {
                if (conn != null) {
                    String sql = String.format(
                            "UPDATE Holidays set name = '%s',day = %d, month = %d, lenth= %d " +
                                    " WHERE id = %d"
                            , c.getHolidayname(), c.getDay(), c.getMonth(),c.getLength(),id);
                    Statement stmt = conn.createStatement();

                    stmt.executeUpdate(sql);
                }
            }
            catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        public void deleteHoliday(int id) {
            try (Connection conn = DriverManager.getConnection(m_conn)) {
                if (conn != null) {
                    String sql = String.format("DELETE from Holidays where id = " + id);
                    Statement stmt = conn.createStatement();

                    stmt.executeUpdate(sql);
                }
            }
            catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        public ArrayList<Holiday> getAllHolidays(){

            ArrayList<Holiday> holidays = new ArrayList<>();

            try (Connection conn = DriverManager.getConnection(m_conn)) {

                if (conn != null) {

                    String sql = "SELECT * FROM Holidays";

                    Statement stmt = conn.createStatement();

                    ResultSet rs = stmt.executeQuery(sql);
                    while (rs.next()) {
                        Holiday e = new Holiday(
                                rs.getInt("id"),
                                rs.getString("name"),
                                rs.getInt("day"),
                                rs.getInt("month"),
                                rs.getInt("length"));
                        holidays.add(e);
                    }
                }
            }
            catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            return  holidays;
        }

        public Holiday getHolidayById(int id){
            // try to connect to db
            try (Connection conn = DriverManager.getConnection(m_conn)) {
                // check if connection succeed
                if (conn != null) {

                    // prepare query string
                    String sql = String.format("Select * from Holidays where id= %d", id );

                    // prepare statement
                    Statement stmt = conn.createStatement();

                    // fire query
                    ResultSet rs = stmt.executeQuery(sql);

                    // read results
                    while (rs.next()) {
                        Holiday e = new Holiday(
                                rs.getInt("id"),
                                rs.getString("name"),
                                rs.getInt("day"),
                                rs.getInt("month"),
                                rs.getInt("length"));
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

