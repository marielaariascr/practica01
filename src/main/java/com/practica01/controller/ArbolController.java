package com.practica01.controller;

import com.practica01.domain.Arbol;
import com.practica01.service.ArbolService;
import com.practica01.service.impl.FirebaseStorageServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author mariassuarez
 */
@Controller
@RequestMapping("/arbol")
public class ArbolController {

    @Autowired
    private ArbolService arbolService;

    @GetMapping("/listado")
    public String page(Model model) {
        List<Arbol> listadoArbols = arbolService.getArboles();
        model.addAttribute("arbols", listadoArbols);
        model.addAttribute("TotalArbols", listadoArbols.size());

        return "/arbol/listado";
    }

    @GetMapping("/nuevo")
    public String arbolNuevo(Arbol arbol) {
        return "/arbol/modifica";
    }

    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageServices;

    @PostMapping("/guardar")
    public String arbolGuardar(Arbol arbol,
            @RequestParam("imagenFile") MultipartFile imagenFile) {
        if (!imagenFile.isEmpty()) {
            arbolService.save(arbol);
            arbol.setRutaImagen(
                    firebaseStorageServices.cargaImagen(
                            imagenFile,
                            "arbol",
                            arbol.getIdArbol()));
        }
        arbolService.save(arbol);
        return "redirect:/arbol/listado";
    }

    @GetMapping("/eliminar/{idArbol}")
    public String arbolEliminar(Arbol arbol) {
        arbolService.delete(arbol);
        return "redirect:/arbol/listado";
    }

    @GetMapping("/modificar/{idArbol}")
    public String arbolModificar(Arbol arbol, Model model) {
        arbol = arbolService.getArbol(arbol);
        model.addAttribute("arbol", arbol);
        return "/arbol/modifica";
    }

}
