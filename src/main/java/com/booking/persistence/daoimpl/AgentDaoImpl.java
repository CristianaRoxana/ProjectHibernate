package com.booking.persistence.daoimpl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.booking.persistence.model.Agent;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class AgentDaoImpl {
	private static final Log logger = LogFactory.getLog(AgentDaoImpl.class);


	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public void addAgent(Agent agent) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(agent);
		logger.info("Agent saved successfully, Agent Details=" + agent);
	}

	public void updateAgent(Agent agent) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(agent);
		logger.info("Agent updated successfully, Agent Details=" + agent);
	}

	@SuppressWarnings("unchecked")

	public List<Agent> listAgents() {
		Session session = this.sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		List<Agent> agentiList = session.createQuery("from agent").list();
		for (Agent agent : agentiList) {
			logger.info("Agent List::" + agent);
		}
		return agentiList;
	}

	public Agent getAgentById(int agentID) {
		Session session = this.sessionFactory.getCurrentSession();
		Agent agent = (Agent) session.load(Agent.class, new Integer(agentID));
		logger.info("Agentloaded successfully, Agent details=" + agent);
		return agent;
	}

	public void removeAgent(int agentID) {
		Session session = this.sessionFactory.getCurrentSession();
		Agent agent = (Agent) session.load(Agent.class, new Integer(agentID));
		if (null != agent) {
			session.delete(agent);
		}
		logger.info("Angajat deleted successfully, angajat details=" + agent);
	}
}
