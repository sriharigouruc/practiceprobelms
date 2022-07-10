/**
 * 
 */
package com.sample.project;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * @author SGouru
 *
 */
public class StreamsSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee e1 = new Employee("srihari1", 1l);
		Employee e2 = new Employee("srihari2", 2l);
		Employee e6 = new Employee("srihari3", 2l);
		Employee e3 = new Employee("srihari3", 3l);
		Employee e4 = new Employee("srihari5", 5l);
		Employee e5 = new Employee("srihari4", 4l);
		List<Employee> empList = new ArrayList<Employee>();
		empList.add(e1);
		empList.add(e2);
		empList.add(e3);
		empList.add(e4);
		empList.add(e5);
		empList.add(e6);

		List<Employee> filteredList = empList.stream().distinct().sorted().collect(toList());

		System.out.println(filteredList);

		Comparator<Employee> comparator = (e33, e22) -> {
			return e33.getName().compareTo(e22.getName());
		};

		HashMap map = new HashMap<String, Employee>();
		map.put(null, null);
		map.put(null, e1);

		System.out.println();
	}

}

class Employee implements Comparable {

	public Employee(String name, Long eid) {
		super();
		this.name = name;
		this.eid = eid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getEid() {
		return eid;
	}

	public void setEid(Long eid) {
		this.eid = eid;
	}

	private String name;
	private Long eid;

	@Override
	public int hashCode() {
		return Objects.hash(eid, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Employee other = (Employee) obj;
		return Objects.equals(eid, other.eid) && Objects.equals(name, other.name);
	}

	@Override
	public int compareTo(Object o) {
		if (o == null)
			return -1;
		if (!(o instanceof Employee))
			return -1;
		Employee icObject = (Employee) o;
		if (icObject.getEid() != null && this.eid != null)
			return (icObject).getEid().compareTo(this.eid);

		return 0;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", eid=" + eid + "]";
	}

}