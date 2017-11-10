/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;


import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import infra.Aluno;
import infra.Endereco;
import java.awt.Font;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlSelectBooleanCheckbox;
import javax.faces.component.html.HtmlSelectManyCheckbox;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FlowEvent;

/**
 *
 * @author JoãoRabelo
 */
@Named(value = "alunoBeans")
@RequestScoped
public class alunoBeans {
    
    private List<Aluno> alus;
    private Endereco end;
    private Aluno alu;

    public Aluno getAlu() {
        return alu;
    }

    public void setAlu(Aluno alu) {
        this.alu = alu;
    }

    
    public Endereco getEnd() {
        return end;
    }

    public void setEnd(Endereco end) {
        this.end = end;
    }
    
    private boolean skip;

    public boolean isSkip() {
        return skip;
    }

    public void setSkip(boolean skip) {
        this.skip = skip;
    }

    public String onFlowProcess(FlowEvent event) {
        if (skip) {
            skip = false;   //reset in case user goes back
            return "confirm";
        } else {
            return event.getNewStep();
        }
    }

    
  
    
    /**
     * Creates a new instance of medicoBeans
     */
    public alunoBeans() {
        end = new Endereco();
        alu = new Aluno();
    }

    public void salvar() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PJSFPU");
        EntityManager em = emf.createEntityManager();
        alu.setEnd(end);
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(alu);
        tx.commit();
        em.close();
        emf.close();
        FacesMessage msg = new FacesMessage("O aluno " + this.alu.getNome() + " foi editado com sucesso");
        FacesContext.getCurrentInstance().addMessage(null, msg);
       

    }

    public void salvar1() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PJSFPU");
        EntityManager em = emf.createEntityManager();
        alu.setEnd(end);
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(alu);
        tx.commit();
        em.close();
        emf.close();
        alu.setNome("");
        alu.setSenha("");
        alu.setFoto("");
        alu.setLocalNac("");
        alu.setPai("");
        alu.setStatus("");
        alu = null;
        FacesMessage msg = new FacesMessage("O aluno " + this.alu.getNome() + " foi cadastrado com sucesso");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "O aluno " + this.alu.getNome() + " foi cadastrado"));
        UIViewRoot view = FacesContext.getCurrentInstance().getViewRoot();
        //return view.getViewId() + "?faces-redirect=true";
        Iterator<UIComponent> filhos = view.getFacetsAndChildren();
        clearComponents(filhos);
    }

    private static void clearComponents(Iterator<UIComponent> filhosid) {
        while (filhosid.hasNext()) {
            UIComponent component = filhosid.next();
            if (component instanceof HtmlInputText) {
                HtmlInputText com = (HtmlInputText) component;
                com.resetValue();
            }
            if (component instanceof HtmlSelectOneMenu) {
                HtmlSelectOneMenu com = (HtmlSelectOneMenu) component;
                com.resetValue();
            }
            if (component instanceof HtmlSelectBooleanCheckbox) {
                HtmlSelectBooleanCheckbox com = (HtmlSelectBooleanCheckbox) component;
                com.resetValue();
            }
            if (component instanceof HtmlSelectManyCheckbox) {
                HtmlSelectManyCheckbox com = (HtmlSelectManyCheckbox) component;
                com.resetValue();
            }

            clearComponents(component.getFacetsAndChildren());

        }
    }

    public List<Aluno> getAlus() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PJSFPU");
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("select a from Aluno a", Aluno.class);
        this.alus = q.getResultList();
        em.close();
        return alus;
    }

    public void excluir(Aluno alu) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PJSFPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        alu = em.merge(alu);
        em.remove(alu);
        tx.commit();
        em.close();
    }
    
    public void editar(Aluno alu){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PJSFPU");
        EntityManager em = emf.createEntityManager();
        alu.setEnd(end);
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(em.merge(alu));
        tx.commit();
        em.close();
        emf.close();
        FacesMessage msg = new FacesMessage("O aluno " + this.alu.getNome() + " foi editado com sucesso");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
   
         public void imprimir(Aluno a) {
             
Document document = new Document(PageSize.LETTER);
ByteArrayOutputStream baos = new ByteArrayOutputStream();
try {
    PdfWriter.getInstance(document, baos);
//METADATA
document.open();
document.add(new Paragraph(" FICHA DE MATRICULA \n"));

DateFormat formatter= new SimpleDateFormat("dd/MM/yy '-' hh:mm:ss:");
Date currentDate = new Date();
String date = formatter.format(currentDate);
//document.add(new Paragraph("Fecha Generado: "+date));  
document.add(new Paragraph("Encerrado: "+date));
document.add(new Paragraph("\n")); 

PdfPTable table = new PdfPTable(6);
table.setTotalWidth(new float[]{ 20,72, 110, 95, 170, 72 });
table.setLockedWidth(true);
PdfPCell cell = new PdfPCell(new Paragraph("|ID|       |PAI|         |MÃE|         |NOME|           |STATUS|" ,
FontFactory.getFont("arial",// fuente
10,// tamaño
Font.BOLD, // estilo
BaseColor.WHITE)));
cell.setHorizontalAlignment(Element.ALIGN_CENTER);
cell.setBackgroundColor(BaseColor.GRAY);
cell.setColspan(6);
table.addCell(cell);
cell = new PdfPCell(new Paragraph ("ID", FontFactory.getFont("arial",8,Font.BOLD,BaseColor.GRAY )));
table.addCell(a.getIdMat().toString());
table.addCell(a.getPai().toString());
table.addCell(a.getMae().toString());
table.addCell(a.getNome());
table.addCell(a.getEmail());
table.addCell(a.getStatus());
PdfPTable tablel = new PdfPTable(6);
tablel.setTotalWidth(new float[]{ 20,72, 110, 95, 170, 72 });
tablel.setLockedWidth(true);
PdfPCell celll = new PdfPCell(new Paragraph("---" ,
FontFactory.getFont("arial",// fuente
8,// tamaño
Font.BOLD, // estilo
BaseColor.WHITE)));
celll.setHorizontalAlignment(Element.ALIGN_CENTER);
celll.setBackgroundColor(BaseColor.GRAY);
celll.setColspan(6);
tablel.addCell(celll);
celll = new PdfPCell(new Paragraph ("ID", FontFactory.getFont("arial",8,Font.BOLD,BaseColor.GRAY )));
tablel.addCell("Pai");
tablel.addCell("Mãe");
tablel.addCell("Nome");
tablel.addCell("Email");
tablel.addCell("Status");




document.add(table);
document.add(tablel);
} catch (Exception ex) {
System.out.println("Error " + ex.getMessage());
}
document.close();
FacesContext context = FacesContext.getCurrentInstance();
Object response = context.getExternalContext().getResponse();
if (response instanceof HttpServletResponse) {
HttpServletResponse hsr = (HttpServletResponse) response;
hsr.setContentType("application/pdf");
hsr.setHeader("Content-disposition", "attachment");
hsr.setContentLength(baos.size());
try {
ServletOutputStream out = hsr.getOutputStream();
baos.writeTo(out);
out.flush();
} catch (IOException ex) {
System.out.println("Error:  " + ex.getMessage());
}
context.responseComplete();
}
}

      } 
    
    

