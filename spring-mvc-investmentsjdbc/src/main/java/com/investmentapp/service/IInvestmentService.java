package com.investmentapp.service;

import java.util.List;

import com.investmentapp.exceptions.PlanNotFoundException;
import com.investmentapp.model.Investment;

public interface IInvestmentService {

	void addInvestment(Investment investment);
	void updateInvestment(int planId, double amount) throws PlanNotFoundException;
	void deleteInvestment(int planId);
	List<Investment> getByRiskAndTerm(String risk, int term);
	List<Investment> getByType(String type);
	List<Investment> getByPurpose(String purpose);
	List<Investment> getAll();
	Investment getById(int planId) throws PlanNotFoundException;
	double calculateMaturity(Investment investment);

}
