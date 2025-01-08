package chapter02_sub;

class Controller {
	
	Service service;
	
	Controller(Service service){
		this.service = service;
	}
	
	void controllerMethod1() {
		System.out.println("Controller Method 1");
		service.serviceMethod1();
	}
	void controllerMethod2() {
		System.out.println("Controller Method 2");
		service.serviceMethod2();
	}
}

class Service {
	
	IRepository repository;
	
	Service(IRepository repository){
		this.repository = repository;
	}
	
	void serviceMethod1() {
		System.out.println("Service Method 1");
		repository.repositoryMethod1();
	}
	void serviceMethod2() {
		System.out.println("Service Method 2");
		repository.repositoryMethod2();
	}
}

interface IRepository {
	void repositoryMethod1();
	void repositoryMethod2();
}

class Repository implements IRepository {
	public void repositoryMethod1() {
		System.out.println("Repository Method 1");
	}
	public void repositoryMethod2() {
		System.out.println("Repository Method 2");
	}
}

class Repository2 implements IRepository {
	public void repositoryMethod1() {
		System.out.println("Repository Method 2_1");
	}
	public void repositoryMethod2() {
		System.out.println("Repository Method 2_2");
	}
}

public class DIP {

	public static void main(String[] args) {
		
		Repository repository = new Repository();
		Repository2 repository2 = new Repository2();
	
		Service service = new Service(repository2);
		Controller controller = new Controller(service);
		controller.controllerMethod1();

	}

}
