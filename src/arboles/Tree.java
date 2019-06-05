/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arboles;

/**
 *
 * @author vsuarezj
 */
public class Tree<T> {
    public class Node{
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }        
    }
    
    private Node root;

    public Tree() {
        this.root = null;
    }
    
    public boolean find(int id){
        Node current = root;
        while(current != null){
            if(id == current.data) return true;
            if(id > current.data) current = current.right;
            else current = current.left;
        }
        return false;
    }
    
    public boolean delete(int id){
        Node parent = root, current = root;
        boolean isLeftChild = false;
        
        if(!find(id)) return false;
        
        while(current.data != id){
            parent = current;
            if(id > current.data){
                isLeftChild = false;
                current = current.right;
            }
            else{
                isLeftChild = true;
                current = current.left;
            }
        }
        
        if(current.left == null && current.right == null){
            if(current == root) root = null;
            if(isLeftChild) parent.left = null;
            else parent.right = null;
        }        
        else if(current.left == null){
            if(current == root) root = current.right;
            else if(isLeftChild) parent.left = current.right;
            else parent.right = current.right;            
        }
        else if(current.right == null){
            if(current == root) root = current.left;
            else if(isLeftChild) parent.left = current.left;
            else parent.right = current.left;  
        }
        else{
            Node sucesor = getSucesor(current);
            if(current == root) root = sucesor;
            else if(isLeftChild) parent.left = sucesor;
            else parent.right = sucesor;
            sucesor.left = current.left;
        }        
        return true;
        
    }
    
    public Node getSucesor(Node n){
        Node sucesor = null, sucesorP = null, current = n.right;
        while(current != null){
            sucesorP = sucesor;
            sucesor = current;
            current = current.left;
        }
        if(sucesor != n.right){
            sucesorP.left = sucesor.right;
            sucesor.right = n.right;
        }
        return sucesor;
    }
    
    
    public void insert(int id){
        Node newNode = new Node(id);
        if(root == null){
            root = newNode; return;
        }
        Node current = root, parent = null;
        while(current != null){
            parent = current;
            if(id > current.data){
                current = current.right;
                if(current == null) parent.right = newNode;
            }
            else{
                current = current.left;
                if(current == null) parent.left = newNode;
            }
        }
    }
    
    public void display(Node r){
        if(r != null){
            display(r.left);
            System.out.print(" " + r.data);
            display(r.right);
        }
    }
    
    public Node getRoot(){
        return root;
    }
    
    public void setRoot(Node root){
        this.root = root;
    }
    
}
