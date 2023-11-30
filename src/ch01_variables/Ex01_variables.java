package ch01_variables;

public class Ex01_variables {

	public static void main(String[] args) {
		// 본인의 이름(name), 나이(age), 키(height), 주소(address), 전화번호(mobile)
		// 를 입력할 수 있는 변수를 각각 선언해봅시다.
		// 변수 선언
		// String; x 타입만 주면 안됨
		// name = "이름"; x 변수이름만 주면 안됨
		String name = "석재곤";
		int age = 25;
		double height = 175;
		String address = "인천시 미추홀구 도화동";
		String mobile = "010-9018-8437";
		
		// 변수값 출력
		System.out.println(name);
		System.out.println(age);
		System.out.println(height);
		System.out.println(address);
		System.out.println(mobile);
	}

}
