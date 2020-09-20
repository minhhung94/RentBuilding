package com.codegym.dao.repository;


import com.codegym.dao.entity.Services;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.Date;
import java.util.List;

@Repository
public interface ServicesRepository extends JpaRepository<Services, Integer> {
    List<Services> findAll();
    Services findAllByIdIs(Integer id);

    Page<Services> findAllByConsumeBeforeAndPriceBeforeAndMonthYearBeforeAndContract_Customer_NameContaining(Integer consume, Integer price, Date monthYear, String contract_customer_name, Pageable pageable);
//    @Query(value = "SELECT s FROM Services s where s.consume>=?1 and s.price>=?2 and s.monthYear>=?3 and s.contract.customer.name like %?4% order by s.nameService" )
    @Query(value = "SELECT s " +
            "FROM Services s " +
            "where s.consume>=?1" +
            "and s.price>=?2" +
            "and s.monthYear>=?3 " +
            "and s.contract.customer.name like %?4%" +
            "order by s.nameService")
    Page<Services> searchAndPage(Integer consume, Integer price, Date monthYear, String nameCustomer, Pageable pageable);

    @Query(value="select s from Services s where s.nameService like %?1% and s.periodic " +
            "like %?2% and s.consume>=?3 and s.monthYear>=?4 order by s.id")
    Page<Services> searchAll(String nameService, String periodic, Integer consume,
                             Date monthYear, Pageable pageable);

    Page<Services> findAllByNameServiceAndPeriodicAndConsumeAndMonthYearAfterAndContract_Customer_DeleteFlagIsNull(String nameService, String periodic, Integer consume, Date monthYear, Pageable pageable);
    Page<Services> findAllByMonthYearBetweenAndContract_Id(Date monthYear, Date monthYear2, Integer contractId, Pageable pageable);

    @Query(value = "select s from Services s where s.contract.id = ?1 and s.monthYear between ?2 and ?3 ")
    Page<Services> searchServiceIdContract(Integer idContract, Date startDate, Date endDate,Pageable pageable);

    @Query(value="select distinct ns.nameService from Services ns ")
    List<String> searchAllDistinct();

    List<Services> findAllByMonthYearAndContract_Id(Date monthYear, Integer contract_id);

    @Query(value="select s from Services s where s.contract.id=?1 and " +
            "s.nameService like ?2 and s.monthYear between ?3 and ?4 order by s.id")
    Page<Services> searchInformationService(Integer idContract,String nameService,
                                            Date startDate, Date endDate, Pageable pageable);
}
