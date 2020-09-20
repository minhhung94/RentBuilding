package com.codegym.dao.repository;

import com.codegym.dao.entity.Building;
import com.codegym.dao.entity.Floor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuildingRepository extends JpaRepository<Building,Integer> {
    List<Building> findAllByDeleteFlagIsNull();
    Page<Building> findAllByDeleteFlagIsNull(Pageable pageable);
    Page<Building> findAllByDeleteFlagIsNullAndFullNameContaining(String fullName,Pageable pageable);

    Building findAllByDeleteFlagIsNullAndIdIs(Integer id);

    @Query(value="select b from Building b where b.fullName like %?1% and b.taxCode like %?2% and b.phone like %?3% and b.address like %?4% and b.deleteFlag is null order by b.id")
    Page<Building> searchAll(String nameBuilding, String taxCode, String phone,
                          String address, Pageable pageable);

}
