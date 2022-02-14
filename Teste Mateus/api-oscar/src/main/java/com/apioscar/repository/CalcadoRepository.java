package com.apioscar.repository;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.apioscar.model.Calcado;

public interface CalcadoRepository extends JpaRepository<Calcado, Long> {
	
	@Query("select c from Calcado c where (:tamanhoCalcado is null or c.tamanhoCalcado=:tamanhoCalcado) and "
			+ "(:categoriaCalcado is null or LOWER(c.categoriaCalcado) LIKE %:categoriaCalcado%) and "
			+ "(:corCalcado is null or LOWER(c.corCalcado) LIKE %:corCalcado%) and "
			+ "(:precoCalcado is null or c.precoCalcado=:precoCalcado) and "
			+ "(:marcaCalcado is null or LOWER(c.marcaCalcado) LIKE %:marcaCalcado%) and "
			+ "(cast(cast(:dataCadCalcado as text) as date) is null or c.dataCadCalcado= cast(cast(:dataCadCalcado as text) as date)) and "
			+ "(:descricaoCalcado is null or LOWER(c.descricaoCalcado) LIKE %:descricaoCalcado%)")
	ArrayList<Calcado> findAllCalcados(@Param("tamanhoCalcado") String tamanhoCalcado,
			@Param("categoriaCalcado") String categoriaCalcado,
			@Param("corCalcado") String corCalcado,
			@Param("precoCalcado") BigDecimal precoCalcado,
			@Param("marcaCalcado") String marcaCalcado,
			@Param("dataCadCalcado") Date dataCadCalcado,
			@Param("descricaoCalcado") String descricaoCalcado);
}
