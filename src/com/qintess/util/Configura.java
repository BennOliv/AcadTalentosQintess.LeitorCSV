package com.qintess.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import com.qintess.model.DadoMercado;
import com.qintess.model.Operacao;
import com.qintess.model.Resultado;

public class Configura {
	
	public static void geraOps(ArrayList<Operacao> lista, String path){
		try {
			FileReader arquivoOp = new FileReader(path);
			BufferedReader brOp = new BufferedReader(arquivoOp);
			String linhaGrudada = brOp.readLine();
			
			while ((linhaGrudada = brOp.readLine()) != null) {
					String[] campos = linhaGrudada.split(";");
					String[] dt = (campos[1]+"/"+campos[2]).split("/");
					lista.add(new Operacao(campos[9]
										, Integer.parseInt(campos[13])
										, Double.parseDouble(campos[12].replace(',', '.'))
										, ChronoUnit.DAYS.between(LocalDate.of(Integer.parseInt(dt[2]),Integer.parseInt(dt[1]),Integer.parseInt(dt[0]))
																, LocalDate.of(Integer.parseInt(dt[5]),Integer.parseInt(dt[4]),Integer.parseInt(dt[3])))));
			}
			
			arquivoOp.close();
			brOp.close();
			
		} catch (IOException e2) {
			e2.printStackTrace();
		}
	}
	
	public static void geraDds(ArrayList<DadoMercado> lista, String path){
		try {
			FileReader arquivoDd = new FileReader(path);
			BufferedReader brDd = new BufferedReader(arquivoDd);
			String linhaGrudada = brDd.readLine();
			
			while ((linhaGrudada = brDd.readLine()) != null) {
				String[] campos = linhaGrudada.split(";");
				lista.add(new DadoMercado(Integer.parseInt(campos[0])
										,Integer.parseInt(campos[1])
										,Double.parseDouble(campos[2].replace(',', '.'))));
			}
			
			arquivoDd.close();
			brDd.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public static void geraValores(ArrayList<Operacao> listaA,ArrayList<DadoMercado> listaB, ArrayList<Resultado> listaC) {
		for (Operacao operacao : listaA) {
			for (DadoMercado dadoMercado : listaB) {
				if(operacao.getId() == dadoMercado.getId() && operacao.getContDias() == dadoMercado.getQuant()) {
					operacao.setValor(operacao.getQuant() * dadoMercado.getPreco());
					break;
				}
			}
		}
		
		//casoInicial
		listaC.add(new Resultado(listaA.get(0).getNome()));
		
		//geraResultados os agrupando
		for (Operacao operacao : listaA) {
			int c = 0;
			for (Resultado resultado : listaC) {
				if(operacao.getNome().equals(resultado.getNome())) {
					resultado.somaValor(operacao.getValor());
					break;
				} else {
					c++;
					if(c == listaC.size()){
						listaC.add(new Resultado(operacao.getNome(), operacao.getValor()));
						break;
					}
				}
			}
		}
	}
	
	public static void geraCsv(ArrayList<Resultado> lista, String path) {
		try {
			FileWriter fw = new FileWriter(path);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("ID_SUBPRODUTO;RESULTADO");
			for (Resultado resultado : lista) {
				bw.newLine();
				bw.write(resultado.getNome() + ";" + resultado.getValor());
			}
			
			bw.flush();
			
			fw.close();
			bw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
