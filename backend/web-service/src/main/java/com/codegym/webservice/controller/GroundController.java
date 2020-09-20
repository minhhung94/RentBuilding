package com.codegym.webservice.controller;

import com.codegym.dao.dto.GroundDTO;
import com.codegym.dao.entity.Floor;
import com.codegym.dao.entity.Ground;
import com.codegym.web.services.GroundService;
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
@RequestMapping("/grounds")
public class GroundController {
    @Autowired
    private GroundService groundService;

    @GetMapping("")
    public List<Ground> getAllGround() {
        List<Ground> grounds;
        grounds = groundService.findAllByDeleteFlagIsNull();
        return grounds;
    }
    @GetMapping(value = "/paging", params = {"page", "size", "search"})
    public Page<Ground> getListGround(@RequestParam("page") int page,
                                    @RequestParam("size") int size,
                                    @RequestParam("search") String name) {
        Page<Ground> grounds;
        grounds= groundService.getGrounds(name, PageRequest.of(page,size));
        return grounds;
    }
    @GetMapping(value = "/paging", params = {"page", "size", "nameFloor", "codeGround", "area", "nameTypeGround"})
    public Page<Ground> getListGround(@RequestParam("page") int page,
                                        @RequestParam("size") int size,
                                        @RequestParam(value = "nameFloor") String nameFloor,
                                        @RequestParam(value = "codeGround", defaultValue = "")  String codeGround,
                                        @RequestParam(value = "area") Integer area,
                                        @RequestParam(value = "nameTypeGround", defaultValue = "") String nameTypeGround) {
        Page<Ground> grounds;
        grounds= groundService.searchAll(nameFloor,codeGround,area, nameTypeGround,PageRequest.of(page, size));
        return grounds;
    }

    @GetMapping("/{id}")
    public ResponseEntity<GroundDTO> getGround(@PathVariable("id") int id) {
        GroundDTO groundDTO = groundService.findAllByDeleteFlagIsNullAndIdIs(id);
        if (groundDTO != null) {
            return ResponseEntity.ok(groundDTO);
        }
        return null;
    }
    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteBuilding(@PathVariable("id") int id) {
        GroundDTO ground = groundService.findAllByDeleteFlagIsNullAndIdIs(id);
        groundService.remove(ground.getId());
        Map<String, Boolean> response = new HashMap<>();
        response.put("delete", Boolean.TRUE);
        return response;
    }
    @PostMapping("")
    public ResponseEntity<?> createGround(@Valid @RequestBody GroundDTO groundDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return new ResponseEntity<List>(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
        groundService.save(groundDTO);
        return ResponseEntity.ok(groundDTO);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateGround(@PathVariable(value = "id") Integer id,@RequestBody @Valid GroundDTO groundDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return new ResponseEntity<List>(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
        groundService.updateGround(groundDTO);
        return ResponseEntity.accepted().body(groundDTO);
    }
}
