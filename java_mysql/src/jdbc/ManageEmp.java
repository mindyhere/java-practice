package jdbc;

import java.util.List;
import java.util.Scanner;

public class ManageEmp {
	EmpDAO dao = new EmpDAO();

	void delete() {
		Scanner sc = new Scanner(System.in);
		System.out.print("삭제할 사원번호를 입력하세요: ");
		int empno = sc.nextInt();
		int result = dao.delete_emp(empno);
		if (result == 1) {
			System.out.println("삭제되었습니다.");
		} else {
			System.out.println("사원번호를 확인하세요.");
		}
	}

	void insert() {
		Scanner sc = new Scanner(System.in);
		System.out.print("사원번호: ");
		int empno = sc.nextInt();
// nextInt() 다음에 nextLine()를 실행할 경우, nextLine()가 그냥 넘어가버리는 오류발생
// nextLine(): Enter값을 기준으로 메소드를 종료시키기 때문에 nextInt()실행 후 남아있던 Enter값를 그대로 읽어 바로 종료되고 그 다음Line이 출력됨
		System.out.print("이름: ");
		String ename = sc.next();

		System.out.print("직급: ");
		String job = sc.next();

		System.out.print("입사연도: ");
		String hiredate = sc.next();

		System.out.print("연봉: ");
		double sal = sc.nextDouble();

		System.out.print("부서번호: ");
		int deptno = sc.nextInt();

		EmpDTO dto = new EmpDTO(empno, ename, job, hiredate, sal, deptno);
		dao.insert_emp(dto);
		System.out.println("추가되었습니다.");
	}

	void list() {
		List<EmpDTO> items = dao.list_emp();
		System.out.println("사원번호\t이름\t직급\t입사연도\t연봉\t부서번호");
		System.out.println("=======================================");

		for (EmpDTO dto : items) {
			System.out.print(dto.getEmpno() + "\t");
			System.out.print(dto.getEname() + "\t");
			System.out.print(dto.getJob() + "\t");
			System.out.print(dto.getHiredate() + "\t");
			System.out.print(dto.getSal() + "\t");
			System.out.print(dto.getDeptno() + "\n");
		}
	}

	public static void main(String[] args) {
		ManageEmp emp = new ManageEmp();
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("작업을 선택하세요(1:목록 2:추가 3:삭제 0:종료): ");
			int code = sc.nextInt();
			switch (code) {
			case 0:
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
				break;
			case 1:
				emp.list();
				break;
			case 2:
				emp.insert();
				break;
			case 3:
				emp.delete();
				break;
			}
		}
	}
}
