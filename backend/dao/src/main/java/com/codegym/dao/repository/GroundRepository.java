package com.codegym.dao.repository;



import com.codegym.dao.entity.Ground;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface GroundRepository extends JpaRepository<Ground,Integer> {
    List<Ground> findAllByDeleteFlagIsNull();
    Page<Ground> findAllByDeleteFlagIsNull(Pageable pageable);
    Page<Ground> findAllByDeleteFlagIsNullAndCodeGroundContaining(String codeGround,Pageable pageable);

    Ground findAllByDeleteFlagIsNullAndIdIs(Integer id);

    @Query(value="select g from Ground g where g.floor.nameFloor like %?1% and g.codeGround like %?2% and g.area>=?3 and g.typeGround.nameTypeGround like %?4% and g.deleteFlag is null order by g.id")
    Page<Ground> searchAll(String nameFloor, String codeGround, Integer area,
                          String typeGround_nameGround, Pageable pageable);
}
