package com.projeto.brewer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.projeto.brewer.model.Cerveja;

@Controller
public class CervejasController {
	
	private static final Logger logger = LoggerFactory.getLogger(CervejasController.class);

	@RequestMapping("/cadastro/novo")
	public String novo(Cerveja cerveja) {
		
		logger.error("Aqui e um log de erro");
		
		return "usuario/CadastroUsuario";
	}
	
	@RequestMapping(value = "/cadastro/novo", method = RequestMethod.POST)
	public String cadastrar(@Validated Cerveja cerveja, BindingResult result, Model model, RedirectAttributes attributes) {
		if(result.hasErrors()){
			
			return novo(cerveja);
			
		}
		attributes.addFlashAttribute("mensagem", "Cerveja salva com sucesso");
		System.out.println(">>> sku: " + cerveja.getSku());
		return "redirect:/cadastro/novo";
	}
	
}