package bean;

import static util.MessageUtil.addErrorMessage;
import static util.MessageUtil.addInfoMessage;

import java.util.List;

import org.primefaces.event.RowEditEvent;

import dao.JogoDAO;
import entidade.Jogo;

@javax.faces.bean.ManagedBean
public class JogoBean {
	private Jogo jogo = new Jogo();
	private List<Jogo> lista;

	public String salvar() {
		try {
			JogoDAO.salvar(jogo);
			addInfoMessage("Sucesso", "Jogo salvo e processando...");
			jogo = new Jogo();
		} catch (Exception e) {
			addErrorMessage("Erro", "Erro ao processar o jogo, tente novamente...");
		}

		return null;
	}
	

	public void editar(RowEditEvent<Jogo> event) {
		try {
			JogoDAO.editar(event.getObject());
			addInfoMessage("Sucesso", "Edição Concluida");
		} catch (Exception e) {
			addErrorMessage("Erro", "Não foi possível alterar, tente novamente...");
		}

	}

	public void cancelar(RowEditEvent<Jogo> event) {
		addInfoMessage("Cancelado", "Tentativa foi cancelada");

	}

	public String excluir(Jogo jogo) {
		try {
			addInfoMessage("Sucesso", "jogo deletado...");
		} catch (Exception e) {
			addErrorMessage("Erro", "não foi possível deletar...");
		}
		JogoDAO.excluir(jogo);
		lista = JogoDAO.listar();
		return null;
	}

	public Jogo getJogo() {
		return jogo;
	}

	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}

	public List<Jogo> getLista() {
		if (lista == null) {
			lista = JogoDAO.listar();
		}
		return lista;
	}

	public void setLista(List<Jogo> lista) {
		this.lista = lista;
	}

}
