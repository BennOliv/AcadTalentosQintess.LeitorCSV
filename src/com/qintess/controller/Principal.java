package com.qintess.controller;

import java.util.ArrayList;

import com.qintess.model.DadoMercado;
import com.qintess.model.Operacao;
import com.qintess.model.Resultado;
import com.qintess.util.Configura;

public class Principal {
	public static void main(String[] args) {
		
		long tempo = System.currentTimeMillis();
		
		ArrayList<Operacao> listaOps = new ArrayList<>();
		ArrayList<DadoMercado> listaDds = new ArrayList<>();
		ArrayList<Resultado> listaResults = new ArrayList<>();
		
//		Para que o funcione, � necess�rio que altere os paths dos files.
//		Os documentos "Dados de Mercado" e "Opera��es" est�o em "/src/com/qintess/resources/".
		String pathOp = "";
		String pathDd = "";
		String pathSaida = "";
		
		Configura.geraOps(listaOps, pathOp);
		Configura.geraDds(listaDds, pathDd);
		Configura.geraValores(listaOps, listaDds, listaResults);
		Configura.geraCsv(listaResults, pathSaida);
		
		System.out.println("Tempo de execu��o: " + (tempo = System.currentTimeMillis() - tempo) + "ms.");
	}
}