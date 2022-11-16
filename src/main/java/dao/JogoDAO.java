package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import entidade.Jogo;
import util.JPAUtil;

public class JogoDAO {
	public static void salvar(Jogo jog) {
		EntityManager em = JPAUtil.criaEntityManager();
		em.getTransaction().begin();
		em.persist(jog);
		em.getTransaction().commit();
		em.close();
	}

	public static void editar(Jogo jog) {
		EntityManager em = JPAUtil.criaEntityManager();
		em.getTransaction().begin();
		em.merge(jog);
		em.getTransaction().commit();
		em.close();
	}

	public static void excluir(Jogo jog) {
		EntityManager em = JPAUtil.criaEntityManager();
		em.getTransaction().begin();
		jog = em.find(Jogo.class, jog.getId());
		em.remove(jog);
		em.getTransaction().commit();
		em.close();

	}

	public static List<Jogo> listar() {
		EntityManager em = JPAUtil.criaEntityManager();
		Query q = em.createQuery("select jogo from Jogo jogo");
		List<Jogo> lista = q.getResultList();
		em.close();
		return lista;
	}
}
