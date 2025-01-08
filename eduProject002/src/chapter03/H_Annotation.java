package chapter03;

// 어노테이션: 코드에 메타데이터를 추가하는 방법
// 툴 또는 프레임워크에 특정 코드를 어떻게 해석해야하는지에 대한 정보를 제공해줌
// 컴파일러에게 코드 작성의 의도를 알릴 수 있음
// 실행 시 특정 코드가 어떻게 동작하는지 지정할 수 있음

// 기본적인 어노테이션
// @Override: 지정한 메소드가 상위 클래스의 메소드를 오버라이드 하는 메소드임을 컴파일러에게 알려주는 어노테이션
// @Deprecated: 지정한 메소드가 더 이상 사용되지 않음을 명시
// @SuppressWarnings: 컴파일 경고를 무시하도록 함

class Over {
	void method() {
		
	}
}

// 커스텀 어노테이션: @interface를 이용하여 어노테이션을 직접 생성할 수 있다
@interface CustomAnnotation {
	String value() default "";
}

@CustomAnnotation(value="Hello")

public class H_Annotation extends Over {
	@Override
	void method() {}

	/** 문서화 작업할 때 사용하는 스킬
	 * @param arg
	 */
	@Deprecated
	static void deprecatedMethod() {}
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		int variable; 
		deprecatedMethod();

	}

}
