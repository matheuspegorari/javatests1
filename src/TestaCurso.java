import java.util.*;
import java.util.stream.Collectors;

public class TestaCurso {
    public static void main(String[] args) {
        List<Curso> cursos = new ArrayList<Curso>();
        cursos.add(new Curso("Python", 45));
        cursos.add(new Curso("JavaScript", 150));
        cursos.add(new Curso("Java 8", 113));
        cursos.add(new Curso("C", 55));

        // Forma de fazer sort pelo número de alunos
        cursos.sort(Comparator.comparing(Curso::getAlunos));

        // Forma de Somar numeros de uma classe usando Stream
        int sum = cursos.stream()
                .filter(c -> c.getAlunos() >= 100)
                .mapToInt(Curso::getAlunos)
                .sum();
        System.out.println("Média de alunos: " + sum);

        // Forma de Obter a média de um atributo de uma classe, usando stream.
        // Repare no Tipo de Dado.
        OptionalDouble media = cursos.stream()
                .filter(c -> c.getAlunos() >= 100)
                .mapToInt(Curso::getAlunos)
                .average();
        System.out.println("Média de alunos: " + media);

        //Filtro Genérico, FindAny
        cursos.stream()
                .filter(c -> c.getAlunos() >= 100)
                .findAny()
                .ifPresent(c -> System.out.println(c.getNome()));

        // Transformar Stream em Collection com ToList
        List<Curso> resultado = cursos.stream()
                .filter(c -> c.getAlunos() >= 100)
                .toList();

        System.out.println("Resultado em lista: " + resultado);

        // Transformar Stream em Collection com Map

        cursos.stream()
                .filter(c -> c.getAlunos() >= 100)
                .collect(Collectors.toMap(
                        Curso::getNome,
                        Curso::getAlunos
                ))
                .forEach((nome, alunos) -> System.out.println(nome + " tem " + alunos + " alunos."));

        //System.out.println("Resultado em Map: " + map);

        // Desafio: Calcule a média de alunos de todos os cursos

        OptionalDouble avg = cursos.stream()
                .mapToDouble(Curso::getAlunos)
                .average();

        System.out.println(avg);


    }


}