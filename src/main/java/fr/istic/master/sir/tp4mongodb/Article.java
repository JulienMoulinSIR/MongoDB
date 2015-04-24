package fr.istic.master.sir.tp4mongodb;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import com.google.code.morphia.annotations.Reference;

@Entity 
public class Article
{
	@Id private ObjectId id;
	private String name;
	private int stars;
	@Reference private List<Person> buyers;

	public Article(){
		super();
	}

	public ObjectId getId() {
		return this.id;	
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}
	
	public void addAllBuyers(List<Person> newBuyers) {
		if (this.buyers == null) {
			this.buyers = new ArrayList<Person>();
		}
		this.buyers.addAll(newBuyers);	
	}
	
	public void removeAllBuyers(List<Person> newBuyers) {
		if(this.buyers == null) {
			return;
		}
		
		this.buyers.removeAll(newBuyers);	
	}
	
	public void setId(ObjectId id) {
		this.id = id;	
	}
	
	public void addBuyers(Person newBuyers) {
		if(this.buyers == null) {
			this.buyers = new ArrayList<Person>();
		}
		
		this.buyers.add(newBuyers);	
	}
	
	public void removeBuyers(Person oldBuyers) {
		if(this.buyers == null)
			return;
		
		this.buyers.remove(oldBuyers);	
	}

	public void setBuyers(List<Person> buyers) {
		this.buyers = buyers;
	}
	
	public List<Person> getBuyers() {
		if(this.buyers == null) {
				this.buyers = new ArrayList<Person>();
		}
		return (List<Person>) this.buyers;	
	}
	
	@Override
	public String toString() {
		String str = "Article [id=" + id + ", name="+ name +", stars="+ stars + "/5, Buyers=\n";
		for(Person p : buyers)
			str+=p.toString()+"\n";
		return  str + "]\n";
	}
}

