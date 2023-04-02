package com.travelease.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(BusNotFoundException.class)
	public ResponseEntity<ExceptionDTO> tutorialExceptionHandler(BusNotFoundException e, WebRequest wr){
		
		ExceptionDTO err=new ExceptionDTO();
		err.setDateAndTime(LocalDateTime.now());
		err.setMessage(e.getMessage());
		err.setDesc(wr.getDescription(false));
		
		return new ResponseEntity<ExceptionDTO>(err, HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(BookingException.class)
	public ResponseEntity<ExceptionDTO> tutorialExceptionHandler(BookingException e, WebRequest wr){
		
		ExceptionDTO err=new ExceptionDTO();
		err.setDateAndTime(LocalDateTime.now());
		err.setMessage(e.getMessage());
		err.setDesc(wr.getDescription(false));
		
		return new ResponseEntity<ExceptionDTO>(err, HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(PaymentException.class)
	public ResponseEntity<ExceptionDTO> tutorialExceptionHandler(PaymentException e, WebRequest wr){
		
		ExceptionDTO err=new ExceptionDTO();
		err.setDateAndTime(LocalDateTime.now());
		err.setMessage(e.getMessage());
		err.setDesc(wr.getDescription(false));
		
		return new ResponseEntity<ExceptionDTO>(err, HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(CustomerException.class)
	public ResponseEntity<ExceptionDTO> tutorialExceptionHandler(CustomerException e, WebRequest wr){
		
		ExceptionDTO err=new ExceptionDTO();
		err.setDateAndTime(LocalDateTime.now());
		err.setMessage(e.getMessage());
		err.setDesc(wr.getDescription(false));
		
		return new ResponseEntity<ExceptionDTO>(err, HttpStatus.BAD_REQUEST);
		
	}

	
	
	
	
	@ExceptionHandler(HotelException.class)
	public ResponseEntity<ExceptionDTO> tutorialExceptionHandler(HotelException e, WebRequest wr){
		
		ExceptionDTO err=new ExceptionDTO();
		err.setDateAndTime(LocalDateTime.now());
		err.setMessage(e.getMessage());
		err.setDesc(wr.getDescription(false));
		
		return new ResponseEntity<ExceptionDTO>(err, HttpStatus.BAD_REQUEST);
		
	}
	
	
	@ExceptionHandler(LoginException.class)
	public ResponseEntity<ExceptionDTO> tutorialExceptionHandler(LoginException e, WebRequest wr){
		
		ExceptionDTO err=new ExceptionDTO();
		err.setDateAndTime(LocalDateTime.now());
		err.setMessage(e.getMessage());
		err.setDesc(wr.getDescription(false));
		
		return new ResponseEntity<ExceptionDTO>(err, HttpStatus.BAD_REQUEST);
		
	}
	
	
	@ExceptionHandler(PackagesException.class)
	public ResponseEntity<ExceptionDTO> tutorialExceptionHandler(PackagesException e, WebRequest wr){
		
		ExceptionDTO err=new ExceptionDTO();
		err.setDateAndTime(LocalDateTime.now());
		err.setMessage(e.getMessage());
		err.setDesc(wr.getDescription(false));
		
		return new ResponseEntity<ExceptionDTO>(err, HttpStatus.BAD_REQUEST);
		
	}
	
	
	@ExceptionHandler(RouteAlreadyExistsException.class)
	public ResponseEntity<ExceptionDTO> tutorialExceptionHandler(RouteAlreadyExistsException e, WebRequest wr){
		
		ExceptionDTO err=new ExceptionDTO();
		err.setDateAndTime(LocalDateTime.now());
		err.setMessage(e.getMessage());
		err.setDesc(wr.getDescription(false));
		
		return new ResponseEntity<ExceptionDTO>(err, HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(RouteNotFoundException.class)
	public ResponseEntity<ExceptionDTO> tutorialExceptionHandler(RouteNotFoundException e, WebRequest wr){
		
		ExceptionDTO err=new ExceptionDTO();
		err.setDateAndTime(LocalDateTime.now());
		err.setMessage(e.getMessage());
		err.setDesc(wr.getDescription(false));
		
		return new ResponseEntity<ExceptionDTO>(err, HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(TravelsAlreadyExistsException.class)
	public ResponseEntity<ExceptionDTO> tutorialExceptionHandler(TravelsAlreadyExistsException e, WebRequest wr){
		
		ExceptionDTO err=new ExceptionDTO();
		err.setDateAndTime(LocalDateTime.now());
		err.setMessage(e.getMessage());
		err.setDesc(wr.getDescription(false));
		
		return new ResponseEntity<ExceptionDTO>(err, HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(TravelsNotFoundException.class)
	public ResponseEntity<ExceptionDTO> tutorialExceptionHandler(TravelsNotFoundException e, WebRequest wr){
		
		ExceptionDTO err=new ExceptionDTO();
		err.setDateAndTime(LocalDateTime.now());
		err.setMessage(e.getMessage());
		err.setDesc(wr.getDescription(false));
		
		return new ResponseEntity<ExceptionDTO>(err, HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ExceptionDTO> validationExceptionHandler(MethodArgumentNotValidException e){
		
		ExceptionDTO err=new ExceptionDTO();
		err.setDateAndTime(LocalDateTime.now());
		err.setMessage(e.getMessage());
		err.setDesc(e.getBindingResult().getFieldError().getDefaultMessage());
		
		return new ResponseEntity<ExceptionDTO>(err, HttpStatus.BAD_REQUEST);
		
	}
	
	
	
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<ExceptionDTO> nullPointerExceptionHandler(NullPointerException e, WebRequest wr){
		
		ExceptionDTO err=new ExceptionDTO();
		err.setDateAndTime(LocalDateTime.now());
		err.setMessage(e.getMessage());
		err.setDesc(wr.getDescription(false));
		
		return new ResponseEntity<ExceptionDTO>(err, HttpStatus.BAD_REQUEST);
		
	}
	
	
	
	
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<ExceptionDTO> noHandlerFoundException(NoHandlerFoundException e, WebRequest wr){
		
		ExceptionDTO err=new ExceptionDTO();
		err.setDateAndTime(LocalDateTime.now());
		err.setMessage(e.getMessage());
		err.setDesc(wr.getDescription(false));
		
		return new ResponseEntity<ExceptionDTO>(err, HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionDTO> masterExceptionHandler(Exception e, WebRequest wr){
		
		ExceptionDTO err=new ExceptionDTO();
		err.setDateAndTime(LocalDateTime.now());
		err.setMessage(e.getMessage());
		err.setDesc(wr.getDescription(false));
		
		return new ResponseEntity<ExceptionDTO>(err, HttpStatus.BAD_REQUEST);
		
	}

}
