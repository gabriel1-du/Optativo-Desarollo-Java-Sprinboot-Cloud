package com.example.api_usuarios.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.api_usuarios.Repository.RegionRepository;
import com.example.api_usuarios.Model.Region;
import com.example.api_usuarios.Service.RegionService;
@Service 
public class RegionServiceImpl implements RegionService{

    //Inyeccion de repositorio
    @Autowired 
    private RegionRepository regionRepository;

    //metodos get
    public List<Region> getAllRegiones(){
        return regionRepository.findAll();
    };

    public Region getRegionById(Long id_region){

        return regionRepository.findById(id_region)
        .orElseThrow(()-> new RuntimeException("Region no encontrada con id: " + id_region));
    };


    //---fin metodos get
}
