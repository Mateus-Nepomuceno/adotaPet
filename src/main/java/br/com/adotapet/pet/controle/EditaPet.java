package br.com.adotapet.pet.controle;

import br.com.adotapet.endereco.Endereco;
import br.com.adotapet.formulario.Formulario;
import br.com.adotapet.pet.Pet;
import br.com.adotapet.resposta.RetornaRespostas;

import java.util.Scanner;

public class EditaPet {
    private Scanner sc;
    private Formulario formulario;

    public EditaPet(Scanner sc, Formulario formulario) {
        this.sc = sc;
        this.formulario = formulario;
    }

    public void editaNomeSobrenome(Pet pet){
        String nomeSobrenome = new RetornaRespostas(this.sc, this.formulario).retornaNomeSobrenome();
        pet.setNomeSobrenome(nomeSobrenome);
    }

    public void editaEndereco(Pet pet){
        Endereco endereco = new RetornaRespostas(this.sc, this.formulario).retornaEndereco();
        pet.setEndereco(endereco);
    }

    public void editaIdade(Pet pet){
        String idade = new RetornaRespostas(this.sc, this.formulario).retornaIdade();
        pet.setIdade(idade);
    }

    public void editaPeso(Pet pet){
        String peso = new RetornaRespostas(this.sc, this.formulario).retornaPeso();
        pet.setPeso(peso);
    }

    public void editaRaca(Pet pet){
        String raca = new RetornaRespostas(this.sc, this.formulario).retornaRaca();
        pet.setRaca(raca);
    }
}
