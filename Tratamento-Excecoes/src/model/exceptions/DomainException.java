package model.exceptions;

public class DomainException extends Exception{

	private static final long serialVersionUID = 1L;
	
	//permite instanciar a classe de execao e passando a msg, fica armazenada na execao
	public DomainException(String msg) {
		super(msg);
	}

}
