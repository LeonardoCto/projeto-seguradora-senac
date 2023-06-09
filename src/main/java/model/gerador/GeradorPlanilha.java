package model.gerador;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import model.util.DateUtil;
import model.vo.Pessoa;
import model.vo.Seguro;
import model.vo.Sinistro;

public class GeradorPlanilha {

	public String gerarPlanilhaSeguros(List<Seguro> seguros, String destinoArquivo) {
		HSSFWorkbook arquivoExcel = new HSSFWorkbook();
		HSSFSheet abaPlanilha = arquivoExcel.createSheet("Clientes");

		HSSFRow linhaCabecalho = abaPlanilha.createRow(0);
		//TODO Ajustar as colunas. 
		linhaCabecalho.createCell(0).setCellValue("Nome");
		linhaCabecalho.createCell(1).setCellValue("Proposta");
		linhaCabecalho.createCell(2).setCellValue("Placa");
		linhaCabecalho.createCell(3).setCellValue("VigênciaInicial");
		linhaCabecalho.createCell(4).setCellValue("VigênciaFinal");
		linhaCabecalho.createCell(5).setCellValue("RCF Materiais");
		linhaCabecalho.createCell(6).setCellValue("RCF Corporais");
		linhaCabecalho.createCell(7).setCellValue("Franquia");
		linhaCabecalho.createCell(8).setCellValue("Assistência");
		linhaCabecalho.createCell(9).setCellValue("CarroReseva");

		int contadorLinhas = 1;
			for (Seguro c : seguros) {
				HSSFRow novaLinha = abaPlanilha.createRow(contadorLinhas);
				novaLinha.createCell(0).setCellValue(c.getPessoa().getNome());
				novaLinha.createCell(1).setCellValue(c.getNumeroProposta());
				novaLinha.createCell(2).setCellValue(c.getVeiculo().toString());
				novaLinha.createCell(3).setCellValue(DateUtil.formatarDataPadraoBrasil(c.getDtInicioVigencia()));
				novaLinha.createCell(4).setCellValue(DateUtil.formatarDataPadraoBrasil(c.getDtFimVigencia()));
				novaLinha.createCell(5).setCellValue(c.getRcfDanosMateriais());
				novaLinha.createCell(6).setCellValue(c.getRcfDanosCorporais());
				novaLinha.createCell(7).setCellValue(c.getFranquia());
				novaLinha.createCell(8).setCellValue(c.getAssistencia());
				novaLinha.createCell(9).setCellValue(c.getCarroReserva());
				contadorLinhas++;
			}
			return salvarNoDisco(arquivoExcel, destinoArquivo);
		}

	public String gerarPlanilhaPessoas(List<Pessoa> pessoas, String destinoArquivo) {
		HSSFWorkbook arquivoExcel = new HSSFWorkbook();
		HSSFSheet abaPlanilha = arquivoExcel.createSheet("Clientes");

		HSSFRow linhaCabecalho = abaPlanilha.createRow(0);
		linhaCabecalho.createCell(0).setCellValue("Nome");
		linhaCabecalho.createCell(1).setCellValue("CPF");
		linhaCabecalho.createCell(2).setCellValue("Data de Nascimento");
		linhaCabecalho.createCell(3).setCellValue("Telefone");
		linhaCabecalho.createCell(4).setCellValue("Endereco resumido (Cidade - UF)");

		int contadorLinhas = 1;
			for (Pessoa p : pessoas) {
				HSSFRow novaLinha = abaPlanilha.createRow(contadorLinhas);
				novaLinha.createCell(0).setCellValue(p.getNome());
				novaLinha.createCell(1).setCellValue(p.getCpf());
				novaLinha.createCell(2).setCellValue(DateUtil.formatarDataPadraoBrasil(p.getDataNascimento()));		
				novaLinha.createCell(3).setCellValue(p.getTelefone());
				novaLinha.createCell(4).setCellValue(p.getEndereco().getCidade() + " - " + p.getEndereco().getEstado());
				contadorLinhas++;
			}
			return salvarNoDisco(arquivoExcel, destinoArquivo);
	}
	
	public String gerarPlanilhaSinistros(List<Sinistro> sinistros, String destinoArquivo) {
		HSSFWorkbook arquivoExcel = new HSSFWorkbook();
		HSSFSheet abaPlanilha = arquivoExcel.createSheet("Sinistros");
		
		HSSFRow linhaCabecalho = abaPlanilha.createRow(0);
		linhaCabecalho.createCell(0).setCellValue("Lista de Sinistros");
		linhaCabecalho.createCell(1).setCellValue("Número Sinistro");
		linhaCabecalho.createCell(2).setCellValue("Tipo Sinistro");
		linhaCabecalho.createCell(3).setCellValue("Segurado");
		linhaCabecalho.createCell(4).setCellValue("Veículo");
		linhaCabecalho.createCell(5).setCellValue("Data do Sinistro");
		linhaCabecalho.createCell(6).setCellValue("Valor da Franquia");
		linhaCabecalho.createCell(7).setCellValue("Valor da Orçado");
		linhaCabecalho.createCell(8).setCellValue("Valor da Pago");
		linhaCabecalho.createCell(9).setCellValue("Situação");
		
		int contadorLinhas = 1;
		for(Sinistro sin : sinistros) {
			HSSFRow novaLinha = abaPlanilha.createRow(contadorLinhas);
			novaLinha.createCell(0).setCellValue("");
			novaLinha.createCell(1).setCellValue(sin.getNumeroSinistro());
			novaLinha.createCell(2).setCellValue(sin.getTipoSinistro().name());
			novaLinha.createCell(3).setCellValue(sin.getSeguro().getPessoa().getNome());
			novaLinha.createCell(4).setCellValue(sin.getSeguro().getVeiculo().getPlacaVeiculo());
			novaLinha.createCell(5).setCellValue(DateUtil.formatarDataPadraoBrasil(sin.getDataSinistro()));
			novaLinha.createCell(6).setCellValue(sin.getValorFranquia());
			novaLinha.createCell(7).setCellValue(sin.getValorOrcado());
			novaLinha.createCell(8).setCellValue(sin.getValorPago());
			novaLinha.createCell(9).setCellValue(sin.getSituacao().toString());
			contadorLinhas++;
		}
		
		return salvarNoDisco(arquivoExcel, destinoArquivo);
	}
	
	private String salvarNoDisco(HSSFWorkbook planilha, String caminhoArquivo) {
		String mensagem = "";
		FileOutputStream saida = null;
		String extensao = ".xls";
		
		try {
			saida = new FileOutputStream(new File(caminhoArquivo + extensao));
			planilha.write(saida);
			mensagem = "Planilha gerada com sucesso!";
		} catch (FileNotFoundException e) {
			mensagem = "Erro ao tentar salvar planilha (sem acesso): " + caminhoArquivo + extensao;
			System.out.println("Causa: " + e.getMessage());
		} catch (IOException e) {
			mensagem = "Erro de I/O ao tentar salvar planilha em: " + caminhoArquivo + extensao;
			System.out.println("Causa: " + e.getMessage());
		} finally {
			if (saida != null) {
				try {
					saida.close();
					planilha.close();
				} catch (IOException e) {
					mensagem = "Erro ao tentar salvar planilha em: " + caminhoArquivo + extensao;
					System.out.println("Causa: " + e.getMessage());
				}
			}
		}
		return mensagem;
	}
}