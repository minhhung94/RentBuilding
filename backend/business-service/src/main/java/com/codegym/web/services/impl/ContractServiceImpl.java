package com.codegym.web.services.impl;

import com.codegym.dao.dto.ContractDTO;
import com.codegym.dao.entity.*;
import com.codegym.dao.repository.ContractRepository;
import com.codegym.dao.repository.CustomerRepository;
import com.codegym.dao.repository.EmployeeRepository;
import com.codegym.dao.repository.GroundRepository;
import com.codegym.web.services.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ContractServiceImpl implements ContractService {


    @Autowired
    ContractRepository contractRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    GroundRepository groundRepository;


    @Override
    public List<Contract> findAllByDeleteFlagIsNull() {
        return contractRepository.findAllByDeleteFlagIsNull();
    }

    @Override
    public ContractDTO findAllByDeleteFlagIsNullAndIdIs(Integer id) {
        Contract contract = contractRepository.findAllByDeleteFlagIsNullAndIdIs(id);
        if (contract != null) {
            ContractDTO contractDTO = new ContractDTO();
            contractDTO.setId(contract.getId());
            contractDTO.setEmployeeId(contract.getEmployee().getId());
            contractDTO.setCustomerId(contract.getCustomer().getId());
            contractDTO.setGroundId(contract.getGround().getId());
            contractDTO.setUrlImage(contract.getUrlImage());
            contractDTO.setTerm(contract.getTerm());
            contractDTO.setStatusContract(contract.getStatusContract());
            contractDTO.setStartRentDay(contract.getStartRentDay());
            contractDTO.setEndRentDay(contract.getEndRentDay());
            contractDTO.setPrice(contract.getPrice());
            contractDTO.setTotal(contract.getTotal());
            contractDTO.setDeposits(contract.getDeposits());
            contractDTO.setTaxCode(contract.getTaxCode());
            contractDTO.setContent(contract.getContent());
            contractDTO.setUnified(contract.getUnified());
            return contractDTO;
        }
        return null;
    }

    @Override
    public Contract findById(Integer id) {
        return contractRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        Contract contract = contractRepository.findAllByDeleteFlagIsNullAndIdIs(id);
        contract.setDeleteFlag(1);
        contractRepository.save(contract);
    }

    @Override
    public void save(ContractDTO contractDTO) {
        Contract contract = new Contract();
        contract.setId(contractDTO.getId());
        contract.setEmployee(employeeRepository.findAllByDeleteFlagIsNullAndIdIs(contractDTO.getEmployeeId()));
        contract.setCustomer(customerRepository.findAllByDeleteFlagIsNullAndIdIs(contractDTO.getCustomerId()));
        contract.setGround(groundRepository.findAllByDeleteFlagIsNullAndIdIs(contractDTO.getGroundId()));
        contract.setUrlImage(contractDTO.getUrlImage());
        contract.setTerm(contractDTO.getTerm());
        contract.setStatusContract(contractDTO.getStatusContract());
        contract.setStartRentDay(contractDTO.getStartRentDay());
        contract.setEndRentDay(contractDTO.getEndRentDay());
        contract.setPrice(contractDTO.getPrice());
        contract.setTotal(contractDTO.getTotal());
        contract.setDeposits(contractDTO.getDeposits());
        contract.setTaxCode(contractDTO.getTaxCode());
        contract.setContent(contractDTO.getContent());
        contract.setUnified(contractDTO.getUnified());
        contractRepository.save(contract);


    }


    @Override
    public void updateContract(ContractDTO contractDTO) {
        Contract contract = contractRepository.findAllByDeleteFlagIsNullAndIdIs(contractDTO.getId());
        contract.setId(contractDTO.getId());
        contract.setEmployee(employeeRepository.findAllByDeleteFlagIsNullAndIdIs(contractDTO.getEmployeeId()));
        contract.setCustomer(customerRepository.findAllByDeleteFlagIsNullAndIdIs(contractDTO.getCustomerId()));
        contract.setGround(groundRepository.findAllByDeleteFlagIsNullAndIdIs(contractDTO.getGroundId()));
        contract.setUrlImage(contractDTO.getUrlImage());
        contract.setTerm(contractDTO.getTerm());
        contract.setStatusContract(contractDTO.getStatusContract());
        contract.setStartRentDay(contractDTO.getStartRentDay());
        contract.setEndRentDay(contractDTO.getEndRentDay());
        contract.setPrice(contractDTO.getPrice());
        contract.setTotal(contractDTO.getTotal());
        contract.setDeposits(contractDTO.getDeposits());
        contract.setTaxCode(contractDTO.getTaxCode());
        contract.setContent(contractDTO.getContent());
        contract.setUnified(contractDTO.getUnified());
        contractRepository.save(contract);
    }

    @Override
    public Page<Contract> getContracts(String nameCustomer, Pageable pageable) {
        return contractRepository.findAllByDeleteFlagIsNullAndCustomerNameContainingIgnoreCase(nameCustomer, pageable);
    }

    @Override
    public Page<Contract> searchAnything(String fullName, String codeGround, Date startRentDay, Date endRentDay, Pageable pageable) {
        return contractRepository.searchAnything(fullName, codeGround, startRentDay, endRentDay, pageable);
    }


}
