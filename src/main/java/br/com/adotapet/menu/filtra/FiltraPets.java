package br.com.adotapet.menu.filtra;

import br.com.adotapet.pets.Pet;
import br.com.adotapet.pets.TipoPet;

import java.util.List;

public class FiltraPets {
    public static List<Pet> filtraPorTipo(TipoPet tipoPet, List<Pet> listaPets){
        listaPets.removeIf(pet -> !(pet.getTipoPet() == tipoPet));
        return listaPets;
    }

    public static List<Pet> filtraPorNomeSobrenome(String nomeSobrenome, List<Pet> listaPets){
        listaPets.removeIf(pet -> !pet.getNomeSobrenome().toLowerCase().contains(nomeSobrenome.toLowerCase()));
        return listaPets;
    }

    public static List<Pet> filtraPorSexo(String sexo, List<Pet> listaPets){
        listaPets.removeIf(pet -> !pet.getTipoSexo().SEXO_RELATORIO.equalsIgnoreCase(sexo));
        return listaPets;
    }

    public static List<Pet> filtraPorIdade(String idade, List<Pet> listaPets){
        listaPets.removeIf(pet -> !pet.getIdade().toLowerCase().contains(idade.toLowerCase()));
        return listaPets;
    }

    public static List<Pet> filtraPorEndereco(String endereco, List<Pet> listaPets){
        listaPets.removeIf(pet -> !pet.getEndereco().toString().contains(endereco));
        return listaPets;
    }

    public static List<Pet> filtraPorRaca(String raca, List<Pet> listaPets){
        listaPets.removeIf(pet -> !pet.getRaca().equalsIgnoreCase(raca));
        return listaPets;
    }

    public static List<Pet> filtraPorPeso(String peso, List<Pet> listaPets){
        listaPets.removeIf(pet -> !pet.getPeso().toLowerCase().contains(peso.toLowerCase()));
        return listaPets;
    }
}
