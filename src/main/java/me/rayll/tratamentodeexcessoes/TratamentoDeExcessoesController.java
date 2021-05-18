package me.rayll.tratamentodeexcessoes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratamentoDeExcessoesController {
	
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public List<String> tratarExcessaoDeArgumentos(MethodArgumentNotValidException ex) {
		
		List<String> listaDeErros = new ArrayList<>();
		
		for(ObjectError error : ex.getAllErrors()) {
			String field = ((FieldError) error).getField();
			String defaultErrorMessage = error.getDefaultMessage();
			
			listaDeErros.add(field + ": " + defaultErrorMessage);
		}
		return listaDeErros;
	}
	
}
