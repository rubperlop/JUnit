package boletinJUnit;

import java.util.Stack;

public class Pila {
	private Stack<Integer> pila = new Stack<Integer>();
	// A�ade el n�mero solo si es mayor que 2 y menor que 20
	public void push (Integer num) {
		if (num > 2 && num < 20)
			pila.push(num);
	}
	/*
	 Si la pila est� vac�a devolvemos null. Si no, se devuelve el
	 �ltimo n�mero a�adido a la pila sac�ndolo de la pila
	*/
	public Integer pop() {
		if (pila.isEmpty())
			return null;
		else
			return pila.pop();
	}
	//Devuelve true si la pila est� vac�a, false caso contrario
	public boolean isEmpty() {
		return pila.isEmpty();
	}
	/*
	 Si la pila est� vac�a devolvemos null. Si no, se devuelve el
	 primer n�mero a�adido a la pila sin sacarlo
	*/
	public Integer top() {
		if (pila.isEmpty())
			return null;
		else
			return pila.peek();
	}
}
