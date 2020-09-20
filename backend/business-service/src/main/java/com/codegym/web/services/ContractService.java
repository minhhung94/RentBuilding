package com.codegym.web.services;

import com.codegym.dao.dto.ContractDTO;
import com.codegym.dao.entity.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

public interface ContractService {

    List<Contract> findAllByDeleteFlagIsNull();

    ContractDTO findAllByDeleteFlagIsNullAndIdIs(Integer id);

    Contract findById(Integer id);

    void save(ContractDTO contractDTO);

    void delete(Integer id);

    void updateContract(ContractDTO contractDTO);

    Page<Contract> getContracts(String nameCustomer, Pageable pageable);

    Page<Contract> searchAnything(String fullName, String codeGround, Date startRentDay, Date endRentDay, Pageable pageable);


}
