package com.finance.portfolio_tracker.accesseur.jdbc.portefeuille.repository;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import java.sql.Statement;

import com.finance.portfolio_tracker.accesseur.jdbc.portefeuille.modele.PortefeuilleAccesseur;

@Repository
public class PortefeuilleRepositoryImpl implements PortefeuilleRepository {

    //Spring class that makes database access easier
    private final JdbcTemplate jdbcTemplate;    

    public PortefeuilleRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //for each row from database, creates object
    private final RowMapper<PortefeuilleAccesseur> rowMapper = (rs, rowNum) -> 
    PortefeuilleAccesseur.builder()
        .id(rs.getLong("id"))
        .nom(rs.getString("nom"))
        .devise(rs.getString("devise"))
        .build();

    @Override
    public PortefeuilleAccesseur save(PortefeuilleAccesseur portefeuille) {
    if (portefeuille.getId() == null) {
        return insert(portefeuille);
    } else {
        return update(portefeuille);
    }
}

private PortefeuilleAccesseur insert(PortefeuilleAccesseur portefeuille) {
    String sql = "INSERT INTO portefeuille (nom, devise) VALUES (?, ?)";
    //Captures the auto-generated ID from the database
    KeyHolder keyHolder = new GeneratedKeyHolder();
    
    jdbcTemplate.update(connection -> {
        PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        //replaces the 1 and 2 ?
        ps.setString(1, portefeuille.getNom());
        ps.setString(2, portefeuille.getDevise());
        return ps;
    }, keyHolder);
    //set the new id
    portefeuille.setId(keyHolder.getKey().longValue());
    return portefeuille;
}

private PortefeuilleAccesseur update(PortefeuilleAccesseur portefeuille) {
    String sql = "UPDATE portefeuille SET nom = ?, devise = ? WHERE id = ?";
    jdbcTemplate.update(sql, portefeuille.getNom(), portefeuille.getDevise(), portefeuille.getId());
    return portefeuille;
}

@Override
public Optional<PortefeuilleAccesseur> findById(Long id) {
    String sql = "SELECT id, nom, devise FROM portefeuille WHERE id = ?";
    List<PortefeuilleAccesseur> results = jdbcTemplate.query(sql, rowMapper, id);
    return results.isEmpty() ? Optional.empty() : Optional.of(results.get(0));
}

@Override
public List<PortefeuilleAccesseur> findAll() {
    //without WHERE returs all the rows
    String sql = "SELECT id, nom, devise FROM portefeuille";
    return jdbcTemplate.query(sql, rowMapper);
}

@Override
public void deleteById(Long id) {
    String sql = "DELETE FROM portefeuille WHERE id = ?";
    jdbcTemplate.update(sql, id);
}
}
