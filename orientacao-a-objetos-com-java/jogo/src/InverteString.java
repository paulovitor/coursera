
public class InverteString implements Embaralhador {

	@Override
	public String embaralha(String palavra) {
		return new StringBuffer(palavra).reverse().toString();
	}

	@Override
	public int getDificuldade() {
		return 1;
	}

}
