package com.investmentapp.repository;

import java.util.List;

import com.investmentapp.model.Investment;

public interface IIvestmentRepository {

	void addInvestment(Investment investment);

	void updateInvestment(int planId, double amount);

	void deleteInvestment(int planId);

	List<Investment> findByRiskAndTerm(String risk, int term);

	List<Investment> findByType(String type);

	List<Investment> findByPurpose(String purpose);

	List<Investment> findAll();

	Investment findById(int planId);

	double calculateMaturity(Investment investment);

}
