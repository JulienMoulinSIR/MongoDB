package fr.istic.master.sir.tp4mongodb;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.mongodb.Mongo;

public class App 
{
	
	
    @SuppressWarnings("deprecation")
	public static void main( String[] args ) throws UnknownHostException
    {
    	
    	
    	Morphia morphia = new Morphia();	
    	Mongo mongo = new Mongo();
    	morphia.map(Article.class).map(Person.class).map(Address.class);
    	Datastore ds = morphia.createDatastore(mongo, "my_database");
    	
    	List<Article> articles = new ArrayList<Article>();
    	int i; int nb;
    	
    	//generate Articles
    	nb = 10;
    	for(i=0;i<nb;i++){
    		Article a = new Article();
    		a.setName("article_"+i);
    		a.setStars(new Random().nextInt(5));
    		articles.add(a);
    		a = null;
    	}
    	
    	//generate Persons
    	for(Article a : articles){
    		nb = new Random().nextInt(20);
    		for(i=0;i<nb;i++){
        		Person p = new Person();
        		p.setName("person_"+i);
        		a.addBuyers(p);;
        		p = null;
        	}
    	}
    	
    	//generate Address
    	for(Article a : articles){
    		for(Person p : a.getBuyers()){
    			nb = new Random().nextInt(3) + 1;
        		for(i=0;i<nb;i++){
            		Address ad = new Address();
            		ad.setStreet(i+" Some street");
                	ad.setCity("Some city_"+i);
                	ad.setPostCode("123 456");
                	ad.setCountry("Some country_"+i);
                	p.addAddress(ad);
            		ad = null;
        		}
    		}
    	}
    	
    	//save the POJO
    	for(Article a : articles){
    		for(Person p : a.getBuyers())
				ds.save(p);
    		ds.save(a);
    	}
    	
    	//print db.<collection>.find()
    	for (Article a : ds.find(Article.class))
    		 System.err.println(a.toString());
    }
}
