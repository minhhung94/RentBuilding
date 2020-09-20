package com.codegym.web.services;


import com.codegym.dao.dto.ServicesDTO;
import com.codegym.dao.entity.Services;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.Date;
import java.util.List;

public interface ServicesService {
    List<Services> findAll();
    Page<Services> searchAndPage(Integer consume, Integer price, Date monthYear, String nameCustomer, Pageable pageable);
    Page<Services> findAllByConsumeBeforeAndPriceBeforeAndMonthYearBeforeAndContract_Customer_NameContaining(Integer consume, Integer price, Date monthYear, String contract_customer_name, Pageable pageable);

    ServicesDTO findAllByIdIs(Integer id);
    void save(ServicesDTO servicesDTO);
    void remove(Integer id);

    void updateService(ServicesDTO servicesDTO);

    Page<Services> searchAll(String nameService, String periodic, Integer consume,
                             Date monthYear, Pageable pageable);

    Page<Services> searchServiceIdContract(Integer idContract, Date startDate, Date endDate, Pageable pageable);

    Page<Services> findAllByMonthYearBetweenAndContract_Id(Date monthYear, Date monthYear2, Integer contractId, Pageable pageable);

    List<String> searchAllDistinct();

    List<Services> findAllByMonthYearAndContract_Id(Date monthYear, Integer contract_id);
    Page<Services> searchInformationService(Integer idContract,String nameService,
                                            Date startDate, Date endDate, Pageable pageable);
}
