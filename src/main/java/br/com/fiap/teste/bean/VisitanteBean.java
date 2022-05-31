package br.com.fiap.teste.bean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.file.UploadedFile;

import br.com.fiap.teste.dao.VisitanteDao;
import br.com.fiap.teste.model.Visitante;
import br.com.fiap.teste.service.UploadService;

@Named
@RequestScoped
public class VisitanteBean {
	private Visitante visitante = new Visitante();

	@Inject
	private VisitanteDao dao;

	private UploadedFile image;

	public String save() {
		
		String path = UploadService.write(image, "visitantes");
		visitante.setImagePath(path);
		
		LocalDateTime agora = LocalDateTime.now();
		DateTimeFormatter formatterData = DateTimeFormatter.ofPattern("dd/MM/uuuu");
		String dataFormatada = formatterData.format(agora);
		visitante.setDateCadastro(dataFormatada);
		
		dao.create(visitante);
		
		System.out.println(path);
		
		FacesMessage facesMessage = new FacesMessage("Visistante cadastrado com sucesso");
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);

		return "visitantes";
	}

	public Visitante getVisitante() {
		return visitante;
	}

	public void setVisitante(Visitante visitante) {
		this.visitante = visitante;
	}

	public VisitanteDao getDao() {
		return dao;
	}

	public void setDao(VisitanteDao dao) {
		this.dao = dao;
	}

	public List<Visitante> list() {
		return dao.listAll();
	}

	public UploadedFile getImage() {
		return image;
	}

	public void setImage(UploadedFile image) {
		this.image = image;
	}
}
