package com.cliente.surittec.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.cliente.surittec.dto.ClienteNewDTO;
import com.cliente.surittec.resources.exceptions.FieldMessage;
import com.cliente.surittec.services.validation.utils.Helper;

public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDTO> {
	 
	@Override
	 public void initialize(ClienteInsert ann) {
	 }
	 
	 @Override
	 public boolean isValid(ClienteNewDTO objDto, ConstraintValidatorContext context) {
		 List<FieldMessage> list = new ArrayList<>();
		
		 // inclua os testes aqui, inserindo erros na lista
		 
		 if (!Helper.isCPF(objDto.getCpf())) {
			 list.add(new FieldMessage("cpf", "CPF Inválido"));
		 }
		
		 for (FieldMessage e : list) {
			 context.disableDefaultConstraintViolation();
			 context.buildConstraintViolationWithTemplate(e.getMessage())
			 .addPropertyNode(e.getFieldName()).addConstraintViolation();
		 }
		 
		 return list.isEmpty();
	 }
	 
	
}