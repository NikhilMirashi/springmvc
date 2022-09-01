package com.investmentapp.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.investmentapp.model.Investment;
import com.investmentapp.util.DBQueries;

@Repository
public class InvestmentRepositoryImpl implements IIvestmentRepository {

	private JdbcTemplate jdbcTemplate;

	@Autowired // RightApporach
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void addInvestment(Investment investment) {

		Object[] investmentArray = { investment.getPlanName(), investment.getEntryAge(), investment.getType(),
				investment.getAmount(), investment.getPurpose(), investment.getRisk(), investment.getNominee(),
				investment.getTerm() };

		jdbcTemplate.update(DBQueries.INSERTQUERY, investmentArray);

	}

	@Override
	public void updateInvestment(int planId, double amount) {

		jdbcTemplate.update(DBQueries.UPDATEQUERY, amount, planId);

	}

	@Override
	public void deleteInvestment(int planId) {
		jdbcTemplate.update(DBQueries.DELTEQUERY, planId);

	}

	@Override
	public List<Investment> findByRiskAndTerm(String risk, int term) {
		return null;
	}

	// Using AnnonymousInnerClass
	@Override
	public List<Investment> findByType(String type) {

		List<Investment> investments = jdbcTemplate.query(DBQueries.SELECTBYTYPE, new RowMapper<Investment>() {
			@Override
			public Investment mapRow(ResultSet rs, int rowNum) throws SQLException {
				Investment investment = new Investment();
				investment.setPlanName(rs.getString("plan_name"));
				investment.setPurpose(rs.getString("purpose"));
				investment.setNominee(rs.getString("nominee"));
				investment.setType(rs.getString("type"));
				investment.setRisk(rs.getString("risk"));
				investment.setTerm(rs.getInt("term"));
				investment.setAmount(rs.getInt("amount"));
				investment.setPlanId(rs.getInt("plan_id"));
				investment.setEntryAge(rs.getInt("entry_age"));
				return investment;
			}

		}, type);

		return investments;
	}

	// Using LamdaExpressions
	@Override
	public List<Investment> findByPurpose(String purpose) {
		List<Investment> investments = jdbcTemplate.query(DBQueries.SELECTBYPURPOSE, (rs, rowNum) -> {

			Investment investment = new Investment();
			investment.setPlanName(rs.getString("plan_name"));
			investment.setPurpose(rs.getString("purpose"));
			investment.setNominee(rs.getString("nominee"));
			investment.setType(rs.getString("type"));
			investment.setRisk(rs.getString("risk"));
			investment.setTerm(rs.getInt("term"));
			investment.setAmount(rs.getInt("amount"));
			investment.setPlanId(rs.getInt("plan_id"));
			investment.setEntryAge(rs.getInt("entry_age"));
			return investment;

		}, purpose);

		return investments;
	}

	@Override
	public List<Investment> findAll() {

		RowMapper<Investment> mapper = new InvestMentMaper();
		List<Investment> investments = jdbcTemplate.query(DBQueries.SELECTQUERY, mapper);

		return investments;
	}

	@Override
	public Investment findById(int planId) {

		Investment ninvestment = jdbcTemplate.queryForObject(DBQueries.SELECTBYID, (rs, rowNum) -> {

			Investment investment = new Investment();
			investment.setPlanName(rs.getString("plan_name"));
			investment.setPurpose(rs.getString("purpose"));
			investment.setNominee(rs.getString("nominee"));
			investment.setType(rs.getString("type"));
			investment.setRisk(rs.getString("risk"));
			investment.setTerm(rs.getInt("term"));
			investment.setAmount(rs.getInt("amount"));
			investment.setPlanId(rs.getInt("plan_id"));
			investment.setEntryAge(rs.getInt("entry_age"));

			return investment;

		}, planId);

		return ninvestment;
	}

	@Override
	public double calculateMaturity(Investment investment) {
		return 0;
	}

}
