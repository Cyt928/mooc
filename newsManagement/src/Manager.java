import java.util.ArrayList;
import java.util.List;

public class Manager extends Worker {

	private List<Worker> worker;

	public Manager() {

	}
	//Manager类的初始化
	public Manager(String name, int age, int salary, String department) {
        if (age < 18 || salary < 2000) {
            String message = "age must be greater than 18 and salary must be greater than 2000.";
            throw new IllegalArgumentException(message);
        }
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.department = department;
	}

	// 管理人员可以查询本部门员工的基本信息，跨部门查询提示权限不足，提示“Access Denied!”
	public String inquire(Worker e) {
		if(e.getDepartment().equals(this.department)){
		    return e.show();
        }else{
		    throw new IllegalArgumentException("Access Denied!");
        }
	}

	// 管理人员给自己的队伍添加工作人员，同一部门的工作人员可以添加，并返回true，不同部门的工作人员无法添加，返回false
	public boolean lead(Worker e) {
	    if(e.getDepartment().equals(this.department)){
	        worker.add(e);
	        return true;
        }else {
            return false;
        }
	}

	// 打印自己队伍的人员姓名，没有打印“Empty”
	public String print() {
		String str="Statement for "+this.name+"\n";
		for(Worker temp : worker ){
		    str=str+" - "+temp.getName()+"\n";
        }
        return str;
	}

}
