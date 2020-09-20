package com.codegym.dao.repository;


import com.codegym.dao.entity.Equipment;
import com.codegym.dao.entity.Floor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface FloorRepository extends JpaRepository<Floor,Integer> {
    List<Floor> findAllByDeleteFlagIsNull();
    Page<Floor> findAllByDeleteFlagIsNull(Pageable pageable);
    Page<Floor> findAllByDeleteFlagIsNullAndNameFloorContaining(String nameFloor,Pageable pageable);

    Page<Floor> findAllByDeleteFlagIsNullAndBuildingIdIs(Integer buildingId, Pageable pageable);

    Floor findAllByDeleteFlagIsNullAndIdIs(Integer id);

    @Query(value="select f from Floor f where f.building.fullName like %?1% and f.nameFloor like %?2% and f.area>=?3 and f.typeFloor.nameTypeFloor like %?4% and f.deleteFlag is null order by f.id")
    Page<Floor> searchAll(String nameBuilding, String nameFloor, Integer area,
                              String typeFloor_nameFloor, Pageable pageable);
}
