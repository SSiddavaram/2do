package com.todo.listener;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import com.todo.beans.CommonNavigationBean;
import com.todo.util.WebAppUtil;

public class SetSelectedMenuPhaseListener implements PhaseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void afterPhase(PhaseEvent event) {
		CommonNavigationBean commonNavigationBean = (CommonNavigationBean)WebAppUtil.getManagedBean("commonNavigationBean");
		commonNavigationBean.setSelectedMenuOnPageLoad();
	}

	@Override
	public void beforePhase(PhaseEvent event) {
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

}
