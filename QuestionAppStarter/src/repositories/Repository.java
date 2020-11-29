package repositories;

import daos.DAOImpl;
import java.util.ArrayList;
import java.util.function.Predicate;
import model.Question;


public class Repository implements RepositoryInterface {
    private ArrayList<Question> items;    
    
    public Repository() {
        this.items = new ArrayList<>();       
    }
    
    public Repository(ArrayList<Question> items) {        
        this.items = items;
    }
    
    public Repository(String filename) {
        this();
        DAOImpl dao = new DAOImpl();
        this.items = dao.load(filename).getItems();  
    }
    
    @Override
    public ArrayList<Question> getItems() {        
        return this.items;
    }
    
    @Override
    public void setItems(ArrayList<Question> items) {        
        this.items = items;
    }
    
    @Override
    public void add(Question item) {
        this.items.add(item);
    }
       
    @Override
    public void remove(int id) {
        Predicate<Question> predicate = e->e.getId() == id;       
        this.items.removeIf(predicate);
    }
    
    @Override
    public Question getItem(int id) {
        for (Question item:this.items) {
            if (item.getId() == id)
                return item;
        }
        return null;
    }
    
    @Override
    public String toString() {
        return "\nItems: " + this.items;
    }   
    
    public String toString(char delimiter) {
        String output = "";
        for (Question item: this.items) {
            output += item.toString(delimiter);
        }
        return output;
    }
    
    @Override
    public void store(String filename) {       
        DAOImpl dao = new DAOImpl();
        dao.store(filename, this);    
    }        
}
