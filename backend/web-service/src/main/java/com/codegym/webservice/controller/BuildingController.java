package com.codegym.webservice.controller;

import com.codegym.dao.dto.BuildingDTO;
import com.codegym.dao.entity.Building;
import com.codegym.dao.entity.Contract;
import com.codegym.dao.entity.Floor;
import com.codegym.web.services.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/buildings")
public class BuildingController {

    @Autowired
    private BuildingService buildingService;

    @GetMapping("")
    public List<Building> getAllBuilding() {
        List<Building> buildings;
        buildings = buildingService.findAllByDeleteFlagIsNull();
        return buildings;
    }
    @GetMapping(value = "/paging", params = {"page", "size", "search"})
    public Page<Building> getListBuilding(@RequestParam("page") int page,
                                          @RequestParam("size") int size,
                                          @RequestParam("search") String name) {
        Page<Building> buildings;
        buildings= buildingService.getBuildings(name, PageRequest.of(page,size));
        return buildings;
    }
    @GetMapping(value = "/paging", params = {"page", "size", "nameBuilding", "taxCode", "phone", "address"})
    public Page<Building> getListBuilding(@RequestParam("page") int page,
                                    @RequestParam("size") int size,
                                    @RequestParam(value = "nameBuilding",defaultValue = "") String nameBuilding,
                                    @RequestParam(value = "taxCode", defaultValue = "")  String taxCode,
                                    @RequestParam(value = "phone", defaultValue = "") String phone,
                                    @RequestParam(value = "address", defaultValue = "") String address) {
        Page<Building> buildings;
        buildings= buildingService.searchAll(nameBuilding,taxCode,phone, address,PageRequest.of(page, size));
        return buildings;
    }

    @GetMapping("/{id}")
    public ResponseEntity<BuildingDTO> getBuilding(@PathVariable("id") int id) {
        BuildingDTO buildingDTO = buildingService.findAllByDeleteFlagIsNullAndIdIs(id);
        if (buildingDTO != null) {
            return ResponseEntity.ok(buildingDTO);
        }
        return null;
    }


    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteBulding(@PathVariable("id") int id) {
        BuildingDTO building = buildingService.findAllByDeleteFlagIsNullAndIdIs(id);
        buildingService.remove(building.getId());
        Map<String, Boolean> response = new HashMap<>();
        response.put("delete", Boolean.TRUE);
        return response;
    }

    @PostMapping("")
    public ResponseEntity<?> createBuilding(@Valid @RequestBody BuildingDTO buildingDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return new ResponseEntity<List>(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
        buildingService.save(buildingDTO);
        return ResponseEntity.ok(buildingDTO);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateBuilding(@PathVariable(value = "id") Integer id, @RequestBody @Valid BuildingDTO buildingDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return new ResponseEntity<List>(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
        buildingService.updateBuilding(buildingDTO);
        return ResponseEntity.accepted().body(buildingDTO);
    }
}
