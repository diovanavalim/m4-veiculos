package com.veiculos.veiculos.controller;

import com.veiculos.veiculos.dto.VeiculoDto;
import com.veiculos.veiculos.model.VeiculoModel;
import com.veiculos.veiculos.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @GetMapping("/{placa}")
    public ResponseEntity<VeiculoDto> getVeiculo(@PathVariable String placa) {
        VeiculoModel veiculo = veiculoRepository.getVeiculo(placa);

        if (veiculo != null) {
            return new ResponseEntity<VeiculoDto>(new VeiculoDto(veiculo), HttpStatus.OK);
        }

        return new ResponseEntity(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<VeiculoDto>> getAllVeiculo() {
        List<VeiculoModel> listaVeiculos = veiculoRepository.getAllVeiculo();
        List<VeiculoDto> listaVeiculosDto = new ArrayList<VeiculoDto>();

        listaVeiculos.forEach(veiculo -> {
            VeiculoDto veiculoDto = new VeiculoDto(veiculo);
            listaVeiculosDto.add(veiculoDto);
        });

        return new ResponseEntity<List<VeiculoDto>>(listaVeiculosDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> saveVeiculo(@RequestBody VeiculoModel veiculo) {
        boolean inseriuVeiculo = veiculoRepository.saveVeiculo(veiculo);

        if (inseriuVeiculo) {
            return new ResponseEntity("Veículo salvo com sucesso!", HttpStatus.OK);
        }

        return new ResponseEntity("Não foi possível salvar o veículo no sistema", HttpStatus.BAD_REQUEST);
    }
}
