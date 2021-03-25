
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author compu
 */
public class Stack{
   
    private int stackpointer = -1;                                                      //Stack consists of a stackpointer to keep track of the position of pages
    private ArrayList<String> stack = new ArrayList<>();                                //Stack consists of an array list to store the data
    
    public Stack(){                                                                     //Initially on creation of the product the main menu will show
        pushPage("Main Menu");                                                          //Putting this here as it needs to be called AFTER the stack is
    }                                                                                   //initialised, this happens after the init is called
    
    
    private boolean checkNext(){
        if(stack.isEmpty()){
            return false;
        }
        else if(stack.size()-1 == stackpointer){
            return false;
        }
        else{
            return true;
        }
    }
   
    private boolean checkPrev(){
        if(stackpointer == 0){
            return false;
        }
        else{
            return true;
        }
    }
   
    public String nextPage(){;
        if(checkNext()){
            stackpointer += 1;
            String page = stack.get(stackpointer);
            return page;
        }
        else{
            return "NoPage";
        }
    }
   
    public String prevPage(){
        if(checkPrev()){
            stackpointer -= 1;
            String page = stack.get(stackpointer);
            return page;
        }
        else{
            return "NoPage";
        }
    }
   
    private void removeNextPages(){
        if(checkNext()){
            stack.subList(stackpointer+1, stack.size()).clear();
        }
    }
   
    public void pushPage(String page){
        removeNextPages();
        stack.add(page);
        stackpointer += 1;
    }
   
    public String currentPage(){;
        String page = stack.get(stackpointer);
        return page;
    }
    
    public boolean stateFowardButton(){
        if(stackpointer==stack.size()-2){
            return false;
        }
        else{
            return true;
        }
    }
    
    public boolean stateBackButton(){
        if(stackpointer==1){
            return false;
        }
        else{
            return true;
        }
    }
}