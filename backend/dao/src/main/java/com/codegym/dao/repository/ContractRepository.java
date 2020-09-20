package com.codegym.dao.repository;

import com.codegym.dao.dto.ReportDTO;
import com.codegym.dao.dto.ReportInt;
import com.codegym.dao.entity.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.lang.annotation.Native;
import java.util.Date;
import java.util.List;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Integer> {
    List<Contract> findAllByDeleteFlagIsNull();

    Contract findAllByDeleteFlagIsNullAndIdIs(Integer id);

    Page<Contract> findAllByDeleteFlagIsNull(Pageable pageable);

    Page<Contract> findAllByDeleteFlagIsNullAndCustomerNameContainingIgnoreCase(String fullName, Pageable pageable);


    @Query(value = "SELECT c " +
            "FROM Contract c " +
            "where c.customer.name like %?1% " +
            "and c.ground.codeGround like %?2% " +
            "and c.startRentDay>=?3 " +
            "and c.endRentDay<=?4 " +
            "and c.deleteFlag is null " +
            "order by c.id")
    Page<Contract> searchAnything(String fullName, String codeGround, Date startRentDay, Date endRentDay, Pageable pageable);

    //    @Query(value = "select g.code_ground as 'codeGroundCal', sum(total ) as 'totalCal' from ground g left join contract c on c.id_ground = g.id_ground group by g.id_ground",nativeQuery = true)
    @Query(value = "select g.code_ground as 'codeGroundCal', IF(SUM(total) IS NULL, 0, SUM(total))  as 'totalCal'  from ground g left join contract c on c.id_ground = g.id_ground group by g.id_ground", nativeQuery = true)
    List<ReportInt> searchAllReport();

    @Query(value = "select g.code_ground as 'codeGroundCal', IF(SUM(total) IS NULL, 0, SUM(total))  as 'totalCal'  from ground g left join contract c on c.id_ground = g.id_ground group by g.id_ground  having totalCal>=15000000", nativeQuery = true)
    List<ReportInt> searchAllReportHigh();

    @Query(value = "select g.code_ground as 'codeGroundCal', IF(SUM(total) IS NULL, 0, SUM(total))  as 'totalCal'  from ground g left join contract c on c.id_ground = g.id_ground group by g.id_ground  having totalCal<15000000", nativeQuery = true)
    List<ReportInt> searchAllReportLow();

        @Query(value = "select g.code_ground as 'codeGroundCal',\n" +
            "COALESCE(sum(c.total), 0) as 'totalCal' \n" +
            "from ground g left join contract c \n" +
            "on c.id_ground = g.id_ground \n" +
            "where COALESCE(c.start_rent_day,'1900-01-01') >= ?1 and COALESCE(c.end_rent_day,'2030-01-01') <= ?2 \n" +
            "group by g.id_ground \n" +
            "having totalCal>=?3 and totalCal <=?4 and codeGroundCal like %?5% ", nativeQuery = true)
//    @Query(value = "SELECT g.codeGround as codeGroundCal,coalesce(sum(c.total),0 )as totalCal FROM Ground g left join Contract c on c.ground.id = g.id where c.startRentDay >=?1 and c.endRentDay <= ?2 group by g.id having totalCal>=?3 and totalCal<=?4 and codeGroundCal like %?5% ")
    List<ReportInt> searchReportWithAny(Date startRentDay, Date endRentDay, Double minTotal, Double maxTotal, String codeGround);
}
