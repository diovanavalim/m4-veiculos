package com.veiculos.veiculos.repository;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.veiculos.veiculos.exception.NotFoundException;
import com.veiculos.veiculos.model.VeiculoModel;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class VeiculoRepository {
    private final String filePath = "src/main/resources/dados.json";

    public VeiculoModel getVeiculo(String placa) {
        ObjectMapper mapper = new ObjectMapper();
        List<VeiculoModel> listaVeiculos = null;

        try {
            listaVeiculos = Arrays.asList(mapper.readValue(new File(filePath), VeiculoModel[].class));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        for (VeiculoModel veiculo : listaVeiculos) {
            if (veiculo.getPlaca().equals(placa)) {
                return veiculo;
            }
        }

        throw new NotFoundException("Veiculo não localizado");
    }

    public List<VeiculoModel> getAllVeiculo() {
        ObjectMapper mapper = new ObjectMapper();
        List<VeiculoModel> listaVeiculos = null;

        try {
            listaVeiculos = Arrays.asList(mapper.readValue(new File(filePath), VeiculoModel[].class));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return listaVeiculos;
    }

    public boolean saveVeiculo(VeiculoModel veiculo) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        List<VeiculoModel> listaVeiculos = null;

        try {
            listaVeiculos = Arrays.asList(mapper.readValue(new File(filePath), VeiculoModel[].class));
            List<VeiculoModel> copiaListaVeiculos = new ArrayList<VeiculoModel>(listaVeiculos);

            copiaListaVeiculos.add(veiculo);
            writer.writeValue(new File(filePath), copiaListaVeiculos);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
