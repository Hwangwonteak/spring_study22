package com.hwt.study016;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TicketController {

	private TicketDao dao;

	@Autowired
	public void setDao(TicketDao dao) {
		this.dao = dao;
	}

	@RequestMapping(value = "/")
	public String buyTicket() {
		
		return "/buy_ticket";
	}
	
	@RequestMapping(value = "/buy_ticket_card")
	public String buy_ticket_card(TicketDto ticketDto, Model model) {
//		TicketDao dao = new TicketDao();
		dao.buy_ticket(ticketDto);
		
		model.addAttribute("ticketInfo", ticketDto);
		
		return "buy_ticket_end";
	}
	
}
