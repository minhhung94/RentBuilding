package com.codegym.dao.repository;

import com.codegym.dao.dto.EquipmentDTO;
import com.codegym.dao.entity.Equipment;
import com.codegym.dao.entity.Ground;
import com.codegym.dao.entity.TypeEquipment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, Integer> {
    List<Equipment> findAllByDeleteFlagIsNull();
//    EquipmentDTO getEquipmentById(Integer id);
    Equipment findAllByDeleteFlagIsNullAndIdIs(Integer id);
    Page<Equipment> findAllByDeleteFlagIsNullAndNameEquipmentContaining(String nameEquipment, Pageable pageable);
    Page<Equipment> findAllByNameEquipmentContainingOrAmountContainingOrGround_CodeGroundOrTypeEquipment_NameType(String nameEquipment, Integer amount, String ground_codeGround, String typeEquipment_nameType, Pageable pageable);
//    Page<Equipment> findAllByDeleteFlagIsNullAndNameEquipmentContainingOrAmountContainingOrGround_CodeGroundOrTypeEquipment_NameType(String nameEquipment, Integer amount, String ground_codeGround, String typeEquipment_nameType, Pageable pageable);
    Page<Equipment> findAllByNameEquipmentContainingOrAmountContainingOrGround_IdContainingOrTypeEquipment_IdContaining(String nameEquipment, Integer amount, Integer ground_id, Integer typeEquipment_id, Pageable pageable);

    @Query(value = "SELECT e FROM Equipment e where e.nameEquipment like %?1% and e.amount>=?2 and e.ground.codeGround like %?3% and e.typeEquipment.nameType like %?4%  and e.deleteFlag is null order by e.typeEquipment.nameType" )
    Page<Equipment> searchAll(String nameEquipment, Integer amount, String ground_codeGround, String typeEquipment_nameType, Pageable pageable);
}
