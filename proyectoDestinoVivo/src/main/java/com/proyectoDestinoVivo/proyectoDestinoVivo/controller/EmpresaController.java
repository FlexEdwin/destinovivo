package com.proyectoDestinoVivo.proyectoDestinoVivo.controller;
import com.proyectoDestinoVivo.proyectoDestinoVivo.model.Empresa;
import com.proyectoDestinoVivo.proyectoDestinoVivo.model.Usuario;
import com.proyectoDestinoVivo.proyectoDestinoVivo.service.EmpresaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin (origins = "http://localhost:5173")
public class EmpresaController {
    private final EmpresaService empresaService;

    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }
    @PostMapping("/empresas/insertar")
    public Empresa insertar(@RequestBody Empresa empresa){
        try {
            return empresaService.insertarEmpresa(empresa);
        }catch (RuntimeException e){
            throw new RuntimeException("Error al insertar la empresa" +e);
        }

    }

    @GetMapping("/empresas/consultar")
    public List<Empresa> consultar(){
        try{
            return empresaService.consultarEmpresas();
        }catch (RuntimeException e){
            throw new RuntimeException("Error al consultar las empresas" +e);
        }
    }



    @PutMapping("/empresas/editar/{id_empresa}")
    public ResponseEntity<Empresa> editarEmpresa(@PathVariable int id_empresa, @RequestBody Empresa empresa){
        Empresa actualizada = empresaService.editarEmpresa(id_empresa, empresa);
        return ResponseEntity.ok(actualizada);

    }

    @DeleteMapping("/empresas/eliminar/{id_empresa}")
    public String eliminarEmpresa(@PathVariable int id_empresa, @RequestBody Empresa empresa){
        return empresaService.eliminarEmpresa(id_empresa);
    }
    @GetMapping("/empresas/consultar/{id_empresa}")
    public ResponseEntity<Empresa> consultarEmpresaById(@PathVariable("id_empresa") int id_empresa){
        try{
            Empresa empresa = empresaService.consultarEmpresaById(id_empresa);
            return new ResponseEntity<>(empresa, HttpStatus.OK);
        }catch (RuntimeException e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }

}
