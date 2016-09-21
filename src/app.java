import java.util.List;
import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import atleta.Atleta;
import esporte.*;
import estatistica.*;
import exception.OlimpiadasException;
import pais.Pais;
import util.ManipulacaoArquivo;

public class app {

    public static void main(String args[]) throws OlimpiadasException{

        // Atributos
        int id;
        int idPais;
        int idEsporte;
        String nome;
        double result[] = new double[5];
        String resultTemp[];

        Esporte corrida = new Corrida(),
                natacao = new Natacao(),
                ginastica = new GinasticaArtistica(),
                levantamento = new LevantamentoPeso(),
                salto = new SaltoAltura();

        int idCorrida = 0, idNatacao = 0, idGinastica = 0, idLevantamento = 0, idSalto = 0;

        Atleta atleta;

        Pais pais;
        List<Pais> relacaoPaises = new ArrayList<>();

        List<String> linhas;

        /**
         * Leitura e instanciação dos países
         */
        linhas = ManipulacaoArquivo.lerArquivo("paises.txt");
        String entrada[];
        for(int i = 0; i < linhas.size(); i++) {
            entrada = linhas.get(i).split(";");
            pais = new Pais(Integer.parseInt(entrada[0]), entrada[1]);
            relacaoPaises.add(pais);
        }

        /**
         * Leitura e instanciação dos esportes
         */
        linhas = ManipulacaoArquivo.lerArquivo("esportes.txt");
        for(int i = 0; i < linhas.size(); i++) {
            entrada = linhas.get(i).split(";");

            /**
             * Dependendo do esporte cadastrado, instancia-se uma classe
             * filha de Esporte
             */
            switch (entrada[1]) {
                case "Corrida":
                    idCorrida = Integer.parseInt(entrada[0]);
                    corrida = new Corrida(idCorrida);
                    break;
                case "Natação":
                    idNatacao = Integer.parseInt(entrada[0]);
                    natacao = new Natacao(idNatacao);
                    break;
                case "Levantamento de peso":
                    idLevantamento = Integer.parseInt(entrada[0]);
                    levantamento = new LevantamentoPeso(idLevantamento);
                    break;
                case "Salto em altura":
                    idSalto = Integer.parseInt(entrada[0]);
                    salto = new SaltoAltura(idSalto);
                    break;
                case "Ginástica artística":
                    idGinastica = Integer.parseInt(entrada[0]);
                    ginastica = new GinasticaArtistica(idGinastica);
                    break;
                default:
                    throw new OlimpiadasException("Esporte inexistente!");
            }
        }

        /**
         * Lê, instancia e salva os atletas dentro de cada
         * esporte que disputam
         */
        linhas = ManipulacaoArquivo.lerArquivo("atletas.txt");
        for(int i = 0; i < linhas.size(); i++) {
            entrada = linhas.get(i).split(";");
            id = Integer.parseInt(entrada[0]);
            idPais = Integer.parseInt(entrada[1]);
            idEsporte = Integer.parseInt(entrada[2]);
            nome = entrada[3];
            entrada[4] = entrada[4].replaceAll(",", ".");
            resultTemp = entrada[4].split("\\|");

            for (int j = 0; j < resultTemp.length; j++) {
                result[j] = Double.parseDouble(resultTemp[j]);
            }

            atleta = new Atleta(id, idPais, idEsporte, nome, result);

            // Salva o atleta no esporte em que disputa
            if (idEsporte == idCorrida) {
                corrida.novoAtleta(atleta);
            } else if (idEsporte == idGinastica) {
                ginastica.novoAtleta(atleta);
            } else if (idEsporte == idLevantamento) {
                levantamento.novoAtleta(atleta);
            } else if (idEsporte == idSalto) {
                salto.novoAtleta(atleta);
            } else if (idEsporte == idNatacao) {
                natacao.novoAtleta(atleta);
            } else {
                throw new OlimpiadasException("Esporte inexistente!");
            }
        }

        // Determina vencedores e distribui as medalhas
	    corrida.determinaVencedor();
        corrida.distribuiMedalhas(relacaoPaises);
        natacao.determinaVencedor();
        natacao.distribuiMedalhas(relacaoPaises);;
        ginastica.determinaVencedor();
        ginastica.distribuiMedalhas(relacaoPaises);;
	    levantamento.determinaVencedor();
	    levantamento.distribuiMedalhas(relacaoPaises);;
        salto.determinaVencedor();
        salto.distribuiMedalhas(relacaoPaises);;

        /**
         * Lê o arquivo de estatísticas e gera as estatísticas requisitadas
         */
        linhas = ManipulacaoArquivo.lerArquivo("estatisticas.txt");
        for(int i = 0; i < linhas.size(); i++) {
            entrada = linhas.get(i).split(";");

            // Chama métodos para gerar os arquivos de estatística
            if(Integer.parseInt(entrada[0]) == 1) {
                if(Integer.parseInt(entrada[1]) == idCorrida) {
                    EstatisticaEsporte.gerarEstatistica(corrida);
                } else if(Integer.parseInt(entrada[1]) == idGinastica) {
                    EstatisticaEsporte.gerarEstatistica(ginastica);
                } else if(Integer.parseInt(entrada[1]) == idLevantamento) {
                    EstatisticaEsporte.gerarEstatistica(levantamento);
                } else if(Integer.parseInt(entrada[1]) == idNatacao) {
                    EstatisticaEsporte.gerarEstatistica(natacao);
                } else if(Integer.parseInt(entrada[1]) == idSalto) {
                    EstatisticaEsporte.gerarEstatistica(salto);
                } else {
                    throw new OlimpiadasException("Opção de esporte inválida!");
                }
            } else if(Integer.parseInt(entrada[0]) == 2){
                EstatisticaGeral.gerarEstatistica(relacaoPaises);
            } else {
                throw new OlimpiadasException("Opção de estatística inválida!");
            }
        }

    }
}
