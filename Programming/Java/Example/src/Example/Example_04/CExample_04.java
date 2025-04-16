package Example.Example_04;

/*
 * 인터페이스 (Interface) 란?
 * - 대상 간에 상호 작용을 할 수 있는 수단을 의미하며 프로그래밍 언어에서 Java 에서 인터페이스는 메서드의 목록을
 * 의미한다. (+ 즉, 메서드를 통해 객체 간에 서로 상호 작용이 가능하다는 것을 알 수 있다.)
 *
 * 인터페이스는 단순히 메서드의 목록이기 때문에 인터페이스 내부에 선언되는 메서드는 구현부를 지니고 있지 않은
 * 추상 메서드를 선언하는 것이 일반적이다. (+ 즉, 특수한 경우를 제외하고는 일반적인 메서드는 인터페이스 내부에
 * 구현하지 않는다는 것을 알 수 있다.)
 *
 * Java 인터페이스 선언 방법
 * - interface + 인터페이스 이름 + 메서드 목록
 *
 * Ex)
 * interface ISomeInterface {
 * 		public void someMethod();
 * }
 *
 * class CSomeClass implements ISomeInterface {
 * 		public void someMethod() {
 * 			// Do Something
 * 		}
 * }
 *
 * ISomeInterface oSomeInterface = new CSomeClass();
 * oSomeInterface.someMethod();
 *
 * 위와 같이 인터페이스에도 다형성의 규칙이 성립하기 때문에 특정 클래스가 인터페이스를 구현하고 있다면
 * 해당 클래스를 통해 생성 된 객체를 인터페이스 변수로 참조하는 것이 가능하다.
 *
 * 클래스는 implements 키워드를 통해 특정 인터페이스를 상속하는 것이 가능하며 이때 인터페이스는 상속한다는 용어보다
 * 따른다 or 구현한다 는 용어를 사용한다.
 *
 * 특정 인터페이스를 구현하고 있는 클래스는 반드시 해당 인터페이스 내부에 존재하는 추상 메서드를 구현해야되며
 * 만약 구현하지 않을 경우 해당 클래스는 객체화가 불가능한 추상 클래스가 된다.
 *
 * 또한 인터페이스는 클래스와 구분하기 위해서 I 접두어를 사용하는 것이 일반적인 관례이며 클래스와 달리
 * 다중 구현을 지원한다. (+ 즉, 특정 클래스가 여러 인터페이스를 구현하는 것이 가능하다.)
 */

import java.util.Random;

/**
 * Example 4 (인터페이스)
 */
public class CExample_04 {
	/** 초기화 */
	public static void start(String[] args) {
		IWriter oWriter = createWriter();
		
		for(int i = 0; i < 10; ++i) {
			oWriter.writeStr(String.format("%d", i + 1));
		}
	}
	
	/** 출력자를 생성한다 */
	private static IWriter createWriter() {
		Random oRandom = new Random();
		
		return (oRandom.nextInt(0, 2) <= 0) ?
				new CWriter_Console() : new CWriter_File("P_E01Example_04_01.txt");
	}
}
