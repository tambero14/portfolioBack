
package com.ArgentinaPrograma.porfolioWeb.controller;

import com.ArgentinaPrograma.porfolioWeb.dto.DtoExperiencia;
import com.ArgentinaPrograma.porfolioWeb.model.Experiencia;
import com.ArgentinaPrograma.porfolioWeb.service.SExperiencia;
import io.micrometer.common.util.StringUtils;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("explab")
@CrossOrigin(origins = "http://localhost:4200")
public class CExperiencia {
    @Autowired
    SExperiencia sExperiencia; 
    
    @GetMapping("/lista")
    public ResponseEntity<List<Experiencia>> list() {
        List<Experiencia> list = sExperiencia.list();
        return new ResponseEntity(list, HttpStatus.OK );
    }
        
    @PostMapping
        public ResponseEntity<?> create(@RequestBody DtoExperiencia dtoexp) {
            
            Experiencia experiencia = new Experiencia(dtoexp.getNombreE(), 
                    dtoexp.getDescripcionE());
            sExperiencia.save(experiencia);
            
            return new ResponseEntity( HttpStatus.OK);
    }
        
        @PutMapping("/update/{id}")
        public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoExperiencia
            dtoexp){
        
        Experiencia experiencia = sExperiencia.getOne(id).get();
        experiencia.setNombreE(dtoexp.getNombreE());
        experiencia.setDescripcionE((dtoexp.getDescripcionE()));
        
        sExperiencia.save(experiencia);
        return new ResponseEntity( HttpStatus.OK);
    }    
        
        public ResponseEntity<?> delete(@PathVariable("id") int id) {
            sExperiencia.delete(id);
            return new ResponseEntity(HttpStatus.OK);
        }
        
}
