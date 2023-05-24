package br.gov.rj.faetec.estoque.repository.helper.congregacao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import br.gov.rj.faetec.estoque.model.Congregacao;
import br.gov.rj.faetec.estoque.repository.filter.CongregacaoFilter;

public class CongregacoesImpl implements CongregacoesQueries {

	@PersistenceContext
	private EntityManager manager;
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<Congregacao> filtrar(CongregacaoFilter filtro) {
		Criteria criteria = manager.unwrap(Session.class).createCriteria(Congregacao.class);
		
		if (filtro != null) {
			if (!StringUtils.isEmpty(filtro.getEndereco())) {
				criteria.add(Restrictions.ilike("endereco", filtro.getEndereco(), MatchMode.ANYWHERE));
			}
			
			if (!StringUtils.isEmpty(filtro.getNumero())) {
				criteria.add(Restrictions.eq("numero", filtro.getNumero()));

			if (!StringUtils.isEmpty(filtro.getBairro())) {
				criteria.add(Restrictions.ilike("bairro", filtro.getBairro(), MatchMode.ANYWHERE));
				}

			if (!StringUtils.isEmpty(filtro.getCidade())) {
				criteria.add(Restrictions.eq("cidade", filtro.getCidade()));
				}

			if (!StringUtils.isEmpty(filtro.getUf())) {
				criteria.add(Restrictions.eq("uf", filtro.getUf()));
				}

			if (!StringUtils.isEmpty(filtro.getCep())) {
				criteria.add(Restrictions.eq("cep", filtro.getCep()));
				}
			}
			
			return criteria.list();
		}
		return null;
	}
	}
