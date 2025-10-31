package school.sptech;

import school.sptech.especialistas.DesenvolvedorMobile;
import school.sptech.especialistas.DesenvolvedorWeb;

import java.util.ArrayList;
import java.util.List;

public class Consultoria {
    private String nome;
    private Integer vagas;
    private List<Desenvolvedor> desenvolvedores = new ArrayList<>();

    public void contratar(Desenvolvedor desenvolvedor){
        if(vagas > 0 ){
            desenvolvedores.add(desenvolvedor);
        }
    }

    public void contratarFullstack(DesenvolvedorWeb desenvolvedor){
        if(desenvolvedor.isFullstack()){
            desenvolvedores.add(desenvolvedor);
        }
    }

    public Double getTotalSalarios(){
        Double salariosSoma = 0.0;

        for(Desenvolvedor d : desenvolvedores){
            salariosSoma += d.calcularSalario();
        }
        return salariosSoma;
    }

    public Integer qtdDesenvolvedoresMobile(){
        int soma = 0;

        for(Desenvolvedor d : desenvolvedores){
            if(d instanceof DesenvolvedorMobile){
                soma += 1;
            }
        }

        return soma;
    }

    public List<Desenvolvedor> buscarPorSalarioMaiorIgualQue(Double salario){
        List<Desenvolvedor> desenvolvedoresMaiorIgual = new ArrayList<>();

        for (Desenvolvedor d : desenvolvedores){
            if(d.calcularSalario() >= salario){
                desenvolvedoresMaiorIgual.add(d);
            }
        }

        return desenvolvedoresMaiorIgual;
    }

    public Desenvolvedor buscarMenorSalario(){
        Desenvolvedor desenvolvedorMenor = null;

        for(Desenvolvedor d : desenvolvedores){
            if(desenvolvedorMenor == null){
                desenvolvedorMenor = d;
            }else if(desenvolvedorMenor.calcularSalario() > d.calcularSalario()){
                desenvolvedorMenor = d;
            }
        }

        return desenvolvedorMenor;
    }
}
