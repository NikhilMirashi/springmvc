package com.investmentapp.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.investmentapp.model.Investment;

public class InvestMentMaper implements RowMapper<Investment> {

	@Override
	public Investment mapRow(ResultSet rs, int rowNum) throws SQLException {
		// get the values using resultset

		String planName = rs.getString("plan_name");
		String purpose = rs.getString("purpose");
		String nominee = rs.getString("nominee");
		String planType = rs.getString("type");
		String risk = rs.getString("risk");
		int term = rs.getInt("term");
		double amount = rs.getInt("amount");
		int planId = rs.getInt("plan_id");
		int entryAge = rs.getInt("entry_age");

		// set in the domain object

		Investment investment = new Investment();
		investment.setAmount(amount);
		investment.setEntryAge(entryAge);
		investment.setNominee(nominee);
		investment.setPlanId(planId);
		investment.setPlanName(planName);
		investment.setPurpose(purpose);
		investment.setRisk(risk);
		investment.setTerm(term);
		investment.setType(planType);

		return investment;
	}

}
