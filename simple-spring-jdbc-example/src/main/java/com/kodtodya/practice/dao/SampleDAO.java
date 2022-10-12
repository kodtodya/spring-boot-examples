/**
 *
 */
package com.kodtodya.practice.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * @author Lee_Vettleson
 *
 */
@Repository
public class SampleDAO {

    private static final Logger log = LoggerFactory.getLogger(SampleDAO.class);

    private JdbcTemplate jdbcTemplate;

    /**
     * We'll wrap the datasource in a Spring JdbcTemplate object
     *
     * @param ds
     */
    @Autowired
    protected void setDatasource(DataSource ds) {
        jdbcTemplate = new JdbcTemplate(ds);
    }

    /**
     * Create a table in the database
     */
    public boolean createTable() {
        boolean success = false;

        try {
            jdbcTemplate.execute("CREATE TABLE sample_table (id INT IDENTITY, first_name VARCHAR(30), last_name VARCHAR(30), age INT)");
            log.info("Creating sample_table");
            success = true;
        } catch (DataAccessException e) {
            log.error("Unable to create the sample_table", e);
        }
        return success;
    }

    /**
     * Remove our sample table
     *
     * @return
     */
    public boolean dropTable() {
        boolean success = false;

        try {
            jdbcTemplate.execute("DROP TABLE sample_table");
            log.info("Deleting sample_table");
            success = true;
        } catch (DataAccessException e) {
            log.error("Unable to create the sample_table", e);
        }
        return success;
    }

    /**
     * Insert a person into the database
     *
     * @param firstName
     * @param lastName
     * @return
     */
    public boolean insertPerson(SamplePerson person) {
        boolean success = false;

        if (person != null) {
            log.debug("insertPerson({} {})", person.getFirstName(), person.getLastName());
            try {
                success = jdbcTemplate.update("INSERT INTO sample_table VALUES (null, ?, ?, ?)", person.getFirstName(), person.getLastName(), person.getAge()) == 1; // success means exactly one row inserted
            } catch (DataAccessException e) {
                log.error("Unable to insert" + person.getFirstName() + " " + person.getLastName() + "into the table", e);
            }
        }
        return success;
    }

    /* ResultSet -> SamplePerson converter */
    private RowMapper<SamplePerson> personMapper = new RowMapper<SamplePerson>() {
        public SamplePerson mapRow(ResultSet rs, int rowNum) throws SQLException {
            SamplePerson person = new SamplePerson();
            person.setId(rs.getInt("id"));
            person.setFirstName(rs.getString("first_name"));
            person.setLastName(rs.getString("last_name"));
            person.setAge(rs.getInt("age"));
            return person;
        }
    };

    /**
     * Get all the people stored in the database
     *
     * @return
     */
    public List<SamplePerson> getAllPeople() {
        log.debug("getAllPeople()");

        return jdbcTemplate.query("SELECT * FROM sample_table", personMapper);
    }

    /**
     * Get a person by their unique ID
     *
     * @param id
     * @return
     */
    public SamplePerson getPersonById(int id) {
        log.debug("getPersonById({})", id);
        return jdbcTemplate.queryForObject("SELECT * FROM sample_table WHERE id = ?", personMapper, id);
    }
}
