package com.investmentapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.investmentapp.exceptions.PlanNotFoundException;
import com.investmentapp.model.Investment;
import com.investmentapp.repository.IIvestmentRepository;

@Service
public class InvestmentServiceImpl implements IInvestmentService {

	private IIvestmentRepository investmentRepository;

	@Autowired
	public void setInvestmentRepository(IIvestmentRepository investmentRepository) {
		this.investmentRepository = investmentRepository;
	}

	@Override
	public void addInvestment(Investment investment) {
		investmentRepository.addInvestment(investment);
	}

	@Override
	public void updateInvestment(int planId, double amount) {
		investmentRepository.updateInvestment(planId, amount);

	}

	@Override
	public void deleteInvestment(int planId) {
		investmentRepository.deleteInvestment(planId);

	}

	@Override
	public List<Investment> getByRiskAndTerm(String risk, int term) {
		return investmentRepository.deleteInvestment(planId);;
	}

	@Override
	public List<Investment> getByType(String type) {
		return investmentRepository.findByType(type);
	}

	@Override
	public List<Investment> getByPurpose(String purpose) {
		return investmentRepository.findByPurpose(purpose);
	}

	@Override
	public List<Investment> getAll() {
		return investmentRepository.findAll();
	}

	@Override
	public double calculateMaturity(Investment investment) {
		return 0;
	}

	@Override
	public Investment getById(int planId) {
		Investment investment = investmentRepository.findById(planId);
		if (investment == null) {
			throw new PlanNotFoundException("Invalid Id");
		}
		return investment;
	}

}
