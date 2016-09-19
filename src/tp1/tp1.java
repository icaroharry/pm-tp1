package tp1;

import java.util.List;
import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import esporte.*;
import estatistica.*;


public class tp1 {

    public static void main(String args[]){
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

		Atleta atl;

        Pais pais;
		List<Pais> relacaoPaises = new ArrayList();

        try {
            File arq = new File("paises.txt");
            BufferedReader lerArq = new BufferedReader(new InputStreamReader(new FileInputStream(arq), "ISO-8859-1"));

            String linha = lerArq.readLine();
            String entrada[];
            while (linha != null) {
                entrada = linha.split(";");
                pais = new Pais(Integer.parseInt(entrada[0]), entrada[1]);
                relacaoPaises.add(pais);
                linha = lerArq.readLine();
            }
            lerArq.close();
        } catch(IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }

		try {
            File arq = new File("esportes.txt");
            BufferedReader lerArq = new BufferedReader(new InputStreamReader(new FileInputStream(arq), "ISO-8859-1"));

            String linha = lerArq.readLine();
            String entrada[];
            while (linha != null) {
                entrada = linha.split(";");

                switch(entrada[1]) {
                    case "Corrida":
                        System.out.printf("%s\n", entrada[0]);
                        idCorrida = Integer.parseInt(entrada[0]);
                        corrida = new Corrida(idCorrida);
                        break;
                    case "Natação":
                        System.out.printf("%s\n", entrada[0]);
                        idNatacao = Integer.parseInt(entrada[0]);
                        natacao = new Natacao(idNatacao);
                        break;
                    case "Levantamento de peso":
                        System.out.printf("%s\n", entrada[0]);
                        idLevantamento = Integer.parseInt(entrada[0]);
                        levantamento = new LevantamentoPeso(idLevantamento);
                        break;
                    case "Salto em altura":
                        System.out.printf("%s\n", entrada[0]);
                        idSalto = Integer.parseInt(entrada[0]);
                        salto = new SaltoAltura(idSalto);
                        break;
                    case "Ginástica artística":
                        System.out.printf("%s\n", entrada[0]);
                        idGinastica = Integer.parseInt(entrada[0]);
                        ginastica = new GinasticaArtistica(idGinastica);
                        break;
                }
                linha = lerArq.readLine();
            }
            lerArq.close();
        } catch(IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }

		try {
			File arq = new File("atletas.txt");
            BufferedReader lerArq = new BufferedReader(new InputStreamReader(new FileInputStream(arq), "ISO-8859-1"));

			String linha = lerArq.readLine();
            String entrada[];
			while (linha != null){
				System.out.printf("%s\n", linha);

                entrada = linha.split(";");

                id = Integer.parseInt(entrada[0]);
                idPais = Integer.parseInt(entrada[1]);
                idEsporte = Integer.parseInt(entrada[2]);
                nome = entrada[3];
                entrada[4] = entrada[4].replaceAll(",", ".");
                resultTemp = entrada[4].split("\\|");
                for(int i = 0; i < resultTemp.length; i++) {
                    result[i] = Double.parseDouble(resultTemp[i]);
                }
                atl = new Atleta(id, idPais, idEsporte, nome, result);

                if(idEsporte == idCorrida) {
                    corrida.novoAtleta(atl);
                } else if(idEsporte == idGinastica) {
                    ginastica.novoAtleta(atl);
                } else if(idEsporte == idLevantamento) {
                    levantamento.novoAtleta(atl);
                } else if(idEsporte == idSalto) {
                    salto.novoAtleta(atl);
                } else if(idEsporte == idNatacao) {
                    natacao.novoAtleta(atl);
                }

				linha = lerArq.readLine();
			}

			lerArq.close();
	    } catch (IOException e){
	        System.err.printf("Erro na abertura do arquivo: %s.\n",
	        e.getMessage());
	    }
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

        try {
            File arq = new File("estatisticas.txt");
            BufferedReader lerArq = new BufferedReader(new InputStreamReader(new FileInputStream(arq), "ISO-8859-1"));

            String linha = lerArq.readLine();
            String entrada[];
            while (linha != null) {
                entrada = linha.split(";");
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
                    }
                } else {

                    EstatisticaGeral.gerarEstatistica(relacaoPaises);
                }
                linha = lerArq.readLine();
            }
            lerArq.close();
        } catch(IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }
    }
}
