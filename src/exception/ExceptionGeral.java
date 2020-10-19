package exception;

public class ExceptionGeral extends Exception{
  
	public ExceptionGeral(String mensagem) {
    	throw new UnsupportedOperationException(mensagem);
    }
}
