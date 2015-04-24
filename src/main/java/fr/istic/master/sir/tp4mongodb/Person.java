package fr.istic.master.sir.tp4mongodb;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;

import com.google.code.morphia.annotations.Embedded;
import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;

@Entity
public class Person
{

	@Id private ObjectId id;
	private String name;
	@Embedded private List<Address> address;

	public Person(){
		super();
	}

	public ObjectId getId() {
		return this.id;	
	}

	public List<Address> getAddress() {
		if(this.address == null) {
			this.address = new ArrayList<Address>();
		}
		return (List<Address>) this.address;	
	}

	public void addAllAddress(List<Address> newAddress) {
		if (this.address == null) {
			this.address = new ArrayList<Address>();
		}
		this.address.addAll(newAddress);	
	}

	public void removeAllAddress(List<Address> newAddress) {
		if(this.address == null) {
			return;
		}
		
		this.address.removeAll(newAddress);	
	}

	public void setId(ObjectId id) {
		this.id = id;	
	}

	public void addAddress(Address newAddress) {
		if(this.address == null) {
			this.address = new ArrayList<Address>();
		}
		
		this.address.add(newAddress);	
	}

	public void removeAddress(Address oldAddress) {
		if(this.address == null)
			return;
		
		this.address.remove(oldAddress);	
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return  "Person [id=" + id + ", name="+ name +", Address=\n"+ address + "]";
	}
}

