package br.com.dock.desafio2.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.dock.desafio2.services.exceptions.DailyWithdrawLimitException;
import br.com.dock.desafio2.services.exceptions.BlockedAccountException;
import br.com.dock.desafio2.services.exceptions.EntityNotFoundException;
import br.com.dock.desafio2.services.exceptions.WithdrawNotAllowedException;

/**
 * Classe responsável por interceptar e controlar 
 * quaisquer exceções que ocorram durante a exucução
 * da API
 * 
 * @author Gabriel Crespo de Souza
 * @version 1.0
 *
 */

@ControllerAdvice
public class ResourceExceptionHandler {
	
	/**
	 * Método responsável por mapear as exceções relacionadas
	 * a entidades não encontradas
	 * 
	 * @param e tipo da exceção a ser mapeada
	 * @param request paramêtro que provê informações sobre requisições HTTP
	 * @return uma entidade de resposta com os dados padrões de exceção da aplicação
	 * 
	 */
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<StandardError> entityNotFound(EntityNotFoundException e, HttpServletRequest request) {
		StandardError err = new StandardError();
		err.setTimestamp(Instant.now());
		err.setStatus(HttpStatus.NOT_FOUND.value());
		err.setError("Resource not found");
		err.setMessage(e.getMessage());
		err.setPath(request.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
	
	/**
	 * Método responsável por mapear as exceções relacionadas
	 * a casos não permitidos durante a operação de saque
	 * 
	 * @param e tipo da exceção a ser mapeada
	 * @param request paramêtro que provê informações sobre requisições HTTP
	 * @return uma entidade de resposta com os dados padrões de exceção da aplicação
	 * 
	 */
	@ExceptionHandler(WithdrawNotAllowedException.class)
	public ResponseEntity<StandardError> withdrawNotAllowed(WithdrawNotAllowedException e, HttpServletRequest request) {
		StandardError err = new StandardError();
		err.setTimestamp(Instant.now());
		err.setStatus(HttpStatus.BAD_REQUEST.value());
		err.setError("Withdraw operation not allowed");
		err.setMessage(e.getMessage());
		err.setPath(request.getRequestURI());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}
	
	/**
	 * Método responsável por mapear as exceções relacionadas
	 * a casos não permitidos com contas bloqueadas
	 * 
	 * @param e tipo da exceção a ser mapeada
	 * @param request paramêtro que provê informações sobre requisições HTTP
	 * @return uma entidade de resposta com os dados padrões de exceção da aplicação
	 * 
	 */
	@ExceptionHandler(BlockedAccountException.class)
	public ResponseEntity<StandardError> blockedAccount(BlockedAccountException e, HttpServletRequest request) {
		StandardError err = new StandardError();
		err.setTimestamp(Instant.now());
		err.setStatus(HttpStatus.BAD_REQUEST.value());
		err.setError("Operation not allowed");
		err.setMessage(e.getMessage());
		err.setPath(request.getRequestURI());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}
	
	/**
	 * Método responsável por mapear as exceções relacionadas
	 * a casos não permitidos com limite de saque diário de uma conta
	 * 
	 * @param e tipo da exceção a ser mapeada
	 * @param request paramêtro que provê informações sobre requisições HTTP
	 * @return uma entidade de resposta com os dados padrões de exceção da aplicação
	 * 
	 */
	@ExceptionHandler(DailyWithdrawLimitException.class)
	public ResponseEntity<StandardError> accountTypeNotFound(DailyWithdrawLimitException e, HttpServletRequest request) {
		StandardError err = new StandardError();
		err.setTimestamp(Instant.now());
		err.setStatus(HttpStatus.BAD_REQUEST.value());
		err.setError("Operation not allowed");
		err.setMessage(e.getMessage());
		err.setPath(request.getRequestURI());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body(err);
	}

}
