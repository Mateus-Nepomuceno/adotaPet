package br.com.adotapet.pet.controle;

import br.com.adotapet.endereco.Endereco;
import br.com.adotapet.pet.Pet;
import br.com.adotapet.pet.TipoPet;
import br.com.adotapet.pet.TipoSexo;

public class GeraPet {
    public Pet gera(String nomeSobrenome, TipoPet tipoPet, TipoSexo tipoSexo, Endereco endereco, String idade, String peso, String raca){
        return new Pet(nomeSobrenome, tipoPet, tipoSexo, endereco, idade, peso, raca);
    }
}
