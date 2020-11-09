package repositories;

import java.util.ArrayList;
import model.Question;

public interface RepositoryInterface {
    
    ArrayList<Question> getItems();
    void setItems(ArrayList<Question> items);
    void add(Question item);
    void remove(int id);
    Question getItem(int id);
    
    @Override
    String toString();
    
    void store(String filename);

    
}
