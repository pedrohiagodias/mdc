package control;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JOptionPane;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class GeraPDF {
	public void gerar(String s, String s2){
		Document docPDF = new Document();
		String c="C:\\MDC\\pdf.pdf";
		String c2="C:\\MDC\\ifcecrato.jpg";
		//
		
		try{
			//cria uma instancia do documento e da o nome do pdf
			PdfWriter.getInstance(docPDF, new FileOutputStream(c));
			// ou 
			// PdfWriter.getInstance(docPDF, new FileOutputStream("pdf.pdf"));
			// = gera pdf na mesma pasta
			
			//abrir o documento
			docPDF.open();
			
			//setar o tamanho da pagina
			docPDF.setPageSize(PageSize.A4);
			
			//imagem
			//Image im = Image.getInstance("E:\\CURSOS\\IFCE\\3 SEMESTRE\\POOI\\AGROSUS9\\images\\pigs\\ifcecrato.jpg");
			Image im = Image.getInstance(c2);
			im.scaleToFit(200, 200); //tamanho
			//im.setAlignment(im.ALIGN_CENTER); //centraliza
			
			//add imagem no pdf
			docPDF.add(im);
			
			//adicionar primeiro paragrafo
			docPDF.add(new Paragraph("\n            CONTROLE MENSAL DO SETOR DE MECANOGRAFIA\n\n",FontFactory.getFont(FontFactory.COURIER_BOLD, 14)));
			docPDF.add(new Paragraph(s2,FontFactory.getFont(FontFactory.COURIER, 12)));
			docPDF.add(new Paragraph("\n\n                          Crato (CE), "+s,FontFactory.getFont(FontFactory.COURIER, 12)));
			docPDF.add(new Paragraph("\n\n\n\n\n",FontFactory.getFont(FontFactory.COURIER, 12)));
			docPDF.add(new Paragraph("_____________________                             _____________________",FontFactory.getFont(FontFactory.COURIER, 12)));
			docPDF.add(new Paragraph("Setor de Mecanografia                               Setor Financeiro",FontFactory.getFont(FontFactory.COURIER, 12)));
			//nova pagina
			//docPDF.newPage();
			//docPDF.add(new Paragraph("Pagina 2"));
			
		}catch(DocumentException | IOException ex){
			JOptionPane.showMessageDialog(null, "Erro: "+ex);
		}finally{
			docPDF.close();
			JOptionPane.showMessageDialog(null, "PDF criado");
		}
		
		try {
			Desktop.getDesktop().open(new File(c));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
